package com.pluu.suitabletips.adapter.item;

import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;

/**
 * Created by PLUUSYSTEM-NEW on 2015-07-29.
 */
public class LightingItem extends ColorItem {
	public LightingColorFilter lightingFilter;

	public LightingItem(int color, PorterDuff.Mode mode) {
		super(color, mode);
	}

	public void setLightingFilter(LightingColorFilter lightingFilter) {
		this.lightingFilter = lightingFilter;
	}

}
