// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class SettingListView extends ListView
{

    public SettingListView(Context context)
    {
        super(context);
    }

    public SettingListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public SettingListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(0x1fffffff, 0x80000000));
    }
}
