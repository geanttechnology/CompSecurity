// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ebw extends eul
{

    private dqi A;
    private boolean B;
    public String a;
    public dre b;
    public byte c[];
    private dzp d;
    private dlb e;
    private dlb f;
    private dlb g;
    private dlb h;
    private dlb i;
    private dlb j;
    private dfq k[];
    private dfq l[];
    private dlb m[];
    private dcr n;
    private String o;
    private dlb p;
    private eab q;
    private dlb r;
    private dzp s;
    private ebx t;
    private dop u;
    private dzo v[];
    private dxa w[];
    private boolean x;
    private dlb y;
    private boolean z;

    public ebw()
    {
        a = "";
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        b = null;
        k = dfq.a;
        l = dfq.a;
        m = dlb.a;
        n = null;
        o = "";
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        c = eup.f;
        u = null;
        v = dzo.a;
        w = dxa.a;
        x = false;
        y = null;
        z = false;
        A = null;
        B = false;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        if (!a.equals(""))
        {
            j1 = euj.b(1, a) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1 + euj.b(2, d);
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1 + euj.b(3, e);
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(4, f);
        }
        j1 = i1;
        if (g != null)
        {
            j1 = i1 + euj.b(5, g);
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
        if (j != null)
        {
            i1 = j1 + euj.b(8, j);
        }
        j1 = i1;
        if (b != null)
        {
            j1 = i1 + euj.b(9, b);
        }
        i1 = j1;
        if (k != null)
        {
            dfq adfq[] = k;
            int l2 = adfq.length;
            int k1 = 0;
            do
            {
                i1 = j1;
                if (k1 >= l2)
                {
                    break;
                }
                dfq dfq1 = adfq[k1];
                i1 = j1;
                if (dfq1 != null)
                {
                    i1 = j1 + euj.b(10, dfq1);
                }
                k1++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (l != null)
        {
            dfq adfq1[] = l;
            int i3 = adfq1.length;
            int l1 = 0;
            do
            {
                j1 = i1;
                if (l1 >= i3)
                {
                    break;
                }
                dfq dfq2 = adfq1[l1];
                j1 = i1;
                if (dfq2 != null)
                {
                    j1 = i1 + euj.b(11, dfq2);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (m != null)
        {
            dlb adlb[] = m;
            int j3 = adlb.length;
            int i2 = 0;
            do
            {
                i1 = j1;
                if (i2 >= j3)
                {
                    break;
                }
                dlb dlb1 = adlb[i2];
                i1 = j1;
                if (dlb1 != null)
                {
                    i1 = j1 + euj.b(12, dlb1);
                }
                i2++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (n != null)
        {
            j1 = i1 + euj.b(13, n);
        }
        i1 = j1;
        if (!o.equals(""))
        {
            i1 = j1 + euj.b(14, o);
        }
        j1 = i1;
        if (p != null)
        {
            j1 = i1 + euj.b(15, p);
        }
        i1 = j1;
        if (q != null)
        {
            i1 = j1 + euj.b(17, q);
        }
        j1 = i1;
        if (r != null)
        {
            j1 = i1 + euj.b(18, r);
        }
        i1 = j1;
        if (s != null)
        {
            i1 = j1 + euj.b(19, s);
        }
        j1 = i1;
        if (t != null)
        {
            j1 = i1 + euj.b(20, t);
        }
        i1 = j1;
        if (!Arrays.equals(c, eup.f))
        {
            i1 = j1 + euj.b(21, c);
        }
        j1 = i1;
        if (u != null)
        {
            j1 = i1 + euj.b(22, u);
        }
        i1 = j1;
        if (v != null)
        {
            dzo adzo[] = v;
            int k3 = adzo.length;
            int j2 = 0;
            do
            {
                i1 = j1;
                if (j2 >= k3)
                {
                    break;
                }
                dzo dzo1 = adzo[j2];
                i1 = j1;
                if (dzo1 != null)
                {
                    i1 = j1 + euj.b(23, dzo1);
                }
                j2++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (w != null)
        {
            dxa adxa[] = w;
            int l3 = adxa.length;
            int k2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (k2 >= l3)
                {
                    break;
                }
                dxa dxa1 = adxa[k2];
                j1 = i1;
                if (dxa1 != null)
                {
                    j1 = i1 + euj.b(24, dxa1);
                }
                k2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (x)
        {
            boolean flag1 = x;
            i1 = j1 + (euj.b(25) + 1);
        }
        j1 = i1;
        if (y != null)
        {
            j1 = i1 + euj.b(26, y);
        }
        i1 = j1;
        if (z)
        {
            boolean flag2 = z;
            i1 = j1 + (euj.b(27) + 1);
        }
        j1 = i1;
        if (A != null)
        {
            j1 = i1 + euj.b(28, A);
        }
        i1 = j1;
        if (B)
        {
            boolean flag3 = B;
            i1 = j1 + (euj.b(30) + 1);
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
                a = eui1.f();
                break;

            case 18: // '\022'
                if (d == null)
                {
                    d = new dzp();
                }
                eui1.a(d);
                break;

            case 26: // '\032'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 34: // '"'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 42: // '*'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 50: // '2'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 58: // ':'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 66: // 'B'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 74: // 'J'
                if (b == null)
                {
                    b = new dre();
                }
                eui1.a(b);
                break;

            case 82: // 'R'
                int k2 = eup.a(eui1, 82);
                dfq adfq[];
                int j1;
                if (k == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = k.length;
                }
                adfq = new dfq[k2 + j1];
                if (k != null)
                {
                    System.arraycopy(k, 0, adfq, 0, j1);
                }
                for (k = adfq; j1 < k.length - 1; j1++)
                {
                    k[j1] = new dfq();
                    eui1.a(k[j1]);
                    eui1.a();
                }

                k[j1] = new dfq();
                eui1.a(k[j1]);
                break;

            case 90: // 'Z'
                int l2 = eup.a(eui1, 90);
                dfq adfq1[];
                int k1;
                if (l == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = l.length;
                }
                adfq1 = new dfq[l2 + k1];
                if (l != null)
                {
                    System.arraycopy(l, 0, adfq1, 0, k1);
                }
                for (l = adfq1; k1 < l.length - 1; k1++)
                {
                    l[k1] = new dfq();
                    eui1.a(l[k1]);
                    eui1.a();
                }

                l[k1] = new dfq();
                eui1.a(l[k1]);
                break;

            case 98: // 'b'
                int i3 = eup.a(eui1, 98);
                dlb adlb[];
                int l1;
                if (m == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = m.length;
                }
                adlb = new dlb[i3 + l1];
                if (m != null)
                {
                    System.arraycopy(m, 0, adlb, 0, l1);
                }
                for (m = adlb; l1 < m.length - 1; l1++)
                {
                    m[l1] = new dlb();
                    eui1.a(m[l1]);
                    eui1.a();
                }

                m[l1] = new dlb();
                eui1.a(m[l1]);
                break;

            case 106: // 'j'
                if (n == null)
                {
                    n = new dcr();
                }
                eui1.a(n);
                break;

            case 114: // 'r'
                o = eui1.f();
                break;

            case 122: // 'z'
                if (p == null)
                {
                    p = new dlb();
                }
                eui1.a(p);
                break;

            case 138: 
                if (q == null)
                {
                    q = new eab();
                }
                eui1.a(q);
                break;

            case 146: 
                if (r == null)
                {
                    r = new dlb();
                }
                eui1.a(r);
                break;

            case 154: 
                if (s == null)
                {
                    s = new dzp();
                }
                eui1.a(s);
                break;

            case 162: 
                if (t == null)
                {
                    t = new ebx();
                }
                eui1.a(t);
                break;

            case 170: 
                c = eui1.g();
                break;

            case 178: 
                if (u == null)
                {
                    u = new dop();
                }
                eui1.a(u);
                break;

            case 186: 
                int j3 = eup.a(eui1, 186);
                dzo adzo[];
                int i2;
                if (v == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = v.length;
                }
                adzo = new dzo[j3 + i2];
                if (v != null)
                {
                    System.arraycopy(v, 0, adzo, 0, i2);
                }
                for (v = adzo; i2 < v.length - 1; i2++)
                {
                    v[i2] = new dzo();
                    eui1.a(v[i2]);
                    eui1.a();
                }

                v[i2] = new dzo();
                eui1.a(v[i2]);
                break;

            case 194: 
                int k3 = eup.a(eui1, 194);
                dxa adxa[];
                int j2;
                if (w == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = w.length;
                }
                adxa = new dxa[k3 + j2];
                if (w != null)
                {
                    System.arraycopy(w, 0, adxa, 0, j2);
                }
                for (w = adxa; j2 < w.length - 1; j2++)
                {
                    w[j2] = new dxa();
                    eui1.a(w[j2]);
                    eui1.a();
                }

                w[j2] = new dxa();
                eui1.a(w[j2]);
                break;

            case 200: 
                x = eui1.e();
                break;

            case 210: 
                if (y == null)
                {
                    y = new dlb();
                }
                eui1.a(y);
                break;

            case 216: 
                z = eui1.e();
                break;

            case 226: 
                if (A == null)
                {
                    A = new dqi();
                }
                eui1.a(A);
                break;

            case 240: 
                B = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!a.equals(""))
        {
            euj1.a(1, a);
        }
        if (d != null)
        {
            euj1.a(2, d);
        }
        if (e != null)
        {
            euj1.a(3, e);
        }
        if (f != null)
        {
            euj1.a(4, f);
        }
        if (g != null)
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
        if (j != null)
        {
            euj1.a(8, j);
        }
        if (b != null)
        {
            euj1.a(9, b);
        }
        if (k != null)
        {
            dfq adfq[] = k;
            int j2 = adfq.length;
            for (int i1 = 0; i1 < j2; i1++)
            {
                dfq dfq1 = adfq[i1];
                if (dfq1 != null)
                {
                    euj1.a(10, dfq1);
                }
            }

        }
        if (l != null)
        {
            dfq adfq1[] = l;
            int k2 = adfq1.length;
            for (int j1 = 0; j1 < k2; j1++)
            {
                dfq dfq2 = adfq1[j1];
                if (dfq2 != null)
                {
                    euj1.a(11, dfq2);
                }
            }

        }
        if (m != null)
        {
            dlb adlb[] = m;
            int l2 = adlb.length;
            for (int k1 = 0; k1 < l2; k1++)
            {
                dlb dlb1 = adlb[k1];
                if (dlb1 != null)
                {
                    euj1.a(12, dlb1);
                }
            }

        }
        if (n != null)
        {
            euj1.a(13, n);
        }
        if (!o.equals(""))
        {
            euj1.a(14, o);
        }
        if (p != null)
        {
            euj1.a(15, p);
        }
        if (q != null)
        {
            euj1.a(17, q);
        }
        if (r != null)
        {
            euj1.a(18, r);
        }
        if (s != null)
        {
            euj1.a(19, s);
        }
        if (t != null)
        {
            euj1.a(20, t);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(21, c);
        }
        if (u != null)
        {
            euj1.a(22, u);
        }
        if (v != null)
        {
            dzo adzo[] = v;
            int i3 = adzo.length;
            for (int l1 = 0; l1 < i3; l1++)
            {
                dzo dzo1 = adzo[l1];
                if (dzo1 != null)
                {
                    euj1.a(23, dzo1);
                }
            }

        }
        if (w != null)
        {
            dxa adxa[] = w;
            int j3 = adxa.length;
            for (int i2 = ((flag) ? 1 : 0); i2 < j3; i2++)
            {
                dxa dxa1 = adxa[i2];
                if (dxa1 != null)
                {
                    euj1.a(24, dxa1);
                }
            }

        }
        if (x)
        {
            euj1.a(25, x);
        }
        if (y != null)
        {
            euj1.a(26, y);
        }
        if (z)
        {
            euj1.a(27, z);
        }
        if (A != null)
        {
            euj1.a(28, A);
        }
        if (B)
        {
            euj1.a(30, B);
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
            if (!(obj instanceof ebw))
            {
                return false;
            }
            obj = (ebw)obj;
            if ((a != null ? a.equals(((ebw) (obj)).a) : ((ebw) (obj)).a == null) && (d != null ? d.equals(((ebw) (obj)).d) : ((ebw) (obj)).d == null) && (e != null ? e.equals(((ebw) (obj)).e) : ((ebw) (obj)).e == null) && (f != null ? f.equals(((ebw) (obj)).f) : ((ebw) (obj)).f == null) && (g != null ? g.equals(((ebw) (obj)).g) : ((ebw) (obj)).g == null) && (h != null ? h.equals(((ebw) (obj)).h) : ((ebw) (obj)).h == null) && (i != null ? i.equals(((ebw) (obj)).i) : ((ebw) (obj)).i == null) && (j != null ? j.equals(((ebw) (obj)).j) : ((ebw) (obj)).j == null) && (b != null ? b.equals(((ebw) (obj)).b) : ((ebw) (obj)).b == null) && (Arrays.equals(k, ((ebw) (obj)).k) && Arrays.equals(l, ((ebw) (obj)).l) && Arrays.equals(m, ((ebw) (obj)).m)) && (n != null ? n.equals(((ebw) (obj)).n) : ((ebw) (obj)).n == null) && (o != null ? o.equals(((ebw) (obj)).o) : ((ebw) (obj)).o == null) && (p != null ? p.equals(((ebw) (obj)).p) : ((ebw) (obj)).p == null) && (q != null ? q.equals(((ebw) (obj)).q) : ((ebw) (obj)).q == null) && (r != null ? r.equals(((ebw) (obj)).r) : ((ebw) (obj)).r == null) && (s != null ? s.equals(((ebw) (obj)).s) : ((ebw) (obj)).s == null) && (t != null ? t.equals(((ebw) (obj)).t) : ((ebw) (obj)).t == null) && Arrays.equals(c, ((ebw) (obj)).c) && (u != null ? u.equals(((ebw) (obj)).u) : ((ebw) (obj)).u == null) && (Arrays.equals(v, ((ebw) (obj)).v) && Arrays.equals(w, ((ebw) (obj)).w) && x == ((ebw) (obj)).x) && (y != null ? y.equals(((ebw) (obj)).y) : ((ebw) (obj)).y == null) && z == ((ebw) (obj)).z && (A != null ? A.equals(((ebw) (obj)).A) : ((ebw) (obj)).A == null) && B == ((ebw) (obj)).B)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ebw) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ebw) (obj)).O))
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
        boolean flag1 = true;
        boolean flag = false;
        int j3 = getClass().getName().hashCode();
        int i3;
        if (a == null)
        {
            i1 = 0;
        } else
        {
            i1 = a.hashCode();
        }
        if (d == null)
        {
            j1 = 0;
        } else
        {
            j1 = d.hashCode();
        }
        if (e == null)
        {
            k1 = 0;
        } else
        {
            k1 = e.hashCode();
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
        if (b == null)
        {
            i3 = 0;
        } else
        {
            i3 = b.hashCode();
        }
        i1 = i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (j3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (k != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L14:
        if (l != null) goto _L4; else goto _L3
_L3:
        j1 *= 31;
_L17:
        if (m != null) goto _L6; else goto _L5
_L5:
        j1 *= 31;
_L20:
        if (n == null)
        {
            i1 = 0;
        } else
        {
            i1 = n.hashCode();
        }
        if (o == null)
        {
            k1 = 0;
        } else
        {
            k1 = o.hashCode();
        }
        if (p == null)
        {
            l1 = 0;
        } else
        {
            l1 = p.hashCode();
        }
        if (q == null)
        {
            i2 = 0;
        } else
        {
            i2 = q.hashCode();
        }
        if (r == null)
        {
            j2 = 0;
        } else
        {
            j2 = r.hashCode();
        }
        if (s == null)
        {
            k2 = 0;
        } else
        {
            k2 = s.hashCode();
        }
        if (t == null)
        {
            l2 = 0;
        } else
        {
            l2 = t.hashCode();
        }
        i1 = l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (c != null) goto _L8; else goto _L7
_L7:
        j1 = i1 * 31;
_L23:
        if (u == null)
        {
            i1 = 0;
        } else
        {
            i1 = u.hashCode();
        }
        i1 += j1 * 31;
        if (v != null) goto _L10; else goto _L9
_L9:
        j1 = i1 * 31;
_L26:
        if (w != null) goto _L12; else goto _L11
_L11:
        j1 *= 31;
_L29:
        if (x)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        if (y == null)
        {
            k1 = 0;
        } else
        {
            k1 = y.hashCode();
        }
        if (z)
        {
            l1 = 1;
        } else
        {
            l1 = 2;
        }
        if (A == null)
        {
            i2 = 0;
        } else
        {
            i2 = A.hashCode();
        }
        if (B)
        {
            j2 = ((flag1) ? 1 : 0);
        } else
        {
            j2 = 2;
        }
        if (O == null)
        {
            k2 = ((flag) ? 1 : 0);
        } else
        {
            k2 = O.hashCode();
        }
        return ((i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31 + j2) * 31 + k2;
_L2:
        k1 = 0;
_L15:
        j1 = i1;
        if (k1 >= k.length) goto _L14; else goto _L13
_L13:
        if (k[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = k[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L15
          goto _L14
_L4:
        k1 = 0;
        i1 = j1;
_L18:
        j1 = i1;
        if (k1 >= l.length) goto _L17; else goto _L16
_L16:
        if (l[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = l[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L18
          goto _L17
_L6:
        k1 = 0;
        i1 = j1;
_L21:
        j1 = i1;
        if (k1 >= m.length) goto _L20; else goto _L19
_L19:
        if (m[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = m[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L21
          goto _L20
_L8:
        k1 = 0;
_L24:
        j1 = i1;
        if (k1 >= c.length) goto _L23; else goto _L22
_L22:
        i1 = i1 * 31 + c[k1];
        k1++;
          goto _L24
          goto _L23
_L10:
        k1 = 0;
_L27:
        j1 = i1;
        if (k1 >= v.length) goto _L26; else goto _L25
_L25:
        if (v[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = v[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L27
          goto _L26
_L12:
        k1 = 0;
        i1 = j1;
_L30:
        j1 = i1;
        if (k1 >= w.length) goto _L29; else goto _L28
_L28:
        if (w[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = w[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L30
    }
}
