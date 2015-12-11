// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dhf extends eul
{

    private float A;
    private int B;
    public String a;
    public int b[];
    public String c;
    public String d;
    public int e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public int l;
    public int m;
    public int n;
    private String o;
    private String p;
    private String q;
    private boolean r;
    private String s;
    private int t;
    private String u;
    private String v;
    private int w;
    private int x;
    private int y;
    private float z;

    public dhf()
    {
        o = "";
        p = "";
        a = "";
        b = eup.a;
        q = "";
        r = false;
        c = "";
        d = "";
        e = 0;
        f = "";
        g = "";
        h = "";
        i = "";
        j = "";
        k = "";
        s = "";
        l = 0;
        t = 0;
        m = 0;
        u = "";
        v = "";
        n = 0;
        w = 0;
        x = 0;
        y = 0;
        z = 0.0F;
        A = 0.0F;
        B = 0;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        if (!o.equals(""))
        {
            i1 = euj.b(1, o) + 0;
        } else
        {
            i1 = 0;
        }
        j1 = i1;
        if (!p.equals(""))
        {
            j1 = i1 + euj.b(2, p);
        }
        i1 = j1;
        if (!a.equals(""))
        {
            i1 = j1 + euj.b(8, a);
        }
        j1 = i1;
        if (b != null)
        {
            j1 = i1;
            if (b.length > 0)
            {
                int ai[] = b;
                int l1 = ai.length;
                int k1 = 0;
                for (j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
                {
                    k1 += euj.a(ai[j1]);
                }

                j1 = i1 + k1 + b.length * 1;
            }
        }
        i1 = j1;
        if (!q.equals(""))
        {
            i1 = j1 + euj.b(10, q);
        }
        j1 = i1;
        if (r)
        {
            boolean flag1 = r;
            j1 = i1 + (euj.b(11) + 1);
        }
        i1 = j1;
        if (!c.equals(""))
        {
            i1 = j1 + euj.b(12, c);
        }
        j1 = i1;
        if (!d.equals(""))
        {
            j1 = i1 + euj.b(13, d);
        }
        i1 = j1;
        if (e != 0)
        {
            i1 = j1 + euj.c(16, e);
        }
        j1 = i1;
        if (!f.equals(""))
        {
            j1 = i1 + euj.b(17, f);
        }
        i1 = j1;
        if (!g.equals(""))
        {
            i1 = j1 + euj.b(18, g);
        }
        j1 = i1;
        if (!h.equals(""))
        {
            j1 = i1 + euj.b(19, h);
        }
        i1 = j1;
        if (!i.equals(""))
        {
            i1 = j1 + euj.b(21, i);
        }
        j1 = i1;
        if (!j.equals(""))
        {
            j1 = i1 + euj.b(22, j);
        }
        i1 = j1;
        if (!k.equals(""))
        {
            i1 = j1 + euj.b(25, k);
        }
        j1 = i1;
        if (!s.equals(""))
        {
            j1 = i1 + euj.b(27, s);
        }
        i1 = j1;
        if (l != 0)
        {
            i1 = j1 + euj.c(28, l);
        }
        j1 = i1;
        if (t != 0)
        {
            j1 = i1 + euj.c(29, t);
        }
        i1 = j1;
        if (m != 0)
        {
            i1 = j1 + euj.c(30, m);
        }
        j1 = i1;
        if (!u.equals(""))
        {
            j1 = i1 + euj.b(31, u);
        }
        i1 = j1;
        if (!v.equals(""))
        {
            i1 = j1 + euj.b(34, v);
        }
        j1 = i1;
        if (n != 0)
        {
            j1 = i1 + euj.c(35, n);
        }
        i1 = j1;
        if (w != 0)
        {
            i1 = j1 + euj.c(36, w);
        }
        j1 = i1;
        if (x != 0)
        {
            j1 = i1 + euj.c(37, x);
        }
        i1 = j1;
        if (y != 0)
        {
            i1 = j1 + euj.c(38, y);
        }
        j1 = i1;
        if (z != 0.0F)
        {
            float f1 = z;
            j1 = i1 + (euj.b(39) + 4);
        }
        i1 = j1;
        if (A != 0.0F)
        {
            float f2 = A;
            i1 = j1 + (euj.b(40) + 4);
        }
        j1 = i1;
        if (B != 0)
        {
            j1 = i1 + euj.c(41, B);
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
                o = eui1.f();
                break;

            case 18: // '\022'
                p = eui1.f();
                break;

            case 66: // 'B'
                a = eui1.f();
                break;

            case 72: // 'H'
                int i3 = eup.a(eui1, 72);
                int j1 = b.length;
                int ai[] = new int[i3 + j1];
                System.arraycopy(b, 0, ai, 0, j1);
                for (b = ai; j1 < b.length - 1; j1++)
                {
                    b[j1] = eui1.d();
                    eui1.a();
                }

                b[j1] = eui1.d();
                break;

            case 82: // 'R'
                q = eui1.f();
                break;

            case 88: // 'X'
                r = eui1.e();
                break;

            case 98: // 'b'
                c = eui1.f();
                break;

            case 106: // 'j'
                d = eui1.f();
                break;

            case 128: 
                int k1 = eui1.d();
                if (k1 == 0 || k1 == 1 || k1 == 2 || k1 == 3 || k1 == 5 || k1 == 7 || k1 == 8 || k1 == 10 || k1 == 11 || k1 == 12 || k1 == 13 || k1 == 14 || k1 == 15 || k1 == 16 || k1 == 17 || k1 == 18 || k1 == 19 || k1 == 20 || k1 == 21 || k1 == 22 || k1 == 23 || k1 == 24 || k1 == 25 || k1 == 26 || k1 == 27 || k1 == 28 || k1 == 29 || k1 == 30)
                {
                    e = k1;
                } else
                {
                    e = 0;
                }
                break;

            case 138: 
                f = eui1.f();
                break;

            case 146: 
                g = eui1.f();
                break;

            case 154: 
                h = eui1.f();
                break;

            case 170: 
                i = eui1.f();
                break;

            case 178: 
                j = eui1.f();
                break;

            case 202: 
                k = eui1.f();
                break;

            case 218: 
                s = eui1.f();
                break;

            case 224: 
                int l1 = eui1.d();
                if (l1 == 0 || l1 == 1 || l1 == 2 || l1 == 3 || l1 == 4 || l1 == 5 || l1 == 6)
                {
                    l = l1;
                } else
                {
                    l = 0;
                }
                break;

            case 232: 
                int i2 = eui1.d();
                if (i2 == 0 || i2 == 1 || i2 == 2)
                {
                    t = i2;
                } else
                {
                    t = 0;
                }
                break;

            case 240: 
                int j2 = eui1.d();
                if (j2 == 0 || j2 == 1 || j2 == 2 || j2 == 3 || j2 == 4 || j2 == 5 || j2 == 6 || j2 == 7)
                {
                    m = j2;
                } else
                {
                    m = 0;
                }
                break;

            case 250: 
                u = eui1.f();
                break;

            case 274: 
                v = eui1.f();
                break;

            case 280: 
                int k2 = eui1.d();
                if (k2 == 0 || k2 == 1 || k2 == 2 || k2 == 3)
                {
                    n = k2;
                } else
                {
                    n = 0;
                }
                break;

            case 288: 
                int l2 = eui1.d();
                if (l2 == 0 || l2 == 1 || l2 == 2 || l2 == 3 || l2 == 4 || l2 == 5 || l2 == 6 || l2 == 7 || l2 == 8 || l2 == 9 || l2 == 10 || l2 == 11 || l2 == 12 || l2 == 13)
                {
                    w = l2;
                } else
                {
                    w = 0;
                }
                break;

            case 296: 
                x = eui1.d();
                break;

            case 304: 
                y = eui1.d();
                break;

            case 317: 
                z = Float.intBitsToFloat(eui1.i());
                break;

            case 325: 
                A = Float.intBitsToFloat(eui1.i());
                break;

            case 328: 
                B = eui1.d();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!o.equals(""))
        {
            euj1.a(1, o);
        }
        if (!p.equals(""))
        {
            euj1.a(2, p);
        }
        if (!a.equals(""))
        {
            euj1.a(8, a);
        }
        if (b != null)
        {
            int ai[] = b;
            int j1 = ai.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                euj1.a(9, ai[i1]);
            }

        }
        if (!q.equals(""))
        {
            euj1.a(10, q);
        }
        if (r)
        {
            euj1.a(11, r);
        }
        if (!c.equals(""))
        {
            euj1.a(12, c);
        }
        if (!d.equals(""))
        {
            euj1.a(13, d);
        }
        if (e != 0)
        {
            euj1.a(16, e);
        }
        if (!f.equals(""))
        {
            euj1.a(17, f);
        }
        if (!g.equals(""))
        {
            euj1.a(18, g);
        }
        if (!h.equals(""))
        {
            euj1.a(19, h);
        }
        if (!i.equals(""))
        {
            euj1.a(21, i);
        }
        if (!j.equals(""))
        {
            euj1.a(22, j);
        }
        if (!k.equals(""))
        {
            euj1.a(25, k);
        }
        if (!s.equals(""))
        {
            euj1.a(27, s);
        }
        if (l != 0)
        {
            euj1.a(28, l);
        }
        if (t != 0)
        {
            euj1.a(29, t);
        }
        if (m != 0)
        {
            euj1.a(30, m);
        }
        if (!u.equals(""))
        {
            euj1.a(31, u);
        }
        if (!v.equals(""))
        {
            euj1.a(34, v);
        }
        if (n != 0)
        {
            euj1.a(35, n);
        }
        if (w != 0)
        {
            euj1.a(36, w);
        }
        if (x != 0)
        {
            euj1.a(37, x);
        }
        if (y != 0)
        {
            euj1.a(38, y);
        }
        if (z != 0.0F)
        {
            euj1.a(39, z);
        }
        if (A != 0.0F)
        {
            euj1.a(40, A);
        }
        if (B != 0)
        {
            euj1.a(41, B);
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
            if (!(obj instanceof dhf))
            {
                return false;
            }
            obj = (dhf)obj;
            if ((o != null ? o.equals(((dhf) (obj)).o) : ((dhf) (obj)).o == null) && (p != null ? p.equals(((dhf) (obj)).p) : ((dhf) (obj)).p == null) && (a != null ? a.equals(((dhf) (obj)).a) : ((dhf) (obj)).a == null) && Arrays.equals(b, ((dhf) (obj)).b) && (q != null ? q.equals(((dhf) (obj)).q) : ((dhf) (obj)).q == null) && r == ((dhf) (obj)).r && (c != null ? c.equals(((dhf) (obj)).c) : ((dhf) (obj)).c == null) && (d != null ? d.equals(((dhf) (obj)).d) : ((dhf) (obj)).d == null) && e == ((dhf) (obj)).e && (f != null ? f.equals(((dhf) (obj)).f) : ((dhf) (obj)).f == null) && (g != null ? g.equals(((dhf) (obj)).g) : ((dhf) (obj)).g == null) && (h != null ? h.equals(((dhf) (obj)).h) : ((dhf) (obj)).h == null) && (i != null ? i.equals(((dhf) (obj)).i) : ((dhf) (obj)).i == null) && (j != null ? j.equals(((dhf) (obj)).j) : ((dhf) (obj)).j == null) && (k != null ? k.equals(((dhf) (obj)).k) : ((dhf) (obj)).k == null) && (s != null ? s.equals(((dhf) (obj)).s) : ((dhf) (obj)).s == null) && (l == ((dhf) (obj)).l && t == ((dhf) (obj)).t && m == ((dhf) (obj)).m) && (u != null ? u.equals(((dhf) (obj)).u) : ((dhf) (obj)).u == null) && (v != null ? v.equals(((dhf) (obj)).v) : ((dhf) (obj)).v == null) && (n == ((dhf) (obj)).n && w == ((dhf) (obj)).w && x == ((dhf) (obj)).x && y == ((dhf) (obj)).y && z == ((dhf) (obj)).z && A == ((dhf) (obj)).A && B == ((dhf) (obj)).B))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dhf) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dhf) (obj)).O))
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
        int l4;
        l4 = 0;
        int l1 = getClass().getName().hashCode();
        int i5;
        int j5;
        int k5;
        int l5;
        int i6;
        int j6;
        int k6;
        int l6;
        int i7;
        int j7;
        int k7;
        if (o == null)
        {
            i1 = 0;
        } else
        {
            i1 = o.hashCode();
        }
        if (p == null)
        {
            j1 = 0;
        } else
        {
            j1 = p.hashCode();
        }
        if (a == null)
        {
            k1 = 0;
        } else
        {
            k1 = a.hashCode();
        }
        i1 = k1 + (j1 + (i1 + (l1 + 527) * 31) * 31) * 31;
        if (b != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L4:
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        if (q == null)
        {
            i1 = 0;
        } else
        {
            i1 = q.hashCode();
        }
        if (r)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (c == null)
        {
            i2 = 0;
        } else
        {
            i2 = c.hashCode();
        }
        if (d == null)
        {
            j2 = 0;
        } else
        {
            j2 = d.hashCode();
        }
        i5 = e;
        if (f == null)
        {
            k2 = 0;
        } else
        {
            k2 = f.hashCode();
        }
        if (g == null)
        {
            l2 = 0;
        } else
        {
            l2 = g.hashCode();
        }
        if (h == null)
        {
            i3 = 0;
        } else
        {
            i3 = h.hashCode();
        }
        if (i == null)
        {
            j3 = 0;
        } else
        {
            j3 = i.hashCode();
        }
        if (j == null)
        {
            k3 = 0;
        } else
        {
            k3 = j.hashCode();
        }
        if (k == null)
        {
            l3 = 0;
        } else
        {
            l3 = k.hashCode();
        }
        if (s == null)
        {
            i4 = 0;
        } else
        {
            i4 = s.hashCode();
        }
        j5 = l;
        k5 = t;
        l5 = m;
        if (u == null)
        {
            j4 = 0;
        } else
        {
            j4 = u.hashCode();
        }
        if (v == null)
        {
            k4 = 0;
        } else
        {
            k4 = v.hashCode();
        }
        i6 = n;
        j6 = w;
        k6 = x;
        l6 = y;
        i7 = Float.floatToIntBits(z);
        j7 = Float.floatToIntBits(A);
        k7 = B;
        if (O != null)
        {
            l4 = O.hashCode();
        }
        return ((((((((k4 + (j4 + ((((i4 + (l3 + (k3 + (j3 + (i3 + (l2 + (k2 + ((j2 + (i2 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31 + i5) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + j5) * 31 + k5) * 31 + l5) * 31) * 31) * 31 + i6) * 31 + j6) * 31 + k6) * 31 + l6) * 31 + i7) * 31 + j7) * 31 + k7) * 31 + l4;
_L2:
        k1 = 0;
_L5:
        j1 = i1;
        if (k1 >= b.length) goto _L4; else goto _L3
_L3:
        i1 = i1 * 31 + b[k1];
        k1++;
          goto _L5
    }
}
