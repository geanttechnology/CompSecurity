// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;

public class TriggerSpinner extends Spinner
{

    public TriggerSpinner(Context context)
    {
        super(context);
    }

    public TriggerSpinner(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public TriggerSpinner(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void setSelection(int i)
    {
        boolean flag;
        if (i == getSelectedItemPosition())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        super.setSelection(i);
        if (flag)
        {
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(), i, getSelectedItemId());
        }
    }

    public void setSelection(int i, boolean flag)
    {
        boolean flag1;
        if (i == getSelectedItemPosition())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        super.setSelection(i, flag);
        if (flag1)
        {
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(), i, getSelectedItemId());
        }
    }
}
