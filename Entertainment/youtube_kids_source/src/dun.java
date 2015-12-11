// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dun extends eul
{

    private dlb A;
    private dre B;
    private dlb C;
    private String D;
    private dlb E[];
    private dlb F[];
    private dre G;
    public dzp a;
    public dre b;
    public byte c[];
    public dux d;
    private String e;
    private dre f;
    private dlb g;
    private dlb h;
    private dlb i;
    private dlb j;
    private dlb k;
    private dlb l;
    private doz m;
    private dxq n;
    private boolean o;
    private dum p;
    private boolean q;
    private doy r;
    private int s;
    private dkh t;
    private dre u;
    private duo v;
    private dxa w;
    private dxa x[];
    private dlb y;
    private dlb z;

    public dun()
    {
        e = "";
        f = null;
        g = null;
        a = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = false;
        p = null;
        q = false;
        r = null;
        s = 0;
        b = null;
        t = null;
        u = null;
        v = null;
        w = null;
        c = eup.f;
        x = dxa.a;
        y = null;
        z = null;
        A = null;
        B = null;
        C = null;
        D = "";
        d = null;
        E = dlb.a;
        F = dlb.a;
        G = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int l1;
        if (!e.equals(""))
        {
            j1 = euj.b(1, e) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(2, f);
        }
        j1 = i1;
        if (g != null)
        {
            j1 = i1 + euj.b(3, g);
        }
        i1 = j1;
        if (a != null)
        {
            i1 = j1 + euj.b(4, a);
        }
        j1 = i1;
        if (h != null)
        {
            j1 = i1 + euj.b(5, h);
        }
        i1 = j1;
        if (i != null)
        {
            i1 = j1 + euj.b(6, i);
        }
        j1 = i1;
        if (j != null)
        {
            j1 = i1 + euj.b(7, j);
        }
        i1 = j1;
        if (k != null)
        {
            i1 = j1 + euj.b(8, k);
        }
        j1 = i1;
        if (l != null)
        {
            j1 = i1 + euj.b(9, l);
        }
        i1 = j1;
        if (m != null)
        {
            i1 = j1 + euj.b(10, m);
        }
        j1 = i1;
        if (n != null)
        {
            j1 = i1 + euj.b(11, n);
        }
        i1 = j1;
        if (o)
        {
            boolean flag1 = o;
            i1 = j1 + (euj.b(12) + 1);
        }
        j1 = i1;
        if (p != null)
        {
            j1 = i1 + euj.b(13, p);
        }
        i1 = j1;
        if (q)
        {
            boolean flag2 = q;
            i1 = j1 + (euj.b(14) + 1);
        }
        j1 = i1;
        if (r != null)
        {
            j1 = i1 + euj.b(15, r);
        }
        i1 = j1;
        if (s != 0)
        {
            i1 = j1 + euj.c(16, s);
        }
        j1 = i1;
        if (b != null)
        {
            j1 = i1 + euj.b(17, b);
        }
        i1 = j1;
        if (t != null)
        {
            i1 = j1 + euj.b(18, t);
        }
        j1 = i1;
        if (u != null)
        {
            j1 = i1 + euj.b(19, u);
        }
        i1 = j1;
        if (v != null)
        {
            i1 = j1 + euj.b(21, v);
        }
        j1 = i1;
        if (w != null)
        {
            j1 = i1 + euj.b(22, w);
        }
        i1 = j1;
        if (!Arrays.equals(c, eup.f))
        {
            i1 = j1 + euj.b(23, c);
        }
        j1 = i1;
        if (x != null)
        {
            dxa adxa[] = x;
            int k2 = adxa.length;
            int k1 = 0;
            do
            {
                j1 = i1;
                if (k1 >= k2)
                {
                    break;
                }
                dxa dxa1 = adxa[k1];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(24, dxa1);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (y != null)
        {
            i1 = j1 + euj.b(25, y);
        }
        j1 = i1;
        if (z != null)
        {
            j1 = i1 + euj.b(26, z);
        }
        i1 = j1;
        if (A != null)
        {
            i1 = j1 + euj.b(27, A);
        }
        j1 = i1;
        if (B != null)
        {
            j1 = i1 + euj.b(28, B);
        }
        i1 = j1;
        if (C != null)
        {
            i1 = j1 + euj.b(29, C);
        }
        l1 = i1;
        if (!D.equals(""))
        {
            l1 = i1 + euj.b(30, D);
        }
        j1 = l1;
        if (d != null)
        {
            j1 = l1 + euj.b(31, d);
        }
        i1 = j1;
        if (E != null)
        {
            dlb adlb[] = E;
            int l2 = adlb.length;
            int i2 = 0;
            do
            {
                i1 = j1;
                if (i2 >= l2)
                {
                    break;
                }
                dlb dlb1 = adlb[i2];
                i1 = j1;
                if (dlb1 != null)
                {
                    i1 = j1 + euj.b(32, dlb1);
                }
                i2++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (F != null)
        {
            dlb adlb1[] = F;
            int i3 = adlb1.length;
            int j2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (j2 >= i3)
                {
                    break;
                }
                dlb dlb2 = adlb1[j2];
                j1 = i1;
                if (dlb2 != null)
                {
                    j1 = i1 + euj.b(33, dlb2);
                }
                j2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (G != null)
        {
            i1 = j1 + euj.b(40, G);
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
                e = eui1.f();
                break;

            case 18: // '\022'
                if (f == null)
                {
                    f = new dre();
                }
                eui1.a(f);
                break;

            case 26: // '\032'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 34: // '"'
                if (a == null)
                {
                    a = new dzp();
                }
                eui1.a(a);
                break;

            case 42: // '*'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 50: // '2'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 58: // ':'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 66: // 'B'
                if (k == null)
                {
                    k = new dlb();
                }
                eui1.a(k);
                break;

            case 74: // 'J'
                if (l == null)
                {
                    l = new dlb();
                }
                eui1.a(l);
                break;

            case 82: // 'R'
                if (m == null)
                {
                    m = new doz();
                }
                eui1.a(m);
                break;

            case 90: // 'Z'
                if (n == null)
                {
                    n = new dxq();
                }
                eui1.a(n);
                break;

            case 96: // '`'
                o = eui1.e();
                break;

            case 106: // 'j'
                if (p == null)
                {
                    p = new dum();
                }
                eui1.a(p);
                break;

            case 112: // 'p'
                q = eui1.e();
                break;

            case 122: // 'z'
                if (r == null)
                {
                    r = new doy();
                }
                eui1.a(r);
                break;

            case 128: 
                int j1 = eui1.d();
                if (j1 == 0 || j1 == 1 || j1 == 2)
                {
                    s = j1;
                } else
                {
                    s = 0;
                }
                break;

            case 138: 
                if (b == null)
                {
                    b = new dre();
                }
                eui1.a(b);
                break;

            case 146: 
                if (t == null)
                {
                    t = new dkh();
                }
                eui1.a(t);
                break;

            case 154: 
                if (u == null)
                {
                    u = new dre();
                }
                eui1.a(u);
                break;

            case 170: 
                if (v == null)
                {
                    v = new duo();
                }
                eui1.a(v);
                break;

            case 178: 
                if (w == null)
                {
                    w = new dxa();
                }
                eui1.a(w);
                break;

            case 186: 
                c = eui1.g();
                break;

            case 194: 
                int j2 = eup.a(eui1, 194);
                dxa adxa[];
                int k1;
                if (x == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = x.length;
                }
                adxa = new dxa[j2 + k1];
                if (x != null)
                {
                    System.arraycopy(x, 0, adxa, 0, k1);
                }
                for (x = adxa; k1 < x.length - 1; k1++)
                {
                    x[k1] = new dxa();
                    eui1.a(x[k1]);
                    eui1.a();
                }

                x[k1] = new dxa();
                eui1.a(x[k1]);
                break;

            case 202: 
                if (y == null)
                {
                    y = new dlb();
                }
                eui1.a(y);
                break;

            case 210: 
                if (z == null)
                {
                    z = new dlb();
                }
                eui1.a(z);
                break;

            case 218: 
                if (A == null)
                {
                    A = new dlb();
                }
                eui1.a(A);
                break;

            case 226: 
                if (B == null)
                {
                    B = new dre();
                }
                eui1.a(B);
                break;

            case 234: 
                if (C == null)
                {
                    C = new dlb();
                }
                eui1.a(C);
                break;

            case 242: 
                D = eui1.f();
                break;

            case 250: 
                if (d == null)
                {
                    d = new dux();
                }
                eui1.a(d);
                break;

            case 258: 
                int k2 = eup.a(eui1, 258);
                dlb adlb[];
                int l1;
                if (E == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = E.length;
                }
                adlb = new dlb[k2 + l1];
                if (E != null)
                {
                    System.arraycopy(E, 0, adlb, 0, l1);
                }
                for (E = adlb; l1 < E.length - 1; l1++)
                {
                    E[l1] = new dlb();
                    eui1.a(E[l1]);
                    eui1.a();
                }

                E[l1] = new dlb();
                eui1.a(E[l1]);
                break;

            case 266: 
                int l2 = eup.a(eui1, 266);
                dlb adlb1[];
                int i2;
                if (F == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = F.length;
                }
                adlb1 = new dlb[l2 + i2];
                if (F != null)
                {
                    System.arraycopy(F, 0, adlb1, 0, i2);
                }
                for (F = adlb1; i2 < F.length - 1; i2++)
                {
                    F[i2] = new dlb();
                    eui1.a(F[i2]);
                    eui1.a();
                }

                F[i2] = new dlb();
                eui1.a(F[i2]);
                break;

            case 322: 
                if (G == null)
                {
                    G = new dre();
                }
                eui1.a(G);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!e.equals(""))
        {
            euj1.a(1, e);
        }
        if (f != null)
        {
            euj1.a(2, f);
        }
        if (g != null)
        {
            euj1.a(3, g);
        }
        if (a != null)
        {
            euj1.a(4, a);
        }
        if (h != null)
        {
            euj1.a(5, h);
        }
        if (i != null)
        {
            euj1.a(6, i);
        }
        if (j != null)
        {
            euj1.a(7, j);
        }
        if (k != null)
        {
            euj1.a(8, k);
        }
        if (l != null)
        {
            euj1.a(9, l);
        }
        if (m != null)
        {
            euj1.a(10, m);
        }
        if (n != null)
        {
            euj1.a(11, n);
        }
        if (o)
        {
            euj1.a(12, o);
        }
        if (p != null)
        {
            euj1.a(13, p);
        }
        if (q)
        {
            euj1.a(14, q);
        }
        if (r != null)
        {
            euj1.a(15, r);
        }
        if (s != 0)
        {
            euj1.a(16, s);
        }
        if (b != null)
        {
            euj1.a(17, b);
        }
        if (t != null)
        {
            euj1.a(18, t);
        }
        if (u != null)
        {
            euj1.a(19, u);
        }
        if (v != null)
        {
            euj1.a(21, v);
        }
        if (w != null)
        {
            euj1.a(22, w);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(23, c);
        }
        if (x != null)
        {
            dxa adxa[] = x;
            int l1 = adxa.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                dxa dxa1 = adxa[i1];
                if (dxa1 != null)
                {
                    euj1.a(24, dxa1);
                }
            }

        }
        if (y != null)
        {
            euj1.a(25, y);
        }
        if (z != null)
        {
            euj1.a(26, z);
        }
        if (A != null)
        {
            euj1.a(27, A);
        }
        if (B != null)
        {
            euj1.a(28, B);
        }
        if (C != null)
        {
            euj1.a(29, C);
        }
        if (!D.equals(""))
        {
            euj1.a(30, D);
        }
        if (d != null)
        {
            euj1.a(31, d);
        }
        if (E != null)
        {
            dlb adlb[] = E;
            int i2 = adlb.length;
            for (int j1 = 0; j1 < i2; j1++)
            {
                dlb dlb1 = adlb[j1];
                if (dlb1 != null)
                {
                    euj1.a(32, dlb1);
                }
            }

        }
        if (F != null)
        {
            dlb adlb1[] = F;
            int j2 = adlb1.length;
            for (int k1 = ((flag) ? 1 : 0); k1 < j2; k1++)
            {
                dlb dlb2 = adlb1[k1];
                if (dlb2 != null)
                {
                    euj1.a(33, dlb2);
                }
            }

        }
        if (G != null)
        {
            euj1.a(40, G);
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
            if (!(obj instanceof dun))
            {
                return false;
            }
            obj = (dun)obj;
            if ((e != null ? e.equals(((dun) (obj)).e) : ((dun) (obj)).e == null) && (f != null ? f.equals(((dun) (obj)).f) : ((dun) (obj)).f == null) && (g != null ? g.equals(((dun) (obj)).g) : ((dun) (obj)).g == null) && (a != null ? a.equals(((dun) (obj)).a) : ((dun) (obj)).a == null) && (h != null ? h.equals(((dun) (obj)).h) : ((dun) (obj)).h == null) && (i != null ? i.equals(((dun) (obj)).i) : ((dun) (obj)).i == null) && (j != null ? j.equals(((dun) (obj)).j) : ((dun) (obj)).j == null) && (k != null ? k.equals(((dun) (obj)).k) : ((dun) (obj)).k == null) && (l != null ? l.equals(((dun) (obj)).l) : ((dun) (obj)).l == null) && (m != null ? m.equals(((dun) (obj)).m) : ((dun) (obj)).m == null) && (n != null ? n.equals(((dun) (obj)).n) : ((dun) (obj)).n == null) && o == ((dun) (obj)).o && (p != null ? p.equals(((dun) (obj)).p) : ((dun) (obj)).p == null) && q == ((dun) (obj)).q && (r != null ? r.equals(((dun) (obj)).r) : ((dun) (obj)).r == null) && s == ((dun) (obj)).s && (b != null ? b.equals(((dun) (obj)).b) : ((dun) (obj)).b == null) && (t != null ? t.equals(((dun) (obj)).t) : ((dun) (obj)).t == null) && (u != null ? u.equals(((dun) (obj)).u) : ((dun) (obj)).u == null) && (v != null ? v.equals(((dun) (obj)).v) : ((dun) (obj)).v == null) && (w != null ? w.equals(((dun) (obj)).w) : ((dun) (obj)).w == null) && (Arrays.equals(c, ((dun) (obj)).c) && Arrays.equals(x, ((dun) (obj)).x)) && (y != null ? y.equals(((dun) (obj)).y) : ((dun) (obj)).y == null) && (z != null ? z.equals(((dun) (obj)).z) : ((dun) (obj)).z == null) && (A != null ? A.equals(((dun) (obj)).A) : ((dun) (obj)).A == null) && (B != null ? B.equals(((dun) (obj)).B) : ((dun) (obj)).B == null) && (C != null ? C.equals(((dun) (obj)).C) : ((dun) (obj)).C == null) && (D != null ? D.equals(((dun) (obj)).D) : ((dun) (obj)).D == null) && (d != null ? d.equals(((dun) (obj)).d) : ((dun) (obj)).d == null) && (Arrays.equals(E, ((dun) (obj)).E) && Arrays.equals(F, ((dun) (obj)).F)) && (G != null ? G.equals(((dun) (obj)).G) : ((dun) (obj)).G == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dun) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dun) (obj)).O))
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
        int j2;
        int k2;
        int l2;
        int j4 = 1;
        boolean flag = false;
        int i6 = getClass().getName().hashCode();
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int k4;
        int l4;
        int i5;
        int j5;
        int k5;
        int l5;
        int j6;
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        if (f == null)
        {
            j1 = 0;
        } else
        {
            j1 = f.hashCode();
        }
        if (g == null)
        {
            k1 = 0;
        } else
        {
            k1 = g.hashCode();
        }
        if (a == null)
        {
            l1 = 0;
        } else
        {
            l1 = a.hashCode();
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
        if (j == null)
        {
            k2 = 0;
        } else
        {
            k2 = j.hashCode();
        }
        if (k == null)
        {
            l2 = 0;
        } else
        {
            l2 = k.hashCode();
        }
        if (l == null)
        {
            i3 = 0;
        } else
        {
            i3 = l.hashCode();
        }
        if (m == null)
        {
            j3 = 0;
        } else
        {
            j3 = m.hashCode();
        }
        if (n == null)
        {
            k3 = 0;
        } else
        {
            k3 = n.hashCode();
        }
        if (o)
        {
            l3 = 1;
        } else
        {
            l3 = 2;
        }
        if (p == null)
        {
            i4 = 0;
        } else
        {
            i4 = p.hashCode();
        }
        if (!q)
        {
            j4 = 2;
        }
        if (r == null)
        {
            k4 = 0;
        } else
        {
            k4 = r.hashCode();
        }
        j6 = s;
        if (b == null)
        {
            l4 = 0;
        } else
        {
            l4 = b.hashCode();
        }
        if (t == null)
        {
            i5 = 0;
        } else
        {
            i5 = t.hashCode();
        }
        if (u == null)
        {
            j5 = 0;
        } else
        {
            j5 = u.hashCode();
        }
        if (v == null)
        {
            k5 = 0;
        } else
        {
            k5 = v.hashCode();
        }
        if (w == null)
        {
            l5 = 0;
        } else
        {
            l5 = w.hashCode();
        }
        j1 = l5 + (k5 + (j5 + (i5 + (l4 + ((k4 + ((i4 + (l3 + (k3 + (j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (i6 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + j4) * 31) * 31 + j6) * 31) * 31) * 31) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        i1 = j1 * 31;
_L10:
        if (x != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L13:
        if (y == null)
        {
            i1 = 0;
        } else
        {
            i1 = y.hashCode();
        }
        if (z == null)
        {
            k1 = 0;
        } else
        {
            k1 = z.hashCode();
        }
        if (A == null)
        {
            l1 = 0;
        } else
        {
            l1 = A.hashCode();
        }
        if (B == null)
        {
            i2 = 0;
        } else
        {
            i2 = B.hashCode();
        }
        if (C == null)
        {
            j2 = 0;
        } else
        {
            j2 = C.hashCode();
        }
        if (D == null)
        {
            k2 = 0;
        } else
        {
            k2 = D.hashCode();
        }
        if (d == null)
        {
            l2 = 0;
        } else
        {
            l2 = d.hashCode();
        }
        i1 = l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (E != null) goto _L6; else goto _L5
_L5:
        j1 = i1 * 31;
_L16:
        if (F != null) goto _L8; else goto _L7
_L7:
        j1 *= 31;
_L19:
        if (G == null)
        {
            i1 = 0;
        } else
        {
            i1 = G.hashCode();
        }
        if (O == null)
        {
            k1 = ((flag) ? 1 : 0);
        } else
        {
            k1 = O.hashCode();
        }
        return (i1 + j1 * 31) * 31 + k1;
_L2:
        k1 = 0;
_L11:
        i1 = j1;
        if (k1 >= c.length) goto _L10; else goto _L9
_L9:
        j1 = j1 * 31 + c[k1];
        k1++;
          goto _L11
          goto _L10
_L4:
        k1 = 0;
_L14:
        j1 = i1;
        if (k1 >= x.length) goto _L13; else goto _L12
_L12:
        if (x[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = x[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L14
          goto _L13
_L6:
        k1 = 0;
_L17:
        j1 = i1;
        if (k1 >= E.length) goto _L16; else goto _L15
_L15:
        if (E[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = E[k1].hashCode();
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
        if (k1 >= F.length) goto _L19; else goto _L18
_L18:
        if (F[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = F[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L20
    }
}
