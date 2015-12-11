// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class edd extends eul
{

    public dnl a;
    public String b;
    public String c;
    public String d;
    public int e;
    public String f;
    public boolean g;
    public dub h;
    public int i[];
    public String j;
    private boolean k;
    private String l;
    private String m;
    private int n;
    private dkz o;

    public edd()
    {
        a = null;
        b = "";
        c = "";
        d = "";
        e = 0;
        f = "";
        g = false;
        k = false;
        h = null;
        l = "";
        m = "";
        n = 1;
        i = eup.a;
        j = "";
        o = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        if (a != null)
        {
            j1 = euj.b(1, a) + 0;
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
            j1 = i1 + euj.b(4, c);
        }
        i1 = j1;
        if (!d.equals(""))
        {
            i1 = j1 + euj.b(6, d);
        }
        j1 = i1;
        if (e != 0)
        {
            j1 = i1 + euj.d(7, e);
        }
        i1 = j1;
        if (!f.equals(""))
        {
            i1 = j1 + euj.b(8, f);
        }
        j1 = i1;
        if (g)
        {
            boolean flag1 = g;
            j1 = i1 + (euj.b(9) + 1);
        }
        i1 = j1;
        if (k)
        {
            boolean flag2 = k;
            i1 = j1 + (euj.b(10) + 1);
        }
        j1 = i1;
        if (h != null)
        {
            j1 = i1 + euj.b(11, h);
        }
        i1 = j1;
        if (!l.equals(""))
        {
            i1 = j1 + euj.b(12, l);
        }
        j1 = i1;
        if (!m.equals(""))
        {
            j1 = i1 + euj.b(13, m);
        }
        i1 = j1;
        if (n != 1)
        {
            i1 = j1 + euj.c(14, n);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1;
            if (i.length > 0)
            {
                int ai[] = i;
                int l1 = ai.length;
                int k1 = 0;
                for (j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
                {
                    k1 += euj.a(ai[j1]);
                }

                j1 = i1 + k1 + i.length * 1;
            }
        }
        i1 = j1;
        if (!j.equals(""))
        {
            i1 = j1 + euj.b(16, j);
        }
        j1 = i1;
        if (o != null)
        {
            j1 = i1 + euj.b(17, o);
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
                if (a == null)
                {
                    a = new dnl();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 34: // '"'
                c = eui1.f();
                break;

            case 50: // '2'
                d = eui1.f();
                break;

            case 56: // '8'
                e = eui1.h();
                break;

            case 66: // 'B'
                f = eui1.f();
                break;

            case 72: // 'H'
                g = eui1.e();
                break;

            case 80: // 'P'
                k = eui1.e();
                break;

            case 90: // 'Z'
                if (h == null)
                {
                    h = new dub();
                }
                eui1.a(h);
                break;

            case 98: // 'b'
                l = eui1.f();
                break;

            case 106: // 'j'
                m = eui1.f();
                break;

            case 112: // 'p'
                int j1 = eui1.d();
                if (j1 == 1)
                {
                    n = j1;
                } else
                {
                    n = 1;
                }
                break;

            case 120: // 'x'
                int l1 = eup.a(eui1, 120);
                int k1 = i.length;
                int ai[] = new int[l1 + k1];
                System.arraycopy(i, 0, ai, 0, k1);
                for (i = ai; k1 < i.length - 1; k1++)
                {
                    i[k1] = eui1.d();
                    eui1.a();
                }

                i[k1] = eui1.d();
                break;

            case 130: 
                j = eui1.f();
                break;

            case 138: 
                if (o == null)
                {
                    o = new dkz();
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
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (!c.equals(""))
        {
            euj1.a(4, c);
        }
        if (!d.equals(""))
        {
            euj1.a(6, d);
        }
        if (e != 0)
        {
            euj1.b(7, e);
        }
        if (!f.equals(""))
        {
            euj1.a(8, f);
        }
        if (g)
        {
            euj1.a(9, g);
        }
        if (k)
        {
            euj1.a(10, k);
        }
        if (h != null)
        {
            euj1.a(11, h);
        }
        if (!l.equals(""))
        {
            euj1.a(12, l);
        }
        if (!m.equals(""))
        {
            euj1.a(13, m);
        }
        if (n != 1)
        {
            euj1.a(14, n);
        }
        if (i != null)
        {
            int ai[] = i;
            int j1 = ai.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                euj1.a(15, ai[i1]);
            }

        }
        if (!j.equals(""))
        {
            euj1.a(16, j);
        }
        if (o != null)
        {
            euj1.a(17, o);
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
            if (!(obj instanceof edd))
            {
                return false;
            }
            obj = (edd)obj;
            if ((a != null ? a.equals(((edd) (obj)).a) : ((edd) (obj)).a == null) && (b != null ? b.equals(((edd) (obj)).b) : ((edd) (obj)).b == null) && (c != null ? c.equals(((edd) (obj)).c) : ((edd) (obj)).c == null) && (d != null ? d.equals(((edd) (obj)).d) : ((edd) (obj)).d == null) && e == ((edd) (obj)).e && (f != null ? f.equals(((edd) (obj)).f) : ((edd) (obj)).f == null) && (g == ((edd) (obj)).g && k == ((edd) (obj)).k) && (h != null ? h.equals(((edd) (obj)).h) : ((edd) (obj)).h == null) && (l != null ? l.equals(((edd) (obj)).l) : ((edd) (obj)).l == null) && (m != null ? m.equals(((edd) (obj)).m) : ((edd) (obj)).m == null) && (n == ((edd) (obj)).n && Arrays.equals(i, ((edd) (obj)).i)) && (j != null ? j.equals(((edd) (obj)).j) : ((edd) (obj)).j == null) && (o != null ? o.equals(((edd) (obj)).o) : ((edd) (obj)).o == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((edd) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((edd) (obj)).O))
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
        int k2 = 1;
        boolean flag = false;
        int k3 = getClass().getName().hashCode();
        int i2;
        int j2;
        int l2;
        int i3;
        int j3;
        int l3;
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
        l3 = e;
        if (f == null)
        {
            i2 = 0;
        } else
        {
            i2 = f.hashCode();
        }
        if (g)
        {
            j2 = 1;
        } else
        {
            j2 = 2;
        }
        if (!k)
        {
            k2 = 2;
        }
        if (h == null)
        {
            l2 = 0;
        } else
        {
            l2 = h.hashCode();
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
        i1 = (j3 + (i3 + (l2 + ((j2 + (i2 + ((l1 + (k1 + (j1 + (i1 + (k3 + 527) * 31) * 31) * 31) * 31) * 31 + l3) * 31) * 31) * 31 + k2) * 31) * 31) * 31) * 31 + n;
        if (i != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L4:
        if (j == null)
        {
            i1 = 0;
        } else
        {
            i1 = j.hashCode();
        }
        if (o == null)
        {
            k1 = 0;
        } else
        {
            k1 = o.hashCode();
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
_L5:
        j1 = i1;
        if (k1 >= i.length) goto _L4; else goto _L3
_L3:
        i1 = i1 * 31 + i[k1];
        k1++;
          goto _L5
    }
}
