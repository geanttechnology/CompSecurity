// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dgc extends eul
{

    private int a;
    private int b;
    private boolean c;
    private dlb d;
    private dxa e;
    private dmb f;
    private dre g;
    private dbk h;
    private String i;

    public dgc()
    {
        a = 0;
        b = 0;
        c = false;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = "";
    }

    public final int a()
    {
        int k = 0;
        if (a != 0)
        {
            k = euj.c(1, a) + 0;
        }
        int j = k;
        if (b != 0)
        {
            j = k + euj.c(2, b);
        }
        k = j;
        if (c)
        {
            boolean flag = c;
            k = j + (euj.b(3) + 1);
        }
        j = k;
        if (d != null)
        {
            j = k + euj.b(5, d);
        }
        k = j;
        if (e != null)
        {
            k = j + euj.b(7, e);
        }
        j = k;
        if (f != null)
        {
            j = k + euj.b(8, f);
        }
        k = j;
        if (g != null)
        {
            k = j + euj.b(9, g);
        }
        j = k;
        if (h != null)
        {
            j = k + euj.b(10, h);
        }
        k = j;
        if (!i.equals(""))
        {
            k = j + euj.b(11, i);
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

            case 8: // '\b'
                int k = eui1.d();
                if (k == 0 || k == 1 || k == 2 || k == 3 || k == 4 || k == 5 || k == 6 || k == 7)
                {
                    a = k;
                } else
                {
                    a = 0;
                }
                break;

            case 16: // '\020'
                int l = eui1.d();
                if (l == 0 || l == 1 || l == 2 || l == 3 || l == 4)
                {
                    b = l;
                } else
                {
                    b = 0;
                }
                break;

            case 24: // '\030'
                c = eui1.e();
                break;

            case 42: // '*'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 58: // ':'
                if (e == null)
                {
                    e = new dxa();
                }
                eui1.a(e);
                break;

            case 66: // 'B'
                if (f == null)
                {
                    f = new dmb();
                }
                eui1.a(f);
                break;

            case 74: // 'J'
                if (g == null)
                {
                    g = new dre();
                }
                eui1.a(g);
                break;

            case 82: // 'R'
                if (h == null)
                {
                    h = new dbk();
                }
                eui1.a(h);
                break;

            case 90: // 'Z'
                i = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != 0)
        {
            euj1.a(1, a);
        }
        if (b != 0)
        {
            euj1.a(2, b);
        }
        if (c)
        {
            euj1.a(3, c);
        }
        if (d != null)
        {
            euj1.a(5, d);
        }
        if (e != null)
        {
            euj1.a(7, e);
        }
        if (f != null)
        {
            euj1.a(8, f);
        }
        if (g != null)
        {
            euj1.a(9, g);
        }
        if (h != null)
        {
            euj1.a(10, h);
        }
        if (!i.equals(""))
        {
            euj1.a(11, i);
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
            if (!(obj instanceof dgc))
            {
                return false;
            }
            obj = (dgc)obj;
            if (a == ((dgc) (obj)).a && b == ((dgc) (obj)).b && c == ((dgc) (obj)).c && (d != null ? d.equals(((dgc) (obj)).d) : ((dgc) (obj)).d == null) && (e != null ? e.equals(((dgc) (obj)).e) : ((dgc) (obj)).e == null) && (f != null ? f.equals(((dgc) (obj)).f) : ((dgc) (obj)).f == null) && (g != null ? g.equals(((dgc) (obj)).g) : ((dgc) (obj)).g == null) && (h != null ? h.equals(((dgc) (obj)).h) : ((dgc) (obj)).h == null) && (i != null ? i.equals(((dgc) (obj)).i) : ((dgc) (obj)).i == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dgc) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dgc) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i2 = 0;
        int j2 = getClass().getName().hashCode();
        int k2 = a;
        int l2 = b;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        if (c)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        if (e == null)
        {
            l = 0;
        } else
        {
            l = e.hashCode();
        }
        if (f == null)
        {
            i1 = 0;
        } else
        {
            i1 = f.hashCode();
        }
        if (g == null)
        {
            j1 = 0;
        } else
        {
            j1 = g.hashCode();
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
        if (O != null)
        {
            i2 = O.hashCode();
        }
        return (l1 + (k1 + (j1 + (i1 + (l + (k + (j + (((j2 + 527) * 31 + k2) * 31 + l2) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
    }
}
