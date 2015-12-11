// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dxg extends eul
{

    private dlb a;
    private dxh b[];

    public dxg()
    {
        a = null;
        b = dxh.a;
    }

    public final int a()
    {
        int j = 0;
        int i;
        int k;
        if (a != null)
        {
            i = euj.b(2, a) + 0;
        } else
        {
            i = 0;
        }
        k = i;
        if (b != null)
        {
            dxh adxh[] = b;
            int l = adxh.length;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                dxh dxh1 = adxh[j];
                k = i;
                if (dxh1 != null)
                {
                    k = i + euj.b(3, dxh1);
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
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 26: // '\032'
                int k = eup.a(eui1, 26);
                dxh adxh[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adxh = new dxh[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adxh, 0, j);
                }
                for (b = adxh; j < b.length - 1; j++)
                {
                    b[j] = new dxh();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dxh();
                eui1.a(b[j]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            euj1.a(2, a);
        }
        if (b != null)
        {
            dxh adxh[] = b;
            int j = adxh.length;
            for (int i = 0; i < j; i++)
            {
                dxh dxh1 = adxh[i];
                if (dxh1 != null)
                {
                    euj1.a(3, dxh1);
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
            if (!(obj instanceof dxg))
            {
                return false;
            }
            obj = (dxg)obj;
            if ((a != null ? a.equals(((dxg) (obj)).a) : ((dxg) (obj)).a == null) && Arrays.equals(b, ((dxg) (obj)).b))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dxg) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dxg) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        int l;
        boolean flag = false;
        int j = getClass().getName().hashCode();
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
        l = i * 31;
_L4:
        int k;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return l * 31 + i;
_L2:
        k = 0;
_L5:
        l = i;
        if (k >= b.length) goto _L4; else goto _L3
_L3:
        if (b[k] == null)
        {
            l = 0;
        } else
        {
            l = b[k].hashCode();
        }
        i = l + i * 31;
        k++;
          goto _L5
    }
}
