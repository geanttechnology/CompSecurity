// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dje extends eul
{

    private boolean a;
    private dlb b;
    private long c;
    private div d[];
    private dqi e;
    private djd f;
    private djf g[];

    public dje()
    {
        a = false;
        b = null;
        c = 0L;
        d = div.a;
        e = null;
        f = null;
        g = djf.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int i1;
        if (a)
        {
            boolean flag1 = a;
            i = euj.b(1) + 1 + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (b != null)
        {
            j = i + euj.b(5, b);
        }
        i = j;
        if (c != 0L)
        {
            i = j + euj.c(6, c);
        }
        j = i;
        if (d != null)
        {
            div adiv[] = d;
            int j1 = adiv.length;
            int l = 0;
            do
            {
                j = i;
                if (l >= j1)
                {
                    break;
                }
                div div1 = adiv[l];
                j = i;
                if (div1 != null)
                {
                    j = i + euj.b(7, div1);
                }
                l++;
                i = j;
            } while (true);
        }
        i1 = j;
        if (e != null)
        {
            i1 = j + euj.b(9, e);
        }
        i = i1;
        if (f != null)
        {
            i = i1 + euj.b(11, f);
        }
        i1 = i;
        if (g != null)
        {
            djf adjf[] = g;
            int k1 = adjf.length;
            int k = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (k >= k1)
                {
                    break;
                }
                djf djf1 = adjf[k];
                i1 = i;
                if (djf1 != null)
                {
                    i1 = i + euj.b(12, djf1);
                }
                k++;
                i = i1;
            } while (true);
        }
        i = i1 + eup.a(O);
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

            case 42: // '*'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 48: // '0'
                c = eui1.b();
                break;

            case 58: // ':'
                int l = eup.a(eui1, 58);
                div adiv[];
                int j;
                if (d == null)
                {
                    j = 0;
                } else
                {
                    j = d.length;
                }
                adiv = new div[l + j];
                if (d != null)
                {
                    System.arraycopy(d, 0, adiv, 0, j);
                }
                for (d = adiv; j < d.length - 1; j++)
                {
                    d[j] = new div();
                    eui1.a(d[j]);
                    eui1.a();
                }

                d[j] = new div();
                eui1.a(d[j]);
                break;

            case 74: // 'J'
                if (e == null)
                {
                    e = new dqi();
                }
                eui1.a(e);
                break;

            case 90: // 'Z'
                if (f == null)
                {
                    f = new djd();
                }
                eui1.a(f);
                break;

            case 98: // 'b'
                int i1 = eup.a(eui1, 98);
                djf adjf[];
                int k;
                if (g == null)
                {
                    k = 0;
                } else
                {
                    k = g.length;
                }
                adjf = new djf[i1 + k];
                if (g != null)
                {
                    System.arraycopy(g, 0, adjf, 0, k);
                }
                for (g = adjf; k < g.length - 1; k++)
                {
                    g[k] = new djf();
                    eui1.a(g[k]);
                    eui1.a();
                }

                g[k] = new djf();
                eui1.a(g[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a)
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            euj1.a(5, b);
        }
        if (c != 0L)
        {
            euj1.a(6, c);
        }
        if (d != null)
        {
            div adiv[] = d;
            int k = adiv.length;
            for (int i = 0; i < k; i++)
            {
                div div1 = adiv[i];
                if (div1 != null)
                {
                    euj1.a(7, div1);
                }
            }

        }
        if (e != null)
        {
            euj1.a(9, e);
        }
        if (f != null)
        {
            euj1.a(11, f);
        }
        if (g != null)
        {
            djf adjf[] = g;
            int l = adjf.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                djf djf1 = adjf[j];
                if (djf1 != null)
                {
                    euj1.a(12, djf1);
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
            if (!(obj instanceof dje))
            {
                return false;
            }
            obj = (dje)obj;
            if (a == ((dje) (obj)).a && (b != null ? b.equals(((dje) (obj)).b) : ((dje) (obj)).b == null) && (c == ((dje) (obj)).c && Arrays.equals(d, ((dje) (obj)).d)) && (e != null ? e.equals(((dje) (obj)).e) : ((dje) (obj)).e == null) && (f != null ? f.equals(((dje) (obj)).f) : ((dje) (obj)).f == null) && Arrays.equals(g, ((dje) (obj)).g))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dje) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dje) (obj)).O))
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
        k = getClass().getName().hashCode();
        if (a)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        i = (j + (i + (k + 527) * 31) * 31) * 31 + (int)(c ^ c >>> 32);
        if (d != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L6:
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
        i = k + (i + j * 31) * 31;
        if (g != null) goto _L4; else goto _L3
_L3:
        k = i * 31;
_L9:
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
        j = 0;
_L10:
        k = i;
        if (j >= g.length) goto _L9; else goto _L8
_L8:
        if (g[j] == null)
        {
            k = 0;
        } else
        {
            k = g[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L10
    }
}
