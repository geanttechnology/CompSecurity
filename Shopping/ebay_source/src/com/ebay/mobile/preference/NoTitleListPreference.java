// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class NoTitleListPreference extends ListPreference
{

    public NoTitleListPreference(Context context)
    {
        this(context, null);
    }

    public NoTitleListPreference(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onBindView(View view)
    {
        super.onBindView(view);
        view.findViewById(0x1020016).setVisibility(8);
        view = (ImageView)view.findViewById(0x1020006);
        if (view != null)
        {
            view.setVisibility(0);
            view.setBackgroundResource(0x7f0202a8);
        }
    }
}
