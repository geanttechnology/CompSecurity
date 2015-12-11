// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dlz extends eul
{

    public static final dlz a[] = new dlz[0];
    public dli b;
    public dlj c;
    public dln d;
    public dlo e;
    public dll f;
    private dii g;
    private dic h;
    private dhy i;
    private dig j;

    public dlz()
    {
        g = null;
        h = null;
        i = null;
        j = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
    }

    public final int a()
    {
        int l = 0;
        if (g != null)
        {
            l = euj.b(0x3049143, g) + 0;
        }
        int k = l;
        if (h != null)
        {
            k = l + euj.b(0x3064567, h);
        }
        l = k;
        if (i != null)
        {
            l = k + euj.b(0x3070f41, i);
        }
        k = l;
        if (j != null)
        {
            k = l + euj.b(0x32b52b9, j);
        }
        l = k;
        if (b != null)
        {
            l = k + euj.b(0x3993a2b, b);
        }
        k = l;
        if (c != null)
        {
            k = l + euj.b(0x3993a43, c);
        }
        l = k;
        if (d != null)
        {
            l = k + euj.b(0x3993a4a, d);
        }
        k = l;
        if (e != null)
        {
            k = l + euj.b(0x3993a79, e);
        }
        l = k;
        if (f != null)
        {
            l = k + euj.b(0x4e600b4, f);
        }
        k = l + eup.a(O);
        P = k;
        return k;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int k = eui1.a();
            switch (k)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, k))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 405047834: 
                if (g == null)
                {
                    g = new dii();
                }
                eui1.a(g);
                break;

            case 405941050: 
                if (h == null)
                {
                    h = new dic();
                }
                eui1.a(h);
                break;

            case 406354442: 
                if (i == null)
                {
                    i = new dhy();
                }
                eui1.a(i);
                break;

            case 425366986: 
                if (j == null)
                {
                    j = new dig();
                }
                eui1.a(j);
                break;

            case 482988378: 
                if (b == null)
                {
                    b = new dli();
                }
                eui1.a(b);
                break;

            case 482988570: 
                if (c == null)
                {
                    c = new dlj();
                }
                eui1.a(c);
                break;

            case 482988626: 
                if (d == null)
                {
                    d = new dln();
                }
                eui1.a(d);
                break;

            case 482989002: 
                if (e == null)
                {
                    e = new dlo();
                }
                eui1.a(e);
                break;

            case 657458594: 
                if (f == null)
                {
                    f = new dll();
                }
                eui1.a(f);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (g != null)
        {
            euj1.a(0x3049143, g);
        }
        if (h != null)
        {
            euj1.a(0x3064567, h);
        }
        if (i != null)
        {
            euj1.a(0x3070f41, i);
        }
        if (j != null)
        {
            euj1.a(0x32b52b9, j);
        }
        if (b != null)
        {
            euj1.a(0x3993a2b, b);
        }
        if (c != null)
        {
            euj1.a(0x3993a43, c);
        }
        if (d != null)
        {
            euj1.a(0x3993a4a, d);
        }
        if (e != null)
        {
            euj1.a(0x3993a79, e);
        }
        if (f != null)
        {
            euj1.a(0x4e600b4, f);
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
            if (!(obj instanceof dlz))
            {
                return false;
            }
            obj = (dlz)obj;
            if ((g != null ? g.equals(((dlz) (obj)).g) : ((dlz) (obj)).g == null) && (h != null ? h.equals(((dlz) (obj)).h) : ((dlz) (obj)).h == null) && (i != null ? i.equals(((dlz) (obj)).i) : ((dlz) (obj)).i == null) && (j != null ? j.equals(((dlz) (obj)).j) : ((dlz) (obj)).j == null) && (b != null ? b.equals(((dlz) (obj)).b) : ((dlz) (obj)).b == null) && (c != null ? c.equals(((dlz) (obj)).c) : ((dlz) (obj)).c == null) && (d != null ? d.equals(((dlz) (obj)).d) : ((dlz) (obj)).d == null) && (e != null ? e.equals(((dlz) (obj)).e) : ((dlz) (obj)).e == null) && (f != null ? f.equals(((dlz) (obj)).f) : ((dlz) (obj)).f == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dlz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dlz) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l2 = 0;
        int i3 = getClass().getName().hashCode();
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        if (g == null)
        {
            k = 0;
        } else
        {
            k = g.hashCode();
        }
        if (h == null)
        {
            l = 0;
        } else
        {
            l = h.hashCode();
        }
        if (i == null)
        {
            i1 = 0;
        } else
        {
            i1 = i.hashCode();
        }
        if (j == null)
        {
            j1 = 0;
        } else
        {
            j1 = j.hashCode();
        }
        if (b == null)
        {
            k1 = 0;
        } else
        {
            k1 = b.hashCode();
        }
        if (c == null)
        {
            l1 = 0;
        } else
        {
            l1 = c.hashCode();
        }
        if (d == null)
        {
            i2 = 0;
        } else
        {
            i2 = d.hashCode();
        }
        if (e == null)
        {
            j2 = 0;
        } else
        {
            j2 = e.hashCode();
        }
        if (f == null)
        {
            k2 = 0;
        } else
        {
            k2 = f.hashCode();
        }
        if (O != null)
        {
            l2 = O.hashCode();
        }
        return (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l + (k + (i3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l2;
    }

}
