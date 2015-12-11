// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dmp extends eul
{

    public static final dmp a[] = new dmp[0];
    public int b;
    public String c;
    public String d;
    public dnd e[];
    private String f;
    private dmx g;
    private String h;

    public dmp()
    {
        b = 0;
        f = "";
        c = "";
        d = "";
        g = null;
        e = dnd.a;
        h = "";
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int k;
        if (b != 0)
        {
            j = euj.c(1, b) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (!f.equals(""))
        {
            i = j + euj.b(2, f);
        }
        j = i;
        if (!c.equals(""))
        {
            j = i + euj.b(3, c);
        }
        k = j;
        if (!d.equals(""))
        {
            k = j + euj.b(4, d);
        }
        i = k;
        if (g != null)
        {
            i = k + euj.b(5, g);
        }
        j = i;
        if (e != null)
        {
            dnd adnd[] = e;
            int i1 = adnd.length;
            int l = ((flag) ? 1 : 0);
            do
            {
                j = i;
                if (l >= i1)
                {
                    break;
                }
                dnd dnd1 = adnd[l];
                j = i;
                if (dnd1 != null)
                {
                    j = i + euj.b(6, dnd1);
                }
                l++;
                i = j;
            } while (true);
        }
        i = j;
        if (!h.equals(""))
        {
            i = j + euj.b(7, h);
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

            case 8: // '\b'
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2 || j == 3 || j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10 || j == 11 || j == 12 || j == 13 || j == 14 || j == 15 || j == 16 || j == 17 || j == 18 || j == 19)
                {
                    b = j;
                } else
                {
                    b = 0;
                }
                break;

            case 18: // '\022'
                f = eui1.f();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 34: // '"'
                d = eui1.f();
                break;

            case 42: // '*'
                if (g == null)
                {
                    g = new dmx();
                }
                eui1.a(g);
                break;

            case 50: // '2'
                int l = eup.a(eui1, 50);
                dnd adnd[];
                int k;
                if (e == null)
                {
                    k = 0;
                } else
                {
                    k = e.length;
                }
                adnd = new dnd[l + k];
                if (e != null)
                {
                    System.arraycopy(e, 0, adnd, 0, k);
                }
                for (e = adnd; k < e.length - 1; k++)
                {
                    e[k] = new dnd();
                    eui1.a(e[k]);
                    eui1.a();
                }

                e[k] = new dnd();
                eui1.a(e[k]);
                break;

            case 58: // ':'
                h = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != 0)
        {
            euj1.a(1, b);
        }
        if (!f.equals(""))
        {
            euj1.a(2, f);
        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (!d.equals(""))
        {
            euj1.a(4, d);
        }
        if (g != null)
        {
            euj1.a(5, g);
        }
        if (e != null)
        {
            dnd adnd[] = e;
            int j = adnd.length;
            for (int i = 0; i < j; i++)
            {
                dnd dnd1 = adnd[i];
                if (dnd1 != null)
                {
                    euj1.a(6, dnd1);
                }
            }

        }
        if (!h.equals(""))
        {
            euj1.a(7, h);
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
            if (!(obj instanceof dmp))
            {
                return false;
            }
            obj = (dmp)obj;
            if (b == ((dmp) (obj)).b && (f != null ? f.equals(((dmp) (obj)).f) : ((dmp) (obj)).f == null) && (c != null ? c.equals(((dmp) (obj)).c) : ((dmp) (obj)).c == null) && (d != null ? d.equals(((dmp) (obj)).d) : ((dmp) (obj)).d == null) && (g != null ? g.equals(((dmp) (obj)).g) : ((dmp) (obj)).g == null) && Arrays.equals(e, ((dmp) (obj)).e) && (h != null ? h.equals(((dmp) (obj)).h) : ((dmp) (obj)).h == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmp) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmp) (obj)).O))
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
        int j1 = b;
        int l;
        if (f == null)
        {
            i = 0;
        } else
        {
            i = f.hashCode();
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
        if (g == null)
        {
            l = 0;
        } else
        {
            l = g.hashCode();
        }
        i = l + (k + (j + (i + ((i1 + 527) * 31 + j1) * 31) * 31) * 31) * 31;
        if (e != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        if (h == null)
        {
            i = 0;
        } else
        {
            i = h.hashCode();
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
