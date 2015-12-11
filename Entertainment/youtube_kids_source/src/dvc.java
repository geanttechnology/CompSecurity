// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dvc extends eul
{

    public dre a;
    public dfq b[];
    public byte c[];
    private String d;
    private dzp e;
    private dlb f;
    private dlb g;
    private dlb h;
    private dlb i;
    private String j;
    private String k;
    private long l;
    private float m;
    private float n;
    private dxa o[];
    private dvb p;
    private boolean q;
    private dqi r;
    private dzp s;
    private dre t;
    private boolean u;
    private dnz v;

    public dvc()
    {
        d = "";
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        a = null;
        j = "";
        b = dfq.a;
        k = "";
        l = 0L;
        m = 0.0F;
        n = 0.0F;
        o = dxa.a;
        p = null;
        c = eup.f;
        q = false;
        r = null;
        s = null;
        t = null;
        u = false;
        v = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int l1;
        if (!d.equals(""))
        {
            j1 = euj.b(1, d) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (e != null)
        {
            i1 = j1 + euj.b(2, e);
        }
        j1 = i1;
        if (f != null)
        {
            j1 = i1 + euj.b(3, f);
        }
        i1 = j1;
        if (g != null)
        {
            i1 = j1 + euj.b(4, g);
        }
        j1 = i1;
        if (h != null)
        {
            j1 = i1 + euj.b(5, h);
        }
        i1 = j1;
        if (i != null)
        {
            i1 = j1 + euj.b(6, i);
        }
        j1 = i1;
        if (a != null)
        {
            j1 = i1 + euj.b(7, a);
        }
        i1 = j1;
        if (!j.equals(""))
        {
            i1 = j1 + euj.b(8, j);
        }
        j1 = i1;
        if (b != null)
        {
            dfq adfq[] = b;
            int j2 = adfq.length;
            int k1 = 0;
            do
            {
                j1 = i1;
                if (k1 >= j2)
                {
                    break;
                }
                dfq dfq1 = adfq[k1];
                j1 = i1;
                if (dfq1 != null)
                {
                    j1 = i1 + euj.b(9, dfq1);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (!k.equals(""))
        {
            i1 = j1 + euj.b(10, k);
        }
        j1 = i1;
        if (l != 0L)
        {
            j1 = i1 + euj.c(11, l);
        }
        l1 = j1;
        if (m != 0.0F)
        {
            float f1 = m;
            l1 = j1 + (euj.b(12) + 4);
        }
        i1 = l1;
        if (n != 0.0F)
        {
            float f2 = n;
            i1 = l1 + (euj.b(13) + 4);
        }
        j1 = i1;
        if (o != null)
        {
            dxa adxa[] = o;
            int k2 = adxa.length;
            int i2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (i2 >= k2)
                {
                    break;
                }
                dxa dxa1 = adxa[i2];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(14, dxa1);
                }
                i2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (p != null)
        {
            i1 = j1 + euj.b(15, p);
        }
        j1 = i1;
        if (!Arrays.equals(c, eup.f))
        {
            j1 = i1 + euj.b(17, c);
        }
        i1 = j1;
        if (q)
        {
            boolean flag1 = q;
            i1 = j1 + (euj.b(18) + 1);
        }
        j1 = i1;
        if (r != null)
        {
            j1 = i1 + euj.b(19, r);
        }
        i1 = j1;
        if (s != null)
        {
            i1 = j1 + euj.b(20, s);
        }
        j1 = i1;
        if (t != null)
        {
            j1 = i1 + euj.b(21, t);
        }
        i1 = j1;
        if (u)
        {
            boolean flag2 = u;
            i1 = j1 + (euj.b(22) + 1);
        }
        j1 = i1;
        if (v != null)
        {
            j1 = i1 + euj.b(0x39d6d44, v);
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
                d = eui1.f();
                break;

            case 18: // '\022'
                if (e == null)
                {
                    e = new dzp();
                }
                eui1.a(e);
                break;

            case 26: // '\032'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 34: // '"'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 42: // '*'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 50: // '2'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 58: // ':'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 66: // 'B'
                j = eui1.f();
                break;

            case 74: // 'J'
                int l1 = eup.a(eui1, 74);
                dfq adfq[];
                int j1;
                if (b == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = b.length;
                }
                adfq = new dfq[l1 + j1];
                if (b != null)
                {
                    System.arraycopy(b, 0, adfq, 0, j1);
                }
                for (b = adfq; j1 < b.length - 1; j1++)
                {
                    b[j1] = new dfq();
                    eui1.a(b[j1]);
                    eui1.a();
                }

                b[j1] = new dfq();
                eui1.a(b[j1]);
                break;

            case 82: // 'R'
                k = eui1.f();
                break;

            case 88: // 'X'
                l = eui1.b();
                break;

            case 101: // 'e'
                m = Float.intBitsToFloat(eui1.i());
                break;

            case 109: // 'm'
                n = Float.intBitsToFloat(eui1.i());
                break;

            case 114: // 'r'
                int i2 = eup.a(eui1, 114);
                dxa adxa[];
                int k1;
                if (o == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = o.length;
                }
                adxa = new dxa[i2 + k1];
                if (o != null)
                {
                    System.arraycopy(o, 0, adxa, 0, k1);
                }
                for (o = adxa; k1 < o.length - 1; k1++)
                {
                    o[k1] = new dxa();
                    eui1.a(o[k1]);
                    eui1.a();
                }

                o[k1] = new dxa();
                eui1.a(o[k1]);
                break;

            case 122: // 'z'
                if (p == null)
                {
                    p = new dvb();
                }
                eui1.a(p);
                break;

            case 138: 
                c = eui1.g();
                break;

            case 144: 
                q = eui1.e();
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
                    s = new dzp();
                }
                eui1.a(s);
                break;

            case 170: 
                if (t == null)
                {
                    t = new dre();
                }
                eui1.a(t);
                break;

            case 176: 
                u = eui1.e();
                break;

            case 485190178: 
                if (v == null)
                {
                    v = new dnz();
                }
                eui1.a(v);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!d.equals(""))
        {
            euj1.a(1, d);
        }
        if (e != null)
        {
            euj1.a(2, e);
        }
        if (f != null)
        {
            euj1.a(3, f);
        }
        if (g != null)
        {
            euj1.a(4, g);
        }
        if (h != null)
        {
            euj1.a(5, h);
        }
        if (i != null)
        {
            euj1.a(6, i);
        }
        if (a != null)
        {
            euj1.a(7, a);
        }
        if (!j.equals(""))
        {
            euj1.a(8, j);
        }
        if (b != null)
        {
            dfq adfq[] = b;
            int k1 = adfq.length;
            for (int i1 = 0; i1 < k1; i1++)
            {
                dfq dfq1 = adfq[i1];
                if (dfq1 != null)
                {
                    euj1.a(9, dfq1);
                }
            }

        }
        if (!k.equals(""))
        {
            euj1.a(10, k);
        }
        if (l != 0L)
        {
            euj1.a(11, l);
        }
        if (m != 0.0F)
        {
            euj1.a(12, m);
        }
        if (n != 0.0F)
        {
            euj1.a(13, n);
        }
        if (o != null)
        {
            dxa adxa[] = o;
            int l1 = adxa.length;
            for (int j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
            {
                dxa dxa1 = adxa[j1];
                if (dxa1 != null)
                {
                    euj1.a(14, dxa1);
                }
            }

        }
        if (p != null)
        {
            euj1.a(15, p);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(17, c);
        }
        if (q)
        {
            euj1.a(18, q);
        }
        if (r != null)
        {
            euj1.a(19, r);
        }
        if (s != null)
        {
            euj1.a(20, s);
        }
        if (t != null)
        {
            euj1.a(21, t);
        }
        if (u)
        {
            euj1.a(22, u);
        }
        if (v != null)
        {
            euj1.a(0x39d6d44, v);
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
            if (!(obj instanceof dvc))
            {
                return false;
            }
            obj = (dvc)obj;
            if ((d != null ? d.equals(((dvc) (obj)).d) : ((dvc) (obj)).d == null) && (e != null ? e.equals(((dvc) (obj)).e) : ((dvc) (obj)).e == null) && (f != null ? f.equals(((dvc) (obj)).f) : ((dvc) (obj)).f == null) && (g != null ? g.equals(((dvc) (obj)).g) : ((dvc) (obj)).g == null) && (h != null ? h.equals(((dvc) (obj)).h) : ((dvc) (obj)).h == null) && (i != null ? i.equals(((dvc) (obj)).i) : ((dvc) (obj)).i == null) && (a != null ? a.equals(((dvc) (obj)).a) : ((dvc) (obj)).a == null) && (j != null ? j.equals(((dvc) (obj)).j) : ((dvc) (obj)).j == null) && Arrays.equals(b, ((dvc) (obj)).b) && (k != null ? k.equals(((dvc) (obj)).k) : ((dvc) (obj)).k == null) && (l == ((dvc) (obj)).l && m == ((dvc) (obj)).m && n == ((dvc) (obj)).n && Arrays.equals(o, ((dvc) (obj)).o)) && (p != null ? p.equals(((dvc) (obj)).p) : ((dvc) (obj)).p == null) && (Arrays.equals(c, ((dvc) (obj)).c) && q == ((dvc) (obj)).q) && (r != null ? r.equals(((dvc) (obj)).r) : ((dvc) (obj)).r == null) && (s != null ? s.equals(((dvc) (obj)).s) : ((dvc) (obj)).s == null) && (t != null ? t.equals(((dvc) (obj)).t) : ((dvc) (obj)).t == null) && u == ((dvc) (obj)).u && (v != null ? v.equals(((dvc) (obj)).v) : ((dvc) (obj)).v == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dvc) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dvc) (obj)).O))
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
        boolean flag1 = true;
        boolean flag = false;
        int i3 = getClass().getName().hashCode();
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
        }
        if (e == null)
        {
            j1 = 0;
        } else
        {
            j1 = e.hashCode();
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
        if (a == null)
        {
            k2 = 0;
        } else
        {
            k2 = a.hashCode();
        }
        if (j == null)
        {
            l2 = 0;
        } else
        {
            l2 = j.hashCode();
        }
        i1 = l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (i3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (b != null) goto _L2; else goto _L1
_L1:
        k1 = i1 * 31;
_L8:
        if (k == null)
        {
            i1 = 0;
        } else
        {
            i1 = k.hashCode();
        }
        i1 = (((i1 + k1 * 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(m)) * 31 + Float.floatToIntBits(n);
        if (o != null) goto _L4; else goto _L3
_L3:
        k1 = i1 * 31;
_L11:
        if (p == null)
        {
            i1 = 0;
        } else
        {
            i1 = p.hashCode();
        }
        i1 += k1 * 31;
        if (c != null) goto _L6; else goto _L5
_L5:
        j1 = i1 * 31;
_L14:
        if (q)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        if (r == null)
        {
            k1 = 0;
        } else
        {
            k1 = r.hashCode();
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
        if (u)
        {
            j2 = ((flag1) ? 1 : 0);
        } else
        {
            j2 = 2;
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
        return (k2 + ((i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31 + j2) * 31) * 31 + l2;
_L2:
        j1 = 0;
_L9:
        k1 = i1;
        if (j1 >= b.length) goto _L8; else goto _L7
_L7:
        if (b[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = b[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L9
          goto _L8
_L4:
        j1 = 0;
_L12:
        k1 = i1;
        if (j1 >= o.length) goto _L11; else goto _L10
_L10:
        if (o[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = o[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L12
          goto _L11
_L6:
        k1 = 0;
_L15:
        j1 = i1;
        if (k1 >= c.length) goto _L14; else goto _L13
_L13:
        i1 = i1 * 31 + c[k1];
        k1++;
          goto _L15
    }
}
