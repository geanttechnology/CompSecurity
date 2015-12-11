// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class edk extends eul
{

    public static final edk a[] = new edk[0];
    private int b;
    private edl c;
    private edj d;
    private edn e;
    private String f;
    private int g;
    private String h;

    public edk()
    {
        b = 0;
        c = null;
        d = null;
        e = null;
        f = "";
        g = 0;
        h = "";
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
        if (!f.equals(""))
        {
            j = i + euj.b(5, f);
        }
        i = j;
        if (g != 0)
        {
            i = j + euj.c(6, g);
        }
        j = i;
        if (!h.equals(""))
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
                if (j == 0 || j == 1 || j == 2 || j == 3)
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
                    c = new edl();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new edj();
                }
                eui1.a(d);
                break;

            case 34: // '"'
                if (e == null)
                {
                    e = new edn();
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
            if (!(obj instanceof edk))
            {
                return false;
            }
            obj = (edk)obj;
            if (b == ((edk) (obj)).b && (c != null ? c.equals(((edk) (obj)).c) : ((edk) (obj)).c == null) && (d != null ? d.equals(((edk) (obj)).d) : ((edk) (obj)).d == null) && (e != null ? e.equals(((edk) (obj)).e) : ((edk) (obj)).e == null) && (f != null ? f.equals(((edk) (obj)).f) : ((edk) (obj)).f == null) && g == ((edk) (obj)).g && (h != null ? h.equals(((edk) (obj)).h) : ((edk) (obj)).h == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((edk) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((edk) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j1 = 0;
        int k1 = getClass().getName().hashCode();
        int l1 = b;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int i2;
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
        i2 = g;
        if (h == null)
        {
            i1 = 0;
        } else
        {
            i1 = h.hashCode();
        }
        if (O != null)
        {
            j1 = O.hashCode();
        }
        return (i1 + ((l + (k + (j + (i + ((k1 + 527) * 31 + l1) * 31) * 31) * 31) * 31) * 31 + i2) * 31) * 31 + j1;
    }

}
