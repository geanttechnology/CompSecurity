// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import java.util.List;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            x, o, a, m, 
//            j, e

public class t extends x
{
    private class a extends x.a
    {

        public int a;
        public int b;
        public int c;
        final t d;

        public void a(e e1)
        {
            b(e1);
            try
            {
                e = e1.b();
                a = e1.b();
                c = e1.b();
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
            d = t.this;
            super(t.this);
        }

    }

    private static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        private static final b e[];

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/richmedia/t$b, s1);
        }

        public static b[] values()
        {
            return (b[])e.clone();
        }

        static 
        {
            a = new b("Idle", 0);
            b = new b("Hover", 1);
            c = new b("Cancel", 2);
            d = new b("Drop", 3);
            e = (new b[] {
                a, b, c, d
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
    int s;
    o t;

    public t(o o1)
    {
        super(o1);
        o = b.a;
        p = 0L;
        q = 0;
        r = 0;
        s = 0;
        t = null;
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
        } else
        if (o == b.d)
        {
            i = a2.c;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(m m1, long l)
    {
        if (o != b.b) goto _L2; else goto _L1
_L1:
        p = Math.min(t.c() - 1L, p + l);
        if (p == t.c() - 1L)
        {
            m1.b(super.a(h.c.j));
        }
_L4:
        return;
_L2:
        if (o != b.c)
        {
            break; /* Loop/switch isn't completed */
        }
        p = Math.min(t.c() - 1L, p + l);
        if (p == t.c() - 1L)
        {
            o = b.a;
            m1.b(super.a(h.c.l));
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (o == b.d)
        {
            p = Math.min(t.c() - 1L, p + l);
            if (p == t.c() - 1L)
            {
                o = b.a;
                m1.b(super.a(h.c.k));
                return;
            }
        } else
        {
            super.a(m1, l);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
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
        }
        if (o == b.d)
        {
            return p;
        } else
        {
            return l % g.f().b(a1.e).c();
        }
    }

    public h.a b(boolean flag)
    {
        if (o != b.a && o != b.c || !flag) goto _L2; else goto _L1
_L1:
        o = b.b;
        t = g.f().b(q);
        p = 0L;
_L4:
        return null;
_L2:
        if (o == b.b && !flag)
        {
            o = b.c;
            t = g.f().b(r);
            p = 0L;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void b()
    {
        a = 0.0F;
        b = 0.0F;
        o = b.a;
        p = 0L;
        a a1 = (a)f.get(0);
        q = a1.a;
        r = a1.b;
        s = a1.c;
    }

    public h.a c(boolean flag)
    {
        if (o == b.b)
        {
            if (flag)
            {
                o = b.d;
                t = g.f().b(s);
                p = 0L;
            } else
            {
                o = b.c;
                t = g.f().b(r);
                p = 0L;
            }
        }
        return null;
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
}
