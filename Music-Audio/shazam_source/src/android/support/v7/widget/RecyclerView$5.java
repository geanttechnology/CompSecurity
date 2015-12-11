// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView, m

final class a
    implements a
{

    final RecyclerView a;

    private void c(a a1)
    {
        switch (a1.a)
        {
        default:
            return;

        case 0: // '\0'
            RecyclerView.e(a).a(a1.a, a1.a);
            return;

        case 1: // '\001'
            RecyclerView.e(a).b(a1.b, a1.b);
            return;

        case 2: // '\002'
            RecyclerView.e(a).c(a1.c, a1.c);
            return;

        case 3: // '\003'
            RecyclerView.e(a).d(a1.d, a1.d);
            break;
        }
    }

    public final d a(int i)
    {
        RecyclerView recyclerview;
        int j;
        int k;
        recyclerview = a;
        k = recyclerview.c.b();
        j = 0;
_L6:
        if (j >= k) goto _L2; else goto _L1
_L1:
        d d1 = RecyclerView.b(recyclerview.c.c(j));
        if (d1 == null || d1.m() || d1.b != i) goto _L4; else goto _L3
_L4:
        j++;
          goto _L5
_L2:
        d1 = null;
_L3:
        if (d1 == null || a.c.a(d1.a))
        {
            return null;
        }
        return d1;
_L5:
        if (true) goto _L6; else goto _L2
    }

    public final void a(int i, int j)
    {
        a.a(i, j, true);
        a.q = true;
        a a1 = a.o;
        a1.h = a1.h + j;
    }

    public final void a(h h)
    {
        c(h);
    }

    public final void b(int i, int j)
    {
        a.a(i, j, false);
        a.q = true;
    }

    public final void b(a a1)
    {
        c(a1);
    }

    public final void c(int i, int j)
    {
        Object obj = a;
        int i1 = ((RecyclerView) (obj)).c.b();
        for (int k = 0; k < i1; k++)
        {
            View view = ((RecyclerView) (obj)).c.c(k);
            c c2 = RecyclerView.b(view);
            if (c2 == null || c2.b() || c2.b < i || c2.b >= i + j)
            {
                continue;
            }
            c2.b(2);
            if (((RecyclerView) (obj)).g())
            {
                c2.b(64);
            }
            ((b)view.getLayoutParams()).c = true;
        }

        obj = ((RecyclerView) (obj)).a;
        for (int l = ((c) (obj)).c.size() - 1; l >= 0; l--)
        {
            c c1 = (c)((c) (obj)).c.get(l);
            if (c1 == null)
            {
                continue;
            }
            int j1 = c1.c();
            if (j1 >= i && j1 < i + j)
            {
                c1.b(2);
                ((b) (obj)).b(l);
            }
        }

        a.r = true;
    }

    public final void d(int i, int j)
    {
        RecyclerView recyclerview = a;
        int i1 = recyclerview.c.b();
        for (int k = 0; k < i1; k++)
        {
            a a1 = RecyclerView.b(recyclerview.c.c(k));
            if (a1 != null && !a1.b() && a1.b >= i)
            {
                a1.a(j, false);
                recyclerview.o.i = true;
            }
        }

        a a2 = recyclerview.a;
        i1 = a2.c.size();
        for (int l = 0; l < i1; l++)
        {
            a a3 = (c)a2.c.get(l);
            if (a3 != null && a3.c() >= i)
            {
                a3.a(j, true);
            }
        }

        recyclerview.requestLayout();
        a.q = true;
    }

    public final void e(int i, int j)
    {
        int j1 = -1;
        RecyclerView recyclerview = a;
        int k1 = recyclerview.c.b();
        byte byte0;
        int k;
        int l;
        int i1;
        if (i < j)
        {
            byte0 = -1;
            k = j;
            l = i;
        } else
        {
            byte0 = 1;
            k = i;
            l = j;
        }
        i1 = 0;
        while (i1 < k1) 
        {
            a a1 = RecyclerView.b(recyclerview.c.c(i1));
            if (a1 != null && a1.b >= l && a1.b <= k)
            {
                if (a1.b == i)
                {
                    a1.a(j - i, false);
                } else
                {
                    a1.a(byte0, false);
                }
                recyclerview.o.i = true;
            }
            i1++;
        }
        a a2 = recyclerview.a;
        if (i < j)
        {
            k = j;
            l = i;
            byte0 = j1;
        } else
        {
            byte0 = 1;
            k = i;
            l = j;
        }
        j1 = a2.c.size();
        i1 = 0;
        while (i1 < j1) 
        {
            a a3 = (c)a2.c.get(i1);
            if (a3 != null && a3.b >= l && a3.b <= k)
            {
                if (a3.b == i)
                {
                    a3.a(j - i, false);
                } else
                {
                    a3.a(byte0, false);
                }
            }
            i1++;
        }
        recyclerview.requestLayout();
        a.q = true;
    }

    (RecyclerView recyclerview)
    {
        a = recyclerview;
        super();
    }
}
