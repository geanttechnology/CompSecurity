// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dfw extends eul
{

    public dnl a;
    public String b;
    public String c;
    public String d;
    public dub e;
    public dkz f;
    private String g;
    private String h;
    private int i;
    private String j;
    private boolean k;
    private String l;
    private dnz m;

    public dfw()
    {
        a = null;
        b = "";
        c = "";
        g = "";
        d = "";
        h = "";
        i = 0;
        e = null;
        j = "";
        k = false;
        f = null;
        l = "";
        m = null;
    }

    public final int a()
    {
        int j1 = 0;
        if (a != null)
        {
            j1 = euj.b(1, a) + 0;
        }
        int i1 = j1;
        if (!b.equals(""))
        {
            i1 = j1 + euj.b(2, b);
        }
        j1 = i1;
        if (!c.equals(""))
        {
            j1 = i1 + euj.b(3, c);
        }
        i1 = j1;
        if (!g.equals(""))
        {
            i1 = j1 + euj.b(4, g);
        }
        j1 = i1;
        if (!d.equals(""))
        {
            j1 = i1 + euj.b(7, d);
        }
        i1 = j1;
        if (!h.equals(""))
        {
            i1 = j1 + euj.b(8, h);
        }
        j1 = i1;
        if (i != 0)
        {
            j1 = i1 + euj.c(9, i);
        }
        i1 = j1;
        if (e != null)
        {
            i1 = j1 + euj.b(10, e);
        }
        j1 = i1;
        if (!j.equals(""))
        {
            j1 = i1 + euj.b(11, j);
        }
        i1 = j1;
        if (k)
        {
            boolean flag = k;
            i1 = j1 + (euj.b(12) + 1);
        }
        j1 = i1;
        if (f != null)
        {
            j1 = i1 + euj.b(13, f);
        }
        i1 = j1;
        if (!l.equals(""))
        {
            i1 = j1 + euj.b(14, l);
        }
        j1 = i1;
        if (m != null)
        {
            j1 = i1 + euj.b(0x39d6d44, m);
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
                    a = new dnl();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 34: // '"'
                g = eui1.f();
                break;

            case 58: // ':'
                d = eui1.f();
                break;

            case 66: // 'B'
                h = eui1.f();
                break;

            case 72: // 'H'
                i = eui1.d();
                break;

            case 82: // 'R'
                if (e == null)
                {
                    e = new dub();
                }
                eui1.a(e);
                break;

            case 90: // 'Z'
                j = eui1.f();
                break;

            case 96: // '`'
                k = eui1.e();
                break;

            case 106: // 'j'
                if (f == null)
                {
                    f = new dkz();
                }
                eui1.a(f);
                break;

            case 114: // 'r'
                l = eui1.f();
                break;

            case 485190178: 
                if (m == null)
                {
                    m = new dnz();
                }
                eui1.a(m);
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
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (!g.equals(""))
        {
            euj1.a(4, g);
        }
        if (!d.equals(""))
        {
            euj1.a(7, d);
        }
        if (!h.equals(""))
        {
            euj1.a(8, h);
        }
        if (i != 0)
        {
            euj1.a(9, i);
        }
        if (e != null)
        {
            euj1.a(10, e);
        }
        if (!j.equals(""))
        {
            euj1.a(11, j);
        }
        if (k)
        {
            euj1.a(12, k);
        }
        if (f != null)
        {
            euj1.a(13, f);
        }
        if (!l.equals(""))
        {
            euj1.a(14, l);
        }
        if (m != null)
        {
            euj1.a(0x39d6d44, m);
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
            if (!(obj instanceof dfw))
            {
                return false;
            }
            obj = (dfw)obj;
            if ((a != null ? a.equals(((dfw) (obj)).a) : ((dfw) (obj)).a == null) && (b != null ? b.equals(((dfw) (obj)).b) : ((dfw) (obj)).b == null) && (c != null ? c.equals(((dfw) (obj)).c) : ((dfw) (obj)).c == null) && (g != null ? g.equals(((dfw) (obj)).g) : ((dfw) (obj)).g == null) && (d != null ? d.equals(((dfw) (obj)).d) : ((dfw) (obj)).d == null) && (h != null ? h.equals(((dfw) (obj)).h) : ((dfw) (obj)).h == null) && i == ((dfw) (obj)).i && (e != null ? e.equals(((dfw) (obj)).e) : ((dfw) (obj)).e == null) && (j != null ? j.equals(((dfw) (obj)).j) : ((dfw) (obj)).j == null) && k == ((dfw) (obj)).k && (f != null ? f.equals(((dfw) (obj)).f) : ((dfw) (obj)).f == null) && (l != null ? l.equals(((dfw) (obj)).l) : ((dfw) (obj)).l == null) && (m != null ? m.equals(((dfw) (obj)).m) : ((dfw) (obj)).m == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dfw) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dfw) (obj)).O))
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
        if (g == null)
        {
            l1 = 0;
        } else
        {
            l1 = g.hashCode();
        }
        if (d == null)
        {
            i2 = 0;
        } else
        {
            i2 = d.hashCode();
        }
        if (h == null)
        {
            j2 = 0;
        } else
        {
            j2 = h.hashCode();
        }
        k4 = i;
        if (e == null)
        {
            k2 = 0;
        } else
        {
            k2 = e.hashCode();
        }
        if (j == null)
        {
            l2 = 0;
        } else
        {
            l2 = j.hashCode();
        }
        if (k)
        {
            i3 = 1;
        } else
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
        return (l3 + (k3 + (j3 + (i3 + (l2 + (k2 + ((j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (j4 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k4) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
    }
}
