package com.pluu.suitabletips;

import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.pluu.suitabletips.adapter.LightingColorFilterAdapter;
import com.pluu.suitabletips.adapter.item.LightingItem;

public class LightingColorFilterActivity extends AppCompatActivity
	implements CompoundButton.OnCheckedChangeListener {

	@Bind(R.id.tintRecyclerView)
	RecyclerView recyclerView;
	@Bind(R.id.switch1)
	SwitchCompat switch1;

	private LightingColorFilterAdapter lightingAdapter;
	private final Random r = new Random(System.currentTimeMillis());

	private final int LIST_SIZE = 100;
	private final List<LightingItem> list = new ArrayList<>(LIST_SIZE);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lighting_color_filter);
		ButterKnife.bind(this);

		switch1.setChecked(false);
		switch1.setOnCheckedChangeListener(this);

		recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
		refreshAdapter();
	}

	private void refreshAdapter() {
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < LIST_SIZE; i++) {
			int mul = Color.rgb(r.nextInt(255),
								r.nextInt(255),
								r.nextInt(255));
			int add = Color.rgb(r.nextInt(255),
								r.nextInt(255),
								r.nextInt(255));

			list.add(new LightingItem(
				Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
				PorterDuff.Mode.MULTIPLY,
				new LightingColorFilter(mul, add)));
		}
		lightingAdapter = new LightingColorFilterAdapter(list);
		recyclerView.setAdapter(lightingAdapter);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		lightingAdapter.setLightingFilter(isChecked);
		lightingAdapter.notifyDataSetChanged();
	}
}
