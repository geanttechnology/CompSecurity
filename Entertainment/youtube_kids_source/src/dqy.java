// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dqy extends eul
{

    public byte a[];
    private dzp b;
    private dlb c;
    private dlb d;
    private dlb e;
    private dlb f[];
    private dlb g[];

    public dqy()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        a = eup.f;
        f = dlb.a;
        g = dlb.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int l;
        if (b != null)
        {
            j = euj.b(1, b) + 0;
        } else
        {
            j = 0;
        }
        i = j;
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
        if (!Arrays.equals(a, eup.f))
        {
            j = i + euj.b(6, a);
        }
        i = j;
        if (f != null)
        {
            dlb adlb[] = f;
            int i1 = adlb.length;
            int k = 0;
            do
            {
                i = j;
                if (k >= i1)
                {
                    break;
                }
                dlb dlb1 = adlb[k];
                i = j;
                if (dlb1 != null)
                {
                    i = j + euj.b(7, dlb1);
                }
                k++;
                j = i;
            } while (true);
        }
        l = i;
        if (g != null)
        {
            dlb adlb1[] = g;
            int j1 = adlb1.length;
            j = ((flag) ? 1 : 0);
            do
            {
                l = i;
                if (j >= j1)
                {
                    break;
                }
                dlb dlb2 = adlb1[j];
                l = i;
                if (dlb2 != null)
                {
                    l = i + euj.b(8, dlb2);
                }
                j++;
                i = l;
            } while (true);
        }
        i = l + eup.a(O);
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
                    b = new dzp();
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

            case 50: // '2'
                a = eui1.g();
                break;

            case 58: // ':'
                int l = eup.a(eui1, 58);
                dlb adlb[];
                int j;
                if (f == null)
                {
                    j = 0;
                } else
                {
                    j = f.length;
                }
                adlb = new dlb[l + j];
                if (f != null)
                {
                    System.arraycopy(f, 0, adlb, 0, j);
                }
                for (f = adlb; j < f.length - 1; j++)
                {
                    f[j] = new dlb();
                    eui1.a(f[j]);
                    eui1.a();
                }

                f[j] = new dlb();
                eui1.a(f[j]);
                break;

            case 66: // 'B'
                int i1 = eup.a(eui1, 66);
                dlb adlb1[];
                int k;
                if (g == null)
                {
                    k = 0;
                } else
                {
                    k = g.length;
                }
                adlb1 = new dlb[i1 + k];
                if (g != null)
                {
                    System.arraycopy(g, 0, adlb1, 0, k);
                }
                for (g = adlb1; k < g.length - 1; k++)
                {
                    g[k] = new dlb();
                    eui1.a(g[k]);
                    eui1.a();
                }

                g[k] = new dlb();
                eui1.a(g[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
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
        if (!Arrays.equals(a, eup.f))
        {
            euj1.a(6, a);
        }
        if (f != null)
        {
            dlb adlb[] = f;
            int k = adlb.length;
            for (int i = 0; i < k; i++)
            {
                dlb dlb1 = adlb[i];
                if (dlb1 != null)
                {
                    euj1.a(7, dlb1);
                }
            }

        }
        if (g != null)
        {
            dlb adlb1[] = g;
            int l = adlb1.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                dlb dlb2 = adlb1[j];
                if (dlb2 != null)
                {
                    euj1.a(8, dlb2);
                }
            }

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
            if (!(obj instanceof dqy))
            {
                return false;
            }
            obj = (dqy)obj;
            if ((b != null ? b.equals(((dqy) (obj)).b) : ((dqy) (obj)).b == null) && (c != null ? c.equals(((dqy) (obj)).c) : ((dqy) (obj)).c == null) && (d != null ? d.equals(((dqy) (obj)).d) : ((dqy) (obj)).d == null) && (e != null ? e.equals(((dqy) (obj)).e) : ((dqy) (obj)).e == null) && (Arrays.equals(a, ((dqy) (obj)).a) && Arrays.equals(f, ((dqy) (obj)).f) && Arrays.equals(g, ((dqy) (obj)).g)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dqy) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dqy) (obj)).O))
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
        int i1 = getClass().getName().hashCode();
        int l;
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
        j = l + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31;
        if (a != null) goto _L2; else goto _L1
_L1:
        i = j * 31;
_L8:
        if (f != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L11:
        if (g != null) goto _L6; else goto _L5
_L5:
        k = j * 31;
_L14:
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return k * 31 + i;
_L2:
        k = 0;
_L9:
        i = j;
        if (k >= a.length) goto _L8; else goto _L7
_L7:
        j = j * 31 + a[k];
        k++;
          goto _L9
          goto _L8
_L4:
        k = 0;
_L12:
        j = i;
        if (k >= f.length) goto _L11; else goto _L10
_L10:
        if (f[k] == null)
        {
            j = 0;
        } else
        {
            j = f[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L12
          goto _L11
_L6:
        k = 0;
        i = j;
        j = k;
_L15:
        k = i;
        if (j >= g.length) goto _L14; else goto _L13
_L13:
        if (g[j] == null)
        {
            k = 0;
        } else
        {
            k = g[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L15
    }
}
