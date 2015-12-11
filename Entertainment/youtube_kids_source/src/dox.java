// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dox extends eul
{

    public dpb a;
    public int b;
    public dlb c;
    public dlb d;
    public dlb e;
    public dlb f;
    public byte g[];
    public boolean h;
    private int i;
    private dlb j;
    private int k;
    private dlb l;
    private dxa m[];

    public dox()
    {
        a = null;
        b = 0;
        i = 0;
        c = null;
        d = null;
        j = null;
        k = 0;
        e = null;
        f = null;
        l = null;
        g = eup.f;
        h = false;
        m = dxa.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (a != null)
        {
            j1 = euj.b(1, a) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (b != 0)
        {
            i1 = j1 + euj.c(2, b);
        }
        j1 = i1;
        if (i != 0)
        {
            j1 = i1 + euj.c(3, i);
        }
        i1 = j1;
        if (c != null)
        {
            i1 = j1 + euj.b(4, c);
        }
        j1 = i1;
        if (d != null)
        {
            j1 = i1 + euj.b(5, d);
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1 + euj.b(6, j);
        }
        j1 = i1;
        if (k != 0)
        {
            j1 = i1 + euj.c(7, k);
        }
        i1 = j1;
        if (e != null)
        {
            i1 = j1 + euj.b(8, e);
        }
        j1 = i1;
        if (f != null)
        {
            j1 = i1 + euj.b(9, f);
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1 + euj.b(10, l);
        }
        j1 = i1;
        if (!Arrays.equals(g, eup.f))
        {
            j1 = i1 + euj.b(11, g);
        }
        i1 = j1;
        if (h)
        {
            boolean flag1 = h;
            i1 = j1 + (euj.b(13) + 1);
        }
        k1 = i1;
        if (m != null)
        {
            dxa adxa[] = m;
            int l1 = adxa.length;
            j1 = ((flag) ? 1 : 0);
            do
            {
                k1 = i1;
                if (j1 >= l1)
                {
                    break;
                }
                dxa dxa1 = adxa[j1];
                k1 = i1;
                if (dxa1 != null)
                {
                    k1 = i1 + euj.b(15, dxa1);
                }
                j1++;
                i1 = k1;
            } while (true);
        }
        i1 = k1 + eup.a(O);
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
                    a = new dpb();
                }
                eui1.a(a);
                break;

            case 16: // '\020'
                int j1 = eui1.d();
                if (j1 == 0 || j1 == 1 || j1 == 2)
                {
                    b = j1;
                } else
                {
                    b = 0;
                }
                break;

            case 24: // '\030'
                i = eui1.d();
                break;

            case 34: // '"'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 42: // '*'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 50: // '2'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 56: // '8'
                k = eui1.d();
                break;

            case 66: // 'B'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 74: // 'J'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 82: // 'R'
                if (l == null)
                {
                    l = new dlb();
                }
                eui1.a(l);
                break;

            case 90: // 'Z'
                g = eui1.g();
                break;

            case 104: // 'h'
                h = eui1.e();
                break;

            case 122: // 'z'
                int l1 = eup.a(eui1, 122);
                dxa adxa[];
                int k1;
                if (m == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = m.length;
                }
                adxa = new dxa[l1 + k1];
                if (m != null)
                {
                    System.arraycopy(m, 0, adxa, 0, k1);
                }
                for (m = adxa; k1 < m.length - 1; k1++)
                {
                    m[k1] = new dxa();
                    eui1.a(m[k1]);
                    eui1.a();
                }

                m[k1] = new dxa();
                eui1.a(m[k1]);
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
        if (b != 0)
        {
            euj1.a(2, b);
        }
        if (i != 0)
        {
            euj1.a(3, i);
        }
        if (c != null)
        {
            euj1.a(4, c);
        }
        if (d != null)
        {
            euj1.a(5, d);
        }
        if (j != null)
        {
            euj1.a(6, j);
        }
        if (k != 0)
        {
            euj1.a(7, k);
        }
        if (e != null)
        {
            euj1.a(8, e);
        }
        if (f != null)
        {
            euj1.a(9, f);
        }
        if (l != null)
        {
            euj1.a(10, l);
        }
        if (!Arrays.equals(g, eup.f))
        {
            euj1.a(11, g);
        }
        if (h)
        {
            euj1.a(13, h);
        }
        if (m != null)
        {
            dxa adxa[] = m;
            int j1 = adxa.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                dxa dxa1 = adxa[i1];
                if (dxa1 != null)
                {
                    euj1.a(15, dxa1);
                }
            }

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
            if (!(obj instanceof dox))
            {
                return false;
            }
            obj = (dox)obj;
            if ((a != null ? a.equals(((dox) (obj)).a) : ((dox) (obj)).a == null) && (b == ((dox) (obj)).b && i == ((dox) (obj)).i) && (c != null ? c.equals(((dox) (obj)).c) : ((dox) (obj)).c == null) && (d != null ? d.equals(((dox) (obj)).d) : ((dox) (obj)).d == null) && (j != null ? j.equals(((dox) (obj)).j) : ((dox) (obj)).j == null) && k == ((dox) (obj)).k && (e != null ? e.equals(((dox) (obj)).e) : ((dox) (obj)).e == null) && (f != null ? f.equals(((dox) (obj)).f) : ((dox) (obj)).f == null) && (l != null ? l.equals(((dox) (obj)).l) : ((dox) (obj)).l == null) && (Arrays.equals(g, ((dox) (obj)).g) && h == ((dox) (obj)).h && Arrays.equals(m, ((dox) (obj)).m)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dox) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dox) (obj)).O))
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
        boolean flag = false;
        int l2 = getClass().getName().hashCode();
        int l1;
        int i2;
        int j2;
        int k2;
        int i3;
        int j3;
        int k3;
        if (a == null)
        {
            i1 = 0;
        } else
        {
            i1 = a.hashCode();
        }
        i3 = b;
        j3 = i;
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
        if (j == null)
        {
            l1 = 0;
        } else
        {
            l1 = j.hashCode();
        }
        k3 = k;
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
        if (l == null)
        {
            k2 = 0;
        } else
        {
            k2 = l.hashCode();
        }
        i1 = k2 + (j2 + (i2 + ((l1 + (k1 + (j1 + (((i1 + (l2 + 527) * 31) * 31 + i3) * 31 + j3) * 31) * 31) * 31) * 31 + k3) * 31) * 31) * 31;
        if (g != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L6:
        if (h)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        i1 += j1 * 31;
        if (m != null) goto _L4; else goto _L3
_L3:
        k1 = i1 * 31;
_L9:
        if (O == null)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = O.hashCode();
        }
        return k1 * 31 + i1;
_L2:
        k1 = 0;
_L7:
        j1 = i1;
        if (k1 >= g.length) goto _L6; else goto _L5
_L5:
        i1 = i1 * 31 + g[k1];
        k1++;
          goto _L7
          goto _L6
_L4:
        j1 = 0;
_L10:
        k1 = i1;
        if (j1 >= m.length) goto _L9; else goto _L8
_L8:
        if (m[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = m[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L10
    }
}
