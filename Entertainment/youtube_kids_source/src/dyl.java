// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dyl extends eul
{

    public dyp a;
    public dyn b;
    public dym c;
    public dit d;
    private dyo e;

    public dyl()
    {
        a = null;
        b = null;
        c = null;
        e = null;
        d = null;
    }

    public final int a()
    {
        int j = 0;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (b != null)
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(3, c);
        }
        i = j;
        if (e != null)
        {
            i = j + euj.b(5, e);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(6, d);
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
                    a = new dyp();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dyn();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dym();
                }
                eui1.a(c);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dyo();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                if (d == null)
                {
                    d = new dit();
                }
                eui1.a(d);
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
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (d != null)
        {
            euj1.a(6, d);
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
            if (!(obj instanceof dyl))
            {
                return false;
            }
            obj = (dyl)obj;
            if ((a != null ? a.equals(((dyl) (obj)).a) : ((dyl) (obj)).a == null) && (b != null ? b.equals(((dyl) (obj)).b) : ((dyl) (obj)).b == null) && (c != null ? c.equals(((dyl) (obj)).c) : ((dyl) (obj)).c == null) && (e != null ? e.equals(((dyl) (obj)).e) : ((dyl) (obj)).e == null) && (d != null ? d.equals(((dyl) (obj)).d) : ((dyl) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dyl) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dyl) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j1 = 0;
        int k1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
        int i1;
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
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        if (e == null)
        {
            l = 0;
        } else
        {
            l = e.hashCode();
        }
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
        }
        if (O != null)
        {
            j1 = O.hashCode();
        }
        return (i1 + (l + (k + (j + (i + (k1 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + j1;
    }
}
