// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dos extends eul
{

    public ddo a[];

    public dos()
    {
        a = ddo.a;
    }

    public final int a()
    {
        int k = 0;
        int i = 0;
        if (a != null)
        {
            ddo addo[] = a;
            int l = addo.length;
            int j = 0;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                ddo ddo1 = addo[j];
                k = i;
                if (ddo1 != null)
                {
                    k = i + euj.b(2, ddo1);
                }
                j++;
                i = k;
            } while (true);
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

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                ddo addo[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                addo = new ddo[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, addo, 0, j);
                }
                for (a = addo; j < a.length - 1; j++)
                {
                    a[j] = new ddo();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new ddo();
                eui1.a(a[j]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            ddo addo[] = a;
            int j = addo.length;
            for (int i = 0; i < j; i++)
            {
                ddo ddo1 = addo[i];
                if (ddo1 != null)
                {
                    euj1.a(2, ddo1);
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
        if (!(obj instanceof dos))
        {
            return false;
        }
        obj = (dos)obj;
        if (!Arrays.equals(a, ((dos) (obj)).a))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dos) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dos) (obj)).O))
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
        int k = i * 31;
_L4:
        int j;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return k * 31 + i;
_L2:
        j = 0;
_L5:
        k = i;
        if (j >= a.length) goto _L4; else goto _L3
_L3:
        if (a[j] == null)
        {
            k = 0;
        } else
        {
            k = a[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L5
    }
}
