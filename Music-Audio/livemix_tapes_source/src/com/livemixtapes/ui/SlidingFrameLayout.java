// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class SlidingFrameLayout extends FrameLayout
{

    public SlidingFrameLayout(Context context)
    {
        super(context);
    }

    public SlidingFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public SlidingFrameLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public float getXFraction()
    {
        if (getWidth() == 0)
        {
            return 0.0F;
        } else
        {
            return getTranslationX() / (float)getWidth();
        }
    }

    public float getYFraction()
    {
        if (getHeight() == 0)
        {
            return 0.0F;
        } else
        {
            return getTranslationY() / (float)getHeight();
        }
    }

    public void setXFraction(float f)
    {
        setTranslationX((float)getWidth() * f);
    }

    public void setYFraction(float f)
    {
        setTranslationY((float)getHeight() * f);
    }
}
