// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class diq extends eul
{

    private byte a[];
    private dry b;
    private drj c;
    private dvg d;
    private dvu e;
    private eak f;
    private dzt g;
    private dcq h;
    private dns i;

    public diq()
    {
        a = eup.f;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
    }

    public final int a()
    {
        int k = 0;
        if (!Arrays.equals(a, eup.f))
        {
            k = euj.b(1, a) + 0;
        }
        int j = k;
        if (b != null)
        {
            j = k + euj.b(0x3120359, b);
        }
        k = j;
        if (c != null)
        {
            k = j + euj.b(0x31a2ee9, c);
        }
        j = k;
        if (d != null)
        {
            j = k + euj.b(0x31a2eed, d);
        }
        k = j;
        if (e != null)
        {
            k = j + euj.b(0x39af697, e);
        }
        j = k;
        if (f != null)
        {
            j = k + euj.b(0x3e68bff, f);
        }
        k = j;
        if (g != null)
        {
            k = j + euj.b(0x4314c98, g);
        }
        j = k;
        if (h != null)
        {
            j = k + euj.b(0x493fdf8, h);
        }
        k = j;
        if (i != null)
        {
            k = j + euj.b(0x4a49488, i);
        }
        j = k + eup.a(O);
        P = j;
        return j;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int j = eui1.a();
            switch (j)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, j))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                a = eui1.g();
                break;

            case 412097226: 
                if (b == null)
                {
                    b = new dry();
                }
                eui1.a(b);
                break;

            case 416380746: 
                if (c == null)
                {
                    c = new drj();
                }
                eui1.a(c);
                break;

            case 416380778: 
                if (d == null)
                {
                    d = new dvg();
                }
                eui1.a(d);
                break;

            case 483898554: 
                if (e == null)
                {
                    e = new dvu();
                }
                eui1.a(e);
                break;

            case 523526138: 
                if (f == null)
                {
                    f = new eak();
                }
                eui1.a(f);
                break;

            case 562717890: 
                if (g == null)
                {
                    g = new dzt();
                }
                eui1.a(g);
                break;

            case 614461378: 
                if (h == null)
                {
                    h = new dcq();
                }
                eui1.a(h);
                break;

            case 623158338: 
                if (i == null)
                {
                    i = new dns();
                }
                eui1.a(i);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!Arrays.equals(a, eup.f))
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            euj1.a(0x3120359, b);
        }
        if (c != null)
        {
            euj1.a(0x31a2ee9, c);
        }
        if (d != null)
        {
            euj1.a(0x31a2eed, d);
        }
        if (e != null)
        {
            euj1.a(0x39af697, e);
        }
        if (f != null)
        {
            euj1.a(0x3e68bff, f);
        }
        if (g != null)
        {
            euj1.a(0x4314c98, g);
        }
        if (h != null)
        {
            euj1.a(0x493fdf8, h);
        }
        if (i != null)
        {
            euj1.a(0x4a49488, i);
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
            if (!(obj instanceof diq))
            {
                return false;
            }
            obj = (diq)obj;
            if (Arrays.equals(a, ((diq) (obj)).a) && (b != null ? b.equals(((diq) (obj)).b) : ((diq) (obj)).b == null) && (c != null ? c.equals(((diq) (obj)).c) : ((diq) (obj)).c == null) && (d != null ? d.equals(((diq) (obj)).d) : ((diq) (obj)).d == null) && (e != null ? e.equals(((diq) (obj)).e) : ((diq) (obj)).e == null) && (f != null ? f.equals(((diq) (obj)).f) : ((diq) (obj)).f == null) && (g != null ? g.equals(((diq) (obj)).g) : ((diq) (obj)).g == null) && (h != null ? h.equals(((diq) (obj)).h) : ((diq) (obj)).h == null) && (i != null ? i.equals(((diq) (obj)).i) : ((diq) (obj)).i == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((diq) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((diq) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j;
        int k2;
        k2 = 0;
        j = getClass().getName().hashCode() + 527;
        if (a != null) goto _L2; else goto _L1
_L1:
        int k = j * 31;
_L4:
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
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
        if (O != null)
        {
            k2 = O.hashCode();
        }
        return (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l + (j + k * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k2;
_L2:
        l = 0;
_L5:
        k = j;
        if (l >= a.length) goto _L4; else goto _L3
_L3:
        j = j * 31 + a[l];
        l++;
          goto _L5
    }
}
