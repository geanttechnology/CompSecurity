// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.w;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView, b

public final class v extends a
{

    final RecyclerView b;
    final a c = new a() {

        final v b;

        public final void a(View view, b b1)
        {
            super.a(view, b1);
            if (!b.a() && b.b.getLayoutManager() != null)
            {
                b.b.getLayoutManager().a(view, b1);
            }
        }

        public final boolean a(View view, int i, Bundle bundle)
        {
            boolean flag1 = false;
            boolean flag;
            if (super.a(view, i, bundle))
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (!b.a())
                {
                    flag = flag1;
                    if (b.b.getLayoutManager() != null)
                    {
                        view = b.b.getLayoutManager();
                        bundle = ((RecyclerView.i) (view)).i.a;
                        view = ((RecyclerView.i) (view)).i.o;
                        return false;
                    }
                }
            }
            return flag;
        }

            
            {
                b = v.this;
                super();
            }
    };

    public v(RecyclerView recyclerview)
    {
        b = recyclerview;
    }

    public final void a(View view, b b1)
    {
        super.a(view, b1);
        b1.a(android/support/v7/widget/RecyclerView.getName());
        if (!a() && b.getLayoutManager() != null)
        {
            view = b.getLayoutManager();
            RecyclerView.n n = ((RecyclerView.i) (view)).i.a;
            RecyclerView.r r = ((RecyclerView.i) (view)).i.o;
            if (w.b(((RecyclerView.i) (view)).i, -1) || w.a(((RecyclerView.i) (view)).i, -1))
            {
                b1.a(8192);
                b1.a(true);
            }
            if (w.b(((RecyclerView.i) (view)).i, 1) || w.a(((RecyclerView.i) (view)).i, 1))
            {
                b1.a(4096);
                b1.a(true);
            }
            int i = view.b(n, r);
            int j = view.c(n, r);
            view = new android.support.v4.view.a.b.i(android.support.v4.view.a.b.a().a(i, j));
            b.a.a(b1.b, ((android.support.v4.view.a.b.i)view).a);
        }
    }

    final boolean a()
    {
        RecyclerView recyclerview = b;
        return !recyclerview.g || recyclerview.h || recyclerview.b.d();
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
        if (a()) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (b.getLayoutManager() == null) goto _L4; else goto _L5
_L5:
        view = b.getLayoutManager();
        bundle = ((RecyclerView.i) (view)).i.a;
        bundle = ((RecyclerView.i) (view)).i.o;
        flag = flag1;
        if (((RecyclerView.i) (view)).i == null) goto _L4; else goto _L6
_L6:
        i;
        JVM INSTR lookupswitch 2: default 108
    //                   4096: 205
    //                   8192: 138;
           goto _L7 _L8 _L9
_L7:
        int j;
        i = 0;
        j = 0;
_L13:
        if (j != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (i == 0) goto _L4; else goto _L10
_L10:
        ((RecyclerView.i) (view)).i.scrollBy(i, j);
        return true;
_L9:
        int k;
        int l;
        int i1;
        if (w.b(((RecyclerView.i) (view)).i, -1))
        {
            i = -(view.l() - view.n() - view.p());
        } else
        {
            i = 0;
        }
        j = i;
        if (!w.a(((RecyclerView.i) (view)).i, -1)) goto _L12; else goto _L11
_L11:
        k = -(view.k() - view.m() - view.o());
        j = i;
        i = k;
          goto _L13
_L8:
        if (w.b(((RecyclerView.i) (view)).i, 1))
        {
            i = view.l() - view.n() - view.p();
        } else
        {
            i = 0;
        }
        j = i;
        if (!w.a(((RecyclerView.i) (view)).i, 1)) goto _L12; else goto _L14
_L14:
        k = view.k();
        l = view.m();
        i1 = view.o();
        j = i;
        i = k - l - i1;
          goto _L13
_L12:
        i = 0;
          goto _L13
    }

    public final void d(View view, AccessibilityEvent accessibilityevent)
    {
        super.d(view, accessibilityevent);
        accessibilityevent.setClassName(android/support/v7/widget/RecyclerView.getName());
        if ((view instanceof RecyclerView) && !a())
        {
            view = (RecyclerView)view;
            if (view.getLayoutManager() != null)
            {
                view.getLayoutManager().a(accessibilityevent);
            }
        }
    }
}
