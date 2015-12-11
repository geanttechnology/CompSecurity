// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dqz extends eul
{

    public byte a[];
    private dlb b;
    private dlb c;
    private dzp d;
    private drb e;
    private String f;
    private boolean g;
    private dlb h;
    private dlb i;
    private boolean j;

    public dqz()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        a = eup.f;
        f = "";
        g = false;
        h = null;
        i = null;
        j = false;
    }

    public final int a()
    {
        int l = 0;
        if (b != null)
        {
            l = euj.b(1, b) + 0;
        }
        int k = l;
        if (c != null)
        {
            k = l + euj.b(2, c);
        }
        l = k;
        if (d != null)
        {
            l = k + euj.b(3, d);
        }
        k = l;
        if (e != null)
        {
            k = l + euj.b(5, e);
        }
        l = k;
        if (!Arrays.equals(a, eup.f))
        {
            l = k + euj.b(9, a);
        }
        k = l;
        if (!f.equals(""))
        {
            k = l + euj.b(10, f);
        }
        l = k;
        if (g)
        {
            boolean flag = g;
            l = k + (euj.b(11) + 1);
        }
        k = l;
        if (h != null)
        {
            k = l + euj.b(13, h);
        }
        l = k;
        if (i != null)
        {
            l = k + euj.b(14, i);
        }
        k = l;
        if (j)
        {
            boolean flag1 = j;
            k = l + (euj.b(15) + 1);
        }
        k += eup.a(O);
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

            case 10: // '\n'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dzp();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new drb();
                }
                eui1.a(e);
                break;

            case 74: // 'J'
                a = eui1.g();
                break;

            case 82: // 'R'
                f = eui1.f();
                break;

            case 88: // 'X'
                g = eui1.e();
                break;

            case 106: // 'j'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 114: // 'r'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 120: // 'x'
                j = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
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
            euj1.a(5, e);
        }
        if (!Arrays.equals(a, eup.f))
        {
            euj1.a(9, a);
        }
        if (!f.equals(""))
        {
            euj1.a(10, f);
        }
        if (g)
        {
            euj1.a(11, g);
        }
        if (h != null)
        {
            euj1.a(13, h);
        }
        if (i != null)
        {
            euj1.a(14, i);
        }
        if (j)
        {
            euj1.a(15, j);
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
            if (!(obj instanceof dqz))
            {
                return false;
            }
            obj = (dqz)obj;
            if ((b != null ? b.equals(((dqz) (obj)).b) : ((dqz) (obj)).b == null) && (c != null ? c.equals(((dqz) (obj)).c) : ((dqz) (obj)).c == null) && (d != null ? d.equals(((dqz) (obj)).d) : ((dqz) (obj)).d == null) && (e != null ? e.equals(((dqz) (obj)).e) : ((dqz) (obj)).e == null) && Arrays.equals(a, ((dqz) (obj)).a) && (f != null ? f.equals(((dqz) (obj)).f) : ((dqz) (obj)).f == null) && g == ((dqz) (obj)).g && (h != null ? h.equals(((dqz) (obj)).h) : ((dqz) (obj)).h == null) && (i != null ? i.equals(((dqz) (obj)).i) : ((dqz) (obj)).i == null) && j == ((dqz) (obj)).j)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dqz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dqz) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k;
        int l;
        int i1;
        int j1;
        int i2;
        int j2;
        i2 = 1;
        j2 = 0;
        int k1 = getClass().getName().hashCode();
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
        k = j1 + (i1 + (l + (k + (k1 + 527) * 31) * 31) * 31) * 31;
        if (a != null) goto _L2; else goto _L1
_L1:
        l = k * 31;
_L4:
        int l1;
        if (f == null)
        {
            k = 0;
        } else
        {
            k = f.hashCode();
        }
        if (g)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        if (h == null)
        {
            j1 = 0;
        } else
        {
            j1 = h.hashCode();
        }
        if (i == null)
        {
            l1 = 0;
        } else
        {
            l1 = i.hashCode();
        }
        if (!j)
        {
            i2 = 2;
        }
        if (O != null)
        {
            j2 = O.hashCode();
        }
        return ((l1 + (j1 + (i1 + (k + l * 31) * 31) * 31) * 31) * 31 + i2) * 31 + j2;
_L2:
        i1 = 0;
_L5:
        l = k;
        if (i1 >= a.length) goto _L4; else goto _L3
_L3:
        k = k * 31 + a[i1];
        i1++;
          goto _L5
    }
}
