// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class LongTitleSummaryListPreference extends ListPreference
{

    public LongTitleSummaryListPreference(Context context)
    {
        this(context, null);
    }

    public LongTitleSummaryListPreference(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onBindView(View view)
    {
        super.onBindView(view);
        TextView textview = (TextView)view.findViewById(0x1020016);
        if (textview != null)
        {
            textview.setSingleLine(false);
        }
        view = (TextView)view.findViewById(0x1020010);
        if (view != null)
        {
            view.setMaxLines(100);
        }
    }
}
