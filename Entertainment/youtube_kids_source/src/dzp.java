// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dzp extends eul
{

    public static final dzp a[] = new dzp[0];
    public dzq b[];

    public dzp()
    {
        b = dzq.a;
    }

    public final int a()
    {
        int k = 0;
        int i = 0;
        if (b != null)
        {
            dzq adzq[] = b;
            int l = adzq.length;
            int j = 0;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                dzq dzq1 = adzq[j];
                k = i;
                if (dzq1 != null)
                {
                    k = i + euj.b(1, dzq1);
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

            case 10: // '\n'
                int k = eup.a(eui1, 10);
                dzq adzq[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adzq = new dzq[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adzq, 0, j);
                }
                for (b = adzq; j < b.length - 1; j++)
                {
                    b[j] = new dzq();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dzq();
                eui1.a(b[j]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            dzq adzq[] = b;
            int j = adzq.length;
            for (int i = 0; i < j; i++)
            {
                dzq dzq1 = adzq[i];
                if (dzq1 != null)
                {
                    euj1.a(1, dzq1);
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
        if (!(obj instanceof dzp))
        {
            return false;
        }
        obj = (dzp)obj;
        if (!Arrays.equals(b, ((dzp) (obj)).b))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dzp) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dzp) (obj)).O))
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
