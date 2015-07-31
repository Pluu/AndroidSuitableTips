package com.pluu.suitabletips.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.pluu.suitabletips.R;

/**
 * Created by nohhs on 2015-07-30.
 */
public class TimerDialog extends AlertDialog {

	@Bind(R.id.textView)
	TextView timeText;

	private final Handler handler = new Handler();
	private long startTime, diffTime;
	private long minute, sec;
	private final String format = "%02d:%02d:%03d";

	public TimerDialog(Context context) {
		super(context);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_timer);
		ButterKnife.bind(this);
	}

	@Override
	public void show() {
		super.show();
		startTime = SystemClock.uptimeMillis();
		handler.post(updateTimer);
	}

	@Override
	public void dismiss() {
		handler.removeCallbacks(updateTimer);
		Toast.makeText(getContext(), timeText.getText(), Toast.LENGTH_SHORT).show();
		super.dismiss();
	}

	private String getDiffTime() {
		diffTime = SystemClock.uptimeMillis() - startTime;
		minute = TimeUnit.MINUTES.convert(diffTime, TimeUnit.MILLISECONDS);
		diffTime -= TimeUnit.MILLISECONDS.convert(minute, TimeUnit.MINUTES);
		sec = TimeUnit.SECONDS.convert(diffTime, TimeUnit.MILLISECONDS);
		diffTime -= TimeUnit.MILLISECONDS.convert(sec, TimeUnit.SECONDS);
		return String.format(format, minute, sec, diffTime);
	}

	private final Runnable updateTimer = new Runnable() {
		@Override
		public void run() {
			timeText.setText(getDiffTime());
			handler.post(updateTimer);
		}
	};

}
