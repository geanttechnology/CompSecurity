// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;

public class AboutPreference extends Preference
{

    public AboutPreference(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setTitle(context.getString(0x7f0600f0));
        setSummary("2.1.390");
    }
}
