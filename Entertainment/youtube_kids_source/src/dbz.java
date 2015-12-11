// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dbz extends eul
{

    private dwa a;
    private dby b;
    private dca c[];
    private dlb d;
    private dxa e;
    private String f;
    private dir g;

    public dbz()
    {
        a = null;
        b = null;
        c = dca.a;
        d = null;
        e = null;
        f = "";
        g = null;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (b != null)
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (c != null)
        {
            dca adca[] = c;
            int l = adca.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dca dca1 = adca[k];
                j = i;
                if (dca1 != null)
                {
                    j = i + euj.b(3, dca1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (d != null)
        {
            i = j + euj.b(4, d);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(8, e);
        }
        i = j;
        if (!f.equals(""))
        {
            i = j + euj.b(9, f);
        }
        j = i;
        if (g != null)
        {
            j = i + euj.b(10, g);
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
                if (a == null)
                {
                    a = new dwa();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dby();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                int k = eup.a(eui1, 26);
                dca adca[];
                int j;
                if (c == null)
                {
                    j = 0;
                } else
                {
                    j = c.length;
                }
                adca = new dca[k + j];
                if (c != null)
                {
                    System.arraycopy(c, 0, adca, 0, j);
                }
                for (c = adca; j < c.length - 1; j++)
                {
                    c[j] = new dca();
                    eui1.a(c[j]);
                    eui1.a();
                }

                c[j] = new dca();
                eui1.a(c[j]);
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 66: // 'B'
                if (e == null)
                {
                    e = new dxa();
                }
                eui1.a(e);
                break;

            case 74: // 'J'
                f = eui1.f();
                break;

            case 82: // 'R'
                if (g == null)
                {
                    g = new dir();
                }
                eui1.a(g);
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
        if (c != null)
        {
            dca adca[] = c;
            int j = adca.length;
            for (int i = 0; i < j; i++)
            {
                dca dca1 = adca[i];
                if (dca1 != null)
                {
                    euj1.a(3, dca1);
                }
            }

        }
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            euj1.a(8, e);
        }
        if (!f.equals(""))
        {
            euj1.a(9, f);
        }
        if (g != null)
        {
            euj1.a(10, g);
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
            if (!(obj instanceof dbz))
            {
                return false;
            }
            obj = (dbz)obj;
            if ((a != null ? a.equals(((dbz) (obj)).a) : ((dbz) (obj)).a == null) && (b != null ? b.equals(((dbz) (obj)).b) : ((dbz) (obj)).b == null) && Arrays.equals(c, ((dbz) (obj)).c) && (d != null ? d.equals(((dbz) (obj)).d) : ((dbz) (obj)).d == null) && (e != null ? e.equals(((dbz) (obj)).e) : ((dbz) (obj)).e == null) && (f != null ? f.equals(((dbz) (obj)).f) : ((dbz) (obj)).f == null) && (g != null ? g.equals(((dbz) (obj)).g) : ((dbz) (obj)).g == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dbz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dbz) (obj)).O))
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
        int k1;
        k1 = 0;
        int k = getClass().getName().hashCode();
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
        i = j + (i + (k + 527) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        int l;
        int i1;
        int j1;
        if (d == null)
        {
            i = 0;
        } else
        {
            i = d.hashCode();
        }
        if (e == null)
        {
            l = 0;
        } else
        {
            l = e.hashCode();
        }
        if (f == null)
        {
            i1 = 0;
        } else
        {
            i1 = f.hashCode();
        }
        if (g == null)
        {
            j1 = 0;
        } else
        {
            j1 = g.hashCode();
        }
        if (O != null)
        {
            k1 = O.hashCode();
        }
        return (j1 + (i1 + (l + (i + j * 31) * 31) * 31) * 31) * 31 + k1;
_L2:
        l = 0;
_L5:
        j = i;
        if (l >= c.length) goto _L4; else goto _L3
_L3:
        if (c[l] == null)
        {
            j = 0;
        } else
        {
            j = c[l].hashCode();
        }
        i = j + i * 31;
        l++;
          goto _L5
    }
}
