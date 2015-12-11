// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dko extends eul
{

    private long a;
    private long b;
    private String c;
    private String d;
    private dre e;
    private dzp f;
    private dlb g;
    private byte h[];

    public dko()
    {
        a = 0L;
        b = 0L;
        c = "";
        d = "";
        e = null;
        f = null;
        g = null;
        h = eup.f;
    }

    public final int a()
    {
        int j = 0;
        if (a != 0L)
        {
            j = euj.d(1, a) + 0;
        }
        int i = j;
        if (b != 0L)
        {
            i = j + euj.d(2, b);
        }
        j = i;
        if (!c.equals(""))
        {
            j = i + euj.b(3, c);
        }
        i = j;
        if (!d.equals(""))
        {
            i = j + euj.b(4, d);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(5, e);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(6, f);
        }
        j = i;
        if (g != null)
        {
            j = i + euj.b(7, g);
        }
        i = j;
        if (!Arrays.equals(h, eup.f))
        {
            i = j + euj.b(9, h);
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

            case 8: // '\b'
                a = eui1.c();
                break;

            case 16: // '\020'
                b = eui1.c();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 34: // '"'
                d = eui1.f();
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dre();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new dzp();
                }
                eui1.a(f);
                break;

            case 58: // ':'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 74: // 'J'
                h = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != 0L)
        {
            euj1.b(1, a);
        }
        if (b != 0L)
        {
            euj1.b(2, b);
        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (!d.equals(""))
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f != null)
        {
            euj1.a(6, f);
        }
        if (g != null)
        {
            euj1.a(7, g);
        }
        if (!Arrays.equals(h, eup.f))
        {
            euj1.a(9, h);
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
            if (!(obj instanceof dko))
            {
                return false;
            }
            obj = (dko)obj;
            if (a == ((dko) (obj)).a && b == ((dko) (obj)).b && (c != null ? c.equals(((dko) (obj)).c) : ((dko) (obj)).c == null) && (d != null ? d.equals(((dko) (obj)).d) : ((dko) (obj)).d == null) && (e != null ? e.equals(((dko) (obj)).e) : ((dko) (obj)).e == null) && (f != null ? f.equals(((dko) (obj)).f) : ((dko) (obj)).f == null) && (g != null ? g.equals(((dko) (obj)).g) : ((dko) (obj)).g == null) && Arrays.equals(h, ((dko) (obj)).h))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dko) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dko) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        int j;
        boolean flag = false;
        int k1 = getClass().getName().hashCode();
        int l1 = (int)(a ^ a >>> 32);
        int i2 = (int)(b ^ b >>> 32);
        int k;
        int i1;
        int j1;
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
        i = j1 + (i1 + (k + (j + (i + (((k1 + 527) * 31 + l1) * 31 + i2) * 31) * 31) * 31) * 31) * 31;
        if (h != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        int l;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return j * 31 + i;
_L2:
        l = 0;
_L5:
        j = i;
        if (l >= h.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + h[l];
        l++;
          goto _L5
    }
}
