// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
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
        a.ah = true;
        a.an = a.am;
        a.am = a.getAdapter().getCount();
        if (a.getAdapter().hasStableIds() && b != null && a.an == 0 && a.am > 0)
        {
            AdapterView.a(a, b);
            b = null;
        } else
        {
            a.y();
        }
        a.u();
        a.requestLayout();
    }

    public void onInvalidated()
    {
        a.ah = true;
        if (a.getAdapter().hasStableIds())
        {
            b = AdapterView.a(a);
        }
        a.an = a.am;
        a.am = 0;
        a.ak = -1;
        a.al = 0x8000000000000000L;
        a.ai = -1;
        a.aj = 0x8000000000000000L;
        a.ab = false;
        a.u();
        a.requestLayout();
    }
}
