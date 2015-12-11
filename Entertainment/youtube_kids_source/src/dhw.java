// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dhw extends eul
{

    private boolean a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private boolean g;
    private String h;
    private int i;

    public dhw()
    {
        a = false;
        b = "";
        c = "";
        d = "";
        e = "";
        f = 0;
        g = false;
        h = "";
        i = 0;
    }

    public final int a()
    {
        int k = 0;
        if (a)
        {
            boolean flag = a;
            k = euj.b(1) + 1 + 0;
        }
        int j = k;
        if (!b.equals(""))
        {
            j = k + euj.b(2, b);
        }
        k = j;
        if (!c.equals(""))
        {
            k = j + euj.b(3, c);
        }
        j = k;
        if (!d.equals(""))
        {
            j = k + euj.b(4, d);
        }
        k = j;
        if (!e.equals(""))
        {
            k = j + euj.b(5, e);
        }
        j = k;
        if (f != 0)
        {
            j = k + euj.c(6, f);
        }
        k = j;
        if (g)
        {
            boolean flag1 = g;
            k = j + (euj.b(7) + 1);
        }
        j = k;
        if (!h.equals(""))
        {
            j = k + euj.b(8, h);
        }
        k = j;
        if (i != 0)
        {
            k = j + euj.c(9, i);
        }
        j = k + eup.a(O);
        P = j;
        return j;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int j = eui1.a();
            switch (j)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, j))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                a = eui1.e();
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 34: // '"'
                d = eui1.f();
                break;

            case 42: // '*'
                e = eui1.f();
                break;

            case 48: // '0'
                int k = eui1.d();
                if (k == 0 || k == 1 || k == 2)
                {
                    f = k;
                } else
                {
                    f = 0;
                }
                break;

            case 56: // '8'
                g = eui1.e();
                break;

            case 66: // 'B'
                h = eui1.f();
                break;

            case 72: // 'H'
                int l = eui1.d();
                if (l == 0 || l == 1 || l == 2)
                {
                    i = l;
                } else
                {
                    i = 0;
                }
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a)
        {
            euj1.a(1, a);
        }
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
            euj1.a(4, d);
        }
        if (!e.equals(""))
        {
            euj1.a(5, e);
        }
        if (f != 0)
        {
            euj1.a(6, f);
        }
        if (g)
        {
            euj1.a(7, g);
        }
        if (!h.equals(""))
        {
            euj1.a(8, h);
        }
        if (i != 0)
        {
            euj1.a(9, i);
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
            if (!(obj instanceof dhw))
            {
                return false;
            }
            obj = (dhw)obj;
            if (a == ((dhw) (obj)).a && (b != null ? b.equals(((dhw) (obj)).b) : ((dhw) (obj)).b == null) && (c != null ? c.equals(((dhw) (obj)).c) : ((dhw) (obj)).c == null) && (d != null ? d.equals(((dhw) (obj)).d) : ((dhw) (obj)).d == null) && (e != null ? e.equals(((dhw) (obj)).e) : ((dhw) (obj)).e == null) && (f == ((dhw) (obj)).f && g == ((dhw) (obj)).g) && (h != null ? h.equals(((dhw) (obj)).h) : ((dhw) (obj)).h == null) && i == ((dhw) (obj)).i)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dhw) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dhw) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k1 = 1;
        int i2 = 0;
        int j2 = getClass().getName().hashCode();
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int l1;
        int k2;
        int l2;
        if (a)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        if (b == null)
        {
            k = 0;
        } else
        {
            k = b.hashCode();
        }
        if (c == null)
        {
            l = 0;
        } else
        {
            l = c.hashCode();
        }
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
        }
        if (e == null)
        {
            j1 = 0;
        } else
        {
            j1 = e.hashCode();
        }
        k2 = f;
        if (!g)
        {
            k1 = 2;
        }
        if (h == null)
        {
            l1 = 0;
        } else
        {
            l1 = h.hashCode();
        }
        l2 = i;
        if (O != null)
        {
            i2 = O.hashCode();
        }
        return ((l1 + (((j1 + (i1 + (l + (k + (j + (j2 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + k2) * 31 + k1) * 31) * 31 + l2) * 31 + i2;
    }
}
