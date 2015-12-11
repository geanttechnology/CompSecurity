// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.d;

import com.google.api.a.d.h;
import com.google.api.a.d.m;
import com.google.api.a.d.p;
import com.google.api.a.d.q;
import com.google.api.a.d.r;
import com.google.api.a.d.s;
import com.google.api.a.d.v;
import com.google.api.a.f.a.a.a.a.c;
import java.io.OutputStream;

public final class com.google.api.a.c.d.a
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/google/api/a/c/d/a$a, s1);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("NOT_STARTED", 0);
            b = new a("MEDIA_IN_PROGRESS", 1);
            c = new a("MEDIA_COMPLETE", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s1, int i)
        {
            super(s1, i);
        }
    }


    public boolean a;
    public int b;
    public long c;
    public a d;
    public long e;
    public long f;
    private final q g;
    private final v h;

    public com.google.api.a.c.d.a(v v1, r r)
    {
        a = false;
        b = 0x2000000;
        d = a.a;
        f = -1L;
        h = (v)com.google.api.a.f.a.a.a.a.c.a(v1);
        if (r == null)
        {
            v1 = v1.a(null);
        } else
        {
            v1 = v1.a(r);
        }
        g = v1;
    }

    public final s a(long l, h h1, m m1, OutputStream outputstream)
    {
        h1 = g.a("GET", h1, null);
        if (m1 != null)
        {
            ((p) (h1)).b.putAll(m1);
        }
        if (e != 0L || l != -1L)
        {
            m1 = new StringBuilder();
            m1.append("bytes=").append(e).append("-");
            if (l != -1L)
            {
                m1.append(l);
            }
            ((p) (h1)).b.range = m.a(m1.toString());
        }
        h1 = h1.a();
        com.google.api.a.g.m.a(h1.b(), outputstream, true);
        h1.d();
        return h1;
        m1;
        h1.d();
        throw m1;
    }
}
