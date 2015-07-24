package com.pluu.suitabletips.adapter;

import android.graphics.PorterDuff;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by nohhs on 2015-07-24.
 */
public class PorterDuffAdapter extends BaseAdapter {

	private final PorterDuff.Mode[] list;

	public PorterDuffAdapter(PorterDuff.Mode[] list) {this.list = list;}

	@Override
	public int getCount() {
		return list != null ? list.length : 0;
	}

	@Override
	public PorterDuff.Mode getItem(int position) {
		return list[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(parent.getContext())
										.inflate(android.R.layout.simple_spinner_dropdown_item, parent,
												 false);
		}

		PorterDuff.Mode item = getItem(position);

		TextView tv = ViewHolder.get(convertView, android.R.id.text1);
		tv.setText(item.name());

		return convertView;
	}

	private static class ViewHolder {
		@SuppressWarnings("unchecked")
		public static <T extends View> T get(View view, int id) {
			SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
			if (viewHolder == null) {
				viewHolder = new SparseArray<View>();
				view.setTag(viewHolder);
			}
			View childView = viewHolder.get(id);
			if (childView == null) {
				childView = view.findViewById(id);
				viewHolder.put(id, childView);
			}
			return (T) childView;
		}
	}
}
