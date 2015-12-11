// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dor extends eul
{

    public static final dor a[] = new dor[0];
    public String b;
    public String c;
    private dlb d;
    private int e;
    private boolean f;
    private double g;

    public dor()
    {
        b = "";
        c = "";
        d = null;
        e = 0;
        f = false;
        g = 0.0D;
    }

    public final int a()
    {
        int j = 0;
        if (!b.equals(""))
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (!c.equals(""))
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(3, d);
        }
        i = j;
        if (e != 0)
        {
            i = j + euj.c(4, e);
        }
        j = i;
        if (f)
        {
            boolean flag = f;
            j = i + (euj.b(5) + 1);
        }
        i = j;
        if (g != 0.0D)
        {
            double d1 = g;
            i = j + (euj.b(6) + 8);
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

            case 10: // '\n'
                b = eui1.f();
                break;

            case 18: // '\022'
                c = eui1.f();
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 32: // ' '
                e = eui1.d();
                break;

            case 40: // '('
                f = eui1.e();
                break;

            case 49: // '1'
                g = Double.longBitsToDouble(eui1.j());
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
        if (!c.equals(""))
        {
            euj1.a(2, c);
        }
        if (d != null)
        {
            euj1.a(3, d);
        }
        if (e != 0)
        {
            euj1.a(4, e);
        }
        if (f)
        {
            euj1.a(5, f);
        }
        if (g != 0.0D)
        {
            euj1.a(6, g);
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
            if (!(obj instanceof dor))
            {
                return false;
            }
            obj = (dor)obj;
            if ((b != null ? b.equals(((dor) (obj)).b) : ((dor) (obj)).b == null) && (c != null ? c.equals(((dor) (obj)).c) : ((dor) (obj)).c == null) && (d != null ? d.equals(((dor) (obj)).d) : ((dor) (obj)).d == null) && (e == ((dor) (obj)).e && f == ((dor) (obj)).f && g == ((dor) (obj)).g))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dor) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dor) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i1 = 0;
        int j1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
        int k1;
        int l1;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (c == null)
        {
            j = 0;
        } else
        {
            j = c.hashCode();
        }
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        k1 = e;
        if (f)
        {
            l = 1;
        } else
        {
            l = 2;
        }
        l1 = (int)(Double.doubleToLongBits(g) ^ Double.doubleToLongBits(g) >>> 32);
        if (O != null)
        {
            i1 = O.hashCode();
        }
        return ((l + ((k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31 + k1) * 31) * 31 + l1) * 31 + i1;
    }

}
