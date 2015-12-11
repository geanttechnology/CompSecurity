// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class edl extends eul
{

    private dkn a[];
    private dcg b[];
    private dzv c[];
    private edo d;

    public edl()
    {
        a = dkn.a;
        b = dcg.a;
        c = dzv.a;
        d = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        if (a != null)
        {
            dkn adkn[] = a;
            int k1 = adkn.length;
            int l = 0;
            int j = 0;
            do
            {
                i = j;
                if (l >= k1)
                {
                    break;
                }
                dkn dkn1 = adkn[l];
                i = j;
                if (dkn1 != null)
                {
                    i = j + euj.b(1, dkn1);
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
            dcg adcg[] = b;
            int l1 = adcg.length;
            int i1 = 0;
            do
            {
                k = i;
                if (i1 >= l1)
                {
                    break;
                }
                dcg dcg1 = adcg[i1];
                k = i;
                if (dcg1 != null)
                {
                    k = i + euj.b(2, dcg1);
                }
                i1++;
                i = k;
            } while (true);
        }
        i = k;
        if (c != null)
        {
            dzv adzv[] = c;
            int i2 = adzv.length;
            int j1 = ((flag) ? 1 : 0);
            do
            {
                i = k;
                if (j1 >= i2)
                {
                    break;
                }
                dzv dzv1 = adzv[j1];
                i = k;
                if (dzv1 != null)
                {
                    i = k + euj.b(3, dzv1);
                }
                j1++;
                k = i;
            } while (true);
        }
        k = i;
        if (d != null)
        {
            k = i + euj.b(4, d);
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
                dkn adkn[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adkn = new dkn[i1 + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adkn, 0, j);
                }
                for (a = adkn; j < a.length - 1; j++)
                {
                    a[j] = new dkn();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dkn();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                int j1 = eup.a(eui1, 18);
                dcg adcg[];
                int k;
                if (b == null)
                {
                    k = 0;
                } else
                {
                    k = b.length;
                }
                adcg = new dcg[j1 + k];
                if (b != null)
                {
                    System.arraycopy(b, 0, adcg, 0, k);
                }
                for (b = adcg; k < b.length - 1; k++)
                {
                    b[k] = new dcg();
                    eui1.a(b[k]);
                    eui1.a();
                }

                b[k] = new dcg();
                eui1.a(b[k]);
                break;

            case 26: // '\032'
                int k1 = eup.a(eui1, 26);
                dzv adzv[];
                int l;
                if (c == null)
                {
                    l = 0;
                } else
                {
                    l = c.length;
                }
                adzv = new dzv[k1 + l];
                if (c != null)
                {
                    System.arraycopy(c, 0, adzv, 0, l);
                }
                for (c = adzv; l < c.length - 1; l++)
                {
                    c[l] = new dzv();
                    eui1.a(c[l]);
                    eui1.a();
                }

                c[l] = new dzv();
                eui1.a(c[l]);
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new edo();
                }
                eui1.a(d);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            dkn adkn[] = a;
            int l = adkn.length;
            for (int i = 0; i < l; i++)
            {
                dkn dkn1 = adkn[i];
                if (dkn1 != null)
                {
                    euj1.a(1, dkn1);
                }
            }

        }
        if (b != null)
        {
            dcg adcg[] = b;
            int i1 = adcg.length;
            for (int j = 0; j < i1; j++)
            {
                dcg dcg1 = adcg[j];
                if (dcg1 != null)
                {
                    euj1.a(2, dcg1);
                }
            }

        }
        if (c != null)
        {
            dzv adzv[] = c;
            int j1 = adzv.length;
            for (int k = ((flag) ? 1 : 0); k < j1; k++)
            {
                dzv dzv1 = adzv[k];
                if (dzv1 != null)
                {
                    euj1.a(3, dzv1);
                }
            }

        }
        if (d != null)
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
label0:
        {
            if (!(obj instanceof edl))
            {
                return false;
            }
            obj = (edl)obj;
            if (Arrays.equals(a, ((edl) (obj)).a) && Arrays.equals(b, ((edl) (obj)).b) && Arrays.equals(c, ((edl) (obj)).c) && (d != null ? d.equals(((edl) (obj)).d) : ((edl) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((edl) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((edl) (obj)).O))
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
        j *= 31;
_L14:
        int k;
        if (d == null)
        {
            i = 0;
        } else
        {
            i = d.hashCode();
        }
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return (i + j * 31) * 31 + k;
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
_L15:
        j = i;
        if (k >= c.length) goto _L14; else goto _L13
_L13:
        if (c[k] == null)
        {
            j = 0;
        } else
        {
            j = c[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L15
    }
}
