// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class eda extends eul
{

    public String a;
    public String b;
    public int c;
    public String d;
    public boolean e;
    public float f;
    public String g;
    public int h;
    public edb i;
    private String j;
    private float k;
    private edc l;

    public eda()
    {
        a = "";
        b = "";
        c = 0;
        j = "";
        d = "";
        e = false;
        f = 0.0F;
        k = 0.0F;
        g = "";
        h = 0;
        l = null;
        i = null;
    }

    public final int a()
    {
        int j1 = 0;
        if (!a.equals(""))
        {
            j1 = euj.b(1, a) + 0;
        }
        int i1 = j1;
        if (!b.equals(""))
        {
            i1 = j1 + euj.b(2, b);
        }
        j1 = i1;
        if (c != 0)
        {
            j1 = i1 + euj.d(3, c);
        }
        i1 = j1;
        if (!j.equals(""))
        {
            i1 = j1 + euj.b(4, j);
        }
        j1 = i1;
        if (!d.equals(""))
        {
            j1 = i1 + euj.b(5, d);
        }
        i1 = j1;
        if (e)
        {
            boolean flag = e;
            i1 = j1 + (euj.b(6) + 1);
        }
        j1 = i1;
        if (f != 0.0F)
        {
            float f1 = f;
            j1 = i1 + (euj.b(7) + 4);
        }
        i1 = j1;
        if (k != 0.0F)
        {
            float f2 = k;
            i1 = j1 + (euj.b(8) + 4);
        }
        j1 = i1;
        if (!g.equals(""))
        {
            j1 = i1 + euj.b(9, g);
        }
        i1 = j1;
        if (h != 0)
        {
            i1 = j1 + euj.c(12, h);
        }
        j1 = i1;
        if (l != null)
        {
            j1 = i1 + euj.b(0x40fd70f, l);
        }
        i1 = j1;
        if (i != null)
        {
            i1 = j1 + euj.b(0x4c288f4, i);
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
                b = eui1.f();
                break;

            case 24: // '\030'
                c = eui1.h();
                break;

            case 34: // '"'
                j = eui1.f();
                break;

            case 42: // '*'
                d = eui1.f();
                break;

            case 48: // '0'
                e = eui1.e();
                break;

            case 61: // '='
                f = Float.intBitsToFloat(eui1.i());
                break;

            case 69: // 'E'
                k = Float.intBitsToFloat(eui1.i());
                break;

            case 74: // 'J'
                g = eui1.f();
                break;

            case 96: // '`'
                int j1 = eui1.d();
                if (j1 == 0 || j1 == 1 || j1 == 2 || j1 == 3)
                {
                    h = j1;
                } else
                {
                    h = 0;
                }
                break;

            case 545175674: 
                if (l == null)
                {
                    l = new edc();
                }
                eui1.a(l);
                break;

            case 638863266: 
                if (i == null)
                {
                    i = new edb();
                }
                eui1.a(i);
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
            euj1.a(2, b);
        }
        if (c != 0)
        {
            euj1.b(3, c);
        }
        if (!j.equals(""))
        {
            euj1.a(4, j);
        }
        if (!d.equals(""))
        {
            euj1.a(5, d);
        }
        if (e)
        {
            euj1.a(6, e);
        }
        if (f != 0.0F)
        {
            euj1.a(7, f);
        }
        if (k != 0.0F)
        {
            euj1.a(8, k);
        }
        if (!g.equals(""))
        {
            euj1.a(9, g);
        }
        if (h != 0)
        {
            euj1.a(12, h);
        }
        if (l != null)
        {
            euj1.a(0x40fd70f, l);
        }
        if (i != null)
        {
            euj1.a(0x4c288f4, i);
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
            if (!(obj instanceof eda))
            {
                return false;
            }
            obj = (eda)obj;
            if ((a != null ? a.equals(((eda) (obj)).a) : ((eda) (obj)).a == null) && (b != null ? b.equals(((eda) (obj)).b) : ((eda) (obj)).b == null) && c == ((eda) (obj)).c && (j != null ? j.equals(((eda) (obj)).j) : ((eda) (obj)).j == null) && (d != null ? d.equals(((eda) (obj)).d) : ((eda) (obj)).d == null) && (e == ((eda) (obj)).e && f == ((eda) (obj)).f && k == ((eda) (obj)).k) && (g != null ? g.equals(((eda) (obj)).g) : ((eda) (obj)).g == null) && h == ((eda) (obj)).h && (l != null ? l.equals(((eda) (obj)).l) : ((eda) (obj)).l == null) && (i != null ? i.equals(((eda) (obj)).i) : ((eda) (obj)).i == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((eda) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((eda) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i3 = 0;
        int j3 = getClass().getName().hashCode();
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int k3;
        int l3;
        int i4;
        int j4;
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
        k3 = c;
        if (j == null)
        {
            k1 = 0;
        } else
        {
            k1 = j.hashCode();
        }
        if (d == null)
        {
            l1 = 0;
        } else
        {
            l1 = d.hashCode();
        }
        if (e)
        {
            i2 = 1;
        } else
        {
            i2 = 2;
        }
        l3 = Float.floatToIntBits(f);
        i4 = Float.floatToIntBits(k);
        if (g == null)
        {
            j2 = 0;
        } else
        {
            j2 = g.hashCode();
        }
        j4 = h;
        if (l == null)
        {
            k2 = 0;
        } else
        {
            k2 = l.hashCode();
        }
        if (i == null)
        {
            l2 = 0;
        } else
        {
            l2 = i.hashCode();
        }
        if (O != null)
        {
            i3 = O.hashCode();
        }
        return (l2 + (k2 + ((j2 + (((i2 + (l1 + (k1 + ((j1 + (i1 + (j3 + 527) * 31) * 31) * 31 + k3) * 31) * 31) * 31) * 31 + l3) * 31 + i4) * 31) * 31 + j4) * 31) * 31) * 31 + i3;
    }
}
