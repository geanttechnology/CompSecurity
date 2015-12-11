// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            ar, bi

public abstract class aq
{

    private ArrayList a;
    ar h;
    long i;
    long j;
    long k;
    long l;
    boolean m;

    public aq()
    {
        h = null;
        a = new ArrayList();
        i = 120L;
        j = 120L;
        k = 250L;
        l = 250L;
        m = false;
    }

    public abstract void a();

    public abstract boolean a(bi bi);

    public abstract boolean a(bi bi, int i1, int j1, int k1, int l1);

    public abstract boolean a(bi bi, bi bi1, int i1, int j1, int k1, int l1);

    public abstract boolean b();

    public abstract boolean b(bi bi);

    public abstract void c(bi bi);

    public abstract void d();

    public final void d(bi bi)
    {
        if (h != null)
        {
            h.a(bi);
        }
    }

    public final void e()
    {
        int j1 = a.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            a.get(i1);
        }

        a.clear();
    }

    public final void e(bi bi)
    {
        if (h != null)
        {
            h.c(bi);
        }
    }

    public final void f(bi bi)
    {
        if (h != null)
        {
            h.b(bi);
        }
    }

    public final void g(bi bi)
    {
        if (h != null)
        {
            h.d(bi);
        }
    }
}
