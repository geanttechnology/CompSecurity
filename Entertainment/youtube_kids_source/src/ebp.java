// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ebp extends eul
{

    public dzp a;
    public dlb b;
    public dre c;
    public byte d[];
    private dzg e;
    private dlb f;
    private ebq g;
    private dfq h[];

    public ebp()
    {
        a = null;
        b = null;
        e = null;
        c = null;
        f = null;
        g = null;
        d = eup.f;
        h = dfq.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int k;
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
        if (e != null)
        {
            j = i + euj.b(3, e);
        }
        i = j;
        if (c != null)
        {
            i = j + euj.b(4, c);
        }
        j = i;
        if (f != null)
        {
            j = i + euj.b(5, f);
        }
        k = j;
        if (g != null)
        {
            k = j + euj.b(6, g);
        }
        i = k;
        if (!Arrays.equals(d, eup.f))
        {
            i = k + euj.b(8, d);
        }
        k = i;
        if (h != null)
        {
            dfq adfq[] = h;
            int l = adfq.length;
            j = ((flag) ? 1 : 0);
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                dfq dfq1 = adfq[j];
                k = i;
                if (dfq1 != null)
                {
                    k = i + euj.b(10, dfq1);
                }
                j++;
                i = k;
            } while (true);
        }
        i = k + eup.a(O);
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
                if (e == null)
                {
                    e = new dzg();
                }
                eui1.a(e);
                break;

            case 34: // '"'
                if (c == null)
                {
                    c = new dre();
                }
                eui1.a(c);
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
                    g = new ebq();
                }
                eui1.a(g);
                break;

            case 66: // 'B'
                d = eui1.g();
                break;

            case 82: // 'R'
                int k = eup.a(eui1, 82);
                dfq adfq[];
                int j;
                if (h == null)
                {
                    j = 0;
                } else
                {
                    j = h.length;
                }
                adfq = new dfq[k + j];
                if (h != null)
                {
                    System.arraycopy(h, 0, adfq, 0, j);
                }
                for (h = adfq; j < h.length - 1; j++)
                {
                    h[j] = new dfq();
                    eui1.a(h[j]);
                    eui1.a();
                }

                h[j] = new dfq();
                eui1.a(h[j]);
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
        if (e != null)
        {
            euj1.a(3, e);
        }
        if (c != null)
        {
            euj1.a(4, c);
        }
        if (f != null)
        {
            euj1.a(5, f);
        }
        if (g != null)
        {
            euj1.a(6, g);
        }
        if (!Arrays.equals(d, eup.f))
        {
            euj1.a(8, d);
        }
        if (h != null)
        {
            dfq adfq[] = h;
            int j = adfq.length;
            for (int i = 0; i < j; i++)
            {
                dfq dfq1 = adfq[i];
                if (dfq1 != null)
                {
                    euj1.a(10, dfq1);
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
            if (!(obj instanceof ebp))
            {
                return false;
            }
            obj = (ebp)obj;
            if ((a != null ? a.equals(((ebp) (obj)).a) : ((ebp) (obj)).a == null) && (b != null ? b.equals(((ebp) (obj)).b) : ((ebp) (obj)).b == null) && (e != null ? e.equals(((ebp) (obj)).e) : ((ebp) (obj)).e == null) && (c != null ? c.equals(((ebp) (obj)).c) : ((ebp) (obj)).c == null) && (f != null ? f.equals(((ebp) (obj)).f) : ((ebp) (obj)).f == null) && (g != null ? g.equals(((ebp) (obj)).g) : ((ebp) (obj)).g == null) && (Arrays.equals(d, ((ebp) (obj)).d) && Arrays.equals(h, ((ebp) (obj)).h)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ebp) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ebp) (obj)).O))
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
        int k1 = getClass().getName().hashCode();
        int l;
        int i1;
        int j1;
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
        if (e == null)
        {
            k = 0;
        } else
        {
            k = e.hashCode();
        }
        if (c == null)
        {
            l = 0;
        } else
        {
            l = c.hashCode();
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
        j = j1 + (i1 + (l + (k + (j + (i + (k1 + 527) * 31) * 31) * 31) * 31) * 31) * 31;
        if (d != null) goto _L2; else goto _L1
_L1:
        i = j * 31;
_L6:
        if (h != null) goto _L4; else goto _L3
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
        i = j;
        if (k >= d.length) goto _L6; else goto _L5
_L5:
        j = j * 31 + d[k];
        k++;
          goto _L7
          goto _L6
_L4:
        j = 0;
_L10:
        k = i;
        if (j >= h.length) goto _L9; else goto _L8
_L8:
        if (h[j] == null)
        {
            k = 0;
        } else
        {
            k = h[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L10
    }
}
