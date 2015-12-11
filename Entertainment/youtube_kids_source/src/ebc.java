// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ebc extends eul
{

    public String a;
    public String b;
    public long c;
    public boolean d;
    public dzp e;
    private String f[];
    private String g;
    private boolean h;
    private String i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private float o;
    private boolean p;
    private String q;
    private String r;

    public ebc()
    {
        a = "";
        b = "";
        c = 0L;
        d = false;
        f = eup.d;
        g = "";
        h = false;
        i = "";
        j = false;
        k = false;
        e = null;
        l = false;
        m = false;
        n = 0;
        o = 0.0F;
        p = false;
        q = "";
        r = "";
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
        if (!b.equals(""))
        {
            i1 = j1 + euj.b(15, b);
        }
        j1 = i1;
        if (c != 0L)
        {
            j1 = i1 + euj.c(16, c);
        }
        i1 = j1;
        if (d)
        {
            boolean flag1 = d;
            i1 = j1 + (euj.b(17) + 1);
        }
        j1 = i1;
        if (f != null)
        {
            j1 = i1;
            if (f.length > 0)
            {
                String as[] = f;
                int l1 = as.length;
                int k1 = 0;
                for (j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
                {
                    k1 += euj.a(as[j1]);
                }

                j1 = i1 + k1 + f.length * 2;
            }
        }
        i1 = j1;
        if (!g.equals(""))
        {
            i1 = j1 + euj.b(19, g);
        }
        j1 = i1;
        if (h)
        {
            boolean flag2 = h;
            j1 = i1 + (euj.b(20) + 1);
        }
        i1 = j1;
        if (!i.equals(""))
        {
            i1 = j1 + euj.b(21, i);
        }
        j1 = i1;
        if (j)
        {
            boolean flag3 = j;
            j1 = i1 + (euj.b(22) + 1);
        }
        i1 = j1;
        if (k)
        {
            boolean flag4 = k;
            i1 = j1 + (euj.b(24) + 1);
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1 + euj.b(25, e);
        }
        i1 = j1;
        if (l)
        {
            boolean flag5 = l;
            i1 = j1 + (euj.b(27) + 1);
        }
        j1 = i1;
        if (m)
        {
            boolean flag6 = m;
            j1 = i1 + (euj.b(28) + 1);
        }
        i1 = j1;
        if (n != 0)
        {
            i1 = j1 + euj.d(29, n);
        }
        j1 = i1;
        if (o != 0.0F)
        {
            float f1 = o;
            j1 = i1 + (euj.b(30) + 4);
        }
        i1 = j1;
        if (p)
        {
            boolean flag7 = p;
            i1 = j1 + (euj.b(31) + 1);
        }
        j1 = i1;
        if (!q.equals(""))
        {
            j1 = i1 + euj.b(32, q);
        }
        i1 = j1;
        if (!r.equals(""))
        {
            i1 = j1 + euj.b(33, r);
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

            case 122: // 'z'
                b = eui1.f();
                break;

            case 128: 
                c = eui1.b();
                break;

            case 136: 
                d = eui1.e();
                break;

            case 146: 
                int k1 = eup.a(eui1, 146);
                int j1 = f.length;
                String as[] = new String[k1 + j1];
                System.arraycopy(f, 0, as, 0, j1);
                for (f = as; j1 < f.length - 1; j1++)
                {
                    f[j1] = eui1.f();
                    eui1.a();
                }

                f[j1] = eui1.f();
                break;

            case 154: 
                g = eui1.f();
                break;

            case 160: 
                h = eui1.e();
                break;

            case 170: 
                i = eui1.f();
                break;

            case 176: 
                j = eui1.e();
                break;

            case 192: 
                k = eui1.e();
                break;

            case 202: 
                if (e == null)
                {
                    e = new dzp();
                }
                eui1.a(e);
                break;

            case 216: 
                l = eui1.e();
                break;

            case 224: 
                m = eui1.e();
                break;

            case 232: 
                n = eui1.h();
                break;

            case 245: 
                o = Float.intBitsToFloat(eui1.i());
                break;

            case 248: 
                p = eui1.e();
                break;

            case 258: 
                q = eui1.f();
                break;

            case 266: 
                r = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!a.equals(""))
        {
            euj1.a(1, a);
        }
        if (!b.equals(""))
        {
            euj1.a(15, b);
        }
        if (c != 0L)
        {
            euj1.a(16, c);
        }
        if (d)
        {
            euj1.a(17, d);
        }
        if (f != null)
        {
            String as[] = f;
            int j1 = as.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                euj1.a(18, as[i1]);
            }

        }
        if (!g.equals(""))
        {
            euj1.a(19, g);
        }
        if (h)
        {
            euj1.a(20, h);
        }
        if (!i.equals(""))
        {
            euj1.a(21, i);
        }
        if (j)
        {
            euj1.a(22, j);
        }
        if (k)
        {
            euj1.a(24, k);
        }
        if (e != null)
        {
            euj1.a(25, e);
        }
        if (l)
        {
            euj1.a(27, l);
        }
        if (m)
        {
            euj1.a(28, m);
        }
        if (n != 0)
        {
            euj1.b(29, n);
        }
        if (o != 0.0F)
        {
            euj1.a(30, o);
        }
        if (p)
        {
            euj1.a(31, p);
        }
        if (!q.equals(""))
        {
            euj1.a(32, q);
        }
        if (!r.equals(""))
        {
            euj1.a(33, r);
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
            if (!(obj instanceof ebc))
            {
                return false;
            }
            obj = (ebc)obj;
            if ((a != null ? a.equals(((ebc) (obj)).a) : ((ebc) (obj)).a == null) && (b != null ? b.equals(((ebc) (obj)).b) : ((ebc) (obj)).b == null) && (c == ((ebc) (obj)).c && d == ((ebc) (obj)).d && Arrays.equals(f, ((ebc) (obj)).f)) && (g != null ? g.equals(((ebc) (obj)).g) : ((ebc) (obj)).g == null) && h == ((ebc) (obj)).h && (i != null ? i.equals(((ebc) (obj)).i) : ((ebc) (obj)).i == null) && (j == ((ebc) (obj)).j && k == ((ebc) (obj)).k) && (e != null ? e.equals(((ebc) (obj)).e) : ((ebc) (obj)).e == null) && (l == ((ebc) (obj)).l && m == ((ebc) (obj)).m && n == ((ebc) (obj)).n && o == ((ebc) (obj)).o && p == ((ebc) (obj)).p) && (q != null ? q.equals(((ebc) (obj)).q) : ((ebc) (obj)).q == null) && (r != null ? r.equals(((ebc) (obj)).r) : ((ebc) (obj)).r == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ebc) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ebc) (obj)).O))
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
        int l3;
        int k4;
        l3 = 1;
        k4 = 0;
        int l1 = getClass().getName().hashCode();
        int j2;
        int l4;
        int i5;
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
        j2 = (int)(c ^ c >>> 32);
        if (d)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        i1 = k1 + ((j1 + (i1 + (l1 + 527) * 31) * 31) * 31 + j2) * 31;
        if (f != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L4:
        int i2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int i4;
        int j4;
        if (g == null)
        {
            i1 = 0;
        } else
        {
            i1 = g.hashCode();
        }
        if (h)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (i == null)
        {
            i2 = 0;
        } else
        {
            i2 = i.hashCode();
        }
        if (j)
        {
            k2 = 1;
        } else
        {
            k2 = 2;
        }
        if (k)
        {
            l2 = 1;
        } else
        {
            l2 = 2;
        }
        if (e == null)
        {
            i3 = 0;
        } else
        {
            i3 = e.hashCode();
        }
        if (l)
        {
            j3 = 1;
        } else
        {
            j3 = 2;
        }
        if (m)
        {
            k3 = 1;
        } else
        {
            k3 = 2;
        }
        l4 = n;
        i5 = Float.floatToIntBits(o);
        if (!p)
        {
            l3 = 2;
        }
        if (q == null)
        {
            i4 = 0;
        } else
        {
            i4 = q.hashCode();
        }
        if (r == null)
        {
            j4 = 0;
        } else
        {
            j4 = r.hashCode();
        }
        if (O != null)
        {
            k4 = O.hashCode();
        }
        return (j4 + (i4 + ((((k3 + (j3 + (i3 + (l2 + (k2 + (i2 + (k1 + (i1 + j1 * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l4) * 31 + i5) * 31 + l3) * 31) * 31) * 31 + k4;
_L2:
        k1 = 0;
_L5:
        j1 = i1;
        if (k1 >= f.length) goto _L4; else goto _L3
_L3:
        if (f[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = f[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L5
    }
}
