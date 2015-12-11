// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dqw extends eul
{

    public boolean a;
    public byte b[];
    private String c;
    private dqv d;
    private dlb e;
    private dre f;
    private dre g;

    public dqw()
    {
        a = false;
        c = "";
        d = null;
        e = null;
        b = eup.f;
        f = null;
        g = null;
    }

    public final int a()
    {
        int j = 0;
        if (a)
        {
            boolean flag = a;
            j = euj.b(1) + 1 + 0;
        }
        int i = j;
        if (!c.equals(""))
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(3, d);
        }
        i = j;
        if (e != null)
        {
            i = j + euj.b(4, e);
        }
        j = i;
        if (!Arrays.equals(b, eup.f))
        {
            j = i + euj.b(6, b);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(7, f);
        }
        j = i;
        if (g != null)
        {
            j = i + euj.b(8, g);
        }
        i = j + eup.a(O);
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

            case 8: // '\b'
                a = eui1.e();
                break;

            case 18: // '\022'
                c = eui1.f();
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dqv();
                }
                eui1.a(d);
                break;

            case 34: // '"'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                b = eui1.g();
                break;

            case 58: // ':'
                if (f == null)
                {
                    f = new dre();
                }
                eui1.a(f);
                break;

            case 66: // 'B'
                if (g == null)
                {
                    g = new dre();
                }
                eui1.a(g);
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
        if (!c.equals(""))
        {
            euj1.a(2, c);
        }
        if (d != null)
        {
            euj1.a(3, d);
        }
        if (e != null)
        {
            euj1.a(4, e);
        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(6, b);
        }
        if (f != null)
        {
            euj1.a(7, f);
        }
        if (g != null)
        {
            euj1.a(8, g);
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
            if (!(obj instanceof dqw))
            {
                return false;
            }
            obj = (dqw)obj;
            if (a == ((dqw) (obj)).a && (c != null ? c.equals(((dqw) (obj)).c) : ((dqw) (obj)).c == null) && (d != null ? d.equals(((dqw) (obj)).d) : ((dqw) (obj)).d == null) && (e != null ? e.equals(((dqw) (obj)).e) : ((dqw) (obj)).e == null) && Arrays.equals(b, ((dqw) (obj)).b) && (f != null ? f.equals(((dqw) (obj)).f) : ((dqw) (obj)).f == null) && (g != null ? g.equals(((dqw) (obj)).g) : ((dqw) (obj)).g == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dqw) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dqw) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        int j;
        int k;
        int l;
        boolean flag = false;
        int i1 = getClass().getName().hashCode();
        if (a)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (c == null)
        {
            j = 0;
        } else
        {
            j = c.hashCode();
        }
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        if (e == null)
        {
            l = 0;
        } else
        {
            l = e.hashCode();
        }
        i = l + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31;
        if (b != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        if (f == null)
        {
            i = 0;
        } else
        {
            i = f.hashCode();
        }
        if (g == null)
        {
            k = 0;
        } else
        {
            k = g.hashCode();
        }
        if (O == null)
        {
            l = ((flag) ? 1 : 0);
        } else
        {
            l = O.hashCode();
        }
        return (k + (i + j * 31) * 31) * 31 + l;
_L2:
        k = 0;
_L5:
        j = i;
        if (k >= b.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + b[k];
        k++;
          goto _L5
    }
}
