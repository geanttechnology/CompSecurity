// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dtf extends eul
{

    private int a;
    private boolean b;
    private int c;

    public dtf()
    {
        a = 0;
        b = false;
        c = 0;
    }

    public final int a()
    {
        int j = 0;
        if (a != 0)
        {
            j = euj.c(1, a) + 0;
        }
        int i = j;
        if (b)
        {
            boolean flag = b;
            i = j + (euj.b(2) + 1);
        }
        j = i;
        if (c != 0)
        {
            j = i + euj.c(4, c);
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
                a = eui1.d();
                break;

            case 16: // '\020'
                b = eui1.e();
                break;

            case 32: // ' '
                c = eui1.d();
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
        if (b)
        {
            euj1.a(2, b);
        }
        if (c != 0)
        {
            euj1.a(4, c);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dtf))
        {
            return false;
        }
        obj = (dtf)obj;
        if (a != ((dtf) (obj)).a || b != ((dtf) (obj)).b || c != ((dtf) (obj)).c)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dtf) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dtf) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k = getClass().getName().hashCode();
        int l = a;
        int i;
        int j;
        int i1;
        if (b)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        i1 = c;
        if (O == null)
        {
            j = 0;
        } else
        {
            j = O.hashCode();
        }
        return j + ((i + ((k + 527) * 31 + l) * 31) * 31 + i1) * 31;
    }
}
