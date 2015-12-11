// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dcj extends eul
{

    public dlb a;
    public dlb b;
    public dzp c;
    public dre d;
    private dre e;
    private boolean f;
    private duf g;
    private duf h;

    public dcj()
    {
        a = null;
        b = null;
        e = null;
        c = null;
        d = null;
        f = false;
        g = null;
        h = null;
    }

    public final int a()
    {
        int j = 0;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (b != null)
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(3, e);
        }
        i = j;
        if (c != null)
        {
            i = j + euj.b(4, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(5, d);
        }
        i = j;
        if (f)
        {
            boolean flag = f;
            i = j + (euj.b(6) + 1);
        }
        j = i;
        if (g != null)
        {
            j = i + euj.b(7, g);
        }
        i = j;
        if (h != null)
        {
            i = j + euj.b(8, h);
        }
        i += eup.a(O);
        P = i;
        return i;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int i = eui1.a();
            switch (i)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                if (e == null)
                {
                    e = new dre();
                }
                eui1.a(e);
                break;

            case 34: // '"'
                if (c == null)
                {
                    c = new dzp();
                }
                eui1.a(c);
                break;

            case 42: // '*'
                if (d == null)
                {
                    d = new dre();
                }
                eui1.a(d);
                break;

            case 48: // '0'
                f = eui1.e();
                break;

            case 58: // ':'
                if (g == null)
                {
                    g = new duf();
                }
                eui1.a(g);
                break;

            case 66: // 'B'
                if (h == null)
                {
                    h = new duf();
                }
                eui1.a(h);
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
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (e != null)
        {
            euj1.a(3, e);
        }
        if (c != null)
        {
            euj1.a(4, c);
        }
        if (d != null)
        {
            euj1.a(5, d);
        }
        if (f)
        {
            euj1.a(6, f);
        }
        if (g != null)
        {
            euj1.a(7, g);
        }
        if (h != null)
        {
            euj1.a(8, h);
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
            if (!(obj instanceof dcj))
            {
                return false;
            }
            obj = (dcj)obj;
            if ((a != null ? a.equals(((dcj) (obj)).a) : ((dcj) (obj)).a == null) && (b != null ? b.equals(((dcj) (obj)).b) : ((dcj) (obj)).b == null) && (e != null ? e.equals(((dcj) (obj)).e) : ((dcj) (obj)).e == null) && (c != null ? c.equals(((dcj) (obj)).c) : ((dcj) (obj)).c == null) && (d != null ? d.equals(((dcj) (obj)).d) : ((dcj) (obj)).d == null) && f == ((dcj) (obj)).f && (g != null ? g.equals(((dcj) (obj)).g) : ((dcj) (obj)).g == null) && (h != null ? h.equals(((dcj) (obj)).h) : ((dcj) (obj)).h == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dcj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dcj) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i2 = 0;
        int j2 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        if (e == null)
        {
            k = 0;
        } else
        {
            k = e.hashCode();
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
        if (f)
        {
            j1 = 1;
        } else
        {
            j1 = 2;
        }
        if (g == null)
        {
            k1 = 0;
        } else
        {
            k1 = g.hashCode();
        }
        if (h == null)
        {
            l1 = 0;
        } else
        {
            l1 = h.hashCode();
        }
        if (O != null)
        {
            i2 = O.hashCode();
        }
        return (l1 + (k1 + (j1 + (i1 + (l + (k + (j + (i + (j2 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
    }
}
