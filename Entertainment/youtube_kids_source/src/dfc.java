// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dfc extends eul
{

    public dzp a;
    private dlb b;
    private dlb c;
    private int d;
    private ean e;
    private dlb f;
    private dlb g;

    public dfc()
    {
        b = null;
        c = null;
        d = 0;
        a = null;
        e = null;
        f = null;
        g = null;
    }

    public final int a()
    {
        int j = 0;
        if (b != null)
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (d != 0)
        {
            j = i + euj.c(3, d);
        }
        i = j;
        if (a != null)
        {
            i = j + euj.b(4, a);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(5, e);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(6, f);
        }
        j = i;
        if (g != null)
        {
            j = i + euj.b(7, g);
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
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 24: // '\030'
                d = eui1.d();
                break;

            case 34: // '"'
                if (a == null)
                {
                    a = new dzp();
                }
                eui1.a(a);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new ean();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 58: // ':'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(1, b);
        }
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (d != 0)
        {
            euj1.a(3, d);
        }
        if (a != null)
        {
            euj1.a(4, a);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f != null)
        {
            euj1.a(6, f);
        }
        if (g != null)
        {
            euj1.a(7, g);
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
            if (!(obj instanceof dfc))
            {
                return false;
            }
            obj = (dfc)obj;
            if ((b != null ? b.equals(((dfc) (obj)).b) : ((dfc) (obj)).b == null) && (c != null ? c.equals(((dfc) (obj)).c) : ((dfc) (obj)).c == null) && d == ((dfc) (obj)).d && (a != null ? a.equals(((dfc) (obj)).a) : ((dfc) (obj)).a == null) && (e != null ? e.equals(((dfc) (obj)).e) : ((dfc) (obj)).e == null) && (f != null ? f.equals(((dfc) (obj)).f) : ((dfc) (obj)).f == null) && (g != null ? g.equals(((dfc) (obj)).g) : ((dfc) (obj)).g == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dfc) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dfc) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k1 = 0;
        int l1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int i2;
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
        i2 = d;
        if (a == null)
        {
            k = 0;
        } else
        {
            k = a.hashCode();
        }
        if (e == null)
        {
            l = 0;
        } else
        {
            l = e.hashCode();
        }
        if (f == null)
        {
            i1 = 0;
        } else
        {
            i1 = f.hashCode();
        }
        if (g == null)
        {
            j1 = 0;
        } else
        {
            j1 = g.hashCode();
        }
        if (O != null)
        {
            k1 = O.hashCode();
        }
        return (j1 + (i1 + (l + (k + ((j + (i + (l1 + 527) * 31) * 31) * 31 + i2) * 31) * 31) * 31) * 31) * 31 + k1;
    }
}
