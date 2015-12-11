// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dyi extends eul
{

    private dzp a;
    private dlb b;
    private dlb c;
    private dms d;
    private dmt e;
    private String f[];
    private byte g[];
    private dlb h;
    private boolean i;
    private String j[];

    public dyi()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = eup.d;
        g = eup.f;
        h = null;
        i = false;
        j = eup.d;
    }

    public final int a()
    {
        boolean flag = false;
        int k;
        int l;
        int i1;
        if (a != null)
        {
            l = euj.b(1, a) + 0;
        } else
        {
            l = 0;
        }
        k = l;
        if (b != null)
        {
            k = l + euj.b(2, b);
        }
        l = k;
        if (c != null)
        {
            l = k + euj.b(3, c);
        }
        i1 = l;
        if (d != null)
        {
            i1 = l + euj.b(4, d);
        }
        k = i1;
        if (e != null)
        {
            k = i1 + euj.b(5, e);
        }
        l = k;
        if (f != null)
        {
            l = k;
            if (f.length > 0)
            {
                String as[] = f;
                int l1 = as.length;
                l = 0;
                int j1 = 0;
                for (; l < l1; l++)
                {
                    j1 += euj.a(as[l]);
                }

                l = k + j1 + f.length * 1;
            }
        }
        k = l;
        if (!Arrays.equals(g, eup.f))
        {
            k = l + euj.b(8, g);
        }
        l = k;
        if (h != null)
        {
            l = k + euj.b(9, h);
        }
        k = l;
        if (i)
        {
            boolean flag1 = i;
            k = l + (euj.b(10) + 1);
        }
        l = k;
        if (j != null)
        {
            l = k;
            if (j.length > 0)
            {
                String as1[] = j;
                int i2 = as1.length;
                int k1 = 0;
                for (l = ((flag) ? 1 : 0); l < i2; l++)
                {
                    k1 += euj.a(as1[l]);
                }

                l = k + k1 + j.length * 1;
            }
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
                    d = new dms();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dmt();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                int j1 = eup.a(eui1, 50);
                int l = f.length;
                String as[] = new String[j1 + l];
                System.arraycopy(f, 0, as, 0, l);
                for (f = as; l < f.length - 1; l++)
                {
                    f[l] = eui1.f();
                    eui1.a();
                }

                f[l] = eui1.f();
                break;

            case 66: // 'B'
                g = eui1.g();
                break;

            case 74: // 'J'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 80: // 'P'
                i = eui1.e();
                break;

            case 98: // 'b'
                int k1 = eup.a(eui1, 98);
                int i1 = j.length;
                String as1[] = new String[k1 + i1];
                System.arraycopy(j, 0, as1, 0, i1);
                for (j = as1; i1 < j.length - 1; i1++)
                {
                    j[i1] = eui1.f();
                    eui1.a();
                }

                j[i1] = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
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
            String as[] = f;
            int i1 = as.length;
            for (int k = 0; k < i1; k++)
            {
                euj1.a(6, as[k]);
            }

        }
        if (!Arrays.equals(g, eup.f))
        {
            euj1.a(8, g);
        }
        if (h != null)
        {
            euj1.a(9, h);
        }
        if (i)
        {
            euj1.a(10, i);
        }
        if (j != null)
        {
            String as1[] = j;
            int j1 = as1.length;
            for (int l = ((flag) ? 1 : 0); l < j1; l++)
            {
                euj1.a(12, as1[l]);
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
            if (!(obj instanceof dyi))
            {
                return false;
            }
            obj = (dyi)obj;
            if ((a != null ? a.equals(((dyi) (obj)).a) : ((dyi) (obj)).a == null) && (b != null ? b.equals(((dyi) (obj)).b) : ((dyi) (obj)).b == null) && (c != null ? c.equals(((dyi) (obj)).c) : ((dyi) (obj)).c == null) && (d != null ? d.equals(((dyi) (obj)).d) : ((dyi) (obj)).d == null) && (e != null ? e.equals(((dyi) (obj)).e) : ((dyi) (obj)).e == null) && (Arrays.equals(f, ((dyi) (obj)).f) && Arrays.equals(g, ((dyi) (obj)).g)) && (h != null ? h.equals(((dyi) (obj)).h) : ((dyi) (obj)).h == null) && (i == ((dyi) (obj)).i && Arrays.equals(j, ((dyi) (obj)).j)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dyi) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dyi) (obj)).O))
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
        int l1 = getClass().getName().hashCode();
        int j1;
        int k1;
        if (a == null)
        {
            k = 0;
        } else
        {
            k = a.hashCode();
        }
        if (b == null)
        {
            l = 0;
        } else
        {
            l = b.hashCode();
        }
        if (c == null)
        {
            i1 = 0;
        } else
        {
            i1 = c.hashCode();
        }
        if (d == null)
        {
            j1 = 0;
        } else
        {
            j1 = d.hashCode();
        }
        if (e == null)
        {
            k1 = 0;
        } else
        {
            k1 = e.hashCode();
        }
        k = k1 + (j1 + (i1 + (l + (k + (l1 + 527) * 31) * 31) * 31) * 31) * 31;
        if (f != null) goto _L2; else goto _L1
_L1:
        l = k * 31;
_L8:
        if (g != null) goto _L4; else goto _L3
_L3:
        k = l * 31;
_L11:
        if (h == null)
        {
            l = 0;
        } else
        {
            l = h.hashCode();
        }
        if (i)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        k = i1 + (l + k * 31) * 31;
        if (j != null) goto _L6; else goto _L5
_L5:
        i1 = k * 31;
_L14:
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return i1 * 31 + k;
_L2:
        i1 = 0;
_L9:
        l = k;
        if (i1 >= f.length) goto _L8; else goto _L7
_L7:
        if (f[i1] == null)
        {
            l = 0;
        } else
        {
            l = f[i1].hashCode();
        }
        k = l + k * 31;
        i1++;
          goto _L9
          goto _L8
_L4:
        i1 = 0;
_L12:
        k = l;
        if (i1 >= g.length) goto _L11; else goto _L10
_L10:
        l = l * 31 + g[i1];
        i1++;
          goto _L12
          goto _L11
_L6:
        l = 0;
_L15:
        i1 = k;
        if (l >= j.length) goto _L14; else goto _L13
_L13:
        if (j[l] == null)
        {
            i1 = 0;
        } else
        {
            i1 = j[l].hashCode();
        }
        k = i1 + k * 31;
        l++;
          goto _L15
    }
}
