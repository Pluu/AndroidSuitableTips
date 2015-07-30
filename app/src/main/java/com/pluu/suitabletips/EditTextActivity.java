package com.pluu.suitabletips;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class EditTextActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_text);

		EditText text = (EditText) findViewById(R.id.editText2);
		text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_SEARCH) {
					alertDialog("Click Search Action");
				}
				return false;
			}
		});
	}

	private void alertDialog(CharSequence msg) {
		new AlertDialog.Builder(this)
			.setMessage(msg)
			.setPositiveButton(android.R.string.ok, null)
			.show();
	}

}
