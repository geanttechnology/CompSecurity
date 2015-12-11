// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dnm extends eul
{

    private boolean a;
    private String b;
    private String c;
    private boolean d;
    private long e[];
    private long f[];
    private long g[];
    private long h[];
    private long i[];
    private long j[];
    private long k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;

    public dnm()
    {
        a = false;
        b = "";
        c = "";
        d = false;
        e = eup.b;
        f = eup.b;
        g = eup.b;
        h = eup.b;
        i = eup.b;
        j = eup.b;
        k = 0L;
        l = 0;
        m = false;
        n = false;
        o = false;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        if (a)
        {
            boolean flag1 = a;
            j1 = euj.b(1) + 1 + 0;
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
        if (!c.equals(""))
        {
            j1 = i1 + euj.b(3, c);
        }
        i1 = j1;
        if (d)
        {
            boolean flag2 = d;
            i1 = j1 + (euj.b(4) + 1);
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1;
            if (e.length > 0)
            {
                long al[] = e;
                int i3 = al.length;
                j1 = 0;
                int k1 = 0;
                for (; j1 < i3; j1++)
                {
                    k1 += euj.a(al[j1]);
                }

                j1 = i1 + k1 + e.length * 1;
            }
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1;
            if (f.length > 0)
            {
                long al1[] = f;
                int j3 = al1.length;
                i1 = 0;
                int l1 = 0;
                for (; i1 < j3; i1++)
                {
                    l1 += euj.a(al1[i1]);
                }

                i1 = j1 + l1 + f.length * 1;
            }
        }
        j1 = i1;
        if (g != null)
        {
            j1 = i1;
            if (g.length > 0)
            {
                long al2[] = g;
                int k3 = al2.length;
                j1 = 0;
                int i2 = 0;
                for (; j1 < k3; j1++)
                {
                    i2 += euj.a(al2[j1]);
                }

                j1 = i1 + i2 + g.length * 1;
            }
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1;
            if (h.length > 0)
            {
                long al3[] = h;
                int l3 = al3.length;
                i1 = 0;
                int j2 = 0;
                for (; i1 < l3; i1++)
                {
                    j2 += euj.a(al3[i1]);
                }

                i1 = j1 + j2 + h.length * 1;
            }
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1;
            if (i.length > 0)
            {
                long al4[] = i;
                int i4 = al4.length;
                j1 = 0;
                int k2 = 0;
                for (; j1 < i4; j1++)
                {
                    k2 += euj.a(al4[j1]);
                }

                j1 = i1 + k2 + i.length * 1;
            }
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1;
            if (j.length > 0)
            {
                long al5[] = j;
                int j4 = al5.length;
                int l2 = 0;
                for (i1 = ((flag) ? 1 : 0); i1 < j4; i1++)
                {
                    l2 += euj.a(al5[i1]);
                }

                i1 = j1 + l2 + j.length * 1;
            }
        }
        j1 = i1;
        if (k != 0L)
        {
            j1 = i1 + euj.c(11, k);
        }
        i1 = j1;
        if (l != 0)
        {
            i1 = j1 + euj.c(12, l);
        }
        j1 = i1;
        if (m)
        {
            boolean flag3 = m;
            j1 = i1 + (euj.b(13) + 1);
        }
        i1 = j1;
        if (n)
        {
            boolean flag4 = n;
            i1 = j1 + (euj.b(14) + 1);
        }
        j1 = i1;
        if (o)
        {
            boolean flag5 = o;
            j1 = i1 + (euj.b(15) + 1);
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
                a = eui1.e();
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 32: // ' '
                d = eui1.e();
                break;

            case 40: // '('
                int l2 = eup.a(eui1, 40);
                int j1 = e.length;
                long al[] = new long[l2 + j1];
                System.arraycopy(e, 0, al, 0, j1);
                for (e = al; j1 < e.length - 1; j1++)
                {
                    e[j1] = eui1.b();
                    eui1.a();
                }

                e[j1] = eui1.b();
                break;

            case 48: // '0'
                int i3 = eup.a(eui1, 48);
                int k1 = f.length;
                long al1[] = new long[i3 + k1];
                System.arraycopy(f, 0, al1, 0, k1);
                for (f = al1; k1 < f.length - 1; k1++)
                {
                    f[k1] = eui1.b();
                    eui1.a();
                }

                f[k1] = eui1.b();
                break;

            case 56: // '8'
                int j3 = eup.a(eui1, 56);
                int l1 = g.length;
                long al2[] = new long[j3 + l1];
                System.arraycopy(g, 0, al2, 0, l1);
                for (g = al2; l1 < g.length - 1; l1++)
                {
                    g[l1] = eui1.b();
                    eui1.a();
                }

                g[l1] = eui1.b();
                break;

            case 64: // '@'
                int k3 = eup.a(eui1, 64);
                int i2 = h.length;
                long al3[] = new long[k3 + i2];
                System.arraycopy(h, 0, al3, 0, i2);
                for (h = al3; i2 < h.length - 1; i2++)
                {
                    h[i2] = eui1.b();
                    eui1.a();
                }

                h[i2] = eui1.b();
                break;

            case 72: // 'H'
                int l3 = eup.a(eui1, 72);
                int j2 = i.length;
                long al4[] = new long[l3 + j2];
                System.arraycopy(i, 0, al4, 0, j2);
                for (i = al4; j2 < i.length - 1; j2++)
                {
                    i[j2] = eui1.b();
                    eui1.a();
                }

                i[j2] = eui1.b();
                break;

            case 80: // 'P'
                int i4 = eup.a(eui1, 80);
                int k2 = j.length;
                long al5[] = new long[i4 + k2];
                System.arraycopy(j, 0, al5, 0, k2);
                for (j = al5; k2 < j.length - 1; k2++)
                {
                    j[k2] = eui1.b();
                    eui1.a();
                }

                j[k2] = eui1.b();
                break;

            case 88: // 'X'
                k = eui1.b();
                break;

            case 96: // '`'
                l = eui1.d();
                break;

            case 104: // 'h'
                m = eui1.e();
                break;

            case 112: // 'p'
                n = eui1.e();
                break;

            case 120: // 'x'
                o = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a)
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
        if (d)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            long al[] = e;
            int k2 = al.length;
            for (int i1 = 0; i1 < k2; i1++)
            {
                euj1.a(5, al[i1]);
            }

        }
        if (f != null)
        {
            long al1[] = f;
            int l2 = al1.length;
            for (int j1 = 0; j1 < l2; j1++)
            {
                euj1.a(6, al1[j1]);
            }

        }
        if (g != null)
        {
            long al2[] = g;
            int i3 = al2.length;
            for (int k1 = 0; k1 < i3; k1++)
            {
                euj1.a(7, al2[k1]);
            }

        }
        if (h != null)
        {
            long al3[] = h;
            int j3 = al3.length;
            for (int l1 = 0; l1 < j3; l1++)
            {
                euj1.a(8, al3[l1]);
            }

        }
        if (i != null)
        {
            long al4[] = i;
            int k3 = al4.length;
            for (int i2 = 0; i2 < k3; i2++)
            {
                euj1.a(9, al4[i2]);
            }

        }
        if (j != null)
        {
            long al5[] = j;
            int l3 = al5.length;
            for (int j2 = ((flag) ? 1 : 0); j2 < l3; j2++)
            {
                euj1.a(10, al5[j2]);
            }

        }
        if (k != 0L)
        {
            euj1.a(11, k);
        }
        if (l != 0)
        {
            euj1.a(12, l);
        }
        if (m)
        {
            euj1.a(13, m);
        }
        if (n)
        {
            euj1.a(14, n);
        }
        if (o)
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
            if (!(obj instanceof dnm))
            {
                return false;
            }
            obj = (dnm)obj;
            if (a == ((dnm) (obj)).a && (b != null ? b.equals(((dnm) (obj)).b) : ((dnm) (obj)).b == null) && (c != null ? c.equals(((dnm) (obj)).c) : ((dnm) (obj)).c == null) && (d == ((dnm) (obj)).d && Arrays.equals(e, ((dnm) (obj)).e) && Arrays.equals(f, ((dnm) (obj)).f) && Arrays.equals(g, ((dnm) (obj)).g) && Arrays.equals(h, ((dnm) (obj)).h) && Arrays.equals(i, ((dnm) (obj)).i) && Arrays.equals(j, ((dnm) (obj)).j) && k == ((dnm) (obj)).k && l == ((dnm) (obj)).l && m == ((dnm) (obj)).m && n == ((dnm) (obj)).n && o == ((dnm) (obj)).o))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dnm) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dnm) (obj)).O))
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
        boolean flag = true;
        i2 = 0;
        int j2 = getClass().getName().hashCode();
        int k2;
        if (a)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
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
        if (d)
        {
            l1 = 1;
        } else
        {
            l1 = 2;
        }
        j1 = l1 + (k1 + (j1 + (i1 + (j2 + 527) * 31) * 31) * 31) * 31;
        if (e != null) goto _L2; else goto _L1
