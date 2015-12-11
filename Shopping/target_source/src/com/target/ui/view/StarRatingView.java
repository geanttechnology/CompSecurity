// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.target.ui.util.j;
import java.math.BigDecimal;

public class StarRatingView extends LinearLayout
{

    private static final int NUM_STARS = 5;
    private int mStarEmpty;
    private int mStarFull;
    private int mStarHalf;
    private int mStarHeight;
    private int mStarSideMargin;
    private int mStarWidth;

    public StarRatingView(Context context)
    {
        super(context);
        mStarEmpty = 0x7f020221;
        mStarFull = 0x7f020222;
        mStarHalf = 0x7f020223;
        a(context, null);
    }

    public StarRatingView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mStarEmpty = 0x7f020221;
        mStarFull = 0x7f020222;
        mStarHalf = 0x7f020223;
        a(context, attributeset);
    }

    public StarRatingView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mStarEmpty = 0x7f020221;
        mStarFull = 0x7f020222;
        mStarHalf = 0x7f020223;
        a(context, attributeset);
    }

    private void a()
    {
        Drawable drawable;
        if (j.b())
        {
            drawable = getResources().getDrawable(mStarFull, null);
        } else
        {
            drawable = getResources().getDrawable(mStarFull);
        }
        mStarWidth = drawable.getIntrinsicWidth();
        mStarHeight = drawable.getIntrinsicHeight();
        mStarSideMargin = getResources().getDimensionPixelSize(0x7f0a02c0);
    }

    private void a(Context context, AttributeSet attributeset)
    {
        attributeset = context.getTheme().obtainStyledAttributes(attributeset, com.target.ui.a.a.StarRatingView, 0, 0);
        int i = attributeset.getInteger(0, 1);
        if (i != 0) goto _L2; else goto _L1
_L1:
        mStarEmpty = 0x7f020224;
        mStarFull = 0x7f020225;
        mStarHalf = 0x7f020226;
_L4:
        attributeset.recycle();
        i = getResources().getDimensionPixelSize(0x7f0a02c0);
        attributeset = new android.widget.LinearLayout.LayoutParams(-2, -2);
        attributeset.setMargins(i, 0, i, 0);
        for (i = 0; i < 5; i++)
        {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(attributeset);
            imageview.setPadding(0, 0, 0, 0);
            addView(imageview);
        }

        break MISSING_BLOCK_LABEL_161;
_L2:
        if (i != 1) goto _L4; else goto _L3
_L3:
        mStarEmpty = 0x7f020227;
        mStarFull = 0x7f020228;
        mStarHalf = 0x7f020229;
          goto _L4
        context;
        attributeset.recycle();
        throw context;
        a();
        return;
    }

    protected void onMeasure(int i, int k)
    {
        super.onMeasure(i, k);
        i = mStarWidth;
        k = mStarSideMargin;
        int l = mStarHeight;
        int j1 = getMeasuredWidth();
        int l1 = getPaddingLeft();
        int i2 = getPaddingRight();
        int j2 = getMeasuredHeight();
        int k2 = getPaddingTop();
        int l2 = getPaddingBottom();
        float f = Math.min((float)(j1 - l1 - i2) / (float)((i + k * 2) * 5), (float)(j2 - k2 - l2) / (float)l);
        if (Float.compare(f, 1.0F) < 0)
        {
            k = (int)Math.floor((float)mStarWidth * f);
            int i1 = (int)Math.floor((float)mStarHeight * f);
            int k1 = (int)Math.floor(f * (float)mStarSideMargin);
            i = 0;
            while (i < getChildCount()) 
            {
                View view = getChildAt(i);
                ((android.widget.LinearLayout.LayoutParams)view.getLayoutParams()).setMargins(k1, 0, k1, 0);
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000));
                i++;
            }
        }
    }

    public void setHalfStars(int i)
    {
        setVisibility(0);
        int l = 1;
        while (l <= 5) 
        {
            ImageView imageview = (ImageView)getChildAt(l - 1);
            int k;
            if (i >= l * 2)
            {
                k = mStarFull;
            } else
            if (i == l * 2 - 1)
            {
                k = mStarHalf;
            } else
            {
                k = mStarEmpty;
            }
            imageview.setImageResource(k);
            l++;
        }
    }

    public void setRating(float f)
    {
        BigDecimal bigdecimal = new BigDecimal(f);
        if (bigdecimal == null)
        {
            bigdecimal = new BigDecimal(0);
        }
        setHalfStars(bigdecimal.multiply(new BigDecimal(2)).intValue());
    }
}
