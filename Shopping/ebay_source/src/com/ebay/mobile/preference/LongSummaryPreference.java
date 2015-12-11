// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class LongSummaryPreference extends Preference
{

    public LongSummaryPreference(Context context)
    {
        this(context, null);
    }

    public LongSummaryPreference(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x101008e);
    }

    public LongSummaryPreference(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onBindView(View view)
    {
        super.onBindView(view);
        ((TextView)view.findViewById(0x1020016)).setVisibility(8);
        view = (TextView)view.findViewById(0x1020010);
        if (view != null)
        {
            view.setMaxLines(100);
        }
    }
}
