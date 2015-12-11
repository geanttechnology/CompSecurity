// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class ddc extends eul
{

    private dlb a;
    private dlb b;
    private dlb c;
    private long d;
    private dlb e;
    private long f;
    private dre g;
    private int h;
    private dlb i;

    public ddc()
    {
        a = null;
        b = null;
        c = null;
        d = 0L;
        e = null;
        f = 0L;
        g = null;
        h = 0;
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
            k = j + euj.b(3, c);
        }
        j = k;
        if (d != 0L)
        {
            j = k + euj.d(4, d);
        }
        k = j;
        if (e != null)
        {
            k = j + euj.b(5, e);
        }
        j = k;
        if (f != 0L)
        {
            j = k + euj.d(6, f);
        }
        k = j;
        if (g != null)
        {
            k = j + euj.b(7, g);
        }
        j = k;
        if (h != 0)
        {
            j = k + euj.d(8, h);
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

            case 26: // '\032'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 32: // ' '
                d = eui1.c();
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 48: // '0'
                f = eui1.c();
                break;

            case 58: // ':'
                if (g == null)
                {
                    g = new dre();
                }
                eui1.a(g);
                break;

            case 64: // '@'
                h = eui1.h();
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
            euj1.a(3, c);
        }
        if (d != 0L)
        {
            euj1.b(4, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f != 0L)
        {
            euj1.b(6, f);
        }
        if (g != null)
        {
            euj1.a(7, g);
        }
        if (h != 0)
        {
            euj1.b(8, h);
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
            if (!(obj instanceof ddc))
            {
                return false;
            }
            obj = (ddc)obj;
            if ((a != null ? a.equals(((ddc) (obj)).a) : ((ddc) (obj)).a == null) && (b != null ? b.equals(((ddc) (obj)).b) : ((ddc) (obj)).b == null) && (c != null ? c.equals(((ddc) (obj)).c) : ((ddc) (obj)).c == null) && d == ((ddc) (obj)).d && (e != null ? e.equals(((ddc) (obj)).e) : ((ddc) (obj)).e == null) && f == ((ddc) (obj)).f && (g != null ? g.equals(((ddc) (obj)).g) : ((ddc) (obj)).g == null) && h == ((ddc) (obj)).h && (i != null ? i.equals(((ddc) (obj)).i) : ((ddc) (obj)).i == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ddc) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ddc) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l1 = 0;
        int i2 = getClass().getName().hashCode();
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int j2;
        int k2;
        int l2;
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
        if (c == null)
        {
            l = 0;
        } else
        {
            l = c.hashCode();
        }
        j2 = (int)(d ^ d >>> 32);
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        k2 = (int)(f ^ f >>> 32);
        if (g == null)
        {
            j1 = 0;
        } else
        {
            j1 = g.hashCode();
        }
        l2 = h;
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
        return (k1 + ((j1 + ((i1 + ((l + (k + (j + (i2 + 527) * 31) * 31) * 31) * 31 + j2) * 31) * 31 + k2) * 31) * 31 + l2) * 31) * 31 + l1;
    }
}
