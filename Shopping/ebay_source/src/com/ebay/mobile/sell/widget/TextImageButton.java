// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatButton;
import android.text.Layout;
import android.util.AttributeSet;

public class TextImageButton extends AppCompatButton
{

    private Drawable mButtonDrawable;
    private int mButtonResource;

    public TextImageButton(Context context)
    {
        this(context, null);
    }

    public TextImageButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010048);
    }

    public TextImageButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (mButtonDrawable != null)
        {
            int ai[] = getDrawableState();
            mButtonDrawable.setState(ai);
            invalidate();
        }
    }

    public int getCompoundPaddingLeft()
    {
        int i = super.getCompoundPaddingLeft();
        if (mButtonDrawable == null)
        {
            return i;
        } else
        {
            return i + (mButtonDrawable.getIntrinsicWidth() + i);
        }
    }

    protected void onDraw(Canvas canvas)
    {
        Drawable drawable;
        super.onDraw(canvas);
        drawable = mButtonDrawable;
        if (drawable == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        int i1;
        j = getGravity();
        i1 = drawable.getIntrinsicHeight();
        i = 0;
        j & 0x70;
        JVM INSTR lookupswitch 2: default 60
    //                   16: 164
    //                   80: 152;
           goto _L3 _L4 _L5
_L3:
        float f = Layout.getDesiredWidth(getText(), getPaint());
        int l = super.getCompoundPaddingLeft();
        int k = getWidth();
        int j1 = drawable.getIntrinsicWidth() + l;
        l = (int)((float)k - f - (float)j1) / 2;
        k = l;
        if (l < j1 / 2)
        {
            k = j1 / 2;
        }
        drawable.setBounds(k, i, drawable.getIntrinsicWidth() + k, i + i1);
        drawable.draw(canvas);
_L2:
        return;
_L5:
        i = getHeight() - i1;
        continue; /* Loop/switch isn't completed */
_L4:
        i = ((getHeight() - i1 - getExtendedPaddingBottom()) + getExtendedPaddingTop()) / 2;
        if (true) goto _L3; else goto _L6
_L6:
    }

    public void setButtonDrawable(int i)
    {
        if (i != 0 && i == mButtonResource)
        {
            return;
        }
        mButtonResource = i;
        Drawable drawable = null;
        if (mButtonResource != 0)
        {
            drawable = getResources().getDrawable(mButtonResource);
        }
        setButtonDrawable(drawable);
    }

    public void setButtonDrawable(Drawable drawable)
    {
        if (drawable != null)
        {
            if (mButtonDrawable != null)
            {
                mButtonDrawable.setCallback(null);
                unscheduleDrawable(mButtonDrawable);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            boolean flag;
            if (getVisibility() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            drawable.setVisible(flag, false);
            mButtonDrawable = drawable;
            mButtonDrawable.setState(null);
            setMinHeight(mButtonDrawable.getIntrinsicHeight());
        }
        refreshDrawableState();
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == mButtonDrawable;
    }
}
