// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dty extends eul
{

    private dzp a;
    private dlb b;
    private dlb c;
    private dlb d;
    private dre e;
    private dtk f;
    private dtx g[];
    private byte h[];

    public dty()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = dtx.a;
        h = eup.f;
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
            j = i + euj.b(5, e);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(6, f);
        }
        j = i;
        if (g != null)
        {
            dtx adtx[] = g;
            int l = adtx.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dtx dtx1 = adtx[k];
                j = i;
                if (dtx1 != null)
                {
                    j = i + euj.b(7, dtx1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (!Arrays.equals(h, eup.f))
        {
            i = j + euj.b(9, h);
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
                if (a == null)
                {
                    a = new dzp();
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
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dre();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new dtk();
                }
                eui1.a(f);
                break;

            case 58: // ':'
                int k = eup.a(eui1, 58);
                dtx adtx[];
                int j;
                if (g == null)
                {
                    j = 0;
                } else
                {
                    j = g.length;
                }
                adtx = new dtx[k + j];
                if (g != null)
                {
                    System.arraycopy(g, 0, adtx, 0, j);
                }
                for (g = adtx; j < g.length - 1; j++)
                {
                    g[j] = new dtx();
                    eui1.a(g[j]);
                    eui1.a();
                }

                g[j] = new dtx();
                eui1.a(g[j]);
                break;

            case 74: // 'J'
                h = eui1.g();
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
            euj1.a(5, e);
        }
        if (f != null)
        {
            euj1.a(6, f);
        }
        if (g != null)
        {
            dtx adtx[] = g;
            int j = adtx.length;
            for (int i = 0; i < j; i++)
            {
                dtx dtx1 = adtx[i];
                if (dtx1 != null)
                {
                    euj1.a(7, dtx1);
                }
            }

        }
        if (!Arrays.equals(h, eup.f))
        {
            euj1.a(9, h);
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
            if (!(obj instanceof dty))
            {
                return false;
            }
            obj = (dty)obj;
            if ((a != null ? a.equals(((dty) (obj)).a) : ((dty) (obj)).a == null) && (b != null ? b.equals(((dty) (obj)).b) : ((dty) (obj)).b == null) && (c != null ? c.equals(((dty) (obj)).c) : ((dty) (obj)).c == null) && (d != null ? d.equals(((dty) (obj)).d) : ((dty) (obj)).d == null) && (e != null ? e.equals(((dty) (obj)).e) : ((dty) (obj)).e == null) && (f != null ? f.equals(((dty) (obj)).f) : ((dty) (obj)).f == null) && (Arrays.equals(g, ((dty) (obj)).g) && Arrays.equals(h, ((dty) (obj)).h)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dty) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dty) (obj)).O))
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
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
        }
        if (e == null)
        {
            j1 = 0;
        } else
        {
            j1 = e.hashCode();
        }
        if (f == null)
        {
            k1 = 0;
        } else
        {
            k1 = f.hashCode();
        }
        i = k1 + (j1 + (i1 + (k + (j + (i + (l1 + 527) * 31) * 31) * 31) * 31) * 31) * 31;
        if (g != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L6:
        if (h != null) goto _L4; else goto _L3
_L3:
        i = j * 31;
_L9:
        int l;
        if (O == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = O.hashCode();
        }
        return i * 31 + j;
_L2:
        l = 0;
_L7:
        j = i;
        if (l >= g.length) goto _L6; else goto _L5
_L5:
        if (g[l] == null)
        {
            j = 0;
        } else
        {
            j = g[l].hashCode();
        }
        i = j + i * 31;
        l++;
          goto _L7
          goto _L6
_L4:
        l = 0;
_L10:
        i = j;
        if (l >= h.length) goto _L9; else goto _L8
_L8:
        j = j * 31 + h[l];
        l++;
          goto _L10
    }
}
