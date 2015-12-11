// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dwa extends eul
{

    public String a;
    public int b;
    private djp c;
    private dxb d[];
    private String e;
    private boolean f;
    private String g;
    private String h;
    private String i;

    public dwa()
    {
        a = "";
        c = null;
        d = dxb.a;
        b = 0;
        e = "";
        f = false;
        g = "";
        h = "";
        i = "";
    }

    public final int a()
    {
        int l = 0;
        int j;
        int k;
        if (!a.equals(""))
        {
            k = euj.b(2, a) + 0;
        } else
        {
            k = 0;
        }
        j = k;
        if (c != null)
        {
            j = k + euj.b(5, c);
        }
        k = j;
        if (d != null)
        {
            dxb adxb[] = d;
            int i1 = adxb.length;
            do
            {
                k = j;
                if (l >= i1)
                {
                    break;
                }
                dxb dxb1 = adxb[l];
                k = j;
                if (dxb1 != null)
                {
                    k = j + euj.b(6, dxb1);
                }
                l++;
                j = k;
            } while (true);
        }
        j = k;
        if (b != 0)
        {
            j = k + euj.d(7, b);
        }
        k = j;
        if (!e.equals(""))
        {
            k = j + euj.b(8, e);
        }
        j = k;
        if (f)
        {
            boolean flag = f;
            j = k + (euj.b(9) + 1);
        }
        k = j;
        if (!g.equals(""))
        {
            k = j + euj.b(10, g);
        }
        j = k;
        if (!h.equals(""))
        {
            j = k + euj.b(11, h);
        }
        k = j;
        if (!i.equals(""))
        {
            k = j + euj.b(13, i);
        }
        j = k + eup.a(O);
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

            case 18: // '\022'
                a = eui1.f();
                break;

            case 42: // '*'
                if (c == null)
                {
                    c = new djp();
                }
                eui1.a(c);
                break;

            case 50: // '2'
                int l = eup.a(eui1, 50);
                dxb adxb[];
                int k;
                if (d == null)
                {
                    k = 0;
                } else
                {
                    k = d.length;
                }
                adxb = new dxb[l + k];
                if (d != null)
                {
                    System.arraycopy(d, 0, adxb, 0, k);
                }
                for (d = adxb; k < d.length - 1; k++)
                {
                    d[k] = new dxb();
                    eui1.a(d[k]);
                    eui1.a();
                }

                d[k] = new dxb();
                eui1.a(d[k]);
                break;

            case 56: // '8'
                b = eui1.h();
                break;

            case 66: // 'B'
                e = eui1.f();
                break;

            case 72: // 'H'
                f = eui1.e();
                break;

            case 82: // 'R'
                g = eui1.f();
                break;

            case 90: // 'Z'
                h = eui1.f();
                break;

            case 106: // 'j'
                i = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!a.equals(""))
        {
            euj1.a(2, a);
        }
        if (c != null)
        {
            euj1.a(5, c);
        }
        if (d != null)
        {
            dxb adxb[] = d;
            int k = adxb.length;
            for (int j = 0; j < k; j++)
            {
                dxb dxb1 = adxb[j];
                if (dxb1 != null)
                {
                    euj1.a(6, dxb1);
                }
            }

        }
        if (b != 0)
        {
            euj1.b(7, b);
        }
        if (!e.equals(""))
        {
            euj1.a(8, e);
        }
        if (f)
        {
            euj1.a(9, f);
        }
        if (!g.equals(""))
        {
            euj1.a(10, g);
        }
        if (!h.equals(""))
        {
            euj1.a(11, h);
        }
        if (!i.equals(""))
        {
            euj1.a(13, i);
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
            if (!(obj instanceof dwa))
            {
                return false;
            }
            obj = (dwa)obj;
            if ((a != null ? a.equals(((dwa) (obj)).a) : ((dwa) (obj)).a == null) && (c != null ? c.equals(((dwa) (obj)).c) : ((dwa) (obj)).c == null) && (Arrays.equals(d, ((dwa) (obj)).d) && b == ((dwa) (obj)).b) && (e != null ? e.equals(((dwa) (obj)).e) : ((dwa) (obj)).e == null) && f == ((dwa) (obj)).f && (g != null ? g.equals(((dwa) (obj)).g) : ((dwa) (obj)).g == null) && (h != null ? h.equals(((dwa) (obj)).h) : ((dwa) (obj)).h == null) && (i != null ? i.equals(((dwa) (obj)).i) : ((dwa) (obj)).i == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dwa) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dwa) (obj)).O))
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
        int i2;
        i2 = 0;
        int l = getClass().getName().hashCode();
        int j2;
        if (a == null)
        {
            j = 0;
        } else
        {
            j = a.hashCode();
        }
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        j = k + (j + (l + 527) * 31) * 31;
        if (d != null) goto _L2; else goto _L1
_L1:
        k = j * 31;
_L4:
        j2 = b;
        int i1;
        int j1;
        int k1;
        int l1;
        if (e == null)
        {
            j = 0;
        } else
        {
            j = e.hashCode();
        }
        if (f)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        if (g == null)
        {
            j1 = 0;
        } else
        {
            j1 = g.hashCode();
        }
        if (h == null)
        {
            k1 = 0;
        } else
        {
            k1 = h.hashCode();
        }
        if (i == null)
        {
            l1 = 0;
        } else
        {
            l1 = i.hashCode();
        }
        if (O != null)
        {
            i2 = O.hashCode();
        }
        return (l1 + (k1 + (j1 + (i1 + (j + (k * 31 + j2) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
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
