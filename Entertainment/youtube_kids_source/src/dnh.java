// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dnh extends eul
{

    private dlb a;
    private dlb b;
    private dzp c;
    private dre d;
    private doy e;
    private dxn f;
    private dqi g;
    private byte h[];

    public dnh()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = eup.f;
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
            j = i + euj.b(4, c);
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
        i = j;
        if (!Arrays.equals(h, eup.f))
        {
            i = j + euj.b(10, h);
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

            case 18: // '\022'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 34: // '"'
                if (c == null)
                {
                    c = new dzp();
                }
                eui1.a(c);
                break;

            case 42: // '*'
                if (d == null)
                {
                    d = new dre();
                }
                eui1.a(d);
                break;

            case 50: // '2'
                if (e == null)
                {
                    e = new doy();
                }
                eui1.a(e);
                break;

            case 58: // ':'
                if (f == null)
                {
                    f = new dxn();
                }
                eui1.a(f);
                break;

            case 66: // 'B'
                if (g == null)
                {
                    g = new dqi();
                }
                eui1.a(g);
                break;

            case 82: // 'R'
                h = eui1.g();
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
        if (f != null)
        {
            euj1.a(7, f);
        }
        if (g != null)
        {
            euj1.a(8, g);
        }
        if (!Arrays.equals(h, eup.f))
        {
            euj1.a(10, h);
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
            if (!(obj instanceof dnh))
            {
                return false;
            }
            obj = (dnh)obj;
            if ((a != null ? a.equals(((dnh) (obj)).a) : ((dnh) (obj)).a == null) && (b != null ? b.equals(((dnh) (obj)).b) : ((dnh) (obj)).b == null) && (c != null ? c.equals(((dnh) (obj)).c) : ((dnh) (obj)).c == null) && (d != null ? d.equals(((dnh) (obj)).d) : ((dnh) (obj)).d == null) && (e != null ? e.equals(((dnh) (obj)).e) : ((dnh) (obj)).e == null) && (f != null ? f.equals(((dnh) (obj)).f) : ((dnh) (obj)).f == null) && (g != null ? g.equals(((dnh) (obj)).g) : ((dnh) (obj)).g == null) && Arrays.equals(h, ((dnh) (obj)).h))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dnh) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dnh) (obj)).O))
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
        int i2 = getClass().getName().hashCode();
        int k;
        int i1;
        int j1;
        int k1;
        int l1;
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
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
        }
        if (e == null)
        {
            j1 = 0;
        } else
        {
            j1 = e.hashCode();
        }
        if (f == null)
        {
            k1 = 0;
        } else
        {
            k1 = f.hashCode();
        }
        if (g == null)
        {
            l1 = 0;
        } else
        {
            l1 = g.hashCode();
        }
        i = l1 + (k1 + (j1 + (i1 + (k + (j + (i + (i2 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (h != null) goto _L2; else goto _L1
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
        if (l >= h.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + h[l];
        l++;
          goto _L5
    }
}
