package com.pluu.suitabletips;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InsetDrawableActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inset_drawable);
		ButterKnife.bind(this);
	}

	@OnClick({R.id.textView, R.id.textView2})
	public void onTextViewClick(TextView view) {
		new AlertDialog.Builder(this)
			.setMessage(view.getText() + " Click")
			.setPositiveButton(android.R.string.ok, null)
			.show();
	}
}
