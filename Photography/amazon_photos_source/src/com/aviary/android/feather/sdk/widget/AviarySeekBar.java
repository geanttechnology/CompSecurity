// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AviarySeekBar extends SeekBar
{

    private static final String LOG_TAG = "seekbar";
    protected int mBackgroundOffset;
    private Drawable mCurrentDrawable;
    private int mRealWidth;
    protected Drawable mSecondary;
    protected Drawable mSecondaryCenter;
    protected double mSecondaryCenterOffset;
    protected Drawable mSecondaryInverted;
    protected int mSecondaryMinHeight;
    protected int mSecondaryMinWidth;

    public AviarySeekBar(Context context)
    {
        this(context, null);
    }

    public AviarySeekBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, com.aviary.android.feather.sdk.R.attr.aviarySeekBarStyle);
    }

    public AviarySeekBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = context.getTheme().obtainStyledAttributes(attributeset, com.aviary.android.feather.sdk.R.styleable.AviarySeekBar, i, 0);
        attributeset = context.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviarySeekBar_aviarySeekBarThumb);
        i = context.getDimensionPixelOffset(com.aviary.android.feather.sdk.R.styleable.AviarySeekBar_aviarySeekBarThumbOffset, 0);
        mSecondary = context.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviarySeekBar_aviarySeekBarSecondary);
        mSecondaryInverted = context.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviarySeekBar_aviarySeekBarSecondaryInverted);
        mSecondaryCenter = context.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviarySeekBar_aviarySeekBarSecondaryCenter);
        context.recycle();
        mSecondaryMinWidth = mSecondary.getIntrinsicWidth();
        mSecondaryMinHeight = mSecondary.getIntrinsicHeight();
        mSecondaryCenterOffset = (double)mSecondaryMinWidth * 0.5D;
        mBackgroundOffset = (int)((double)getProgressDrawable().getIntrinsicWidth() * 0.12D);
        setThumb(attributeset);
        setThumbOffset(i);
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        int ai[] = getDrawableState();
        mSecondary.setState(ai);
        mSecondaryInverted.setState(ai);
        mSecondaryCenter.setState(ai);
    }

    protected void onDraw(Canvas canvas)
    {
        this;
        JVM INSTR monitorenter ;
        int i = mRealWidth;
        if (i >= 1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        double d;
        double d1;
        double d2;
        d = ((double)getProgress() - 50D) / 50D;
        d1 = (double)(-getPaddingLeft()) + (double)getWidth() / 2D;
        d2 = ((double)mRealWidth * d) / 2D;
        if (!(getProgressDrawable() instanceof LayerDrawable)) goto _L4; else goto _L3
_L3:
        LayerDrawable layerdrawable = (LayerDrawable)getProgressDrawable();
        Drawable drawable;
        int j;
        i = 0;
        j = 0;
        drawable = null;
        if (d <= 0.0D) goto _L6; else goto _L5
_L5:
        i = (int)(d1 - mSecondaryCenterOffset);
        j = (int)((double)i + d2 + mSecondaryCenterOffset);
        drawable = mSecondary;
_L9:
        int k;
        int l;
        l = i;
        k = j;
        if (j - i < mSecondaryMinWidth)
        {
            l = (int)(d1 - (double)(mSecondaryMinWidth / 2));
            k = (int)((double)(mSecondaryMinWidth / 2) + d1);
            drawable = mSecondaryCenter;
        }
        if (mCurrentDrawable != drawable)
        {
            mCurrentDrawable = drawable;
            layerdrawable.setDrawableByLayerId(0x102000f, mCurrentDrawable);
        }
        if (drawable == null) goto _L4; else goto _L7
_L7:
        drawable.setBounds(l, 0, k, mSecondaryMinHeight);
_L4:
        super.onDraw(canvas);
          goto _L1
        canvas;
        throw canvas;
_L6:
        if (d >= 0.0D) goto _L9; else goto _L8
_L8:
        i = (int)(d1 + d2);
        j = (int)(mSecondaryCenterOffset + d1);
        drawable = mSecondaryInverted;
          goto _L9
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        mRealWidth = i - (getPaddingLeft() + getPaddingRight()) - mBackgroundOffset;
    }
}
