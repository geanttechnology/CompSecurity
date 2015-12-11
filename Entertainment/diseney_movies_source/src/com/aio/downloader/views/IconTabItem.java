// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class IconTabItem extends RadioButton
{

    private Drawable buttonDrawable;
    private int mDrawableHeight;
    private int mDrawableWidth;

    public IconTabItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = context.obtainStyledAttributes(attributeset, com.aio.downloader.R.styleable.CompoundButton, 0, 0);
        buttonDrawable = context.getDrawable(0);
        mDrawableWidth = context.getDimensionPixelSize(1, 0);
        mDrawableHeight = context.getDimensionPixelSize(2, 0);
        setButtonDrawable(0x7f02007a);
        context.recycle();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (buttonDrawable == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        buttonDrawable.setState(getDrawableState());
        int k = getGravity();
        int i1;
        if (mDrawableWidth == 0)
        {
            j = buttonDrawable.getIntrinsicHeight();
        } else
        {
            j = mDrawableWidth;
        }
        i = 0;
        k & 0x70;
        JVM INSTR lookupswitch 2: default 80
    //                   16: 152
    //                   80: 142;
           goto _L3 _L4 _L5
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_152;
_L6:
        int l;
        if (mDrawableHeight == 0)
        {
            l = buttonDrawable.getIntrinsicWidth();
        } else
        {
            l = mDrawableHeight;
        }
        i1 = (getWidth() - l) / 2;
        buttonDrawable.setBounds(i1, i, i1 + l, i + j);
        buttonDrawable.draw(canvas);
_L2:
        return;
_L5:
        i = getHeight() - j;
          goto _L6
        i = (getHeight() - j) / 2;
          goto _L6
    }
}
