package com.pluu.suitabletips.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by nohhs on 2015-07-29.
 */
public class TestDatabase extends SQLiteOpenHelper {

	private static final String TAG = TestDatabase.class.getSimpleName();

	private static final String DATABASE_NAME = "test.db";
	private static final int CUR_DATABASE_VERSION = 1;

	public interface Tables {
		String SESSION = "blocks";
	}

	public interface SessionColumns {
		String SESSION_ID = "session_id";
		String BODY = "body";
	}

	public TestDatabase(Context context) {
		super(context, DATABASE_NAME, null, CUR_DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + Tables.SESSION + " ("
					   + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
					   + SessionColumns.SESSION_ID + " TEXT NOT NULL,"
					   + SessionColumns.BODY + " TEXT NOT NULL, "
					   + "UNIQUE (" + SessionColumns.SESSION_ID + ") ON CONFLICT REPLACE)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

	public void remove() {
		SQLiteDatabase db = getWritableDatabase();
		db.delete(Tables.SESSION, null, null);
	}
}
