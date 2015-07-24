package com.pluu.suitabletips.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import com.pluu.suitabletips.R;

/**
 * Created by nohhs on 2015-07-24.
 */
public class TintAdapter extends RecyclerView.Adapter<TintAdapter.TintViewHolder> {

	private final List<ColorItem> list;

	public TintAdapter(List<ColorItem> list) {this.list = list;}

	@Override
	public TintViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext())
									  .inflate(R.layout.layout_list_tint_item, parent, false);
		return new TintViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(TintViewHolder holder, int position) {
		ColorItem item = list.get(position);
		holder.img.setColorFilter(item.filter);
	}

	@Override
	public int getItemCount() {
		return list != null ? list.size() : 0;
	}

	public final static class TintViewHolder extends RecyclerView.ViewHolder {
		public final ImageView img;

		public TintViewHolder(View itemView) {
			super(itemView);
			img = (ImageView) itemView.findViewById(R.id.imageView);
		}
	}
}
