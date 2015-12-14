// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class CheckBoxPreferenceWithLongSummary extends CheckBoxPreference
{

    public CheckBoxPreferenceWithLongSummary(Context context)
    {
        super(context);
    }

    public CheckBoxPreferenceWithLongSummary(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public CheckBoxPreferenceWithLongSummary(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onBindView(View view)
    {
        super.onBindView(view);
        ((TextView)view.findViewById(0x1020010)).setMaxLines(10);
    }
}
