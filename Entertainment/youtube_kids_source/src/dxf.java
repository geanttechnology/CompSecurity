// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dxf extends eul
{

    private dlb a;
    private dlb b;
    private boolean c;
    private dxa d;
    private dxa e;

    public dxf()
    {
        a = null;
        b = null;
        c = false;
        d = null;
        e = null;
    }

    public final int a()
    {
        int j = 0;
        if (a != null)
        {
            j = euj.b(2, a) + 0;
        }
        int i = j;
        if (b != null)
        {
            i = j + euj.b(3, b);
        }
        j = i;
        if (c)
        {
            boolean flag = c;
            j = i + (euj.b(4) + 1);
        }
        i = j;
        if (d != null)
        {
            i = j + euj.b(5, d);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(6, e);
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

            case 18: // '\022'
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 26: // '\032'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 32: // ' '
                c = eui1.e();
                break;

            case 42: // '*'
                if (d == null)
                {
                    d = new dxa();
                }
                eui1.a(d);
                break;

            case 50: // '2'
                if (e == null)
                {
                    e = new dxa();
                }
                eui1.a(e);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            euj1.a(2, a);
        }
        if (b != null)
        {
            euj1.a(3, b);
        }
        if (c)
        {
            euj1.a(4, c);
        }
        if (d != null)
        {
            euj1.a(5, d);
        }
        if (e != null)
        {
            euj1.a(6, e);
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
            if (!(obj instanceof dxf))
            {
                return false;
            }
            obj = (dxf)obj;
            if ((a != null ? a.equals(((dxf) (obj)).a) : ((dxf) (obj)).a == null) && (b != null ? b.equals(((dxf) (obj)).b) : ((dxf) (obj)).b == null) && c == ((dxf) (obj)).c && (d != null ? d.equals(((dxf) (obj)).d) : ((dxf) (obj)).d == null) && (e != null ? e.equals(((dxf) (obj)).e) : ((dxf) (obj)).e == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dxf) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dxf) (obj)).O))
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
        if (c)
        {
            k = 1;
        } else
        {
            k = 2;
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
        if (O != null)
        {
            j1 = O.hashCode();
        }
        return (i1 + (l + (k + (j + (i + (k1 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + j1;
    }
}
