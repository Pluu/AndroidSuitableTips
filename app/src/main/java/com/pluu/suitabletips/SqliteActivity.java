package com.pluu.suitabletips;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.pluu.suitabletips.db.TestDatabase;
import com.pluu.suitabletips.dialog.TimerDialog;

public class SqliteActivity extends AppCompatActivity {

	private final String TAG = SqliteActivity.class.getSimpleName();

	@Bind(android.R.id.list)
	ListView listView;

	private TestDatabase mOpenHelper;

	private List<String> list;

	private final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:SSS");
	private ArrayAdapter<String> adapter;
	private TimerDialog dlg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite);
		ButterKnife.bind(this);

		mOpenHelper = new TestDatabase(this);

		list = new ArrayList<>();
		adapter = new ArrayAdapter<>(this,
									 android.R.layout.simple_list_item_1,
									 list);
		listView.setAdapter(adapter);
		dlg = new TimerDialog(this);
		dlg.setCancelable(false);
	}

	@OnClick({R.id.button, R.id.button2})
	public void onInsertClick(View view) {
		mOpenHelper.remove();
		new TestTask(view.getId() == R.id.button2).execute();
	}

	private String getCurrentTime() {
		return format.format(new Date());
	}

	private void addListLog(String log) {
		list.add(0, getCurrentTime() + " > " + log);
		adapter.notifyDataSetChanged();
	}

	private class TestTask extends AsyncTask<Void, Void, Void> {

		private final boolean isTransaction;

		private TestTask(boolean isTransaction) {this.isTransaction = isTransaction;}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dlg.show();
			addListLog(isTransaction ? "Transaction On" : "Transaction Off");
			addListLog("Start");
		}

		@Override
		protected Void doInBackground(Void... params) {
			SQLiteDatabase db = mOpenHelper.getWritableDatabase();
			if (isTransaction) {
				db.beginTransaction();
			}

			try {
				ContentValues value;
				for (int i = 0; i < 10000; i++) {
					value = new ContentValues();
					value.put(TestDatabase.SessionColumns.SESSION_ID,
							  "SessionID_" + String.valueOf(i));
					value.put(TestDatabase.SessionColumns.BODY, "Body_" + String.valueOf(i));
					db.insert(TestDatabase.Tables.SESSION, null, value);
				}

				if (isTransaction) {
					db.setTransactionSuccessful();
				}
			} finally {
				if (isTransaction) {
					db.endTransaction();
				}
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);
			addListLog("End");
			dlg.dismiss();
		}
	}

}
