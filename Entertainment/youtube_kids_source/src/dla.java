// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dla extends eul
{

    public static final dla a[] = new dla[0];
    private String A;
    private int B;
    public int b;
    public String c;
    public String d;
    public int e;
    public int f;
    public int g;
    public dvr h;
    public dvr i;
    public long j;
    public long k;
    public boolean l;
    public boolean m;
    public int n;
    public String o;
    public boolean p;
    public String q;
    public int r[];
    public String s;
    public int t;
    private String u;
    private String v;
    private int w;
    private int x;
    private int y;
    private String z;

    public dla()
    {
        b = 0;
        c = "";
        u = "";
        v = "";
        d = "";
        e = 0;
        f = 0;
        g = 0;
        h = null;
        i = null;
        j = 0L;
        k = 0L;
        w = 0;
        x = 0;
        y = 0;
        z = "";
        l = false;
        m = false;
        n = 0;
        A = "";
        o = "";
        p = false;
        q = "";
        r = eup.a;
        B = 0;
        s = "";
        t = 0;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (b != 0)
        {
            j1 = euj.c(1, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (!c.equals(""))
        {
            i1 = j1 + euj.b(2, c);
        }
        j1 = i1;
        if (!u.equals(""))
        {
            j1 = i1 + euj.b(3, u);
        }
        i1 = j1;
        if (!v.equals(""))
        {
            i1 = j1 + euj.b(4, v);
        }
        j1 = i1;
        if (!d.equals(""))
        {
            j1 = i1 + euj.b(5, d);
        }
        i1 = j1;
        if (e != 0)
        {
            i1 = j1 + euj.c(6, e);
        }
        j1 = i1;
        if (f != 0)
        {
            j1 = i1 + euj.c(7, f);
        }
        i1 = j1;
        if (g != 0)
        {
            i1 = j1 + euj.c(8, g);
        }
        j1 = i1;
        if (h != null)
        {
            j1 = i1 + euj.b(9, h);
        }
        i1 = j1;
        if (i != null)
        {
            i1 = j1 + euj.b(10, i);
        }
        j1 = i1;
        if (j != 0L)
        {
            j1 = i1 + euj.d(11, j);
        }
        i1 = j1;
        if (k != 0L)
        {
            i1 = j1 + euj.d(12, k);
        }
        j1 = i1;
        if (w != 0)
        {
            j1 = i1 + euj.c(13, w);
        }
        i1 = j1;
        if (x != 0)
        {
            i1 = j1 + euj.c(14, x);
        }
        j1 = i1;
        if (y != 0)
        {
            j1 = i1 + euj.c(15, y);
        }
        i1 = j1;
        if (!z.equals(""))
        {
            i1 = j1 + euj.b(16, z);
        }
        j1 = i1;
        if (l)
        {
            boolean flag1 = l;
            j1 = i1 + (euj.b(17) + 1);
        }
        i1 = j1;
        if (m)
        {
            boolean flag2 = m;
            i1 = j1 + (euj.b(18) + 1);
        }
        j1 = i1;
        if (n != 0)
        {
            j1 = i1 + euj.c(19, n);
        }
        i1 = j1;
        if (!A.equals(""))
        {
            i1 = j1 + euj.b(20, A);
        }
        j1 = i1;
        if (!o.equals(""))
        {
            j1 = i1 + euj.b(21, o);
        }
        k1 = j1;
        if (p)
        {
            boolean flag3 = p;
            k1 = j1 + (euj.b(22) + 1);
        }
        i1 = k1;
        if (!q.equals(""))
        {
            i1 = k1 + euj.b(23, q);
        }
        j1 = i1;
        if (r != null)
        {
            j1 = i1;
            if (r.length > 0)
            {
                int ai[] = r;
                int i2 = ai.length;
                int l1 = 0;
                for (j1 = ((flag) ? 1 : 0); j1 < i2; j1++)
                {
                    l1 += euj.a(ai[j1]);
                }

                j1 = i1 + l1 + r.length * 2;
            }
        }
        i1 = j1;
        if (B != 0)
        {
            i1 = j1 + euj.c(25, B);
        }
        j1 = i1;
        if (!s.equals(""))
        {
            j1 = i1 + euj.b(26, s);
        }
        i1 = j1;
        if (t != 0)
        {
            i1 = j1 + euj.c(27, t);
        }
        i1 += eup.a(O);
        P = i1;
        return i1;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int i1 = eui1.a();
            switch (i1)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                b = eui1.d();
                break;

            case 18: // '\022'
                c = eui1.f();
                break;

            case 26: // '\032'
                u = eui1.f();
                break;

            case 34: // '"'
                v = eui1.f();
                break;

            case 42: // '*'
                d = eui1.f();
                break;

            case 48: // '0'
                e = eui1.d();
                break;

            case 56: // '8'
                f = eui1.d();
                break;

            case 64: // '@'
                g = eui1.d();
                break;

            case 74: // 'J'
                if (h == null)
                {
                    h = new dvr();
                }
                eui1.a(h);
                break;

            case 82: // 'R'
                if (i == null)
                {
                    i = new dvr();
                }
                eui1.a(i);
                break;

            case 88: // 'X'
                j = eui1.c();
                break;

            case 96: // '`'
                k = eui1.c();
                break;

            case 104: // 'h'
                w = eui1.d();
                break;

            case 112: // 'p'
                x = eui1.d();
                break;

            case 120: // 'x'
                y = eui1.d();
                break;

            case 130: 
                z = eui1.f();
                break;

            case 136: 
                l = eui1.e();
                break;

            case 144: 
                m = eui1.e();
                break;

            case 152: 
                int j1 = eui1.d();
                if (j1 == 0 || j1 == 1 || j1 == 2)
                {
                    n = j1;
                } else
                {
                    n = 0;
                }
                break;

            case 162: 
                A = eui1.f();
                break;

            case 170: 
                o = eui1.f();
                break;

            case 176: 
                p = eui1.e();
                break;

            case 186: 
                q = eui1.f();
                break;

            case 192: 
                int i2 = eup.a(eui1, 192);
                int k1 = r.length;
                int ai[] = new int[i2 + k1];
                System.arraycopy(r, 0, ai, 0, k1);
                for (r = ai; k1 < r.length - 1; k1++)
                {
                    r[k1] = eui1.d();
                    eui1.a();
                }

                r[k1] = eui1.d();
                break;

            case 200: 
                B = eui1.d();
                break;

            case 210: 
                s = eui1.f();
                break;

            case 216: 
                int l1 = eui1.d();
                if (l1 == 0 || l1 == 1 || l1 == 2)
                {
                    t = l1;
                } else
                {
                    t = 0;
                }
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != 0)
        {
            euj1.a(1, b);
        }
        if (!c.equals(""))
        {
            euj1.a(2, c);
        }
        if (!u.equals(""))
        {
            euj1.a(3, u);
        }
        if (!v.equals(""))
        {
            euj1.a(4, v);
        }
        if (!d.equals(""))
        {
            euj1.a(5, d);
        }
        if (e != 0)
        {
            euj1.a(6, e);
        }
        if (f != 0)
        {
            euj1.a(7, f);
        }
        if (g != 0)
        {
            euj1.a(8, g);
        }
        if (h != null)
        {
            euj1.a(9, h);
        }
        if (i != null)
        {
            euj1.a(10, i);
        }
        if (j != 0L)
        {
            euj1.b(11, j);
        }
        if (k != 0L)
        {
            euj1.b(12, k);
        }
        if (w != 0)
        {
            euj1.a(13, w);
        }
        if (x != 0)
        {
            euj1.a(14, x);
        }
        if (y != 0)
        {
            euj1.a(15, y);
        }
        if (!z.equals(""))
        {
            euj1.a(16, z);
        }
        if (l)
        {
            euj1.a(17, l);
        }
        if (m)
        {
            euj1.a(18, m);
        }
        if (n != 0)
        {
            euj1.a(19, n);
        }
        if (!A.equals(""))
        {
            euj1.a(20, A);
        }
        if (!o.equals(""))
        {
            euj1.a(21, o);
        }
        if (p)
        {
            euj1.a(22, p);
        }
        if (!q.equals(""))
        {
            euj1.a(23, q);
        }
        if (r != null && r.length > 0)
        {
            int ai[] = r;
            int j1 = ai.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                euj1.a(24, ai[i1]);
            }

        }
        if (B != 0)
        {
            euj1.a(25, B);
        }
        if (!s.equals(""))
        {
            euj1.a(26, s);
        }
        if (t != 0)
        {
            euj1.a(27, t);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
label0:
        {
            if (!(obj instanceof dla))
            {
                return false;
            }
            obj = (dla)obj;
            if (b == ((dla) (obj)).b && (c != null ? c.equals(((dla) (obj)).c) : ((dla) (obj)).c == null) && (u != null ? u.equals(((dla) (obj)).u) : ((dla) (obj)).u == null) && (v != null ? v.equals(((dla) (obj)).v) : ((dla) (obj)).v == null) && (d != null ? d.equals(((dla) (obj)).d) : ((dla) (obj)).d == null) && (e == ((dla) (obj)).e && f == ((dla) (obj)).f && g == ((dla) (obj)).g) && (h != null ? h.equals(((dla) (obj)).h) : ((dla) (obj)).h == null) && (i != null ? i.equals(((dla) (obj)).i) : ((dla) (obj)).i == null) && (j == ((dla) (obj)).j && k == ((dla) (obj)).k && w == ((dla) (obj)).w && x == ((dla) (obj)).x && y == ((dla) (obj)).y) && (z != null ? z.equals(((dla) (obj)).z) : ((dla) (obj)).z == null) && (l == ((dla) (obj)).l && m == ((dla) (obj)).m && n == ((dla) (obj)).n) && (A != null ? A.equals(((dla) (obj)).A) : ((dla) (obj)).A == null) && (o != null ? o.equals(((dla) (obj)).o) : ((dla) (obj)).o == null) && p == ((dla) (obj)).p && (q != null ? q.equals(((dla) (obj)).q) : ((dla) (obj)).q == null) && (Arrays.equals(r, ((dla) (obj)).r) && B == ((dla) (obj)).B) && (s != null ? s.equals(((dla) (obj)).s) : ((dla) (obj)).s == null) && t == ((dla) (obj)).t)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dla) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dla) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i1;
        int j1;
        int k1;
        int l3 = 1;
        boolean flag = false;
        int j4 = getClass().getName().hashCode();
        int k4 = b;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int i4;
        int l4;
        int i5;
        int j5;
        int k5;
        int l5;
        int i6;
        int j6;
        int k6;
        int l6;
        if (c == null)
        {
            i1 = 0;
        } else
        {
            i1 = c.hashCode();
        }
        if (u == null)
        {
            j1 = 0;
        } else
        {
            j1 = u.hashCode();
        }
        if (v == null)
        {
            k1 = 0;
        } else
        {
            k1 = v.hashCode();
        }
        if (d == null)
        {
            l1 = 0;
        } else
        {
            l1 = d.hashCode();
        }
        l4 = e;
        i5 = f;
        j5 = g;
        if (h == null)
        {
            i2 = 0;
        } else
        {
            i2 = h.hashCode();
        }
        if (i == null)
        {
            j2 = 0;
        } else
        {
            j2 = i.hashCode();
        }
        k5 = (int)(j ^ j >>> 32);
        l5 = (int)(k ^ k >>> 32);
        i6 = w;
        j6 = x;
        k6 = y;
        if (z == null)
        {
            k2 = 0;
        } else
        {
            k2 = z.hashCode();
        }
        if (l)
        {
            l2 = 1;
        } else
        {
            l2 = 2;
        }
        if (m)
        {
            i3 = 1;
        } else
        {
            i3 = 2;
        }
        l6 = n;
        if (A == null)
        {
            j3 = 0;
        } else
        {
            j3 = A.hashCode();
        }
        if (o == null)
        {
            k3 = 0;
        } else
        {
            k3 = o.hashCode();
        }
        if (!p)
        {
            l3 = 2;
        }
        if (q == null)
        {
            i4 = 0;
        } else
        {
            i4 = q.hashCode();
        }
        i1 = i4 + ((k3 + (j3 + ((i3 + (l2 + (k2 + ((((((j2 + (i2 + ((((l1 + (k1 + (j1 + (i1 + ((j4 + 527) * 31 + k4) * 31) * 31) * 31) * 31) * 31 + l4) * 31 + i5) * 31 + j5) * 31) * 31) * 31 + k5) * 31 + l5) * 31 + i6) * 31 + j6) * 31 + k6) * 31) * 31) * 31) * 31 + l6) * 31) * 31) * 31 + l3) * 31;
        if (r != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L4:
        l1 = B;
        if (s == null)
        {
            i1 = 0;
        } else
        {
            i1 = s.hashCode();
        }
        i2 = t;
        if (O == null)
        {
            k1 = ((flag) ? 1 : 0);
        } else
        {
            k1 = O.hashCode();
        }
        return ((i1 + (j1 * 31 + l1) * 31) * 31 + i2) * 31 + k1;
_L2:
        k1 = 0;
_L5:
        j1 = i1;
        if (k1 >= r.length) goto _L4; else goto _L3
_L3:
        i1 = i1 * 31 + r[k1];
        k1++;
          goto _L5
    }

}
