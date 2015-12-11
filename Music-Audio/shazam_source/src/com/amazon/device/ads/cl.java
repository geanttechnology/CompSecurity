// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package com.amazon.device.ads:
//            co, cn

public class cl
{
    static final class a extends cl
    {

        private final ArrayList c;

        public final void a(ck.a a1)
        {
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).a(a1)) { }
        }

        public final void a(ck.a a1, long l)
        {
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).a(a1, l)) { }
        }

        public final void a(ck.a a1, String s)
        {
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).a(a1, s)) { }
        }

        public final void b(ck.a a1)
        {
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).b(a1)) { }
        }

        public final void b(ck.a a1, long l)
        {
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).b(a1, l)) { }
        }

        public final void c(ck.a a1)
        {
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).c(a1)) { }
        }

        public final void c(ck.a a1, long l)
        {
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((cl)iterator.next()).c(a1, l)) { }
        }

        public a(ArrayList arraylist)
        {
            c = arraylist;
        }
    }

    static class b
    {

        public final ck.a a;

        public b(ck.a a1)
        {
            a = a1;
        }
    }

    static final class c extends b
    {

        public final int b = 1;

        public c(ck.a a1)
        {
            super(a1);
        }
    }

    static final class d extends b
    {

        public final long b;

        public d(ck.a a1, long l)
        {
            super(a1);
            b = l;
        }
    }

    static final class e extends b
    {

        public final long b;

        public e(ck.a a1, long l)
        {
            super(a1);
            b = l;
        }
    }

    static final class f extends b
    {

        public final String b;

        public f(ck.a a1, String s)
        {
            super(a1);
            b = s;
        }
    }

    static final class g extends b
    {

        public final long b;

        public g(ck.a a1, long l)
        {
            super(a1);
            b = l;
        }
    }


    private static final String c = com/amazon/device/ads/cl.getSimpleName();
    protected Vector a;
    String b;
    private final cn d;

    public cl()
    {
        new co();
        d = co.a(c);
        a = new Vector(60);
    }

    public final Vector a()
    {
        return a;
    }

    public void a(ck.a a1)
    {
        d.b((new StringBuilder("METRIC Increment ")).append(a1.toString()).toString(), null);
        a.add(new c(a1));
    }

    public void a(ck.a a1, long l)
    {
        d.b((new StringBuilder("METRIC Publish ")).append(a1.toString()).toString(), null);
        a.add(new g(a1, l));
    }

    public void a(ck.a a1, String s)
    {
        d.b((new StringBuilder("METRIC Set ")).append(a1.toString()).append(": ").append(s).toString(), null);
        a.add(new f(a1, s));
    }

    public void b(ck.a a1)
    {
        b(a1, System.nanoTime());
    }

    public void b(ck.a a1, long l)
    {
        d.b((new StringBuilder("METRIC Start ")).append(a1.toString()).toString(), null);
        l /= 0xf4240L;
        a.add(new d(a1, l));
    }

    public final boolean b()
    {
        return a.isEmpty();
    }

    public void c(ck.a a1)
    {
        c(a1, System.nanoTime());
    }

    public void c(ck.a a1, long l)
    {
        d.b((new StringBuilder("METRIC Stop ")).append(a1.toString()).toString(), null);
        l /= 0xf4240L;
        a.add(new e(a1, l));
    }

}
