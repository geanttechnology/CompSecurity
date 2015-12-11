// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dir extends eul
{

    public dwq a;
    public dom b;
    private duq c;
    private dly d;
    private dwu e;
    private duy f;
    private eax g;
    private dyr h;
    private dhs i;
    private dbp j;
    private eah k;
    private dhq l;
    private drn m;
    private dje n;
    private dbt o;

    public dir()
    {
        a = null;
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
        l = null;
        m = null;
        n = null;
        o = null;
    }

    public final int a()
    {
        int j1 = 0;
        if (a != null)
        {
            j1 = euj.b(0x2f1c7f5, a) + 0;
        }
        int i1 = j1;
        if (b != null)
        {
            i1 = j1 + euj.b(0x2fdec06, b);
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1 + euj.b(0x3049158, c);
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1 + euj.b(0x310c7ec, d);
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1 + euj.b(0x31618db, e);
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(0x3425de4, f);
        }
        j1 = i1;
        if (g != null)
        {
            j1 = i1 + euj.b(0x374d3e7, g);
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1 + euj.b(0x3b0b8f0, h);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1 + euj.b(0x3b5bb0d, i);
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1 + euj.b(0x3c7eeec, j);
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1 + euj.b(0x3d28517, k);
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1 + euj.b(0x3e0bf91, l);
        }
        j1 = i1;
        if (m != null)
        {
            j1 = i1 + euj.b(0x3e2e179, m);
        }
        i1 = j1;
        if (n != null)
        {
            i1 = j1 + euj.b(0x420487a, n);
        }
        j1 = i1;
        if (o != null)
        {
            j1 = i1 + euj.b(0x498941e, o);
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

            case 395198378: 
                if (a == null)
                {
                    a = new dwq();
                }
                eui1.a(a);
                break;

            case 401563698: 
                if (b == null)
                {
                    b = new dom();
                }
                eui1.a(b);
                break;

            case 405048002: 
                if (c == null)
                {
                    c = new duq();
                }
                eui1.a(c);
                break;

            case 411451234: 
                if (d == null)
                {
                    d = new dly();
                }
                eui1.a(d);
                break;

            case 414238426: 
                if (e == null)
                {
                    e = new dwu();
                }
                eui1.a(e);
                break;

            case 437448482: 
                if (f == null)
                {
                    f = new duy();
                }
                eui1.a(f);
                break;

            case 463904570: 
                if (g == null)
                {
                    g = new eax();
                }
                eui1.a(g);
                break;

            case 495306626: 
                if (h == null)
                {
                    h = new dyr();
                }
                eui1.a(h);
                break;

            case 497932394: 
                if (i == null)
                {
                    i = new dhs();
                }
                eui1.a(i);
                break;

            case 507475810: 
                if (j == null)
                {
                    j = new dbp();
                }
                eui1.a(j);
                break;

            case 513026234: 
                if (k == null)
                {
                    k = new eah();
                }
                eui1.a(k);
                break;

            case 520486026: 
                if (l == null)
                {
                    l = new dhq();
                }
                eui1.a(l);
                break;

            case 521604042: 
                if (m == null)
                {
                    m = new drn();
                }
                eui1.a(m);
                break;

            case 553796562: 
                if (n == null)
                {
                    n = new dje();
                }
                eui1.a(n);
                break;

            case 616866034: 
                if (o == null)
                {
                    o = new dbt();
                }
                eui1.a(o);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            euj1.a(0x2f1c7f5, a);
        }
        if (b != null)
        {
            euj1.a(0x2fdec06, b);
        }
        if (c != null)
        {
            euj1.a(0x3049158, c);
        }
        if (d != null)
        {
            euj1.a(0x310c7ec, d);
        }
        if (e != null)
        {
            euj1.a(0x31618db, e);
        }
        if (f != null)
        {
            euj1.a(0x3425de4, f);
        }
        if (g != null)
        {
            euj1.a(0x374d3e7, g);
        }
        if (h != null)
        {
            euj1.a(0x3b0b8f0, h);
        }
        if (i != null)
        {
            euj1.a(0x3b5bb0d, i);
        }
        if (j != null)
        {
            euj1.a(0x3c7eeec, j);
        }
        if (k != null)
        {
            euj1.a(0x3d28517, k);
        }
        if (l != null)
        {
            euj1.a(0x3e0bf91, l);
        }
        if (m != null)
        {
            euj1.a(0x3e2e179, m);
        }
        if (n != null)
        {
            euj1.a(0x420487a, n);
        }
        if (o != null)
        {
            euj1.a(0x498941e, o);
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
            if (!(obj instanceof dir))
            {
                return false;
            }
            obj = (dir)obj;
            if ((a != null ? a.equals(((dir) (obj)).a) : ((dir) (obj)).a == null) && (b != null ? b.equals(((dir) (obj)).b) : ((dir) (obj)).b == null) && (c != null ? c.equals(((dir) (obj)).c) : ((dir) (obj)).c == null) && (d != null ? d.equals(((dir) (obj)).d) : ((dir) (obj)).d == null) && (e != null ? e.equals(((dir) (obj)).e) : ((dir) (obj)).e == null) && (f != null ? f.equals(((dir) (obj)).f) : ((dir) (obj)).f == null) && (g != null ? g.equals(((dir) (obj)).g) : ((dir) (obj)).g == null) && (h != null ? h.equals(((dir) (obj)).h) : ((dir) (obj)).h == null) && (i != null ? i.equals(((dir) (obj)).i) : ((dir) (obj)).i == null) && (j != null ? j.equals(((dir) (obj)).j) : ((dir) (obj)).j == null) && (k != null ? k.equals(((dir) (obj)).k) : ((dir) (obj)).k == null) && (l != null ? l.equals(((dir) (obj)).l) : ((dir) (obj)).l == null) && (m != null ? m.equals(((dir) (obj)).m) : ((dir) (obj)).m == null) && (n != null ? n.equals(((dir) (obj)).n) : ((dir) (obj)).n == null) && (o != null ? o.equals(((dir) (obj)).o) : ((dir) (obj)).o == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dir) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dir) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l4 = 0;
        int i5 = getClass().getName().hashCode();
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
        if (c == null)
        {
            k1 = 0;
        } else
        {
            k1 = c.hashCode();
        }
        if (d == null)
        {
            l1 = 0;
        } else
        {
            l1 = d.hashCode();
        }
        if (e == null)
        {
            i2 = 0;
        } else
        {
            i2 = e.hashCode();
        }
        if (f == null)
        {
            j2 = 0;
        } else
        {
            j2 = f.hashCode();
        }
        if (g == null)
        {
            k2 = 0;
        } else
        {
            k2 = g.hashCode();
        }
        if (h == null)
        {
            l2 = 0;
        } else
        {
            l2 = h.hashCode();
        }
        if (i == null)
        {
            i3 = 0;
        } else
        {
            i3 = i.hashCode();
        }
        if (j == null)
        {
            j3 = 0;
        } else
        {
            j3 = j.hashCode();
        }
        if (k == null)
        {
            k3 = 0;
        } else
        {
            k3 = k.hashCode();
        }
        if (l == null)
        {
            l3 = 0;
        } else
        {
            l3 = l.hashCode();
        }
        if (m == null)
        {
            i4 = 0;
        } else
        {
            i4 = m.hashCode();
        }
        if (n == null)
        {
            j4 = 0;
        } else
        {
            j4 = n.hashCode();
        }
        if (o == null)
        {
            k4 = 0;
        } else
        {
            k4 = o.hashCode();
        }
        if (O != null)
        {
            l4 = O.hashCode();
        }
        return (k4 + (j4 + (i4 + (l3 + (k3 + (j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (i5 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l4;
    }
}
