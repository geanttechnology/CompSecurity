// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dqb extends eul
{

    public static final dqb a[] = new dqb[0];
    private String b;
    private int c;
    private String d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private String l;
    private String m;
    private String n;

    public dqb()
    {
        b = "";
        c = 1;
        d = "";
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        j = false;
        k = false;
        l = "";
        m = "";
        n = "";
    }

    public final int a()
    {
        int j1 = 0;
        if (!b.equals(""))
        {
            j1 = euj.b(1, b) + 0;
        }
        int i1 = j1;
        if (c != 1)
        {
            i1 = j1 + euj.c(2, c);
        }
        j1 = i1;
        if (!d.equals(""))
        {
            j1 = i1 + euj.b(3, d);
        }
        i1 = j1;
        if (e != 0)
        {
            i1 = j1 + euj.c(4, e);
        }
        j1 = i1;
        if (f != 0)
        {
            j1 = i1 + euj.c(5, f);
        }
        i1 = j1;
        if (g != 0)
        {
            i1 = j1 + euj.c(6, g);
        }
        j1 = i1;
        if (h != 0)
        {
            j1 = i1 + euj.c(7, h);
        }
        i1 = j1;
        if (i != 0)
        {
            i1 = j1 + euj.c(8, i);
        }
        j1 = i1;
        if (j)
        {
            boolean flag = j;
            j1 = i1 + (euj.b(9) + 1);
        }
        i1 = j1;
        if (k)
        {
            boolean flag1 = k;
            i1 = j1 + (euj.b(10) + 1);
        }
        j1 = i1;
        if (!l.equals(""))
        {
            j1 = i1 + euj.b(11, l);
        }
        i1 = j1;
        if (!m.equals(""))
        {
            i1 = j1 + euj.b(12, m);
        }
        j1 = i1;
        if (!n.equals(""))
        {
            j1 = i1 + euj.b(13, n);
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

            case 10: // '\n'
                b = eui1.f();
                break;

            case 16: // '\020'
                int j1 = eui1.d();
                if (j1 == 1 || j1 == 2)
                {
                    c = j1;
                } else
                {
                    c = 1;
                }
                break;

            case 26: // '\032'
                d = eui1.f();
                break;

            case 32: // ' '
                e = eui1.d();
                break;

            case 40: // '('
                f = eui1.d();
                break;

            case 48: // '0'
                g = eui1.d();
                break;

            case 56: // '8'
                h = eui1.d();
                break;

            case 64: // '@'
                i = eui1.d();
                break;

            case 72: // 'H'
                j = eui1.e();
                break;

            case 80: // 'P'
                k = eui1.e();
                break;

            case 90: // 'Z'
                l = eui1.f();
                break;

            case 98: // 'b'
                m = eui1.f();
                break;

            case 106: // 'j'
                n = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!b.equals(""))
        {
            euj1.a(1, b);
        }
        if (c != 1)
        {
            euj1.a(2, c);
        }
        if (!d.equals(""))
        {
            euj1.a(3, d);
        }
        if (e != 0)
        {
            euj1.a(4, e);
        }
        if (f != 0)
        {
            euj1.a(5, f);
        }
        if (g != 0)
        {
            euj1.a(6, g);
        }
        if (h != 0)
        {
            euj1.a(7, h);
        }
        if (i != 0)
        {
            euj1.a(8, i);
        }
        if (j)
        {
            euj1.a(9, j);
        }
        if (k)
        {
            euj1.a(10, k);
        }
        if (!l.equals(""))
        {
            euj1.a(11, l);
        }
        if (!m.equals(""))
        {
            euj1.a(12, m);
        }
        if (!n.equals(""))
        {
            euj1.a(13, n);
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
            if (!(obj instanceof dqb))
            {
                return false;
            }
            obj = (dqb)obj;
            if ((b != null ? b.equals(((dqb) (obj)).b) : ((dqb) (obj)).b == null) && c == ((dqb) (obj)).c && (d != null ? d.equals(((dqb) (obj)).d) : ((dqb) (obj)).d == null) && (e == ((dqb) (obj)).e && f == ((dqb) (obj)).f && g == ((dqb) (obj)).g && h == ((dqb) (obj)).h && i == ((dqb) (obj)).i && j == ((dqb) (obj)).j && k == ((dqb) (obj)).k) && (l != null ? l.equals(((dqb) (obj)).l) : ((dqb) (obj)).l == null) && (m != null ? m.equals(((dqb) (obj)).m) : ((dqb) (obj)).m == null) && (n != null ? n.equals(((dqb) (obj)).n) : ((dqb) (obj)).n == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dqb) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dqb) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l1 = 1;
        int l2 = 0;
        int i3 = getClass().getName().hashCode();
        int i1;
        int j1;
        int k1;
        int i2;
        int j2;
        int k2;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        if (b == null)
        {
            i1 = 0;
        } else
        {
            i1 = b.hashCode();
        }
        j3 = c;
        if (d == null)
        {
            j1 = 0;
        } else
        {
            j1 = d.hashCode();
        }
        k3 = e;
        l3 = f;
        i4 = g;
        j4 = h;
        k4 = i;
        if (j)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (!k)
        {
            l1 = 2;
        }
        if (l == null)
        {
            i2 = 0;
        } else
        {
            i2 = l.hashCode();
        }
        if (m == null)
        {
            j2 = 0;
        } else
        {
            j2 = m.hashCode();
        }
        if (n == null)
        {
            k2 = 0;
        } else
        {
            k2 = n.hashCode();
        }
        if (O != null)
        {
            l2 = O.hashCode();
        }
        return (k2 + (j2 + (i2 + ((k1 + ((((((j1 + ((i1 + (i3 + 527) * 31) * 31 + j3) * 31) * 31 + k3) * 31 + l3) * 31 + i4) * 31 + j4) * 31 + k4) * 31) * 31 + l1) * 31) * 31) * 31) * 31 + l2;
    }

}
