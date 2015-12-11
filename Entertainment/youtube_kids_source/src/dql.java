// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dql extends eul
{

    public static final dql a[] = new dql[0];
    private dpy b;
    private dpp c;
    private dpw d;
    private dpx e;
    private dpo f;
    private dpj g;
    private dpu h;
    private dpm i;
    private dpq j;
    private dpg k;
    private dpn l;
    private dph m;

    public dql()
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
        l = null;
        m = null;
    }

    public final int a()
    {
        int j1 = 0;
        if (b != null)
        {
            j1 = euj.b(0x3f91d5d, b) + 0;
        }
        int i1 = j1;
        if (c != null)
        {
            i1 = j1 + euj.b(0x3f91d7e, c);
        }
        j1 = i1;
        if (d != null)
        {
            j1 = i1 + euj.b(0x413d26c, d);
        }
        i1 = j1;
        if (e != null)
        {
            i1 = j1 + euj.b(0x414bb43, e);
        }
        j1 = i1;
        if (f != null)
        {
            j1 = i1 + euj.b(0x41538db, f);
        }
        i1 = j1;
        if (g != null)
        {
            i1 = j1 + euj.b(0x415f181, g);
        }
        j1 = i1;
        if (h != null)
        {
            j1 = i1 + euj.b(0x415f42b, h);
        }
        i1 = j1;
        if (i != null)
        {
            i1 = j1 + euj.b(0x415f433, i);
        }
        j1 = i1;
        if (j != null)
        {
            j1 = i1 + euj.b(0x415f436, j);
        }
        i1 = j1;
        if (k != null)
        {
            i1 = j1 + euj.b(0x415f442, k);
        }
        j1 = i1;
        if (l != null)
        {
            j1 = i1 + euj.b(0x421c57e, l);
        }
        i1 = j1;
        if (m != null)
        {
            i1 = j1 + euj.b(0x45dd2d3, m);
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

            case 533261034: 
                if (b == null)
                {
                    b = new dpy();
                }
                eui1.a(b);
                break;

            case 533261298: 
                if (c == null)
                {
                    c = new dpp();
                }
                eui1.a(c);
                break;

            case 547263330: 
                if (d == null)
                {
                    d = new dpw();
                }
                eui1.a(d);
                break;

            case 547740186: 
                if (e == null)
                {
                    e = new dpx();
                }
                eui1.a(e);
                break;

            case 547997402: 
                if (f == null)
                {
                    f = new dpo();
                }
                eui1.a(f);
                break;

            case 548375562: 
                if (g == null)
                {
                    g = new dpj();
                }
                eui1.a(g);
                break;

            case 548381018: 
                if (h == null)
                {
                    h = new dpu();
                }
                eui1.a(h);
                break;

            case 548381082: 
                if (i == null)
                {
                    i = new dpm();
                }
                eui1.a(i);
                break;

            case 548381106: 
                if (j == null)
                {
                    j = new dpq();
                }
                eui1.a(j);
                break;

            case 548381202: 
                if (k == null)
                {
                    k = new dpg();
                }
                eui1.a(k);
                break;

            case 554576882: 
                if (l == null)
                {
                    l = new dpn();
                }
                eui1.a(l);
                break;

            case 586061466: 
                if (m == null)
                {
                    m = new dph();
                }
                eui1.a(m);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(0x3f91d5d, b);
        }
        if (c != null)
        {
            euj1.a(0x3f91d7e, c);
        }
        if (d != null)
        {
            euj1.a(0x413d26c, d);
        }
        if (e != null)
        {
            euj1.a(0x414bb43, e);
        }
        if (f != null)
        {
            euj1.a(0x41538db, f);
        }
        if (g != null)
        {
            euj1.a(0x415f181, g);
        }
        if (h != null)
        {
            euj1.a(0x415f42b, h);
        }
        if (i != null)
        {
            euj1.a(0x415f433, i);
        }
        if (j != null)
        {
            euj1.a(0x415f436, j);
        }
        if (k != null)
        {
            euj1.a(0x415f442, k);
        }
        if (l != null)
        {
            euj1.a(0x421c57e, l);
        }
        if (m != null)
        {
            euj1.a(0x45dd2d3, m);
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
            if (!(obj instanceof dql))
            {
                return false;
            }
            obj = (dql)obj;
            if ((b != null ? b.equals(((dql) (obj)).b) : ((dql) (obj)).b == null) && (c != null ? c.equals(((dql) (obj)).c) : ((dql) (obj)).c == null) && (d != null ? d.equals(((dql) (obj)).d) : ((dql) (obj)).d == null) && (e != null ? e.equals(((dql) (obj)).e) : ((dql) (obj)).e == null) && (f != null ? f.equals(((dql) (obj)).f) : ((dql) (obj)).f == null) && (g != null ? g.equals(((dql) (obj)).g) : ((dql) (obj)).g == null) && (h != null ? h.equals(((dql) (obj)).h) : ((dql) (obj)).h == null) && (i != null ? i.equals(((dql) (obj)).i) : ((dql) (obj)).i == null) && (j != null ? j.equals(((dql) (obj)).j) : ((dql) (obj)).j == null) && (k != null ? k.equals(((dql) (obj)).k) : ((dql) (obj)).k == null) && (l != null ? l.equals(((dql) (obj)).l) : ((dql) (obj)).l == null) && (m != null ? m.equals(((dql) (obj)).m) : ((dql) (obj)).m == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dql) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dql) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i4 = 0;
        int j4 = getClass().getName().hashCode();
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
        if (O != null)
        {
            i4 = O.hashCode();
        }
        return (l3 + (k3 + (j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (j4 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
    }

}
