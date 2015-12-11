// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.content.Context;
import android.widget.RelativeLayout;

public class i extends RelativeLayout
{

    private int a;
    private int b;

    public i(Context context)
    {
        super(context);
        a = 0;
        b = 0;
    }

    protected void onMeasure(int j, int k)
    {
        super.onMeasure(j, k);
        if (b > 0 && getMeasuredWidth() > b)
        {
            setMeasuredDimension(b, getMeasuredHeight());
        } else
        if (getMeasuredWidth() < a)
        {
            setMeasuredDimension(a, getMeasuredHeight());
            return;
        }
    }

    protected void setMaxWidth(int j)
    {
        b = j;
    }

    public void setMinWidth(int j)
    {
        a = j;
    }
}
