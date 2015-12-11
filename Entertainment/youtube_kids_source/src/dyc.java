// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dyc extends eul
{

    public byte a[];
    private dlb b;
    private dlb c;
    private dre d;
    private dlb e;
    private dlb f;
    private dre g;

    public dyc()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        a = eup.f;
    }

    public final int a()
    {
        int j = 0;
        if (b != null)
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
        if (f != null)
        {
            j = i + euj.b(5, f);
        }
        i = j;
        if (g != null)
        {
            i = j + euj.b(6, g);
        }
        j = i;
        if (!Arrays.equals(a, eup.f))
        {
            j = i + euj.b(8, a);
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
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dre();
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
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 50: // '2'
                if (g == null)
                {
                    g = new dre();
                }
                eui1.a(g);
                break;

            case 66: // 'B'
                a = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
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
        if (f != null)
        {
            euj1.a(5, f);
        }
        if (g != null)
        {
            euj1.a(6, g);
        }
        if (!Arrays.equals(a, eup.f))
        {
            euj1.a(8, a);
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
            if (!(obj instanceof dyc))
            {
                return false;
            }
            obj = (dyc)obj;
            if ((b != null ? b.equals(((dyc) (obj)).b) : ((dyc) (obj)).b == null) && (c != null ? c.equals(((dyc) (obj)).c) : ((dyc) (obj)).c == null) && (d != null ? d.equals(((dyc) (obj)).d) : ((dyc) (obj)).d == null) && (e != null ? e.equals(((dyc) (obj)).e) : ((dyc) (obj)).e == null) && (f != null ? f.equals(((dyc) (obj)).f) : ((dyc) (obj)).f == null) && (g != null ? g.equals(((dyc) (obj)).g) : ((dyc) (obj)).g == null) && Arrays.equals(a, ((dyc) (obj)).a))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dyc) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dyc) (obj)).O))
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
        boolean flag = false;
        int l1 = getClass().getName().hashCode();
        int k;
        int i1;
        int j1;
        int k1;
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
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        if (f == null)
        {
            j1 = 0;
        } else
        {
            j1 = f.hashCode();
        }
        if (g == null)
        {
            k1 = 0;
        } else
        {
            k1 = g.hashCode();
        }
        i = k1 + (j1 + (i1 + (k + (j + (i + (l1 + 527) * 31) * 31) * 31) * 31) * 31) * 31;
        if (a != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        int l;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return j * 31 + i;
_L2:
        l = 0;
_L5:
        j = i;
        if (l >= a.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + a[l];
        l++;
          goto _L5
    }
}
