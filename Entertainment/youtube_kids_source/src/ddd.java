// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ddd extends eul
{

    private double a[];
    private dlb b;
    private dlb c;
    private int d;

    public ddd()
    {
        a = eup.c;
        b = null;
        c = null;
        d = 0;
    }

    public final int a()
    {
        int j = 0;
        int i = j;
        if (a != null)
        {
            i = j;
            if (a.length > 0)
            {
                i = a.length * 8 + 0 + a.length * 1;
            }
        }
        j = i;
        if (b != null)
        {
            j = i + euj.b(2, b);
        }
        i = j;
        if (c != null)
        {
            i = j + euj.b(3, c);
        }
        j = i;
        if (d != 0)
        {
            j = i + euj.d(4, d);
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

            case 9: // '\t'
                int k = eup.a(eui1, 9);
                int j = a.length;
                double ad[] = new double[k + j];
                System.arraycopy(a, 0, ad, 0, j);
                for (a = ad; j < a.length - 1; j++)
                {
                    a[j] = Double.longBitsToDouble(eui1.j());
                    eui1.a();
                }

                a[j] = Double.longBitsToDouble(eui1.j());
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 32: // ' '
                d = eui1.h();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            double ad[] = a;
            int j = ad.length;
            for (int i = 0; i < j; i++)
            {
                euj1.a(1, ad[i]);
            }

        }
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            euj1.a(3, c);
        }
        if (d != 0)
        {
            euj1.b(4, d);
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
            if (!(obj instanceof ddd))
            {
                return false;
            }
            obj = (ddd)obj;
            if (Arrays.equals(a, ((ddd) (obj)).a) && (b != null ? b.equals(((ddd) (obj)).b) : ((ddd) (obj)).b == null) && (c != null ? c.equals(((ddd) (obj)).c) : ((ddd) (obj)).c == null) && d == ((ddd) (obj)).d)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ddd) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ddd) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        int l;
        l = 0;
        i = getClass().getName().hashCode() + 527;
        if (a != null) goto _L2; else goto _L1
_L1:
        int j = i * 31;
_L4:
        int k;
        int i1;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        i1 = d;
        if (O != null)
        {
            l = O.hashCode();
        }
        return ((k + (i + j * 31) * 31) * 31 + i1) * 31 + l;
_L2:
        k = 0;
_L5:
        j = i;
        if (k >= a.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + (int)(Double.doubleToLongBits(a[k]) ^ Double.doubleToLongBits(a[k]) >>> 32);
        k++;
          goto _L5
    }
}
