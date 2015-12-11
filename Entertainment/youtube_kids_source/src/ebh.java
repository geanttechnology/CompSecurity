// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ebh extends eul
{

    private dqi A;
    private dre B;
    private dxn C;
    public byte a[];
    private dlb b;
    private dzp c;
    private dlb d;
    private dlb e;
    private dzg f;
    private dlb g;
    private dlb h;
    private dlb i;
    private dlb j;
    private dlb k;
    private int l;
    private dlb m;
    private int n;
    private String o;
    private boolean p;
    private dlb q;
    private boolean r;
    private dfq s[];
    private int t;
    private int u;
    private doy v;
    private int w;
    private dfq x[];
    private dlb y;
    private String z;

    public ebh()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = 0;
        m = null;
        n = 0;
        o = "";
        p = false;
        q = null;
        r = false;
        s = dfq.a;
        t = 0;
        u = 0;
        v = null;
        w = 0;
        x = dfq.a;
        y = null;
        a = eup.f;
        z = "";
        A = null;
        B = null;
        C = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (b != null)
        {
            j1 = euj.b(1, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (c != null)
        {
            i1 = j1 + euj.b(2, c);
        }
        j1 = i1;
        if (d != null)
        {
            j1 = i1 + euj.b(3, d);
        }
        i1 = j1;
        if (e != null)
        {
            i1 = j1 + euj.b(4, e);
        }
        j1 = i1;
        if (f != null)
        {
            j1 = i1 + euj.b(5, f);
        }
        i1 = j1;
        if (g != null)
        {
            i1 = j1 + euj.b(6, g);
        }
        j1 = i1;
        if (h != null)
        {
            j1 = i1 + euj.b(7, h);
        }
        i1 = j1;
        if (i != null)
        {
            i1 = j1 + euj.b(8, i);
        }
        j1 = i1;
        if (j != null)
        {
            j1 = i1 + euj.b(9, j);
        }
        i1 = j1;
        if (k != null)
        {
            i1 = j1 + euj.b(10, k);
        }
        j1 = i1;
        if (l != 0)
        {
            j1 = i1 + euj.c(11, l);
        }
        i1 = j1;
        if (m != null)
        {
            i1 = j1 + euj.b(12, m);
        }
        j1 = i1;
        if (n != 0)
        {
            j1 = i1 + euj.c(13, n);
        }
        i1 = j1;
        if (!o.equals(""))
        {
            i1 = j1 + euj.b(14, o);
        }
        j1 = i1;
        if (p)
        {
            boolean flag1 = p;
            j1 = i1 + (euj.b(15) + 1);
        }
        k1 = j1;
        if (q != null)
        {
            k1 = j1 + euj.b(16, q);
        }
        i1 = k1;
        if (r)
        {
            boolean flag2 = r;
            i1 = k1 + (euj.b(17) + 1);
        }
        j1 = i1;
        if (s != null)
        {
            dfq adfq[] = s;
            int i2 = adfq.length;
            k1 = 0;
            do
            {
                j1 = i1;
                if (k1 >= i2)
                {
                    break;
                }
                dfq dfq1 = adfq[k1];
                j1 = i1;
                if (dfq1 != null)
                {
                    j1 = i1 + euj.b(18, dfq1);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (t != 0)
        {
            i1 = j1 + euj.c(21, t);
        }
        j1 = i1;
        if (u != 0)
        {
            j1 = i1 + euj.c(22, u);
        }
        k1 = j1;
        if (v != null)
        {
            k1 = j1 + euj.b(24, v);
        }
        i1 = k1;
        if (w != 0)
        {
            i1 = k1 + euj.c(25, w);
        }
        j1 = i1;
        if (x != null)
        {
            dfq adfq1[] = x;
            int j2 = adfq1.length;
            int l1 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (l1 >= j2)
                {
                    break;
                }
                dfq dfq2 = adfq1[l1];
                j1 = i1;
                if (dfq2 != null)
                {
                    j1 = i1 + euj.b(26, dfq2);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (y != null)
        {
            i1 = j1 + euj.b(27, y);
        }
        j1 = i1;
        if (!Arrays.equals(a, eup.f))
        {
            j1 = i1 + euj.b(28, a);
        }
        i1 = j1;
        if (!z.equals(""))
        {
            i1 = j1 + euj.b(36, z);
        }
        j1 = i1;
        if (A != null)
        {
            j1 = i1 + euj.b(37, A);
        }
        i1 = j1;
        if (B != null)
        {
            i1 = j1 + euj.b(38, B);
        }
        j1 = i1;
        if (C != null)
        {
            j1 = i1 + euj.b(39, C);
        }
        i1 = j1 + eup.a(O);
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

            case 10: // '\n'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dzp();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 34: // '"'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 42: // '*'
                if (f == null)
                {
                    f = new dzg();
                }
                eui1.a(f);
                break;

            case 50: // '2'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 58: // ':'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 66: // 'B'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 74: // 'J'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 82: // 'R'
                if (k == null)
                {
                    k = new dlb();
                }
                eui1.a(k);
                break;

            case 88: // 'X'
                l = eui1.d();
                break;

            case 98: // 'b'
                if (m == null)
                {
                    m = new dlb();
                }
                eui1.a(m);
                break;

            case 104: // 'h'
                n = eui1.d();
                break;

            case 114: // 'r'
                o = eui1.f();
                break;

            case 120: // 'x'
                p = eui1.e();
                break;

            case 130: 
                if (q == null)
                {
                    q = new dlb();
                }
                eui1.a(q);
                break;

            case 136: 
                r = eui1.e();
                break;

            case 146: 
                int k2 = eup.a(eui1, 146);
                dfq adfq[];
                int j1;
                if (s == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = s.length;
                }
                adfq = new dfq[k2 + j1];
                if (s != null)
                {
                    System.arraycopy(s, 0, adfq, 0, j1);
                }
                for (s = adfq; j1 < s.length - 1; j1++)
                {
                    s[j1] = new dfq();
                    eui1.a(s[j1]);
                    eui1.a();
                }

                s[j1] = new dfq();
                eui1.a(s[j1]);
                break;

            case 168: 
                int k1 = eui1.d();
                if (k1 == 0 || k1 == 1 || k1 == 2)
                {
                    t = k1;
                } else
                {
                    t = 0;
                }
                break;

            case 176: 
                int l1 = eui1.d();
                if (l1 == 0 || l1 == 1 || l1 == 2)
                {
                    u = l1;
                } else
                {
                    u = 0;
                }
                break;

            case 194: 
                if (v == null)
                {
                    v = new doy();
                }
                eui1.a(v);
                break;

            case 200: 
                int i2 = eui1.d();
                if (i2 == 0 || i2 == 1 || i2 == 2)
                {
                    w = i2;
                } else
                {
                    w = 0;
                }
                break;

            case 210: 
                int l2 = eup.a(eui1, 210);
                dfq adfq1[];
                int j2;
                if (x == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = x.length;
                }
                adfq1 = new dfq[l2 + j2];
                if (x != null)
                {
                    System.arraycopy(x, 0, adfq1, 0, j2);
                }
                for (x = adfq1; j2 < x.length - 1; j2++)
                {
                    x[j2] = new dfq();
                    eui1.a(x[j2]);
                    eui1.a();
                }

                x[j2] = new dfq();
                eui1.a(x[j2]);
                break;

            case 218: 
                if (y == null)
                {
                    y = new dlb();
                }
                eui1.a(y);
                break;

            case 226: 
                a = eui1.g();
                break;

            case 290: 
                z = eui1.f();
                break;

            case 298: 
                if (A == null)
                {
                    A = new dqi();
                }
                eui1.a(A);
                break;

            case 306: 
                if (B == null)
                {
                    B = new dre();
                }
                eui1.a(B);
                break;

            case 314: 
                if (C == null)
                {
                    C = new dxn();
                }
                eui1.a(C);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (b != null)
        {
            euj1.a(1, b);
        }
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (d != null)
        {
            euj1.a(3, d);
        }
        if (e != null)
        {
            euj1.a(4, e);
        }
        if (f != null)
        {
            euj1.a(5, f);
        }
        if (g != null)
        {
            euj1.a(6, g);
        }
        if (h != null)
        {
            euj1.a(7, h);
        }
        if (i != null)
        {
            euj1.a(8, i);
        }
        if (j != null)
        {
            euj1.a(9, j);
        }
        if (k != null)
        {
            euj1.a(10, k);
        }
        if (l != 0)
        {
            euj1.a(11, l);
        }
        if (m != null)
        {
            euj1.a(12, m);
        }
        if (n != 0)
        {
            euj1.a(13, n);
        }
        if (!o.equals(""))
        {
            euj1.a(14, o);
        }
        if (p)
        {
            euj1.a(15, p);
        }
        if (q != null)
        {
            euj1.a(16, q);
        }
        if (r)
        {
            euj1.a(17, r);
        }
        if (s != null)
        {
            dfq adfq[] = s;
            int k1 = adfq.length;
            for (int i1 = 0; i1 < k1; i1++)
            {
                dfq dfq1 = adfq[i1];
                if (dfq1 != null)
                {
                    euj1.a(18, dfq1);
                }
            }

        }
        if (t != 0)
        {
            euj1.a(21, t);
        }
        if (u != 0)
        {
            euj1.a(22, u);
        }
        if (v != null)
        {
            euj1.a(24, v);
        }
        if (w != 0)
        {
            euj1.a(25, w);
        }
        if (x != null)
        {
            dfq adfq1[] = x;
            int l1 = adfq1.length;
            for (int j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
            {
                dfq dfq2 = adfq1[j1];
                if (dfq2 != null)
                {
                    euj1.a(26, dfq2);
                }
            }

        }
        if (y != null)
        {
            euj1.a(27, y);
        }
        if (!Arrays.equals(a, eup.f))
        {
            euj1.a(28, a);
        }
        if (!z.equals(""))
        {
            euj1.a(36, z);
        }
        if (A != null)
        {
            euj1.a(37, A);
        }
        if (B != null)
        {
            euj1.a(38, B);
        }
        if (C != null)
        {
            euj1.a(39, C);
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
            if (!(obj instanceof ebh))
            {
                return false;
            }
            obj = (ebh)obj;
            if ((b != null ? b.equals(((ebh) (obj)).b) : ((ebh) (obj)).b == null) && (c != null ? c.equals(((ebh) (obj)).c) : ((ebh) (obj)).c == null) && (d != null ? d.equals(((ebh) (obj)).d) : ((ebh) (obj)).d == null) && (e != null ? e.equals(((ebh) (obj)).e) : ((ebh) (obj)).e == null) && (f != null ? f.equals(((ebh) (obj)).f) : ((ebh) (obj)).f == null) && (g != null ? g.equals(((ebh) (obj)).g) : ((ebh) (obj)).g == null) && (h != null ? h.equals(((ebh) (obj)).h) : ((ebh) (obj)).h == null) && (i != null ? i.equals(((ebh) (obj)).i) : ((ebh) (obj)).i == null) && (j != null ? j.equals(((ebh) (obj)).j) : ((ebh) (obj)).j == null) && (k != null ? k.equals(((ebh) (obj)).k) : ((ebh) (obj)).k == null) && l == ((ebh) (obj)).l && (m != null ? m.equals(((ebh) (obj)).m) : ((ebh) (obj)).m == null) && n == ((ebh) (obj)).n && (o != null ? o.equals(((ebh) (obj)).o) : ((ebh) (obj)).o == null) && p == ((ebh) (obj)).p && (q != null ? q.equals(((ebh) (obj)).q) : ((ebh) (obj)).q == null) && (r == ((ebh) (obj)).r && Arrays.equals(s, ((ebh) (obj)).s) && t == ((ebh) (obj)).t && u == ((ebh) (obj)).u) && (v != null ? v.equals(((ebh) (obj)).v) : ((ebh) (obj)).v == null) && (w == ((ebh) (obj)).w && Arrays.equals(x, ((ebh) (obj)).x)) && (y != null ? y.equals(((ebh) (obj)).y) : ((ebh) (obj)).y == null) && Arrays.equals(a, ((ebh) (obj)).a) && (z != null ? z.equals(((ebh) (obj)).z) : ((ebh) (obj)).z == null) && (A != null ? A.equals(((ebh) (obj)).A) : ((ebh) (obj)).A == null) && (B != null ? B.equals(((ebh) (obj)).B) : ((ebh) (obj)).B == null) && (C != null ? C.equals(((ebh) (obj)).C) : ((ebh) (obj)).C == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ebh) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ebh) (obj)).O))
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
        int l1;
        int i2;
        int j2;
        int k4 = 1;
        boolean flag = false;
        int l4 = getClass().getName().hashCode();
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int i5;
        int j5;
        if (b == null)
        {
            i1 = 0;
        } else
        {
            i1 = b.hashCode();
        }
        if (c == null)
        {
            j1 = 0;
        } else
        {
            j1 = c.hashCode();
        }
        if (d == null)
        {
            k1 = 0;
        } else
        {
            k1 = d.hashCode();
        }
        if (e == null)
        {
            l1 = 0;
        } else
        {
            l1 = e.hashCode();
        }
        if (f == null)
        {
            i2 = 0;
        } else
        {
            i2 = f.hashCode();
        }
        if (g == null)
        {
            j2 = 0;
        } else
        {
            j2 = g.hashCode();
        }
        if (h == null)
        {
            k2 = 0;
        } else
        {
            k2 = h.hashCode();
        }
        if (i == null)
        {
            l2 = 0;
        } else
        {
            l2 = i.hashCode();
        }
        if (j == null)
        {
            i3 = 0;
        } else
        {
            i3 = j.hashCode();
        }
        if (k == null)
        {
            j3 = 0;
        } else
        {
            j3 = k.hashCode();
        }
        i5 = l;
        if (m == null)
        {
            k3 = 0;
        } else
        {
            k3 = m.hashCode();
        }
        j5 = n;
        if (o == null)
        {
            l3 = 0;
        } else
        {
            l3 = o.hashCode();
        }
        if (p)
        {
            i4 = 1;
        } else
        {
            i4 = 2;
        }
        if (q == null)
        {
            j4 = 0;
        } else
        {
            j4 = q.hashCode();
        }
        if (!r)
        {
            k4 = 2;
        }
        i1 = (j4 + (i4 + (l3 + ((k3 + ((j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l4 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i5) * 31) * 31 + j5) * 31) * 31) * 31) * 31 + k4;
        if (s != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L8:
        k1 = t;
        l1 = u;
        if (v == null)
        {
            i1 = 0;
        } else
        {
            i1 = v.hashCode();
        }
        i1 = (i1 + ((j1 * 31 + k1) * 31 + l1) * 31) * 31 + w;
        if (x != null) goto _L4; else goto _L3
_L3:
        k1 = i1 * 31;
_L11:
        if (y == null)
        {
            i1 = 0;
        } else
        {
            i1 = y.hashCode();
        }
        i1 += k1 * 31;
        if (a != null) goto _L6; else goto _L5
_L5:
        j1 = i1 * 31;
_L14:
        if (z == null)
        {
            i1 = 0;
        } else
        {
            i1 = z.hashCode();
        }
        if (A == null)
        {
            k1 = 0;
        } else
        {
            k1 = A.hashCode();
        }
        if (B == null)
        {
            l1 = 0;
        } else
        {
            l1 = B.hashCode();
        }
        if (C == null)
        {
            i2 = 0;
        } else
        {
            i2 = C.hashCode();
        }
        if (O == null)
        {
            j2 = ((flag) ? 1 : 0);
        } else
        {
            j2 = O.hashCode();
        }
        return (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31 + j2;
_L2:
        k1 = 0;
_L9:
        j1 = i1;
        if (k1 >= s.length) goto _L8; else goto _L7
_L7:
        if (s[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = s[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L9
          goto _L8
_L4:
        j1 = 0;
_L12:
        k1 = i1;
        if (j1 >= x.length) goto _L11; else goto _L10
_L10:
        if (x[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = x[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L12
          goto _L11
_L6:
        k1 = 0;
_L15:
        j1 = i1;
        if (k1 >= a.length) goto _L14; else goto _L13
_L13:
        i1 = i1 * 31 + a[k1];
        k1++;
          goto _L15
    }
}
