// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dyh extends eul
{

    private String a[];
    private byte b[];

    public dyh()
    {
        a = eup.d;
        b = eup.f;
    }

    public final int a()
    {
        int j = 0;
        boolean flag = false;
        int i = j;
        if (a != null)
        {
            i = j;
            if (a.length > 0)
            {
                String as[] = a;
                int k = as.length;
                j = 0;
                for (i = ((flag) ? 1 : 0); i < k; i++)
                {
                    j += euj.a(as[i]);
                }

                i = j + 0 + a.length * 1;
            }
        }
        j = i;
        if (!Arrays.equals(b, eup.f))
        {
            j = i + euj.b(3, b);
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
                int j = a.length;
                String as[] = new String[k + j];
                System.arraycopy(a, 0, as, 0, j);
                for (a = as; j < a.length - 1; j++)
                {
                    a[j] = eui1.f();
                    eui1.a();
                }

                a[j] = eui1.f();
                break;

            case 26: // '\032'
                b = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            String as[] = a;
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                euj1.a(1, as[i]);
            }

        }
        if (!Arrays.equals(b, eup.f))
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
        if (!(obj instanceof dyh))
        {
            return false;
        }
        obj = (dyh)obj;
        if (!Arrays.equals(a, ((dyh) (obj)).a) || !Arrays.equals(b, ((dyh) (obj)).b))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dyh) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dyh) (obj)).O))
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
        if (b != null) goto _L4; else goto _L3
_L3:
        i = j * 31;
_L9:
        int k;
        if (O == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = O.hashCode();
        }
        return i * 31 + j;
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
_L10:
        i = j;
        if (k >= b.length) goto _L9; else goto _L8
_L8:
        j = j * 31 + b[k];
        k++;
          goto _L10
    }
}