_L1:
        i1 = j1 * 31;
_L14:
        if (f != null) goto _L4; else goto _L3
_L3:
        i1 *= 31;
_L17:
        if (g != null) goto _L6; else goto _L5
_L5:
        i1 *= 31;
_L20:
        if (h != null) goto _L8; else goto _L7
_L7:
        i1 *= 31;
_L23:
        if (i != null) goto _L10; else goto _L9
_L9:
        i1 *= 31;
_L26:
        if (j != null) goto _L12; else goto _L11
_L11:
        j1 = i1 * 31;
_L29:
        j2 = (int)(k ^ k >>> 32);
        k2 = l;
        if (m)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        if (n)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (o)
        {
            l1 = ((flag) ? 1 : 0);
        } else
        {
            l1 = 2;
        }
        if (O != null)
        {
            i2 = O.hashCode();
        }
        return ((k1 + (i1 + ((j1 * 31 + j2) * 31 + k2) * 31) * 31) * 31 + l1) * 31 + i2;
_L2:
        k1 = 0;
_L15:
        i1 = j1;
        if (k1 >= e.length) goto _L14; else goto _L13
_L13:
        j1 = j1 * 31 + (int)(e[k1] ^ e[k1] >>> 32);
        k1++;
          goto _L15
          goto _L14
