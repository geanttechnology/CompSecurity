// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class eab extends eul
{

    private long a;
    private boolean b;

    public eab()
    {
        a = 0L;
        b = false;
    }

    public final int a()
    {
        int i = 0;
        if (a != 0L)
        {
            i = euj.c(1, a) + 0;
        }
        int j = i;
        if (b)
        {
            boolean flag = b;
            j = i + (euj.b(2) + 1);
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

            case 8: // '\b'
                a = eui1.b();
                break;

            case 16: // '\020'
                b = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != 0L)
        {
            euj1.a(1, a);
        }
        if (b)
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
        if (!(obj instanceof eab))
        {
            return false;
        }
        obj = (eab)obj;
        if (a != ((eab) (obj)).a || b != ((eab) (obj)).b)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((eab) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((eab) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k = getClass().getName().hashCode();
        int l = (int)(a ^ a >>> 32);
        int i;
        int j;
        if (b)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (O == null)
        {
            j = 0;
        } else
        {
            j = O.hashCode();
        }
        return j + (i + ((k + 527) * 31 + l) * 31) * 31;
    }
}
