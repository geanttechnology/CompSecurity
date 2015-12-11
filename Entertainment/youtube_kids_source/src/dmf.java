// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dmf extends eul
{

    private int a;
    private dme b[];

    public dmf()
    {
        a = 0;
        b = dme.a;
    }

    public final int a()
    {
        int j = 0;
        int i;
        int k;
        if (a != 0)
        {
            i = euj.c(1, a) + 0;
        } else
        {
            i = 0;
        }
        k = i;
        if (b != null)
        {
            dme adme[] = b;
            int l = adme.length;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                dme dme1 = adme[j];
                k = i;
                if (dme1 != null)
                {
                    k = i + euj.b(2, dme1);
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

            case 8: // '\b'
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2)
                {
                    a = j;
                } else
                {
                    a = 0;
                }
                break;

            case 18: // '\022'
                int l = eup.a(eui1, 18);
                dme adme[];
                int k;
                if (b == null)
                {
                    k = 0;
                } else
                {
                    k = b.length;
                }
                adme = new dme[l + k];
                if (b != null)
                {
                    System.arraycopy(b, 0, adme, 0, k);
                }
                for (b = adme; k < b.length - 1; k++)
                {
                    b[k] = new dme();
                    eui1.a(b[k]);
                    eui1.a();
                }

                b[k] = new dme();
                eui1.a(b[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != 0)
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            dme adme[] = b;
            int j = adme.length;
            for (int i = 0; i < j; i++)
            {
                dme dme1 = adme[i];
                if (dme1 != null)
                {
                    euj1.a(2, dme1);
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
        if (!(obj instanceof dmf))
        {
            return false;
        }
        obj = (dmf)obj;
        if (a != ((dmf) (obj)).a || !Arrays.equals(b, ((dmf) (obj)).b))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmf) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmf) (obj)).O))
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
        i = (getClass().getName().hashCode() + 527) * 31 + a;
        if (b != null) goto _L2; else goto _L1
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
        if (j >= b.length) goto _L4; else goto _L3
_L3:
        if (b[j] == null)
        {
            k = 0;
        } else
        {
            k = b[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L5
    }
}
