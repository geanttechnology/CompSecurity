// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dbt extends eul
{

    private dbv a[];
    private dbu b[];
    private byte c[];

    public dbt()
    {
        a = dbv.a;
        b = dbu.a;
        c = eup.f;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        if (a != null)
        {
            dbv adbv[] = a;
            int j1 = adbv.length;
            int l = 0;
            int j = 0;
            do
            {
                i = j;
                if (l >= j1)
                {
                    break;
                }
                dbv dbv1 = adbv[l];
                i = j;
                if (dbv1 != null)
                {
                    i = j + euj.b(1, dbv1);
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
            dbu adbu[] = b;
            int k1 = adbu.length;
            int i1 = ((flag) ? 1 : 0);
            do
            {
                k = i;
                if (i1 >= k1)
                {
                    break;
                }
                dbu dbu1 = adbu[i1];
                k = i;
                if (dbu1 != null)
                {
                    k = i + euj.b(2, dbu1);
                }
                i1++;
                i = k;
            } while (true);
        }
        i = k;
        if (!Arrays.equals(c, eup.f))
        {
            i = k + euj.b(3, c);
        }
        i += eup.a(O);
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
                dbv adbv[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adbv = new dbv[l + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adbv, 0, j);
                }
                for (a = adbv; j < a.length - 1; j++)
                {
                    a[j] = new dbv();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dbv();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                int i1 = eup.a(eui1, 18);
                dbu adbu[];
                int k;
                if (b == null)
                {
                    k = 0;
                } else
                {
                    k = b.length;
                }
                adbu = new dbu[i1 + k];
                if (b != null)
                {
                    System.arraycopy(b, 0, adbu, 0, k);
                }
                for (b = adbu; k < b.length - 1; k++)
                {
                    b[k] = new dbu();
                    eui1.a(b[k]);
                    eui1.a();
                }

                b[k] = new dbu();
                eui1.a(b[k]);
                break;

            case 26: // '\032'
                c = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            dbv adbv[] = a;
            int k = adbv.length;
            for (int i = 0; i < k; i++)
            {
                dbv dbv1 = adbv[i];
                if (dbv1 != null)
                {
                    euj1.a(1, dbv1);
                }
            }

        }
        if (b != null)
        {
            dbu adbu[] = b;
            int l = adbu.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                dbu dbu1 = adbu[j];
                if (dbu1 != null)
                {
                    euj1.a(2, dbu1);
                }
            }

        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(3, c);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dbt))
        {
            return false;
        }
        obj = (dbt)obj;
        if (!Arrays.equals(a, ((dbt) (obj)).a) || !Arrays.equals(b, ((dbt) (obj)).b) || !Arrays.equals(c, ((dbt) (obj)).c))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dbt) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dbt) (obj)).O))
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
        i = j * 31;
_L14:
        int k;
        if (O == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = O.hashCode();
        }
        return i * 31 + j;
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
_L15:
        i = j;
        if (k >= c.length) goto _L14; else goto _L13
_L13:
        j = j * 31 + c[k];
        k++;
          goto _L15
    }
}
