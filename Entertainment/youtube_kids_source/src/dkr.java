// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dkr extends eul
{

    public static final dkr a[] = new dkr[0];
    public ebw b;
    public duv c;
    public dfj d;
    public dff e;
    public dnj f;
    private dii g;
    private dic h;
    private dhy i;
    private dig j;
    private dia k;

    public dkr()
    {
        b = null;
        g = null;
        c = null;
        h = null;
        i = null;
        j = null;
        k = null;
        d = null;
        e = null;
        f = null;
    }

    public final int a()
    {
        int i1 = 0;
        if (b != null)
        {
            i1 = euj.b(0x303c1d6, b) + 0;
        }
        int l = i1;
        if (g != null)
        {
            l = i1 + euj.b(0x3049143, g);
        }
        i1 = l;
        if (c != null)
        {
            i1 = l + euj.b(0x3061cf4, c);
        }
        l = i1;
        if (h != null)
        {
            l = i1 + euj.b(0x3064567, h);
        }
        i1 = l;
        if (i != null)
        {
            i1 = l + euj.b(0x3070f41, i);
        }
        l = i1;
        if (j != null)
        {
            l = i1 + euj.b(0x32b52b9, j);
        }
        i1 = l;
        if (k != null)
        {
            i1 = l + euj.b(0x37c6a1c, k);
        }
        l = i1;
        if (d != null)
        {
            l = i1 + euj.b(0x3e1ae1d, d);
        }
        i1 = l;
        if (e != null)
        {
            i1 = l + euj.b(0x4a7aeb4, e);
        }
        l = i1;
        if (f != null)
        {
            l = i1 + euj.b(0x4faac81, f);
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

            case 404623026: 
                if (b == null)
                {
                    b = new ebw();
                }
                eui1.a(b);
                break;

            case 405047834: 
                if (g == null)
                {
                    g = new dii();
                }
                eui1.a(g);
                break;

            case 405858210: 
                if (c == null)
                {
                    c = new duv();
                }
                eui1.a(c);
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

            case 467882210: 
                if (k == null)
                {
                    k = new dia();
                }
                eui1.a(k);
                break;

            case 520974570: 
                if (d == null)
                {
                    d = new dfj();
                }
                eui1.a(d);
                break;

            case 624784802: 
                if (e == null)
                {
                    e = new dff();
                }
                eui1.a(e);
                break;

            case 668296202: 
                if (f == null)
                {
                    f = new dnj();
                }
                eui1.a(f);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(0x303c1d6, b);
        }
        if (g != null)
        {
            euj1.a(0x3049143, g);
        }
        if (c != null)
        {
            euj1.a(0x3061cf4, c);
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
        if (k != null)
        {
            euj1.a(0x37c6a1c, k);
        }
        if (d != null)
        {
            euj1.a(0x3e1ae1d, d);
        }
        if (e != null)
        {
            euj1.a(0x4a7aeb4, e);
        }
        if (f != null)
        {
            euj1.a(0x4faac81, f);
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
            if (!(obj instanceof dkr))
            {
                return false;
            }
            obj = (dkr)obj;
            if ((b != null ? b.equals(((dkr) (obj)).b) : ((dkr) (obj)).b == null) && (g != null ? g.equals(((dkr) (obj)).g) : ((dkr) (obj)).g == null) && (c != null ? c.equals(((dkr) (obj)).c) : ((dkr) (obj)).c == null) && (h != null ? h.equals(((dkr) (obj)).h) : ((dkr) (obj)).h == null) && (i != null ? i.equals(((dkr) (obj)).i) : ((dkr) (obj)).i == null) && (j != null ? j.equals(((dkr) (obj)).j) : ((dkr) (obj)).j == null) && (k != null ? k.equals(((dkr) (obj)).k) : ((dkr) (obj)).k == null) && (d != null ? d.equals(((dkr) (obj)).d) : ((dkr) (obj)).d == null) && (e != null ? e.equals(((dkr) (obj)).e) : ((dkr) (obj)).e == null) && (f != null ? f.equals(((dkr) (obj)).f) : ((dkr) (obj)).f == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dkr) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dkr) (obj)).O))
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
        if (g == null)
        {
            i1 = 0;
        } else
        {
            i1 = g.hashCode();
        }
        if (c == null)
        {
            j1 = 0;
        } else
        {
            j1 = c.hashCode();
        }
        if (h == null)
        {
            k1 = 0;
        } else
        {
            k1 = h.hashCode();
        }
        if (i == null)
        {
            l1 = 0;
        } else
        {
            l1 = i.hashCode();
        }
        if (j == null)
        {
            i2 = 0;
        } else
        {
            i2 = j.hashCode();
        }
        if (k == null)
        {
            j2 = 0;
        } else
        {
            j2 = k.hashCode();
        }
        if (d == null)
        {
            k2 = 0;
        } else
        {
            k2 = d.hashCode();
        }
        if (e == null)
        {
            l2 = 0;
        } else
        {
            l2 = e.hashCode();
        }
        if (f == null)
        {
            i3 = 0;
        } else
        {
            i3 = f.hashCode();
        }
        if (O != null)
        {
            j3 = O.hashCode();
        }
        return (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l + (k3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + j3;
    }

}
