// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class ddr extends eul
{

    public int a;
    public int b;
    public boolean c;
    public boolean d;

    public ddr()
    {
        a = 0;
        b = 0;
        c = false;
        d = false;
    }

    public final int a()
    {
        int j = 0;
        if (a != 0)
        {
            j = euj.c(1, a) + 0;
        }
        int i = j;
        if (b != 0)
        {
            i = j + euj.c(2, b);
        }
        j = i;
        if (c)
        {
            boolean flag = c;
            j = i + (euj.b(3) + 1);
        }
        i = j;
        if (d)
        {
            boolean flag1 = d;
            i = j + (euj.b(4) + 1);
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
                a = eui1.d();
                break;

            case 16: // '\020'
                b = eui1.d();
                break;

            case 24: // '\030'
                c = eui1.e();
                break;

            case 32: // ' '
                d = eui1.e();
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
        if (b != 0)
        {
            euj1.a(2, b);
        }
        if (c)
        {
            euj1.a(3, c);
        }
        if (d)
        {
            euj1.a(4, d);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof ddr))
        {
            return false;
        }
        obj = (ddr)obj;
        if (a != ((ddr) (obj)).a || b != ((ddr) (obj)).b || c != ((ddr) (obj)).c || d != ((ddr) (obj)).d)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ddr) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ddr) (obj)).O))
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
        int i1 = a;
        int j1 = b;
        int i;
        int k;
        if (c)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (!d)
        {
            j = 2;
        }
        if (O == null)
        {
            k = 0;
        } else
        {
            k = O.hashCode();
        }
        return k + ((i + (((l + 527) * 31 + i1) * 31 + j1) * 31) * 31 + j) * 31;
    }
}
