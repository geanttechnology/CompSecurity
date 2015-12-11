// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class FixedHeightGridView extends GridView
{

    public FixedHeightGridView(Context context)
    {
        super(context);
    }

    public FixedHeightGridView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public FixedHeightGridView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(0xffffff, 0x80000000));
    }
}
