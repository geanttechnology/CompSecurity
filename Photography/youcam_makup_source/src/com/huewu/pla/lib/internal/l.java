// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib.internal;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;
import com.huewu.pla.lib.a;

// Referenced classes of package com.huewu.pla.lib.internal:
//            PLA_AdapterView

class l extends DataSetObserver
{

    final PLA_AdapterView a;
    private Parcelable b;

    l(PLA_AdapterView pla_adapterview)
    {
        a = pla_adapterview;
        super();
        b = null;
    }

    public void onChanged()
    {
        com.huewu.pla.lib.a.a("data changed by onChanged()");
        a.Q = true;
        a.W = a.V;
        a.V = a.getAdapter().getCount();
        if (a.getAdapter().hasStableIds() && b != null && a.W == 0 && a.V > 0)
        {
            com.huewu.pla.lib.internal.PLA_AdapterView.a(a, b);
            b = null;
        } else
        {
            a.m();
        }
        a.requestLayout();
    }

    public void onInvalidated()
    {
        com.huewu.pla.lib.a.a("data changed by onInvalidated()");
        a.Q = true;
        if (a.getAdapter().hasStableIds())
        {
            b = com.huewu.pla.lib.internal.PLA_AdapterView.a(a);
        }
        a.W = a.V;
        a.V = 0;
        a.T = -1;
        a.U = 0x8000000000000000L;
        a.R = -1;
        a.K = false;
        a.requestLayout();
    }
}
