// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dti extends eul
{

    public dzw a;
    public dzw b;
    public dzw c;
    public dzw d;
    public dzw e;
    public dzw f;
    public boolean g;
    public dzw h;
    private dzw i;
    private dzw j;
    private dzw k;
    private dzw l;
    private dzw m[];
    private dzw n;
    private dpd o;

    public dti()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        i = null;
        j = null;
        k = null;
        g = false;
        l = null;
        m = dzw.a;
        h = null;
        n = null;
        o = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (a != null)
        {
            j1 = euj.b(1, a) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (b != null)
        {
            i1 = j1 + euj.b(2, b);
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1 + euj.b(3, c);
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1 + euj.b(4, d);
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1 + euj.b(5, e);
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(6, f);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1 + euj.b(7, i);
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1 + euj.b(8, j);
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1 + euj.b(9, k);
        }
        k1 = j1;
        if (g)
        {
            boolean flag1 = g;
            k1 = j1 + (euj.b(10) + 1);
        }
        i1 = k1;
        if (l != null)
        {
            i1 = k1 + euj.b(11, l);
        }
        j1 = i1;
        if (m != null)
        {
            dzw adzw[] = m;
            int i2 = adzw.length;
            int l1 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (l1 >= i2)
                {
                    break;
                }
                dzw dzw1 = adzw[l1];
                j1 = i1;
                if (dzw1 != null)
                {
                    j1 = i1 + euj.b(12, dzw1);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1 + euj.b(13, h);
        }
        j1 = i1;
        if (n != null)
        {
            j1 = i1 + euj.b(14, n);
        }
        i1 = j1;
        if (o != null)
        {
            i1 = j1 + euj.b(15, o);
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

            case 10: // '\n'
                if (a == null)
                {
                    a = new dzw();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dzw();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dzw();
                }
                eui1.a(c);
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dzw();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dzw();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new dzw();
                }
                eui1.a(f);
                break;

            case 58: // ':'
                if (i == null)
                {
                    i = new dzw();
                }
                eui1.a(i);
                break;

            case 66: // 'B'
                if (j == null)
                {
                    j = new dzw();
                }
                eui1.a(j);
                break;

            case 74: // 'J'
                if (k == null)
                {
                    k = new dzw();
                }
                eui1.a(k);
                break;

            case 80: // 'P'
                g = eui1.e();
                break;

            case 90: // 'Z'
                if (l == null)
                {
                    l = new dzw();
                }
                eui1.a(l);
                break;

            case 98: // 'b'
                int k1 = eup.a(eui1, 98);
                dzw adzw[];
                int j1;
                if (m == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = m.length;
                }
                adzw = new dzw[k1 + j1];
                if (m != null)
                {
                    System.arraycopy(m, 0, adzw, 0, j1);
                }
                for (m = adzw; j1 < m.length - 1; j1++)
                {
                    m[j1] = new dzw();
                    eui1.a(m[j1]);
                    eui1.a();
                }

                m[j1] = new dzw();
                eui1.a(m[j1]);
                break;

            case 106: // 'j'
                if (h == null)
                {
                    h = new dzw();
                }
                eui1.a(h);
                break;

            case 114: // 'r'
                if (n == null)
                {
                    n = new dzw();
                }
                eui1.a(n);
                break;

            case 122: // 'z'
                if (o == null)
                {
                    o = new dpd();
                }
                eui1.a(o);
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
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            euj1.a(3, c);
        }
        if (d != null)
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
        if (i != null)
        {
            euj1.a(7, i);
        }
        if (j != null)
        {
            euj1.a(8, j);
        }
        if (k != null)
        {
            euj1.a(9, k);
        }
        if (g)
        {
            euj1.a(10, g);
        }
        if (l != null)
        {
            euj1.a(11, l);
        }
        if (m != null)
        {
            dzw adzw[] = m;
            int j1 = adzw.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                dzw dzw1 = adzw[i1];
                if (dzw1 != null)
                {
                    euj1.a(12, dzw1);
                }
            }

        }
        if (h != null)
        {
            euj1.a(13, h);
        }
        if (n != null)
        {
            euj1.a(14, n);
        }
        if (o != null)
        {
            euj1.a(15, o);
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
            if (!(obj instanceof dti))
            {
                return false;
            }
            obj = (dti)obj;
            if ((a != null ? a.equals(((dti) (obj)).a) : ((dti) (obj)).a == null) && (b != null ? b.equals(((dti) (obj)).b) : ((dti) (obj)).b == null) && (c != null ? c.equals(((dti) (obj)).c) : ((dti) (obj)).c == null) && (d != null ? d.equals(((dti) (obj)).d) : ((dti) (obj)).d == null) && (e != null ? e.equals(((dti) (obj)).e) : ((dti) (obj)).e == null) && (f != null ? f.equals(((dti) (obj)).f) : ((dti) (obj)).f == null) && (i != null ? i.equals(((dti) (obj)).i) : ((dti) (obj)).i == null) && (j != null ? j.equals(((dti) (obj)).j) : ((dti) (obj)).j == null) && (k != null ? k.equals(((dti) (obj)).k) : ((dti) (obj)).k == null) && g == ((dti) (obj)).g && (l != null ? l.equals(((dti) (obj)).l) : ((dti) (obj)).l == null) && Arrays.equals(m, ((dti) (obj)).m) && (h != null ? h.equals(((dti) (obj)).h) : ((dti) (obj)).h == null) && (n != null ? n.equals(((dti) (obj)).n) : ((dti) (obj)).n == null) && (o != null ? o.equals(((dti) (obj)).o) : ((dti) (obj)).o == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dti) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dti) (obj)).O))
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
        int k1;
        int l1;
        int i2;
        boolean flag = false;
        int l3 = getClass().getName().hashCode();
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        if (a == null)
        {
            i1 = 0;
        } else
        {
            i1 = a.hashCode();
        }
        if (b == null)
        {
            j1 = 0;
        } else
        {
            j1 = b.hashCode();
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
        if (f == null)
        {
            j2 = 0;
        } else
        {
            j2 = f.hashCode();
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
        if (k == null)
        {
            i3 = 0;
        } else
        {
            i3 = k.hashCode();
        }
        if (g)
        {
            j3 = 1;
        } else
        {
            j3 = 2;
        }
        if (l == null)
        {
            k3 = 0;
        } else
        {
            k3 = l.hashCode();
        }
        i1 = k3 + (j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (m != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L4:
        if (h == null)
        {
            i1 = 0;
        } else
        {
            i1 = h.hashCode();
        }
        if (n == null)
        {
            k1 = 0;
        } else
        {
            k1 = n.hashCode();
        }
        if (o == null)
        {
            l1 = 0;
        } else
        {
            l1 = o.hashCode();
        }
        if (O == null)
        {
            i2 = ((flag) ? 1 : 0);
        } else
        {
            i2 = O.hashCode();
        }
        return (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31 + i2;
_L2:
        k1 = 0;
_L5:
        j1 = i1;
        if (k1 >= m.length) goto _L4; else goto _L3
_L3:
        if (m[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = m[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L5
    }
}
