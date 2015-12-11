// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dwp extends eul
{

    private dlb a;
    private boolean b;
    private dlb c;
    private String d;
    private dlb e;
    private dlb f;
    private String g;

    public dwp()
    {
        a = null;
        b = false;
        c = null;
        d = "";
        e = null;
        f = null;
        g = "";
    }

    public final int a()
    {
        int j = 0;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (b)
        {
            boolean flag = b;
            i = j + (euj.b(2) + 1);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(3, c);
        }
        i = j;
        if (!d.equals(""))
        {
            i = j + euj.b(4, d);
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
        if (!g.equals(""))
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
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 16: // '\020'
                b = eui1.e();
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 34: // '"'
                d = eui1.f();
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dlb();
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
                g = eui1.f();
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
        if (b)
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            euj1.a(3, c);
        }
        if (!d.equals(""))
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f != null)
        {
            euj1.a(6, f);
        }
        if (!g.equals(""))
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
            if (!(obj instanceof dwp))
            {
                return false;
            }
            obj = (dwp)obj;
            if ((a != null ? a.equals(((dwp) (obj)).a) : ((dwp) (obj)).a == null) && b == ((dwp) (obj)).b && (c != null ? c.equals(((dwp) (obj)).c) : ((dwp) (obj)).c == null) && (d != null ? d.equals(((dwp) (obj)).d) : ((dwp) (obj)).d == null) && (e != null ? e.equals(((dwp) (obj)).e) : ((dwp) (obj)).e == null) && (f != null ? f.equals(((dwp) (obj)).f) : ((dwp) (obj)).f == null) && (g != null ? g.equals(((dwp) (obj)).g) : ((dwp) (obj)).g == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dwp) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dwp) (obj)).O))
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
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        if (d == null)
        {
            l = 0;
        } else
        {
            l = d.hashCode();
        }
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        if (f == null)
        {
            j1 = 0;
        } else
        {
            j1 = f.hashCode();
        }
        if (g == null)
        {
            k1 = 0;
        } else
        {
            k1 = g.hashCode();
        }
        if (O != null)
        {
            l1 = O.hashCode();
        }
        return (k1 + (j1 + (i1 + (l + (k + (j + (i + (i2 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l1;
    }
}
