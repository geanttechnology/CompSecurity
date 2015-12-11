// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dhp extends eul
{

    private dlb a;
    private dzp b;
    private dre c;
    private dlb d;
    private dlb e;
    private boolean f;
    private int g;
    private dqi h;
    private String i;
    private dhl j;
    private boolean k;
    private dlb l;
    private dzp m;
    private dlb n;

    public dhp()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = false;
        g = 0;
        h = null;
        i = "";
        j = null;
        k = false;
        l = null;
        m = null;
        n = null;
    }

    public final int a()
    {
        int j1 = 0;
        if (a != null)
        {
            j1 = euj.b(1, a) + 0;
        }
        int i1 = j1;
        if (b != null)
        {
            i1 = j1 + euj.b(2, b);
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1 + euj.b(3, c);
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
        if (f)
        {
            boolean flag = f;
            i1 = j1 + (euj.b(6) + 1);
        }
        j1 = i1;
        if (g != 0)
        {
            j1 = i1 + euj.c(7, g);
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1 + euj.b(8, h);
        }
        j1 = i1;
        if (!i.equals(""))
        {
            j1 = i1 + euj.b(9, i);
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1 + euj.b(10, j);
        }
        j1 = i1;
        if (k)
        {
            boolean flag1 = k;
            j1 = i1 + (euj.b(11) + 1);
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
        if (n != null)
        {
            i1 = j1 + euj.b(14, n);
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
                if (b == null)
                {
                    b = new dzp();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dre();
                }
                eui1.a(c);
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

            case 48: // '0'
                f = eui1.e();
                break;

            case 56: // '8'
                g = eui1.d();
                break;

            case 66: // 'B'
                if (h == null)
                {
                    h = new dqi();
                }
                eui1.a(h);
                break;

            case 74: // 'J'
                i = eui1.f();
                break;

            case 82: // 'R'
                if (j == null)
                {
                    j = new dhl();
                }
                eui1.a(j);
                break;

            case 88: // 'X'
                k = eui1.e();
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
                    m = new dzp();
                }
                eui1.a(m);
                break;

            case 114: // 'r'
                if (n == null)
                {
                    n = new dlb();
                }
                eui1.a(n);
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
        if (c != null)
        {
            euj1.a(3, c);
        }
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f)
        {
            euj1.a(6, f);
        }
        if (g != 0)
        {
            euj1.a(7, g);
        }
        if (h != null)
        {
            euj1.a(8, h);
        }
        if (!i.equals(""))
        {
            euj1.a(9, i);
        }
        if (j != null)
        {
            euj1.a(10, j);
        }
        if (k)
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
        if (n != null)
        {
            euj1.a(14, n);
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
            if (!(obj instanceof dhp))
            {
                return false;
            }
            obj = (dhp)obj;
            if ((a != null ? a.equals(((dhp) (obj)).a) : ((dhp) (obj)).a == null) && (b != null ? b.equals(((dhp) (obj)).b) : ((dhp) (obj)).b == null) && (c != null ? c.equals(((dhp) (obj)).c) : ((dhp) (obj)).c == null) && (d != null ? d.equals(((dhp) (obj)).d) : ((dhp) (obj)).d == null) && (e != null ? e.equals(((dhp) (obj)).e) : ((dhp) (obj)).e == null) && (f == ((dhp) (obj)).f && g == ((dhp) (obj)).g) && (h != null ? h.equals(((dhp) (obj)).h) : ((dhp) (obj)).h == null) && (i != null ? i.equals(((dhp) (obj)).i) : ((dhp) (obj)).i == null) && (j != null ? j.equals(((dhp) (obj)).j) : ((dhp) (obj)).j == null) && k == ((dhp) (obj)).k && (l != null ? l.equals(((dhp) (obj)).l) : ((dhp) (obj)).l == null) && (m != null ? m.equals(((dhp) (obj)).m) : ((dhp) (obj)).m == null) && (n != null ? n.equals(((dhp) (obj)).n) : ((dhp) (obj)).n == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dhp) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dhp) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j3 = 1;
        int j4 = 0;
        int k4 = getClass().getName().hashCode();
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int k3;
        int l3;
        int i4;
        int l4;
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
        if (f)
        {
            j2 = 1;
        } else
        {
            j2 = 2;
        }
        l4 = g;
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
        if (!k)
        {
            j3 = 2;
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
        if (n == null)
        {
            i4 = 0;
        } else
        {
            i4 = n.hashCode();
        }
        if (O != null)
        {
            j4 = O.hashCode();
        }
        return (i4 + (l3 + (k3 + ((i3 + (l2 + (k2 + ((j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (k4 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l4) * 31) * 31) * 31) * 31 + j3) * 31) * 31) * 31) * 31 + j4;
    }
}
