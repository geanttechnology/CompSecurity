// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dey extends eul
{

    public float a;
    public boolean b;
    private float c;

    public dey()
    {
        a = 0.0F;
        b = false;
        c = 0.0F;
    }

    public final int a()
    {
        int j = 0;
        if (a != 0.0F)
        {
            float f = a;
            j = euj.b(1) + 4 + 0;
        }
        int i = j;
        if (b)
        {
            boolean flag = b;
            i = j + (euj.b(2) + 1);
        }
        j = i;
        if (c != 0.0F)
        {
            float f1 = c;
            j = i + (euj.b(3) + 4);
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

            case 13: // '\r'
                a = Float.intBitsToFloat(eui1.i());
                break;

            case 16: // '\020'
                b = eui1.e();
                break;

            case 29: // '\035'
                c = Float.intBitsToFloat(eui1.i());
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != 0.0F)
        {
            euj1.a(1, a);
        }
        if (b)
        {
            euj1.a(2, b);
        }
        if (c != 0.0F)
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
        if (!(obj instanceof dey))
        {
            return false;
        }
        obj = (dey)obj;
        if (a != ((dey) (obj)).a || b != ((dey) (obj)).b || c != ((dey) (obj)).c)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dey) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dey) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k = getClass().getName().hashCode();
        int l = Float.floatToIntBits(a);
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
        i1 = Float.floatToIntBits(c);
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
