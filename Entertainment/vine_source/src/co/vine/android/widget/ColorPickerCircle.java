// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import co.vine.android.Settings;
import co.vine.android.util.ViewUtil;

public class ColorPickerCircle extends ImageView
{

    private int mIndex;
    private boolean mSelected;
    private Drawable mWhiteCircle;

    public ColorPickerCircle(Context context)
    {
        this(context, null);
    }

    public ColorPickerCircle(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ColorPickerCircle(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        Resources resources = getResources();
        context.obtainStyledAttributes(attributeset, co.vine.android.R.styleable.ColorPickerCircle, i, 0).recycle();
        mWhiteCircle = resources.getDrawable(0x7f0200f8);
    }

    public int getIndex()
    {
        return mIndex;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mSelected)
        {
            int i = getWidth();
            mWhiteCircle.setBounds(i / 4, i / 4, (i * 3) / 4, (i * 3) / 4);
            mWhiteCircle.draw(canvas);
        }
    }

    public void setIndex(int i)
    {
        mIndex = i;
        Drawable drawable = getResources().getDrawable(0x7f0200f7);
        drawable.setColorFilter(Settings.PROFILE_BACKGROUND_COLORS[i] | 0xff000000, android.graphics.PorterDuff.Mode.SRC_ATOP);
        ViewUtil.setBackground(this, drawable);
        invalidate();
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        mSelected = flag;
        invalidate();
    }
}
