// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dzb extends eul
{

    private dlb a;
    private dlb b;
    private boolean c;
    private boolean d;
    private dzf e;
    private int f;
    private String g;
    private boolean h;
    private dlb i;
    private dlb j;
    private eaa k;
    private dlb l;
    private dlb m;
    private byte n[];
    private dlb o;
    private dmb p;
    private dxa q[];
    private dzc r;
    private dlb s;

    public dzb()
    {
        a = null;
        b = null;
        c = false;
        d = false;
        e = null;
        f = 0;
        g = "";
        h = false;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = eup.f;
        o = null;
        p = null;
        q = dxa.a;
        r = null;
        s = null;
    }

    public final int a()
    {
        int k1 = 0;
        int i1;
        int j1;
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
        if (c)
        {
            boolean flag = c;
            j1 = i1 + (euj.b(3) + 1);
        }
        i1 = j1;
        if (d)
        {
            boolean flag1 = d;
            i1 = j1 + (euj.b(4) + 1);
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1 + euj.b(5, e);
        }
        i1 = j1;
        if (f != 0)
        {
            i1 = j1 + euj.c(6, f);
        }
        j1 = i1;
        if (!g.equals(""))
        {
            j1 = i1 + euj.b(7, g);
        }
        i1 = j1;
        if (h)
        {
            boolean flag2 = h;
            i1 = j1 + (euj.b(8) + 1);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1 + euj.b(9, i);
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1 + euj.b(10, j);
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1 + euj.b(11, k);
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1 + euj.b(12, l);
        }
        j1 = i1;
        if (m != null)
        {
            j1 = i1 + euj.b(13, m);
        }
        i1 = j1;
        if (!Arrays.equals(n, eup.f))
        {
            i1 = j1 + euj.b(15, n);
        }
        j1 = i1;
        if (o != null)
        {
            j1 = i1 + euj.b(16, o);
        }
        i1 = j1;
        if (p != null)
        {
            i1 = j1 + euj.b(17, p);
        }
        j1 = i1;
        if (q != null)
        {
            dxa adxa[] = q;
            int l1 = adxa.length;
            do
            {
                j1 = i1;
                if (k1 >= l1)
                {
                    break;
                }
                dxa dxa1 = adxa[k1];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(18, dxa1);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (r != null)
        {
            i1 = j1 + euj.b(19, r);
        }
        j1 = i1;
        if (s != null)
        {
            j1 = i1 + euj.b(20, s);
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

            case 24: // '\030'
                c = eui1.e();
                break;

            case 32: // ' '
                d = eui1.e();
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dzf();
                }
                eui1.a(e);
                break;

            case 48: // '0'
                int j1 = eui1.d();
                if (j1 == 0 || j1 == 1 || j1 == 2)
                {
                    f = j1;
                } else
                {
                    f = 0;
                }
                break;

            case 58: // ':'
                g = eui1.f();
                break;

            case 64: // '@'
                h = eui1.e();
                break;

            case 74: // 'J'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 82: // 'R'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 90: // 'Z'
                if (k == null)
                {
                    k = new eaa();
                }
                eui1.a(k);
                break;

            case 98: // 'b'
                if (l == null)
                {
                    l = new dlb();
                }
                eui1.a(l);
                break;

            case 106: // 'j'
                if (m == null)
                {
                    m = new dlb();
                }
                eui1.a(m);
                break;

            case 122: // 'z'
                n = eui1.g();
                break;

            case 130: 
                if (o == null)
                {
                    o = new dlb();
                }
                eui1.a(o);
                break;

            case 138: 
                if (p == null)
                {
                    p = new dmb();
                }
                eui1.a(p);
                break;

            case 146: 
                int l1 = eup.a(eui1, 146);
                dxa adxa[];
                int k1;
                if (q == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = q.length;
                }
                adxa = new dxa[l1 + k1];
                if (q != null)
                {
                    System.arraycopy(q, 0, adxa, 0, k1);
                }
                for (q = adxa; k1 < q.length - 1; k1++)
                {
                    q[k1] = new dxa();
                    eui1.a(q[k1]);
                    eui1.a();
                }

                q[k1] = new dxa();
                eui1.a(q[k1]);
                break;

            case 154: 
                if (r == null)
                {
                    r = new dzc();
                }
                eui1.a(r);
                break;

            case 162: 
                if (s == null)
                {
                    s = new dlb();
                }
                eui1.a(s);
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
        if (c)
        {
            euj1.a(3, c);
        }
        if (d)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f != 0)
        {
            euj1.a(6, f);
        }
        if (!g.equals(""))
        {
            euj1.a(7, g);
        }
        if (h)
        {
            euj1.a(8, h);
        }
        if (i != null)
        {
            euj1.a(9, i);
        }
        if (j != null)
        {
            euj1.a(10, j);
        }
        if (k != null)
        {
            euj1.a(11, k);
        }
        if (l != null)
        {
            euj1.a(12, l);
        }
        if (m != null)
        {
            euj1.a(13, m);
        }
        if (!Arrays.equals(n, eup.f))
        {
            euj1.a(15, n);
        }
        if (o != null)
        {
            euj1.a(16, o);
        }
        if (p != null)
        {
            euj1.a(17, p);
        }
        if (q != null)
        {
            dxa adxa[] = q;
            int j1 = adxa.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                dxa dxa1 = adxa[i1];
                if (dxa1 != null)
                {
                    euj1.a(18, dxa1);
                }
            }

        }
        if (r != null)
        {
            euj1.a(19, r);
        }
        if (s != null)
        {
            euj1.a(20, s);
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
            if (!(obj instanceof dzb))
            {
                return false;
            }
            obj = (dzb)obj;
            if ((a != null ? a.equals(((dzb) (obj)).a) : ((dzb) (obj)).a == null) && (b != null ? b.equals(((dzb) (obj)).b) : ((dzb) (obj)).b == null) && (c == ((dzb) (obj)).c && d == ((dzb) (obj)).d) && (e != null ? e.equals(((dzb) (obj)).e) : ((dzb) (obj)).e == null) && f == ((dzb) (obj)).f && (g != null ? g.equals(((dzb) (obj)).g) : ((dzb) (obj)).g == null) && h == ((dzb) (obj)).h && (i != null ? i.equals(((dzb) (obj)).i) : ((dzb) (obj)).i == null) && (j != null ? j.equals(((dzb) (obj)).j) : ((dzb) (obj)).j == null) && (k != null ? k.equals(((dzb) (obj)).k) : ((dzb) (obj)).k == null) && (l != null ? l.equals(((dzb) (obj)).l) : ((dzb) (obj)).l == null) && (m != null ? m.equals(((dzb) (obj)).m) : ((dzb) (obj)).m == null) && Arrays.equals(n, ((dzb) (obj)).n) && (o != null ? o.equals(((dzb) (obj)).o) : ((dzb) (obj)).o == null) && (p != null ? p.equals(((dzb) (obj)).p) : ((dzb) (obj)).p == null) && Arrays.equals(q, ((dzb) (obj)).q) && (r != null ? r.equals(((dzb) (obj)).r) : ((dzb) (obj)).r == null) && (s != null ? s.equals(((dzb) (obj)).s) : ((dzb) (obj)).s == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dzb) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dzb) (obj)).O))
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
        int k2 = 1;
        boolean flag = false;
        int i4 = getClass().getName().hashCode();
        int i2;
        int j2;
        int l2;
        int i3;
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
        if (c)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (d)
        {
            l1 = 1;
        } else
        {
            l1 = 2;
        }
        if (e == null)
        {
            i2 = 0;
        } else
        {
            i2 = e.hashCode();
        }
        j4 = f;
        if (g == null)
        {
            j2 = 0;
        } else
        {
            j2 = g.hashCode();
        }
        if (!h)
        {
            k2 = 2;
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
        if (l == null)
        {
            k3 = 0;
        } else
        {
            k3 = l.hashCode();
        }
        if (m == null)
        {
            l3 = 0;
        } else
        {
            l3 = m.hashCode();
        }
        i1 = l3 + (k3 + (j3 + (i3 + (l2 + ((j2 + ((i2 + (l1 + (k1 + (j1 + (i1 + (i4 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + j4) * 31) * 31 + k2) * 31) * 31) * 31) * 31) * 31;
        if (n != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L6:
        if (o == null)
        {
            i1 = 0;
        } else
        {
            i1 = o.hashCode();
        }
        if (p == null)
        {
            k1 = 0;
        } else
        {
            k1 = p.hashCode();
        }
        i1 = k1 + (i1 + j1 * 31) * 31;
        if (q != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L9:
        if (r == null)
        {
            i1 = 0;
        } else
        {
            i1 = r.hashCode();
        }
        if (s == null)
        {
            k1 = 0;
        } else
        {
            k1 = s.hashCode();
        }
        if (O == null)
        {
            l1 = ((flag) ? 1 : 0);
        } else
        {
            l1 = O.hashCode();
        }
        return (k1 + (i1 + j1 * 31) * 31) * 31 + l1;
_L2:
        k1 = 0;
_L7:
        j1 = i1;
        if (k1 >= n.length) goto _L6; else goto _L5
_L5:
        i1 = i1 * 31 + n[k1];
        k1++;
          goto _L7
          goto _L6
_L4:
        k1 = 0;
_L10:
        j1 = i1;
        if (k1 >= q.length) goto _L9; else goto _L8
_L8:
        if (q[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = q[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L10
    }
}
