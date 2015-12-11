// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class duv extends eul
{

    public String a;
    public dlb b;
    public long c;
    public dre d;
    public dlb e;
    public dlb f;
    public byte g[];
    private dzp h[];
    private dlb i;
    private dlb j;
    private dui k[];
    private dcr l;
    private String m;
    private doy n;
    private dlb o;
    private dlb p;
    private dfq q[];
    private dqi r;
    private dux s;

    public duv()
    {
        a = "";
        b = null;
        h = dzp.a;
        c = 0L;
        d = null;
        i = null;
        j = null;
        e = null;
        k = dui.a;
        l = null;
        m = "";
        f = null;
        n = null;
        g = eup.f;
        o = null;
        p = null;
        q = dfq.a;
        r = null;
        s = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        if (!a.equals(""))
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
        if (h != null)
        {
            dzp adzp[] = h;
            int j2 = adzp.length;
            int k1 = 0;
            do
            {
                j1 = i1;
                if (k1 >= j2)
                {
                    break;
                }
                dzp dzp1 = adzp[k1];
                j1 = i1;
                if (dzp1 != null)
                {
                    j1 = i1 + euj.b(3, dzp1);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (c != 0L)
        {
            i1 = j1 + euj.d(4, c);
        }
        j1 = i1;
        if (d != null)
        {
            j1 = i1 + euj.b(5, d);
        }
        i1 = j1;
        if (i != null)
        {
            i1 = j1 + euj.b(6, i);
        }
        j1 = i1;
        if (j != null)
        {
            j1 = i1 + euj.b(7, j);
        }
        i1 = j1;
        if (e != null)
        {
            i1 = j1 + euj.b(8, e);
        }
        j1 = i1;
        if (k != null)
        {
            dui adui[] = k;
            int k2 = adui.length;
            int l1 = 0;
            do
            {
                j1 = i1;
                if (l1 >= k2)
                {
                    break;
                }
                dui dui1 = adui[l1];
                j1 = i1;
                if (dui1 != null)
                {
                    j1 = i1 + euj.b(9, dui1);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1 + euj.b(10, l);
        }
        j1 = i1;
        if (!m.equals(""))
        {
            j1 = i1 + euj.b(11, m);
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(13, f);
        }
        j1 = i1;
        if (n != null)
        {
            j1 = i1 + euj.b(14, n);
        }
        i1 = j1;
        if (!Arrays.equals(g, eup.f))
        {
            i1 = j1 + euj.b(15, g);
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
            dfq adfq[] = q;
            int l2 = adfq.length;
            int i2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (i2 >= l2)
                {
                    break;
                }
                dfq dfq1 = adfq[i2];
                j1 = i1;
                if (dfq1 != null)
                {
                    j1 = i1 + euj.b(18, dfq1);
                }
                i2++;
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
                a = eui1.f();
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                int i2 = eup.a(eui1, 26);
                dzp adzp[];
                int j1;
                if (h == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = h.length;
                }
                adzp = new dzp[i2 + j1];
                if (h != null)
                {
                    System.arraycopy(h, 0, adzp, 0, j1);
                }
                for (h = adzp; j1 < h.length - 1; j1++)
                {
                    h[j1] = new dzp();
                    eui1.a(h[j1]);
                    eui1.a();
                }

                h[j1] = new dzp();
                eui1.a(h[j1]);
                break;

            case 32: // ' '
                c = eui1.c();
                break;

            case 42: // '*'
                if (d == null)
                {
                    d = new dre();
                }
                eui1.a(d);
                break;

            case 50: // '2'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 58: // ':'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 66: // 'B'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 74: // 'J'
                int j2 = eup.a(eui1, 74);
                dui adui[];
                int k1;
                if (k == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = k.length;
                }
                adui = new dui[j2 + k1];
                if (k != null)
                {
                    System.arraycopy(k, 0, adui, 0, k1);
                }
                for (k = adui; k1 < k.length - 1; k1++)
                {
                    k[k1] = new dui();
                    eui1.a(k[k1]);
                    eui1.a();
                }

                k[k1] = new dui();
                eui1.a(k[k1]);
                break;

            case 82: // 'R'
                if (l == null)
                {
                    l = new dcr();
                }
                eui1.a(l);
                break;

            case 90: // 'Z'
                m = eui1.f();
                break;

            case 106: // 'j'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 114: // 'r'
                if (n == null)
                {
                    n = new doy();
                }
                eui1.a(n);
                break;

            case 122: // 'z'
                g = eui1.g();
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
                    p = new dlb();
                }
                eui1.a(p);
                break;

            case 146: 
                int k2 = eup.a(eui1, 146);
                dfq adfq[];
                int l1;
                if (q == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = q.length;
                }
                adfq = new dfq[k2 + l1];
                if (q != null)
                {
                    System.arraycopy(q, 0, adfq, 0, l1);
                }
                for (q = adfq; l1 < q.length - 1; l1++)
                {
                    q[l1] = new dfq();
                    eui1.a(q[l1]);
                    eui1.a();
                }

                q[l1] = new dfq();
                eui1.a(q[l1]);
                break;

            case 154: 
                if (r == null)
                {
                    r = new dqi();
                }
                eui1.a(r);
                break;

            case 162: 
                if (s == null)
                {
                    s = new dux();
                }
                eui1.a(s);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!a.equals(""))
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (h != null)
        {
            dzp adzp[] = h;
            int l1 = adzp.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                dzp dzp1 = adzp[i1];
                if (dzp1 != null)
                {
                    euj1.a(3, dzp1);
                }
            }

        }
        if (c != 0L)
        {
            euj1.b(4, c);
        }
        if (d != null)
        {
            euj1.a(5, d);
        }
        if (i != null)
        {
            euj1.a(6, i);
        }
        if (j != null)
        {
            euj1.a(7, j);
        }
        if (e != null)
        {
            euj1.a(8, e);
        }
        if (k != null)
        {
            dui adui[] = k;
            int i2 = adui.length;
            for (int j1 = 0; j1 < i2; j1++)
            {
                dui dui1 = adui[j1];
                if (dui1 != null)
                {
                    euj1.a(9, dui1);
                }
            }

        }
        if (l != null)
        {
            euj1.a(10, l);
        }
        if (!m.equals(""))
        {
            euj1.a(11, m);
        }
        if (f != null)
        {
            euj1.a(13, f);
        }
        if (n != null)
        {
            euj1.a(14, n);
        }
        if (!Arrays.equals(g, eup.f))
        {
            euj1.a(15, g);
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
            dfq adfq[] = q;
            int j2 = adfq.length;
            for (int k1 = ((flag) ? 1 : 0); k1 < j2; k1++)
            {
                dfq dfq1 = adfq[k1];
                if (dfq1 != null)
                {
                    euj1.a(18, dfq1);
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
            if (!(obj instanceof duv))
            {
                return false;
            }
            obj = (duv)obj;
            if ((a != null ? a.equals(((duv) (obj)).a) : ((duv) (obj)).a == null) && (b != null ? b.equals(((duv) (obj)).b) : ((duv) (obj)).b == null) && (Arrays.equals(h, ((duv) (obj)).h) && c == ((duv) (obj)).c) && (d != null ? d.equals(((duv) (obj)).d) : ((duv) (obj)).d == null) && (i != null ? i.equals(((duv) (obj)).i) : ((duv) (obj)).i == null) && (j != null ? j.equals(((duv) (obj)).j) : ((duv) (obj)).j == null) && (e != null ? e.equals(((duv) (obj)).e) : ((duv) (obj)).e == null) && Arrays.equals(k, ((duv) (obj)).k) && (l != null ? l.equals(((duv) (obj)).l) : ((duv) (obj)).l == null) && (m != null ? m.equals(((duv) (obj)).m) : ((duv) (obj)).m == null) && (f != null ? f.equals(((duv) (obj)).f) : ((duv) (obj)).f == null) && (n != null ? n.equals(((duv) (obj)).n) : ((duv) (obj)).n == null) && Arrays.equals(g, ((duv) (obj)).g) && (o != null ? o.equals(((duv) (obj)).o) : ((duv) (obj)).o == null) && (p != null ? p.equals(((duv) (obj)).p) : ((duv) (obj)).p == null) && Arrays.equals(q, ((duv) (obj)).q) && (r != null ? r.equals(((duv) (obj)).r) : ((duv) (obj)).r == null) && (s != null ? s.equals(((duv) (obj)).s) : ((duv) (obj)).s == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((duv) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((duv) (obj)).O))
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
        boolean flag = false;
        k1 = getClass().getName().hashCode();
        int j2;
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
        i1 = j1 + (i1 + (k1 + 527) * 31) * 31;
        if (h != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L10:
        j2 = (int)(c ^ c >>> 32);
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
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
        if (e == null)
        {
            i2 = 0;
        } else
        {
            i2 = e.hashCode();
        }
        i1 = i2 + (l1 + (k1 + (i1 + (j1 * 31 + j2) * 31) * 31) * 31) * 31;
        if (k != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L13:
        if (l == null)
        {
            i1 = 0;
        } else
        {
            i1 = l.hashCode();
        }
        if (m == null)
        {
            k1 = 0;
        } else
        {
            k1 = m.hashCode();
        }
        if (f == null)
        {
            l1 = 0;
        } else
        {
            l1 = f.hashCode();
        }
        if (n == null)
        {
            i2 = 0;
        } else
        {
            i2 = n.hashCode();
        }
        i1 = i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31;
        if (g != null) goto _L6; else goto _L5
_L5:
        j1 = i1 * 31;
_L16:
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
        if (q != null) goto _L8; else goto _L7
_L7:
        j1 = i1 * 31;
_L19:
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
_L11:
        j1 = i1;
        if (k1 >= h.length) goto _L10; else goto _L9
_L9:
        if (h[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = h[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L11
          goto _L10
_L4:
        k1 = 0;
_L14:
        j1 = i1;
        if (k1 >= k.length) goto _L13; else goto _L12
_L12:
        if (k[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = k[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L14
          goto _L13
_L6:
        k1 = 0;
_L17:
        j1 = i1;
        if (k1 >= g.length) goto _L16; else goto _L15
_L15:
        i1 = i1 * 31 + g[k1];
        k1++;
          goto _L17
          goto _L16
_L8:
        k1 = 0;
_L20:
        j1 = i1;
        if (k1 >= q.length) goto _L19; else goto _L18
_L18:
        if (q[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = q[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L20
    }
}
