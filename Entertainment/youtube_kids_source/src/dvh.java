// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dvh extends eul
{

    private int a;
    private String b;
    private double c;

    public dvh()
    {
        a = 0;
        b = "";
        c = 0.0D;
    }

    public final int a()
    {
        int j = 0;
        if (a != 0)
        {
            j = euj.c(1, a) + 0;
        }
        int i = j;
        if (!b.equals(""))
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (c != 0.0D)
        {
            double d = c;
            j = i + (euj.b(3) + 8);
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
                if (j == 0 || j == 1 || j == 2 || j == 3)
                {
                    a = j;
                } else
                {
                    a = 0;
                }
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 25: // '\031'
                c = Double.longBitsToDouble(eui1.j());
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
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (c != 0.0D)
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
            if (!(obj instanceof dvh))
            {
                return false;
            }
            obj = (dvh)obj;
            if (a == ((dvh) (obj)).a && (b != null ? b.equals(((dvh) (obj)).b) : ((dvh) (obj)).b == null) && c == ((dvh) (obj)).c)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dvh) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dvh) (obj)).O))
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
        int l = a;
        int i;
        int i1;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        i1 = (int)(Double.doubleToLongBits(c) ^ Double.doubleToLongBits(c) >>> 32);
        if (O != null)
        {
            j = O.hashCode();
        }
        return ((i + ((k + 527) * 31 + l) * 31) * 31 + i1) * 31 + j;
    }
}
