// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class doh extends eul
{

    private dlb a;
    private dxa b[];
    private dgd c[];

    public doh()
    {
        a = null;
        b = dxa.a;
        c = dgd.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int l;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (b != null)
        {
            dxa adxa[] = b;
            int i1 = adxa.length;
            int k = 0;
            do
            {
                i = j;
                if (k >= i1)
                {
                    break;
                }
                dxa dxa1 = adxa[k];
                i = j;
                if (dxa1 != null)
                {
                    i = j + euj.b(2, dxa1);
                }
                k++;
                j = i;
            } while (true);
        }
        l = i;
        if (c != null)
        {
            dgd adgd[] = c;
            int j1 = adgd.length;
            j = ((flag) ? 1 : 0);
            do
            {
                l = i;
                if (j >= j1)
                {
                    break;
                }
                dgd dgd1 = adgd[j];
                l = i;
                if (dgd1 != null)
                {
                    l = i + euj.b(3, dgd1);
                }
                j++;
                i = l;
            } while (true);
        }
        i = l + eup.a(O);
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
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                int l = eup.a(eui1, 18);
                dxa adxa[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adxa = new dxa[l + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adxa, 0, j);
                }
                for (b = adxa; j < b.length - 1; j++)
                {
                    b[j] = new dxa();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dxa();
                eui1.a(b[j]);
                break;

            case 26: // '\032'
                int i1 = eup.a(eui1, 26);
                dgd adgd[];
                int k;
                if (c == null)
                {
                    k = 0;
                } else
                {
                    k = c.length;
                }
                adgd = new dgd[i1 + k];
                if (c != null)
                {
                    System.arraycopy(c, 0, adgd, 0, k);
                }
                for (c = adgd; k < c.length - 1; k++)
                {
                    c[k] = new dgd();
                    eui1.a(c[k]);
                    eui1.a();
                }

                c[k] = new dgd();
                eui1.a(c[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            dxa adxa[] = b;
            int k = adxa.length;
            for (int i = 0; i < k; i++)
            {
                dxa dxa1 = adxa[i];
                if (dxa1 != null)
                {
                    euj1.a(2, dxa1);
                }
            }

        }
        if (c != null)
        {
            dgd adgd[] = c;
            int l = adgd.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                dgd dgd1 = adgd[j];
                if (dgd1 != null)
                {
                    euj1.a(3, dgd1);
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
            if (!(obj instanceof doh))
            {
                return false;
            }
            obj = (doh)obj;
            if ((a != null ? a.equals(((doh) (obj)).a) : ((doh) (obj)).a == null) && (Arrays.equals(b, ((doh) (obj)).b) && Arrays.equals(c, ((doh) (obj)).c)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((doh) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((doh) (obj)).O))
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
        j = getClass().getName().hashCode();
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        i += (j + 527) * 31;
        if (b != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L6:
        if (c != null) goto _L4; else goto _L3
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
        if (k >= b.length) goto _L6; else goto _L5
_L5:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
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
        if (j >= c.length) goto _L9; else goto _L8
_L8:
        if (c[j] == null)
        {
            k = 0;
        } else
        {
            k = c[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L10
    }
}
