// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.widget.Adapter;

// Referenced classes of package android.support.v7.internal.widget:
//            e

final class b extends DataSetObserver
{

    final e a;
    private Parcelable b;

    public final void onChanged()
    {
        a.v = true;
        a.B = a.A;
        a.A = a.getAdapter().getCount();
        if (!a.getAdapter().hasStableIds() || b == null || a.B != 0 || a.A <= 0) goto _L2; else goto _L1
_L1:
        e.a(a, b);
        b = null;
_L4:
        a.b();
        a.requestLayout();
        return;
_L2:
        e e1 = a;
        if (e1.getChildCount() > 0)
        {
            e1.o = true;
            e1.n = e1.q;
            if (e1.y >= 0)
            {
                View view = e1.getChildAt(e1.y - e1.j);
                e1.m = e1.x;
                e1.l = e1.w;
                if (view != null)
                {
                    e1.k = view.getTop();
                }
                e1.p = 0;
            } else
            {
                View view1 = e1.getChildAt(0);
                Adapter adapter = e1.getAdapter();
                if (e1.j >= 0 && e1.j < adapter.getCount())
                {
                    e1.m = adapter.getItemId(e1.j);
                } else
                {
                    e1.m = -1L;
                }
                e1.l = e1.j;
                if (view1 != null)
                {
                    e1.k = view1.getTop();
                }
                e1.p = 1;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void onInvalidated()
    {
        a.v = true;
        if (a.getAdapter().hasStableIds())
        {
            b = e.a(a);
        }
        a.B = a.A;
        a.A = 0;
        a.y = -1;
        a.z = 0x8000000000000000L;
        a.w = -1;
        a.x = 0x8000000000000000L;
        a.o = false;
        a.b();
        a.requestLayout();
    }

    (e e1)
    {
        a = e1;
        super();
        b = null;
    }
}
