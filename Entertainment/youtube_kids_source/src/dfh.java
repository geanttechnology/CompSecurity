// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dfh extends eul
{

    public static final dfh a[] = new dfh[0];
    public int b;
    public dre c;
    public dre d;
    public dre e;
    private dfi f;
    private dfi g;
    private dfi h;

    public dfh()
    {
        b = 0;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
    }

    public final int a()
    {
        int j = 0;
        if (b != 0)
        {
            j = euj.c(1, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(3, d);
        }
        i = j;
        if (e != null)
        {
            i = j + euj.b(4, e);
        }
        j = i;
        if (f != null)
        {
            j = i + euj.b(5, f);
        }
        i = j;
        if (g != null)
        {
            i = j + euj.b(6, g);
        }
        j = i;
        if (h != null)
        {
            j = i + euj.b(7, h);
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

            case 8: // '\b'
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2 || j == 3 || j == 4)
                {
                    b = j;
                } else
                {
                    b = 0;
                }
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dre();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dre();
                }
                eui1.a(d);
                break;

            case 34: // '"'
                if (e == null)
                {
                    e = new dre();
                }
                eui1.a(e);
                break;

            case 42: // '*'
                if (f == null)
                {
                    f = new dfi();
                }
                eui1.a(f);
                break;

            case 50: // '2'
                if (g == null)
                {
                    g = new dfi();
                }
                eui1.a(g);
                break;

            case 58: // ':'
                if (h == null)
                {
                    h = new dfi();
                }
                eui1.a(h);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != 0)
        {
            euj1.a(1, b);
        }
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (d != null)
        {
            euj1.a(3, d);
        }
        if (e != null)
        {
            euj1.a(4, e);
        }
        if (f != null)
        {
            euj1.a(5, f);
        }
        if (g != null)
        {
            euj1.a(6, g);
        }
        if (h != null)
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
            if (!(obj instanceof dfh))
            {
                return false;
            }
            obj = (dfh)obj;
            if (b == ((dfh) (obj)).b && (c != null ? c.equals(((dfh) (obj)).c) : ((dfh) (obj)).c == null) && (d != null ? d.equals(((dfh) (obj)).d) : ((dfh) (obj)).d == null) && (e != null ? e.equals(((dfh) (obj)).e) : ((dfh) (obj)).e == null) && (f != null ? f.equals(((dfh) (obj)).f) : ((dfh) (obj)).f == null) && (g != null ? g.equals(((dfh) (obj)).g) : ((dfh) (obj)).g == null) && (h != null ? h.equals(((dfh) (obj)).h) : ((dfh) (obj)).h == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dfh) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dfh) (obj)).O))
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
        int i2 = b;
        int i;
        int j;
        int k;
        int l;
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
            l = 0;
        } else
        {
            l = f.hashCode();
        }
        if (g == null)
        {
            i1 = 0;
        } else
        {
            i1 = g.hashCode();
        }
        if (h == null)
        {
            j1 = 0;
        } else
        {
            j1 = h.hashCode();
        }
        if (O != null)
        {
            k1 = O.hashCode();
        }
        return (j1 + (i1 + (l + (k + (j + (i + ((l1 + 527) * 31 + i2) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k1;
    }

}
