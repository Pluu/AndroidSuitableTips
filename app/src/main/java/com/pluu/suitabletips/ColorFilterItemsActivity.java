package com.pluu.suitabletips;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.pluu.suitabletips.adapter.item.ColorItem;
import com.pluu.suitabletips.adapter.PorterDuffAdapter;
import com.pluu.suitabletips.adapter.TintAdapter;

public class ColorFilterItemsActivity extends AppCompatActivity
	implements AdapterView.OnItemSelectedListener {

	@Bind(R.id.tintRecyclerView)
	RecyclerView tintRecyclerView;
	@Bind(R.id.mode)
	Spinner modeSpinner;

	private PorterDuffAdapter modeAdapter;
	private PorterDuff.Mode selectMode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_filter_items);
		ButterKnife.bind(this);

		modeAdapter = new PorterDuffAdapter(PorterDuff.Mode.values());
		modeSpinner.setAdapter(modeAdapter);
		modeSpinner.setSelection(PorterDuff.Mode.MULTIPLY.ordinal());
		modeSpinner.setOnItemSelectedListener(this);

		tintRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
	}

	@OnClick(R.id.filter)
	public void onRefreshClick() {
		refreshAdapter(selectMode);
	}

	private void refreshAdapter(PorterDuff.Mode mode) {
		final int LIST_SIZE = 100;
		List<ColorItem> list = new ArrayList<>(LIST_SIZE);
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < LIST_SIZE; i++) {
			list.add(new ColorItem(Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
								   mode));
		}
		tintRecyclerView.setAdapter(new TintAdapter(list));
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		selectMode = modeAdapter.getItem(position);
		refreshAdapter(selectMode);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) { }

}
