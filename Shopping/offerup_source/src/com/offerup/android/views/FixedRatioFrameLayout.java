// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FixedRatioFrameLayout extends FrameLayout
{

    public FixedRatioFrameLayout(Context context)
    {
        super(context);
    }

    public FixedRatioFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, i);
    }
}
