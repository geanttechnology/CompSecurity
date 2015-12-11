// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dzq extends eul
{

    public static final dzq a[] = new dzq[0];
    public String b;
    public int c;
    public int d;

    public dzq()
    {
        b = "";
        c = 0;
        d = 0;
    }

    public final int a()
    {
        int j = 0;
        if (!b.equals(""))
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (c != 0)
        {
            i = j + euj.d(2, c);
        }
        j = i;
        if (d != 0)
        {
            j = i + euj.d(3, d);
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
                c = eui1.h();
                break;

            case 24: // '\030'
                d = eui1.h();
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
        if (c != 0)
        {
            euj1.b(2, c);
        }
        if (d != 0)
        {
            euj1.b(3, d);
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
            if (!(obj instanceof dzq))
            {
                return false;
            }
            obj = (dzq)obj;
            if ((b != null ? b.equals(((dzq) (obj)).b) : ((dzq) (obj)).b == null) && (c == ((dzq) (obj)).c && d == ((dzq) (obj)).d))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dzq) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dzq) (obj)).O))
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
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        l = c;
        i1 = d;
        if (O != null)
        {
            j = O.hashCode();
        }
        return (((i + (k + 527) * 31) * 31 + l) * 31 + i1) * 31 + j;
    }

}
