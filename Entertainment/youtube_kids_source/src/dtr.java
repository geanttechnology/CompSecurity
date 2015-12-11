// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dtr extends eul
{

    private dgi a[];
    private dfb b[];
    private dzx c[];
    private int d;

    public dtr()
    {
        a = dgi.a;
        b = dfb.a;
        c = dzx.a;
        d = 0;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        if (a != null)
        {
            dgi adgi[] = a;
            int k1 = adgi.length;
            int l = 0;
            int j = 0;
            do
            {
                i = j;
                if (l >= k1)
                {
                    break;
                }
                dgi dgi1 = adgi[l];
                i = j;
                if (dgi1 != null)
                {
                    i = j + euj.b(1, dgi1);
                }
                l++;
                j = i;
            } while (true);
        } else
        {
            i = 0;
        }
        int k = i;
        if (b != null)
        {
            dfb adfb[] = b;
            int l1 = adfb.length;
            int i1 = 0;
            do
            {
                k = i;
                if (i1 >= l1)
                {
                    break;
                }
                dfb dfb1 = adfb[i1];
                k = i;
                if (dfb1 != null)
                {
                    k = i + euj.b(2, dfb1);
                }
                i1++;
                i = k;
            } while (true);
        }
        i = k;
        if (c != null)
        {
            dzx adzx[] = c;
            int i2 = adzx.length;
            int j1 = ((flag) ? 1 : 0);
            do
            {
                i = k;
                if (j1 >= i2)
                {
                    break;
                }
                dzx dzx1 = adzx[j1];
                i = k;
                if (dzx1 != null)
                {
                    i = k + euj.b(3, dzx1);
                }
                j1++;
                k = i;
            } while (true);
        }
        k = i;
        if (d != 0)
        {
            k = i + euj.c(4, d);
        }
        i = k + eup.a(O);
        P = i;
        return i;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int i = eui1.a();
            switch (i)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                int i1 = eup.a(eui1, 10);
                dgi adgi[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adgi = new dgi[i1 + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adgi, 0, j);
                }
                for (a = adgi; j < a.length - 1; j++)
                {
                    a[j] = new dgi();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dgi();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                int j1 = eup.a(eui1, 18);
                dfb adfb[];
                int k;
                if (b == null)
                {
                    k = 0;
                } else
                {
                    k = b.length;
                }
                adfb = new dfb[j1 + k];
                if (b != null)
                {
                    System.arraycopy(b, 0, adfb, 0, k);
                }
                for (b = adfb; k < b.length - 1; k++)
                {
                    b[k] = new dfb();
                    eui1.a(b[k]);
                    eui1.a();
                }

                b[k] = new dfb();
                eui1.a(b[k]);
                break;

            case 26: // '\032'
                int k1 = eup.a(eui1, 26);
                dzx adzx[];
                int l;
                if (c == null)
                {
                    l = 0;
                } else
                {
                    l = c.length;
                }
                adzx = new dzx[k1 + l];
                if (c != null)
                {
                    System.arraycopy(c, 0, adzx, 0, l);
                }
                for (c = adzx; l < c.length - 1; l++)
                {
                    c[l] = new dzx();
                    eui1.a(c[l]);
                    eui1.a();
                }

                c[l] = new dzx();
                eui1.a(c[l]);
                break;

            case 32: // ' '
                d = eui1.d();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            dgi adgi[] = a;
            int l = adgi.length;
            for (int i = 0; i < l; i++)
            {
                dgi dgi1 = adgi[i];
                if (dgi1 != null)
                {
                    euj1.a(1, dgi1);
                }
            }

        }
        if (b != null)
        {
            dfb adfb[] = b;
            int i1 = adfb.length;
            for (int j = 0; j < i1; j++)
            {
                dfb dfb1 = adfb[j];
                if (dfb1 != null)
                {
                    euj1.a(2, dfb1);
                }
            }

        }
        if (c != null)
        {
            dzx adzx[] = c;
            int j1 = adzx.length;
            for (int k = ((flag) ? 1 : 0); k < j1; k++)
            {
                dzx dzx1 = adzx[k];
                if (dzx1 != null)
                {
                    euj1.a(3, dzx1);
                }
            }

        }
        if (d != 0)
        {
            euj1.a(4, d);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dtr))
        {
            return false;
        }
        obj = (dtr)obj;
        if (!Arrays.equals(a, ((dtr) (obj)).a) || !Arrays.equals(b, ((dtr) (obj)).b) || !Arrays.equals(c, ((dtr) (obj)).c) || d != ((dtr) (obj)).d)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dtr) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dtr) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        boolean flag;
        flag = false;
        i = getClass().getName().hashCode() + 527;
        if (a != null) goto _L2; else goto _L1
_L1:
        int j = i * 31;
_L8:
        if (b != null) goto _L4; else goto _L3
_L3:
        j *= 31;
_L11:
        if (c != null) goto _L6; else goto _L5
_L5:
        int k = j * 31;
_L14:
        j = d;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return (k * 31 + j) * 31 + i;
_L2:
        k = 0;
_L9:
        j = i;
        if (k >= a.length) goto _L8; else goto _L7
_L7:
        if (a[k] == null)
        {
            j = 0;
        } else
        {
            j = a[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L9
          goto _L8
_L4:
        k = 0;
        i = j;
_L12:
        j = i;
        if (k >= b.length) goto _L11; else goto _L10
_L10:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L12
          goto _L11
_L6:
        k = 0;
        i = j;
        j = k;
_L15:
        k = i;
        if (j >= c.length) goto _L14; else goto _L13
_L13:
        if (c[j] == null)
        {
            k = 0;
        } else
        {
            k = c[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L15
    }
}
