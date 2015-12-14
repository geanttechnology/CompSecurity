// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;

public class SwitchPreferenceCompat extends CheckBoxPreference
{

    public SwitchPreferenceCompat(Context context)
    {
        super(context);
        setWidgetLayout();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setWidgetLayout();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setWidgetLayout();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeset, int i, int j)
    {
        super(context, attributeset, i, j);
        setWidgetLayout();
    }

    private void setWidgetLayout()
    {
        setWidgetLayoutResource(0x7f030020);
    }
}
