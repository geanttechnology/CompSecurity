// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ect extends eul
{

    public dre a;
    private String b;
    private dzp c;
    private dlb d;
    private dlb e;
    private byte f[];
    private dlb g;

    public ect()
    {
        b = "";
        c = null;
        d = null;
        e = null;
        a = null;
        f = eup.f;
        g = null;
    }

    public final int a()
    {
        int j = 0;
        if (!b.equals(""))
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (c != null)
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
        if (a != null)
        {
            j = i + euj.b(5, a);
        }
        i = j;
        if (!Arrays.equals(f, eup.f))
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

            case 10: // '\n'
                b = eui1.f();
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dzp();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dlb();
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

            case 42: // '*'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 58: // ':'
                f = eui1.g();
                break;

            case 66: // 'B'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!b.equals(""))
        {
            euj1.a(1, b);
        }
        if (c != null)
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
        if (a != null)
        {
            euj1.a(5, a);
        }
        if (!Arrays.equals(f, eup.f))
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
            if (!(obj instanceof ect))
            {
                return false;
            }
            obj = (ect)obj;
            if ((b != null ? b.equals(((ect) (obj)).b) : ((ect) (obj)).b == null) && (c != null ? c.equals(((ect) (obj)).c) : ((ect) (obj)).c == null) && (d != null ? d.equals(((ect) (obj)).d) : ((ect) (obj)).d == null) && (e != null ? e.equals(((ect) (obj)).e) : ((ect) (obj)).e == null) && (a != null ? a.equals(((ect) (obj)).a) : ((ect) (obj)).a == null) && Arrays.equals(f, ((ect) (obj)).f) && (g != null ? g.equals(((ect) (obj)).g) : ((ect) (obj)).g == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ect) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ect) (obj)).O))
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
        boolean flag = false;
        int j1 = getClass().getName().hashCode();
        int l;
        int i1;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
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
        if (a == null)
        {
            i1 = 0;
        } else
        {
            i1 = a.hashCode();
        }
        i = i1 + (l + (k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31) * 31;
        if (f != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        if (g == null)
        {
            i = 0;
        } else
        {
            i = g.hashCode();
        }
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return (i + j * 31) * 31 + k;
_L2:
        k = 0;
_L5:
        j = i;
        if (k >= f.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + f[k];
        k++;
          goto _L5
    }
}
