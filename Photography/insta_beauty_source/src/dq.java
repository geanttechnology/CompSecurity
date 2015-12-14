// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.widget.SpinnerCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

class dq
    implements android.widget.AdapterView.OnItemClickListener
{

    final SpinnerCompat a;
    final dp b;

    dq(dp dp1, SpinnerCompat spinnercompat)
    {
        b = dp1;
        a = spinnercompat;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        b.a.setSelection(i);
        if (b.a.mOnItemClickListener != null)
        {
            b.a.performItemClick(view, i, dp.a(b).getItemId(i));
        }
        b.a();
    }
}
