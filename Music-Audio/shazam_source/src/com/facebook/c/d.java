// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.c;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.facebook.c:
//            e, b, f

public final class d
{
    private static final class a
    {

        public double a;
        double b;

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }


    private static int m = 0;
    e a;
    public boolean b;
    public final String c;
    public final a d = new a((byte)0);
    final a e = new a((byte)0);
    final a f = new a((byte)0);
    double g;
    double h;
    boolean i;
    public CopyOnWriteArraySet j;
    double k;
    public final b l;
    private double n;
    private double o;

    d(b b1)
    {
        i = true;
        n = 0.0050000000000000001D;
        o = 0.0050000000000000001D;
        j = new CopyOnWriteArraySet();
        k = 0.0D;
        if (b1 == null)
        {
            throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
        } else
        {
            l = b1;
            b1 = new StringBuilder("spring:");
            int i1 = m;
            m = i1 + 1;
            c = b1.append(i1).toString();
            a(e.c);
            return;
        }
    }

    public final d a(double d1)
    {
        g = d1;
        d.a = d1;
        l.a(c);
        for (Iterator iterator = j.iterator(); iterator.hasNext(); ((f)iterator.next()).a(this)) { }
        h = d.a;
        f.a = d.a;
        d.b = 0.0D;
        return this;
    }

    public final d a(e e1)
    {
        if (e1 == null)
        {
            throw new IllegalArgumentException("springConfig is required");
        } else
        {
            a = e1;
            return this;
        }
    }

    public final d a(f f1)
    {
        j.add(f1);
        return this;
    }

    public final boolean a()
    {
        if (Math.abs(d.b) <= n)
        {
            a a1 = d;
            if (Math.abs(h - a1.a) <= o || a.b == 0.0D)
            {
                return true;
            }
        }
        return false;
    }

    public final d b(double d1)
    {
        if (h != d1 || !a())
        {
            g = d.a;
            h = d1;
            l.a(c);
            Iterator iterator = j.iterator();
            while (iterator.hasNext()) 
            {
                iterator.next();
            }
        }
        return this;
    }

}
