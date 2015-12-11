// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dsw extends eul
{

    private dlb a;
    private dlb b;
    private dlb c;
    private eaq d;
    private eaq e[];
    private dgd f;
    private dgd g;

    public dsw()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = eaq.a;
        f = null;
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
            j = i + euj.b(3, c);
        }
        i = j;
        if (d != null)
        {
            i = j + euj.b(4, d);
        }
        j = i;
        if (e != null)
        {
            eaq aeaq[] = e;
            int l = aeaq.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                eaq eaq1 = aeaq[k];
                j = i;
                if (eaq1 != null)
                {
                    j = i + euj.b(5, eaq1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(6, f);
        }
        j = i;
        if (g != null)
        {
            j = i + euj.b(7, g);
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
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new eaq();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                int k = eup.a(eui1, 42);
                eaq aeaq[];
                int j;
                if (e == null)
                {
                    j = 0;
                } else
                {
                    j = e.length;
                }
                aeaq = new eaq[k + j];
                if (e != null)
                {
                    System.arraycopy(e, 0, aeaq, 0, j);
                }
                for (e = aeaq; j < e.length - 1; j++)
                {
                    e[j] = new eaq();
                    eui1.a(e[j]);
                    eui1.a();
                }

                e[j] = new eaq();
                eui1.a(e[j]);
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new dgd();
                }
                eui1.a(f);
                break;

            case 58: // ':'
                if (g == null)
                {
                    g = new dgd();
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
            euj1.a(3, c);
        }
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            eaq aeaq[] = e;
            int j = aeaq.length;
            for (int i = 0; i < j; i++)
            {
                eaq eaq1 = aeaq[i];
                if (eaq1 != null)
                {
                    euj1.a(5, eaq1);
                }
            }

        }
        if (f != null)
        {
            euj1.a(6, f);
        }
        if (g != null)
        {
            euj1.a(7, g);
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
            if (!(obj instanceof dsw))
            {
                return false;
            }
            obj = (dsw)obj;
            if ((a != null ? a.equals(((dsw) (obj)).a) : ((dsw) (obj)).a == null) && (b != null ? b.equals(((dsw) (obj)).b) : ((dsw) (obj)).b == null) && (c != null ? c.equals(((dsw) (obj)).c) : ((dsw) (obj)).c == null) && (d != null ? d.equals(((dsw) (obj)).d) : ((dsw) (obj)).d == null) && Arrays.equals(e, ((dsw) (obj)).e) && (f != null ? f.equals(((dsw) (obj)).f) : ((dsw) (obj)).f == null) && (g != null ? g.equals(((dsw) (obj)).g) : ((dsw) (obj)).g == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dsw) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dsw) (obj)).O))
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
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        if (d == null)
        {
            l = 0;
        } else
        {
            l = d.hashCode();
        }
        i = l + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31;
        if (e != null) goto _L2; else goto _L1
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
        if (k >= e.length) goto _L4; else goto _L3
_L3:
        if (e[k] == null)
        {
            j = 0;
        } else
        {
            j = e[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L5
    }
}
