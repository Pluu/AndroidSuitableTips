package com.pluu.suitabletips.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import com.pluu.suitabletips.R;
import com.pluu.suitabletips.adapter.item.LightingItem;

/**
 * Created by nohhs on 2015-07-24.
 */
public class LightingColorFilterAdapter extends RecyclerView.Adapter<LightingColorFilterAdapter.ViewHolder> {

	private final List<LightingItem> list;

	private boolean isLightingFilter;

	public LightingColorFilterAdapter(List<LightingItem> list) {
		this.list = list;
		this.isLightingFilter = false;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext())
									  .inflate(R.layout.layout_list_tint_item, parent, false);
		return new ViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		LightingItem item = list.get(position);
		holder.img.setColorFilter(item.filter);

		if (isLightingFilter) {
			holder.img.setColorFilter(item.lightingFilter);
		}
	}

	@Override
	public int getItemCount() {
		return list != null ? list.size() : 0;
	}

	public void setLightingFilter(boolean isAlive) {
		this.isLightingFilter = isAlive;
	}

	public final static class ViewHolder extends RecyclerView.ViewHolder {
		public final ImageView img;

		public ViewHolder(View itemView) {
			super(itemView);
			img = (ImageView) itemView.findViewById(R.id.imageView);
		}
	}
}
