// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xv, xu, xz, ye

public interface lu
{
    public static final class a extends xv
    {

        public int a;
        public int b;
        public int c;

        public a a()
        {
            a = 1;
            b = 0;
            c = 0;
            r = null;
            s = -1;
            return this;
        }

        public void a(xu xu1)
            throws IOException
        {
            if (a != 1)
            {
                xu1.a(1, a);
            }
            if (b != 0)
            {
                xu1.a(2, b);
            }
            if (c != 0)
            {
                xu1.a(3, c);
            }
            super.a(xu1);
        }

        protected int b()
        {
            int k = super.b();
            int j = k;
            if (a != 1)
            {
                j = k + xu.b(1, a);
            }
            k = j;
            if (b != 0)
            {
                k = j + xu.b(2, b);
            }
            j = k;
            if (c != 0)
            {
                j = k + xu.b(3, c);
            }
            return j;
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag;
            if (obj == this)
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (obj instanceof a)
                {
                    obj = (a)obj;
                    flag = flag1;
                    if (a == ((a) (obj)).a)
                    {
                        flag = flag1;
                        if (b == ((a) (obj)).b)
                        {
                            flag = flag1;
                            if (c == ((a) (obj)).c)
                            {
                                return a(((xv) (obj)));
                            }
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return (((a + 527) * 31 + b) * 31 + c) * 31 + d();
        }

        public a()
        {
            a();
        }
    }

    public static final class b extends xv
    {

        private static volatile b f[];
        public int a[];
        public int b;
        public int c;
        public boolean d;
        public boolean e;

        public static b[] a()
        {
            if (f == null)
            {
                synchronized (xz.a)
                {
                    if (f == null)
                    {
                        f = new b[0];
                    }
                }
            }
            return f;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(xu xu1)
            throws IOException
        {
            if (e)
            {
                xu1.a(1, e);
            }
            xu1.a(2, b);
            if (a != null && a.length > 0)
            {
                for (int j = 0; j < a.length; j++)
                {
                    xu1.a(3, a[j]);
                }

            }
            if (c != 0)
            {
                xu1.a(4, c);
            }
            if (d)
            {
                xu1.a(6, d);
            }
            super.a(xu1);
        }

        protected int b()
        {
            int k = 0;
            int l = super.b();
            int j = l;
            if (e)
            {
                j = l + xu.b(1, e);
            }
            l = xu.b(2, b) + j;
            if (a != null && a.length > 0)
            {
                for (j = 0; j < a.length; j++)
                {
                    k += xu.b(a[j]);
                }

                k = l + k + a.length * 1;
            } else
            {
                k = l;
            }
            j = k;
            if (c != 0)
            {
                j = k + xu.b(4, c);
            }
            k = j;
            if (d)
            {
                k = j + xu.b(6, d);
            }
            return k;
        }

        public b c()
        {
            a = ye.a;
            b = 0;
            c = 0;
            d = false;
            e = false;
            r = null;
            s = -1;
            return this;
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag;
            if (obj == this)
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (obj instanceof b)
                {
                    obj = (b)obj;
                    flag = flag1;
                    if (xz.a(a, ((b) (obj)).a))
                    {
                        flag = flag1;
                        if (b == ((b) (obj)).b)
                        {
                            flag = flag1;
                            if (c == ((b) (obj)).c)
                            {
                                flag = flag1;
                                if (d == ((b) (obj)).d)
                                {
                                    flag = flag1;
                                    if (e == ((b) (obj)).e)
                                    {
                                        return a(((xv) (obj)));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            char c2 = '\u04CF';
            int j = xz.a(a);
            int k = b;
            int l = c;
            char c1;
            if (d)
            {
                c1 = '\u04CF';
            } else
            {
                c1 = '\u04D5';
            }
            if (!e)
            {
                c2 = '\u04D5';
            }
            return ((c1 + (((j + 527) * 31 + k) * 31 + l) * 31) * 31 + c2) * 31 + d();
        }

        public b()
        {
            c();
        }
    }

    public static final class c extends xv
    {

        private static volatile c f[];
        public String a;
        public long b;
        public long c;
        public boolean d;
        public long e;

        public static c[] a()
        {
            if (f == null)
            {
                synchronized (xz.a)
                {
                    if (f == null)
                    {
                        f = new c[0];
                    }
                }
            }
            return f;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(xu xu1)
            throws IOException
        {
            if (!a.equals(""))
            {
                xu1.a(1, a);
            }
            if (b != 0L)
            {
                xu1.a(2, b);
            }
            if (c != 0x7fffffffL)
            {
                xu1.a(3, c);
            }
            if (d)
            {
                xu1.a(4, d);
            }
            if (e != 0L)
            {
                xu1.a(5, e);
            }
            super.a(xu1);
        }

        protected int b()
        {
            int k = super.b();
            int j = k;
            if (!a.equals(""))
            {
                j = k + xu.b(1, a);
            }
            k = j;
            if (b != 0L)
            {
                k = j + xu.b(2, b);
            }
            j = k;
            if (c != 0x7fffffffL)
            {
                j = k + xu.b(3, c);
            }
            k = j;
            if (d)
            {
                k = j + xu.b(4, d);
            }
            j = k;
            if (e != 0L)
            {
                j = k + xu.b(5, e);
            }
            return j;
        }

        public c c()
        {
            a = "";
            b = 0L;
            c = 0x7fffffffL;
            d = false;
            e = 0L;
            r = null;
            s = -1;
            return this;
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            if (obj != this) goto _L2; else goto _L1
_L1:
            boolean flag = true;
_L4:
            return flag;
_L2:
            flag = flag1;
            if (!(obj instanceof c))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (c)obj;
            if (a != null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (((c) (obj)).a != null)
            {
                continue; /* Loop/switch isn't completed */
            }
_L5:
            flag = flag1;
            if (b == ((c) (obj)).b)
            {
                flag = flag1;
                if (c == ((c) (obj)).c)
                {
                    flag = flag1;
                    if (d == ((c) (obj)).d)
                    {
                        flag = flag1;
                        if (e == ((c) (obj)).e)
                        {
                            return a(((xv) (obj)));
                        }
                    }
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (!a.equals(((c) (obj)).a))
            {
                return false;
            }
              goto _L5
            if (true) goto _L4; else goto _L6
_L6:
        }

        public int hashCode()
        {
            int j;
            char c1;
            int k;
            int l;
            if (a == null)
            {
                j = 0;
            } else
            {
                j = a.hashCode();
            }
            k = (int)(b ^ b >>> 32);
            l = (int)(c ^ c >>> 32);
            if (d)
            {
                c1 = '\u04CF';
            } else
            {
                c1 = '\u04D5';
            }
            return ((c1 + (((j + 527) * 31 + k) * 31 + l) * 31) * 31 + (int)(e ^ e >>> 32)) * 31 + d();
        }

        public c()
        {
            c();
        }
    }

    public static final class d extends xv
    {

        public lv.a a[];
        public lv.a b[];
        public c c[];

        public d a()
        {
            a = lv.a.a();
            b = lv.a.a();
            c = c.a();
            r = null;
            s = -1;
            return this;
        }

        public void a(xu xu1)
            throws IOException
        {
            boolean flag = false;
            if (a != null && a.length > 0)
            {
                for (int j = 0; j < a.length; j++)
                {
                    lv.a a1 = a[j];
                    if (a1 != null)
                    {
                        xu1.a(1, a1);
                    }
                }

            }
            if (b != null && b.length > 0)
            {
                for (int k = 0; k < b.length; k++)
                {
                    lv.a a2 = b[k];
                    if (a2 != null)
                    {
                        xu1.a(2, a2);
                    }
                }

            }
            if (c != null && c.length > 0)
            {
                for (int l = ((flag) ? 1 : 0); l < c.length; l++)
                {
                    c c1 = c[l];
                    if (c1 != null)
                    {
                        xu1.a(3, c1);
                    }
                }

            }
            super.a(xu1);
        }

        protected int b()
        {
            boolean flag = false;
            int j = super.b();
            int k = j;
            if (a != null)
            {
                k = j;
                if (a.length > 0)
                {
                    for (k = 0; k < a.length;)
                    {
                        lv.a a1 = a[k];
                        int j1 = j;
                        if (a1 != null)
                        {
                            j1 = j + xu.c(1, a1);
                        }
                        k++;
                        j = j1;
                    }

                    k = j;
                }
            }
            j = k;
            if (b != null)
            {
                j = k;
                if (b.length > 0)
                {
                    j = k;
                    for (int l = 0; l < b.length;)
                    {
                        lv.a a2 = b[l];
                        int k1 = j;
                        if (a2 != null)
                        {
                            k1 = j + xu.c(2, a2);
                        }
                        l++;
                        j = k1;
                    }

                }
            }
            int l1 = j;
            if (c != null)
            {
                l1 = j;
                if (c.length > 0)
                {
                    int i1 = ((flag) ? 1 : 0);
                    do
                    {
                        l1 = j;
                        if (i1 >= c.length)
                        {
                            break;
                        }
                        c c1 = c[i1];
                        l1 = j;
                        if (c1 != null)
                        {
                            l1 = j + xu.c(3, c1);
                        }
                        i1++;
                        j = l1;
                    } while (true);
                }
            }
            return l1;
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag;
            if (obj == this)
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (obj instanceof d)
                {
                    obj = (d)obj;
                    flag = flag1;
                    if (xz.a(a, ((d) (obj)).a))
                    {
                        flag = flag1;
                        if (xz.a(b, ((d) (obj)).b))
                        {
                            flag = flag1;
                            if (xz.a(c, ((d) (obj)).c))
                            {
                                return a(((xv) (obj)));
                            }
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return (((xz.a(a) + 527) * 31 + xz.a(b)) * 31 + xz.a(c)) * 31 + d();
        }

        public d()
        {
            a();
        }
    }

    public static final class e extends xv
    {

        private static volatile e c[];
        public int a;
        public int b;

        public static e[] a()
        {
            if (c == null)
            {
                synchronized (xz.a)
                {
                    if (c == null)
                    {
                        c = new e[0];
                    }
                }
            }
            return c;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(xu xu1)
            throws IOException
        {
            xu1.a(1, a);
            xu1.a(2, b);
            super.a(xu1);
        }

        protected int b()
        {
            return super.b() + xu.b(1, a) + xu.b(2, b);
        }

        public e c()
        {
            a = 0;
            b = 0;
            r = null;
            s = -1;
            return this;
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag;
            if (obj == this)
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (obj instanceof e)
                {
                    obj = (e)obj;
                    flag = flag1;
                    if (a == ((e) (obj)).a)
                    {
                        flag = flag1;
                        if (b == ((e) (obj)).b)
                        {
                            return a(((xv) (obj)));
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return ((a + 527) * 31 + b) * 31 + d();
        }

        public e()
        {
            c();
        }
    }

    public static final class f extends xv
    {

        public String a[];
        public String b[];
        public lv.a c[];
        public e d[];
        public b e[];
        public b f[];
        public b g[];
        public g h[];
        public String i;
        public String j;
        public String k;
        public String l;
        public a m;
        public float n;
        public boolean o;
        public String p[];
        public int q;

        public f a()
        {
            a = ye.f;
            b = ye.f;
            c = lv.a.a();
            d = e.a();
            e = b.a();
            f = b.a();
            g = b.a();
            h = g.a();
            i = "";
            j = "";
            k = "0";
            l = "";
            m = null;
            n = 0.0F;
            o = false;
            p = ye.f;
            q = 0;
            r = null;
            s = -1;
            return this;
        }

        public void a(xu xu1)
            throws IOException
        {
            boolean flag = false;
            if (b != null && b.length > 0)
            {
                for (int i1 = 0; i1 < b.length; i1++)
                {
                    String s = b[i1];
                    if (s != null)
                    {
                        xu1.a(1, s);
                    }
                }

            }
            if (c != null && c.length > 0)
            {
                for (int j1 = 0; j1 < c.length; j1++)
                {
                    lv.a a1 = c[j1];
                    if (a1 != null)
                    {
                        xu1.a(2, a1);
                    }
                }

            }
            if (d != null && d.length > 0)
            {
                for (int k1 = 0; k1 < d.length; k1++)
                {
                    e e1 = d[k1];
                    if (e1 != null)
                    {
                        xu1.a(3, e1);
                    }
                }

            }
            if (e != null && e.length > 0)
            {
                for (int l1 = 0; l1 < e.length; l1++)
                {
                    b b1 = e[l1];
                    if (b1 != null)
                    {
                        xu1.a(4, b1);
                    }
                }

            }
            if (f != null && f.length > 0)
            {
                for (int i2 = 0; i2 < f.length; i2++)
                {
                    b b2 = f[i2];
                    if (b2 != null)
                    {
                        xu1.a(5, b2);
                    }
                }

            }
            if (g != null && g.length > 0)
            {
                for (int j2 = 0; j2 < g.length; j2++)
                {
                    b b3 = g[j2];
                    if (b3 != null)
                    {
                        xu1.a(6, b3);
                    }
                }

            }
            if (h != null && h.length > 0)
            {
                for (int k2 = 0; k2 < h.length; k2++)
                {
                    g g1 = h[k2];
                    if (g1 != null)
                    {
                        xu1.a(7, g1);
                    }
                }

            }
            if (!i.equals(""))
            {
                xu1.a(9, i);
            }
            if (!j.equals(""))
            {
                xu1.a(10, j);
            }
            if (!k.equals("0"))
            {
                xu1.a(12, k);
            }
            if (!l.equals(""))
            {
                xu1.a(13, l);
            }
            if (m != null)
            {
                xu1.a(14, m);
            }
            if (Float.floatToIntBits(n) != Float.floatToIntBits(0.0F))
            {
                xu1.a(15, n);
            }
            if (p != null && p.length > 0)
            {
                for (int l2 = 0; l2 < p.length; l2++)
                {
                    String s1 = p[l2];
                    if (s1 != null)
                    {
                        xu1.a(16, s1);
                    }
                }

            }
            if (q != 0)
            {
                xu1.a(17, q);
            }
            if (o)
            {
                xu1.a(18, o);
            }
            if (a != null && a.length > 0)
            {
                for (int i3 = ((flag) ? 1 : 0); i3 < a.length; i3++)
                {
                    String s2 = a[i3];
                    if (s2 != null)
                    {
                        xu1.a(19, s2);
                    }
                }

            }
            super.a(xu1);
        }

        protected int b()
        {
            boolean flag = false;
            int k5 = super.b();
            int j1;
            int k1;
            int k3;
            if (b != null && b.length > 0)
            {
                int i1 = 0;
                k1 = 0;
                int l1;
                int i4;
                for (l1 = 0; i1 < b.length; l1 = i4)
                {
                    String s = b[i1];
                    int l4 = k1;
                    i4 = l1;
                    if (s != null)
                    {
                        i4 = l1 + 1;
                        l4 = k1 + xu.b(s);
                    }
                    i1++;
                    k1 = l4;
                }

                k1 = k5 + k1 + l1 * 1;
            } else
            {
                k1 = k5;
            }
            j1 = k1;
            if (c != null)
            {
                j1 = k1;
                if (c.length > 0)
                {
                    j1 = k1;
                    for (k1 = 0; k1 < c.length;)
                    {
                        lv.a a1 = c[k1];
                        int i2 = j1;
                        if (a1 != null)
                        {
                            i2 = j1 + xu.c(2, a1);
                        }
                        k1++;
                        j1 = i2;
                    }

                }
            }
            k1 = j1;
            if (d != null)
            {
                k1 = j1;
                if (d.length > 0)
                {
                    for (k1 = 0; k1 < d.length;)
                    {
                        e e1 = d[k1];
                        int j2 = j1;
                        if (e1 != null)
                        {
                            j2 = j1 + xu.c(3, e1);
                        }
                        k1++;
                        j1 = j2;
                    }

                    k1 = j1;
                }
            }
            j1 = k1;
            if (e != null)
            {
                j1 = k1;
                if (e.length > 0)
                {
                    j1 = k1;
                    for (k1 = 0; k1 < e.length;)
                    {
                        b b1 = e[k1];
                        int k2 = j1;
                        if (b1 != null)
                        {
                            k2 = j1 + xu.c(4, b1);
                        }
                        k1++;
                        j1 = k2;
                    }

                }
            }
            k1 = j1;
            if (f != null)
            {
                k1 = j1;
                if (f.length > 0)
                {
                    for (k1 = 0; k1 < f.length;)
                    {
                        b b2 = f[k1];
                        int l2 = j1;
                        if (b2 != null)
                        {
                            l2 = j1 + xu.c(5, b2);
                        }
                        k1++;
                        j1 = l2;
                    }

                    k1 = j1;
                }
            }
            j1 = k1;
            if (g != null)
            {
                j1 = k1;
                if (g.length > 0)
                {
                    j1 = k1;
                    for (k1 = 0; k1 < g.length;)
                    {
                        b b3 = g[k1];
                        int i3 = j1;
                        if (b3 != null)
                        {
                            i3 = j1 + xu.c(6, b3);
                        }
                        k1++;
                        j1 = i3;
                    }

                }
            }
            k1 = j1;
            if (h != null)
            {
                k1 = j1;
                if (h.length > 0)
                {
                    for (k1 = 0; k1 < h.length;)
                    {
                        g g1 = h[k1];
                        int j3 = j1;
                        if (g1 != null)
                        {
                            j3 = j1 + xu.c(7, g1);
                        }
                        k1++;
                        j1 = j3;
                    }

                    k1 = j1;
                }
            }
            j1 = k1;
            if (!i.equals(""))
            {
                j1 = k1 + xu.b(9, i);
            }
            k1 = j1;
            if (!j.equals(""))
            {
                k1 = j1 + xu.b(10, j);
            }
            j1 = k1;
            if (!k.equals("0"))
            {
                j1 = k1 + xu.b(12, k);
            }
            k1 = j1;
            if (!l.equals(""))
            {
                k1 = j1 + xu.b(13, l);
            }
            k3 = k1;
            if (m != null)
            {
                k3 = k1 + xu.c(14, m);
            }
            j1 = k3;
            if (Float.floatToIntBits(n) != Float.floatToIntBits(0.0F))
            {
                j1 = k3 + xu.b(15, n);
            }
            k1 = j1;
            if (p != null)
            {
                k1 = j1;
                if (p.length > 0)
                {
                    k1 = 0;
                    k3 = 0;
                    int j4;
                    int i5;
                    for (j4 = 0; k1 < p.length; j4 = i5)
                    {
                        String s1 = p[k1];
                        k5 = k3;
                        i5 = j4;
                        if (s1 != null)
                        {
                            i5 = j4 + 1;
                            k5 = k3 + xu.b(s1);
                        }
                        k1++;
                        k3 = k5;
                    }

                    k1 = j1 + k3 + j4 * 2;
                }
            }
            k3 = k1;
            if (q != 0)
            {
                k3 = k1 + xu.b(17, q);
            }
            j1 = k3;
            if (o)
            {
                j1 = k3 + xu.b(18, o);
            }
            k1 = j1;
            if (a != null)
            {
                k1 = j1;
                if (a.length > 0)
                {
                    int l3 = 0;
                    int k4 = 0;
                    for (k1 = ((flag) ? 1 : 0); k1 < a.length;)
                    {
                        String s2 = a[k1];
                        k5 = l3;
                        int j5 = k4;
                        if (s2 != null)
                        {
                            j5 = k4 + 1;
                            k5 = l3 + xu.b(s2);
                        }
                        k1++;
                        l3 = k5;
                        k4 = j5;
                    }

                    k1 = j1 + l3 + k4 * 2;
                }
            }
            return k1;
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            if (obj != this) goto _L2; else goto _L1
_L1:
            boolean flag = true;
_L4:
            return flag;
_L2:
            flag = flag1;
            if (!(obj instanceof f)) goto _L4; else goto _L3
_L3:
            obj = (f)obj;
            flag = flag1;
            if (!xz.a(a, ((f) (obj)).a)) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (!xz.a(b, ((f) (obj)).b)) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (!xz.a(c, ((f) (obj)).c)) goto _L4; else goto _L7
_L7:
            flag = flag1;
            if (!xz.a(d, ((f) (obj)).d)) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (!xz.a(e, ((f) (obj)).e)) goto _L4; else goto _L9
_L9:
            flag = flag1;
            if (!xz.a(f, ((f) (obj)).f)) goto _L4; else goto _L10
_L10:
            flag = flag1;
            if (!xz.a(g, ((f) (obj)).g)) goto _L4; else goto _L11
_L11:
            flag = flag1;
            if (!xz.a(h, ((f) (obj)).h)) goto _L4; else goto _L12
_L12:
            if (i != null) goto _L14; else goto _L13
_L13:
            flag = flag1;
            if (((f) (obj)).i != null) goto _L4; else goto _L15
_L15:
            if (j != null) goto _L17; else goto _L16
_L16:
            flag = flag1;
            if (((f) (obj)).j != null) goto _L4; else goto _L18
_L18:
            if (k != null) goto _L20; else goto _L19
_L19:
            flag = flag1;
            if (((f) (obj)).k != null) goto _L4; else goto _L21
_L21:
            if (l != null) goto _L23; else goto _L22
_L22:
            flag = flag1;
            if (((f) (obj)).l != null) goto _L4; else goto _L24
_L24:
            if (m != null)
            {
                break MISSING_BLOCK_LABEL_364;
            }
            flag = flag1;
            if (((f) (obj)).m != null) goto _L4; else goto _L25
_L25:
            flag = flag1;
            if (Float.floatToIntBits(n) == Float.floatToIntBits(((f) (obj)).n))
            {
                flag = flag1;
                if (o == ((f) (obj)).o)
                {
                    flag = flag1;
                    if (xz.a(p, ((f) (obj)).p))
                    {
                        flag = flag1;
                        if (q == ((f) (obj)).q)
                        {
                            return a(((xv) (obj)));
                        }
                    }
                }
            }
              goto _L4
_L14:
            if (!i.equals(((f) (obj)).i))
            {
                return false;
            }
              goto _L15
_L17:
            if (!j.equals(((f) (obj)).j))
            {
                return false;
            }
              goto _L18
_L20:
            if (!k.equals(((f) (obj)).k))
            {
                return false;
            }
              goto _L21
_L23:
            if (!l.equals(((f) (obj)).l))
            {
                return false;
            }
              goto _L24
            if (!m.equals(((f) (obj)).m))
            {
                return false;
            }
              goto _L25
        }

        public int hashCode()
        {
            int i2 = 0;
            int j2 = xz.a(a);
            int k2 = xz.a(b);
            int l2 = xz.a(c);
            int i3 = xz.a(d);
            int j3 = xz.a(e);
            int k3 = xz.a(f);
            int l3 = xz.a(g);
            int i4 = xz.a(h);
            int i1;
            int j1;
            int k1;
            int l1;
            char c1;
            int j4;
            if (i == null)
            {
                i1 = 0;
            } else
            {
                i1 = i.hashCode();
            }
            if (j == null)
            {
                j1 = 0;
            } else
            {
                j1 = j.hashCode();
            }
            if (k == null)
            {
                k1 = 0;
            } else
            {
                k1 = k.hashCode();
            }
            if (l == null)
            {
                l1 = 0;
            } else
            {
                l1 = l.hashCode();
            }
            if (m != null)
            {
                i2 = m.hashCode();
            }
            j4 = Float.floatToIntBits(n);
            if (o)
            {
                c1 = '\u04CF';
            } else
            {
                c1 = '\u04D5';
            }
            return (((c1 + (((l1 + (k1 + (j1 + (i1 + ((((((((j2 + 527) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31 + l3) * 31 + i4) * 31) * 31) * 31) * 31) * 31 + i2) * 31 + j4) * 31) * 31 + xz.a(p)) * 31 + q) * 31 + d();
        }

        public f()
        {
            a();
        }
    }

    public static final class g extends xv
    {

        private static volatile g k[];
        public int a[];
        public int b[];
        public int c[];
        public int d[];
        public int e[];
        public int f[];
        public int g[];
        public int h[];
        public int i[];
        public int j[];

        public static g[] a()
        {
            if (k == null)
            {
                synchronized (xz.a)
                {
                    if (k == null)
                    {
                        k = new g[0];
                    }
                }
            }
            return k;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(xu xu1)
            throws IOException
        {
            boolean flag = false;
            if (a != null && a.length > 0)
            {
                for (int l = 0; l < a.length; l++)
                {
                    xu1.a(1, a[l]);
                }

            }
            if (b != null && b.length > 0)
            {
                for (int i1 = 0; i1 < b.length; i1++)
                {
                    xu1.a(2, b[i1]);
                }

            }
            if (c != null && c.length > 0)
            {
                for (int j1 = 0; j1 < c.length; j1++)
                {
                    xu1.a(3, c[j1]);
                }

            }
            if (d != null && d.length > 0)
            {
                for (int k1 = 0; k1 < d.length; k1++)
                {
                    xu1.a(4, d[k1]);
                }

            }
            if (e != null && e.length > 0)
            {
                for (int l1 = 0; l1 < e.length; l1++)
                {
                    xu1.a(5, e[l1]);
                }

            }
            if (f != null && f.length > 0)
            {
                for (int i2 = 0; i2 < f.length; i2++)
                {
                    xu1.a(6, f[i2]);
                }

            }
            if (g != null && g.length > 0)
            {
                for (int j2 = 0; j2 < g.length; j2++)
                {
                    xu1.a(7, g[j2]);
                }

            }
            if (h != null && h.length > 0)
            {
                for (int k2 = 0; k2 < h.length; k2++)
                {
                    xu1.a(8, h[k2]);
                }

            }
            if (i != null && i.length > 0)
            {
                for (int l2 = 0; l2 < i.length; l2++)
                {
                    xu1.a(9, i[l2]);
                }

            }
            if (j != null && j.length > 0)
            {
                for (int i3 = ((flag) ? 1 : 0); i3 < j.length; i3++)
                {
                    xu1.a(10, j[i3]);
                }

            }
            super.a(xu1);
        }

        protected int b()
        {
            boolean flag = false;
            int k1 = super.b();
            int i1;
            int j1;
            if (a != null && a.length > 0)
            {
                int l = 0;
                j1 = 0;
                for (; l < a.length; l++)
                {
                    j1 += xu.b(a[l]);
                }

                j1 = k1 + j1 + a.length * 1;
            } else
            {
                j1 = k1;
            }
            i1 = j1;
            if (b != null)
            {
                i1 = j1;
                if (b.length > 0)
                {
                    i1 = 0;
                    k1 = 0;
                    for (; i1 < b.length; i1++)
                    {
                        k1 += xu.b(b[i1]);
                    }

                    i1 = j1 + k1 + b.length * 1;
                }
            }
            j1 = i1;
            if (c != null)
            {
                j1 = i1;
                if (c.length > 0)
                {
                    j1 = 0;
                    k1 = 0;
                    for (; j1 < c.length; j1++)
                    {
                        k1 += xu.b(c[j1]);
                    }

                    j1 = i1 + k1 + c.length * 1;
                }
            }
            i1 = j1;
            if (d != null)
            {
                i1 = j1;
                if (d.length > 0)
                {
                    i1 = 0;
                    k1 = 0;
                    for (; i1 < d.length; i1++)
                    {
                        k1 += xu.b(d[i1]);
                    }

                    i1 = j1 + k1 + d.length * 1;
                }
            }
            j1 = i1;
            if (e != null)
            {
                j1 = i1;
                if (e.length > 0)
                {
                    j1 = 0;
                    k1 = 0;
                    for (; j1 < e.length; j1++)
                    {
                        k1 += xu.b(e[j1]);
                    }

                    j1 = i1 + k1 + e.length * 1;
                }
            }
            i1 = j1;
            if (f != null)
            {
                i1 = j1;
                if (f.length > 0)
                {
                    i1 = 0;
                    k1 = 0;
                    for (; i1 < f.length; i1++)
                    {
                        k1 += xu.b(f[i1]);
                    }

                    i1 = j1 + k1 + f.length * 1;
                }
            }
            j1 = i1;
            if (g != null)
            {
                j1 = i1;
                if (g.length > 0)
                {
                    j1 = 0;
                    k1 = 0;
                    for (; j1 < g.length; j1++)
                    {
                        k1 += xu.b(g[j1]);
                    }

                    j1 = i1 + k1 + g.length * 1;
                }
            }
            i1 = j1;
            if (h != null)
            {
                i1 = j1;
                if (h.length > 0)
                {
                    i1 = 0;
                    k1 = 0;
                    for (; i1 < h.length; i1++)
                    {
                        k1 += xu.b(h[i1]);
                    }

                    i1 = j1 + k1 + h.length * 1;
                }
            }
            j1 = i1;
            if (i != null)
            {
                j1 = i1;
                if (i.length > 0)
                {
                    j1 = 0;
                    k1 = 0;
                    for (; j1 < i.length; j1++)
                    {
                        k1 += xu.b(i[j1]);
                    }

                    j1 = i1 + k1 + i.length * 1;
                }
            }
            i1 = j1;
            if (j != null)
            {
                i1 = j1;
                if (j.length > 0)
                {
                    k1 = 0;
                    for (i1 = ((flag) ? 1 : 0); i1 < j.length; i1++)
                    {
                        k1 += xu.b(j[i1]);
                    }

                    i1 = j1 + k1 + j.length * 1;
                }
            }
            return i1;
        }

        public g c()
        {
            a = ye.a;
            b = ye.a;
            c = ye.a;
            d = ye.a;
            e = ye.a;
            f = ye.a;
            g = ye.a;
            h = ye.a;
            i = ye.a;
            j = ye.a;
            r = null;
            s = -1;
            return this;
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag;
            if (obj == this)
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (obj instanceof g)
                {
                    obj = (g)obj;
                    flag = flag1;
                    if (xz.a(a, ((g) (obj)).a))
                    {
                        flag = flag1;
                        if (xz.a(b, ((g) (obj)).b))
                        {
                            flag = flag1;
                            if (xz.a(c, ((g) (obj)).c))
                            {
                                flag = flag1;
                                if (xz.a(d, ((g) (obj)).d))
                                {
                                    flag = flag1;
                                    if (xz.a(e, ((g) (obj)).e))
                                    {
                                        flag = flag1;
                                        if (xz.a(f, ((g) (obj)).f))
                                        {
                                            flag = flag1;
                                            if (xz.a(g, ((g) (obj)).g))
                                            {
                                                flag = flag1;
                                                if (xz.a(h, ((g) (obj)).h))
                                                {
                                                    flag = flag1;
                                                    if (xz.a(i, ((g) (obj)).i))
                                                    {
                                                        flag = flag1;
                                                        if (xz.a(j, ((g) (obj)).j))
                                                        {
                                                            return a(((xv) (obj)));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return ((((((((((xz.a(a) + 527) * 31 + xz.a(b)) * 31 + xz.a(c)) * 31 + xz.a(d)) * 31 + xz.a(e)) * 31 + xz.a(f)) * 31 + xz.a(g)) * 31 + xz.a(h)) * 31 + xz.a(i)) * 31 + xz.a(j)) * 31 + d();
        }

        public g()
        {
            c();
        }
    }

    public static final class h extends xv
    {

        private static volatile h d[];
        public String a;
        public lv.a b;
        public d c;

        public static h[] a()
        {
            if (d == null)
            {
                synchronized (xz.a)
                {
                    if (d == null)
                    {
                        d = new h[0];
                    }
                }
            }
            return d;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(xu xu1)
            throws IOException
        {
            if (!a.equals(""))
            {
                xu1.a(1, a);
            }
            if (b != null)
            {
                xu1.a(2, b);
            }
            if (c != null)
            {
                xu1.a(3, c);
            }
            super.a(xu1);
        }

        protected int b()
        {
            int k = super.b();
            int j = k;
            if (!a.equals(""))
            {
                j = k + xu.b(1, a);
            }
            k = j;
            if (b != null)
            {
                k = j + xu.c(2, b);
            }
            j = k;
            if (c != null)
            {
                j = k + xu.c(3, c);
            }
            return j;
        }

        public h c()
        {
            a = "";
            b = null;
            c = null;
            r = null;
            s = -1;
            return this;
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            if (obj != this) goto _L2; else goto _L1
_L1:
            boolean flag = true;
_L4:
            return flag;
_L2:
            flag = flag1;
            if (!(obj instanceof h)) goto _L4; else goto _L3
_L3:
            obj = (h)obj;
            if (a != null) goto _L6; else goto _L5
_L5:
            flag = flag1;
            if (((h) (obj)).a != null) goto _L4; else goto _L7
_L7:
            if (b != null) goto _L9; else goto _L8
_L8:
            flag = flag1;
            if (((h) (obj)).b != null) goto _L4; else goto _L10
_L10:
            if (c != null)
            {
                break MISSING_BLOCK_LABEL_111;
            }
            flag = flag1;
            if (((h) (obj)).c != null) goto _L4; else goto _L11
_L11:
            return a(((xv) (obj)));
_L6:
            if (!a.equals(((h) (obj)).a))
            {
                return false;
            }
              goto _L7
_L9:
            if (!b.equals(((h) (obj)).b))
            {
                return false;
            }
              goto _L10
            if (!c.equals(((h) (obj)).c))
            {
                return false;
            }
              goto _L11
        }

        public int hashCode()
        {
            int l = 0;
            int j;
            int k;
            if (a == null)
            {
                j = 0;
            } else
            {
                j = a.hashCode();
            }
            if (b == null)
            {
                k = 0;
            } else
            {
                k = b.hashCode();
            }
            if (c != null)
            {
                l = c.hashCode();
            }
            return ((k + (j + 527) * 31) * 31 + l) * 31 + d();
        }

        public h()
        {
            c();
        }
    }

    public static final class i extends xv
    {

        public h a[];
        public f b;
        public String c;

        public i a()
        {
            a = h.a();
            b = null;
            c = "";
            r = null;
            s = -1;
            return this;
        }

        public void a(xu xu1)
            throws IOException
        {
            if (a != null && a.length > 0)
            {
                for (int j = 0; j < a.length; j++)
                {
                    h h1 = a[j];
                    if (h1 != null)
                    {
                        xu1.a(1, h1);
                    }
                }

            }
            if (b != null)
            {
                xu1.a(2, b);
            }
            if (!c.equals(""))
            {
                xu1.a(3, c);
            }
            super.a(xu1);
        }

        protected int b()
        {
            int j = super.b();
            int k = j;
            if (a != null)
            {
                k = j;
                if (a.length > 0)
                {
                    int l = 0;
                    do
                    {
                        k = j;
                        if (l >= a.length)
                        {
                            break;
                        }
                        h h1 = a[l];
                        k = j;
                        if (h1 != null)
                        {
                            k = j + xu.c(1, h1);
                        }
                        l++;
                        j = k;
                    } while (true);
                }
            }
            j = k;
            if (b != null)
            {
                j = k + xu.c(2, b);
            }
            k = j;
            if (!c.equals(""))
            {
                k = j + xu.b(3, c);
            }
            return k;
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            if (obj != this) goto _L2; else goto _L1
_L1:
            boolean flag = true;
_L4:
            return flag;
_L2:
            flag = flag1;
            if (!(obj instanceof i)) goto _L4; else goto _L3
_L3:
            obj = (i)obj;
            flag = flag1;
            if (!xz.a(a, ((i) (obj)).a)) goto _L4; else goto _L5
_L5:
            if (b != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((i) (obj)).b != null) goto _L4; else goto _L8
_L8:
            if (c != null)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            flag = flag1;
            if (((i) (obj)).c != null) goto _L4; else goto _L9
_L9:
            return a(((xv) (obj)));
_L7:
            if (!b.equals(((i) (obj)).b))
            {
                return false;
            }
              goto _L8
            if (!c.equals(((i) (obj)).c))
            {
                return false;
            }
              goto _L9
        }

        public int hashCode()
        {
            int k = 0;
            int l = xz.a(a);
            int j;
            if (b == null)
            {
                j = 0;
            } else
            {
                j = b.hashCode();
            }
            if (c != null)
            {
                k = c.hashCode();
            }
            return ((j + (l + 527) * 31) * 31 + k) * 31 + d();
        }

        public i()
        {
            a();
        }
    }

}
