// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dts extends eul
{

    public dey a;
    public dkj b;
    public dth c;
    public dck d;
    public drh e;
    public ddx f;
    public dqp g;
    public dow h;
    public dcn i;
    public ddv j;
    private drf k;
    private dlx l;
    private dvn m;
    private dtc n;
    private dwx o;
    private dez p;
    private dfl q;
    private dka r;
    private ddt s;

    public dts()
    {
        k = null;
        l = null;
        m = null;
        n = null;
        a = null;
        b = null;
        o = null;
        c = null;
        p = null;
        q = null;
        d = null;
        e = null;
        f = null;
        r = null;
        g = null;
        h = null;
        i = null;
        j = null;
        s = null;
    }

    public final int a()
    {
        int j1 = 0;
        if (k != null)
        {
            j1 = euj.b(0x3011140, k) + 0;
        }
        int i1 = j1;
        if (l != null)
        {
            i1 = j1 + euj.b(0x329aa9d, l);
        }
        j1 = i1;
        if (m != null)
        {
            j1 = i1 + euj.b(0x329ef44, m);
        }
        i1 = j1;
        if (n != null)
        {
            i1 = j1 + euj.b(0x33449ad, n);
        }
        j1 = i1;
        if (a != null)
        {
            j1 = i1 + euj.b(0x34d6cf6, a);
        }
        i1 = j1;
        if (b != null)
        {
            i1 = j1 + euj.b(0x37256f3, b);
        }
        j1 = i1;
        if (o != null)
        {
            j1 = i1 + euj.b(0x3742f13, o);
        }
        i1 = j1;
        if (c != null)
        {
            i1 = j1 + euj.b(0x39515b9, c);
        }
        j1 = i1;
        if (p != null)
        {
            j1 = i1 + euj.b(0x3a21c49, p);
        }
        i1 = j1;
        if (q != null)
        {
            i1 = j1 + euj.b(0x3b93ca7, q);
        }
        j1 = i1;
        if (d != null)
        {
            j1 = i1 + euj.b(0x4162901, d);
        }
        i1 = j1;
        if (e != null)
        {
            i1 = j1 + euj.b(0x4169166, e);
        }
        j1 = i1;
        if (f != null)
        {
            j1 = i1 + euj.b(0x42440e9, f);
        }
        i1 = j1;
        if (r != null)
        {
            i1 = j1 + euj.b(0x4556327, r);
        }
        j1 = i1;
        if (g != null)
        {
            j1 = i1 + euj.b(0x462c123, g);
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1 + euj.b(0x472f5f4, h);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1 + euj.b(0x4a49c61, i);
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1 + euj.b(0x4b4cf6c, j);
        }
        j1 = i1;
        if (s != null)
        {
            j1 = i1 + euj.b(0x4c16673, s);
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

            case 403212802: 
                if (k == null)
                {
                    k = new drf();
                }
                eui1.a(k);
                break;

            case 424498410: 
                if (l == null)
                {
                    l = new dlx();
                }
                eui1.a(l);
                break;

            case 424639010: 
                if (m == null)
                {
                    m = new dvn();
                }
                eui1.a(m);
                break;

            case 430067050: 
                if (n == null)
                {
                    n = new dtc();
                }
                eui1.a(n);
                break;

            case 443246514: 
                if (a == null)
                {
                    a = new dey();
                }
                eui1.a(a);
                break;

            case 462600090: 
                if (b == null)
                {
                    b = new dkj();
                }
                eui1.a(b);
                break;

            case 463567002: 
                if (o == null)
                {
                    o = new dwx();
                }
                eui1.a(o);
                break;

            case 480816586: 
                if (c == null)
                {
                    c = new dth();
                }
                eui1.a(c);
                break;

            case 487645770: 
                if (p == null)
                {
                    p = new dez();
                }
                eui1.a(p);
                break;

            case 499770682: 
                if (q == null)
                {
                    q = new dfl();
                }
                eui1.a(q);
                break;

            case 548489226: 
                if (d == null)
                {
                    d = new dck();
                }
                eui1.a(d);
                break;

            case 548703026: 
                if (e == null)
                {
                    e = new drh();
                }
                eui1.a(e);
                break;

            case 555878218: 
                if (f == null)
                {
                    f = new ddx();
                }
                eui1.a(f);
                break;

            case 581638458: 
                if (r == null)
                {
                    r = new dka();
                }
                eui1.a(r);
                break;

            case 588646682: 
                if (g == null)
                {
                    g = new dqp();
                }
                eui1.a(g);
                break;

            case 597143458: 
                if (h == null)
                {
                    h = new dow();
                }
                eui1.a(h);
                break;

            case 623174410: 
                if (i == null)
                {
                    i = new dcn();
                }
                eui1.a(i);
                break;

            case 631667554: 
                if (j == null)
                {
                    j = new ddv();
                }
                eui1.a(j);
                break;

            case 638268314: 
                if (s == null)
                {
                    s = new ddt();
                }
                eui1.a(s);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (k != null)
        {
            euj1.a(0x3011140, k);
        }
        if (l != null)
        {
            euj1.a(0x329aa9d, l);
        }
        if (m != null)
        {
            euj1.a(0x329ef44, m);
        }
        if (n != null)
        {
            euj1.a(0x33449ad, n);
        }
        if (a != null)
        {
            euj1.a(0x34d6cf6, a);
        }
        if (b != null)
        {
            euj1.a(0x37256f3, b);
        }
        if (o != null)
        {
            euj1.a(0x3742f13, o);
        }
        if (c != null)
        {
            euj1.a(0x39515b9, c);
        }
        if (p != null)
        {
            euj1.a(0x3a21c49, p);
        }
        if (q != null)
        {
            euj1.a(0x3b93ca7, q);
        }
        if (d != null)
        {
            euj1.a(0x4162901, d);
        }
        if (e != null)
        {
            euj1.a(0x4169166, e);
        }
        if (f != null)
        {
            euj1.a(0x42440e9, f);
        }
        if (r != null)
        {
            euj1.a(0x4556327, r);
        }
        if (g != null)
        {
            euj1.a(0x462c123, g);
        }
        if (h != null)
        {
            euj1.a(0x472f5f4, h);
        }
        if (i != null)
        {
            euj1.a(0x4a49c61, i);
        }
        if (j != null)
        {
            euj1.a(0x4b4cf6c, j);
        }
        if (s != null)
        {
            euj1.a(0x4c16673, s);
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
            if (!(obj instanceof dts))
            {
                return false;
            }
            obj = (dts)obj;
            if ((k != null ? k.equals(((dts) (obj)).k) : ((dts) (obj)).k == null) && (l != null ? l.equals(((dts) (obj)).l) : ((dts) (obj)).l == null) && (m != null ? m.equals(((dts) (obj)).m) : ((dts) (obj)).m == null) && (n != null ? n.equals(((dts) (obj)).n) : ((dts) (obj)).n == null) && (a != null ? a.equals(((dts) (obj)).a) : ((dts) (obj)).a == null) && (b != null ? b.equals(((dts) (obj)).b) : ((dts) (obj)).b == null) && (o != null ? o.equals(((dts) (obj)).o) : ((dts) (obj)).o == null) && (c != null ? c.equals(((dts) (obj)).c) : ((dts) (obj)).c == null) && (p != null ? p.equals(((dts) (obj)).p) : ((dts) (obj)).p == null) && (q != null ? q.equals(((dts) (obj)).q) : ((dts) (obj)).q == null) && (d != null ? d.equals(((dts) (obj)).d) : ((dts) (obj)).d == null) && (e != null ? e.equals(((dts) (obj)).e) : ((dts) (obj)).e == null) && (f != null ? f.equals(((dts) (obj)).f) : ((dts) (obj)).f == null) && (r != null ? r.equals(((dts) (obj)).r) : ((dts) (obj)).r == null) && (g != null ? g.equals(((dts) (obj)).g) : ((dts) (obj)).g == null) && (h != null ? h.equals(((dts) (obj)).h) : ((dts) (obj)).h == null) && (i != null ? i.equals(((dts) (obj)).i) : ((dts) (obj)).i == null) && (j != null ? j.equals(((dts) (obj)).j) : ((dts) (obj)).j == null) && (s != null ? s.equals(((dts) (obj)).s) : ((dts) (obj)).s == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dts) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dts) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l5 = 0;
        int i6 = getClass().getName().hashCode();
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        int j5;
        int k5;
        if (k == null)
        {
            i1 = 0;
        } else
        {
            i1 = k.hashCode();
        }
        if (l == null)
        {
            j1 = 0;
        } else
        {
            j1 = l.hashCode();
        }
        if (m == null)
        {
            k1 = 0;
        } else
        {
            k1 = m.hashCode();
        }
        if (n == null)
        {
            l1 = 0;
        } else
        {
            l1 = n.hashCode();
        }
        if (a == null)
        {
            i2 = 0;
        } else
        {
            i2 = a.hashCode();
        }
        if (b == null)
        {
            j2 = 0;
        } else
        {
            j2 = b.hashCode();
        }
        if (o == null)
        {
            k2 = 0;
        } else
        {
            k2 = o.hashCode();
        }
        if (c == null)
        {
            l2 = 0;
        } else
        {
            l2 = c.hashCode();
        }
        if (p == null)
        {
            i3 = 0;
        } else
        {
            i3 = p.hashCode();
        }
        if (q == null)
        {
            j3 = 0;
        } else
        {
            j3 = q.hashCode();
        }
        if (d == null)
        {
            k3 = 0;
        } else
        {
            k3 = d.hashCode();
        }
        if (e == null)
        {
            l3 = 0;
        } else
        {
            l3 = e.hashCode();
        }
        if (f == null)
        {
            i4 = 0;
        } else
        {
            i4 = f.hashCode();
        }
        if (r == null)
        {
            j4 = 0;
        } else
        {
            j4 = r.hashCode();
        }
        if (g == null)
        {
            k4 = 0;
        } else
        {
            k4 = g.hashCode();
        }
        if (h == null)
        {
            l4 = 0;
        } else
        {
            l4 = h.hashCode();
        }
        if (i == null)
        {
            i5 = 0;
        } else
        {
            i5 = i.hashCode();
        }
        if (j == null)
        {
            j5 = 0;
        } else
        {
            j5 = j.hashCode();
        }
        if (s == null)
        {
            k5 = 0;
        } else
        {
            k5 = s.hashCode();
        }
        if (O != null)
        {
            l5 = O.hashCode();
        }
        return (k5 + (j5 + (i5 + (l4 + (k4 + (j4 + (i4 + (l3 + (k3 + (j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (i6 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l5;
    }
}
