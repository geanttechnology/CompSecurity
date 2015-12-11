// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ebn extends eul
{

    public dlb a;
    public dlb b;
    public dlb c;
    public boolean d;
    public boolean e;
    public dlb f;
    public doy g;
    public byte h[];
    private dlb i;
    private dlb j;
    private dlb k;
    private dlb l;
    private int m;
    private String n;
    private dfq o[];
    private dlb p;
    private dlb q;
    private String r;
    private int s;
    private ebo t;
    private dlb u;
    private dlb v;

    public ebn()
    {
        a = null;
        b = null;
        i = null;
        j = null;
        c = null;
        k = null;
        l = null;
        d = false;
        e = false;
        f = null;
        m = 0;
        n = "";
        g = null;
        o = dfq.a;
        h = eup.f;
        p = null;
        q = null;
        r = "";
        s = 0;
        t = null;
        u = null;
        v = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (a != null)
        {
            j1 = euj.b(1, a) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (b != null)
        {
            i1 = j1 + euj.b(2, b);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1 + euj.b(3, i);
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1 + euj.b(4, j);
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1 + euj.b(5, c);
        }
        i1 = j1;
        if (k != null)
        {
            i1 = j1 + euj.b(6, k);
        }
        j1 = i1;
        if (l != null)
        {
            j1 = i1 + euj.b(7, l);
        }
        i1 = j1;
        if (d)
        {
            boolean flag1 = d;
            i1 = j1 + (euj.b(8) + 1);
        }
        j1 = i1;
        if (e)
        {
            boolean flag2 = e;
            j1 = i1 + (euj.b(9) + 1);
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(10, f);
        }
        j1 = i1;
        if (m != 0)
        {
            j1 = i1 + euj.c(11, m);
        }
        k1 = j1;
        if (!n.equals(""))
        {
            k1 = j1 + euj.b(12, n);
        }
        i1 = k1;
        if (g != null)
        {
            i1 = k1 + euj.b(13, g);
        }
        j1 = i1;
        if (o != null)
        {
            dfq adfq[] = o;
            int i2 = adfq.length;
            int l1 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (l1 >= i2)
                {
                    break;
                }
                dfq dfq1 = adfq[l1];
                j1 = i1;
                if (dfq1 != null)
                {
                    j1 = i1 + euj.b(14, dfq1);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (!Arrays.equals(h, eup.f))
        {
            i1 = j1 + euj.b(16, h);
        }
        j1 = i1;
        if (p != null)
        {
            j1 = i1 + euj.b(17, p);
        }
        i1 = j1;
        if (q != null)
        {
            i1 = j1 + euj.b(18, q);
        }
        j1 = i1;
        if (!r.equals(""))
        {
            j1 = i1 + euj.b(23, r);
        }
        i1 = j1;
        if (s != 0)
        {
            i1 = j1 + euj.c(24, s);
        }
        j1 = i1;
        if (t != null)
        {
            j1 = i1 + euj.b(25, t);
        }
        i1 = j1;
        if (u != null)
        {
            i1 = j1 + euj.b(28, u);
        }
        j1 = i1;
        if (v != null)
        {
            j1 = i1 + euj.b(29, v);
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
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 34: // '"'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 42: // '*'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 50: // '2'
                if (k == null)
                {
                    k = new dlb();
                }
                eui1.a(k);
                break;

            case 58: // ':'
                if (l == null)
                {
                    l = new dlb();
                }
                eui1.a(l);
                break;

            case 64: // '@'
                d = eui1.e();
                break;

            case 72: // 'H'
                e = eui1.e();
                break;

            case 82: // 'R'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 88: // 'X'
                int j1 = eui1.d();
                if (j1 == 0 || j1 == 1 || j1 == 2)
                {
                    m = j1;
                } else
                {
                    m = 0;
                }
                break;

            case 98: // 'b'
                n = eui1.f();
                break;

            case 106: // 'j'
                if (g == null)
                {
                    g = new doy();
                }
                eui1.a(g);
                break;

            case 114: // 'r'
                int i2 = eup.a(eui1, 114);
                dfq adfq[];
                int k1;
                if (o == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = o.length;
                }
                adfq = new dfq[i2 + k1];
                if (o != null)
                {
                    System.arraycopy(o, 0, adfq, 0, k1);
                }
                for (o = adfq; k1 < o.length - 1; k1++)
                {
                    o[k1] = new dfq();
                    eui1.a(o[k1]);
                    eui1.a();
                }

                o[k1] = new dfq();
                eui1.a(o[k1]);
                break;

            case 130: 
                h = eui1.g();
                break;

            case 138: 
                if (p == null)
                {
                    p = new dlb();
                }
                eui1.a(p);
                break;

            case 146: 
                if (q == null)
                {
                    q = new dlb();
                }
                eui1.a(q);
                break;

            case 186: 
                r = eui1.f();
                break;

            case 192: 
                int l1 = eui1.d();
                if (l1 == 0 || l1 == 1 || l1 == 2 || l1 == 3)
                {
                    s = l1;
                } else
                {
                    s = 0;
                }
                break;

            case 202: 
                if (t == null)
                {
                    t = new ebo();
                }
                eui1.a(t);
                break;

            case 226: 
                if (u == null)
                {
                    u = new dlb();
                }
                eui1.a(u);
                break;

            case 234: 
                if (v == null)
                {
                    v = new dlb();
                }
                eui1.a(v);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (i != null)
        {
            euj1.a(3, i);
        }
        if (j != null)
        {
            euj1.a(4, j);
        }
        if (c != null)
        {
            euj1.a(5, c);
        }
        if (k != null)
        {
            euj1.a(6, k);
        }
        if (l != null)
        {
            euj1.a(7, l);
        }
        if (d)
        {
            euj1.a(8, d);
        }
        if (e)
        {
            euj1.a(9, e);
        }
        if (f != null)
        {
            euj1.a(10, f);
        }
        if (m != 0)
        {
            euj1.a(11, m);
        }
        if (!n.equals(""))
        {
            euj1.a(12, n);
        }
        if (g != null)
        {
            euj1.a(13, g);
        }
        if (o != null)
        {
            dfq adfq[] = o;
            int j1 = adfq.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                dfq dfq1 = adfq[i1];
                if (dfq1 != null)
                {
                    euj1.a(14, dfq1);
                }
            }

        }
        if (!Arrays.equals(h, eup.f))
        {
            euj1.a(16, h);
        }
        if (p != null)
        {
            euj1.a(17, p);
        }
        if (q != null)
        {
            euj1.a(18, q);
        }
        if (!r.equals(""))
        {
            euj1.a(23, r);
        }
        if (s != 0)
        {
            euj1.a(24, s);
        }
        if (t != null)
        {
            euj1.a(25, t);
        }
        if (u != null)
        {
            euj1.a(28, u);
        }
        if (v != null)
        {
            euj1.a(29, v);
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
            if (!(obj instanceof ebn))
            {
                return false;
            }
            obj = (ebn)obj;
            if ((a != null ? a.equals(((ebn) (obj)).a) : ((ebn) (obj)).a == null) && (b != null ? b.equals(((ebn) (obj)).b) : ((ebn) (obj)).b == null) && (i != null ? i.equals(((ebn) (obj)).i) : ((ebn) (obj)).i == null) && (j != null ? j.equals(((ebn) (obj)).j) : ((ebn) (obj)).j == null) && (c != null ? c.equals(((ebn) (obj)).c) : ((ebn) (obj)).c == null) && (k != null ? k.equals(((ebn) (obj)).k) : ((ebn) (obj)).k == null) && (l != null ? l.equals(((ebn) (obj)).l) : ((ebn) (obj)).l == null) && (d == ((ebn) (obj)).d && e == ((ebn) (obj)).e) && (f != null ? f.equals(((ebn) (obj)).f) : ((ebn) (obj)).f == null) && m == ((ebn) (obj)).m && (n != null ? n.equals(((ebn) (obj)).n) : ((ebn) (obj)).n == null) && (g != null ? g.equals(((ebn) (obj)).g) : ((ebn) (obj)).g == null) && (Arrays.equals(o, ((ebn) (obj)).o) && Arrays.equals(h, ((ebn) (obj)).h)) && (p != null ? p.equals(((ebn) (obj)).p) : ((ebn) (obj)).p == null) && (q != null ? q.equals(((ebn) (obj)).q) : ((ebn) (obj)).q == null) && (r != null ? r.equals(((ebn) (obj)).r) : ((ebn) (obj)).r == null) && s == ((ebn) (obj)).s && (t != null ? t.equals(((ebn) (obj)).t) : ((ebn) (obj)).t == null) && (u != null ? u.equals(((ebn) (obj)).u) : ((ebn) (obj)).u == null) && (v != null ? v.equals(((ebn) (obj)).v) : ((ebn) (obj)).v == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ebn) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ebn) (obj)).O))
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
        int k2;
        int l2;
        int i3 = 1;
        boolean flag = false;
        int i4 = getClass().getName().hashCode();
        int j3;
        int k3;
        int l3;
        int j4;
        if (a == null)
        {
            i1 = 0;
        } else
        {
            i1 = a.hashCode();
        }
        if (b == null)
        {
            j1 = 0;
        } else
        {
            j1 = b.hashCode();
        }
        if (i == null)
        {
            k1 = 0;
        } else
        {
            k1 = i.hashCode();
        }
        if (j == null)
        {
            l1 = 0;
        } else
        {
            l1 = j.hashCode();
        }
        if (c == null)
        {
            i2 = 0;
        } else
        {
            i2 = c.hashCode();
        }
        if (k == null)
        {
            j2 = 0;
        } else
        {
            j2 = k.hashCode();
        }
        if (l == null)
        {
            k2 = 0;
        } else
        {
            k2 = l.hashCode();
        }
        if (d)
        {
            l2 = 1;
        } else
        {
            l2 = 2;
        }
        if (!e)
        {
            i3 = 2;
        }
        if (f == null)
        {
            j3 = 0;
        } else
        {
            j3 = f.hashCode();
        }
        j4 = m;
        if (n == null)
        {
            k3 = 0;
        } else
        {
            k3 = n.hashCode();
        }
        if (g == null)
        {
            l3 = 0;
        } else
        {
            l3 = g.hashCode();
        }
        i1 = l3 + (k3 + ((j3 + ((l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (i4 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3) * 31) * 31 + j4) * 31) * 31;
        if (o != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L6:
        if (h != null) goto _L4; else goto _L3
_L3:
        i1 = j1 * 31;
_L9:
        if (p == null)
        {
            j1 = 0;
        } else
        {
            j1 = p.hashCode();
        }
        if (q == null)
        {
            k1 = 0;
        } else
        {
            k1 = q.hashCode();
        }
        if (r == null)
        {
            l1 = 0;
        } else
        {
            l1 = r.hashCode();
        }
        i3 = s;
        if (t == null)
        {
            i2 = 0;
        } else
        {
            i2 = t.hashCode();
        }
        if (u == null)
        {
            j2 = 0;
        } else
        {
            j2 = u.hashCode();
        }
        if (v == null)
        {
            k2 = 0;
        } else
        {
            k2 = v.hashCode();
        }
        if (O == null)
        {
            l2 = ((flag) ? 1 : 0);
        } else
        {
            l2 = O.hashCode();
        }
        return (k2 + (j2 + (i2 + ((l1 + (k1 + (j1 + i1 * 31) * 31) * 31) * 31 + i3) * 31) * 31) * 31) * 31 + l2;
_L2:
        k1 = 0;
_L7:
        j1 = i1;
        if (k1 >= o.length) goto _L6; else goto _L5
_L5:
        if (o[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = o[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L7
          goto _L6
_L4:
        k1 = 0;
_L10:
        i1 = j1;
        if (k1 >= h.length) goto _L9; else goto _L8
_L8:
        j1 = j1 * 31 + h[k1];
        k1++;
          goto _L10
    }
}
