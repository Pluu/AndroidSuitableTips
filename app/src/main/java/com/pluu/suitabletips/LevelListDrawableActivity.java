package com.pluu.suitabletips;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LevelListDrawableActivity extends AppCompatActivity {

	@Bind(R.id.imageView2)
	ImageView imageView2;
	@Bind(R.id.imageView3)
	ImageView imageView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level_list_drawable);
		ButterKnife.bind(this);

		imageView2.setImageLevel(8);
		imageView3.setImageLevel(10);

	}

}
