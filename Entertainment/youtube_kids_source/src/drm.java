// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class drm extends eul
{

    public dre a;
    private dzp b;
    private dzp c;
    private dlb d;
    private dlb e;
    private dlb f;
    private dxa g[];
    private boolean h;
    private boolean i;
    private dxa j;
    private dqi k;
    private byte l[];

    public drm()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        a = null;
        g = dxa.a;
        h = false;
        i = false;
        j = null;
        k = null;
        l = eup.f;
    }

    public final int a()
    {
        int k1 = 0;
        int i1;
        int j1;
        if (b != null)
        {
            j1 = euj.b(1, b) + 0;
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
        if (d != null)
        {
            j1 = i1 + euj.b(3, d);
        }
        i1 = j1;
        if (e != null)
        {
            i1 = j1 + euj.b(4, e);
        }
        j1 = i1;
        if (f != null)
        {
            j1 = i1 + euj.b(5, f);
        }
        i1 = j1;
        if (a != null)
        {
            i1 = j1 + euj.b(6, a);
        }
        j1 = i1;
        if (g != null)
        {
            dxa adxa[] = g;
            int l1 = adxa.length;
            do
            {
                j1 = i1;
                if (k1 >= l1)
                {
                    break;
                }
                dxa dxa1 = adxa[k1];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(7, dxa1);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (h)
        {
            boolean flag = h;
            i1 = j1 + (euj.b(8) + 1);
        }
        j1 = i1;
        if (i)
        {
            boolean flag1 = i;
            j1 = i1 + (euj.b(9) + 1);
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1 + euj.b(10, j);
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1 + euj.b(11, k);
        }
        i1 = j1;
        if (!Arrays.equals(l, eup.f))
        {
            i1 = j1 + euj.b(13, l);
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
                if (b == null)
                {
                    b = new dzp();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dzp();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 34: // '"'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 42: // '*'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 50: // '2'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 58: // ':'
                int k1 = eup.a(eui1, 58);
                dxa adxa[];
                int j1;
                if (g == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = g.length;
                }
                adxa = new dxa[k1 + j1];
                if (g != null)
                {
                    System.arraycopy(g, 0, adxa, 0, j1);
                }
                for (g = adxa; j1 < g.length - 1; j1++)
                {
                    g[j1] = new dxa();
                    eui1.a(g[j1]);
                    eui1.a();
                }

                g[j1] = new dxa();
                eui1.a(g[j1]);
                break;

            case 64: // '@'
                h = eui1.e();
                break;

            case 72: // 'H'
                i = eui1.e();
                break;

            case 82: // 'R'
                if (j == null)
                {
                    j = new dxa();
                }
                eui1.a(j);
                break;

            case 90: // 'Z'
                if (k == null)
                {
                    k = new dqi();
                }
                eui1.a(k);
                break;

            case 106: // 'j'
                l = eui1.g();
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
        if (a != null)
        {
            euj1.a(6, a);
        }
        if (g != null)
        {
            dxa adxa[] = g;
            int j1 = adxa.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                dxa dxa1 = adxa[i1];
                if (dxa1 != null)
                {
                    euj1.a(7, dxa1);
                }
            }

        }
        if (h)
        {
            euj1.a(8, h);
        }
        if (i)
        {
            euj1.a(9, i);
        }
        if (j != null)
        {
            euj1.a(10, j);
        }
        if (k != null)
        {
            euj1.a(11, k);
        }
        if (!Arrays.equals(l, eup.f))
        {
            euj1.a(13, l);
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
            if (!(obj instanceof drm))
            {
                return false;
            }
            obj = (drm)obj;
            if ((b != null ? b.equals(((drm) (obj)).b) : ((drm) (obj)).b == null) && (c != null ? c.equals(((drm) (obj)).c) : ((drm) (obj)).c == null) && (d != null ? d.equals(((drm) (obj)).d) : ((drm) (obj)).d == null) && (e != null ? e.equals(((drm) (obj)).e) : ((drm) (obj)).e == null) && (f != null ? f.equals(((drm) (obj)).f) : ((drm) (obj)).f == null) && (a != null ? a.equals(((drm) (obj)).a) : ((drm) (obj)).a == null) && (Arrays.equals(g, ((drm) (obj)).g) && h == ((drm) (obj)).h && i == ((drm) (obj)).i) && (j != null ? j.equals(((drm) (obj)).j) : ((drm) (obj)).j == null) && (k != null ? k.equals(((drm) (obj)).k) : ((drm) (obj)).k == null) && Arrays.equals(l, ((drm) (obj)).l))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((drm) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((drm) (obj)).O))
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
        boolean flag1 = true;
        boolean flag = false;
        int k2 = getClass().getName().hashCode();
        int j2;
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
        if (a == null)
        {
            j2 = 0;
        } else
        {
            j2 = a.hashCode();
        }
        i1 = j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (k2 + 527) * 31) * 31) * 31) * 31) * 31) * 31;
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
        if (i)
        {
            k1 = ((flag1) ? 1 : 0);
        } else
        {
            k1 = 2;
        }
        if (j == null)
        {
            l1 = 0;
        } else
        {
            l1 = j.hashCode();
        }
        if (k == null)
        {
            i2 = 0;
        } else
        {
            i2 = k.hashCode();
        }
        i1 = i2 + (l1 + ((i1 + j1 * 31) * 31 + k1) * 31) * 31;
        if (l != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L9:
        if (O == null)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = O.hashCode();
        }
        return j1 * 31 + i1;
_L2:
        k1 = 0;
_L7:
        j1 = i1;
        if (k1 >= g.length) goto _L6; else goto _L5
_L5:
        if (g[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = g[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L7
          goto _L6
_L4:
        k1 = 0;
_L10:
        j1 = i1;
        if (k1 >= l.length) goto _L9; else goto _L8
_L8:
        i1 = i1 * 31 + l[k1];
        k1++;
          goto _L10
    }
}
