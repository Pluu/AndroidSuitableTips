package com.pluu.suitabletips;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ColorFilterActivity extends AppCompatActivity
	implements CompoundButton.OnCheckedChangeListener {

	@Bind(R.id.switch1)
	SwitchCompat switch1;
	@Bind(R.id.textView)
	TextView textView;
	@Bind(R.id.imageView)
	ImageView imageView;

	private int filterColor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_filter);
		ButterKnife.bind(this);

		filterColor = Color.parseColor("#0D47A1");
		switch1.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			textView.setTextColor(filterColor);
			imageView.setColorFilter(filterColor, PorterDuff.Mode.MULTIPLY);
		} else {
			int defaultColor = getResources().getColor(R.color.secondary_text);
			textView.setTextColor(defaultColor);
			imageView.clearColorFilter();
		}

	}

}
