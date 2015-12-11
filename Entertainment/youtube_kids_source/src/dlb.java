// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dlb extends eul
{

    public static final dlb a[] = new dlb[0];
    public dza b[];
    private boolean c;
    private dlc d;

    public dlb()
    {
        b = dza.a;
        c = false;
        d = null;
    }

    public final int a()
    {
        int j = 0;
        int i = 0;
        if (b != null)
        {
            dza adza[] = b;
            int l = adza.length;
            int k = 0;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dza dza1 = adza[k];
                j = i;
                if (dza1 != null)
                {
                    j = i + euj.b(1, dza1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (c)
        {
            boolean flag = c;
            i = j + (euj.b(2) + 1);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(3, d);
        }
        i = j + eup.a(O);
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
                int k = eup.a(eui1, 10);
                dza adza[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adza = new dza[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adza, 0, j);
                }
                for (b = adza; j < b.length - 1; j++)
                {
                    b[j] = new dza();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dza();
                eui1.a(b[j]);
                break;

            case 16: // '\020'
                c = eui1.e();
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dlc();
                }
                eui1.a(d);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            dza adza[] = b;
            int j = adza.length;
            for (int i = 0; i < j; i++)
            {
                dza dza1 = adza[i];
                if (dza1 != null)
                {
                    euj1.a(1, dza1);
                }
            }

        }
        if (c)
        {
            euj1.a(2, c);
        }
        if (d != null)
        {
            euj1.a(3, d);
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
            if (!(obj instanceof dlb))
            {
                return false;
            }
            obj = (dlb)obj;
            if (Arrays.equals(b, ((dlb) (obj)).b) && c == ((dlb) (obj)).c && (d != null ? d.equals(((dlb) (obj)).d) : ((dlb) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dlb) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dlb) (obj)).O))
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
        l = 0;
        i = getClass().getName().hashCode() + 527;
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
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + (i + j * 31) * 31) * 31 + l;
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
