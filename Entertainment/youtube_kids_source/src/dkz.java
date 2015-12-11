// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dkz extends eul
{

    public String a[];
    public String b;
    private String c[];

    public dkz()
    {
        a = eup.d;
        c = eup.d;
        b = "";
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int k;
        if (a != null && a.length > 0)
        {
            String as[] = a;
            int l = as.length;
            i = 0;
            int j = 0;
            for (; i < l; i++)
            {
                j += euj.a(as[i]);
            }

            i = j + 0 + a.length * 1;
        } else
        {
            i = 0;
        }
        k = i;
        if (c != null)
        {
            k = i;
            if (c.length > 0)
            {
                String as1[] = c;
                int j1 = as1.length;
                int i1 = 0;
                for (k = ((flag) ? 1 : 0); k < j1; k++)
                {
                    i1 += euj.a(as1[k]);
                }

                k = i + i1 + c.length * 1;
            }
        }
        i = k;
        if (!b.equals(""))
        {
            i = k + euj.b(3, b);
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
                int j = a.length;
                String as[] = new String[l + j];
                System.arraycopy(a, 0, as, 0, j);
                for (a = as; j < a.length - 1; j++)
                {
                    a[j] = eui1.f();
                    eui1.a();
                }

                a[j] = eui1.f();
                break;

            case 18: // '\022'
                int i1 = eup.a(eui1, 18);
                int k = c.length;
                String as1[] = new String[i1 + k];
                System.arraycopy(c, 0, as1, 0, k);
                for (c = as1; k < c.length - 1; k++)
                {
                    c[k] = eui1.f();
                    eui1.a();
                }

                c[k] = eui1.f();
                break;

            case 26: // '\032'
                b = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            String as[] = a;
            int k = as.length;
            for (int i = 0; i < k; i++)
            {
                euj1.a(1, as[i]);
            }

        }
        if (c != null)
        {
            String as1[] = c;
            int l = as1.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                euj1.a(2, as1[j]);
            }

        }
        if (!b.equals(""))
        {
            euj1.a(3, b);
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
            if (!(obj instanceof dkz))
            {
                return false;
            }
            obj = (dkz)obj;
            if (Arrays.equals(a, ((dkz) (obj)).a) && Arrays.equals(c, ((dkz) (obj)).c) && (b != null ? b.equals(((dkz) (obj)).b) : ((dkz) (obj)).b == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dkz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dkz) (obj)).O))
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
        if (c != null) goto _L4; else goto _L3
_L3:
        j *= 31;
_L9:
        int k;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
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
        if (k >= c.length) goto _L9; else goto _L8
_L8:
        if (c[k] == null)
        {
            j = 0;
        } else
        {
            j = c[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L10
    }
}
