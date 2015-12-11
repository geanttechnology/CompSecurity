// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dle extends eul
{

    public byte a[];
    private dlb b;
    private dlb c;
    private dgd d;
    private dzp e;
    private dmb f;
    private dzp g;
    private dxa h;
    private dre i;
    private String j;
    private String k;

    public dle()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        a = eup.f;
        i = null;
        j = "";
        k = "";
    }

    public final int a()
    {
        int i1 = 0;
        if (b != null)
        {
            i1 = euj.b(1, b) + 0;
        }
        int l = i1;
        if (c != null)
        {
            l = i1 + euj.b(2, c);
        }
        i1 = l;
        if (d != null)
        {
            i1 = l + euj.b(3, d);
        }
        l = i1;
        if (e != null)
        {
            l = i1 + euj.b(4, e);
        }
        i1 = l;
        if (f != null)
        {
            i1 = l + euj.b(5, f);
        }
        l = i1;
        if (g != null)
        {
            l = i1 + euj.b(6, g);
        }
        i1 = l;
        if (h != null)
        {
            i1 = l + euj.b(7, h);
        }
        l = i1;
        if (!Arrays.equals(a, eup.f))
        {
            l = i1 + euj.b(9, a);
        }
        i1 = l;
        if (i != null)
        {
            i1 = l + euj.b(10, i);
        }
        l = i1;
        if (!j.equals(""))
        {
            l = i1 + euj.b(11, j);
        }
        i1 = l;
        if (!k.equals(""))
        {
            i1 = l + euj.b(12, k);
        }
        l = i1 + eup.a(O);
        P = l;
        return l;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int l = eui1.a();
            switch (l)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, l))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dgd();
                }
                eui1.a(d);
                break;

            case 34: // '"'
                if (e == null)
                {
                    e = new dzp();
                }
                eui1.a(e);
                break;

            case 42: // '*'
                if (f == null)
                {
                    f = new dmb();
                }
                eui1.a(f);
                break;

            case 50: // '2'
                if (g == null)
                {
                    g = new dzp();
                }
                eui1.a(g);
                break;

            case 58: // ':'
                if (h == null)
                {
                    h = new dxa();
                }
                eui1.a(h);
                break;

            case 74: // 'J'
                a = eui1.g();
                break;

            case 82: // 'R'
                if (i == null)
                {
                    i = new dre();
                }
                eui1.a(i);
                break;

            case 90: // 'Z'
                j = eui1.f();
                break;

            case 98: // 'b'
                k = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(1, b);
        }
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (d != null)
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
            euj1.a(6, g);
        }
        if (h != null)
        {
            euj1.a(7, h);
        }
        if (!Arrays.equals(a, eup.f))
        {
            euj1.a(9, a);
        }
        if (i != null)
        {
            euj1.a(10, i);
        }
        if (!j.equals(""))
        {
            euj1.a(11, j);
        }
        if (!k.equals(""))
        {
            euj1.a(12, k);
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
            if (!(obj instanceof dle))
            {
                return false;
            }
            obj = (dle)obj;
            if ((b != null ? b.equals(((dle) (obj)).b) : ((dle) (obj)).b == null) && (c != null ? c.equals(((dle) (obj)).c) : ((dle) (obj)).c == null) && (d != null ? d.equals(((dle) (obj)).d) : ((dle) (obj)).d == null) && (e != null ? e.equals(((dle) (obj)).e) : ((dle) (obj)).e == null) && (f != null ? f.equals(((dle) (obj)).f) : ((dle) (obj)).f == null) && (g != null ? g.equals(((dle) (obj)).g) : ((dle) (obj)).g == null) && (h != null ? h.equals(((dle) (obj)).h) : ((dle) (obj)).h == null) && Arrays.equals(a, ((dle) (obj)).a) && (i != null ? i.equals(((dle) (obj)).i) : ((dle) (obj)).i == null) && (j != null ? j.equals(((dle) (obj)).j) : ((dle) (obj)).j == null) && (k != null ? k.equals(((dle) (obj)).k) : ((dle) (obj)).k == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dle) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dle) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        boolean flag = false;
        int k2 = getClass().getName().hashCode();
        int i2;
        int j2;
        if (b == null)
        {
            l = 0;
        } else
        {
            l = b.hashCode();
        }
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
        l = j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l + (k2 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (a != null) goto _L2; else goto _L1
_L1:
        i1 = l * 31;
_L4:
        if (i == null)
        {
            l = 0;
        } else
        {
            l = i.hashCode();
        }
        if (j == null)
        {
            j1 = 0;
        } else
        {
            j1 = j.hashCode();
        }
        if (k == null)
        {
            k1 = 0;
        } else
        {
            k1 = k.hashCode();
        }
        if (O == null)
        {
            l1 = ((flag) ? 1 : 0);
        } else
        {
            l1 = O.hashCode();
        }
        return (k1 + (j1 + (l + i1 * 31) * 31) * 31) * 31 + l1;
_L2:
        j1 = 0;
_L5:
        i1 = l;
        if (j1 >= a.length) goto _L4; else goto _L3
_L3:
        l = l * 31 + a[j1];
        j1++;
          goto _L5
    }
}
