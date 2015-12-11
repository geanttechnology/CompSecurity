// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dyq extends eul
{

    public dxa a;
    public byte b[];
    private dlb c;
    private dlb d[];
    private dlb e;
    private dlb f;
    private dbk g;

    public dyq()
    {
        c = null;
        d = dlb.a;
        e = null;
        f = null;
        a = null;
        b = eup.f;
        g = null;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (c != null)
        {
            i = euj.b(1, c) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (d != null)
        {
            dlb adlb[] = d;
            int l = adlb.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dlb dlb1 = adlb[k];
                j = i;
                if (dlb1 != null)
                {
                    j = i + euj.b(2, dlb1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (e != null)
        {
            i = j + euj.b(3, e);
        }
        j = i;
        if (f != null)
        {
            j = i + euj.b(4, f);
        }
        i = j;
        if (a != null)
        {
            i = j + euj.b(5, a);
        }
        j = i;
        if (!Arrays.equals(b, eup.f))
        {
            j = i + euj.b(7, b);
        }
        i = j;
        if (g != null)
        {
            i = j + euj.b(8, g);
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
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                dlb adlb[];
                int j;
                if (d == null)
                {
                    j = 0;
                } else
                {
                    j = d.length;
                }
                adlb = new dlb[k + j];
                if (d != null)
                {
                    System.arraycopy(d, 0, adlb, 0, j);
                }
                for (d = adlb; j < d.length - 1; j++)
                {
                    d[j] = new dlb();
                    eui1.a(d[j]);
                    eui1.a();
                }

                d[j] = new dlb();
                eui1.a(d[j]);
                break;

            case 26: // '\032'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 34: // '"'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 42: // '*'
                if (a == null)
                {
                    a = new dxa();
                }
                eui1.a(a);
                break;

            case 58: // ':'
                b = eui1.g();
                break;

            case 66: // 'B'
                if (g == null)
                {
                    g = new dbk();
                }
                eui1.a(g);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (c != null)
        {
            euj1.a(1, c);
        }
        if (d != null)
        {
            dlb adlb[] = d;
            int j = adlb.length;
            for (int i = 0; i < j; i++)
            {
                dlb dlb1 = adlb[i];
                if (dlb1 != null)
                {
                    euj1.a(2, dlb1);
                }
            }

        }
        if (e != null)
        {
            euj1.a(3, e);
        }
        if (f != null)
        {
            euj1.a(4, f);
        }
        if (a != null)
        {
            euj1.a(5, a);
        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(7, b);
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
            if (!(obj instanceof dyq))
            {
                return false;
            }
            obj = (dyq)obj;
            if ((c != null ? c.equals(((dyq) (obj)).c) : ((dyq) (obj)).c == null) && Arrays.equals(d, ((dyq) (obj)).d) && (e != null ? e.equals(((dyq) (obj)).e) : ((dyq) (obj)).e == null) && (f != null ? f.equals(((dyq) (obj)).f) : ((dyq) (obj)).f == null) && (a != null ? a.equals(((dyq) (obj)).a) : ((dyq) (obj)).a == null) && Arrays.equals(b, ((dyq) (obj)).b) && (g != null ? g.equals(((dyq) (obj)).g) : ((dyq) (obj)).g == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dyq) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dyq) (obj)).O))
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
        j = getClass().getName().hashCode();
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        i += (j + 527) * 31;
        if (d != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L6:
        int l;
        if (e == null)
        {
            i = 0;
        } else
        {
            i = e.hashCode();
        }
        if (f == null)
        {
            k = 0;
        } else
        {
            k = f.hashCode();
        }
        if (a == null)
        {
            l = 0;
        } else
        {
            l = a.hashCode();
        }
        i = l + (k + (i + j * 31) * 31) * 31;
        if (b != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L9:
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
_L7:
        j = i;
        if (k >= d.length) goto _L6; else goto _L5
_L5:
        if (d[k] == null)
        {
            j = 0;
        } else
        {
            j = d[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L7
          goto _L6
_L4:
        k = 0;
_L10:
        j = i;
        if (k >= b.length) goto _L9; else goto _L8
_L8:
        i = i * 31 + b[k];
        k++;
          goto _L10
    }
}
