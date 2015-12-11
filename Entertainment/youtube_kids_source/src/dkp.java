// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dkp extends eul
{

    private long a;
    private long b;
    private String c;
    private dzp d;
    private String e;
    private dre f;
    private dlb g;
    private dlb h;
    private dlb i;
    private dtk j;
    private byte k[];

    public dkp()
    {
        a = 0L;
        b = 0L;
        c = "";
        d = null;
        e = "";
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = eup.f;
    }

    public final int a()
    {
        int i1 = 0;
        if (a != 0L)
        {
            i1 = euj.d(1, a) + 0;
        }
        int l = i1;
        if (b != 0L)
        {
            l = i1 + euj.d(2, b);
        }
        i1 = l;
        if (!c.equals(""))
        {
            i1 = l + euj.b(3, c);
        }
        l = i1;
        if (d != null)
        {
            l = i1 + euj.b(4, d);
        }
        i1 = l;
        if (!e.equals(""))
        {
            i1 = l + euj.b(5, e);
        }
        l = i1;
        if (f != null)
        {
            l = i1 + euj.b(6, f);
        }
        i1 = l;
        if (g != null)
        {
            i1 = l + euj.b(7, g);
        }
        l = i1;
        if (h != null)
        {
            l = i1 + euj.b(8, h);
        }
        i1 = l;
        if (i != null)
        {
            i1 = l + euj.b(9, i);
        }
        l = i1;
        if (j != null)
        {
            l = i1 + euj.b(10, j);
        }
        i1 = l;
        if (!Arrays.equals(k, eup.f))
        {
            i1 = l + euj.b(12, k);
        }
        l = i1 + eup.a(O);
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
                if (d == null)
                {
                    d = new dzp();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                e = eui1.f();
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new dre();
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

            case 66: // 'B'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 74: // 'J'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 82: // 'R'
                if (j == null)
                {
                    j = new dtk();
                }
                eui1.a(j);
                break;

            case 98: // 'b'
                k = eui1.g();
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
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (!e.equals(""))
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
        if (h != null)
        {
            euj1.a(8, h);
        }
        if (i != null)
        {
            euj1.a(9, i);
        }
        if (j != null)
        {
            euj1.a(10, j);
        }
        if (!Arrays.equals(k, eup.f))
        {
            euj1.a(12, k);
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
            if (!(obj instanceof dkp))
            {
                return false;
            }
            obj = (dkp)obj;
            if (a == ((dkp) (obj)).a && b == ((dkp) (obj)).b && (c != null ? c.equals(((dkp) (obj)).c) : ((dkp) (obj)).c == null) && (d != null ? d.equals(((dkp) (obj)).d) : ((dkp) (obj)).d == null) && (e != null ? e.equals(((dkp) (obj)).e) : ((dkp) (obj)).e == null) && (f != null ? f.equals(((dkp) (obj)).f) : ((dkp) (obj)).f == null) && (g != null ? g.equals(((dkp) (obj)).g) : ((dkp) (obj)).g == null) && (h != null ? h.equals(((dkp) (obj)).h) : ((dkp) (obj)).h == null) && (i != null ? i.equals(((dkp) (obj)).i) : ((dkp) (obj)).i == null) && (j != null ? j.equals(((dkp) (obj)).j) : ((dkp) (obj)).j == null) && Arrays.equals(k, ((dkp) (obj)).k))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dkp) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dkp) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l;
        int i1;
        boolean flag = false;
        int i3 = getClass().getName().hashCode();
        int j3 = (int)(a ^ a >>> 32);
        int k3 = (int)(b ^ b >>> 32);
        int j1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
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
            l1 = 0;
        } else
        {
            l1 = f.hashCode();
        }
        if (g == null)
        {
            i2 = 0;
        } else
        {
            i2 = g.hashCode();
        }
        if (h == null)
        {
            j2 = 0;
        } else
        {
            j2 = h.hashCode();
        }
        if (i == null)
        {
            k2 = 0;
        } else
        {
            k2 = i.hashCode();
        }
        if (j == null)
        {
            l2 = 0;
        } else
        {
            l2 = j.hashCode();
        }
        l = l2 + (k2 + (j2 + (i2 + (l1 + (j1 + (i1 + (l + (((i3 + 527) * 31 + j3) * 31 + k3) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (k != null) goto _L2; else goto _L1
_L1:
        i1 = l * 31;
_L4:
        int k1;
        if (O == null)
        {
            l = ((flag) ? 1 : 0);
        } else
        {
            l = O.hashCode();
        }
        return i1 * 31 + l;
_L2:
        k1 = 0;
_L5:
        i1 = l;
        if (k1 >= k.length) goto _L4; else goto _L3
_L3:
        l = l * 31 + k[k1];
        k1++;
          goto _L5
    }
}
