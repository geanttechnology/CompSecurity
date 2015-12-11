// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dnl extends eul
{

    public dhf a;
    public eap b;
    public dvz c;
    public dgz d;
    public dhf e;
    public dcl f;
    private dgh g;
    private dzm h;
    private dkm i;

    public dnl()
    {
        a = null;
        b = null;
        g = null;
        c = null;
        d = null;
        h = null;
        e = null;
        f = null;
        i = null;
    }

    public final int a()
    {
        int k = 0;
        if (a != null)
        {
            k = euj.b(1, a) + 0;
        }
        int j = k;
        if (b != null)
        {
            j = k + euj.b(3, b);
        }
        k = j;
        if (g != null)
        {
            k = j + euj.b(4, g);
        }
        j = k;
        if (c != null)
        {
            j = k + euj.b(5, c);
        }
        k = j;
        if (d != null)
        {
            k = j + euj.b(6, d);
        }
        j = k;
        if (h != null)
        {
            j = k + euj.b(7, h);
        }
        k = j;
        if (e != null)
        {
            k = j + euj.b(8, e);
        }
        j = k;
        if (f != null)
        {
            j = k + euj.b(9, f);
        }
        k = j;
        if (i != null)
        {
            k = j + euj.b(10, i);
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
                if (a == null)
                {
                    a = new dhf();
                }
                eui1.a(a);
                break;

            case 26: // '\032'
                if (b == null)
                {
                    b = new eap();
                }
                eui1.a(b);
                break;

            case 34: // '"'
                if (g == null)
                {
                    g = new dgh();
                }
                eui1.a(g);
                break;

            case 42: // '*'
                if (c == null)
                {
                    c = new dvz();
                }
                eui1.a(c);
                break;

            case 50: // '2'
                if (d == null)
                {
                    d = new dgz();
                }
                eui1.a(d);
                break;

            case 58: // ':'
                if (h == null)
                {
                    h = new dzm();
                }
                eui1.a(h);
                break;

            case 66: // 'B'
                if (e == null)
                {
                    e = new dhf();
                }
                eui1.a(e);
                break;

            case 74: // 'J'
                if (f == null)
                {
                    f = new dcl();
                }
                eui1.a(f);
                break;

            case 82: // 'R'
                if (i == null)
                {
                    i = new dkm();
                }
                eui1.a(i);
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
            euj1.a(3, b);
        }
        if (g != null)
        {
            euj1.a(4, g);
        }
        if (c != null)
        {
            euj1.a(5, c);
        }
        if (d != null)
        {
            euj1.a(6, d);
        }
        if (h != null)
        {
            euj1.a(7, h);
        }
        if (e != null)
        {
            euj1.a(8, e);
        }
        if (f != null)
        {
            euj1.a(9, f);
        }
        if (i != null)
        {
            euj1.a(10, i);
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
            if (!(obj instanceof dnl))
            {
                return false;
            }
            obj = (dnl)obj;
            if ((a != null ? a.equals(((dnl) (obj)).a) : ((dnl) (obj)).a == null) && (b != null ? b.equals(((dnl) (obj)).b) : ((dnl) (obj)).b == null) && (g != null ? g.equals(((dnl) (obj)).g) : ((dnl) (obj)).g == null) && (c != null ? c.equals(((dnl) (obj)).c) : ((dnl) (obj)).c == null) && (d != null ? d.equals(((dnl) (obj)).d) : ((dnl) (obj)).d == null) && (h != null ? h.equals(((dnl) (obj)).h) : ((dnl) (obj)).h == null) && (e != null ? e.equals(((dnl) (obj)).e) : ((dnl) (obj)).e == null) && (f != null ? f.equals(((dnl) (obj)).f) : ((dnl) (obj)).f == null) && (i != null ? i.equals(((dnl) (obj)).i) : ((dnl) (obj)).i == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dnl) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dnl) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k2 = 0;
        int l2 = getClass().getName().hashCode();
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        if (a == null)
        {
            j = 0;
        } else
        {
            j = a.hashCode();
        }
        if (b == null)
        {
            k = 0;
        } else
        {
            k = b.hashCode();
        }
        if (g == null)
        {
            l = 0;
        } else
        {
            l = g.hashCode();
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
        if (h == null)
        {
            k1 = 0;
        } else
        {
            k1 = h.hashCode();
        }
        if (e == null)
        {
            l1 = 0;
        } else
        {
            l1 = e.hashCode();
        }
        if (f == null)
        {
            i2 = 0;
        } else
        {
            i2 = f.hashCode();
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
        return (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l + (k + (j + (l2 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k2;
    }
}
