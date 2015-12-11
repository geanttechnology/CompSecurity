// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.VideoView;

public class AppLovinVideoView extends VideoView
{

    private int a;
    private int b;

    public AppLovinVideoView(Context context)
    {
        this(context, null);
    }

    public AppLovinVideoView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AppLovinVideoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = 0;
        b = 0;
    }

    protected void onMeasure(int i, int j)
    {
        if (a <= 0 || b <= 0)
        {
            super.onMeasure(i, j);
            return;
        }
        float f = (float)b / (float)getHeight();
        float f1 = (float)a / (float)getWidth();
        if (f > f1)
        {
            j = (int)Math.ceil((float)b / f);
            i = (int)Math.ceil((float)a / f);
        } else
        {
            j = (int)Math.ceil((float)b / f1);
            i = (int)Math.ceil((float)a / f1);
        }
        setMeasuredDimension(i, j);
    }

    public void setVideoSize(int i, int j)
    {
        a = i;
        b = j;
        try
        {
            getHolder().setFixedSize(i, j);
            requestLayout();
            invalidate();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
