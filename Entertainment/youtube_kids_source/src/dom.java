// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dom extends eul
{

    public doo a[];
    public don b[];
    public byte c[];
    private doi d;

    public dom()
    {
        a = doo.a;
        b = don.a;
        c = eup.f;
        d = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        if (a != null)
        {
            doo adoo[] = a;
            int j1 = adoo.length;
            int l = 0;
            int j = 0;
            do
            {
                i = j;
                if (l >= j1)
                {
                    break;
                }
                doo doo1 = adoo[l];
                i = j;
                if (doo1 != null)
                {
                    i = j + euj.b(1, doo1);
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
            don adon[] = b;
            int k1 = adon.length;
            int i1 = ((flag) ? 1 : 0);
            do
            {
                k = i;
                if (i1 >= k1)
                {
                    break;
                }
                don don1 = adon[i1];
                k = i;
                if (don1 != null)
                {
                    k = i + euj.b(2, don1);
                }
                i1++;
                i = k;
            } while (true);
        }
        i = k;
        if (!Arrays.equals(c, eup.f))
        {
            i = k + euj.b(4, c);
        }
        k = i;
        if (d != null)
        {
            k = i + euj.b(5, d);
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
                int l = eup.a(eui1, 10);
                doo adoo[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adoo = new doo[l + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adoo, 0, j);
                }
                for (a = adoo; j < a.length - 1; j++)
                {
                    a[j] = new doo();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new doo();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                int i1 = eup.a(eui1, 18);
                don adon[];
                int k;
                if (b == null)
                {
                    k = 0;
                } else
                {
                    k = b.length;
                }
                adon = new don[i1 + k];
                if (b != null)
                {
                    System.arraycopy(b, 0, adon, 0, k);
                }
                for (b = adon; k < b.length - 1; k++)
                {
                    b[k] = new don();
                    eui1.a(b[k]);
                    eui1.a();
                }

                b[k] = new don();
                eui1.a(b[k]);
                break;

            case 34: // '"'
                c = eui1.g();
                break;

            case 42: // '*'
                if (d == null)
                {
                    d = new doi();
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
            doo adoo[] = a;
            int k = adoo.length;
            for (int i = 0; i < k; i++)
            {
                doo doo1 = adoo[i];
                if (doo1 != null)
                {
                    euj1.a(1, doo1);
                }
            }

        }
        if (b != null)
        {
            don adon[] = b;
            int l = adon.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                don don1 = adon[j];
                if (don1 != null)
                {
                    euj1.a(2, don1);
                }
            }

        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(4, c);
        }
        if (d != null)
        {
            euj1.a(5, d);
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
            if (!(obj instanceof dom))
            {
                return false;
            }
            obj = (dom)obj;
            if (Arrays.equals(a, ((dom) (obj)).a) && Arrays.equals(b, ((dom) (obj)).b) && Arrays.equals(c, ((dom) (obj)).c) && (d != null ? d.equals(((dom) (obj)).d) : ((dom) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dom) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dom) (obj)).O))
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
        if (d == null)
        {
            j = 0;
        } else
        {
            j = d.hashCode();
        }
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return (j + i * 31) * 31 + k;
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
