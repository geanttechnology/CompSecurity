// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dtq extends eul
{

    public int a;
    private String b;
    private boolean c;

    public dtq()
    {
        b = "";
        a = 0;
        c = false;
    }

    public final int a()
    {
        int j = 0;
        if (!b.equals(""))
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (a != 0)
        {
            i = j + euj.c(2, a);
        }
        j = i;
        if (c)
        {
            boolean flag = c;
            j = i + (euj.b(4) + 1);
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
                b = eui1.f();
                break;

            case 16: // '\020'
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2 || j == 3)
                {
                    a = j;
                } else
                {
                    a = 0;
                }
                break;

            case 32: // ' '
                c = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!b.equals(""))
        {
            euj1.a(1, b);
        }
        if (a != 0)
        {
            euj1.a(2, a);
        }
        if (c)
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
label0:
        {
            if (!(obj instanceof dtq))
            {
                return false;
            }
            obj = (dtq)obj;
            if ((b != null ? b.equals(((dtq) (obj)).b) : ((dtq) (obj)).b == null) && (a == ((dtq) (obj)).a && c == ((dtq) (obj)).c))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dtq) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dtq) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k = 0;
        int l = getClass().getName().hashCode();
        int i;
        int j;
        int i1;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        i1 = a;
        if (c)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        if (O != null)
        {
            k = O.hashCode();
        }
        return (j + ((i + (l + 527) * 31) * 31 + i1) * 31) * 31 + k;
    }
}
