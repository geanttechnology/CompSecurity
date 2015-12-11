// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.Spinner;

public class DialogSpinner extends Spinner
{

    public DialogSpinner(Context context)
    {
        super(context);
    }

    public DialogSpinner(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public DialogSpinner(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean performClick()
    {
        (new android.app.AlertDialog.Builder(getContext())).setAdapter((ListAdapter)getAdapter(), new android.content.DialogInterface.OnClickListener() {

            final DialogSpinner a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                a.setSelection(i);
                dialoginterface.dismiss();
            }

            
            {
                a = DialogSpinner.this;
                super();
            }
        }).create().show();
        return true;
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
}
