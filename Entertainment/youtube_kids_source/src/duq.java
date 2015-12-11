// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class duq extends eul
{

    public String a;
    public dus b[];
    public int c;
    public String d;
    public int e;
    public boolean f;
    public doy g;
    public dlb h;
    public byte i[];
    private dlb j;
    private boolean k;
    private int l;
    private String m;
    private duw n[];
    private dlb o;
    private dlb p;
    private int q;
    private dfq r[];
    private dlb s;
    private boolean t;
    private dre u;
    private dur v;
    private dqi w;
    private int x;

    public duq()
    {
        a = "";
        b = dus.a;
        c = 0;
        d = "";
        e = 0;
        j = null;
        f = false;
        k = false;
        l = 0;
        m = "";
        g = null;
        n = duw.a;
        o = null;
        p = null;
        h = null;
        q = 0;
        i = eup.f;
        r = dfq.a;
        s = null;
        t = false;
        u = null;
        v = null;
        w = null;
        x = 0;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        if (!a.equals(""))
        {
            i1 = euj.b(1, a) + 0;
        } else
        {
            i1 = 0;
        }
        j1 = i1;
        if (b != null)
        {
            dus adus[] = b;
            int j2 = adus.length;
            int k1 = 0;
            do
            {
                j1 = i1;
                if (k1 >= j2)
                {
                    break;
                }
                dus dus1 = adus[k1];
                j1 = i1;
                if (dus1 != null)
                {
                    j1 = i1 + euj.b(2, dus1);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (c != 0)
        {
            i1 = j1 + euj.c(3, c);
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
        if (j != null)
        {
            j1 = i1 + euj.b(7, j);
        }
        i1 = j1;
        if (f)
        {
            boolean flag1 = f;
            i1 = j1 + (euj.b(8) + 1);
        }
        j1 = i1;
        if (k)
        {
            boolean flag2 = k;
            j1 = i1 + (euj.b(11) + 1);
        }
        i1 = j1;
        if (l != 0)
        {
            i1 = j1 + euj.c(12, l);
        }
        j1 = i1;
        if (!m.equals(""))
        {
            j1 = i1 + euj.b(13, m);
        }
        i1 = j1;
        if (g != null)
        {
            i1 = j1 + euj.b(14, g);
        }
        j1 = i1;
        if (n != null)
        {
            duw aduw[] = n;
            int k2 = aduw.length;
            int l1 = 0;
            do
            {
                j1 = i1;
                if (l1 >= k2)
                {
                    break;
                }
                duw duw1 = aduw[l1];
                j1 = i1;
                if (duw1 != null)
                {
                    j1 = i1 + euj.b(15, duw1);
                }
                l1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (o != null)
        {
            i1 = j1 + euj.b(16, o);
        }
        j1 = i1;
        if (p != null)
        {
            j1 = i1 + euj.b(17, p);
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1 + euj.b(18, h);
        }
        j1 = i1;
        if (q != 0)
        {
            j1 = i1 + euj.c(19, q);
        }
        i1 = j1;
        if (!Arrays.equals(i, eup.f))
        {
            i1 = j1 + euj.b(20, i);
        }
        j1 = i1;
        if (r != null)
        {
            dfq adfq[] = r;
            int l2 = adfq.length;
            int i2 = ((flag) ? 1 : 0);
            do
            {
                j1 = i1;
                if (i2 >= l2)
                {
                    break;
                }
                dfq dfq1 = adfq[i2];
                j1 = i1;
                if (dfq1 != null)
                {
                    j1 = i1 + euj.b(21, dfq1);
                }
                i2++;
                i1 = j1;
            } while (true);
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
        if (u != null)
        {
            i1 = j1 + euj.b(24, u);
        }
        j1 = i1;
        if (v != null)
        {
            j1 = i1 + euj.b(25, v);
        }
        i1 = j1;
        if (w != null)
        {
            i1 = j1 + euj.b(26, w);
        }
        j1 = i1;
        if (x != 0)
        {
            j1 = i1 + euj.c(27, x);
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
                a = eui1.f();
                break;

            case 18: // '\022'
                int k2 = eup.a(eui1, 18);
                dus adus[];
                int j1;
                if (b == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = b.length;
                }
                adus = new dus[k2 + j1];
                if (b != null)
                {
                    System.arraycopy(b, 0, adus, 0, j1);
                }
                for (b = adus; j1 < b.length - 1; j1++)
                {
                    b[j1] = new dus();
                    eui1.a(b[j1]);
                    eui1.a();
                }

                b[j1] = new dus();
                eui1.a(b[j1]);
                break;

            case 24: // '\030'
                c = eui1.d();
                break;

            case 42: // '*'
                d = eui1.f();
                break;

            case 48: // '0'
                e = eui1.d();
                break;

            case 58: // ':'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 64: // '@'
                f = eui1.e();
                break;

            case 88: // 'X'
                k = eui1.e();
                break;

            case 96: // '`'
                int k1 = eui1.d();
                if (k1 == 0 || k1 == 1 || k1 == 2)
                {
                    l = k1;
                } else
                {
                    l = 0;
                }
                break;

            case 106: // 'j'
                m = eui1.f();
                break;

            case 114: // 'r'
                if (g == null)
                {
                    g = new doy();
                }
                eui1.a(g);
                break;

            case 122: // 'z'
                int l2 = eup.a(eui1, 122);
                duw aduw[];
                int l1;
                if (n == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = n.length;
                }
                aduw = new duw[l2 + l1];
                if (n != null)
                {
                    System.arraycopy(n, 0, aduw, 0, l1);
                }
                for (n = aduw; l1 < n.length - 1; l1++)
                {
                    n[l1] = new duw();
                    eui1.a(n[l1]);
                    eui1.a();
                }

                n[l1] = new duw();
                eui1.a(n[l1]);
                break;

            case 130: 
                if (o == null)
                {
                    o = new dlb();
                }
                eui1.a(o);
                break;

            case 138: 
                if (p == null)
                {
                    p = new dlb();
                }
                eui1.a(p);
                break;

            case 146: 
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 152: 
                int i2 = eui1.d();
                if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3)
                {
                    q = i2;
                } else
                {
                    q = 0;
                }
                break;

            case 162: 
                i = eui1.g();
                break;

            case 170: 
                int i3 = eup.a(eui1, 170);
                dfq adfq[];
                int j2;
                if (r == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = r.length;
                }
                adfq = new dfq[i3 + j2];
                if (r != null)
                {
                    System.arraycopy(r, 0, adfq, 0, j2);
                }
                for (r = adfq; j2 < r.length - 1; j2++)
                {
                    r[j2] = new dfq();
                    eui1.a(r[j2]);
                    eui1.a();
                }

                r[j2] = new dfq();
                eui1.a(r[j2]);
                break;

            case 178: 
                if (s == null)
                {
                    s = new dlb();
                }
                eui1.a(s);
                break;

            case 184: 
                t = eui1.e();
                break;

            case 194: 
                if (u == null)
                {
                    u = new dre();
                }
                eui1.a(u);
                break;

            case 202: 
                if (v == null)
                {
                    v = new dur();
                }
                eui1.a(v);
                break;

            case 210: 
                if (w == null)
                {
                    w = new dqi();
                }
                eui1.a(w);
                break;

            case 216: 
                x = eui1.d();
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
        if (b != null)
        {
            dus adus[] = b;
            int l1 = adus.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                dus dus1 = adus[i1];
                if (dus1 != null)
                {
                    euj1.a(2, dus1);
                }
            }

        }
        if (c != 0)
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
        if (j != null)
        {
            euj1.a(7, j);
        }
        if (f)
        {
            euj1.a(8, f);
        }
        if (k)
        {
            euj1.a(11, k);
        }
        if (l != 0)
        {
            euj1.a(12, l);
        }
        if (!m.equals(""))
        {
            euj1.a(13, m);
        }
        if (g != null)
        {
            euj1.a(14, g);
        }
        if (n != null)
        {
            duw aduw[] = n;
            int i2 = aduw.length;
            for (int j1 = 0; j1 < i2; j1++)
            {
                duw duw1 = aduw[j1];
                if (duw1 != null)
                {
                    euj1.a(15, duw1);
                }
            }

        }
        if (o != null)
        {
            euj1.a(16, o);
        }
        if (p != null)
        {
            euj1.a(17, p);
        }
        if (h != null)
        {
            euj1.a(18, h);
        }
        if (q != 0)
        {
            euj1.a(19, q);
        }
        if (!Arrays.equals(i, eup.f))
        {
            euj1.a(20, i);
        }
        if (r != null)
        {
            dfq adfq[] = r;
            int j2 = adfq.length;
            for (int k1 = ((flag) ? 1 : 0); k1 < j2; k1++)
            {
                dfq dfq1 = adfq[k1];
                if (dfq1 != null)
                {
                    euj1.a(21, dfq1);
                }
            }

        }
        if (s != null)
        {
            euj1.a(22, s);
        }
        if (t)
        {
            euj1.a(23, t);
        }
        if (u != null)
        {
            euj1.a(24, u);
        }
        if (v != null)
        {
            euj1.a(25, v);
        }
        if (w != null)
        {
            euj1.a(26, w);
        }
        if (x != 0)
        {
            euj1.a(27, x);
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
            if (!(obj instanceof duq))
            {
                return false;
            }
            obj = (duq)obj;
            if ((a != null ? a.equals(((duq) (obj)).a) : ((duq) (obj)).a == null) && (Arrays.equals(b, ((duq) (obj)).b) && c == ((duq) (obj)).c) && (d != null ? d.equals(((duq) (obj)).d) : ((duq) (obj)).d == null) && e == ((duq) (obj)).e && (j != null ? j.equals(((duq) (obj)).j) : ((duq) (obj)).j == null) && (f == ((duq) (obj)).f && k == ((duq) (obj)).k && l == ((duq) (obj)).l) && (m != null ? m.equals(((duq) (obj)).m) : ((duq) (obj)).m == null) && (g != null ? g.equals(((duq) (obj)).g) : ((duq) (obj)).g == null) && Arrays.equals(n, ((duq) (obj)).n) && (o != null ? o.equals(((duq) (obj)).o) : ((duq) (obj)).o == null) && (p != null ? p.equals(((duq) (obj)).p) : ((duq) (obj)).p == null) && (h != null ? h.equals(((duq) (obj)).h) : ((duq) (obj)).h == null) && (q == ((duq) (obj)).q && Arrays.equals(i, ((duq) (obj)).i) && Arrays.equals(r, ((duq) (obj)).r)) && (s != null ? s.equals(((duq) (obj)).s) : ((duq) (obj)).s == null) && t == ((duq) (obj)).t && (u != null ? u.equals(((duq) (obj)).u) : ((duq) (obj)).u == null) && (v != null ? v.equals(((duq) (obj)).v) : ((duq) (obj)).v == null) && (w != null ? w.equals(((duq) (obj)).w) : ((duq) (obj)).w == null) && x == ((duq) (obj)).x)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((duq) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((duq) (obj)).O))
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
        int l2 = 1;
        boolean flag = false;
        j1 = getClass().getName().hashCode();
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
        i1 += (j1 + 527) * 31;
        if (b != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L10:
        i3 = c;
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
        }
        j3 = e;
        if (j == null)
        {
            k1 = 0;
        } else
        {
            k1 = j.hashCode();
        }
        if (f)
        {
            l1 = 1;
        } else
        {
            l1 = 2;
        }
        if (k)
        {
            i2 = 1;
        } else
        {
            i2 = 2;
        }
        k3 = l;
        if (m == null)
        {
            j2 = 0;
        } else
        {
            j2 = m.hashCode();
        }
        if (g == null)
        {
            k2 = 0;
        } else
        {
            k2 = g.hashCode();
        }
        i1 = k2 + (j2 + ((i2 + (l1 + (k1 + ((i1 + (j1 * 31 + i3) * 31) * 31 + j3) * 31) * 31) * 31) * 31 + k3) * 31) * 31;
        if (n != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L13:
        if (o == null)
        {
            i1 = 0;
        } else
        {
            i1 = o.hashCode();
        }
        if (p == null)
        {
            k1 = 0;
        } else
        {
            k1 = p.hashCode();
        }
        if (h == null)
        {
            l1 = 0;
        } else
        {
            l1 = h.hashCode();
        }
        j1 = (l1 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31 + q;
        if (i != null) goto _L6; else goto _L5
_L5:
        i1 = j1 * 31;
_L16:
        if (r != null) goto _L8; else goto _L7
_L7:
        j1 = i1 * 31;
_L19:
        if (s == null)
        {
            i1 = 0;
        } else
        {
            i1 = s.hashCode();
        }
        if (t)
        {
            k1 = l2;
        } else
        {
            k1 = 2;
        }
        if (u == null)
        {
            l1 = 0;
        } else
        {
            l1 = u.hashCode();
        }
        if (v == null)
        {
            i2 = 0;
        } else
        {
            i2 = v.hashCode();
        }
        if (w == null)
        {
            j2 = 0;
        } else
        {
            j2 = w.hashCode();
        }
        l2 = x;
        if (O == null)
        {
            k2 = ((flag) ? 1 : 0);
        } else
        {
            k2 = O.hashCode();
        }
        return ((j2 + (i2 + (l1 + ((i1 + j1 * 31) * 31 + k1) * 31) * 31) * 31) * 31 + l2) * 31 + k2;
_L2:
        k1 = 0;
_L11:
        j1 = i1;
        if (k1 >= b.length) goto _L10; else goto _L9
_L9:
        if (b[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = b[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L11
          goto _L10
_L4:
        k1 = 0;
_L14:
        j1 = i1;
        if (k1 >= n.length) goto _L13; else goto _L12
_L12:
        if (n[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = n[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L14
          goto _L13
_L6:
        k1 = 0;
_L17:
        i1 = j1;
        if (k1 >= i.length) goto _L16; else goto _L15
_L15:
        j1 = j1 * 31 + i[k1];
        k1++;
          goto _L17
          goto _L16
_L8:
        k1 = 0;
_L20:
        j1 = i1;
        if (k1 >= r.length) goto _L19; else goto _L18
_L18:
        if (r[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = r[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L20
    }
}
