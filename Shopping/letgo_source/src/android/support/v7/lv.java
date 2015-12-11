// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xv, xz, xu, ye

public interface lv
{
    public static final class a extends xv
    {

        private static volatile a m[];
        public int a;
        public String b;
        public a c[];
        public a d[];
        public a e[];
        public String f;
        public String g;
        public long h;
        public boolean i;
        public a j[];
        public int k[];
        public boolean l;

        public static a[] a()
        {
            if (m == null)
            {
                synchronized (xz.a)
                {
                    if (m == null)
                    {
                        m = new a[0];
                    }
                }
            }
            return m;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(xu xu1)
            throws IOException
        {
            boolean flag = false;
            xu1.a(1, a);
            if (!b.equals(""))
            {
                xu1.a(2, b);
            }
            if (c != null && c.length > 0)
            {
                for (int i1 = 0; i1 < c.length; i1++)
                {
                    a a1 = c[i1];
                    if (a1 != null)
                    {
                        xu1.a(3, a1);
                    }
                }

            }
            if (d != null && d.length > 0)
            {
                for (int j1 = 0; j1 < d.length; j1++)
                {
                    a a2 = d[j1];
                    if (a2 != null)
                    {
                        xu1.a(4, a2);
                    }
                }

            }
            if (e != null && e.length > 0)
            {
                for (int k1 = 0; k1 < e.length; k1++)
                {
                    a a3 = e[k1];
                    if (a3 != null)
                    {
                        xu1.a(5, a3);
                    }
                }

            }
            if (!f.equals(""))
            {
                xu1.a(6, f);
            }
            if (!g.equals(""))
            {
                xu1.a(7, g);
            }
            if (h != 0L)
            {
                xu1.a(8, h);
            }
            if (l)
            {
                xu1.a(9, l);
            }
            if (k != null && k.length > 0)
            {
                for (int l1 = 0; l1 < k.length; l1++)
                {
                    xu1.a(10, k[l1]);
                }

            }
            if (j != null && j.length > 0)
            {
                for (int i2 = ((flag) ? 1 : 0); i2 < j.length; i2++)
                {
                    a a4 = j[i2];
                    if (a4 != null)
                    {
                        xu1.a(11, a4);
                    }
                }

            }
            if (i)
            {
                xu1.a(12, i);
            }
            super.a(xu1);
        }

        protected int b()
        {
            boolean flag = false;
            int j1 = super.b() + xu.b(1, a);
            int i1 = j1;
            if (!b.equals(""))
            {
                i1 = j1 + xu.b(2, b);
            }
            j1 = i1;
            if (c != null)
            {
                j1 = i1;
                if (c.length > 0)
                {
                    for (j1 = 0; j1 < c.length;)
                    {
                        a a1 = c[j1];
                        int k1 = i1;
                        if (a1 != null)
                        {
                            k1 = i1 + xu.c(3, a1);
                        }
                        j1++;
                        i1 = k1;
                    }

                    j1 = i1;
                }
            }
            i1 = j1;
            if (d != null)
            {
                i1 = j1;
                if (d.length > 0)
                {
                    i1 = j1;
                    for (j1 = 0; j1 < d.length;)
                    {
                        a a2 = d[j1];
                        int l1 = i1;
                        if (a2 != null)
                        {
                            l1 = i1 + xu.c(4, a2);
                        }
                        j1++;
                        i1 = l1;
                    }

                }
            }
            j1 = i1;
            if (e != null)
            {
                j1 = i1;
                if (e.length > 0)
                {
                    for (j1 = 0; j1 < e.length;)
                    {
                        a a3 = e[j1];
                        int i2 = i1;
                        if (a3 != null)
                        {
                            i2 = i1 + xu.c(5, a3);
                        }
                        j1++;
                        i1 = i2;
                    }

                    j1 = i1;
                }
            }
            i1 = j1;
            if (!f.equals(""))
            {
                i1 = j1 + xu.b(6, f);
            }
            j1 = i1;
            if (!g.equals(""))
            {
                j1 = i1 + xu.b(7, g);
            }
            i1 = j1;
            if (h != 0L)
            {
                i1 = j1 + xu.b(8, h);
            }
            j1 = i1;
            if (l)
            {
                j1 = i1 + xu.b(9, l);
            }
            i1 = j1;
            if (k != null)
            {
                i1 = j1;
                if (k.length > 0)
                {
                    i1 = 0;
                    int j2 = 0;
                    for (; i1 < k.length; i1++)
                    {
                        j2 += xu.b(k[i1]);
                    }

                    i1 = j1 + j2 + k.length * 1;
                }
            }
            j1 = i1;
            if (j != null)
            {
                j1 = i1;
                if (j.length > 0)
                {
                    int k2 = ((flag) ? 1 : 0);
                    do
                    {
                        j1 = i1;
                        if (k2 >= j.length)
                        {
                            break;
                        }
                        a a4 = j[k2];
                        j1 = i1;
                        if (a4 != null)
                        {
                            j1 = i1 + xu.c(11, a4);
                        }
                        k2++;
                        i1 = j1;
                    } while (true);
                }
            }
            i1 = j1;
            if (i)
            {
                i1 = j1 + xu.b(12, i);
            }
            return i1;
        }

        public a c()
        {
            a = 1;
            b = "";
            c = a();
            d = a();
            e = a();
            f = "";
            g = "";
            h = 0L;
            i = false;
            j = a();
            k = ye.a;
            l = false;
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
            if (!(obj instanceof a)) goto _L4; else goto _L3
_L3:
            obj = (a)obj;
            flag = flag1;
            if (a != ((a) (obj)).a) goto _L4; else goto _L5
_L5:
            if (b != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((a) (obj)).b != null) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (!xz.a(c, ((a) (obj)).c)) goto _L4; else goto _L9
_L9:
            flag = flag1;
            if (!xz.a(d, ((a) (obj)).d)) goto _L4; else goto _L10
_L10:
            flag = flag1;
            if (!xz.a(e, ((a) (obj)).e)) goto _L4; else goto _L11
_L11:
            if (f != null) goto _L13; else goto _L12
_L12:
            flag = flag1;
            if (((a) (obj)).f != null) goto _L4; else goto _L14
_L14:
            if (g != null)
            {
                break MISSING_BLOCK_LABEL_244;
            }
            flag = flag1;
            if (((a) (obj)).g != null) goto _L4; else goto _L15
_L15:
            flag = flag1;
            if (h == ((a) (obj)).h)
            {
                flag = flag1;
                if (i == ((a) (obj)).i)
                {
                    flag = flag1;
                    if (xz.a(j, ((a) (obj)).j))
                    {
                        flag = flag1;
                        if (xz.a(k, ((a) (obj)).k))
                        {
                            flag = flag1;
                            if (l == ((a) (obj)).l)
                            {
                                return a(((xv) (obj)));
                            }
                        }
                    }
                }
            }
              goto _L4
_L7:
            if (!b.equals(((a) (obj)).b))
            {
                return false;
            }
              goto _L8
_L13:
            if (!f.equals(((a) (obj)).f))
            {
                return false;
            }
              goto _L14
            if (!g.equals(((a) (obj)).g))
            {
                return false;
            }
              goto _L15
        }

        public int hashCode()
        {
            char c2 = '\u04CF';
            int k1 = 0;
            int l1 = a;
            int i1;
            int j1;
            char c1;
            int i2;
            int j2;
            int k2;
            int l2;
            int i3;
            int j3;
            if (b == null)
            {
                i1 = 0;
            } else
            {
                i1 = b.hashCode();
            }
            i2 = xz.a(c);
            j2 = xz.a(d);
            k2 = xz.a(e);
            if (f == null)
            {
                j1 = 0;
            } else
            {
                j1 = f.hashCode();
            }
            if (g != null)
            {
                k1 = g.hashCode();
            }
            l2 = (int)(h ^ h >>> 32);
            if (i)
            {
                c1 = '\u04CF';
            } else
            {
                c1 = '\u04D5';
            }
            i3 = xz.a(j);
            j3 = xz.a(k);
            if (!l)
            {
                c2 = '\u04D5';
            }
            return ((((c1 + (((j1 + ((((i1 + (l1 + 527) * 31) * 31 + i2) * 31 + j2) * 31 + k2) * 31) * 31 + k1) * 31 + l2) * 31) * 31 + i3) * 31 + j3) * 31 + c2) * 31 + d();
        }

        public a()
        {
            c();
        }
    }

}
