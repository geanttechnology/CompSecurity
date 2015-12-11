// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dub extends eul
{

    public dnl a;
    public String b;
    public boolean c;
    public dta d;
    public boolean e;
    public boolean f;
    public String g;
    public int h;
    public String i;
    private int j;

    public dub()
    {
        a = null;
        b = "";
        c = false;
        d = null;
        e = false;
        f = false;
        g = "";
        h = 0;
        j = 0;
        i = "";
    }

    public final int a()
    {
        int l = 0;
        if (a != null)
        {
            l = euj.b(1, a) + 0;
        }
        int k = l;
        if (!b.equals(""))
        {
            k = l + euj.b(2, b);
        }
        l = k;
        if (c)
        {
            boolean flag = c;
            l = k + (euj.b(3) + 1);
        }
        k = l;
        if (d != null)
        {
            k = l + euj.b(4, d);
        }
        l = k;
        if (e)
        {
            boolean flag1 = e;
            l = k + (euj.b(5) + 1);
        }
        k = l;
        if (f)
        {
            boolean flag2 = f;
            k = l + (euj.b(8) + 1);
        }
        l = k;
        if (!g.equals(""))
        {
            l = k + euj.b(9, g);
        }
        k = l;
        if (h != 0)
        {
            k = l + euj.c(10, h);
        }
        l = k;
        if (j != 0)
        {
            l = k + euj.d(11, j);
        }
        k = l;
        if (!i.equals(""))
        {
            k = l + euj.b(12, i);
        }
        k += eup.a(O);
        P = k;
        return k;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int k = eui1.a();
            switch (k)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, k))
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

            case 24: // '\030'
                c = eui1.e();
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dta();
                }
                eui1.a(d);
                break;

            case 40: // '('
                e = eui1.e();
                break;

            case 64: // '@'
                f = eui1.e();
                break;

            case 74: // 'J'
                g = eui1.f();
                break;

            case 80: // 'P'
                h = eui1.d();
                break;

            case 88: // 'X'
                j = eui1.h();
                break;

            case 98: // 'b'
                i = eui1.f();
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
        if (c)
        {
            euj1.a(3, c);
        }
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (e)
        {
            euj1.a(5, e);
        }
        if (f)
        {
            euj1.a(8, f);
        }
        if (!g.equals(""))
        {
            euj1.a(9, g);
        }
        if (h != 0)
        {
            euj1.a(10, h);
        }
        if (j != 0)
        {
            euj1.b(11, j);
        }
        if (!i.equals(""))
        {
            euj1.a(12, i);
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
            if (!(obj instanceof dub))
            {
                return false;
            }
            obj = (dub)obj;
            if ((a != null ? a.equals(((dub) (obj)).a) : ((dub) (obj)).a == null) && (b != null ? b.equals(((dub) (obj)).b) : ((dub) (obj)).b == null) && c == ((dub) (obj)).c && (d != null ? d.equals(((dub) (obj)).d) : ((dub) (obj)).d == null) && (e == ((dub) (obj)).e && f == ((dub) (obj)).f) && (g != null ? g.equals(((dub) (obj)).g) : ((dub) (obj)).g == null) && (h == ((dub) (obj)).h && j == ((dub) (obj)).j) && (i != null ? i.equals(((dub) (obj)).i) : ((dub) (obj)).i == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dub) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dub) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l1 = 1;
        int k2 = 0;
        int l2 = getClass().getName().hashCode();
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int i2;
        int j2;
        int i3;
        int j3;
        if (a == null)
        {
            k = 0;
        } else
        {
            k = a.hashCode();
        }
        if (b == null)
        {
            l = 0;
        } else
        {
            l = b.hashCode();
        }
        if (c)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        if (d == null)
        {
            j1 = 0;
        } else
        {
            j1 = d.hashCode();
        }
        if (e)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (!f)
        {
            l1 = 2;
        }
        if (g == null)
        {
            i2 = 0;
        } else
        {
            i2 = g.hashCode();
        }
        i3 = h;
        j3 = j;
        if (i == null)
        {
            j2 = 0;
        } else
        {
            j2 = i.hashCode();
        }
        if (O != null)
        {
            k2 = O.hashCode();
        }
        return (j2 + (((i2 + ((k1 + (j1 + (i1 + (l + (k + (l2 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + l1) * 31) * 31 + i3) * 31 + j3) * 31) * 31 + k2;
    }
}
