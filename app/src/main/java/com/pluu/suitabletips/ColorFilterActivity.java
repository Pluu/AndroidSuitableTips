package com.pluu.suitabletips;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

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

	private final Random r = new Random(System.currentTimeMillis());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_filter);
		ButterKnife.bind(this);

		switch1.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			int color = Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255));
			textView.setTextColor(color);
			imageView.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
		} else {
			int defaultColor = getResources().getColor(R.color.secondary_text);
			textView.setTextColor(defaultColor);
			imageView.clearColorFilter();
		}

	}

}
