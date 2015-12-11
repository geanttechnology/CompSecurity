// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;

// Referenced classes of package android.support.v7.internal.widget:
//            e

class b extends DataSetObserver
{

    final e a;
    private Parcelable b;

    public void onChanged()
    {
        a.u = true;
        a.A = a.z;
        a.z = a.getAdapter().getCount();
        if (a.getAdapter().hasStableIds() && b != null && a.A == 0 && a.z > 0)
        {
            e.a(a, b);
            b = null;
        } else
        {
            a.j();
        }
        a.e();
        a.requestLayout();
    }

    public void onInvalidated()
    {
        a.u = true;
        if (a.getAdapter().hasStableIds())
        {
            b = e.a(a);
        }
        a.A = a.z;
        a.z = 0;
        a.x = -1;
        a.y = 0x8000000000000000L;
        a.v = -1;
        a.w = 0x8000000000000000L;
        a.o = false;
        a.e();
        a.requestLayout();
    }

    (e e1)
    {
        a = e1;
        super();
        b = null;
    }
}
