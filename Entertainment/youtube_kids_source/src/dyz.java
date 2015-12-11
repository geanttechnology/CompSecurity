// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dyz extends eul
{

    public long a;
    public dla b[];
    public dla c[];
    public String d;
    public String e;
    public dov f[];
    private dla g[];
    private String h;

    public dyz()
    {
        a = 0L;
        b = dla.a;
        c = dla.a;
        d = "";
        e = "";
        g = dla.a;
        h = "";
        f = dov.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int i1;
        if (a != 0L)
        {
            j = euj.d(1, a) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (b != null)
        {
            dla adla[] = b;
            int j1 = adla.length;
            int k = 0;
            do
            {
                i = j;
                if (k >= j1)
                {
                    break;
                }
                dla dla1 = adla[k];
                i = j;
                if (dla1 != null)
                {
                    i = j + euj.b(2, dla1);
                }
                k++;
                j = i;
            } while (true);
        }
        j = i;
        if (c != null)
        {
            dla adla1[] = c;
            int k1 = adla1.length;
            int l = 0;
            do
            {
                j = i;
                if (l >= k1)
                {
                    break;
                }
                dla dla2 = adla1[l];
                j = i;
                if (dla2 != null)
                {
                    j = i + euj.b(3, dla2);
                }
                l++;
                i = j;
            } while (true);
        }
        i1 = j;
        if (!d.equals(""))
        {
            i1 = j + euj.b(4, d);
        }
        i = i1;
        if (!e.equals(""))
        {
            i = i1 + euj.b(5, e);
        }
        j = i;
        if (g != null)
        {
            dla adla2[] = g;
            int l1 = adla2.length;
            i1 = 0;
            do
            {
                j = i;
                if (i1 >= l1)
                {
                    break;
                }
                dla dla3 = adla2[i1];
                j = i;
                if (dla3 != null)
                {
                    j = i + euj.b(6, dla3);
                }
                i1++;
                i = j;
            } while (true);
        }
        i = j;
        if (!h.equals(""))
        {
            i = j + euj.b(7, h);
        }
        i1 = i;
        if (f != null)
        {
            dov adov[] = f;
            int i2 = adov.length;
            j = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (j >= i2)
                {
                    break;
                }
                dov dov1 = adov[j];
                i1 = i;
                if (dov1 != null)
                {
                    i1 = i + euj.b(8, dov1);
                }
                j++;
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
                a = eui1.c();
                break;

            case 18: // '\022'
                int j1 = eup.a(eui1, 18);
                dla adla[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adla = new dla[j1 + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adla, 0, j);
                }
                for (b = adla; j < b.length - 1; j++)
                {
                    b[j] = new dla();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dla();
                eui1.a(b[j]);
                break;

            case 26: // '\032'
                int k1 = eup.a(eui1, 26);
                dla adla1[];
                int k;
                if (c == null)
                {
                    k = 0;
                } else
                {
                    k = c.length;
                }
                adla1 = new dla[k1 + k];
                if (c != null)
                {
                    System.arraycopy(c, 0, adla1, 0, k);
                }
                for (c = adla1; k < c.length - 1; k++)
                {
                    c[k] = new dla();
                    eui1.a(c[k]);
                    eui1.a();
                }

                c[k] = new dla();
                eui1.a(c[k]);
                break;

            case 34: // '"'
                d = eui1.f();
                break;

            case 42: // '*'
                e = eui1.f();
                break;

            case 50: // '2'
                int l1 = eup.a(eui1, 50);
                dla adla2[];
                int l;
                if (g == null)
                {
                    l = 0;
                } else
                {
                    l = g.length;
                }
                adla2 = new dla[l1 + l];
                if (g != null)
                {
                    System.arraycopy(g, 0, adla2, 0, l);
                }
                for (g = adla2; l < g.length - 1; l++)
                {
                    g[l] = new dla();
                    eui1.a(g[l]);
                    eui1.a();
                }

                g[l] = new dla();
                eui1.a(g[l]);
                break;

            case 58: // ':'
                h = eui1.f();
                break;

            case 66: // 'B'
                int i2 = eup.a(eui1, 66);
                dov adov[];
                int i1;
                if (f == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = f.length;
                }
                adov = new dov[i2 + i1];
                if (f != null)
                {
                    System.arraycopy(f, 0, adov, 0, i1);
                }
                for (f = adov; i1 < f.length - 1; i1++)
                {
                    f[i1] = new dov();
                    eui1.a(f[i1]);
                    eui1.a();
                }

                f[i1] = new dov();
                eui1.a(f[i1]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != 0L)
        {
            euj1.b(1, a);
        }
        if (b != null)
        {
            dla adla[] = b;
            int i1 = adla.length;
            for (int i = 0; i < i1; i++)
            {
                dla dla1 = adla[i];
                if (dla1 != null)
                {
                    euj1.a(2, dla1);
                }
            }

        }
        if (c != null)
        {
            dla adla1[] = c;
            int j1 = adla1.length;
            for (int j = 0; j < j1; j++)
            {
                dla dla2 = adla1[j];
                if (dla2 != null)
                {
                    euj1.a(3, dla2);
                }
            }

        }
        if (!d.equals(""))
        {
            euj1.a(4, d);
        }
        if (!e.equals(""))
        {
            euj1.a(5, e);
        }
        if (g != null)
        {
            dla adla2[] = g;
            int k1 = adla2.length;
            for (int k = 0; k < k1; k++)
            {
                dla dla3 = adla2[k];
                if (dla3 != null)
                {
                    euj1.a(6, dla3);
                }
            }

        }
        if (!h.equals(""))
        {
            euj1.a(7, h);
        }
        if (f != null)
        {
            dov adov[] = f;
            int l1 = adov.length;
            for (int l = ((flag) ? 1 : 0); l < l1; l++)
            {
                dov dov1 = adov[l];
                if (dov1 != null)
                {
                    euj1.a(8, dov1);
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
            if (!(obj instanceof dyz))
            {
                return false;
            }
            obj = (dyz)obj;
            if (a == ((dyz) (obj)).a && Arrays.equals(b, ((dyz) (obj)).b) && Arrays.equals(c, ((dyz) (obj)).c) && (d != null ? d.equals(((dyz) (obj)).d) : ((dyz) (obj)).d == null) && (e != null ? e.equals(((dyz) (obj)).e) : ((dyz) (obj)).e == null) && Arrays.equals(g, ((dyz) (obj)).g) && (h != null ? h.equals(((dyz) (obj)).h) : ((dyz) (obj)).h == null) && Arrays.equals(f, ((dyz) (obj)).f))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dyz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dyz) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        boolean flag;
        flag = false;
        i = (getClass().getName().hashCode() + 527) * 31 + (int)(a ^ a >>> 32);
        if (b != null) goto _L2; else goto _L1
_L1:
        int j = i * 31;
_L10:
        if (c != null) goto _L4; else goto _L3
_L3:
        j *= 31;
_L13:
        int k;
        if (d == null)
        {
            i = 0;
        } else
        {
            i = d.hashCode();
        }
        if (e == null)
        {
            k = 0;
        } else
        {
            k = e.hashCode();
        }
        i = k + (i + j * 31) * 31;
        if (g != null) goto _L6; else goto _L5
_L5:
        k = i * 31;
_L16:
        if (h == null)
        {
            i = 0;
        } else
        {
            i = h.hashCode();
        }
        i += k * 31;
        if (f != null) goto _L8; else goto _L7
_L7:
        k = i * 31;
_L19:
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
_L11:
        j = i;
        if (k >= b.length) goto _L10; else goto _L9
_L9:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L11
          goto _L10
_L4:
        k = 0;
        i = j;
_L14:
        j = i;
        if (k >= c.length) goto _L13; else goto _L12
_L12:
        if (c[k] == null)
        {
            j = 0;
        } else
        {
            j = c[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L14
          goto _L13
_L6:
        j = 0;
_L17:
        k = i;
        if (j >= g.length) goto _L16; else goto _L15
_L15:
        if (g[j] == null)
        {
            k = 0;
        } else
        {
            k = g[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L17
          goto _L16
_L8:
        j = 0;
_L20:
        k = i;
        if (j >= f.length) goto _L19; else goto _L18
_L18:
        if (f[j] == null)
        {
            k = 0;
        } else
        {
            k = f[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L20
    }
}
