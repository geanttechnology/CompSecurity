// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import java.util.List;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            x, o, a, m, 
//            j, e

public class r extends x
{
    private class a extends x.a
    {

        public int a;
        public int b;
        final r c;

        public void a(e e1)
        {
            b(e1);
            try
            {
                e = e1.b();
                a = e1.b();
                b = e1.b();
                f = e1.d();
                g = e1.b();
                h = e1.d();
                i = e1.b();
                j = 0;
                k = e1.d();
                l = e1.b();
                m = e1.d();
                n = e1.b();
                o = e1.d();
                p = e1.b();
                q = e1.d();
                r = e1.b();
                s = e1.f();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (e e1)
            {
                return;
            }
        }

        private a()
        {
            c = r.this;
            super(r.this);
        }

    }

    private static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        private static final b d[];

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/richmedia/r$b, s1);
        }

        public static b[] values()
        {
            return (b[])d.clone();
        }

        static 
        {
            a = new b("Idle", 0);
            b = new b("Press", 1);
            c = new b("Release", 2);
            d = (new b[] {
                a, b, c
            });
        }

        private b(String s1, int i)
        {
            super(s1, i);
        }
    }


    b o;
    long p;
    int q;
    int r;
    o s;
    boolean t;

    public r(o o1)
    {
        super(o1);
        o = b.a;
        p = 0L;
        q = 0;
        r = 0;
        s = null;
        t = false;
    }

    public h.a a(boolean flag)
    {
        if (o == b.b)
        {
            o = b.c;
            s = g.f().b(r);
            p = 0L;
        }
        t = flag;
        return null;
    }

    public o a(x.a a1, long l)
    {
        a a2;
        int i;
        a2 = (a)a1;
        i = a1.e;
        if (o != b.b) goto _L2; else goto _L1
_L1:
        i = a2.a;
_L4:
        return g.f().b(i);
_L2:
        if (o == b.c)
        {
            i = a2.b;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(m m1, long l)
    {
        if (o == b.b)
        {
            p = Math.min(s.c() - 1L, p + l);
        } else
        if (o == b.c)
        {
            p = Math.min(s.c() - 1L, p + l);
            if (p == s.c() - 1L)
            {
                boolean flag = t;
                t = false;
                o = b.a;
                if (flag)
                {
                    m1.b(super.a(h.c.d));
                    m1.b(super.a(h.c.e));
                    return;
                }
            }
        } else
        {
            super.a(m1, l);
            return;
        }
    }

    protected long b(x.a a1, long l)
    {
        if (o == b.b)
        {
            return p;
        }
        if (o == b.c)
        {
            return p;
        } else
        {
            return l % g.f().b(a1.e).c();
        }
    }

    public void b()
    {
        a = 0.0F;
        b = 0.0F;
        o = b.a;
        p = 0L;
        t = false;
        a a1 = (a)f.get(0);
        q = a1.a;
        r = a1.b;
    }

    protected x.a c()
    {
        return new a();
    }

    protected j e()
    {
        return c();
    }

    public boolean k()
    {
        return true;
    }

    public h.a m()
    {
        if (o == b.a)
        {
            o = b.b;
            s = g.f().b(q);
            p = 0L;
        }
        return null;
    }
}
