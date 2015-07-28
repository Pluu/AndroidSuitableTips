package com.pluu.suitabletips;

import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.pluu.suitabletips.adapter.LightingColorFilterAdapter;
import com.pluu.suitabletips.adapter.item.LightingItem;

public class LightingColorFilterActivity extends AppCompatActivity {

	@Bind(R.id.tintRecyclerView)
	RecyclerView recyclerView;

	private LightingColorFilterAdapter lightingAdapter;
	private final Random r = new Random(System.currentTimeMillis());

	private final int LIST_SIZE = 100;
	private final List<LightingItem> list = new ArrayList<>(LIST_SIZE);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lighting_color_filter);
		ButterKnife.bind(this);

		recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
		refreshAdapter(PorterDuff.Mode.MULTIPLY);
	}

	@OnClick(R.id.filter)
	public void onRefreshClick() {
		for (LightingItem item : list) {
			int mul = Color.rgb(r.nextInt(255),
								r.nextInt(255),
								r.nextInt(255));
			int add = Color.rgb(r.nextInt(255),
								r.nextInt(255),
								r.nextInt(255));
			item.setLightingFilter(new LightingColorFilter(mul, add));
		}
		lightingAdapter.notifyDataSetChanged();
	}

	@OnClick(R.id.clear)
	public void onClearClick() {
		for (LightingItem item : list) {
			item.lightingFilter = null;
		}
		lightingAdapter.notifyDataSetChanged();
	}

	private void refreshAdapter(PorterDuff.Mode mode) {
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < LIST_SIZE; i++) {
			list.add(new LightingItem(Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
									  mode));
		}
		lightingAdapter = new LightingColorFilterAdapter(list);
		recyclerView.setAdapter(lightingAdapter);
	}

}
