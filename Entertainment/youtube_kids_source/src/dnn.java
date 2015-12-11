// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dnn extends eul
{

    private boolean a;
    private int b;
    private int c;

    public dnn()
    {
        a = false;
        b = 0;
        c = 0;
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
            i = j + euj.c(2, b);
        }
        j = i;
        if (c != 0)
        {
            j = i + euj.c(3, c);
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
                a = eui1.e();
                break;

            case 16: // '\020'
                b = eui1.d();
                break;

            case 24: // '\030'
                c = eui1.d();
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
            euj1.a(2, b);
        }
        if (c != 0)
        {
            euj1.a(3, c);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dnn))
        {
            return false;
        }
        obj = (dnn)obj;
        if (a != ((dnn) (obj)).a || b != ((dnn) (obj)).b || c != ((dnn) (obj)).c)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dnn) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dnn) (obj)).O))
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
        if (a)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        l = b;
        i1 = c;
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
