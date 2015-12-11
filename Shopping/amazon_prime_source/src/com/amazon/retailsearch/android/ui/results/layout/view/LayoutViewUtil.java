// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.view.ViewGroup;
import android.widget.TextView;

public class LayoutViewUtil
{

    public LayoutViewUtil()
    {
    }

    public static void buildPlaceholder(ViewGroup viewgroup)
    {
        viewgroup.removeAllViews();
        TextView textview = new TextView(viewgroup.getContext());
        textview.setText(viewgroup.getClass().getSimpleName());
        viewgroup.addView(textview);
    }
}
