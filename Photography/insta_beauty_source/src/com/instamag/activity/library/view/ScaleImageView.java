// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import bea;

public class ScaleImageView extends ImageView
{

    private bea imageChangeListener;
    private boolean scaleToWidth;

    public ScaleImageView(Context context)
    {
        super(context);
        scaleToWidth = false;
        init();
    }

    public ScaleImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        scaleToWidth = false;
        init();
    }

    public ScaleImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        scaleToWidth = false;
        init();
    }

    private void init()
    {
        setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
    }

    public bea getImageChangeListener()
    {
        return imageChangeListener;
    }

    protected void onMeasure(int i, int j)
    {
        int i1 = android.view.View.MeasureSpec.getMode(i);
        int k1 = android.view.View.MeasureSpec.getMode(j);
        int l = android.view.View.MeasureSpec.getSize(i);
        int k = android.view.View.MeasureSpec.getSize(j);
        if (i1 == 0x40000000 || i1 == 0x80000000)
        {
            scaleToWidth = true;
        } else
        if (k1 == 0x40000000 || k1 == 0x80000000)
        {
            scaleToWidth = false;
        } else
        {
            throw new IllegalStateException("width or height needs to be set to match_parent or a specific dimension");
        }
        if (getDrawable() == null || getDrawable().getIntrinsicWidth() == 0)
        {
            super.onMeasure(i, j);
            return;
        }
        if (scaleToWidth)
        {
            j = getDrawable().getIntrinsicWidth();
            int j1 = getDrawable().getIntrinsicHeight();
            i = (l * j1) / j;
            if (k > 0 && i > k)
            {
                j = (k * j) / j1;
                i = k;
            } else
            {
                j = l;
            }
            setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            setMeasuredDimension(j, i);
            return;
        }
        if (getParent() != null && getParent().getParent() != null)
        {
            i = ((RelativeLayout)getParent().getParent()).getPaddingTop();
            i = ((RelativeLayout)getParent().getParent()).getPaddingBottom() + (0 + i);
        } else
        {
            i = 0;
        }
        setMeasuredDimension((getDrawable().getIntrinsicWidth() * k) / getDrawable().getIntrinsicHeight(), k - i);
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
        if (imageChangeListener != null)
        {
            bea bea1 = imageChangeListener;
            boolean flag;
            if (bitmap == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            bea1.a(flag);
        }
    }

    public void setImageChangeListener(bea bea1)
    {
        imageChangeListener = bea1;
    }

    public void setImageDrawable(Drawable drawable)
    {
        super.setImageDrawable(drawable);
        if (imageChangeListener != null)
        {
            bea bea1 = imageChangeListener;
            boolean flag;
            if (drawable == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            bea1.a(flag);
        }
    }

    public void setImageResource(int i)
    {
        super.setImageResource(i);
    }
}
