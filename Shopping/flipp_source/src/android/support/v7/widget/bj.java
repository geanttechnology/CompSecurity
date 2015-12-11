// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.e;
import android.support.v4.view.a.h;
import android.support.v4.view.a.m;
import android.support.v4.view.ap;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v7.widget:
//            bk, RecyclerView, au

public final class bj extends a
{

    final RecyclerView b;
    final a c = new bk(this);

    public bj(RecyclerView recyclerview)
    {
        b = recyclerview;
    }

    public final void a(View view, e e1)
    {
        super.a(view, e1);
        e1.a(android/support/v7/widget/RecyclerView.getName());
        if (b.getLayoutManager() != null)
        {
            view = b.getLayoutManager();
            az az = ((au) (view)).q.a;
            bf bf = ((au) (view)).q.m;
            e1.a(android/support/v7/widget/RecyclerView.getName());
            if (ap.b(((au) (view)).q, -1) || ap.a(((au) (view)).q, -1))
            {
                e1.a(8192);
                e1.a(true);
            }
            if (ap.b(((au) (view)).q, 1) || ap.a(((au) (view)).q, 1))
            {
                e1.a(4096);
                e1.a(true);
            }
            int i = view.a(az, bf);
            int j = view.b(az, bf);
            view = new m(e.k().a(i, j));
            e.a.a(e1.b, ((m)view).a);
        }
    }

    public final boolean a(View view, int i, Bundle bundle)
    {
        boolean flag1 = false;
        if (!super.a(view, i, bundle)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (b.getLayoutManager() == null) goto _L4; else goto _L3
_L3:
        view = b.getLayoutManager();
        bundle = ((au) (view)).q.a;
        bundle = ((au) (view)).q.m;
        flag = flag1;
        if (((au) (view)).q == null) goto _L4; else goto _L5
_L5:
        i;
        JVM INSTR lookupswitch 2: default 96
    //                   4096: 193
    //                   8192: 126;
           goto _L6 _L7 _L8
_L6:
        int j;
        i = 0;
        j = 0;
_L12:
        if (j != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (i == 0) goto _L4; else goto _L9
_L9:
        ((au) (view)).q.scrollBy(i, j);
        return true;
_L8:
        int k;
        int l;
        int i1;
        if (ap.b(((au) (view)).q, -1))
        {
            i = -(view.l() - view.n() - view.p());
        } else
        {
            i = 0;
        }
        j = i;
        if (!ap.a(((au) (view)).q, -1)) goto _L11; else goto _L10
_L10:
        k = -(view.k() - view.m() - view.o());
        j = i;
        i = k;
          goto _L12
_L7:
        if (ap.b(((au) (view)).q, 1))
        {
            i = view.l() - view.n() - view.p();
        } else
        {
            i = 0;
        }
        j = i;
        if (!ap.a(((au) (view)).q, 1)) goto _L11; else goto _L13
_L13:
        k = view.k();
        l = view.m();
        i1 = view.o();
        j = i;
        i = k - l - i1;
          goto _L12
_L11:
        i = 0;
          goto _L12
    }

    public final void d(View view, AccessibilityEvent accessibilityevent)
    {
        super.d(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v7/widget/RecyclerView.getName());
        if (view instanceof RecyclerView)
        {
            view = (RecyclerView)view;
            if (view.getLayoutManager() != null)
            {
                view.getLayoutManager().a(accessibilityevent);
            }
        }
    }
}
