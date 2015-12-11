// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dpm extends eul
{

    private dlb a;
    private boolean b;
    private int c;
    private dpl d[];
    private boolean e;
    private dlb f;
    private boolean g;
    private dlb h;
    private boolean i;

    public dpm()
    {
        a = null;
        b = false;
        c = 0;
        d = dpl.a;
        e = false;
        f = null;
        g = false;
        h = null;
        i = false;
    }

    public final int a()
    {
        int l = 0;
        int j;
        int k;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        } else
        {
            j = 0;
        }
        k = j;
        if (b)
        {
            boolean flag = b;
            k = j + (euj.b(2) + 1);
        }
        j = k;
        if (c != 0)
        {
            j = k + euj.c(3, c);
        }
        k = j;
        if (d != null)
        {
            dpl adpl[] = d;
            int i1 = adpl.length;
            do
            {
                k = j;
                if (l >= i1)
                {
                    break;
                }
                dpl dpl1 = adpl[l];
                k = j;
                if (dpl1 != null)
                {
                    k = j + euj.b(4, dpl1);
                }
                l++;
                j = k;
            } while (true);
        }
        j = k;
        if (e)
        {
            boolean flag1 = e;
            j = k + (euj.b(5) + 1);
        }
        k = j;
        if (f != null)
        {
            k = j + euj.b(6, f);
        }
        j = k;
        if (g)
        {
            boolean flag2 = g;
            j = k + (euj.b(7) + 1);
        }
        k = j;
        if (h != null)
        {
            k = j + euj.b(8, h);
        }
        j = k;
        if (i)
        {
            boolean flag3 = i;
            j = k + (euj.b(9) + 1);
        }
        j += eup.a(O);
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

            case 10: // '\n'
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 16: // '\020'
                b = eui1.e();
                break;

            case 24: // '\030'
                int k = eui1.d();
                if (k == 0 || k == 1 || k == 2 || k == 3)
                {
                    c = k;
                } else
                {
                    c = 0;
                }
                break;

            case 34: // '"'
                int i1 = eup.a(eui1, 34);
                dpl adpl[];
                int l;
                if (d == null)
                {
                    l = 0;
                } else
                {
                    l = d.length;
                }
                adpl = new dpl[i1 + l];
                if (d != null)
                {
                    System.arraycopy(d, 0, adpl, 0, l);
                }
                for (d = adpl; l < d.length - 1; l++)
                {
                    d[l] = new dpl();
                    eui1.a(d[l]);
                    eui1.a();
                }

                d[l] = new dpl();
                eui1.a(d[l]);
                break;

            case 40: // '('
                e = eui1.e();
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 56: // '8'
                g = eui1.e();
                break;

            case 66: // 'B'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 72: // 'H'
                i = eui1.e();
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
        if (b)
        {
            euj1.a(2, b);
        }
        if (c != 0)
        {
            euj1.a(3, c);
        }
        if (d != null)
        {
            dpl adpl[] = d;
            int k = adpl.length;
            for (int j = 0; j < k; j++)
            {
                dpl dpl1 = adpl[j];
                if (dpl1 != null)
                {
                    euj1.a(4, dpl1);
                }
            }

        }
        if (e)
        {
            euj1.a(5, e);
        }
        if (f != null)
        {
            euj1.a(6, f);
        }
        if (g)
        {
            euj1.a(7, g);
        }
        if (h != null)
        {
            euj1.a(8, h);
        }
        if (i)
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
            if (!(obj instanceof dpm))
            {
                return false;
            }
            obj = (dpm)obj;
            if ((a != null ? a.equals(((dpm) (obj)).a) : ((dpm) (obj)).a == null) && (b == ((dpm) (obj)).b && c == ((dpm) (obj)).c && Arrays.equals(d, ((dpm) (obj)).d) && e == ((dpm) (obj)).e) && (f != null ? f.equals(((dpm) (obj)).f) : ((dpm) (obj)).f == null) && g == ((dpm) (obj)).g && (h != null ? h.equals(((dpm) (obj)).h) : ((dpm) (obj)).h == null) && i == ((dpm) (obj)).i)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dpm) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dpm) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j;
        int k;
        int l1;
        int i2;
        l1 = 1;
        i2 = 0;
        int l = getClass().getName().hashCode();
        if (a == null)
        {
            j = 0;
        } else
        {
            j = a.hashCode();
        }
        if (b)
        {
            k = 1;
        } else
        {
            k = 2;
        }
        j = (k + (j + (l + 527) * 31) * 31) * 31 + c;
        if (d != null) goto _L2; else goto _L1
_L1:
        k = j * 31;
_L4:
        int i1;
        int j1;
        int k1;
        if (e)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        if (f == null)
        {
            i1 = 0;
        } else
        {
            i1 = f.hashCode();
        }
        if (g)
        {
            j1 = 1;
        } else
        {
            j1 = 2;
        }
        if (h == null)
        {
            k1 = 0;
        } else
        {
            k1 = h.hashCode();
        }
        if (!i)
        {
            l1 = 2;
        }
        if (O != null)
        {
            i2 = O.hashCode();
        }
        return ((k1 + (j1 + (i1 + (j + k * 31) * 31) * 31) * 31) * 31 + l1) * 31 + i2;
_L2:
        i1 = 0;
_L5:
        k = j;
        if (i1 >= d.length) goto _L4; else goto _L3
_L3:
        if (d[i1] == null)
        {
            k = 0;
        } else
        {
            k = d[i1].hashCode();
        }
        j = k + j * 31;
        i1++;
          goto _L5
    }
}
