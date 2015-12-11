// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dki extends eul
{

    public long a;
    public long b;
    private boolean c;

    public dki()
    {
        c = false;
        a = 0L;
        b = 0L;
    }

    public final int a()
    {
        int j = 0;
        if (c)
        {
            boolean flag = c;
            j = euj.b(1) + 1 + 0;
        }
        int i = j;
        if (a != 0L)
        {
            i = j + euj.c(2, a);
        }
        j = i;
        if (b != 0L)
        {
            j = i + euj.c(3, b);
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
                c = eui1.e();
                break;

            case 16: // '\020'
                a = eui1.b();
                break;

            case 24: // '\030'
                b = eui1.b();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (c)
        {
            euj1.a(1, c);
        }
        if (a != 0L)
        {
            euj1.a(2, a);
        }
        if (b != 0L)
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
        if (!(obj instanceof dki))
        {
            return false;
        }
        obj = (dki)obj;
        if (c != ((dki) (obj)).c || a != ((dki) (obj)).a || b != ((dki) (obj)).b)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dki) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dki) (obj)).O))
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
        int l;
        int i1;
        if (c)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        l = (int)(a ^ a >>> 32);
        i1 = (int)(b ^ b >>> 32);
        if (O == null)
        {
            j = 0;
        } else
        {
            j = O.hashCode();
        }
        return j + (((i + (k + 527) * 31) * 31 + l) * 31 + i1) * 31;
    }
}
