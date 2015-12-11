// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dkt extends eul
{

    private String a;
    private dku b;
    private dfr c[];
    private dcb d[];

    public dkt()
    {
        a = "";
        b = null;
        c = dfr.a;
        d = dcb.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int i1;
        if (!a.equals(""))
        {
            i = euj.b(1, a) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (b != null)
        {
            j = i + euj.b(2, b);
        }
        i = j;
        if (c != null)
        {
            dfr adfr[] = c;
            int j1 = adfr.length;
            int l = 0;
            do
            {
                i = j;
                if (l >= j1)
                {
                    break;
                }
                dfr dfr1 = adfr[l];
                i = j;
                if (dfr1 != null)
                {
                    i = j + euj.b(3, dfr1);
                }
                l++;
                j = i;
            } while (true);
        }
        i1 = i;
        if (d != null)
        {
            dcb adcb[] = d;
            int k1 = adcb.length;
            int k = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (k >= k1)
                {
                    break;
                }
                dcb dcb1 = adcb[k];
                i1 = i;
                if (dcb1 != null)
                {
                    i1 = i + euj.b(4, dcb1);
                }
                k++;
                i = i1;
            } while (true);
        }
        i = i1 + eup.a(O);
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
                a = eui1.f();
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dku();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                int l = eup.a(eui1, 26);
                dfr adfr[];
                int j;
                if (c == null)
                {
                    j = 0;
                } else
                {
                    j = c.length;
                }
                adfr = new dfr[l + j];
                if (c != null)
                {
                    System.arraycopy(c, 0, adfr, 0, j);
                }
                for (c = adfr; j < c.length - 1; j++)
                {
                    c[j] = new dfr();
                    eui1.a(c[j]);
                    eui1.a();
                }

                c[j] = new dfr();
                eui1.a(c[j]);
                break;

            case 34: // '"'
                int i1 = eup.a(eui1, 34);
                dcb adcb[];
                int k;
                if (d == null)
                {
                    k = 0;
                } else
                {
                    k = d.length;
                }
                adcb = new dcb[i1 + k];
                if (d != null)
                {
                    System.arraycopy(d, 0, adcb, 0, k);
                }
                for (d = adcb; k < d.length - 1; k++)
                {
                    d[k] = new dcb();
                    eui1.a(d[k]);
                    eui1.a();
                }

                d[k] = new dcb();
                eui1.a(d[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!a.equals(""))
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            dfr adfr[] = c;
            int k = adfr.length;
            for (int i = 0; i < k; i++)
            {
                dfr dfr1 = adfr[i];
                if (dfr1 != null)
                {
                    euj1.a(3, dfr1);
                }
            }

        }
        if (d != null)
        {
            dcb adcb[] = d;
            int l = adcb.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                dcb dcb1 = adcb[j];
                if (dcb1 != null)
                {
                    euj1.a(4, dcb1);
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
            if (!(obj instanceof dkt))
            {
                return false;
            }
            obj = (dkt)obj;
            if ((a != null ? a.equals(((dkt) (obj)).a) : ((dkt) (obj)).a == null) && (b != null ? b.equals(((dkt) (obj)).b) : ((dkt) (obj)).b == null) && (Arrays.equals(c, ((dkt) (obj)).c) && Arrays.equals(d, ((dkt) (obj)).d)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dkt) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dkt) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        int j;
        int k;
        boolean flag = false;
        k = getClass().getName().hashCode();
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        i = j + (i + (k + 527) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L6:
        if (d != null) goto _L4; else goto _L3
_L3:
        k = j * 31;
_L9:
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return k * 31 + i;
_L2:
        k = 0;
_L7:
        j = i;
        if (k >= c.length) goto _L6; else goto _L5
_L5:
        if (c[k] == null)
        {
            j = 0;
        } else
        {
            j = c[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L7
          goto _L6
_L4:
        k = 0;
        i = j;
        j = k;
_L10:
        k = i;
        if (j >= d.length) goto _L9; else goto _L8
_L8:
        if (d[j] == null)
        {
            k = 0;
        } else
        {
            k = d[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L10
    }
}
