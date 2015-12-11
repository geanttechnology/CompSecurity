// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.emilsjolander.components.StickyListHeaders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class WrapperView
{

    private int layoutId;
    private LinearLayout v;

    public WrapperView(Context context)
    {
        layoutId = R.layout.wrapper;
        v = (LinearLayout)LayoutInflater.from(context).inflate(layoutId, null);
    }

    public WrapperView(View view)
    {
        layoutId = R.layout.wrapper;
        v = (LinearLayout)view;
    }

    public transient View wrapViews(View aview[])
    {
        v.removeAllViews();
        int j = aview.length;
        for (int i = 0; i < j; i++)
        {
            View view = aview[i];
            v.addView(view);
        }

        return v;
    }
}
