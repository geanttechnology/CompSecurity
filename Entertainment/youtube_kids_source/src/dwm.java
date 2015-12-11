// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dwm extends eul
{

    public dnl a;
    public String b;
    public String c;
    public String d;
    public dkv e;
    public dub f;
    private int g;
    private dkz h;

    public dwm()
    {
        a = null;
        b = "";
        c = "";
        g = 0;
        d = "";
        e = null;
        f = null;
        h = null;
    }

    public final int a()
    {
        int j = 0;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (!b.equals(""))
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (!c.equals(""))
        {
            j = i + euj.b(3, c);
        }
        i = j;
        if (g != 0)
        {
            i = j + euj.c(4, g);
        }
        j = i;
        if (!d.equals(""))
        {
            j = i + euj.b(8, d);
        }
        i = j;
        if (e != null)
        {
            i = j + euj.b(11, e);
        }
        j = i;
        if (f != null)
        {
            j = i + euj.b(12, f);
        }
        i = j;
        if (h != null)
        {
            i = j + euj.b(13, h);
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
                    a = new dnl();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 32: // ' '
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2 || j == 3)
                {
                    g = j;
                } else
                {
                    g = 0;
                }
                break;

            case 66: // 'B'
                d = eui1.f();
                break;

            case 90: // 'Z'
                if (e == null)
                {
                    e = new dkv();
                }
                eui1.a(e);
                break;

            case 98: // 'b'
                if (f == null)
                {
                    f = new dub();
                }
                eui1.a(f);
                break;

            case 106: // 'j'
                if (h == null)
                {
                    h = new dkz();
                }
                eui1.a(h);
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
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (g != 0)
        {
            euj1.a(4, g);
        }
        if (!d.equals(""))
        {
            euj1.a(8, d);
        }
        if (e != null)
        {
            euj1.a(11, e);
        }
        if (f != null)
        {
            euj1.a(12, f);
        }
        if (h != null)
        {
            euj1.a(13, h);
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
            if (!(obj instanceof dwm))
            {
                return false;
            }
            obj = (dwm)obj;
            if ((a != null ? a.equals(((dwm) (obj)).a) : ((dwm) (obj)).a == null) && (b != null ? b.equals(((dwm) (obj)).b) : ((dwm) (obj)).b == null) && (c != null ? c.equals(((dwm) (obj)).c) : ((dwm) (obj)).c == null) && g == ((dwm) (obj)).g && (d != null ? d.equals(((dwm) (obj)).d) : ((dwm) (obj)).d == null) && (e != null ? e.equals(((dwm) (obj)).e) : ((dwm) (obj)).e == null) && (f != null ? f.equals(((dwm) (obj)).f) : ((dwm) (obj)).f == null) && (h != null ? h.equals(((dwm) (obj)).h) : ((dwm) (obj)).h == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dwm) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dwm) (obj)).O))
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
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int j2;
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
        j2 = g;
        if (d == null)
        {
            l = 0;
        } else
        {
            l = d.hashCode();
        }
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        if (f == null)
        {
            j1 = 0;
        } else
        {
            j1 = f.hashCode();
        }
        if (h == null)
        {
            k1 = 0;
        } else
        {
            k1 = h.hashCode();
        }
        if (O != null)
        {
            l1 = O.hashCode();
        }
        return (k1 + (j1 + (i1 + (l + ((k + (j + (i + (i2 + 527) * 31) * 31) * 31) * 31 + j2) * 31) * 31) * 31) * 31) * 31 + l1;
    }
}
