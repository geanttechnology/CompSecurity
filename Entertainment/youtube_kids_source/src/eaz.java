// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class eaz extends eul
{

    public static final eaz a[] = new eaz[0];
    public dii b;
    public dic c;
    public dhy d;
    public dig e;
    public dfj f;
    public die g;
    public dff h;
    public dnj i;
    private ebg j;
    private dhh k;

    public eaz()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        j = null;
        f = null;
        k = null;
        g = null;
        h = null;
        i = null;
    }

    public final int a()
    {
        int i1 = 0;
        if (b != null)
        {
            i1 = euj.b(0x3049143, b) + 0;
        }
        int l = i1;
        if (c != null)
        {
            l = i1 + euj.b(0x3064567, c);
        }
        i1 = l;
        if (d != null)
        {
            i1 = l + euj.b(0x3070f41, d);
        }
        l = i1;
        if (e != null)
        {
            l = i1 + euj.b(0x32b52b9, e);
        }
        i1 = l;
        if (j != null)
        {
            i1 = l + euj.b(0x3d6367c, j);
        }
        l = i1;
        if (f != null)
        {
            l = i1 + euj.b(0x3e1ae1d, f);
        }
        i1 = l;
        if (k != null)
        {
            i1 = l + euj.b(0x3f2030e, k);
        }
        l = i1;
        if (g != null)
        {
            l = i1 + euj.b(0x467ef78, g);
        }
        i1 = l;
        if (h != null)
        {
            i1 = l + euj.b(0x4a7aeb4, h);
        }
        l = i1;
        if (i != null)
        {
            l = i1 + euj.b(0x4faac81, i);
        }
        l += eup.a(O);
        P = l;
        return l;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int l = eui1.a();
            switch (l)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, l))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 405047834: 
                if (b == null)
                {
                    b = new dii();
                }
                eui1.a(b);
                break;

            case 405941050: 
                if (c == null)
                {
                    c = new dic();
                }
                eui1.a(c);
                break;

            case 406354442: 
                if (d == null)
                {
                    d = new dhy();
                }
                eui1.a(d);
                break;

            case 425366986: 
                if (e == null)
                {
                    e = new dig();
                }
                eui1.a(e);
                break;

            case 514962402: 
                if (j == null)
                {
                    j = new ebg();
                }
                eui1.a(j);
                break;

            case 520974570: 
                if (f == null)
                {
                    f = new dfj();
                }
                eui1.a(f);
                break;

            case 529537138: 
                if (k == null)
                {
                    k = new dhh();
                }
                eui1.a(k);
                break;

            case 591363010: 
                if (g == null)
                {
                    g = new die();
                }
                eui1.a(g);
                break;

            case 624784802: 
                if (h == null)
                {
                    h = new dff();
                }
                eui1.a(h);
                break;

            case 668296202: 
                if (i == null)
                {
                    i = new dnj();
                }
                eui1.a(i);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(0x3049143, b);
        }
        if (c != null)
        {
            euj1.a(0x3064567, c);
        }
        if (d != null)
        {
            euj1.a(0x3070f41, d);
        }
        if (e != null)
        {
            euj1.a(0x32b52b9, e);
        }
        if (j != null)
        {
            euj1.a(0x3d6367c, j);
        }
        if (f != null)
        {
            euj1.a(0x3e1ae1d, f);
        }
        if (k != null)
        {
            euj1.a(0x3f2030e, k);
        }
        if (g != null)
        {
            euj1.a(0x467ef78, g);
        }
        if (h != null)
        {
            euj1.a(0x4a7aeb4, h);
        }
        if (i != null)
        {
            euj1.a(0x4faac81, i);
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
            if (!(obj instanceof eaz))
            {
                return false;
            }
            obj = (eaz)obj;
            if ((b != null ? b.equals(((eaz) (obj)).b) : ((eaz) (obj)).b == null) && (c != null ? c.equals(((eaz) (obj)).c) : ((eaz) (obj)).c == null) && (d != null ? d.equals(((eaz) (obj)).d) : ((eaz) (obj)).d == null) && (e != null ? e.equals(((eaz) (obj)).e) : ((eaz) (obj)).e == null) && (j != null ? j.equals(((eaz) (obj)).j) : ((eaz) (obj)).j == null) && (f != null ? f.equals(((eaz) (obj)).f) : ((eaz) (obj)).f == null) && (k != null ? k.equals(((eaz) (obj)).k) : ((eaz) (obj)).k == null) && (g != null ? g.equals(((eaz) (obj)).g) : ((eaz) (obj)).g == null) && (h != null ? h.equals(((eaz) (obj)).h) : ((eaz) (obj)).h == null) && (i != null ? i.equals(((eaz) (obj)).i) : ((eaz) (obj)).i == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((eaz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((eaz) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j3 = 0;
        int k3 = getClass().getName().hashCode();
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        if (b == null)
        {
            l = 0;
        } else
        {
            l = b.hashCode();
        }
        if (c == null)
        {
            i1 = 0;
        } else
        {
            i1 = c.hashCode();
        }
        if (d == null)
        {
            j1 = 0;
        } else
        {
            j1 = d.hashCode();
        }
        if (e == null)
        {
            k1 = 0;
        } else
        {
            k1 = e.hashCode();
        }
        if (j == null)
        {
            l1 = 0;
        } else
        {
            l1 = j.hashCode();
        }
        if (f == null)
        {
            i2 = 0;
        } else
        {
            i2 = f.hashCode();
        }
        if (k == null)
        {
            j2 = 0;
        } else
        {
            j2 = k.hashCode();
        }
        if (g == null)
        {
            k2 = 0;
        } else
        {
            k2 = g.hashCode();
        }
        if (h == null)
        {
            l2 = 0;
        } else
        {
            l2 = h.hashCode();
        }
        if (i == null)
        {
            i3 = 0;
        } else
        {
            i3 = i.hashCode();
        }
        if (O != null)
        {
            j3 = O.hashCode();
        }
        return (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l + (k3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + j3;
    }

}
