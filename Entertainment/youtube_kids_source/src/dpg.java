// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dpg extends eul
{

    private dlb a;
    private boolean b;
    private boolean c;

    public dpg()
    {
        a = null;
        b = false;
        c = false;
    }

    public final int a()
    {
        int j = 0;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (b)
        {
            boolean flag = b;
            i = j + (euj.b(2) + 1);
        }
        j = i;
        if (c)
        {
            boolean flag1 = c;
            j = i + (euj.b(3) + 1);
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
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 16: // '\020'
                b = eui1.e();
                break;

            case 24: // '\030'
                c = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            euj1.a(1, a);
        }
        if (b)
        {
            euj1.a(2, b);
        }
        if (c)
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
            if (!(obj instanceof dpg))
            {
                return false;
            }
            obj = (dpg)obj;
            if ((a != null ? a.equals(((dpg) (obj)).a) : ((dpg) (obj)).a == null) && (b == ((dpg) (obj)).b && c == ((dpg) (obj)).c))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dpg) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dpg) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k = 1;
        int l = 0;
        int i1 = getClass().getName().hashCode();
        int i;
        int j;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        if (!c)
        {
            k = 2;
        }
        if (O != null)
        {
            l = O.hashCode();
        }
        return ((j + (i + (i1 + 527) * 31) * 31) * 31 + k) * 31 + l;
    }
}
