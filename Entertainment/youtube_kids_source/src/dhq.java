// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dhq extends eul
{

    private dhu a[];
    private dht b[];
    private dlb c;

    public dhq()
    {
        a = dhu.a;
        b = dht.a;
        c = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        if (a != null)
        {
            dhu adhu[] = a;
            int j1 = adhu.length;
            int l = 0;
            int j = 0;
            do
            {
                i = j;
                if (l >= j1)
                {
                    break;
                }
                dhu dhu1 = adhu[l];
                i = j;
                if (dhu1 != null)
                {
                    i = j + euj.b(1, dhu1);
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
            dht adht[] = b;
            int k1 = adht.length;
            int i1 = ((flag) ? 1 : 0);
            do
            {
                k = i;
                if (i1 >= k1)
                {
                    break;
                }
                dht dht1 = adht[i1];
                k = i;
                if (dht1 != null)
                {
                    k = i + euj.b(2, dht1);
                }
                i1++;
                i = k;
            } while (true);
        }
        i = k;
        if (c != null)
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
                dhu adhu[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adhu = new dhu[l + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adhu, 0, j);
                }
                for (a = adhu; j < a.length - 1; j++)
                {
                    a[j] = new dhu();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dhu();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                int i1 = eup.a(eui1, 18);
                dht adht[];
                int k;
                if (b == null)
                {
                    k = 0;
                } else
                {
                    k = b.length;
                }
                adht = new dht[i1 + k];
                if (b != null)
                {
                    System.arraycopy(b, 0, adht, 0, k);
                }
                for (b = adht; k < b.length - 1; k++)
                {
                    b[k] = new dht();
                    eui1.a(b[k]);
                    eui1.a();
                }

                b[k] = new dht();
                eui1.a(b[k]);
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            dhu adhu[] = a;
            int k = adhu.length;
            for (int i = 0; i < k; i++)
            {
                dhu dhu1 = adhu[i];
                if (dhu1 != null)
                {
                    euj1.a(1, dhu1);
                }
            }

        }
        if (b != null)
        {
            dht adht[] = b;
            int l = adht.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                dht dht1 = adht[j];
                if (dht1 != null)
                {
                    euj1.a(2, dht1);
                }
            }

        }
        if (c != null)
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
label0:
        {
            if (!(obj instanceof dhq))
            {
                return false;
            }
            obj = (dhq)obj;
            if (Arrays.equals(a, ((dhq) (obj)).a) && Arrays.equals(b, ((dhq) (obj)).b) && (c != null ? c.equals(((dhq) (obj)).c) : ((dhq) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dhq) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dhq) (obj)).O))
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
        j *= 31;
_L9:
        int k;
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
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
_L10:
        j = i;
        if (k >= b.length) goto _L9; else goto _L8
_L8:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L10
    }
}
