// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dsi extends eul
{

    public int a;
    public float b;
    public int c;

    public dsi()
    {
        a = 0;
        b = 0.0F;
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
        if (b != 0.0F)
        {
            float f = b;
            i = j + (euj.b(2) + 4);
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
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2)
                {
                    a = j;
                } else
                {
                    a = 0;
                }
                break;

            case 21: // '\025'
                b = Float.intBitsToFloat(eui1.i());
                break;

            case 24: // '\030'
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
        if (b != 0.0F)
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
        if (!(obj instanceof dsi))
        {
            return false;
        }
        obj = (dsi)obj;
        if (a != ((dsi) (obj)).a || b != ((dsi) (obj)).b || c != ((dsi) (obj)).c)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dsi) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dsi) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j = getClass().getName().hashCode();
        int k = a;
        int l = Float.floatToIntBits(b);
        int i1 = c;
        int i;
        if (O == null)
        {
            i = 0;
        } else
        {
            i = O.hashCode();
        }
        return i + ((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31;
    }
}
