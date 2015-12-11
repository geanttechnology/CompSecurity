// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dmg extends eul
{

    public static final dmg a[] = new dmg[0];
    public int b;
    public dmh c;
    private dmf d;
    private dmj e;
    private String f;
    private int g;
    private String h;
    private String i;

    public dmg()
    {
        b = 0;
        c = null;
        d = null;
        e = null;
        f = "";
        g = 0;
        h = "";
        i = "";
    }

    public final int a()
    {
        int k = 0;
        if (b != 0)
        {
            k = euj.c(1, b) + 0;
        }
        int j = k;
        if (c != null)
        {
            j = k + euj.b(2, c);
        }
        k = j;
        if (d != null)
        {
            k = j + euj.b(3, d);
        }
        j = k;
        if (e != null)
        {
            j = k + euj.b(4, e);
        }
        k = j;
        if (!f.equals(""))
        {
            k = j + euj.b(5, f);
        }
        j = k;
        if (g != 0)
        {
            j = k + euj.c(6, g);
        }
        k = j;
        if (!h.equals(""))
        {
            k = j + euj.b(7, h);
        }
        j = k;
        if (!i.equals(""))
        {
            j = k + euj.b(8, i);
        }
        j += eup.a(O);
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
                if (k == 0 || k == 1 || k == 2 || k == 3)
                {
                    b = k;
                } else
                {
                    b = 0;
                }
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dmh();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dmf();
                }
                eui1.a(d);
                break;

            case 34: // '"'
                if (e == null)
                {
                    e = new dmj();
                }
                eui1.a(e);
                break;

            case 42: // '*'
                f = eui1.f();
                break;

            case 48: // '0'
                g = eui1.d();
                break;

            case 58: // ':'
                h = eui1.f();
                break;

            case 66: // 'B'
                i = eui1.f();
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
        if (!f.equals(""))
        {
            euj1.a(5, f);
        }
        if (g != 0)
        {
            euj1.a(6, g);
        }
        if (!h.equals(""))
        {
            euj1.a(7, h);
        }
        if (!i.equals(""))
        {
            euj1.a(8, i);
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
            if (!(obj instanceof dmg))
            {
                return false;
            }
            obj = (dmg)obj;
            if (b == ((dmg) (obj)).b && (c != null ? c.equals(((dmg) (obj)).c) : ((dmg) (obj)).c == null) && (d != null ? d.equals(((dmg) (obj)).d) : ((dmg) (obj)).d == null) && (e != null ? e.equals(((dmg) (obj)).e) : ((dmg) (obj)).e == null) && (f != null ? f.equals(((dmg) (obj)).f) : ((dmg) (obj)).f == null) && g == ((dmg) (obj)).g && (h != null ? h.equals(((dmg) (obj)).h) : ((dmg) (obj)).h == null) && (i != null ? i.equals(((dmg) (obj)).i) : ((dmg) (obj)).i == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmg) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmg) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l1 = 0;
        int i2 = getClass().getName().hashCode();
        int j2 = b;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int k2;
        if (c == null)
        {
            j = 0;
        } else
        {
            j = c.hashCode();
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
        k2 = g;
        if (h == null)
        {
            j1 = 0;
        } else
        {
            j1 = h.hashCode();
        }
        if (i == null)
        {
            k1 = 0;
        } else
        {
            k1 = i.hashCode();
        }
        if (O != null)
        {
            l1 = O.hashCode();
        }
        return (k1 + (j1 + ((i1 + (l + (k + (j + ((i2 + 527) * 31 + j2) * 31) * 31) * 31) * 31) * 31 + k2) * 31) * 31) * 31 + l1;
    }

}
