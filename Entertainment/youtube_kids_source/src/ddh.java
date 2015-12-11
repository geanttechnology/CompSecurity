// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class ddh extends eul
{

    public static final ddh a[] = new ddh[0];
    private ddk b;
    private ddl c;
    private ddb d;
    private dct e;
    private dcu f;
    private ddc g;
    private dcw h;
    private ddi i;
    private dcs j;

    public ddh()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
    }

    public final int a()
    {
        int l = 0;
        if (b != null)
        {
            l = euj.b(0x3ec6d57, b) + 0;
        }
        int k = l;
        if (c != null)
        {
            k = l + euj.b(0x3ec6d64, c);
        }
        l = k;
        if (d != null)
        {
            l = k + euj.b(0x3ec6d71, d);
        }
        k = l;
        if (e != null)
        {
            k = l + euj.b(0x3ec6d82, e);
        }
        l = k;
        if (f != null)
        {
            l = k + euj.b(0x4092887, f);
        }
        k = l;
        if (g != null)
        {
            k = l + euj.b(0x40943cf, g);
        }
        l = k;
        if (h != null)
        {
            l = k + euj.b(0x4a77302, h);
        }
        k = l;
        if (i != null)
        {
            k = l + euj.b(0x4a88a65, i);
        }
        l = k;
        if (j != null)
        {
            l = k + euj.b(0x4b19227, j);
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

            case 526609082: 
                if (b == null)
                {
                    b = new ddk();
                }
                eui1.a(b);
                break;

            case 526609186: 
                if (c == null)
                {
                    c = new ddl();
                }
                eui1.a(c);
                break;

            case 526609290: 
                if (d == null)
                {
                    d = new ddb();
                }
                eui1.a(d);
                break;

            case 526609426: 
                if (e == null)
                {
                    e = new dct();
                }
                eui1.a(e);
                break;

            case 541672506: 
                if (f == null)
                {
                    f = new dcu();
                }
                eui1.a(f);
                break;

            case 541728378: 
                if (g == null)
                {
                    g = new ddc();
                }
                eui1.a(g);
                break;

            case 624662546: 
                if (h == null)
                {
                    h = new dcw();
                }
                eui1.a(h);
                break;

            case 625234730: 
                if (i == null)
                {
                    i = new ddi();
                }
                eui1.a(i);
                break;

            case 629969210: 
                if (j == null)
                {
                    j = new dcs();
                }
                eui1.a(j);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(0x3ec6d57, b);
        }
        if (c != null)
        {
            euj1.a(0x3ec6d64, c);
        }
        if (d != null)
        {
            euj1.a(0x3ec6d71, d);
        }
        if (e != null)
        {
            euj1.a(0x3ec6d82, e);
        }
        if (f != null)
        {
            euj1.a(0x4092887, f);
        }
        if (g != null)
        {
            euj1.a(0x40943cf, g);
        }
        if (h != null)
        {
            euj1.a(0x4a77302, h);
        }
        if (i != null)
        {
            euj1.a(0x4a88a65, i);
        }
        if (j != null)
        {
            euj1.a(0x4b19227, j);
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
            if (!(obj instanceof ddh))
            {
                return false;
            }
            obj = (ddh)obj;
            if ((b != null ? b.equals(((ddh) (obj)).b) : ((ddh) (obj)).b == null) && (c != null ? c.equals(((ddh) (obj)).c) : ((ddh) (obj)).c == null) && (d != null ? d.equals(((ddh) (obj)).d) : ((ddh) (obj)).d == null) && (e != null ? e.equals(((ddh) (obj)).e) : ((ddh) (obj)).e == null) && (f != null ? f.equals(((ddh) (obj)).f) : ((ddh) (obj)).f == null) && (g != null ? g.equals(((ddh) (obj)).g) : ((ddh) (obj)).g == null) && (h != null ? h.equals(((ddh) (obj)).h) : ((ddh) (obj)).h == null) && (i != null ? i.equals(((ddh) (obj)).i) : ((ddh) (obj)).i == null) && (j != null ? j.equals(((ddh) (obj)).j) : ((ddh) (obj)).j == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ddh) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ddh) (obj)).O))
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
        if (b == null)
        {
            k = 0;
        } else
        {
            k = b.hashCode();
        }
        if (c == null)
        {
            l = 0;
        } else
        {
            l = c.hashCode();
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
        if (h == null)
        {
            i2 = 0;
        } else
        {
            i2 = h.hashCode();
        }
        if (i == null)
        {
            j2 = 0;
        } else
        {
            j2 = i.hashCode();
        }
        if (j == null)
        {
            k2 = 0;
        } else
        {
            k2 = j.hashCode();
        }
        if (O != null)
        {
            l2 = O.hashCode();
        }
        return (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l + (k + (i3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l2;
    }

}
