// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class duk extends eul
{

    public static final duk a[] = new duk[0];
    private String b;
    private String c;
    private String d;
    private int e;
    private float f;
    private float g;
    private String h;
    private String i;
    private String j;
    private String k;
    private int l;
    private int m;
    private String n;
    private byte o[];
    private String p;
    private String q;
    private boolean r;
    private boolean s;
    private boolean t;
    private duh u[];
    private String v;
    private String w;

    public duk()
    {
        b = "";
        c = "";
        d = "";
        e = 0;
        f = 0.0F;
        g = 0.0F;
        h = "";
        i = "";
        j = "";
        k = "";
        l = 0;
        m = 0;
        n = "";
        o = eup.f;
        p = "";
        q = "";
        r = false;
        s = false;
        t = false;
        u = duh.a;
        v = "";
        w = "";
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (!b.equals(""))
        {
            j1 = euj.b(2, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (!c.equals(""))
        {
            i1 = j1 + euj.b(3, c);
        }
        j1 = i1;
        if (!d.equals(""))
        {
            j1 = i1 + euj.b(5, d);
        }
        i1 = j1;
        if (e != 0)
        {
            i1 = j1 + euj.c(6, e);
        }
        j1 = i1;
        if (f != 0.0F)
        {
            float f1 = f;
            j1 = i1 + (euj.b(7) + 4);
        }
        i1 = j1;
        if (g != 0.0F)
        {
            float f2 = g;
            i1 = j1 + (euj.b(8) + 4);
        }
        j1 = i1;
        if (!h.equals(""))
        {
            j1 = i1 + euj.b(9, h);
        }
        i1 = j1;
        if (!i.equals(""))
        {
            i1 = j1 + euj.b(10, i);
        }
        j1 = i1;
        if (!j.equals(""))
        {
            j1 = i1 + euj.b(11, j);
        }
        i1 = j1;
        if (!k.equals(""))
        {
            i1 = j1 + euj.b(12, k);
        }
        j1 = i1;
        if (l != 0)
        {
            j1 = i1 + euj.c(13, l);
        }
        i1 = j1;
        if (m != 0)
        {
            i1 = j1 + euj.d(14, m);
        }
        j1 = i1;
        if (!n.equals(""))
        {
            j1 = i1 + euj.b(15, n);
        }
        i1 = j1;
        if (!Arrays.equals(o, eup.f))
        {
            i1 = j1 + euj.b(16, o);
        }
        j1 = i1;
        if (!p.equals(""))
        {
            j1 = i1 + euj.b(17, p);
        }
        i1 = j1;
        if (!q.equals(""))
        {
            i1 = j1 + euj.b(18, q);
        }
        j1 = i1;
        if (r)
        {
            boolean flag1 = r;
            j1 = i1 + (euj.b(19) + 1);
        }
        k1 = j1;
        if (s)
        {
            boolean flag2 = s;
            k1 = j1 + (euj.b(20) + 1);
        }
        i1 = k1;
        if (t)
        {
            boolean flag3 = t;
            i1 = k1 + (euj.b(21) + 1);
        }
        j1 = i1;
        if (u != null)
        {
            duh aduh[] = u;
            int i2 = aduh.length;
            int l1 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (l1 >= i2)
                {
                    break;
                }
                duh duh1 = aduh[l1];
                j1 = i1;
                if (duh1 != null)
                {
                    j1 = i1 + euj.b(22, duh1);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (!v.equals(""))
        {
            i1 = j1 + euj.b(23, v);
        }
        j1 = i1;
        if (!w.equals(""))
        {
            j1 = i1 + euj.b(24, w);
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

            case 18: // '\022'
                b = eui1.f();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 42: // '*'
                d = eui1.f();
                break;

            case 48: // '0'
                int j1 = eui1.d();
                if (j1 == 0 || j1 == 1 || j1 == 2 || j1 == 3 || j1 == 4 || j1 == 5 || j1 == 6 || j1 == 7 || j1 == 8 || j1 == 9 || j1 == 10 || j1 == 11 || j1 == 12 || j1 == 13 || j1 == 14 || j1 == 15 || j1 == 16 || j1 == 17 || j1 == 18 || j1 == 19 || j1 == 20 || j1 == 21 || j1 == 22 || j1 == 23 || j1 == 24)
                {
                    e = j1;
                } else
                {
                    e = 0;
                }
                break;

            case 61: // '='
                f = Float.intBitsToFloat(eui1.i());
                break;

            case 69: // 'E'
                g = Float.intBitsToFloat(eui1.i());
                break;

            case 74: // 'J'
                h = eui1.f();
                break;

            case 82: // 'R'
                i = eui1.f();
                break;

            case 90: // 'Z'
                j = eui1.f();
                break;

            case 98: // 'b'
                k = eui1.f();
                break;

            case 104: // 'h'
                int k1 = eui1.d();
                if (k1 == 0 || k1 == 1 || k1 == 2)
                {
                    l = k1;
                } else
                {
                    l = 0;
                }
                break;

            case 112: // 'p'
                m = eui1.h();
                break;

            case 122: // 'z'
                n = eui1.f();
                break;

            case 130: 
                o = eui1.g();
                break;

            case 138: 
                p = eui1.f();
                break;

            case 146: 
                q = eui1.f();
                break;

            case 152: 
                r = eui1.e();
                break;

            case 160: 
                s = eui1.e();
                break;

            case 168: 
                t = eui1.e();
                break;

            case 178: 
                int i2 = eup.a(eui1, 178);
                duh aduh[];
                int l1;
                if (u == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = u.length;
                }
                aduh = new duh[i2 + l1];
                if (u != null)
                {
                    System.arraycopy(u, 0, aduh, 0, l1);
                }
                for (u = aduh; l1 < u.length - 1; l1++)
                {
                    u[l1] = new duh();
                    eui1.a(u[l1]);
                    eui1.a();
                }

                u[l1] = new duh();
                eui1.a(u[l1]);
                break;

            case 186: 
                v = eui1.f();
                break;

            case 194: 
                w = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (!d.equals(""))
        {
            euj1.a(5, d);
        }
        if (e != 0)
        {
            euj1.a(6, e);
        }
        if (f != 0.0F)
        {
            euj1.a(7, f);
        }
        if (g != 0.0F)
        {
            euj1.a(8, g);
        }
        if (!h.equals(""))
        {
            euj1.a(9, h);
        }
        if (!i.equals(""))
        {
            euj1.a(10, i);
        }
        if (!j.equals(""))
        {
            euj1.a(11, j);
        }
        if (!k.equals(""))
        {
            euj1.a(12, k);
        }
        if (l != 0)
        {
            euj1.a(13, l);
        }
        if (m != 0)
        {
            euj1.b(14, m);
        }
        if (!n.equals(""))
        {
            euj1.a(15, n);
        }
        if (!Arrays.equals(o, eup.f))
        {
            euj1.a(16, o);
        }
        if (!p.equals(""))
        {
            euj1.a(17, p);
        }
        if (!q.equals(""))
        {
            euj1.a(18, q);
        }
        if (r)
        {
            euj1.a(19, r);
        }
        if (s)
        {
            euj1.a(20, s);
        }
        if (t)
        {
            euj1.a(21, t);
        }
        if (u != null)
        {
            duh aduh[] = u;
            int j1 = aduh.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                duh duh1 = aduh[i1];
                if (duh1 != null)
                {
                    euj1.a(22, duh1);
                }
            }

        }
        if (!v.equals(""))
        {
            euj1.a(23, v);
        }
        if (!w.equals(""))
        {
            euj1.a(24, w);
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
            if (!(obj instanceof duk))
            {
                return false;
            }
            obj = (duk)obj;
            if ((b != null ? b.equals(((duk) (obj)).b) : ((duk) (obj)).b == null) && (c != null ? c.equals(((duk) (obj)).c) : ((duk) (obj)).c == null) && (d != null ? d.equals(((duk) (obj)).d) : ((duk) (obj)).d == null) && (e == ((duk) (obj)).e && f == ((duk) (obj)).f && g == ((duk) (obj)).g) && (h != null ? h.equals(((duk) (obj)).h) : ((duk) (obj)).h == null) && (i != null ? i.equals(((duk) (obj)).i) : ((duk) (obj)).i == null) && (j != null ? j.equals(((duk) (obj)).j) : ((duk) (obj)).j == null) && (k != null ? k.equals(((duk) (obj)).k) : ((duk) (obj)).k == null) && (l == ((duk) (obj)).l && m == ((duk) (obj)).m) && (n != null ? n.equals(((duk) (obj)).n) : ((duk) (obj)).n == null) && Arrays.equals(o, ((duk) (obj)).o) && (p != null ? p.equals(((duk) (obj)).p) : ((duk) (obj)).p == null) && (q != null ? q.equals(((duk) (obj)).q) : ((duk) (obj)).q == null) && (r == ((duk) (obj)).r && s == ((duk) (obj)).s && t == ((duk) (obj)).t && Arrays.equals(u, ((duk) (obj)).u)) && (v != null ? v.equals(((duk) (obj)).v) : ((duk) (obj)).v == null) && (w != null ? w.equals(((duk) (obj)).w) : ((duk) (obj)).w == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((duk) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((duk) (obj)).O))
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
        boolean flag1 = true;
        boolean flag = false;
        int i3 = getClass().getName().hashCode();
        int k2;
        int l2;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        if (b == null)
        {
            i1 = 0;
        } else
        {
            i1 = b.hashCode();
        }
        if (c == null)
        {
            j1 = 0;
        } else
        {
            j1 = c.hashCode();
        }
        if (d == null)
        {
            k1 = 0;
        } else
        {
            k1 = d.hashCode();
        }
        j3 = e;
        k3 = Float.floatToIntBits(f);
        l3 = Float.floatToIntBits(g);
        if (h == null)
        {
            l1 = 0;
        } else
        {
            l1 = h.hashCode();
        }
        if (i == null)
        {
            i2 = 0;
        } else
        {
            i2 = i.hashCode();
        }
        if (j == null)
        {
            j2 = 0;
        } else
        {
            j2 = j.hashCode();
        }
        if (k == null)
        {
            k2 = 0;
        } else
        {
            k2 = k.hashCode();
        }
        i4 = l;
        j4 = m;
        if (n == null)
        {
            l2 = 0;
        } else
        {
            l2 = n.hashCode();
        }
        i1 = l2 + (((k2 + (j2 + (i2 + (l1 + ((((k1 + (j1 + (i1 + (i3 + 527) * 31) * 31) * 31) * 31 + j3) * 31 + k3) * 31 + l3) * 31) * 31) * 31) * 31) * 31 + i4) * 31 + j4) * 31;
        if (o != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L6:
        if (p == null)
        {
            i1 = 0;
        } else
        {
            i1 = p.hashCode();
        }
        if (q == null)
        {
            k1 = 0;
        } else
        {
            k1 = q.hashCode();
        }
        if (r)
        {
            l1 = 1;
        } else
        {
            l1 = 2;
        }
        if (s)
        {
            i2 = 1;
        } else
        {
            i2 = 2;
        }
        if (t)
        {
            j2 = ((flag1) ? 1 : 0);
        } else
        {
            j2 = 2;
        }
        i1 = (i2 + (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31 + j2;
        if (u != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L9:
        if (v == null)
        {
            i1 = 0;
        } else
        {
            i1 = v.hashCode();
        }
        if (w == null)
        {
            k1 = 0;
        } else
        {
            k1 = w.hashCode();
        }
        if (O == null)
        {
            l1 = ((flag) ? 1 : 0);
        } else
        {
            l1 = O.hashCode();
        }
        return (k1 + (i1 + j1 * 31) * 31) * 31 + l1;
_L2:
        k1 = 0;
_L7:
        j1 = i1;
        if (k1 >= o.length) goto _L6; else goto _L5
_L5:
        i1 = i1 * 31 + o[k1];
        k1++;
          goto _L7
          goto _L6
_L4:
        k1 = 0;
_L10:
        j1 = i1;
        if (k1 >= u.length) goto _L9; else goto _L8
_L8:
        if (u[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = u[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L10
    }

}
