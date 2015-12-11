// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class eao extends eul
{

    private dlb a;
    private boolean b;
    private String c;
    private dre d;
    private dlb e;
    private dzp f;

    public eao()
    {
        a = null;
        b = false;
        c = "";
        d = null;
        e = null;
        f = null;
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
        if (!c.equals(""))
        {
            j = i + euj.b(3, c);
        }
        i = j;
        if (d != null)
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
                c = eui1.f();
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dre();
                }
                eui1.a(d);
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
                    f = new dzp();
                }
                eui1.a(f);
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
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (d != null)
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
            if (!(obj instanceof eao))
            {
                return false;
            }
            obj = (eao)obj;
            if ((a != null ? a.equals(((eao) (obj)).a) : ((eao) (obj)).a == null) && b == ((eao) (obj)).b && (c != null ? c.equals(((eao) (obj)).c) : ((eao) (obj)).c == null) && (d != null ? d.equals(((eao) (obj)).d) : ((eao) (obj)).d == null) && (e != null ? e.equals(((eao) (obj)).e) : ((eao) (obj)).e == null) && (f != null ? f.equals(((eao) (obj)).f) : ((eao) (obj)).f == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((eao) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((eao) (obj)).O))
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
        if (O != null)
        {
            k1 = O.hashCode();
        }
        return (j1 + (i1 + (l + (k + (j + (i + (l1 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k1;
    }
}
