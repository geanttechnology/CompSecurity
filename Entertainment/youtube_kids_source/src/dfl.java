// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dfl extends eul
{

    private boolean a;
    private float b;
    private float c;
    private float d;
    private float e;

    public dfl()
    {
        a = false;
        b = 0.0F;
        c = 0.0F;
        d = 0.0F;
        e = 0.0F;
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
        if (b != 0.0F)
        {
            float f = b;
            i = j + (euj.b(2) + 4);
        }
        j = i;
        if (c != 0.0F)
        {
            float f1 = c;
            j = i + (euj.b(3) + 4);
        }
        i = j;
        if (d != 0.0F)
        {
            float f2 = d;
            i = j + (euj.b(4) + 4);
        }
        j = i;
        if (e != 0.0F)
        {
            float f3 = e;
            j = i + (euj.b(5) + 4);
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

            case 21: // '\025'
                b = Float.intBitsToFloat(eui1.i());
                break;

            case 29: // '\035'
                c = Float.intBitsToFloat(eui1.i());
                break;

            case 37: // '%'
                d = Float.intBitsToFloat(eui1.i());
                break;

            case 45: // '-'
                e = Float.intBitsToFloat(eui1.i());
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
        if (e != 0.0F)
        {
            euj1.a(5, e);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dfl))
        {
            return false;
        }
        obj = (dfl)obj;
        if (a != ((dfl) (obj)).a || b != ((dfl) (obj)).b || c != ((dfl) (obj)).c || d != ((dfl) (obj)).d || e != ((dfl) (obj)).e)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dfl) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dfl) (obj)).O))
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
        int j1;
        int k1;
        if (a)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        l = Float.floatToIntBits(b);
        i1 = Float.floatToIntBits(c);
        j1 = Float.floatToIntBits(d);
        k1 = Float.floatToIntBits(e);
        if (O == null)
        {
            j = 0;
        } else
        {
            j = O.hashCode();
        }
        return j + (((((i + (k + 527) * 31) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31;
    }
}
