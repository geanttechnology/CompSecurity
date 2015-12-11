// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.content.Context;
import android.preference.SwitchPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class LongTitleSwitchPreference extends SwitchPreference
{

    public LongTitleSwitchPreference(Context context)
    {
        super(context);
    }

    public LongTitleSwitchPreference(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public LongTitleSwitchPreference(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onBindView(View view)
    {
        super.onBindView(view);
        view = (TextView)view.findViewById(0x1020016);
        if (view != null)
        {
            view.setSingleLine(false);
        }
    }
}
