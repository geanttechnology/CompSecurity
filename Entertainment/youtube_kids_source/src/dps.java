// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dps extends eul
{

    private int a;
    private dpr b[];
    private boolean c;

    public dps()
    {
        a = 0;
        b = dpr.a;
        c = false;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (a != 0)
        {
            i = euj.c(1, a) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (b != null)
        {
            dpr adpr[] = b;
            int l = adpr.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dpr dpr1 = adpr[k];
                j = i;
                if (dpr1 != null)
                {
                    j = i + euj.b(2, dpr1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (c)
        {
            boolean flag = c;
            i = j + (euj.b(3) + 1);
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

            case 8: // '\b'
                a = eui1.d();
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                dpr adpr[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adpr = new dpr[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adpr, 0, j);
                }
                for (b = adpr; j < b.length - 1; j++)
                {
                    b[j] = new dpr();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dpr();
                eui1.a(b[j]);
                break;

            case 24: // '\030'
                c = eui1.e();
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
            dpr adpr[] = b;
            int j = adpr.length;
            for (int i = 0; i < j; i++)
            {
                dpr dpr1 = adpr[i];
                if (dpr1 != null)
                {
                    euj1.a(2, dpr1);
                }
            }

        }
        if (c)
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
        if (!(obj instanceof dps))
        {
            return false;
        }
        obj = (dps)obj;
        if (a != ((dps) (obj)).a || !Arrays.equals(b, ((dps) (obj)).b) || c != ((dps) (obj)).c)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dps) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dps) (obj)).O))
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
        int j = i * 31;
_L4:
        int k;
        if (c)
        {
            i = 1;
        } else
        {
            i = 2;
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
_L5:
        j = i;
        if (k >= b.length) goto _L4; else goto _L3
_L3:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L5
    }
}
