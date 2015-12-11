// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dmn extends eul
{

    public static final dmn a[] = new dmn[0];
    public int b;
    public dmp c[];
    public dnd d[];
    public dmr e;
    private dmo f;
    private int g;
    private long h;
    private long i;
    private dmq j;
    private dmy k;
    private int l;
    private dna m;
    private dne n;

    public dmn()
    {
        b = 0;
        f = null;
        g = 0;
        h = 0L;
        i = 0L;
        c = dmp.a;
        d = dnd.a;
        j = null;
        k = null;
        e = null;
        l = 0;
        m = null;
        n = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        if (b != 0)
        {
            j1 = euj.c(1, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(2, f);
        }
        j1 = i1;
        if (g != 0)
        {
            j1 = i1 + euj.c(3, g);
        }
        i1 = j1;
        if (h != 0L)
        {
            i1 = j1 + euj.d(4, h);
        }
        j1 = i1;
        if (i != 0L)
        {
            j1 = i1 + euj.d(5, i);
        }
        i1 = j1;
        if (c != null)
        {
            dmp admp[] = c;
            int i2 = admp.length;
            int k1 = 0;
            do
            {
                i1 = j1;
                if (k1 >= i2)
                {
                    break;
                }
                dmp dmp1 = admp[k1];
                i1 = j1;
                if (dmp1 != null)
                {
                    i1 = j1 + euj.b(6, dmp1);
                }
                k1++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (d != null)
        {
            dnd adnd[] = d;
            int j2 = adnd.length;
            int l1 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (l1 >= j2)
                {
                    break;
                }
                dnd dnd1 = adnd[l1];
                j1 = i1;
                if (dnd1 != null)
                {
                    j1 = i1 + euj.b(7, dnd1);
                }
                l1++;
                i1 = j1;
            } while (true);
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
        if (e != null)
        {
            i1 = j1 + euj.b(10, e);
        }
        j1 = i1;
        if (l != 0)
        {
            j1 = i1 + euj.c(11, l);
        }
        i1 = j1;
        if (m != null)
        {
            i1 = j1 + euj.b(12, m);
        }
        j1 = i1;
        if (n != null)
        {
            j1 = i1 + euj.b(13, n);
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
                if (f == null)
                {
                    f = new dmo();
                }
                eui1.a(f);
                break;

            case 24: // '\030'
                g = eui1.d();
                break;

            case 32: // ' '
                h = eui1.c();
                break;

            case 40: // '('
                i = eui1.c();
                break;

            case 50: // '2'
                int j2 = eup.a(eui1, 50);
                dmp admp[];
                int k1;
                if (c == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = c.length;
                }
                admp = new dmp[j2 + k1];
                if (c != null)
                {
                    System.arraycopy(c, 0, admp, 0, k1);
                }
                for (c = admp; k1 < c.length - 1; k1++)
                {
                    c[k1] = new dmp();
                    eui1.a(c[k1]);
                    eui1.a();
                }

                c[k1] = new dmp();
                eui1.a(c[k1]);
                break;

            case 58: // ':'
                int k2 = eup.a(eui1, 58);
                dnd adnd[];
                int l1;
                if (d == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = d.length;
                }
                adnd = new dnd[k2 + l1];
                if (d != null)
                {
                    System.arraycopy(d, 0, adnd, 0, l1);
                }
                for (d = adnd; l1 < d.length - 1; l1++)
                {
                    d[l1] = new dnd();
                    eui1.a(d[l1]);
                    eui1.a();
                }

                d[l1] = new dnd();
                eui1.a(d[l1]);
                break;

            case 66: // 'B'
                if (j == null)
                {
                    j = new dmq();
                }
                eui1.a(j);
                break;

            case 74: // 'J'
                if (k == null)
                {
                    k = new dmy();
                }
                eui1.a(k);
                break;

            case 82: // 'R'
                if (e == null)
                {
                    e = new dmr();
                }
                eui1.a(e);
                break;

            case 88: // 'X'
                int i2 = eui1.d();
                if (i2 == 0 || i2 == 1 || i2 == 2)
                {
                    l = i2;
                } else
                {
                    l = 0;
                }
                break;

            case 98: // 'b'
                if (m == null)
                {
                    m = new dna();
                }
                eui1.a(m);
                break;

            case 106: // 'j'
                if (n == null)
                {
                    n = new dne();
                }
                eui1.a(n);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (b != 0)
        {
            euj1.a(1, b);
        }
        if (f != null)
        {
            euj1.a(2, f);
        }
        if (g != 0)
        {
            euj1.a(3, g);
        }
        if (h != 0L)
        {
            euj1.b(4, h);
        }
        if (i != 0L)
        {
            euj1.b(5, i);
        }
        if (c != null)
        {
            dmp admp[] = c;
            int k1 = admp.length;
            for (int i1 = 0; i1 < k1; i1++)
            {
                dmp dmp1 = admp[i1];
                if (dmp1 != null)
                {
                    euj1.a(6, dmp1);
                }
            }

        }
        if (d != null)
        {
            dnd adnd[] = d;
            int l1 = adnd.length;
            for (int j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
            {
                dnd dnd1 = adnd[j1];
                if (dnd1 != null)
                {
                    euj1.a(7, dnd1);
                }
            }

        }
        if (j != null)
        {
            euj1.a(8, j);
        }
        if (k != null)
        {
            euj1.a(9, k);
        }
        if (e != null)
        {
            euj1.a(10, e);
        }
        if (l != 0)
        {
            euj1.a(11, l);
        }
        if (m != null)
        {
            euj1.a(12, m);
        }
        if (n != null)
        {
            euj1.a(13, n);
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
            if (!(obj instanceof dmn))
            {
                return false;
            }
            obj = (dmn)obj;
            if (b == ((dmn) (obj)).b && (f != null ? f.equals(((dmn) (obj)).f) : ((dmn) (obj)).f == null) && (g == ((dmn) (obj)).g && h == ((dmn) (obj)).h && i == ((dmn) (obj)).i && Arrays.equals(c, ((dmn) (obj)).c) && Arrays.equals(d, ((dmn) (obj)).d)) && (j != null ? j.equals(((dmn) (obj)).j) : ((dmn) (obj)).j == null) && (k != null ? k.equals(((dmn) (obj)).k) : ((dmn) (obj)).k == null) && (e != null ? e.equals(((dmn) (obj)).e) : ((dmn) (obj)).e == null) && l == ((dmn) (obj)).l && (m != null ? m.equals(((dmn) (obj)).m) : ((dmn) (obj)).m == null) && (n != null ? n.equals(((dmn) (obj)).n) : ((dmn) (obj)).n == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmn) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmn) (obj)).O))
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
        int l2;
        l2 = 0;
        j1 = getClass().getName().hashCode();
        int k1 = b;
        int i3;
        if (f == null)
        {
            i1 = 0;
        } else
        {
            i1 = f.hashCode();
        }
        i1 = (((i1 + ((j1 + 527) * 31 + k1) * 31) * 31 + g) * 31 + (int)(h ^ h >>> 32)) * 31 + (int)(i ^ i >>> 32);
        if (c != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L6:
        if (d != null) goto _L4; else goto _L3
_L3:
        j1 *= 31;
_L9:
        int l1;
        int i2;
        int j2;
        int k2;
        if (j == null)
        {
            i1 = 0;
        } else
        {
            i1 = j.hashCode();
        }
        if (k == null)
        {
            l1 = 0;
        } else
        {
            l1 = k.hashCode();
        }
        if (e == null)
        {
            i2 = 0;
        } else
        {
            i2 = e.hashCode();
        }
        i3 = l;
        if (m == null)
        {
            j2 = 0;
        } else
        {
            j2 = m.hashCode();
        }
        if (n == null)
        {
            k2 = 0;
        } else
        {
            k2 = n.hashCode();
        }
        if (O != null)
        {
            l2 = O.hashCode();
        }
        return (k2 + (j2 + ((i2 + (l1 + (i1 + j1 * 31) * 31) * 31) * 31 + i3) * 31) * 31) * 31 + l2;
_L2:
        l1 = 0;
_L7:
        j1 = i1;
        if (l1 >= c.length) goto _L6; else goto _L5
_L5:
        if (c[l1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = c[l1].hashCode();
        }
        i1 = j1 + i1 * 31;
        l1++;
          goto _L7
          goto _L6
_L4:
        l1 = 0;
        i1 = j1;
_L10:
        j1 = i1;
        if (l1 >= d.length) goto _L9; else goto _L8
_L8:
        if (d[l1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = d[l1].hashCode();
        }
        i1 = j1 + i1 * 31;
        l1++;
          goto _L10
    }

}