_L4:
        k1 = 0;
        j1 = i1;
_L18:
        i1 = j1;
        if (k1 >= f.length) goto _L17; else goto _L16
_L16:
        j1 = j1 * 31 + (int)(f[k1] ^ f[k1] >>> 32);
        k1++;
          goto _L18
          goto _L17
_L6:
        k1 = 0;
        j1 = i1;
_L21:
        i1 = j1;
        if (k1 >= g.length) goto _L20; else goto _L19
_L19:
        j1 = j1 * 31 + (int)(g[k1] ^ g[k1] >>> 32);
        k1++;
          goto _L21
          goto _L20
_L8:
        k1 = 0;
        j1 = i1;
_L24:
        i1 = j1;
        if (k1 >= h.length) goto _L23; else goto _L22
_L22:
        j1 = j1 * 31 + (int)(h[k1] ^ h[k1] >>> 32);
        k1++;
          goto _L24
          goto _L23
_L10:
        k1 = 0;
        j1 = i1;
_L27:
        i1 = j1;
        if (k1 >= i.length) goto _L26; else goto _L25
_L25:
        j1 = j1 * 31 + (int)(i[k1] ^ i[k1] >>> 32);
        k1++;
          goto _L27
          goto _L26
_L12:
        k1 = 0;
_L30:
        j1 = i1;
        if (k1 >= j.length) goto _L29; else goto _L28
_L28:
        i1 = i1 * 31 + (int)(j[k1] ^ j[k1] >>> 32);
        k1++;
          goto _L30
    }
}
