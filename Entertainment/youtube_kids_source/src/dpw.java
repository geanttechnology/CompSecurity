// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dpw extends eul
{

    private int a;
    private dpv b[];

    public dpw()
    {
        a = 0;
        b = dpv.a;
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
            dpv adpv[] = b;
            int l = adpv.length;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                dpv dpv1 = adpv[j];
                k = i;
                if (dpv1 != null)
                {
                    k = i + euj.b(2, dpv1);
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
                dpv adpv[];
                int k;
                if (b == null)
                {
                    k = 0;
                } else
                {
                    k = b.length;
                }
                adpv = new dpv[l + k];
                if (b != null)
                {
                    System.arraycopy(b, 0, adpv, 0, k);
                }
                for (b = adpv; k < b.length - 1; k++)
                {
                    b[k] = new dpv();
                    eui1.a(b[k]);
                    eui1.a();
                }

                b[k] = new dpv();
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
            dpv adpv[] = b;
            int j = adpv.length;
            for (int i = 0; i < j; i++)
            {
                dpv dpv1 = adpv[i];
                if (dpv1 != null)
                {
                    euj1.a(2, dpv1);
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
        if (!(obj instanceof dpw))
        {
            return false;
        }
        obj = (dpw)obj;
        if (a != ((dpw) (obj)).a || !Arrays.equals(b, ((dpw) (obj)).b))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dpw) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dpw) (obj)).O))
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
