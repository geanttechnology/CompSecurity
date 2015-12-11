// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dhs extends eul
{

    private dho a[];
    private dhn b[];

    public dhs()
    {
        a = dho.a;
        b = dhn.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        if (a != null)
        {
            dho adho[] = a;
            int j1 = adho.length;
            int l = 0;
            int j = 0;
            do
            {
                i = j;
                if (l >= j1)
                {
                    break;
                }
                dho dho1 = adho[l];
                i = j;
                if (dho1 != null)
                {
                    i = j + euj.b(1, dho1);
                }
                l++;
                j = i;
            } while (true);
        } else
        {
            i = 0;
        }
        int i1 = i;
        if (b != null)
        {
            dhn adhn[] = b;
            int k1 = adhn.length;
            int k = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (k >= k1)
                {
                    break;
                }
                dhn dhn1 = adhn[k];
                i1 = i;
                if (dhn1 != null)
                {
                    i1 = i + euj.b(2, dhn1);
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
                int l = eup.a(eui1, 10);
                dho adho[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adho = new dho[l + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adho, 0, j);
                }
                for (a = adho; j < a.length - 1; j++)
                {
                    a[j] = new dho();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dho();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                int i1 = eup.a(eui1, 18);
                dhn adhn[];
                int k;
                if (b == null)
                {
                    k = 0;
                } else
                {
                    k = b.length;
                }
                adhn = new dhn[i1 + k];
                if (b != null)
                {
                    System.arraycopy(b, 0, adhn, 0, k);
                }
                for (b = adhn; k < b.length - 1; k++)
                {
                    b[k] = new dhn();
                    eui1.a(b[k]);
                    eui1.a();
                }

                b[k] = new dhn();
                eui1.a(b[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            dho adho[] = a;
            int k = adho.length;
            for (int i = 0; i < k; i++)
            {
                dho dho1 = adho[i];
                if (dho1 != null)
                {
                    euj1.a(1, dho1);
                }
            }

        }
        if (b != null)
        {
            dhn adhn[] = b;
            int l = adhn.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                dhn dhn1 = adhn[j];
                if (dhn1 != null)
                {
                    euj1.a(2, dhn1);
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
        if (!(obj instanceof dhs))
        {
            return false;
        }
        obj = (dhs)obj;
        if (!Arrays.equals(a, ((dhs) (obj)).a) || !Arrays.equals(b, ((dhs) (obj)).b))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dhs) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dhs) (obj)).O))
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
_L6:
        if (b != null) goto _L4; else goto _L3
_L3:
        int k = j * 31;
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
        if (k >= a.length) goto _L6; else goto _L5
_L5:
        if (a[k] == null)
        {
            j = 0;
        } else
        {
            j = a[k].hashCode();
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
        if (j >= b.length) goto _L9; else goto _L8
_L8:
        if (b[j] == null)
        {
            k = 0;
        } else
        {
            k = b[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L10
    }
}
