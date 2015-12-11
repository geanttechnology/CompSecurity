// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dkn extends eul
{

    public static final dkn a[] = new dkn[0];
    public dex b[];
    public drk c[];
    private String d;

    public dkn()
    {
        b = dex.a;
        d = "";
        c = drk.a;
    }

    public final int a()
    {
        boolean flag = false;
        int k;
        if (b != null)
        {
            dex adex[] = b;
            int k1 = adex.length;
            int i1 = 0;
            int i = 0;
            do
            {
                k = i;
                if (i1 >= k1)
                {
                    break;
                }
                dex dex1 = adex[i1];
                k = i;
                if (dex1 != null)
                {
                    k = i + euj.b(1, dex1);
                }
                i1++;
                i = k;
            } while (true);
        } else
        {
            k = 0;
        }
        int j = k;
        if (!d.equals(""))
        {
            j = k + euj.b(2, d);
        }
        int j1 = j;
        if (c != null)
        {
            drk adrk[] = c;
            int l1 = adrk.length;
            int l = ((flag) ? 1 : 0);
            do
            {
                j1 = j;
                if (l >= l1)
                {
                    break;
                }
                drk drk1 = adrk[l];
                j1 = j;
                if (drk1 != null)
                {
                    j1 = j + euj.b(3, drk1);
                }
                l++;
                j = j1;
            } while (true);
        }
        j = j1 + eup.a(O);
        P = j;
        return j;
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
                int l = eup.a(eui1, 10);
                dex adex[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adex = new dex[l + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adex, 0, j);
                }
                for (b = adex; j < b.length - 1; j++)
                {
                    b[j] = new dex();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dex();
                eui1.a(b[j]);
                break;

            case 18: // '\022'
                d = eui1.f();
                break;

            case 26: // '\032'
                int i1 = eup.a(eui1, 26);
                drk adrk[];
                int k;
                if (c == null)
                {
                    k = 0;
                } else
                {
                    k = c.length;
                }
                adrk = new drk[i1 + k];
                if (c != null)
                {
                    System.arraycopy(c, 0, adrk, 0, k);
                }
                for (c = adrk; k < c.length - 1; k++)
                {
                    c[k] = new drk();
                    eui1.a(c[k]);
                    eui1.a();
                }

                c[k] = new drk();
                eui1.a(c[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (b != null)
        {
            dex adex[] = b;
            int k = adex.length;
            for (int i = 0; i < k; i++)
            {
                dex dex1 = adex[i];
                if (dex1 != null)
                {
                    euj1.a(1, dex1);
                }
            }

        }
        if (!d.equals(""))
        {
            euj1.a(2, d);
        }
        if (c != null)
        {
            drk adrk[] = c;
            int l = adrk.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                drk drk1 = adrk[j];
                if (drk1 != null)
                {
                    euj1.a(3, drk1);
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
            if (!(obj instanceof dkn))
            {
                return false;
            }
            obj = (dkn)obj;
            if (Arrays.equals(b, ((dkn) (obj)).b) && (d != null ? d.equals(((dkn) (obj)).d) : ((dkn) (obj)).d == null) && Arrays.equals(c, ((dkn) (obj)).c))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dkn) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dkn) (obj)).O))
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
        if (b != null) goto _L2; else goto _L1
_L1:
        int l = i * 31;
_L6:
        int j;
        if (d == null)
        {
            i = 0;
        } else
        {
            i = d.hashCode();
        }
        i += l * 31;
        if (c != null) goto _L4; else goto _L3
_L3:
        l = i * 31;
_L9:
        int k;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return l * 31 + i;
_L2:
        j = 0;
_L7:
        l = i;
        if (j >= b.length) goto _L6; else goto _L5
_L5:
        if (b[j] == null)
        {
            l = 0;
        } else
        {
            l = b[j].hashCode();
        }
        i = l + i * 31;
        j++;
          goto _L7
          goto _L6
_L4:
        k = 0;
_L10:
        l = i;
        if (k >= c.length) goto _L9; else goto _L8
_L8:
        if (c[k] == null)
        {
            l = 0;
        } else
        {
            l = c[k].hashCode();
        }
        i = l + i * 31;
        k++;
          goto _L10
    }

}
