// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;

public class ConfirmationPreference extends DialogPreference
{

    public ConfirmationPreference(Context context)
    {
        this(context, null);
    }

    public ConfirmationPreference(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010090);
    }

    public ConfirmationPreference(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onDialogClosed(boolean flag)
    {
        super.onDialogClosed(flag);
        if (flag)
        {
            callChangeListener(Boolean.valueOf(flag));
        }
    }
}
