// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dll extends eul
{

    public dre a;
    public byte b[];
    private String c;
    private dzp d;
    private dlb e;
    private dlb f;
    private dlb g;
    private dzp h;
    private dlb i;
    private dlb j;
    private dlb k;
    private dre l;
    private String m[];
    private dqi n;
    private dlm o;
    private String p;

    public dll()
    {
        c = "";
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        a = null;
        b = eup.f;
        l = null;
        m = eup.d;
        n = null;
        o = null;
        p = "";
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        if (!c.equals(""))
        {
            j1 = euj.b(1, c) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
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
        if (h != null)
        {
            i1 = j1 + euj.b(6, h);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1 + euj.b(7, i);
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1 + euj.b(8, j);
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1 + euj.b(9, k);
        }
        i1 = j1;
        if (a != null)
        {
            i1 = j1 + euj.b(10, a);
        }
        j1 = i1;
        if (!Arrays.equals(b, eup.f))
        {
            j1 = i1 + euj.b(11, b);
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1 + euj.b(12, l);
        }
        j1 = i1;
        if (m != null)
        {
            j1 = i1;
            if (m.length > 0)
            {
                String as[] = m;
                int l1 = as.length;
                int k1 = 0;
                for (j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
                {
                    k1 += euj.a(as[j1]);
                }

                j1 = i1 + k1 + m.length * 1;
            }
        }
        i1 = j1;
        if (n != null)
        {
            i1 = j1 + euj.b(14, n);
        }
        j1 = i1;
        if (o != null)
        {
            j1 = i1 + euj.b(15, o);
        }
        i1 = j1;
        if (!p.equals(""))
        {
            i1 = j1 + euj.b(16, p);
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
                c = eui1.f();
                break;

            case 18: // '\022'
                if (d == null)
                {
                    d = new dzp();
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
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 50: // '2'
                if (h == null)
                {
                    h = new dzp();
                }
                eui1.a(h);
                break;

            case 58: // ':'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 66: // 'B'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 74: // 'J'
                if (k == null)
                {
                    k = new dlb();
                }
                eui1.a(k);
                break;

            case 82: // 'R'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 90: // 'Z'
                b = eui1.g();
                break;

            case 98: // 'b'
                if (l == null)
                {
                    l = new dre();
                }
                eui1.a(l);
                break;

            case 106: // 'j'
                int k1 = eup.a(eui1, 106);
                int j1 = m.length;
                String as[] = new String[k1 + j1];
                System.arraycopy(m, 0, as, 0, j1);
                for (m = as; j1 < m.length - 1; j1++)
                {
                    m[j1] = eui1.f();
                    eui1.a();
                }

                m[j1] = eui1.f();
                break;

            case 114: // 'r'
                if (n == null)
                {
                    n = new dqi();
                }
                eui1.a(n);
                break;

            case 122: // 'z'
                if (o == null)
                {
                    o = new dlm();
                }
                eui1.a(o);
                break;

            case 130: 
                p = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!c.equals(""))
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
        if (h != null)
        {
            euj1.a(6, h);
        }
        if (i != null)
        {
            euj1.a(7, i);
        }
        if (j != null)
        {
            euj1.a(8, j);
        }
        if (k != null)
        {
            euj1.a(9, k);
        }
        if (a != null)
        {
            euj1.a(10, a);
        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(11, b);
        }
        if (l != null)
        {
            euj1.a(12, l);
        }
        if (m != null)
        {
            String as[] = m;
            int j1 = as.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                euj1.a(13, as[i1]);
            }

        }
        if (n != null)
        {
            euj1.a(14, n);
        }
        if (o != null)
        {
            euj1.a(15, o);
        }
        if (!p.equals(""))
        {
            euj1.a(16, p);
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
            if (!(obj instanceof dll))
            {
                return false;
            }
            obj = (dll)obj;
            if ((c != null ? c.equals(((dll) (obj)).c) : ((dll) (obj)).c == null) && (d != null ? d.equals(((dll) (obj)).d) : ((dll) (obj)).d == null) && (e != null ? e.equals(((dll) (obj)).e) : ((dll) (obj)).e == null) && (f != null ? f.equals(((dll) (obj)).f) : ((dll) (obj)).f == null) && (g != null ? g.equals(((dll) (obj)).g) : ((dll) (obj)).g == null) && (h != null ? h.equals(((dll) (obj)).h) : ((dll) (obj)).h == null) && (i != null ? i.equals(((dll) (obj)).i) : ((dll) (obj)).i == null) && (j != null ? j.equals(((dll) (obj)).j) : ((dll) (obj)).j == null) && (k != null ? k.equals(((dll) (obj)).k) : ((dll) (obj)).k == null) && (a != null ? a.equals(((dll) (obj)).a) : ((dll) (obj)).a == null) && Arrays.equals(b, ((dll) (obj)).b) && (l != null ? l.equals(((dll) (obj)).l) : ((dll) (obj)).l == null) && Arrays.equals(m, ((dll) (obj)).m) && (n != null ? n.equals(((dll) (obj)).n) : ((dll) (obj)).n == null) && (o != null ? o.equals(((dll) (obj)).o) : ((dll) (obj)).o == null) && (p != null ? p.equals(((dll) (obj)).p) : ((dll) (obj)).p == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dll) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dll) (obj)).O))
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
        boolean flag = false;
        int k3 = getClass().getName().hashCode();
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
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
        if (i == null)
        {
            k2 = 0;
        } else
        {
            k2 = i.hashCode();
        }
        if (j == null)
        {
            l2 = 0;
        } else
        {
            l2 = j.hashCode();
        }
        if (k == null)
        {
            i3 = 0;
        } else
        {
            i3 = k.hashCode();
        }
        if (a == null)
        {
            j3 = 0;
        } else
        {
            j3 = a.hashCode();
        }
        i1 = j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (k3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (b != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L6:
        if (l == null)
        {
            i1 = 0;
        } else
        {
            i1 = l.hashCode();
        }
        i1 += j1 * 31;
        if (m != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L9:
        if (n == null)
        {
            i1 = 0;
        } else
        {
            i1 = n.hashCode();
        }
        if (o == null)
        {
            k1 = 0;
        } else
        {
            k1 = o.hashCode();
        }
        if (p == null)
        {
            l1 = 0;
        } else
        {
            l1 = p.hashCode();
        }
        if (O == null)
        {
            i2 = ((flag) ? 1 : 0);
        } else
        {
            i2 = O.hashCode();
        }
        return (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31 + i2;
_L2:
        k1 = 0;
_L7:
        j1 = i1;
        if (k1 >= b.length) goto _L6; else goto _L5
_L5:
        i1 = i1 * 31 + b[k1];
        k1++;
          goto _L7
          goto _L6
_L4:
        k1 = 0;
_L10:
        j1 = i1;
        if (k1 >= m.length) goto _L9; else goto _L8
_L8:
        if (m[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = m[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L10
    }
}
