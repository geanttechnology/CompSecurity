// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dhg extends eul
{

    private boolean a;

    public dhg()
    {
        a = false;
    }

    public final int a()
    {
        int i = 0;
        if (a)
        {
            boolean flag = a;
            i = euj.b(1) + 1 + 0;
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
                a = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a)
        {
            euj1.a(1, a);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dhg))
        {
            return false;
        }
        obj = (dhg)obj;
        if (a != ((dhg) (obj)).a)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dhg) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dhg) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k = getClass().getName().hashCode();
        int i;
        int j;
        if (a)
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
        return j + (i + (k + 527) * 31) * 31;
    }
}
