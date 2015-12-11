// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dxm extends eul
{

    private dlb a;
    private dlb b;
    private dxk c[];

    public dxm()
    {
        a = null;
        b = null;
        c = dxk.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int k;
        if (a != null)
        {
            j = euj.b(2, a) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (b != null)
        {
            i = j + euj.b(3, b);
        }
        k = i;
        if (c != null)
        {
            dxk adxk[] = c;
            int l = adxk.length;
            j = ((flag) ? 1 : 0);
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                dxk dxk1 = adxk[j];
                k = i;
                if (dxk1 != null)
                {
                    k = i + euj.b(4, dxk1);
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
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 34: // '"'
                int k = eup.a(eui1, 34);
                dxk adxk[];
                int j;
                if (c == null)
                {
                    j = 0;
                } else
                {
                    j = c.length;
                }
                adxk = new dxk[k + j];
                if (c != null)
                {
                    System.arraycopy(c, 0, adxk, 0, j);
                }
                for (c = adxk; j < c.length - 1; j++)
                {
                    c[j] = new dxk();
                    eui1.a(c[j]);
                    eui1.a();
                }

                c[j] = new dxk();
                eui1.a(c[j]);
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
            euj1.a(3, b);
        }
        if (c != null)
        {
            dxk adxk[] = c;
            int j = adxk.length;
            for (int i = 0; i < j; i++)
            {
                dxk dxk1 = adxk[i];
                if (dxk1 != null)
                {
                    euj1.a(4, dxk1);
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
            if (!(obj instanceof dxm))
            {
                return false;
            }
            obj = (dxm)obj;
            if ((a != null ? a.equals(((dxm) (obj)).a) : ((dxm) (obj)).a == null) && (b != null ? b.equals(((dxm) (obj)).b) : ((dxm) (obj)).b == null) && Arrays.equals(c, ((dxm) (obj)).c))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dxm) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dxm) (obj)).O))
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
        l = getClass().getName().hashCode();
        int j;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        i = j + (i + (l + 527) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
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
        if (k >= c.length) goto _L4; else goto _L3
_L3:
        if (c[k] == null)
        {
            l = 0;
        } else
        {
            l = c[k].hashCode();
        }
        i = l + i * 31;
        k++;
          goto _L5
    }
}
