// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dqm extends eul
{

    private dqo a[];
    private int b;

    public dqm()
    {
        a = dqo.a;
        b = 0;
    }

    public final int a()
    {
        int j = 0;
        int i = 0;
        if (a != null)
        {
            dqo adqo[] = a;
            int l = adqo.length;
            int k = 0;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dqo dqo1 = adqo[k];
                j = i;
                if (dqo1 != null)
                {
                    j = i + euj.b(1, dqo1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (b != 0)
        {
            i = j + euj.c(2, b);
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
                int k = eup.a(eui1, 10);
                dqo adqo[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adqo = new dqo[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adqo, 0, j);
                }
                for (a = adqo; j < a.length - 1; j++)
                {
                    a[j] = new dqo();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dqo();
                eui1.a(a[j]);
                break;

            case 16: // '\020'
                b = eui1.d();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            dqo adqo[] = a;
            int j = adqo.length;
            for (int i = 0; i < j; i++)
            {
                dqo dqo1 = adqo[i];
                if (dqo1 != null)
                {
                    euj1.a(1, dqo1);
                }
            }

        }
        if (b != 0)
        {
            euj1.a(2, b);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dqm))
        {
            return false;
        }
        obj = (dqm)obj;
        if (!Arrays.equals(a, ((dqm) (obj)).a) || b != ((dqm) (obj)).b)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dqm) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dqm) (obj)).O))
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
        int k = i * 31;
_L4:
        int j = b;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return (k * 31 + j) * 31 + i;
_L2:
        j = 0;
_L5:
        k = i;
        if (j >= a.length) goto _L4; else goto _L3
_L3:
        if (a[j] == null)
        {
            k = 0;
        } else
        {
            k = a[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L5
    }
}
