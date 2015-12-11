// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dcg extends eul
{

    public static final dcg a[] = new dcg[0];
    private int b;
    private dyx c;
    private String d;
    private dma e;
    private dmc f;
    private String g[];
    private String h;
    private int i;
    private int j;
    private edp k;
    private edv l;
    private dsi m;
    private String n;
    private String o;

    public dcg()
    {
        b = 0;
        c = null;
        d = "";
        e = null;
        f = null;
        g = eup.d;
        h = "";
        i = 0;
        j = 0;
        k = null;
        l = null;
        m = null;
        n = "";
        o = "";
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (b != 0)
        {
            j1 = euj.c(1, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (c != null)
        {
            i1 = j1 + euj.b(2, c);
        }
        j1 = i1;
        if (!d.equals(""))
        {
            j1 = i1 + euj.b(3, d);
        }
        k1 = j1;
        if (e != null)
        {
            k1 = j1 + euj.b(4, e);
        }
        i1 = k1;
        if (f != null)
        {
            i1 = k1 + euj.b(5, f);
        }
        j1 = i1;
        if (g != null)
        {
            j1 = i1;
            if (g.length > 0)
            {
                String as[] = g;
                int i2 = as.length;
                int l1 = 0;
                for (j1 = ((flag) ? 1 : 0); j1 < i2; j1++)
                {
                    l1 += euj.a(as[j1]);
                }

                j1 = i1 + l1 + g.length * 1;
            }
        }
        i1 = j1;
        if (!h.equals(""))
        {
            i1 = j1 + euj.b(7, h);
        }
        j1 = i1;
        if (i != 0)
        {
            j1 = i1 + euj.c(8, i);
        }
        i1 = j1;
        if (j != 0)
        {
            i1 = j1 + euj.c(9, j);
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1 + euj.b(10, k);
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1 + euj.b(11, l);
        }
        j1 = i1;
        if (m != null)
        {
            j1 = i1 + euj.b(12, m);
        }
        i1 = j1;
        if (!n.equals(""))
        {
            i1 = j1 + euj.b(13, n);
        }
        j1 = i1;
        if (!o.equals(""))
        {
            j1 = i1 + euj.b(14, o);
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

            case 8: // '\b'
                int j1 = eui1.d();
                if (j1 == 0 || j1 == 1 || j1 == 2 || j1 == 3)
                {
                    b = j1;
                } else
                {
                    b = 0;
                }
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dyx();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                d = eui1.f();
                break;

            case 34: // '"'
                if (e == null)
                {
                    e = new dma();
                }
                eui1.a(e);
                break;

            case 42: // '*'
                if (f == null)
                {
                    f = new dmc();
                }
                eui1.a(f);
                break;

            case 50: // '2'
                int l1 = eup.a(eui1, 50);
                int k1 = g.length;
                String as[] = new String[l1 + k1];
                System.arraycopy(g, 0, as, 0, k1);
                for (g = as; k1 < g.length - 1; k1++)
                {
                    g[k1] = eui1.f();
                    eui1.a();
                }

                g[k1] = eui1.f();
                break;

            case 58: // ':'
                h = eui1.f();
                break;

            case 64: // '@'
                i = eui1.d();
                break;

            case 72: // 'H'
                j = eui1.d();
                break;

            case 82: // 'R'
                if (k == null)
                {
                    k = new edp();
                }
                eui1.a(k);
                break;

            case 90: // 'Z'
                if (l == null)
                {
                    l = new edv();
                }
                eui1.a(l);
                break;

            case 98: // 'b'
                if (m == null)
                {
                    m = new dsi();
                }
                eui1.a(m);
                break;

            case 106: // 'j'
                n = eui1.f();
                break;

            case 114: // 'r'
                o = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != 0)
        {
            euj1.a(1, b);
        }
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (!d.equals(""))
        {
            euj1.a(3, d);
        }
        if (e != null)
        {
            euj1.a(4, e);
        }
        if (f != null)
        {
            euj1.a(5, f);
        }
        if (g != null)
        {
            String as[] = g;
            int j1 = as.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                euj1.a(6, as[i1]);
            }

        }
        if (!h.equals(""))
        {
            euj1.a(7, h);
        }
        if (i != 0)
        {
            euj1.a(8, i);
        }
        if (j != 0)
        {
            euj1.a(9, j);
        }
        if (k != null)
        {
            euj1.a(10, k);
        }
        if (l != null)
        {
            euj1.a(11, l);
        }
        if (m != null)
        {
            euj1.a(12, m);
        }
        if (!n.equals(""))
        {
            euj1.a(13, n);
        }
        if (!o.equals(""))
        {
            euj1.a(14, o);
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
            if (!(obj instanceof dcg))
            {
                return false;
            }
            obj = (dcg)obj;
            if (b == ((dcg) (obj)).b && (c != null ? c.equals(((dcg) (obj)).c) : ((dcg) (obj)).c == null) && (d != null ? d.equals(((dcg) (obj)).d) : ((dcg) (obj)).d == null) && (e != null ? e.equals(((dcg) (obj)).e) : ((dcg) (obj)).e == null) && (f != null ? f.equals(((dcg) (obj)).f) : ((dcg) (obj)).f == null) && Arrays.equals(g, ((dcg) (obj)).g) && (h != null ? h.equals(((dcg) (obj)).h) : ((dcg) (obj)).h == null) && (i == ((dcg) (obj)).i && j == ((dcg) (obj)).j) && (k != null ? k.equals(((dcg) (obj)).k) : ((dcg) (obj)).k == null) && (l != null ? l.equals(((dcg) (obj)).l) : ((dcg) (obj)).l == null) && (m != null ? m.equals(((dcg) (obj)).m) : ((dcg) (obj)).m == null) && (n != null ? n.equals(((dcg) (obj)).n) : ((dcg) (obj)).n == null) && (o != null ? o.equals(((dcg) (obj)).o) : ((dcg) (obj)).o == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dcg) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dcg) (obj)).O))
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
        int j3;
        j3 = 0;
        int i2 = getClass().getName().hashCode();
        int k2 = b;
        int k3;
        int l3;
        if (c == null)
        {
            i1 = 0;
        } else
        {
            i1 = c.hashCode();
        }
        if (d == null)
        {
            j1 = 0;
        } else
        {
            j1 = d.hashCode();
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
        i1 = l1 + (k1 + (j1 + (i1 + ((i2 + 527) * 31 + k2) * 31) * 31) * 31) * 31;
        if (g != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L4:
        int j2;
        int l2;
        int i3;
        if (h == null)
        {
            i1 = 0;
        } else
        {
            i1 = h.hashCode();
        }
        k3 = i;
        l3 = j;
        if (k == null)
        {
            k1 = 0;
        } else
        {
            k1 = k.hashCode();
        }
        if (l == null)
        {
            l1 = 0;
        } else
        {
            l1 = l.hashCode();
        }
        if (m == null)
        {
            j2 = 0;
        } else
        {
            j2 = m.hashCode();
        }
        if (n == null)
        {
            l2 = 0;
        } else
        {
            l2 = n.hashCode();
        }
        if (o == null)
        {
            i3 = 0;
        } else
        {
            i3 = o.hashCode();
        }
        if (O != null)
        {
            j3 = O.hashCode();
        }
        return (i3 + (l2 + (j2 + (l1 + (k1 + (((i1 + j1 * 31) * 31 + k3) * 31 + l3) * 31) * 31) * 31) * 31) * 31) * 31 + j3;
_L2:
        k1 = 0;
_L5:
        j1 = i1;
        if (k1 >= g.length) goto _L4; else goto _L3
_L3:
        if (g[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = g[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L5
    }

}
