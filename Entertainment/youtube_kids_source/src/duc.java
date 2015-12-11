// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class duc extends eul
{

    public dsz a;
    public dyz b;
    public dlt c;
    public dtj d[];
    public dti e;
    public dgj f;
    public ebc g;
    public den h[];
    public dsc i;
    public dts j;
    public dnf k;
    public byte l[];
    public dew m;
    public String n;
    public String o;
    public ebu p;
    private dwa q;
    private String r;
    private dyy s;
    private dzn t;
    private String u;
    private dqi v;

    public duc()
    {
        q = null;
        a = null;
        b = null;
        r = "";
        c = null;
        d = dtj.a;
        e = null;
        f = null;
        g = null;
        h = den.a;
        i = null;
        j = null;
        s = null;
        t = null;
        k = null;
        l = eup.f;
        m = null;
        n = "";
        o = "";
        p = null;
        u = "";
        v = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (q != null)
        {
            j1 = euj.b(1, q) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (a != null)
        {
            i1 = j1 + euj.b(2, a);
        }
        j1 = i1;
        if (b != null)
        {
            j1 = i1 + euj.b(4, b);
        }
        k1 = j1;
        if (!r.equals(""))
        {
            k1 = j1 + euj.b(5, r);
        }
        i1 = k1;
        if (c != null)
        {
            i1 = k1 + euj.b(6, c);
        }
        j1 = i1;
        if (d != null)
        {
            dtj adtj[] = d;
            int j2 = adtj.length;
            int l1 = 0;
            do
            {
                j1 = i1;
                if (l1 >= j2)
                {
                    break;
                }
                dtj dtj1 = adtj[l1];
                j1 = i1;
                if (dtj1 != null)
                {
                    j1 = i1 + euj.b(7, dtj1);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (e != null)
        {
            i1 = j1 + euj.b(9, e);
        }
        j1 = i1;
        if (f != null)
        {
            j1 = i1 + euj.b(10, f);
        }
        i1 = j1;
        if (g != null)
        {
            i1 = j1 + euj.b(11, g);
        }
        j1 = i1;
        if (h != null)
        {
            den aden[] = h;
            int k2 = aden.length;
            int i2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (i2 >= k2)
                {
                    break;
                }
                den den1 = aden[i2];
                j1 = i1;
                if (den1 != null)
                {
                    j1 = i1 + euj.b(13, den1);
                }
                i2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (i != null)
        {
            i1 = j1 + euj.b(14, i);
        }
        j1 = i1;
        if (j != null)
        {
            j1 = i1 + euj.b(15, j);
        }
        i1 = j1;
        if (s != null)
        {
            i1 = j1 + euj.b(16, s);
        }
        j1 = i1;
        if (t != null)
        {
            j1 = i1 + euj.b(17, t);
        }
        i1 = j1;
        if (k != null)
        {
            i1 = j1 + euj.b(20, k);
        }
        j1 = i1;
        if (!Arrays.equals(l, eup.f))
        {
            j1 = i1 + euj.b(21, l);
        }
        i1 = j1;
        if (m != null)
        {
            i1 = j1 + euj.b(22, m);
        }
        j1 = i1;
        if (!n.equals(""))
        {
            j1 = i1 + euj.b(23, n);
        }
        i1 = j1;
        if (!o.equals(""))
        {
            i1 = j1 + euj.b(25, o);
        }
        j1 = i1;
        if (p != null)
        {
            j1 = i1 + euj.b(26, p);
        }
        i1 = j1;
        if (!u.equals(""))
        {
            i1 = j1 + euj.b(27, u);
        }
        j1 = i1;
        if (v != null)
        {
            j1 = i1 + euj.b(28, v);
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
                if (q == null)
                {
                    q = new dwa();
                }
                eui1.a(q);
                break;

            case 18: // '\022'
                if (a == null)
                {
                    a = new dsz();
                }
                eui1.a(a);
                break;

            case 34: // '"'
                if (b == null)
                {
                    b = new dyz();
                }
                eui1.a(b);
                break;

            case 42: // '*'
                r = eui1.f();
                break;

            case 50: // '2'
                if (c == null)
                {
                    c = new dlt();
                }
                eui1.a(c);
                break;

            case 58: // ':'
                int l1 = eup.a(eui1, 58);
                dtj adtj[];
                int j1;
                if (d == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = d.length;
                }
                adtj = new dtj[l1 + j1];
                if (d != null)
                {
                    System.arraycopy(d, 0, adtj, 0, j1);
                }
                for (d = adtj; j1 < d.length - 1; j1++)
                {
                    d[j1] = new dtj();
                    eui1.a(d[j1]);
                    eui1.a();
                }

                d[j1] = new dtj();
                eui1.a(d[j1]);
                break;

            case 74: // 'J'
                if (e == null)
                {
                    e = new dti();
                }
                eui1.a(e);
                break;

            case 82: // 'R'
                if (f == null)
                {
                    f = new dgj();
                }
                eui1.a(f);
                break;

            case 90: // 'Z'
                if (g == null)
                {
                    g = new ebc();
                }
                eui1.a(g);
                break;

            case 106: // 'j'
                int i2 = eup.a(eui1, 106);
                den aden[];
                int k1;
                if (h == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = h.length;
                }
                aden = new den[i2 + k1];
                if (h != null)
                {
                    System.arraycopy(h, 0, aden, 0, k1);
                }
                for (h = aden; k1 < h.length - 1; k1++)
                {
                    h[k1] = new den();
                    eui1.a(h[k1]);
                    eui1.a();
                }

                h[k1] = new den();
                eui1.a(h[k1]);
                break;

            case 114: // 'r'
                if (i == null)
                {
                    i = new dsc();
                }
                eui1.a(i);
                break;

            case 122: // 'z'
                if (j == null)
                {
                    j = new dts();
                }
                eui1.a(j);
                break;

            case 130: 
                if (s == null)
                {
                    s = new dyy();
                }
                eui1.a(s);
                break;

            case 138: 
                if (t == null)
                {
                    t = new dzn();
                }
                eui1.a(t);
                break;

            case 162: 
                if (k == null)
                {
                    k = new dnf();
                }
                eui1.a(k);
                break;

            case 170: 
                l = eui1.g();
                break;

            case 178: 
                if (m == null)
                {
                    m = new dew();
                }
                eui1.a(m);
                break;

            case 186: 
                n = eui1.f();
                break;

            case 202: 
                o = eui1.f();
                break;

            case 210: 
                if (p == null)
                {
                    p = new ebu();
                }
                eui1.a(p);
                break;

            case 218: 
                u = eui1.f();
                break;

            case 226: 
                if (v == null)
                {
                    v = new dqi();
                }
                eui1.a(v);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (q != null)
        {
            euj1.a(1, q);
        }
        if (a != null)
        {
            euj1.a(2, a);
        }
        if (b != null)
        {
            euj1.a(4, b);
        }
        if (!r.equals(""))
        {
            euj1.a(5, r);
        }
        if (c != null)
        {
            euj1.a(6, c);
        }
        if (d != null)
        {
            dtj adtj[] = d;
            int k1 = adtj.length;
            for (int i1 = 0; i1 < k1; i1++)
            {
                dtj dtj1 = adtj[i1];
                if (dtj1 != null)
                {
                    euj1.a(7, dtj1);
                }
            }

        }
        if (e != null)
        {
            euj1.a(9, e);
        }
        if (f != null)
        {
            euj1.a(10, f);
        }
        if (g != null)
        {
            euj1.a(11, g);
        }
        if (h != null)
        {
            den aden[] = h;
            int l1 = aden.length;
            for (int j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
            {
                den den1 = aden[j1];
                if (den1 != null)
                {
                    euj1.a(13, den1);
                }
            }

        }
        if (i != null)
        {
            euj1.a(14, i);
        }
        if (j != null)
        {
            euj1.a(15, j);
        }
        if (s != null)
        {
            euj1.a(16, s);
        }
        if (t != null)
        {
            euj1.a(17, t);
        }
        if (k != null)
        {
            euj1.a(20, k);
        }
        if (!Arrays.equals(l, eup.f))
        {
            euj1.a(21, l);
        }
        if (m != null)
        {
            euj1.a(22, m);
        }
        if (!n.equals(""))
        {
            euj1.a(23, n);
        }
        if (!o.equals(""))
        {
            euj1.a(25, o);
        }
        if (p != null)
        {
            euj1.a(26, p);
        }
        if (!u.equals(""))
        {
            euj1.a(27, u);
        }
        if (v != null)
        {
            euj1.a(28, v);
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
            if (!(obj instanceof duc))
            {
                return false;
            }
            obj = (duc)obj;
            if ((q != null ? q.equals(((duc) (obj)).q) : ((duc) (obj)).q == null) && (a != null ? a.equals(((duc) (obj)).a) : ((duc) (obj)).a == null) && (b != null ? b.equals(((duc) (obj)).b) : ((duc) (obj)).b == null) && (r != null ? r.equals(((duc) (obj)).r) : ((duc) (obj)).r == null) && (c != null ? c.equals(((duc) (obj)).c) : ((duc) (obj)).c == null) && Arrays.equals(d, ((duc) (obj)).d) && (e != null ? e.equals(((duc) (obj)).e) : ((duc) (obj)).e == null) && (f != null ? f.equals(((duc) (obj)).f) : ((duc) (obj)).f == null) && (g != null ? g.equals(((duc) (obj)).g) : ((duc) (obj)).g == null) && Arrays.equals(h, ((duc) (obj)).h) && (i != null ? i.equals(((duc) (obj)).i) : ((duc) (obj)).i == null) && (j != null ? j.equals(((duc) (obj)).j) : ((duc) (obj)).j == null) && (s != null ? s.equals(((duc) (obj)).s) : ((duc) (obj)).s == null) && (t != null ? t.equals(((duc) (obj)).t) : ((duc) (obj)).t == null) && (k != null ? k.equals(((duc) (obj)).k) : ((duc) (obj)).k == null) && Arrays.equals(l, ((duc) (obj)).l) && (m != null ? m.equals(((duc) (obj)).m) : ((duc) (obj)).m == null) && (n != null ? n.equals(((duc) (obj)).n) : ((duc) (obj)).n == null) && (o != null ? o.equals(((duc) (obj)).o) : ((duc) (obj)).o == null) && (p != null ? p.equals(((duc) (obj)).p) : ((duc) (obj)).p == null) && (u != null ? u.equals(((duc) (obj)).u) : ((duc) (obj)).u == null) && (v != null ? v.equals(((duc) (obj)).v) : ((duc) (obj)).v == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((duc) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((duc) (obj)).O))
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
        int l2;
        l2 = 0;
        j2 = getClass().getName().hashCode();
        if (q == null)
        {
            i1 = 0;
        } else
        {
            i1 = q.hashCode();
        }
        if (a == null)
        {
            j1 = 0;
        } else
        {
            j1 = a.hashCode();
        }
        if (b == null)
        {
            k1 = 0;
        } else
        {
            k1 = b.hashCode();
        }
        if (r == null)
        {
            l1 = 0;
        } else
        {
            l1 = r.hashCode();
        }
        if (c == null)
        {
            i2 = 0;
        } else
        {
            i2 = c.hashCode();
        }
        i1 = i2 + (l1 + (k1 + (j1 + (i1 + (j2 + 527) * 31) * 31) * 31) * 31) * 31;
        if (d != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L8:
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        if (f == null)
        {
            k1 = 0;
        } else
        {
            k1 = f.hashCode();
        }
        if (g == null)
        {
            l1 = 0;
        } else
        {
            l1 = g.hashCode();
        }
        i1 = l1 + (k1 + (i1 + j1 * 31) * 31) * 31;
        if (h != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L11:
        if (i == null)
        {
            i1 = 0;
        } else
        {
            i1 = i.hashCode();
        }
        if (j == null)
        {
            k1 = 0;
        } else
        {
            k1 = j.hashCode();
        }
        if (s == null)
        {
            l1 = 0;
        } else
        {
            l1 = s.hashCode();
        }
        if (t == null)
        {
            i2 = 0;
        } else
        {
            i2 = t.hashCode();
        }
        if (k == null)
        {
            j2 = 0;
        } else
        {
            j2 = k.hashCode();
        }
        i1 = j2 + (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31;
        if (l != null) goto _L6; else goto _L5
_L5:
        j1 = i1 * 31;
_L14:
        int k2;
        if (m == null)
        {
            i1 = 0;
        } else
        {
            i1 = m.hashCode();
        }
        if (n == null)
        {
            k1 = 0;
        } else
        {
            k1 = n.hashCode();
        }
        if (o == null)
        {
            l1 = 0;
        } else
        {
            l1 = o.hashCode();
        }
        if (p == null)
        {
            i2 = 0;
        } else
        {
            i2 = p.hashCode();
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
        if (O != null)
        {
            l2 = O.hashCode();
        }
        return (k2 + (j2 + (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l2;
_L2:
        k1 = 0;
_L9:
        j1 = i1;
        if (k1 >= d.length) goto _L8; else goto _L7
_L7:
        if (d[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = d[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L9
          goto _L8
_L4:
        k1 = 0;
_L12:
        j1 = i1;
        if (k1 >= h.length) goto _L11; else goto _L10
_L10:
        if (h[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = h[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L12
          goto _L11
_L6:
        k1 = 0;
_L15:
        j1 = i1;
        if (k1 >= l.length) goto _L14; else goto _L13
_L13:
        i1 = i1 * 31 + l[k1];
        k1++;
          goto _L15
    }
}
