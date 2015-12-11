// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dip extends eul
{

    public String a;
    public int b;
    public long c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public String i;
    public ddr j;
    public dkz k;
    private String l;
    private boolean m;
    private long n;
    private String o;
    private String p;
    private String q;
    private int r;
    private dny s;
    private boolean t;
    private boolean u;
    private drg v;
    private boolean w;

    public dip()
    {
        l = "";
        a = "";
        b = 0;
        c = 0L;
        d = 0;
        e = 0;
        f = 0;
        m = false;
        g = false;
        h = false;
        i = "";
        n = 0L;
        o = "";
        p = "";
        q = "";
        r = 0;
        j = null;
        s = null;
        t = false;
        u = false;
        k = null;
        v = null;
        w = false;
    }

    public final int a()
    {
        int j1 = 0;
        if (!l.equals(""))
        {
            j1 = euj.b(1, l) + 0;
        }
        int i1 = j1;
        if (!a.equals(""))
        {
            i1 = j1 + euj.b(3, a);
        }
        j1 = i1;
        if (b != 0)
        {
            j1 = i1 + euj.d(4, b);
        }
        i1 = j1;
        if (c != 0L)
        {
            i1 = j1 + euj.d(5, c);
        }
        j1 = i1;
        if (d != 0)
        {
            j1 = i1 + euj.d(6, d);
        }
        i1 = j1;
        if (e != 0)
        {
            i1 = j1 + euj.d(7, e);
        }
        j1 = i1;
        if (f != 0)
        {
            j1 = i1 + euj.d(8, f);
        }
        i1 = j1;
        if (m)
        {
            boolean flag = m;
            i1 = j1 + (euj.b(9) + 1);
        }
        j1 = i1;
        if (g)
        {
            boolean flag1 = g;
            j1 = i1 + (euj.b(10) + 1);
        }
        i1 = j1;
        if (h)
        {
            boolean flag2 = h;
            i1 = j1 + (euj.b(11) + 1);
        }
        j1 = i1;
        if (!i.equals(""))
        {
            j1 = i1 + euj.b(12, i);
        }
        i1 = j1;
        if (n != 0L)
        {
            i1 = j1 + euj.c(13, n);
        }
        j1 = i1;
        if (!o.equals(""))
        {
            j1 = i1 + euj.b(15, o);
        }
        i1 = j1;
        if (!p.equals(""))
        {
            i1 = j1 + euj.b(16, p);
        }
        j1 = i1;
        if (!q.equals(""))
        {
            j1 = i1 + euj.b(19, q);
        }
        i1 = j1;
        if (r != 0)
        {
            i1 = j1 + euj.c(20, r);
        }
        j1 = i1;
        if (j != null)
        {
            j1 = i1 + euj.b(21, j);
        }
        i1 = j1;
        if (s != null)
        {
            i1 = j1 + euj.b(22, s);
        }
        j1 = i1;
        if (t)
        {
            boolean flag3 = t;
            j1 = i1 + (euj.b(23) + 1);
        }
        i1 = j1;
        if (u)
        {
            boolean flag4 = u;
            i1 = j1 + (euj.b(24) + 1);
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1 + euj.b(25, k);
        }
        i1 = j1;
        if (v != null)
        {
            i1 = j1 + euj.b(26, v);
        }
        j1 = i1;
        if (w)
        {
            boolean flag5 = w;
            j1 = i1 + (euj.b(27) + 1);
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
                l = eui1.f();
                break;

            case 26: // '\032'
                a = eui1.f();
                break;

            case 32: // ' '
                b = eui1.h();
                break;

            case 40: // '('
                c = eui1.c();
                break;

            case 48: // '0'
                d = eui1.h();
                break;

            case 56: // '8'
                e = eui1.h();
                break;

            case 64: // '@'
                f = eui1.h();
                break;

            case 72: // 'H'
                m = eui1.e();
                break;

            case 80: // 'P'
                g = eui1.e();
                break;

            case 88: // 'X'
                h = eui1.e();
                break;

            case 98: // 'b'
                i = eui1.f();
                break;

            case 104: // 'h'
                n = eui1.b();
                break;

            case 122: // 'z'
                o = eui1.f();
                break;

            case 130: 
                p = eui1.f();
                break;

            case 154: 
                q = eui1.f();
                break;

            case 160: 
                int j1 = eui1.d();
                if (j1 == 0 || j1 == 1 || j1 == 2)
                {
                    r = j1;
                } else
                {
                    r = 0;
                }
                break;

            case 170: 
                if (j == null)
                {
                    j = new ddr();
                }
                eui1.a(j);
                break;

            case 178: 
                if (s == null)
                {
                    s = new dny();
                }
                eui1.a(s);
                break;

            case 184: 
                t = eui1.e();
                break;

            case 192: 
                u = eui1.e();
                break;

            case 202: 
                if (k == null)
                {
                    k = new dkz();
                }
                eui1.a(k);
                break;

            case 210: 
                if (v == null)
                {
                    v = new drg();
                }
                eui1.a(v);
                break;

            case 216: 
                w = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!l.equals(""))
        {
            euj1.a(1, l);
        }
        if (!a.equals(""))
        {
            euj1.a(3, a);
        }
        if (b != 0)
        {
            euj1.b(4, b);
        }
        if (c != 0L)
        {
            euj1.b(5, c);
        }
        if (d != 0)
        {
            euj1.b(6, d);
        }
        if (e != 0)
        {
            euj1.b(7, e);
        }
        if (f != 0)
        {
            euj1.b(8, f);
        }
        if (m)
        {
            euj1.a(9, m);
        }
        if (g)
        {
            euj1.a(10, g);
        }
        if (h)
        {
            euj1.a(11, h);
        }
        if (!i.equals(""))
        {
            euj1.a(12, i);
        }
        if (n != 0L)
        {
            euj1.a(13, n);
        }
        if (!o.equals(""))
        {
            euj1.a(15, o);
        }
        if (!p.equals(""))
        {
            euj1.a(16, p);
        }
        if (!q.equals(""))
        {
            euj1.a(19, q);
        }
        if (r != 0)
        {
            euj1.a(20, r);
        }
        if (j != null)
        {
            euj1.a(21, j);
        }
        if (s != null)
        {
            euj1.a(22, s);
        }
        if (t)
        {
            euj1.a(23, t);
        }
        if (u)
        {
            euj1.a(24, u);
        }
        if (k != null)
        {
            euj1.a(25, k);
        }
        if (v != null)
        {
            euj1.a(26, v);
        }
        if (w)
        {
            euj1.a(27, w);
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
            if (!(obj instanceof dip))
            {
                return false;
            }
            obj = (dip)obj;
            if ((l != null ? l.equals(((dip) (obj)).l) : ((dip) (obj)).l == null) && (a != null ? a.equals(((dip) (obj)).a) : ((dip) (obj)).a == null) && (b == ((dip) (obj)).b && c == ((dip) (obj)).c && d == ((dip) (obj)).d && e == ((dip) (obj)).e && f == ((dip) (obj)).f && m == ((dip) (obj)).m && g == ((dip) (obj)).g && h == ((dip) (obj)).h) && (i != null ? i.equals(((dip) (obj)).i) : ((dip) (obj)).i == null) && n == ((dip) (obj)).n && (o != null ? o.equals(((dip) (obj)).o) : ((dip) (obj)).o == null) && (p != null ? p.equals(((dip) (obj)).p) : ((dip) (obj)).p == null) && (q != null ? q.equals(((dip) (obj)).q) : ((dip) (obj)).q == null) && r == ((dip) (obj)).r && (j != null ? j.equals(((dip) (obj)).j) : ((dip) (obj)).j == null) && (s != null ? s.equals(((dip) (obj)).s) : ((dip) (obj)).s == null) && (t == ((dip) (obj)).t && u == ((dip) (obj)).u) && (k != null ? k.equals(((dip) (obj)).k) : ((dip) (obj)).k == null) && (v != null ? v.equals(((dip) (obj)).v) : ((dip) (obj)).v == null) && w == ((dip) (obj)).w)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dip) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dip) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l4 = 1;
        int i5 = 0;
        int j5 = getClass().getName().hashCode();
        int i1;
        int j1;
        int k1;
        int l1;
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
        int k5;
        int l5;
        int i6;
        int j6;
        int k6;
        int l6;
        int i7;
        if (l == null)
        {
            i1 = 0;
        } else
        {
            i1 = l.hashCode();
        }
        if (a == null)
        {
            j1 = 0;
        } else
        {
            j1 = a.hashCode();
        }
        k5 = b;
        l5 = (int)(c ^ c >>> 32);
        i6 = d;
        j6 = e;
        k6 = f;
        if (m)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (g)
        {
            l1 = 1;
        } else
        {
            l1 = 2;
        }
        if (h)
        {
            i2 = 1;
        } else
        {
            i2 = 2;
        }
        if (i == null)
        {
            j2 = 0;
        } else
        {
            j2 = i.hashCode();
        }
        l6 = (int)(n ^ n >>> 32);
        if (o == null)
        {
            k2 = 0;
        } else
        {
            k2 = o.hashCode();
        }
        if (p == null)
        {
            l2 = 0;
        } else
        {
            l2 = p.hashCode();
        }
        if (q == null)
        {
            i3 = 0;
        } else
        {
            i3 = q.hashCode();
        }
        i7 = r;
        if (j == null)
        {
            j3 = 0;
        } else
        {
            j3 = j.hashCode();
        }
        if (s == null)
        {
            k3 = 0;
        } else
        {
            k3 = s.hashCode();
        }
        if (t)
        {
            l3 = 1;
        } else
        {
            l3 = 2;
        }
        if (u)
        {
            i4 = 1;
        } else
        {
            i4 = 2;
        }
        if (k == null)
        {
            j4 = 0;
        } else
        {
            j4 = k.hashCode();
        }
        if (v == null)
        {
            k4 = 0;
        } else
        {
            k4 = v.hashCode();
        }
        if (!w)
        {
            l4 = 2;
        }
        if (O != null)
        {
            i5 = O.hashCode();
        }
        return ((k4 + (j4 + (i4 + (l3 + (k3 + (j3 + ((i3 + (l2 + (k2 + ((j2 + (i2 + (l1 + (k1 + ((((((j1 + (i1 + (j5 + 527) * 31) * 31) * 31 + k5) * 31 + l5) * 31 + i6) * 31 + j6) * 31 + k6) * 31) * 31) * 31) * 31) * 31 + l6) * 31) * 31) * 31) * 31 + i7) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l4) * 31 + i5;
    }
}
