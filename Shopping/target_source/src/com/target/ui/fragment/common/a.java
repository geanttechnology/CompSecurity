// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.app.Activity;
import android.app.Dialog;
import com.wdullaer.materialdatetimepicker.date.b;

public class a extends b
{

    public a()
    {
    }

    public static a a(com.wdullaer.materialdatetimepicker.date.b.b b1, int i, int j, int k)
    {
        a a1 = new a();
        a1.b(b1, i, j, k);
        return a1;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    public void onPause()
    {
        super.onPause();
        if (getDialog() == null)
        {
            return;
        } else
        {
            getDialog().dismiss();
            return;
        }
    }
}
