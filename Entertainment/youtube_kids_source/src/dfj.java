// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dfj extends eul
{

    public dre a;
    public byte b[];
    private dzp c;
    private dlb d;
    private dlb e;
    private dlb f;
    private dzp g;
    private duc h;
    private dlb i;
    private String j;
    private doy k;
    private dqi l;
    private dre m;
    private dxn n;

    public dfj()
    {
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        a = null;
        h = null;
        i = null;
        j = "";
        b = eup.f;
        k = null;
        l = null;
        m = null;
        n = null;
    }

    public final int a()
    {
        int j1 = 0;
        if (c != null)
        {
            j1 = euj.b(1, c) + 0;
        }
        int i1 = j1;
        if (d != null)
        {
            i1 = j1 + euj.b(2, d);
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1 + euj.b(3, e);
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(4, f);
        }
        j1 = i1;
        if (g != null)
        {
            j1 = i1 + euj.b(5, g);
        }
        i1 = j1;
        if (a != null)
        {
            i1 = j1 + euj.b(6, a);
        }
        j1 = i1;
        if (h != null)
        {
            j1 = i1 + euj.b(7, h);
        }
        i1 = j1;
        if (i != null)
        {
            i1 = j1 + euj.b(8, i);
        }
        j1 = i1;
        if (!j.equals(""))
        {
            j1 = i1 + euj.b(9, j);
        }
        i1 = j1;
        if (!Arrays.equals(b, eup.f))
        {
            i1 = j1 + euj.b(11, b);
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1 + euj.b(12, k);
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1 + euj.b(14, l);
        }
        j1 = i1;
        if (m != null)
        {
            j1 = i1 + euj.b(15, m);
        }
        i1 = j1;
        if (n != null)
        {
            i1 = j1 + euj.b(16, n);
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
                if (c == null)
                {
                    c = new dzp();
                }
                eui1.a(c);
                break;

            case 18: // '\022'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 26: // '\032'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 34: // '"'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 42: // '*'
                if (g == null)
                {
                    g = new dzp();
                }
                eui1.a(g);
                break;

            case 50: // '2'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 58: // ':'
                if (h == null)
                {
                    h = new duc();
                }
                eui1.a(h);
                break;

            case 66: // 'B'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 74: // 'J'
                j = eui1.f();
                break;

            case 90: // 'Z'
                b = eui1.g();
                break;

            case 98: // 'b'
                if (k == null)
                {
                    k = new doy();
                }
                eui1.a(k);
                break;

            case 114: // 'r'
                if (l == null)
                {
                    l = new dqi();
                }
                eui1.a(l);
                break;

            case 122: // 'z'
                if (m == null)
                {
                    m = new dre();
                }
                eui1.a(m);
                break;

            case 130: 
                if (n == null)
                {
                    n = new dxn();
                }
                eui1.a(n);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (c != null)
        {
            euj1.a(1, c);
        }
        if (d != null)
        {
            euj1.a(2, d);
        }
        if (e != null)
        {
            euj1.a(3, e);
        }
        if (f != null)
        {
            euj1.a(4, f);
        }
        if (g != null)
        {
            euj1.a(5, g);
        }
        if (a != null)
        {
            euj1.a(6, a);
        }
        if (h != null)
        {
            euj1.a(7, h);
        }
        if (i != null)
        {
            euj1.a(8, i);
        }
        if (!j.equals(""))
        {
            euj1.a(9, j);
        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(11, b);
        }
        if (k != null)
        {
            euj1.a(12, k);
        }
        if (l != null)
        {
            euj1.a(14, l);
        }
        if (m != null)
        {
            euj1.a(15, m);
        }
        if (n != null)
        {
            euj1.a(16, n);
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
            if (!(obj instanceof dfj))
            {
                return false;
            }
            obj = (dfj)obj;
            if ((c != null ? c.equals(((dfj) (obj)).c) : ((dfj) (obj)).c == null) && (d != null ? d.equals(((dfj) (obj)).d) : ((dfj) (obj)).d == null) && (e != null ? e.equals(((dfj) (obj)).e) : ((dfj) (obj)).e == null) && (f != null ? f.equals(((dfj) (obj)).f) : ((dfj) (obj)).f == null) && (g != null ? g.equals(((dfj) (obj)).g) : ((dfj) (obj)).g == null) && (a != null ? a.equals(((dfj) (obj)).a) : ((dfj) (obj)).a == null) && (h != null ? h.equals(((dfj) (obj)).h) : ((dfj) (obj)).h == null) && (i != null ? i.equals(((dfj) (obj)).i) : ((dfj) (obj)).i == null) && (j != null ? j.equals(((dfj) (obj)).j) : ((dfj) (obj)).j == null) && Arrays.equals(b, ((dfj) (obj)).b) && (k != null ? k.equals(((dfj) (obj)).k) : ((dfj) (obj)).k == null) && (l != null ? l.equals(((dfj) (obj)).l) : ((dfj) (obj)).l == null) && (m != null ? m.equals(((dfj) (obj)).m) : ((dfj) (obj)).m == null) && (n != null ? n.equals(((dfj) (obj)).n) : ((dfj) (obj)).n == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dfj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dfj) (obj)).O))
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
        boolean flag = false;
        int j3 = getClass().getName().hashCode();
        int k2;
        int l2;
        int i3;
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
        if (a == null)
        {
            j2 = 0;
        } else
        {
            j2 = a.hashCode();
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
        i1 = i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (j3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (b != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L4:
        if (k == null)
        {
            i1 = 0;
        } else
        {
            i1 = k.hashCode();
        }
        if (l == null)
        {
            k1 = 0;
        } else
        {
            k1 = l.hashCode();
        }
        if (m == null)
        {
            l1 = 0;
        } else
        {
            l1 = m.hashCode();
        }
        if (n == null)
        {
            i2 = 0;
        } else
        {
            i2 = n.hashCode();
        }
        if (O == null)
        {
            j2 = ((flag) ? 1 : 0);
        } else
        {
            j2 = O.hashCode();
        }
        return (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31 + j2;
_L2:
        k1 = 0;
_L5:
        j1 = i1;
        if (k1 >= b.length) goto _L4; else goto _L3
_L3:
        i1 = i1 * 31 + b[k1];
        k1++;
          goto _L5
    }
}
