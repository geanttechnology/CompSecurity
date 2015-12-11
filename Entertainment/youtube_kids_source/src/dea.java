// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dea extends eul
{

    private boolean a;
    private int b;
    private boolean c;
    private int d;

    public dea()
    {
        a = false;
        b = 0;
        c = false;
        d = 0;
    }

    public final int a()
    {
        int j = 0;
        if (a)
        {
            boolean flag = a;
            j = euj.b(1) + 1 + 0;
        }
        int i = j;
        if (b != 0)
        {
            i = j + euj.d(2, b);
        }
        j = i;
        if (c)
        {
            boolean flag1 = c;
            j = i + (euj.b(3) + 1);
        }
        i = j;
        if (d != 0)
        {
            i = j + euj.d(4, d);
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

            case 16: // '\020'
                b = eui1.h();
                break;

            case 24: // '\030'
                c = eui1.e();
                break;

            case 32: // ' '
                d = eui1.h();
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
        if (b != 0)
        {
            euj1.b(2, b);
        }
        if (c)
        {
            euj1.a(3, c);
        }
        if (d != 0)
        {
            euj1.b(4, d);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dea))
        {
            return false;
        }
        obj = (dea)obj;
        if (a != ((dea) (obj)).a || b != ((dea) (obj)).b || c != ((dea) (obj)).c || d != ((dea) (obj)).d)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dea) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dea) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j = 1;
        int l = getClass().getName().hashCode();
        int i;
        int k;
        int i1;
        int j1;
        if (a)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        i1 = b;
        if (!c)
        {
            j = 2;
        }
        j1 = d;
        if (O == null)
        {
            k = 0;
        } else
        {
            k = O.hashCode();
        }
        return k + ((((i + (l + 527) * 31) * 31 + i1) * 31 + j) * 31 + j1) * 31;
    }
}
