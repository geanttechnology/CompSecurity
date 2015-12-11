// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dgi extends eul
{

    public static final dgi a[] = new dgi[0];
    private String b;
    private dlb c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private boolean h;

    public dgi()
    {
        b = "";
        c = null;
        d = "";
        e = "";
        f = "";
        g = false;
        h = false;
    }

    public final int a()
    {
        int j = 0;
        if (!b.equals(""))
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (!d.equals(""))
        {
            j = i + euj.b(3, d);
        }
        i = j;
        if (!e.equals(""))
        {
            i = j + euj.b(4, e);
        }
        j = i;
        if (!f.equals(""))
        {
            j = i + euj.b(5, f);
        }
        i = j;
        if (g)
        {
            boolean flag = g;
            i = j + (euj.b(6) + 1);
        }
        j = i;
        if (h)
        {
            boolean flag1 = h;
            j = i + (euj.b(7) + 1);
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
                b = eui1.f();
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                d = eui1.f();
                break;

            case 34: // '"'
                e = eui1.f();
                break;

            case 42: // '*'
                f = eui1.f();
                break;

            case 48: // '0'
                g = eui1.e();
                break;

            case 56: // '8'
                h = eui1.e();
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
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (!d.equals(""))
        {
            euj1.a(3, d);
        }
        if (!e.equals(""))
        {
            euj1.a(4, e);
        }
        if (!f.equals(""))
        {
            euj1.a(5, f);
        }
        if (g)
        {
            euj1.a(6, g);
        }
        if (h)
        {
            euj1.a(7, h);
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
            if (!(obj instanceof dgi))
            {
                return false;
            }
            obj = (dgi)obj;
            if ((b != null ? b.equals(((dgi) (obj)).b) : ((dgi) (obj)).b == null) && (c != null ? c.equals(((dgi) (obj)).c) : ((dgi) (obj)).c == null) && (d != null ? d.equals(((dgi) (obj)).d) : ((dgi) (obj)).d == null) && (e != null ? e.equals(((dgi) (obj)).e) : ((dgi) (obj)).e == null) && (f != null ? f.equals(((dgi) (obj)).f) : ((dgi) (obj)).f == null) && (g == ((dgi) (obj)).g && h == ((dgi) (obj)).h))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dgi) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dgi) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k1 = 1;
        int l1 = 0;
        int i2 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
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
        if (g)
        {
            j1 = 1;
        } else
        {
            j1 = 2;
        }
        if (!h)
        {
            k1 = 2;
        }
        if (O != null)
        {
            l1 = O.hashCode();
        }
        return ((j1 + (i1 + (l + (k + (j + (i + (i2 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k1) * 31 + l1;
    }

}
