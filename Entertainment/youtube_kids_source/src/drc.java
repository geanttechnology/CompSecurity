// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class drc extends eul
{

    private String a;
    private dre b;
    private byte c[];
    private String d;
    private dmb e;
    private dlb f;
    private dre g;

    public drc()
    {
        a = "";
        b = null;
        c = eup.f;
        d = "";
        e = null;
        f = null;
        g = null;
    }

    public final int a()
    {
        int j = 0;
        if (!a.equals(""))
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (b != null)
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (!Arrays.equals(c, eup.f))
        {
            j = i + euj.b(4, c);
        }
        i = j;
        if (!d.equals(""))
        {
            i = j + euj.b(5, d);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(6, e);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(7, f);
        }
        j = i;
        if (g != null)
        {
            j = i + euj.b(8, g);
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
                a = eui1.f();
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dre();
                }
                eui1.a(b);
                break;

            case 34: // '"'
                c = eui1.g();
                break;

            case 42: // '*'
                d = eui1.f();
                break;

            case 50: // '2'
                if (e == null)
                {
                    e = new dmb();
                }
                eui1.a(e);
                break;

            case 58: // ':'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 66: // 'B'
                if (g == null)
                {
                    g = new dre();
                }
                eui1.a(g);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!a.equals(""))
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(4, c);
        }
        if (!d.equals(""))
        {
            euj1.a(5, d);
        }
        if (e != null)
        {
            euj1.a(6, e);
        }
        if (f != null)
        {
            euj1.a(7, f);
        }
        if (g != null)
        {
            euj1.a(8, g);
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
            if (!(obj instanceof drc))
            {
                return false;
            }
            obj = (drc)obj;
            if ((a != null ? a.equals(((drc) (obj)).a) : ((drc) (obj)).a == null) && (b != null ? b.equals(((drc) (obj)).b) : ((drc) (obj)).b == null) && Arrays.equals(c, ((drc) (obj)).c) && (d != null ? d.equals(((drc) (obj)).d) : ((drc) (obj)).d == null) && (e != null ? e.equals(((drc) (obj)).e) : ((drc) (obj)).e == null) && (f != null ? f.equals(((drc) (obj)).f) : ((drc) (obj)).f == null) && (g != null ? g.equals(((drc) (obj)).g) : ((drc) (obj)).g == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((drc) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((drc) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        int j;
        int k1;
        k1 = 0;
        int k = getClass().getName().hashCode();
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        i = j + (i + (k + 527) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        int l;
        int i1;
        int j1;
        if (d == null)
        {
            i = 0;
        } else
        {
            i = d.hashCode();
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
        return (j1 + (i1 + (l + (i + j * 31) * 31) * 31) * 31) * 31 + k1;
_L2:
        l = 0;
_L5:
        j = i;
        if (l >= c.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + c[l];
        l++;
          goto _L5
    }
}
