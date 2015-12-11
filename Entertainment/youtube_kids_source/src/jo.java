// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;

final class jo extends im
{

    private final String a;
    private boolean b;
    private int c;
    private int d;
    private jl e;
    private int f;
    private jk g;

    public jo(jk jk1, String s)
    {
        g = jk1;
        super();
        c = -1;
        a = s;
    }

    public final void a()
    {
        jk.a(g, this);
    }

    public final void a(int i)
    {
        if (e != null)
        {
            e.a(f, i);
            return;
        } else
        {
            c = i;
            d = 0;
            return;
        }
    }

    public final void a(jl jl1)
    {
        e = jl1;
        String s = a;
        int i = jl1.d;
        jl1.d = i + 1;
        Bundle bundle = new Bundle();
        bundle.putString("routeId", s);
        int j = jl1.c;
        jl1.c = j + 1;
        jl1.a(3, j, i, null, bundle);
        f = i;
        if (b)
        {
            jl1.a(f);
            if (c >= 0)
            {
                jl1.a(f, c);
                c = -1;
            }
            if (d != 0)
            {
                jl1.b(f, d);
                d = 0;
            }
        }
    }

    public final void b()
    {
        b = true;
        if (e != null)
        {
            e.a(f);
        }
    }

    public final void b(int i)
    {
        if (e != null)
        {
            e.b(f, i);
            return;
        } else
        {
            d = d + i;
            return;
        }
    }

    public final void c()
    {
        b = false;
        if (e != null)
        {
            jl jl1 = e;
            int i = f;
            int j = jl1.c;
            jl1.c = j + 1;
            jl1.a(6, j, i, null, null);
        }
    }

    public final void d()
    {
        if (e != null)
        {
            jl jl1 = e;
            int i = f;
            int j = jl1.c;
            jl1.c = j + 1;
            jl1.a(4, j, i, null, null);
            e = null;
            f = 0;
        }
    }
}
