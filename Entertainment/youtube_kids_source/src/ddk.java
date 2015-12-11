// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ddk extends eul
{

    private dlb a;
    private dlb b;
    private double c[];
    private dlb d;
    private dre e;
    private int f;
    private dlb g;
    private double h;
    private dlb i;

    public ddk()
    {
        a = null;
        b = null;
        c = eup.c;
        d = null;
        e = null;
        f = 0;
        g = null;
        h = 0.0D;
        i = null;
    }

    public final int a()
    {
        int k = 0;
        if (a != null)
        {
            k = euj.b(1, a) + 0;
        }
        int j = k;
        if (b != null)
        {
            j = k + euj.b(2, b);
        }
        k = j;
        if (c != null)
        {
            k = j;
            if (c.length > 0)
            {
                k = j + c.length * 8 + c.length * 1;
            }
        }
        j = k;
        if (d != null)
        {
            j = k + euj.b(4, d);
        }
        k = j;
        if (e != null)
        {
            k = j + euj.b(5, e);
        }
        j = k;
        if (f != 0)
        {
            j = k + euj.d(6, f);
        }
        k = j;
        if (g != null)
        {
            k = j + euj.b(7, g);
        }
        j = k;
        if (h != 0.0D)
        {
            double d1 = h;
            j = k + (euj.b(8) + 8);
        }
        k = j;
        if (i != null)
        {
            k = j + euj.b(9, i);
        }
        j = k + eup.a(O);
        P = j;
        return j;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int j = eui1.a();
            switch (j)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, j))
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

            case 18: // '\022'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 25: // '\031'
                int l = eup.a(eui1, 25);
                int k = c.length;
                double ad[] = new double[l + k];
                System.arraycopy(c, 0, ad, 0, k);
                for (c = ad; k < c.length - 1; k++)
                {
                    c[k] = Double.longBitsToDouble(eui1.j());
                    eui1.a();
                }

                c[k] = Double.longBitsToDouble(eui1.j());
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dre();
                }
                eui1.a(e);
                break;

            case 48: // '0'
                f = eui1.h();
                break;

            case 58: // ':'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 65: // 'A'
                h = Double.longBitsToDouble(eui1.j());
                break;

            case 74: // 'J'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
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
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            double ad[] = c;
            int k = ad.length;
            for (int j = 0; j < k; j++)
            {
                euj1.a(3, ad[j]);
            }

        }
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f != 0)
        {
            euj1.b(6, f);
        }
        if (g != null)
        {
            euj1.a(7, g);
        }
        if (h != 0.0D)
        {
            euj1.a(8, h);
        }
        if (i != null)
        {
            euj1.a(9, i);
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
            if (!(obj instanceof ddk))
            {
                return false;
            }
            obj = (ddk)obj;
            if ((a != null ? a.equals(((ddk) (obj)).a) : ((ddk) (obj)).a == null) && (b != null ? b.equals(((ddk) (obj)).b) : ((ddk) (obj)).b == null) && Arrays.equals(c, ((ddk) (obj)).c) && (d != null ? d.equals(((ddk) (obj)).d) : ((ddk) (obj)).d == null) && (e != null ? e.equals(((ddk) (obj)).e) : ((ddk) (obj)).e == null) && f == ((ddk) (obj)).f && (g != null ? g.equals(((ddk) (obj)).g) : ((ddk) (obj)).g == null) && h == ((ddk) (obj)).h && (i != null ? i.equals(((ddk) (obj)).i) : ((ddk) (obj)).i == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ddk) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ddk) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j;
        int k;
        int l1;
        l1 = 0;
        int l = getClass().getName().hashCode();
        int i2;
        int j2;
        if (a == null)
        {
            j = 0;
        } else
        {
            j = a.hashCode();
        }
        if (b == null)
        {
            k = 0;
        } else
        {
            k = b.hashCode();
        }
        j = k + (j + (l + 527) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        k = j * 31;
_L4:
        int i1;
        int j1;
        int k1;
        if (d == null)
        {
            j = 0;
        } else
        {
            j = d.hashCode();
        }
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        i2 = f;
        if (g == null)
        {
            j1 = 0;
        } else
        {
            j1 = g.hashCode();
        }
        j2 = (int)(Double.doubleToLongBits(h) ^ Double.doubleToLongBits(h) >>> 32);
        if (i == null)
        {
            k1 = 0;
        } else
        {
            k1 = i.hashCode();
        }
        if (O != null)
        {
            l1 = O.hashCode();
        }
        return (k1 + ((j1 + ((i1 + (j + k * 31) * 31) * 31 + i2) * 31) * 31 + j2) * 31) * 31 + l1;
_L2:
        i1 = 0;
_L5:
        k = j;
        if (i1 >= c.length) goto _L4; else goto _L3
_L3:
        j = j * 31 + (int)(Double.doubleToLongBits(c[i1]) ^ Double.doubleToLongBits(c[i1]) >>> 32);
        i1++;
          goto _L5
    }
}
