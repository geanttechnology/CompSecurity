// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import java.util.ArrayList;
import java.util.List;

public final class u
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/rhythmnewmedia/sdk/u$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("image", 0);
            b = new a("html", 1);
            c = new a("video", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i1)
        {
            super(s, i1);
        }
    }


    public static int a = 5000;
    public static int b = 0x80000000;
    public static int c = 5000;
    public static int d = 2000;
    public static int e = 5000;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private int l;
    private int m;
    private a n;
    private final List o = new ArrayList();
    private final List p = new ArrayList();
    private int q;

    public u()
    {
        k = a;
        l = b;
        m = e;
    }

    public final String a()
    {
        return f;
    }

    public final void a(int i1)
    {
        k = i1;
    }

    public final void a(a a1)
    {
        n = a1;
    }

    public final void a(String s)
    {
        f = s;
    }

    public final void a(String s, boolean flag)
    {
        if (s != null && s.length() > 0)
        {
            List list = o;
            s = s.trim();
            boolean flag1;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            list.add(new a.e(s, flag1, flag));
        }
    }

    public final String b()
    {
        return g;
    }

    public final void b(int i1)
    {
        l = i1;
    }

    public final void b(String s)
    {
        g = s;
    }

    public final void b(String s, boolean flag)
    {
        if (s != null && s.length() > 0)
        {
            List list = p;
            s = s.trim();
            boolean flag1;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            list.add(new a.e(s, flag1, flag));
        }
    }

    public final String c()
    {
        return h;
    }

    public final void c(int i1)
    {
        m = i1;
    }

    public final void c(String s)
    {
        h = s;
    }

    public final String d()
    {
        return i;
    }

    public final void d(int i1)
    {
        q = i1;
    }

    public final void d(String s)
    {
        i = s;
    }

    public final String e()
    {
        return j;
    }

    public final void e(String s)
    {
        j = s;
    }

    public final int f()
    {
        return k;
    }

    public final int g()
    {
        return l;
    }

    public final int h()
    {
        return m;
    }

    public final a i()
    {
        return n;
    }

    public final Iterable j()
    {
        return o;
    }

    public final int k()
    {
        return o.size();
    }

    public final Iterable l()
    {
        return p;
    }

    public final int m()
    {
        return p.size();
    }

    public final int n()
    {
        return q;
    }

}
