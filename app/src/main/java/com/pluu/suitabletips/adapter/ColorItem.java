package com.pluu.suitabletips.adapter;

import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

/**
 * Created by nohhs on 2015-07-24.
 */
public class ColorItem {
	public final ColorFilter filter;

	public ColorItem(int color, PorterDuff.Mode mode) {
		filter = new PorterDuffColorFilter(color, mode);
	}
}
