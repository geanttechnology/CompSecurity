// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ecq extends eul
{

    public ecp a[];
    public ecu b;
    public byte c[];
    private dlb d;
    private dre e;
    private int f;
    private dlb g;

    public ecq()
    {
        d = null;
        e = null;
        a = ecp.a;
        f = 0;
        b = null;
        g = null;
        c = eup.f;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (d != null)
        {
            j = euj.b(1, d) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (e != null)
        {
            i = j + euj.b(2, e);
        }
        j = i;
        if (a != null)
        {
            ecp aecp[] = a;
            int l = aecp.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                ecp ecp1 = aecp[k];
                j = i;
                if (ecp1 != null)
                {
                    j = i + euj.b(3, ecp1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (f != 0)
        {
            i = j + euj.c(4, f);
        }
        j = i;
        if (b != null)
        {
            j = i + euj.b(6, b);
        }
        i = j;
        if (g != null)
        {
            i = j + euj.b(7, g);
        }
        j = i;
        if (!Arrays.equals(c, eup.f))
        {
            j = i + euj.b(9, c);
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
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 18: // '\022'
                if (e == null)
                {
                    e = new dre();
                }
                eui1.a(e);
                break;

            case 26: // '\032'
                int k = eup.a(eui1, 26);
                ecp aecp[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                aecp = new ecp[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, aecp, 0, j);
                }
                for (a = aecp; j < a.length - 1; j++)
                {
                    a[j] = new ecp();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new ecp();
                eui1.a(a[j]);
                break;

            case 32: // ' '
                f = eui1.d();
                break;

            case 50: // '2'
                if (b == null)
                {
                    b = new ecu();
                }
                eui1.a(b);
                break;

            case 58: // ':'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 74: // 'J'
                c = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (d != null)
        {
            euj1.a(1, d);
        }
        if (e != null)
        {
            euj1.a(2, e);
        }
        if (a != null)
        {
            ecp aecp[] = a;
            int j = aecp.length;
            for (int i = 0; i < j; i++)
            {
                ecp ecp1 = aecp[i];
                if (ecp1 != null)
                {
                    euj1.a(3, ecp1);
                }
            }

        }
        if (f != 0)
        {
            euj1.a(4, f);
        }
        if (b != null)
        {
            euj1.a(6, b);
        }
        if (g != null)
        {
            euj1.a(7, g);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(9, c);
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
            if (!(obj instanceof ecq))
            {
                return false;
            }
            obj = (ecq)obj;
            if ((d != null ? d.equals(((ecq) (obj)).d) : ((ecq) (obj)).d == null) && (e != null ? e.equals(((ecq) (obj)).e) : ((ecq) (obj)).e == null) && (Arrays.equals(a, ((ecq) (obj)).a) && f == ((ecq) (obj)).f) && (b != null ? b.equals(((ecq) (obj)).b) : ((ecq) (obj)).b == null) && (g != null ? g.equals(((ecq) (obj)).g) : ((ecq) (obj)).g == null) && Arrays.equals(c, ((ecq) (obj)).c))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ecq) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ecq) (obj)).O))
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
        int k = getClass().getName().hashCode();
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
            j = 0;
        } else
        {
            j = e.hashCode();
        }
        i = j + (i + (k + 527) * 31) * 31;
        if (a != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L6:
        j1 = f;
        int l;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (g == null)
        {
            l = 0;
        } else
        {
            l = g.hashCode();
        }
        i = l + (i + (j * 31 + j1) * 31) * 31;
        if (c != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L9:
        int i1;
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
_L7:
        j = i;
        if (l >= a.length) goto _L6; else goto _L5
_L5:
        if (a[l] == null)
        {
            j = 0;
        } else
        {
            j = a[l].hashCode();
        }
        i = j + i * 31;
        l++;
          goto _L7
          goto _L6
_L4:
        i1 = 0;
_L10:
        j = i;
        if (i1 >= c.length) goto _L9; else goto _L8
_L8:
        i = i * 31 + c[i1];
        i1++;
          goto _L10
    }
}
