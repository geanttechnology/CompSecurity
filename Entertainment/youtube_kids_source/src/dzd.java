// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dzd extends eul
{

    private String a[];

    public dzd()
    {
        a = eup.d;
    }

    public final int a()
    {
        boolean flag = false;
        boolean flag1 = false;
        int i = ((flag) ? 1 : 0);
        if (a != null)
        {
            i = ((flag) ? 1 : 0);
            if (a.length > 0)
            {
                String as[] = a;
                int k = as.length;
                int j = 0;
                for (i = ((flag1) ? 1 : 0); i < k; i++)
                {
                    j += euj.a(as[i]);
                }

                i = j + 0 + a.length * 1;
            }
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
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dzd))
        {
            return false;
        }
        obj = (dzd)obj;
        if (!Arrays.equals(a, ((dzd) (obj)).a))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dzd) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dzd) (obj)).O))
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
