// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class edi extends eul
{

    public static final edi a[] = new edi[0];
    private int b[];
    private dyx c;
    private String d;
    private dma e;
    private dkn f[];
    private dzv g[];
    private String h[];
    private String i;
    private dch j;
    private String k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private String r;
    private String s;

    public edi()
    {
        b = eup.a;
        c = null;
        d = "";
        e = null;
        f = dkn.a;
        g = dzv.a;
        h = eup.d;
        i = "";
        j = null;
        k = "";
        l = 0;
        m = 0;
        n = 0;
        o = 0;
        p = 0;
        q = 0;
        r = "";
        s = "";
    }

    public final int a()
    {
        boolean flag = false;
        int j1;
        int k1;
        int i2;
        if (b != null && b.length > 0)
        {
            int ai[] = b;
            int l1 = ai.length;
            int i1 = 0;
            k1 = 0;
            for (; i1 < l1; i1++)
            {
                k1 += euj.a(ai[i1]);
            }

            k1 = k1 + 0 + b.length * 1;
        } else
        {
            k1 = 0;
        }
        j1 = k1;
        if (c != null)
        {
            j1 = k1 + euj.b(2, c);
        }
        i2 = j1;
        if (!d.equals(""))
        {
            i2 = j1 + euj.b(3, d);
        }
        k1 = i2;
        if (e != null)
        {
            k1 = i2 + euj.b(4, e);
        }
        j1 = k1;
        if (f != null)
        {
            dkn adkn[] = f;
            int i3 = adkn.length;
            int j2 = 0;
            do
            {
                j1 = k1;
                if (j2 >= i3)
                {
                    break;
                }
                dkn dkn1 = adkn[j2];
                j1 = k1;
                if (dkn1 != null)
                {
                    j1 = k1 + euj.b(5, dkn1);
                }
                j2++;
                k1 = j1;
            } while (true);
        }
        k1 = j1;
        if (g != null)
        {
            dzv adzv[] = g;
            int j3 = adzv.length;
            int k2 = 0;
            do
            {
                k1 = j1;
                if (k2 >= j3)
                {
                    break;
                }
                dzv dzv1 = adzv[k2];
                k1 = j1;
                if (dzv1 != null)
                {
                    k1 = j1 + euj.b(6, dzv1);
                }
                k2++;
                j1 = k1;
            } while (true);
        }
        j1 = k1;
        if (h != null)
        {
            j1 = k1;
            if (h.length > 0)
            {
                String as[] = h;
                int k3 = as.length;
                int l2 = 0;
                for (j1 = ((flag) ? 1 : 0); j1 < k3; j1++)
                {
                    l2 += euj.a(as[j1]);
                }

                j1 = k1 + l2 + h.length * 1;
            }
        }
        k1 = j1;
        if (!i.equals(""))
        {
            k1 = j1 + euj.b(9, i);
        }
        j1 = k1;
        if (j != null)
        {
            j1 = k1 + euj.b(10, j);
        }
        k1 = j1;
        if (!k.equals(""))
        {
            k1 = j1 + euj.b(11, k);
        }
        j1 = k1;
        if (l != 0)
        {
            j1 = k1 + euj.c(12, l);
        }
        k1 = j1;
        if (m != 0)
        {
            k1 = j1 + euj.c(13, m);
        }
        j1 = k1;
        if (n != 0)
        {
            j1 = k1 + euj.c(14, n);
        }
        k1 = j1;
        if (o != 0)
        {
            k1 = j1 + euj.c(15, o);
        }
        j1 = k1;
        if (p != 0)
        {
            j1 = k1 + euj.c(16, p);
        }
        k1 = j1;
        if (q != 0)
        {
            k1 = j1 + euj.c(17, q);
        }
        j1 = k1;
        if (!r.equals(""))
        {
            j1 = k1 + euj.b(18, r);
        }
        k1 = j1;
        if (!s.equals(""))
        {
            k1 = j1 + euj.b(19, s);
        }
        j1 = k1 + eup.a(O);
        P = j1;
        return j1;
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
                int j2 = eup.a(eui1, 8);
                int j1 = b.length;
                int ai[] = new int[j2 + j1];
                System.arraycopy(b, 0, ai, 0, j1);
                for (b = ai; j1 < b.length - 1; j1++)
                {
                    b[j1] = eui1.d();
                    eui1.a();
                }

                b[j1] = eui1.d();
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dyx();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                d = eui1.f();
                break;

            case 34: // '"'
                if (e == null)
                {
                    e = new dma();
                }
                eui1.a(e);
                break;

            case 42: // '*'
                int k2 = eup.a(eui1, 42);
                dkn adkn[];
                int k1;
                if (f == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = f.length;
                }
                adkn = new dkn[k2 + k1];
                if (f != null)
                {
                    System.arraycopy(f, 0, adkn, 0, k1);
                }
                for (f = adkn; k1 < f.length - 1; k1++)
                {
                    f[k1] = new dkn();
                    eui1.a(f[k1]);
                    eui1.a();
                }

                f[k1] = new dkn();
                eui1.a(f[k1]);
                break;

            case 50: // '2'
                int l2 = eup.a(eui1, 50);
                dzv adzv[];
                int l1;
                if (g == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = g.length;
                }
                adzv = new dzv[l2 + l1];
                if (g != null)
                {
                    System.arraycopy(g, 0, adzv, 0, l1);
                }
                for (g = adzv; l1 < g.length - 1; l1++)
                {
                    g[l1] = new dzv();
                    eui1.a(g[l1]);
                    eui1.a();
                }

                g[l1] = new dzv();
                eui1.a(g[l1]);
                break;

            case 66: // 'B'
                int i3 = eup.a(eui1, 66);
                int i2 = h.length;
                String as[] = new String[i3 + i2];
                System.arraycopy(h, 0, as, 0, i2);
                for (h = as; i2 < h.length - 1; i2++)
                {
                    h[i2] = eui1.f();
                    eui1.a();
                }

                h[i2] = eui1.f();
                break;

            case 74: // 'J'
                i = eui1.f();
                break;

            case 82: // 'R'
                if (j == null)
                {
                    j = new dch();
                }
                eui1.a(j);
                break;

            case 90: // 'Z'
                k = eui1.f();
                break;

            case 96: // '`'
                l = eui1.d();
                break;

            case 104: // 'h'
                m = eui1.d();
                break;

            case 112: // 'p'
                n = eui1.d();
                break;

            case 120: // 'x'
                o = eui1.d();
                break;

            case 128: 
                p = eui1.d();
                break;

            case 136: 
                q = eui1.d();
                break;

            case 146: 
                r = eui1.f();
                break;

            case 154: 
                s = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (b != null && b.length > 0)
        {
            int ai[] = b;
            int i2 = ai.length;
            for (int i1 = 0; i1 < i2; i1++)
            {
                euj1.a(1, ai[i1]);
            }

        }
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (!d.equals(""))
        {
            euj1.a(3, d);
        }
        if (e != null)
        {
            euj1.a(4, e);
        }
        if (f != null)
        {
            dkn adkn[] = f;
            int j2 = adkn.length;
            for (int j1 = 0; j1 < j2; j1++)
            {
                dkn dkn1 = adkn[j1];
                if (dkn1 != null)
                {
                    euj1.a(5, dkn1);
                }
            }

        }
        if (g != null)
        {
            dzv adzv[] = g;
            int k2 = adzv.length;
            for (int k1 = 0; k1 < k2; k1++)
            {
                dzv dzv1 = adzv[k1];
                if (dzv1 != null)
                {
                    euj1.a(6, dzv1);
                }
            }

        }
        if (h != null)
        {
            String as[] = h;
            int l2 = as.length;
            for (int l1 = ((flag) ? 1 : 0); l1 < l2; l1++)
            {
                euj1.a(8, as[l1]);
            }

        }
        if (!i.equals(""))
        {
            euj1.a(9, i);
        }
        if (j != null)
        {
            euj1.a(10, j);
        }
        if (!k.equals(""))
        {
            euj1.a(11, k);
        }
        if (l != 0)
        {
            euj1.a(12, l);
        }
        if (m != 0)
        {
            euj1.a(13, m);
        }
        if (n != 0)
        {
            euj1.a(14, n);
        }
        if (o != 0)
        {
            euj1.a(15, o);
        }
        if (p != 0)
        {
            euj1.a(16, p);
        }
        if (q != 0)
        {
            euj1.a(17, q);
        }
        if (!r.equals(""))
        {
            euj1.a(18, r);
        }
        if (!s.equals(""))
        {
            euj1.a(19, s);
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
            if (!(obj instanceof edi))
            {
                return false;
            }
            obj = (edi)obj;
            if (Arrays.equals(b, ((edi) (obj)).b) && (c != null ? c.equals(((edi) (obj)).c) : ((edi) (obj)).c == null) && (d != null ? d.equals(((edi) (obj)).d) : ((edi) (obj)).d == null) && (e != null ? e.equals(((edi) (obj)).e) : ((edi) (obj)).e == null) && (Arrays.equals(f, ((edi) (obj)).f) && Arrays.equals(g, ((edi) (obj)).g) && Arrays.equals(h, ((edi) (obj)).h)) && (i != null ? i.equals(((edi) (obj)).i) : ((edi) (obj)).i == null) && (j != null ? j.equals(((edi) (obj)).j) : ((edi) (obj)).j == null) && (k != null ? k.equals(((edi) (obj)).k) : ((edi) (obj)).k == null) && (l == ((edi) (obj)).l && m == ((edi) (obj)).m && n == ((edi) (obj)).n && o == ((edi) (obj)).o && p == ((edi) (obj)).p && q == ((edi) (obj)).q) && (r != null ? r.equals(((edi) (obj)).r) : ((edi) (obj)).r == null) && (s != null ? s.equals(((edi) (obj)).s) : ((edi) (obj)).s == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((edi) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((edi) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i1;
        int k2;
        k2 = 0;
        i1 = getClass().getName().hashCode() + 527;
        if (b != null) goto _L2; else goto _L1
_L1:
        int j1 = i1 * 31;
_L10:
        int k1;
        int l1;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        if (c == null)
        {
            i1 = 0;
        } else
        {
            i1 = c.hashCode();
        }
        if (d == null)
        {
            k1 = 0;
        } else
        {
            k1 = d.hashCode();
        }
        if (e == null)
        {
            l1 = 0;
        } else
        {
            l1 = e.hashCode();
        }
        i1 = l1 + (k1 + (i1 + j1 * 31) * 31) * 31;
        if (f != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L13:
        if (g != null) goto _L6; else goto _L5
_L5:
        j1 *= 31;
_L16:
        if (h != null) goto _L8; else goto _L7
_L7:
        j1 *= 31;
_L19:
        int i2;
        int j2;
        if (i == null)
        {
            i1 = 0;
        } else
        {
            i1 = i.hashCode();
        }
        if (j == null)
        {
            k1 = 0;
        } else
        {
            k1 = j.hashCode();
        }
        if (k == null)
        {
            l1 = 0;
        } else
        {
            l1 = k.hashCode();
        }
        l2 = l;
        i3 = m;
        j3 = n;
        k3 = o;
        l3 = p;
        i4 = q;
        if (r == null)
        {
            i2 = 0;
        } else
        {
            i2 = r.hashCode();
        }
        if (s == null)
        {
            j2 = 0;
        } else
        {
            j2 = s.hashCode();
        }
        if (O != null)
        {
            k2 = O.hashCode();
        }
        return (j2 + (i2 + (((((((l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31 + l3) * 31 + i4) * 31) * 31) * 31 + k2;
_L2:
        k1 = 0;
_L11:
        j1 = i1;
        if (k1 >= b.length) goto _L10; else goto _L9
_L9:
        i1 = i1 * 31 + b[k1];
        k1++;
          goto _L11
          goto _L10
_L4:
        k1 = 0;
_L14:
        j1 = i1;
        if (k1 >= f.length) goto _L13; else goto _L12
_L12:
        if (f[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = f[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L14
          goto _L13
_L6:
        k1 = 0;
        i1 = j1;
_L17:
        j1 = i1;
        if (k1 >= g.length) goto _L16; else goto _L15
_L15:
        if (g[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = g[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L17
          goto _L16
_L8:
        k1 = 0;
        i1 = j1;
_L20:
        j1 = i1;
        if (k1 >= h.length) goto _L19; else goto _L18
_L18:
        if (h[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = h[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L20
    }

}
