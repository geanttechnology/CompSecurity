// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dsz extends eul
{

    public int a;
    public String b;
    public dsy c;
    public dfp d;
    private String e[];
    private boolean f;
    private boolean g;
    private dfk h;
    private drx i;
    private boolean j;
    private dsh k;
    private int l;
    private boolean m;

    public dsz()
    {
        a = 0;
        b = "";
        e = eup.d;
        f = false;
        g = false;
        h = null;
        i = null;
        c = null;
        j = false;
        k = null;
        d = null;
        l = 0;
        m = false;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        if (a != 0)
        {
            j1 = euj.c(1, a) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (!b.equals(""))
        {
            i1 = j1 + euj.b(2, b);
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1;
            if (e.length > 0)
            {
                String as[] = e;
                int l1 = as.length;
                int k1 = 0;
                for (j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
                {
                    k1 += euj.a(as[j1]);
                }

                j1 = i1 + k1 + e.length * 1;
            }
        }
        i1 = j1;
        if (f)
        {
            boolean flag1 = f;
            i1 = j1 + (euj.b(4) + 1);
        }
        j1 = i1;
        if (g)
        {
            boolean flag2 = g;
            j1 = i1 + (euj.b(5) + 1);
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1 + euj.b(6, h);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1 + euj.b(7, i);
        }
        i1 = j1;
        if (c != null)
        {
            i1 = j1 + euj.b(8, c);
        }
        j1 = i1;
        if (j)
        {
            boolean flag3 = j;
            j1 = i1 + (euj.b(9) + 1);
        }
        i1 = j1;
        if (k != null)
        {
            i1 = j1 + euj.b(10, k);
        }
        j1 = i1;
        if (d != null)
        {
            j1 = i1 + euj.b(11, d);
        }
        i1 = j1;
        if (l != 0)
        {
            i1 = j1 + euj.c(12, l);
        }
        j1 = i1;
        if (m)
        {
            boolean flag4 = m;
            j1 = i1 + (euj.b(14) + 1);
        }
        i1 = j1 + eup.a(O);
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

            case 8: // '\b'
                int j1 = eui1.d();
                if (j1 == 0 || j1 == 1 || j1 == 2 || j1 == 3 || j1 == 4 || j1 == 5)
                {
                    a = j1;
                } else
                {
                    a = 0;
                }
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 26: // '\032'
                int l1 = eup.a(eui1, 26);
                int k1 = e.length;
                String as[] = new String[l1 + k1];
                System.arraycopy(e, 0, as, 0, k1);
                for (e = as; k1 < e.length - 1; k1++)
                {
                    e[k1] = eui1.f();
                    eui1.a();
                }

                e[k1] = eui1.f();
                break;

            case 32: // ' '
                f = eui1.e();
                break;

            case 40: // '('
                g = eui1.e();
                break;

            case 50: // '2'
                if (h == null)
                {
                    h = new dfk();
                }
                eui1.a(h);
                break;

            case 58: // ':'
                if (i == null)
                {
                    i = new drx();
                }
                eui1.a(i);
                break;

            case 66: // 'B'
                if (c == null)
                {
                    c = new dsy();
                }
                eui1.a(c);
                break;

            case 72: // 'H'
                j = eui1.e();
                break;

            case 82: // 'R'
                if (k == null)
                {
                    k = new dsh();
                }
                eui1.a(k);
                break;

            case 90: // 'Z'
                if (d == null)
                {
                    d = new dfp();
                }
                eui1.a(d);
                break;

            case 96: // '`'
                l = eui1.d();
                break;

            case 112: // 'p'
                m = eui1.e();
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
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (e != null)
        {
            String as[] = e;
            int j1 = as.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                euj1.a(3, as[i1]);
            }

        }
        if (f)
        {
            euj1.a(4, f);
        }
        if (g)
        {
            euj1.a(5, g);
        }
        if (h != null)
        {
            euj1.a(6, h);
        }
        if (i != null)
        {
            euj1.a(7, i);
        }
        if (c != null)
        {
            euj1.a(8, c);
        }
        if (j)
        {
            euj1.a(9, j);
        }
        if (k != null)
        {
            euj1.a(10, k);
        }
        if (d != null)
        {
            euj1.a(11, d);
        }
        if (l != 0)
        {
            euj1.a(12, l);
        }
        if (m)
        {
            euj1.a(14, m);
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
            if (!(obj instanceof dsz))
            {
                return false;
            }
            obj = (dsz)obj;
            if (a == ((dsz) (obj)).a && (b != null ? b.equals(((dsz) (obj)).b) : ((dsz) (obj)).b == null) && (Arrays.equals(e, ((dsz) (obj)).e) && f == ((dsz) (obj)).f && g == ((dsz) (obj)).g) && (h != null ? h.equals(((dsz) (obj)).h) : ((dsz) (obj)).h == null) && (i != null ? i.equals(((dsz) (obj)).i) : ((dsz) (obj)).i == null) && (c != null ? c.equals(((dsz) (obj)).c) : ((dsz) (obj)).c == null) && j == ((dsz) (obj)).j && (k != null ? k.equals(((dsz) (obj)).k) : ((dsz) (obj)).k == null) && (d != null ? d.equals(((dsz) (obj)).d) : ((dsz) (obj)).d == null) && (l == ((dsz) (obj)).l && m == ((dsz) (obj)).m))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dsz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dsz) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i1;
        int j1;
        int k3;
        int l3;
        k3 = 1;
        l3 = 0;
        j1 = getClass().getName().hashCode();
        int k1 = a;
        int i4;
        if (b == null)
        {
            i1 = 0;
        } else
        {
            i1 = b.hashCode();
        }
        i1 += ((j1 + 527) * 31 + k1) * 31;
        if (e != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L4:
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        if (f)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        if (g)
        {
            l1 = 1;
        } else
        {
            l1 = 2;
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
        if (c == null)
        {
            k2 = 0;
        } else
        {
            k2 = c.hashCode();
        }
        if (j)
        {
            l2 = 1;
        } else
        {
            l2 = 2;
        }
        if (k == null)
        {
            i3 = 0;
        } else
        {
            i3 = k.hashCode();
        }
        if (d == null)
        {
            j3 = 0;
        } else
        {
            j3 = d.hashCode();
        }
        i4 = l;
        if (!m)
        {
            k3 = 2;
        }
        if (O != null)
        {
            l3 = O.hashCode();
        }
        return (((j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4) * 31 + k3) * 31 + l3;
_L2:
        l1 = 0;
_L5:
        j1 = i1;
        if (l1 >= e.length) goto _L4; else goto _L3
_L3:
        if (e[l1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = e[l1].hashCode();
        }
        i1 = j1 + i1 * 31;
        l1++;
          goto _L5
    }
}
