package com.pluu.suitabletips;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SelectorActivity extends AppCompatActivity {

	@Bind(R.id.button2)
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selector);
		ButterKnife.bind(this);

		Drawable drawable = getBgSelector();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
			button.setBackground(drawable);
		} else {
			button.setBackgroundDrawable(drawable);
		}

		ColorStateList colors = getTextColorSelector();
		button.setTextColor(colors);
	}

	private Drawable getBgSelector() {
		Resources res = getResources();
		StateListDrawable states = new StateListDrawable();
		states.addState(new int[]{android.R.attr.state_pressed},
						createDrawable(res.getColor(R.color.color_hint)));
		states.addState(new int[]{}, createDrawable(res.getColor(R.color.divider)));

		return states;
	}

	private Drawable createDrawable(int bgColor) {
		final int r = 15;
		float[] outerR = new float[]{r, r, r, r, r, r, r, r};
		RoundRectShape rectShape = new RoundRectShape(outerR, null, null);

		Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
		p.setColor(bgColor);
		ShapeDrawable drawable = new ShapeDrawable(rectShape);
		drawable.getPaint().set(p);

		return drawable;
	}

	private ColorStateList getTextColorSelector() {
		int[][] states = new int[][] {
			new int[] { android.R.attr.state_pressed},
			new int[] {}
		};
		int[] colors = new int[] {
			Color.WHITE,
			Color.BLACK,
		};
		return new ColorStateList(states, colors);
	}
}
