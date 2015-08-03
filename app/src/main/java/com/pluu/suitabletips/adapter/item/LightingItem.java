package com.pluu.suitabletips.adapter.item;

import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;

/**
 * Created by PLUUSYSTEM-NEW on 2015-07-29.
 */
public class LightingItem extends ColorItem {
	public final LightingColorFilter lightingFilter;

	public LightingItem(int color, PorterDuff.Mode mode, LightingColorFilter filter) {
		super(color, mode);
		this.lightingFilter = filter;
	}

}
