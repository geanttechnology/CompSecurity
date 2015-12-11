// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

class SlidingTabStrip extends LinearLayout
{
    private static class SimpleTabColorizer
        implements SlidingTabLayout.TabColorizer
    {

        private int dividerColors[];
        private int indicatorColors[];

        public int getDividerColor(int i)
        {
            return dividerColors[i % dividerColors.length];
        }

        public final int getIndicatorColor(int i)
        {
            return indicatorColors[i % indicatorColors.length];
        }

        transient void setDividerColors(int ai[])
        {
            dividerColors = ai;
        }

        transient void setIndicatorColors(int ai[])
        {
            indicatorColors = ai;
        }

        private SimpleTabColorizer()
        {
        }

    }


    private static final byte DEFAULT_BOTTOM_BORDER_COLOR_ALPHA = 38;
    private static final int DEFAULT_BOTTOM_BORDER_THICKNESS_DIPS = 0;
    private static final byte DEFAULT_DIVIDER_COLOR_ALPHA = 32;
    private static final float DEFAULT_DIVIDER_HEIGHT = 0.5F;
    private static final int DEFAULT_DIVIDER_THICKNESS_DIPS = 1;
    private static final int DEFAULT_SELECTED_INDICATOR_COLOR = 0xff33b5e5;
    private static final int SELECTED_INDICATOR_THICKNESS_DIPS = 2;
    private final Paint bottomBorderPaint;
    private final int bottomBorderThickness;
    private SlidingTabLayout.TabColorizer customTabColorizer;
    private final int defaultBottomBorderColor;
    private final SimpleTabColorizer defaultTabColorizer;
    private final float dividerHeight;
    private final Paint dividerPaint;
    private final Paint selectedIndicatorPaint;
    private final int selectedIndicatorThickness;
    private int selectedPosition;
    private float selectionOffset;

    SlidingTabStrip(Context context)
    {
        this(context, null);
    }

    SlidingTabStrip(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        attributeset = new TypedValue();
        context.getTheme().resolveAttribute(0x1010030, attributeset, true);
        int i = ((TypedValue) (attributeset)).data;
        defaultBottomBorderColor = setColorAlpha(i, (byte)38);
        defaultTabColorizer = new SimpleTabColorizer();
        defaultTabColorizer.setIndicatorColors(new int[] {
            0xff33b5e5
        });
        defaultTabColorizer.setDividerColors(new int[] {
            setColorAlpha(i, (byte)32)
        });
        bottomBorderThickness = (int)(0.0F * f);
        bottomBorderPaint = new Paint();
        bottomBorderPaint.setColor(defaultBottomBorderColor);
        selectedIndicatorThickness = (int)(2.0F * f);
        selectedIndicatorPaint = new Paint();
        dividerHeight = 0.5F;
        dividerPaint = new Paint();
        dividerPaint.setStrokeWidth((int)(1.0F * f));
    }

    private static int blendColors(int i, int j, float f)
    {
        float f1 = 1.0F - f;
        float f2 = Color.red(i);
        float f3 = Color.red(j);
        float f4 = Color.green(i);
        float f5 = Color.green(j);
        float f6 = Color.blue(i);
        float f7 = Color.blue(j);
        return Color.rgb((int)(f2 * f + f3 * f1), (int)(f4 * f + f5 * f1), (int)(f6 * f + f7 * f1));
    }

    private static int setColorAlpha(int i, byte byte0)
    {
        return Color.argb(byte0, Color.red(i), Color.green(i), Color.blue(i));
    }

    protected void onDraw(Canvas canvas)
    {
        int j2 = getHeight();
        int k2 = getChildCount();
        int i = (int)(Math.min(Math.max(0.0F, dividerHeight), 1.0F) * (float)j2);
        Object obj;
        int i1;
        if (customTabColorizer != null)
        {
            obj = customTabColorizer;
        } else
        {
            obj = defaultTabColorizer;
        }
        if (k2 > 0)
        {
            View view = getChildAt(selectedPosition);
            int i2 = view.getLeft();
            int l1 = view.getRight();
            int l = ((SlidingTabLayout.TabColorizer) (obj)).getIndicatorColor(selectedPosition);
            int j = l;
            int k1 = i2;
            int j1 = l1;
            if (selectionOffset > 0.0F)
            {
                j = l;
                k1 = i2;
                j1 = l1;
                if (selectedPosition < getChildCount() - 1)
                {
                    j1 = ((SlidingTabLayout.TabColorizer) (obj)).getIndicatorColor(selectedPosition + 1);
                    j = l;
                    if (l != j1)
                    {
                        j = blendColors(j1, l, selectionOffset);
                    }
                    View view1 = getChildAt(selectedPosition + 1);
                    k1 = (int)(selectionOffset * (float)view1.getLeft() + (1.0F - selectionOffset) * (float)i2);
                    j1 = (int)(selectionOffset * (float)view1.getRight() + (1.0F - selectionOffset) * (float)l1);
                }
            }
            selectedIndicatorPaint.setColor(j);
            canvas.drawRect(k1, j2 - selectedIndicatorThickness, j1, j2, selectedIndicatorPaint);
        }
        canvas.drawRect(0.0F, j2 - bottomBorderThickness, getWidth(), j2, bottomBorderPaint);
        i1 = selectedIndicatorThickness;
        for (int k = 0; k < k2 - 1; k++)
        {
            View view2 = getChildAt(k);
            dividerPaint.setColor(((SlidingTabLayout.TabColorizer) (obj)).getDividerColor(k));
            canvas.drawLine(view2.getRight(), i1, view2.getRight(), j2 - selectedIndicatorThickness, dividerPaint);
        }

    }

    void onViewPagerPageChanged(int i, float f)
    {
        selectedPosition = i;
        selectionOffset = f;
        invalidate();
    }

    void setCustomTabColorizer(SlidingTabLayout.TabColorizer tabcolorizer)
    {
        customTabColorizer = tabcolorizer;
        invalidate();
    }

    transient void setSelectedIndicatorColors(int ai[])
    {
        customTabColorizer = null;
        defaultTabColorizer.setIndicatorColors(ai);
        invalidate();
    }
}
