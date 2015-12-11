// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dmj extends eul
{

    private dzv a[];
    private dmi b[];

    public dmj()
    {
        a = dzv.a;
        b = dmi.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        if (a != null)
        {
            dzv adzv[] = a;
            int j1 = adzv.length;
            int l = 0;
            int j = 0;
            do
            {
                i = j;
                if (l >= j1)
                {
                    break;
                }
                dzv dzv1 = adzv[l];
                i = j;
                if (dzv1 != null)
                {
                    i = j + euj.b(1, dzv1);
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
            dmi admi[] = b;
            int k1 = admi.length;
            int k = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (k >= k1)
                {
                    break;
                }
                dmi dmi1 = admi[k];
                i1 = i;
                if (dmi1 != null)
                {
                    i1 = i + euj.b(2, dmi1);
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
                dzv adzv[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adzv = new dzv[l + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adzv, 0, j);
                }
                for (a = adzv; j < a.length - 1; j++)
                {
                    a[j] = new dzv();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dzv();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                int i1 = eup.a(eui1, 18);
                dmi admi[];
                int k;
                if (b == null)
                {
                    k = 0;
                } else
                {
                    k = b.length;
                }
                admi = new dmi[i1 + k];
                if (b != null)
                {
                    System.arraycopy(b, 0, admi, 0, k);
                }
                for (b = admi; k < b.length - 1; k++)
                {
                    b[k] = new dmi();
                    eui1.a(b[k]);
                    eui1.a();
                }

                b[k] = new dmi();
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
            dzv adzv[] = a;
            int k = adzv.length;
            for (int i = 0; i < k; i++)
            {
                dzv dzv1 = adzv[i];
                if (dzv1 != null)
                {
                    euj1.a(1, dzv1);
                }
            }

        }
        if (b != null)
        {
            dmi admi[] = b;
            int l = admi.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                dmi dmi1 = admi[j];
                if (dmi1 != null)
                {
                    euj1.a(2, dmi1);
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
        if (!(obj instanceof dmj))
        {
            return false;
        }
        obj = (dmj)obj;
        if (!Arrays.equals(a, ((dmj) (obj)).a) || !Arrays.equals(b, ((dmj) (obj)).b))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmj) (obj)).O))
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
