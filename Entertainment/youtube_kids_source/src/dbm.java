// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dbm extends eul
{

    private byte a[];
    private String b;
    private dlb c;
    private dbl d;
    private dzp e;
    private boolean f;
    private boolean g;
    private dzp h;
    private boolean i;
    private String j;
    private dxa k;
    private dlb l;

    public dbm()
    {
        a = eup.f;
        b = "";
        c = null;
        d = null;
        e = null;
        f = false;
        g = false;
        h = null;
        i = false;
        j = "";
        k = null;
        l = null;
    }

    public final int a()
    {
        int j1 = 0;
        if (!Arrays.equals(a, eup.f))
        {
            j1 = euj.b(2, a) + 0;
        }
        int i1 = j1;
        if (!b.equals(""))
        {
            i1 = j1 + euj.b(3, b);
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1 + euj.b(4, c);
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1 + euj.b(5, d);
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1 + euj.b(6, e);
        }
        i1 = j1;
        if (f)
        {
            boolean flag = f;
            i1 = j1 + (euj.b(7) + 1);
        }
        j1 = i1;
        if (g)
        {
            boolean flag1 = g;
            j1 = i1 + (euj.b(8) + 1);
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1 + euj.b(9, h);
        }
        j1 = i1;
        if (i)
        {
            boolean flag2 = i;
            j1 = i1 + (euj.b(10) + 1);
        }
        i1 = j1;
        if (!j.equals(""))
        {
            i1 = j1 + euj.b(11, j);
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1 + euj.b(12, k);
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1 + euj.b(13, l);
        }
        i1 += eup.a(O);
        P = i1;
        return i1;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int i1 = eui1.a();
            switch (i1)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 18: // '\022'
                a = eui1.g();
                break;

            case 26: // '\032'
                b = eui1.f();
                break;

            case 34: // '"'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 42: // '*'
                if (d == null)
                {
                    d = new dbl();
                }
                eui1.a(d);
                break;

            case 50: // '2'
                if (e == null)
                {
                    e = new dzp();
                }
                eui1.a(e);
                break;

            case 56: // '8'
                f = eui1.e();
                break;

            case 64: // '@'
                g = eui1.e();
                break;

            case 74: // 'J'
                if (h == null)
                {
                    h = new dzp();
                }
                eui1.a(h);
                break;

            case 80: // 'P'
                i = eui1.e();
                break;

            case 90: // 'Z'
                j = eui1.f();
                break;

            case 98: // 'b'
                if (k == null)
                {
                    k = new dxa();
                }
                eui1.a(k);
                break;

            case 106: // 'j'
                if (l == null)
                {
                    l = new dlb();
                }
                eui1.a(l);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!Arrays.equals(a, eup.f))
        {
            euj1.a(2, a);
        }
        if (!b.equals(""))
        {
            euj1.a(3, b);
        }
        if (c != null)
        {
            euj1.a(4, c);
        }
        if (d != null)
        {
            euj1.a(5, d);
        }
        if (e != null)
        {
            euj1.a(6, e);
        }
        if (f)
        {
            euj1.a(7, f);
        }
        if (g)
        {
            euj1.a(8, g);
        }
        if (h != null)
        {
            euj1.a(9, h);
        }
        if (i)
        {
            euj1.a(10, i);
        }
        if (!j.equals(""))
        {
            euj1.a(11, j);
        }
        if (k != null)
        {
            euj1.a(12, k);
        }
        if (l != null)
        {
            euj1.a(13, l);
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
            if (!(obj instanceof dbm))
            {
                return false;
            }
            obj = (dbm)obj;
            if (Arrays.equals(a, ((dbm) (obj)).a) && (b != null ? b.equals(((dbm) (obj)).b) : ((dbm) (obj)).b == null) && (c != null ? c.equals(((dbm) (obj)).c) : ((dbm) (obj)).c == null) && (d != null ? d.equals(((dbm) (obj)).d) : ((dbm) (obj)).d == null) && (e != null ? e.equals(((dbm) (obj)).e) : ((dbm) (obj)).e == null) && (f == ((dbm) (obj)).f && g == ((dbm) (obj)).g) && (h != null ? h.equals(((dbm) (obj)).h) : ((dbm) (obj)).h == null) && i == ((dbm) (obj)).i && (j != null ? j.equals(((dbm) (obj)).j) : ((dbm) (obj)).j == null) && (k != null ? k.equals(((dbm) (obj)).k) : ((dbm) (obj)).k == null) && (l != null ? l.equals(((dbm) (obj)).l) : ((dbm) (obj)).l == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dbm) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dbm) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i1;
        int i3;
        int i4;
        i3 = 1;
        i4 = 0;
        i1 = getClass().getName().hashCode() + 527;
        if (a != null) goto _L2; else goto _L1
_L1:
        int j1 = i1 * 31;
_L4:
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int j3;
        int k3;
        int l3;
        if (b == null)
        {
            i1 = 0;
        } else
        {
            i1 = b.hashCode();
        }
        if (c == null)
        {
            k1 = 0;
        } else
        {
            k1 = c.hashCode();
        }
        if (d == null)
        {
            l1 = 0;
        } else
        {
            l1 = d.hashCode();
        }
        if (e == null)
        {
            i2 = 0;
        } else
        {
            i2 = e.hashCode();
        }
        if (f)
        {
            j2 = 1;
        } else
        {
            j2 = 2;
        }
        if (g)
        {
            k2 = 1;
        } else
        {
            k2 = 2;
        }
        if (h == null)
        {
            l2 = 0;
        } else
        {
            l2 = h.hashCode();
        }
        if (!i)
        {
            i3 = 2;
        }
        if (j == null)
        {
            j3 = 0;
        } else
        {
            j3 = j.hashCode();
        }
        if (k == null)
        {
            k3 = 0;
        } else
        {
            k3 = k.hashCode();
        }
        if (l == null)
        {
            l3 = 0;
        } else
        {
            l3 = l.hashCode();
        }
        if (O != null)
        {
            i4 = O.hashCode();
        }
        return (l3 + (k3 + (j3 + ((l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3) * 31) * 31) * 31) * 31 + i4;
_L2:
        k1 = 0;
_L5:
        j1 = i1;
        if (k1 >= a.length) goto _L4; else goto _L3
_L3:
        i1 = i1 * 31 + a[k1];
        k1++;
          goto _L5
    }
}
