// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            b, c, RecyclerView, au, 
//            d, bi, bf, av, 
//            az

final class am
    implements b
{

    final RecyclerView a;

    am(RecyclerView recyclerview)
    {
        a = recyclerview;
        super();
    }

    private void c(c c1)
    {
        switch (c1.a)
        {
        default:
            return;

        case 0: // '\0'
            RecyclerView.e(a).a(c1.b, c1.c);
            return;

        case 1: // '\001'
            RecyclerView.e(a).b(c1.b, c1.c);
            return;

        case 2: // '\002'
            RecyclerView.e(a).c(c1.b, c1.c);
            return;

        case 3: // '\003'
            RecyclerView.e(a).d(c1.b, c1.c);
            break;
        }
    }

    public final bi a(int i)
    {
        RecyclerView recyclerview = a;
        int k = recyclerview.c.b();
        for (int j = 0; j < k; j++)
        {
            bi bi1 = RecyclerView.b(recyclerview.c.c(j));
            if (bi1 != null && !bi1.m() && bi1.b == i)
            {
                return bi1;
            }
        }

        return null;
    }

    public final void a(int i, int j)
    {
        a.a(i, j, true);
        a.n = true;
        bf bf1 = a.m;
        bf1.g = bf1.g + j;
    }

    public final void a(c c1)
    {
        c(c1);
    }

    public final void b(int i, int j)
    {
        a.a(i, j, false);
        a.n = true;
    }

    public final void b(c c1)
    {
        c(c1);
    }

    public final void c(int i, int j)
    {
        boolean flag = false;
        Object obj = a;
        int j1 = ((RecyclerView) (obj)).c.b();
        for (int k = 0; k < j1; k++)
        {
            View view = ((RecyclerView) (obj)).c.c(k);
            bi bi2 = RecyclerView.b(view);
            if (bi2 == null || bi2.b() || bi2.b < i || bi2.b >= i + j)
            {
                continue;
            }
            bi2.a(2);
            if (((RecyclerView) (obj)).f())
            {
                bi2.a(64);
            }
            ((av)view.getLayoutParams()).e = true;
        }

        obj = ((RecyclerView) (obj)).a;
        j1 = ((az) (obj)).c.size();
        for (int l = ((flag) ? 1 : 0); l < j1; l++)
        {
            bi bi1 = (bi)((az) (obj)).c.get(l);
            if (bi1 == null)
            {
                continue;
            }
            int i1 = bi1.c();
            if (i1 >= i && i1 < i + j)
            {
                bi1.a(2);
            }
        }

        a.o = true;
    }

    public final void d(int i, int j)
    {
        RecyclerView recyclerview = a;
        int i1 = recyclerview.c.b();
        for (int k = 0; k < i1; k++)
        {
            bi bi1 = RecyclerView.b(recyclerview.c.c(k));
            if (bi1 != null && !bi1.b() && bi1.b >= i)
            {
                bi1.a(j, false);
                recyclerview.m.h = true;
            }
        }

        az az1 = recyclerview.a;
        i1 = az1.c.size();
        for (int l = 0; l < i1; l++)
        {
            bi bi2 = (bi)az1.c.get(l);
            if (bi2 != null && bi2.c() >= i)
            {
                bi2.a(j, true);
            }
        }

        recyclerview.requestLayout();
        a.n = true;
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
            bi bi1 = RecyclerView.b(recyclerview.c.c(i1));
            if (bi1 != null && bi1.b >= l && bi1.b <= k)
            {
                if (bi1.b == i)
                {
                    bi1.a(j - i, false);
                } else
                {
                    bi1.a(byte0, false);
                }
                recyclerview.m.h = true;
            }
            i1++;
        }
        az az1 = recyclerview.a;
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
        j1 = az1.c.size();
        i1 = 0;
        while (i1 < j1) 
        {
            bi bi2 = (bi)az1.c.get(i1);
            if (bi2 != null && bi2.b >= l && bi2.b <= k)
            {
                if (bi2.b == i)
                {
                    bi2.a(j - i, false);
                } else
                {
                    bi2.a(byte0, false);
                }
            }
            i1++;
        }
        recyclerview.requestLayout();
        a.n = true;
    }
}
