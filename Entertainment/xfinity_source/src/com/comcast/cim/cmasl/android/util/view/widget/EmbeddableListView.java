// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class EmbeddableListView extends ListView
{

    public static final int MAX_CELL_HEIGHT_MEASURE_SPEC = android.view.View.MeasureSpec.makeMeasureSpec(0x800000, 0x80000000);

    public EmbeddableListView(Context context)
    {
        super(context);
    }

    public EmbeddableListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public EmbeddableListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, MAX_CELL_HEIGHT_MEASURE_SPEC);
        getLayoutParams().height = getMeasuredHeight();
    }

}
