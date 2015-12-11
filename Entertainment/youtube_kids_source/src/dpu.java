// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dpu extends eul
{

    private String a;
    private dpt b[];
    private boolean c;

    public dpu()
    {
        a = "";
        b = dpt.a;
        c = false;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (!a.equals(""))
        {
            i = euj.b(1, a) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (b != null)
        {
            dpt adpt[] = b;
            int l = adpt.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dpt dpt1 = adpt[k];
                j = i;
                if (dpt1 != null)
                {
                    j = i + euj.b(2, dpt1);
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

            case 10: // '\n'
                a = eui1.f();
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                dpt adpt[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adpt = new dpt[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adpt, 0, j);
                }
                for (b = adpt; j < b.length - 1; j++)
                {
                    b[j] = new dpt();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dpt();
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
        if (!a.equals(""))
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            dpt adpt[] = b;
            int j = adpt.length;
            for (int i = 0; i < j; i++)
            {
                dpt dpt1 = adpt[i];
                if (dpt1 != null)
                {
                    euj1.a(2, dpt1);
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
label0:
        {
            if (!(obj instanceof dpu))
            {
                return false;
            }
            obj = (dpu)obj;
            if ((a != null ? a.equals(((dpu) (obj)).a) : ((dpu) (obj)).a == null) && (Arrays.equals(b, ((dpu) (obj)).b) && c == ((dpu) (obj)).c))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dpu) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dpu) (obj)).O))
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
