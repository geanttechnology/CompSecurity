// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dqs extends eul
{

    private String a;
    private int b;
    private int c;

    public dqs()
    {
        a = "";
        b = 0;
        c = 0;
    }

    public final int a()
    {
        int j = 0;
        if (!a.equals(""))
        {
            j = euj.b(1, a) + 0;
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

            case 10: // '\n'
                a = eui1.f();
                break;

            case 16: // '\020'
                b = eui1.d();
                break;

            case 24: // '\030'
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2)
                {
                    c = j;
                } else
                {
                    c = 0;
                }
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!a.equals(""))
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
label0:
        {
            if (!(obj instanceof dqs))
            {
                return false;
            }
            obj = (dqs)obj;
            if ((a != null ? a.equals(((dqs) (obj)).a) : ((dqs) (obj)).a == null) && (b == ((dqs) (obj)).b && c == ((dqs) (obj)).c))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dqs) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dqs) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j = 0;
        int k = getClass().getName().hashCode();
        int i;
        int l;
        int i1;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        l = b;
        i1 = c;
        if (O != null)
        {
            j = O.hashCode();
        }
        return (((i + (k + 527) * 31) * 31 + l) * 31 + i1) * 31 + j;
    }
}
