// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.clhorizontalgridview;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;

// Referenced classes of package com.cyberlink.you.widgetpool.clhorizontalgridview:
//            AdapterView

class n extends DataSetObserver
{

    final AdapterView a;
    private Parcelable b;

    n(AdapterView adapterview)
    {
        a = adapterview;
        super();
        b = null;
    }

    public void onChanged()
    {
        a.ag = true;
        a.am = a.al;
        a.al = a.getAdapter().getCount();
        if (a.getAdapter().hasStableIds() && b != null && a.am == 0 && a.al > 0)
        {
            AdapterView.a(a, b);
            b = null;
        } else
        {
            a.w();
        }
        a.s();
        a.requestLayout();
    }

    public void onInvalidated()
    {
        a.ag = true;
        if (a.getAdapter().hasStableIds())
        {
            b = AdapterView.a(a);
        }
        a.am = a.al;
        a.al = 0;
        a.aj = -1;
        a.ak = 0x8000000000000000L;
        a.ah = -1;
        a.ai = 0x8000000000000000L;
        a.aa = false;
        a.s();
        a.requestLayout();
    }
}
