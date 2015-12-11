// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.ui;

import afy;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

public class SlidingFrameLayout extends FrameLayout
{

    private android.view.ViewTreeObserver.OnPreDrawListener a;
    private float b;

    public SlidingFrameLayout(Context context)
    {
        super(context);
    }

    public SlidingFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public static android.view.ViewTreeObserver.OnPreDrawListener a(SlidingFrameLayout slidingframelayout)
    {
        return slidingframelayout.a;
    }

    public static float b(SlidingFrameLayout slidingframelayout)
    {
        return slidingframelayout.b;
    }

    public float getXFraction()
    {
        if (getHeight() == 0)
        {
            return 0.0F;
        } else
        {
            return getTranslationX() / (float)getWidth();
        }
    }

    public void setXFraction(float f)
    {
        b = f;
        if (getHeight() == 0)
        {
            if (a == null)
            {
                a = new afy(this);
                getViewTreeObserver().addOnPreDrawListener(a);
            }
            return;
        } else
        {
            setTranslationX((float)getWidth() * b);
            return;
        }
    }
}
