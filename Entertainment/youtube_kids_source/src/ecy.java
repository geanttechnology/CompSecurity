// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ecy extends eul
{

    public static final ecy a[] = new ecy[0];
    public dre b;
    private dzp c;
    private dlb d;
    private dlb e;
    private dlb f;
    private byte g[];

    public ecy()
    {
        c = null;
        d = null;
        e = null;
        f = null;
        b = null;
        g = eup.f;
    }

    public final int a()
    {
        int j = 0;
        if (c != null)
        {
            j = euj.b(1, c) + 0;
        }
        int i = j;
        if (d != null)
        {
            i = j + euj.b(2, d);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(3, e);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(4, f);
        }
        j = i;
        if (b != null)
        {
            j = i + euj.b(5, b);
        }
        i = j;
        if (!Arrays.equals(g, eup.f))
        {
            i = j + euj.b(7, g);
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
                if (c == null)
                {
                    c = new dzp();
                }
                eui1.a(c);
                break;

            case 18: // '\022'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 26: // '\032'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 34: // '"'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 42: // '*'
                if (b == null)
                {
                    b = new dre();
                }
                eui1.a(b);
                break;

            case 58: // ':'
                g = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (c != null)
        {
            euj1.a(1, c);
        }
        if (d != null)
        {
            euj1.a(2, d);
        }
        if (e != null)
        {
            euj1.a(3, e);
        }
        if (f != null)
        {
            euj1.a(4, f);
        }
        if (b != null)
        {
            euj1.a(5, b);
        }
        if (!Arrays.equals(g, eup.f))
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
            if (!(obj instanceof ecy))
            {
                return false;
            }
            obj = (ecy)obj;
            if ((c != null ? c.equals(((ecy) (obj)).c) : ((ecy) (obj)).c == null) && (d != null ? d.equals(((ecy) (obj)).d) : ((ecy) (obj)).d == null) && (e != null ? e.equals(((ecy) (obj)).e) : ((ecy) (obj)).e == null) && (f != null ? f.equals(((ecy) (obj)).f) : ((ecy) (obj)).f == null) && (b != null ? b.equals(((ecy) (obj)).b) : ((ecy) (obj)).b == null) && Arrays.equals(g, ((ecy) (obj)).g))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ecy) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ecy) (obj)).O))
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
        boolean flag = false;
        int k1 = getClass().getName().hashCode();
        int k;
        int i1;
        int j1;
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        if (d == null)
        {
            j = 0;
        } else
        {
            j = d.hashCode();
        }
        if (e == null)
        {
            k = 0;
        } else
        {
            k = e.hashCode();
        }
        if (f == null)
        {
            i1 = 0;
        } else
        {
            i1 = f.hashCode();
        }
        if (b == null)
        {
            j1 = 0;
        } else
        {
            j1 = b.hashCode();
        }
        i = j1 + (i1 + (k + (j + (i + (k1 + 527) * 31) * 31) * 31) * 31) * 31;
        if (g != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        int l;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return j * 31 + i;
_L2:
        l = 0;
_L5:
        j = i;
        if (l >= g.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + g[l];
        l++;
          goto _L5
    }

}
