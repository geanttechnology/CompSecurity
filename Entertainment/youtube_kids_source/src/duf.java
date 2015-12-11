// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class duf extends eul
{

    private int a[];

    public duf()
    {
        a = eup.a;
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
                int ai[] = a;
                int k = ai.length;
                int j = 0;
                for (i = ((flag1) ? 1 : 0); i < k; i++)
                {
                    j += euj.a(ai[i]);
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

            case 8: // '\b'
                int k = eup.a(eui1, 8);
                int j = a.length;
                int ai[] = new int[k + j];
                System.arraycopy(a, 0, ai, 0, j);
                for (a = ai; j < a.length - 1; j++)
                {
                    a[j] = eui1.d();
                    eui1.a();
                }

                a[j] = eui1.d();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null && a.length > 0)
        {
            int ai[] = a;
            int j = ai.length;
            for (int i = 0; i < j; i++)
            {
                euj1.a(1, ai[i]);
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
        if (!(obj instanceof duf))
        {
            return false;
        }
        obj = (duf)obj;
        if (!Arrays.equals(a, ((duf) (obj)).a))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((duf) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((duf) (obj)).O))
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
_L4:
        int k;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return j * 31 + i;
_L2:
        k = 0;
_L5:
        j = i;
        if (k >= a.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + a[k];
        k++;
          goto _L5
    }
}
