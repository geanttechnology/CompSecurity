// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;


// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            ab, o, a, p, 
//            j, e

public class s extends ab
{
    private class a extends ab.a
    {

        public int a;
        public int b;
        public int c;
        final s d;

        public void a(e e1)
        {
            b(e1);
            try
            {
                e = e1.b();
                a = e1.b();
                b = e1.b();
                c = e1.a();
                f = e1.b();
                g = e1.b();
                h = e1.d();
                i = e1.b();
                j = e1.d();
                k = e1.b();
                l = e1.d();
                m = e1.b();
                n = e1.d();
                o = e1.b();
                p = e1.d();
                q = e1.b();
                r = e1.d();
                s = e1.b();
                t = e1.d();
                u = e1.b();
                v = e1.d();
                w = e1.b();
                x = e1.d();
                y = e1.b();
                z = e1.f();
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
            d = s.this;
            super(s.this);
        }

    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        private static final b e[];

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/richmedia/s$b, s1);
        }

        public static b[] values()
        {
            return (b[])e.clone();
        }

        static 
        {
            a = new b("VideoRemaining", 0);
            b = new b("VideoElapsed", 1);
            c = new b("SceneRemaining", 2);
            d = new b("SceneElapsed", 3);
            e = (new b[] {
                a, b, c, d
            });
        }

        private b(String s1, int i)
        {
            super(s1, i);
        }
    }


    public s(o o1)
    {
        super(o1);
    }

    private String a(long l, long l1, int i)
    {
        float f = (float)l / 1000F;
        if ((double)f < 0.10000000000000001D)
        {
            return "0";
        } else
        {
            return Integer.toString((int)Math.ceil(f) + i);
        }
    }

    protected String a(p p1, ab.a a1, long l)
    {
        String s1;
        Object obj;
        a a2;
        b b1;
        m.a a3;
        if (p != null)
        {
            return p;
        }
        obj = g.f();
        a2 = (a)a1;
        s1 = ((com.tremorvideo.sdk.android.richmedia.a) (obj)).a(a2.e);
        obj = ((com.tremorvideo.sdk.android.richmedia.a) (obj)).a(a2.a);
        a1 = "##";
        b1 = b.values()[a2.b];
        a3 = p1.b();
        if (b1 != b.d) goto _L2; else goto _L1
_L1:
        p1 = a(l, g.c(), a2.c);
_L4:
        return (new StringBuilder()).append(s1).append(p1).append(((String) (obj))).toString();
_L2:
        if (b1 == b.c)
        {
            p1 = a(g.c() - l, g.c(), a2.c);
        } else
        if (b1 == b.a)
        {
            p1 = a1;
            if (a3 != null)
            {
                int i = a3.b();
                int k = a3.a();
                if (i != -1 && k != -1)
                {
                    p1 = a(i - k, i, a2.c);
                } else
                {
                    p1 = a(0L, 0L, a2.c);
                }
            }
        } else
        {
            p1 = a1;
            if (b1 == b.b)
            {
                p1 = a1;
                if (a3 != null)
                {
                    int j = a3.b();
                    int i1 = a3.a();
                    if (j != -1 && i1 != -1)
                    {
                        p1 = a(i1, j, a2.c);
                    } else
                    {
                        p1 = a(0L, 0L, a2.c);
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(p p1, long l)
    {
        super.a(p1, l);
    }

    protected ab.a c()
    {
        return new a();
    }

    protected j e()
    {
        return c();
    }
}
