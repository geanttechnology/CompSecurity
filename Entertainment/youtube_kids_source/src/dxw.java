// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dxw extends eul
{

    public byte a[];
    private boolean b;
    private String c;
    private dxs d[];
    private dxs e[];
    private dlb f;
    private dlb g;
    private dre h;
    private byte i[];
    private dxp j;

    public dxw()
    {
        b = false;
        c = "";
        d = dxs.a;
        e = dxs.a;
        f = null;
        g = null;
        h = null;
        i = eup.f;
        a = eup.f;
        j = null;
    }

    public final int a()
    {
        boolean flag = false;
        int k;
        int l;
        if (b)
        {
            boolean flag1 = b;
            k = euj.b(1) + 1 + 0;
        } else
        {
            k = 0;
        }
        l = k;
        if (!c.equals(""))
        {
            l = k + euj.b(2, c);
        }
        k = l;
        if (d != null)
        {
            dxs adxs[] = d;
            int k1 = adxs.length;
            int i1 = 0;
            do
            {
                k = l;
                if (i1 >= k1)
                {
                    break;
                }
                dxs dxs1 = adxs[i1];
                k = l;
                if (dxs1 != null)
                {
                    k = l + euj.b(3, dxs1);
                }
                i1++;
                l = k;
            } while (true);
        }
        l = k;
        if (e != null)
        {
            dxs adxs1[] = e;
            int l1 = adxs1.length;
            int j1 = ((flag) ? 1 : 0);
            do
            {
                l = k;
                if (j1 >= l1)
                {
                    break;
                }
                dxs dxs2 = adxs1[j1];
                l = k;
                if (dxs2 != null)
                {
                    l = k + euj.b(4, dxs2);
                }
                j1++;
                k = l;
            } while (true);
        }
        k = l;
        if (f != null)
        {
            k = l + euj.b(5, f);
        }
        l = k;
        if (g != null)
        {
            l = k + euj.b(6, g);
        }
        k = l;
        if (h != null)
        {
            k = l + euj.b(7, h);
        }
        l = k;
        if (!Arrays.equals(i, eup.f))
        {
            l = k + euj.b(8, i);
        }
        k = l;
        if (!Arrays.equals(a, eup.f))
        {
            k = l + euj.b(9, a);
        }
        l = k;
        if (j != null)
        {
            l = k + euj.b(11, j);
        }
        k = l + eup.a(O);
        P = k;
        return k;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int k = eui1.a();
            switch (k)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, k))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                b = eui1.e();
                break;

            case 18: // '\022'
                c = eui1.f();
                break;

            case 26: // '\032'
                int j1 = eup.a(eui1, 26);
                dxs adxs[];
                int l;
                if (d == null)
                {
                    l = 0;
                } else
                {
                    l = d.length;
                }
                adxs = new dxs[j1 + l];
                if (d != null)
                {
                    System.arraycopy(d, 0, adxs, 0, l);
                }
                for (d = adxs; l < d.length - 1; l++)
                {
                    d[l] = new dxs();
                    eui1.a(d[l]);
                    eui1.a();
                }

                d[l] = new dxs();
                eui1.a(d[l]);
                break;

            case 34: // '"'
                int k1 = eup.a(eui1, 34);
                dxs adxs1[];
                int i1;
                if (e == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = e.length;
                }
                adxs1 = new dxs[k1 + i1];
                if (e != null)
                {
                    System.arraycopy(e, 0, adxs1, 0, i1);
                }
                for (e = adxs1; i1 < e.length - 1; i1++)
                {
                    e[i1] = new dxs();
                    eui1.a(e[i1]);
                    eui1.a();
                }

                e[i1] = new dxs();
                eui1.a(e[i1]);
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
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 58: // ':'
                if (h == null)
                {
                    h = new dre();
                }
                eui1.a(h);
                break;

            case 66: // 'B'
                i = eui1.g();
                break;

            case 74: // 'J'
                a = eui1.g();
                break;

            case 90: // 'Z'
                if (j == null)
                {
                    j = new dxp();
                }
                eui1.a(j);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (b)
        {
            euj1.a(1, b);
        }
        if (!c.equals(""))
        {
            euj1.a(2, c);
        }
        if (d != null)
        {
            dxs adxs[] = d;
            int i1 = adxs.length;
            for (int k = 0; k < i1; k++)
            {
                dxs dxs1 = adxs[k];
                if (dxs1 != null)
                {
                    euj1.a(3, dxs1);
                }
            }

        }
        if (e != null)
        {
            dxs adxs1[] = e;
            int j1 = adxs1.length;
            for (int l = ((flag) ? 1 : 0); l < j1; l++)
            {
                dxs dxs2 = adxs1[l];
                if (dxs2 != null)
                {
                    euj1.a(4, dxs2);
                }
            }

        }
        if (f != null)
        {
            euj1.a(5, f);
        }
        if (g != null)
        {
            euj1.a(6, g);
        }
        if (h != null)
        {
            euj1.a(7, h);
        }
        if (!Arrays.equals(i, eup.f))
        {
            euj1.a(8, i);
        }
        if (!Arrays.equals(a, eup.f))
        {
            euj1.a(9, a);
        }
        if (j != null)
        {
            euj1.a(11, j);
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
            if (!(obj instanceof dxw))
            {
                return false;
            }
            obj = (dxw)obj;
            if (b == ((dxw) (obj)).b && (c != null ? c.equals(((dxw) (obj)).c) : ((dxw) (obj)).c == null) && (Arrays.equals(d, ((dxw) (obj)).d) && Arrays.equals(e, ((dxw) (obj)).e)) && (f != null ? f.equals(((dxw) (obj)).f) : ((dxw) (obj)).f == null) && (g != null ? g.equals(((dxw) (obj)).g) : ((dxw) (obj)).g == null) && (h != null ? h.equals(((dxw) (obj)).h) : ((dxw) (obj)).h == null) && (Arrays.equals(i, ((dxw) (obj)).i) && Arrays.equals(a, ((dxw) (obj)).a)) && (j != null ? j.equals(((dxw) (obj)).j) : ((dxw) (obj)).j == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dxw) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dxw) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k;
        int l;
        int i1;
        boolean flag = false;
        i1 = getClass().getName().hashCode();
        if (b)
        {
            k = 1;
        } else
        {
            k = 2;
        }
        if (c == null)
        {
            l = 0;
        } else
        {
            l = c.hashCode();
        }
        k = l + (k + (i1 + 527) * 31) * 31;
        if (d != null) goto _L2; else goto _L1
_L1:
        l = k * 31;
_L10:
        if (e != null) goto _L4; else goto _L3
_L3:
        l *= 31;
_L13:
        int j1;
        if (f == null)
        {
            k = 0;
        } else
        {
            k = f.hashCode();
        }
        if (g == null)
        {
            i1 = 0;
        } else
        {
            i1 = g.hashCode();
        }
        if (h == null)
        {
            j1 = 0;
        } else
        {
            j1 = h.hashCode();
        }
        l = j1 + (i1 + (k + l * 31) * 31) * 31;
        if (i != null) goto _L6; else goto _L5
_L5:
        k = l * 31;
_L16:
        if (a != null) goto _L8; else goto _L7
_L7:
        l = k * 31;
_L19:
        if (j == null)
        {
            k = 0;
        } else
        {
            k = j.hashCode();
        }
        if (O == null)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = O.hashCode();
        }
        return (k + l * 31) * 31 + i1;
_L2:
        i1 = 0;
_L11:
        l = k;
        if (i1 >= d.length) goto _L10; else goto _L9
_L9:
        if (d[i1] == null)
        {
            l = 0;
        } else
        {
            l = d[i1].hashCode();
        }
        k = l + k * 31;
        i1++;
          goto _L11
          goto _L10
_L4:
        i1 = 0;
        k = l;
_L14:
        l = k;
        if (i1 >= e.length) goto _L13; else goto _L12
_L12:
        if (e[i1] == null)
        {
            l = 0;
        } else
        {
            l = e[i1].hashCode();
        }
        k = l + k * 31;
        i1++;
          goto _L14
          goto _L13
_L6:
        i1 = 0;
_L17:
        k = l;
        if (i1 >= i.length) goto _L16; else goto _L15
_L15:
        l = l * 31 + i[i1];
        i1++;
          goto _L17
          goto _L16
_L8:
        i1 = 0;
_L20:
        l = k;
        if (i1 >= a.length) goto _L19; else goto _L18
_L18:
        k = k * 31 + a[i1];
        i1++;
          goto _L20
    }
}
