// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.askexpert;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

public class CustomGroupExpandableListView extends ExpandableListView
{

    public CustomGroupExpandableListView(Context context)
    {
        super(context);
    }

    public CustomGroupExpandableListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public CustomGroupExpandableListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(0x7fffffff, 0x80000000));
    }
}
