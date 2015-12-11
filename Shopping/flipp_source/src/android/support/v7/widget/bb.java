// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ap;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            ap, RecyclerView, an, bf, 
//            a

final class bb extends android.support.v7.widget.ap
{

    final RecyclerView a;

    private bb(RecyclerView recyclerview)
    {
        a = recyclerview;
        super();
    }

    bb(RecyclerView recyclerview, byte byte0)
    {
        this(recyclerview);
    }

    private void b()
    {
        if (RecyclerView.n(a) && RecyclerView.o(a) && RecyclerView.p(a))
        {
            ap.a(a, RecyclerView.q(a));
            return;
        } else
        {
            RecyclerView.r(a);
            a.requestLayout();
            return;
        }
    }

    public final void a()
    {
        a.a(null);
        if (RecyclerView.g(a).b)
        {
            a.m.h = true;
            RecyclerView.m(a);
        } else
        {
            a.m.h = true;
            RecyclerView.m(a);
        }
        if (!a.b.d())
        {
            a.requestLayout();
        }
    }

    public final void a(int i)
    {
        boolean flag = true;
        a.a(null);
        a a1 = a.b;
        a1.a.add(a1.a(2, i, 1));
        if (a1.a.size() == 1)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            b();
        }
    }

    public final void a(int i, int j)
    {
        boolean flag = true;
        a.a(null);
        a a1 = a.b;
        a1.a.add(a1.a(0, i, j));
        if (a1.a.size() == 1)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            b();
        }
    }

    public final void b(int i, int j)
    {
        boolean flag = true;
        a.a(null);
        a a1 = a.b;
        a1.a.add(a1.a(1, i, j));
        if (a1.a.size() == 1)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            b();
        }
    }
}
