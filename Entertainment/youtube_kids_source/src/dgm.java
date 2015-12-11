// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dgm extends eul
{

    private dlb a;
    private dbj b[];
    private dbj c[];
    private dlb d;
    private dlb e;
    private dlb f;
    private dyb g;
    private dri h;
    private dsp i;
    private eao j;
    private dre k;
    private String l;
    private String m;
    private boolean n;
    private dxa o[];
    private String p;

    public dgm()
    {
        a = null;
        b = dbj.a;
        c = dbj.a;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = "";
        m = "";
        n = false;
        o = dxa.a;
        p = "";
    }

    public final int a()
    {
        boolean flag = false;
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
            dbj adbj[] = b;
            int j2 = adbj.length;
            int k1 = 0;
            do
            {
                i1 = j1;
                if (k1 >= j2)
                {
                    break;
                }
                dbj dbj1 = adbj[k1];
                i1 = j1;
                if (dbj1 != null)
                {
                    i1 = j1 + euj.b(2, dbj1);
                }
                k1++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (c != null)
        {
            dbj adbj1[] = c;
            int k2 = adbj1.length;
            int l1 = 0;
            do
            {
                j1 = i1;
                if (l1 >= k2)
                {
                    break;
                }
                dbj dbj2 = adbj1[l1];
                j1 = i1;
                if (dbj2 != null)
                {
                    j1 = i1 + euj.b(3, dbj2);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1 + euj.b(4, d);
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1 + euj.b(5, e);
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(6, f);
        }
        j1 = i1;
        if (g != null)
        {
            j1 = i1 + euj.b(7, g);
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1 + euj.b(8, h);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1 + euj.b(9, i);
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1 + euj.b(11, j);
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1 + euj.b(12, k);
        }
        i1 = j1;
        if (!l.equals(""))
        {
            i1 = j1 + euj.b(13, l);
        }
        j1 = i1;
        if (!m.equals(""))
        {
            j1 = i1 + euj.b(14, m);
        }
        i1 = j1;
        if (n)
        {
            boolean flag1 = n;
            i1 = j1 + (euj.b(15) + 1);
        }
        j1 = i1;
        if (o != null)
        {
            dxa adxa[] = o;
            int l2 = adxa.length;
            int i2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (i2 >= l2)
                {
                    break;
                }
                dxa dxa1 = adxa[i2];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(16, dxa1);
                }
                i2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (!p.equals(""))
        {
            i1 = j1 + euj.b(17, p);
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

            case 10: // '\n'
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                int i2 = eup.a(eui1, 18);
                dbj adbj[];
                int j1;
                if (b == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = b.length;
                }
                adbj = new dbj[i2 + j1];
                if (b != null)
                {
                    System.arraycopy(b, 0, adbj, 0, j1);
                }
                for (b = adbj; j1 < b.length - 1; j1++)
                {
                    b[j1] = new dbj();
                    eui1.a(b[j1]);
                    eui1.a();
                }

                b[j1] = new dbj();
                eui1.a(b[j1]);
                break;

            case 26: // '\032'
                int j2 = eup.a(eui1, 26);
                dbj adbj1[];
                int k1;
                if (c == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = c.length;
                }
                adbj1 = new dbj[j2 + k1];
                if (c != null)
                {
                    System.arraycopy(c, 0, adbj1, 0, k1);
                }
                for (c = adbj1; k1 < c.length - 1; k1++)
                {
                    c[k1] = new dbj();
                    eui1.a(c[k1]);
                    eui1.a();
                }

                c[k1] = new dbj();
                eui1.a(c[k1]);
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 58: // ':'
                if (g == null)
                {
                    g = new dyb();
                }
                eui1.a(g);
                break;

            case 66: // 'B'
                if (h == null)
                {
                    h = new dri();
                }
                eui1.a(h);
                break;

            case 74: // 'J'
                if (i == null)
                {
                    i = new dsp();
                }
                eui1.a(i);
                break;

            case 90: // 'Z'
                if (j == null)
                {
                    j = new eao();
                }
                eui1.a(j);
                break;

            case 98: // 'b'
                if (k == null)
                {
                    k = new dre();
                }
                eui1.a(k);
                break;

            case 106: // 'j'
                l = eui1.f();
                break;

            case 114: // 'r'
                m = eui1.f();
                break;

            case 120: // 'x'
                n = eui1.e();
                break;

            case 130: 
                int k2 = eup.a(eui1, 130);
                dxa adxa[];
                int l1;
                if (o == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = o.length;
                }
                adxa = new dxa[k2 + l1];
                if (o != null)
                {
                    System.arraycopy(o, 0, adxa, 0, l1);
                }
                for (o = adxa; l1 < o.length - 1; l1++)
                {
                    o[l1] = new dxa();
                    eui1.a(o[l1]);
                    eui1.a();
                }

                o[l1] = new dxa();
                eui1.a(o[l1]);
                break;

            case 138: 
                p = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            dbj adbj[] = b;
            int l1 = adbj.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                dbj dbj1 = adbj[i1];
                if (dbj1 != null)
                {
                    euj1.a(2, dbj1);
                }
            }

        }
        if (c != null)
        {
            dbj adbj1[] = c;
            int i2 = adbj1.length;
            for (int j1 = 0; j1 < i2; j1++)
            {
                dbj dbj2 = adbj1[j1];
                if (dbj2 != null)
                {
                    euj1.a(3, dbj2);
                }
            }

        }
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f != null)
        {
            euj1.a(6, f);
        }
        if (g != null)
        {
            euj1.a(7, g);
        }
        if (h != null)
        {
            euj1.a(8, h);
        }
        if (i != null)
        {
            euj1.a(9, i);
        }
        if (j != null)
        {
            euj1.a(11, j);
        }
        if (k != null)
        {
            euj1.a(12, k);
        }
        if (!l.equals(""))
        {
            euj1.a(13, l);
        }
        if (!m.equals(""))
        {
            euj1.a(14, m);
        }
        if (n)
        {
            euj1.a(15, n);
        }
        if (o != null)
        {
            dxa adxa[] = o;
            int j2 = adxa.length;
            for (int k1 = ((flag) ? 1 : 0); k1 < j2; k1++)
            {
                dxa dxa1 = adxa[k1];
                if (dxa1 != null)
                {
                    euj1.a(16, dxa1);
                }
            }

        }
        if (!p.equals(""))
        {
            euj1.a(17, p);
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
            if (!(obj instanceof dgm))
            {
                return false;
            }
            obj = (dgm)obj;
            if ((a != null ? a.equals(((dgm) (obj)).a) : ((dgm) (obj)).a == null) && (Arrays.equals(b, ((dgm) (obj)).b) && Arrays.equals(c, ((dgm) (obj)).c)) && (d != null ? d.equals(((dgm) (obj)).d) : ((dgm) (obj)).d == null) && (e != null ? e.equals(((dgm) (obj)).e) : ((dgm) (obj)).e == null) && (f != null ? f.equals(((dgm) (obj)).f) : ((dgm) (obj)).f == null) && (g != null ? g.equals(((dgm) (obj)).g) : ((dgm) (obj)).g == null) && (h != null ? h.equals(((dgm) (obj)).h) : ((dgm) (obj)).h == null) && (i != null ? i.equals(((dgm) (obj)).i) : ((dgm) (obj)).i == null) && (j != null ? j.equals(((dgm) (obj)).j) : ((dgm) (obj)).j == null) && (k != null ? k.equals(((dgm) (obj)).k) : ((dgm) (obj)).k == null) && (l != null ? l.equals(((dgm) (obj)).l) : ((dgm) (obj)).l == null) && (m != null ? m.equals(((dgm) (obj)).m) : ((dgm) (obj)).m == null) && (n == ((dgm) (obj)).n && Arrays.equals(o, ((dgm) (obj)).o)) && (p != null ? p.equals(((dgm) (obj)).p) : ((dgm) (obj)).p == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dgm) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dgm) (obj)).O))
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
        boolean flag = false;
        j1 = getClass().getName().hashCode();
        if (a == null)
        {
            i1 = 0;
        } else
        {
            i1 = a.hashCode();
        }
        i1 += (j1 + 527) * 31;
        if (b != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L8:
        if (c != null) goto _L4; else goto _L3
_L3:
        j1 *= 31;
_L11:
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
        }
        if (e == null)
        {
            k1 = 0;
        } else
        {
            k1 = e.hashCode();
        }
        if (f == null)
        {
            l1 = 0;
        } else
        {
            l1 = f.hashCode();
        }
        if (g == null)
        {
            i2 = 0;
        } else
        {
            i2 = g.hashCode();
        }
        if (h == null)
        {
            j2 = 0;
        } else
        {
            j2 = h.hashCode();
        }
        if (i == null)
        {
            k2 = 0;
        } else
        {
            k2 = i.hashCode();
        }
        if (j == null)
        {
            l2 = 0;
        } else
        {
            l2 = j.hashCode();
        }
        if (k == null)
        {
            i3 = 0;
        } else
        {
            i3 = k.hashCode();
        }
        if (l == null)
        {
            j3 = 0;
        } else
        {
            j3 = l.hashCode();
        }
        if (m == null)
        {
            k3 = 0;
        } else
        {
            k3 = m.hashCode();
        }
        if (n)
        {
            l3 = 1;
        } else
        {
            l3 = 2;
        }
        i1 = l3 + (k3 + (j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (o != null) goto _L6; else goto _L5
_L5:
        j1 = i1 * 31;
_L14:
        if (p == null)
        {
            i1 = 0;
        } else
        {
            i1 = p.hashCode();
        }
        if (O == null)
        {
            k1 = ((flag) ? 1 : 0);
        } else
        {
            k1 = O.hashCode();
        }
        return (i1 + j1 * 31) * 31 + k1;
_L2:
        k1 = 0;
_L9:
        j1 = i1;
        if (k1 >= b.length) goto _L8; else goto _L7
_L7:
        if (b[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = b[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L9
          goto _L8
_L4:
        k1 = 0;
        i1 = j1;
_L12:
        j1 = i1;
        if (k1 >= c.length) goto _L11; else goto _L10
_L10:
        if (c[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = c[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L12
          goto _L11
_L6:
        k1 = 0;
_L15:
        j1 = i1;
        if (k1 >= o.length) goto _L14; else goto _L13
_L13:
        if (o[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = o[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L15
    }
}
