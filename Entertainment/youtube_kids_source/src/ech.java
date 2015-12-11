// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class ech extends eul
{

    private float a;
    private float b;
    private float c;
    private float d;

    public ech()
    {
        a = 0.0F;
        b = 0.0F;
        c = 0.0F;
        d = 0.0F;
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
        if (b != 0.0F)
        {
            float f1 = b;
            i = j + (euj.b(2) + 4);
        }
        j = i;
        if (c != 0.0F)
        {
            float f2 = c;
            j = i + (euj.b(3) + 4);
        }
        i = j;
        if (d != 0.0F)
        {
            float f3 = d;
            i = j + (euj.b(4) + 4);
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

            case 13: // '\r'
                a = Float.intBitsToFloat(eui1.i());
                break;

            case 21: // '\025'
                b = Float.intBitsToFloat(eui1.i());
                break;

            case 29: // '\035'
                c = Float.intBitsToFloat(eui1.i());
                break;

            case 37: // '%'
                d = Float.intBitsToFloat(eui1.i());
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
        if (b != 0.0F)
        {
            euj1.a(2, b);
        }
        if (c != 0.0F)
        {
            euj1.a(3, c);
        }
        if (d != 0.0F)
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
        if (!(obj instanceof ech))
        {
            return false;
        }
        obj = (ech)obj;
        if (a != ((ech) (obj)).a || b != ((ech) (obj)).b || c != ((ech) (obj)).c || d != ((ech) (obj)).d)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ech) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ech) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j = getClass().getName().hashCode();
        int k = Float.floatToIntBits(a);
        int l = Float.floatToIntBits(b);
        int i1 = Float.floatToIntBits(c);
        int j1 = Float.floatToIntBits(d);
        int i;
        if (O == null)
        {
            i = 0;
        } else
        {
            i = O.hashCode();
        }
        return i + (((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31;
    }
}
