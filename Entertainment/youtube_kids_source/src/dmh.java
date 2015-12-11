// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dmh extends eul
{

    public dzv a[];
    private dch b;
    private String c;
    private dqb d[];
    private dmk e;
    private dkn f[];
    private dcg g[];
    private dsi h;

    public dmh()
    {
        b = null;
        c = "";
        d = dqb.a;
        a = dzv.a;
        e = null;
        f = dkn.a;
        g = dcg.a;
        h = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int l;
        if (b != null)
        {
            i = euj.b(1, b) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (!c.equals(""))
        {
            j = i + euj.b(2, c);
        }
        i = j;
        if (d != null)
        {
            dqb adqb[] = d;
            int k1 = adqb.length;
            int k = 0;
            do
            {
                i = j;
                if (k >= k1)
                {
                    break;
                }
                dqb dqb1 = adqb[k];
                i = j;
                if (dqb1 != null)
                {
                    i = j + euj.b(3, dqb1);
                }
                k++;
                j = i;
            } while (true);
        }
        l = i;
        if (a != null)
        {
            dzv adzv[] = a;
            int l1 = adzv.length;
            j = 0;
            do
            {
                l = i;
                if (j >= l1)
                {
                    break;
                }
                dzv dzv1 = adzv[j];
                l = i;
                if (dzv1 != null)
                {
                    l = i + euj.b(4, dzv1);
                }
                j++;
                i = l;
            } while (true);
        }
        j = l;
        if (e != null)
        {
            j = l + euj.b(5, e);
        }
        i = j;
        if (f != null)
        {
            dkn adkn[] = f;
            int i2 = adkn.length;
            int i1 = 0;
            do
            {
                i = j;
                if (i1 >= i2)
                {
                    break;
                }
                dkn dkn1 = adkn[i1];
                i = j;
                if (dkn1 != null)
                {
                    i = j + euj.b(6, dkn1);
                }
                i1++;
                j = i;
            } while (true);
        }
        j = i;
        if (g != null)
        {
            dcg adcg[] = g;
            int j2 = adcg.length;
            int j1 = ((flag) ? 1 : 0);
            do
            {
                j = i;
                if (j1 >= j2)
                {
                    break;
                }
                dcg dcg1 = adcg[j1];
                j = i;
                if (dcg1 != null)
                {
                    j = i + euj.b(7, dcg1);
                }
                j1++;
                i = j;
            } while (true);
        }
        i = j;
        if (h != null)
        {
            i = j + euj.b(8, h);
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
                if (b == null)
                {
                    b = new dch();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                c = eui1.f();
                break;

            case 26: // '\032'
                int j1 = eup.a(eui1, 26);
                dqb adqb[];
                int j;
                if (d == null)
                {
                    j = 0;
                } else
                {
                    j = d.length;
                }
                adqb = new dqb[j1 + j];
                if (d != null)
                {
                    System.arraycopy(d, 0, adqb, 0, j);
                }
                for (d = adqb; j < d.length - 1; j++)
                {
                    d[j] = new dqb();
                    eui1.a(d[j]);
                    eui1.a();
                }

                d[j] = new dqb();
                eui1.a(d[j]);
                break;

            case 34: // '"'
                int k1 = eup.a(eui1, 34);
                dzv adzv[];
                int k;
                if (a == null)
                {
                    k = 0;
                } else
                {
                    k = a.length;
                }
                adzv = new dzv[k1 + k];
                if (a != null)
                {
                    System.arraycopy(a, 0, adzv, 0, k);
                }
                for (a = adzv; k < a.length - 1; k++)
                {
                    a[k] = new dzv();
                    eui1.a(a[k]);
                    eui1.a();
                }

                a[k] = new dzv();
                eui1.a(a[k]);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dmk();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                int l1 = eup.a(eui1, 50);
                dkn adkn[];
                int l;
                if (f == null)
                {
                    l = 0;
                } else
                {
                    l = f.length;
                }
                adkn = new dkn[l1 + l];
                if (f != null)
                {
                    System.arraycopy(f, 0, adkn, 0, l);
                }
                for (f = adkn; l < f.length - 1; l++)
                {
                    f[l] = new dkn();
                    eui1.a(f[l]);
                    eui1.a();
                }

                f[l] = new dkn();
                eui1.a(f[l]);
                break;

            case 58: // ':'
                int i2 = eup.a(eui1, 58);
                dcg adcg[];
                int i1;
                if (g == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = g.length;
                }
                adcg = new dcg[i2 + i1];
                if (g != null)
                {
                    System.arraycopy(g, 0, adcg, 0, i1);
                }
                for (g = adcg; i1 < g.length - 1; i1++)
                {
                    g[i1] = new dcg();
                    eui1.a(g[i1]);
                    eui1.a();
                }

                g[i1] = new dcg();
                eui1.a(g[i1]);
                break;

            case 66: // 'B'
                if (h == null)
                {
                    h = new dsi();
                }
                eui1.a(h);
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
        if (!c.equals(""))
        {
            euj1.a(2, c);
        }
        if (d != null)
        {
            dqb adqb[] = d;
            int i1 = adqb.length;
            for (int i = 0; i < i1; i++)
            {
                dqb dqb1 = adqb[i];
                if (dqb1 != null)
                {
                    euj1.a(3, dqb1);
                }
            }

        }
        if (a != null)
        {
            dzv adzv[] = a;
            int j1 = adzv.length;
            for (int j = 0; j < j1; j++)
            {
                dzv dzv1 = adzv[j];
                if (dzv1 != null)
                {
                    euj1.a(4, dzv1);
                }
            }

        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f != null)
        {
            dkn adkn[] = f;
            int k1 = adkn.length;
            for (int k = 0; k < k1; k++)
            {
                dkn dkn1 = adkn[k];
                if (dkn1 != null)
                {
                    euj1.a(6, dkn1);
                }
            }

        }
        if (g != null)
        {
            dcg adcg[] = g;
            int l1 = adcg.length;
            for (int l = ((flag) ? 1 : 0); l < l1; l++)
            {
                dcg dcg1 = adcg[l];
                if (dcg1 != null)
                {
                    euj1.a(7, dcg1);
                }
            }

        }
        if (h != null)
        {
            euj1.a(8, h);
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
            if (!(obj instanceof dmh))
            {
                return false;
            }
            obj = (dmh)obj;
            if ((b != null ? b.equals(((dmh) (obj)).b) : ((dmh) (obj)).b == null) && (c != null ? c.equals(((dmh) (obj)).c) : ((dmh) (obj)).c == null) && (Arrays.equals(d, ((dmh) (obj)).d) && Arrays.equals(a, ((dmh) (obj)).a)) && (e != null ? e.equals(((dmh) (obj)).e) : ((dmh) (obj)).e == null) && (Arrays.equals(f, ((dmh) (obj)).f) && Arrays.equals(g, ((dmh) (obj)).g)) && (h != null ? h.equals(((dmh) (obj)).h) : ((dmh) (obj)).h == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmh) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmh) (obj)).O))
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
        i = j + (i + (k + 527) * 31) * 31;
        if (d != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L10:
        if (a != null) goto _L4; else goto _L3
_L3:
        k = j * 31;
_L13:
        if (e == null)
        {
            i = 0;
        } else
        {
            i = e.hashCode();
        }
        i += k * 31;
        if (f != null) goto _L6; else goto _L5
_L5:
        j = i * 31;
_L16:
        if (g != null) goto _L8; else goto _L7
_L7:
        j *= 31;
_L19:
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
_L11:
        j = i;
        if (k >= d.length) goto _L10; else goto _L9
_L9:
        if (d[k] == null)
        {
            j = 0;
        } else
        {
            j = d[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L11
          goto _L10
_L4:
        k = 0;
        i = j;
        j = k;
_L14:
        k = i;
        if (j >= a.length) goto _L13; else goto _L12
_L12:
        if (a[j] == null)
        {
            k = 0;
        } else
        {
            k = a[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L14
          goto _L13
_L6:
        k = 0;
_L17:
        j = i;
        if (k >= f.length) goto _L16; else goto _L15
_L15:
        if (f[k] == null)
        {
            j = 0;
        } else
        {
            j = f[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L17
          goto _L16
_L8:
        k = 0;
        i = j;
_L20:
        j = i;
        if (k >= g.length) goto _L19; else goto _L18
_L18:
        if (g[k] == null)
        {
            j = 0;
        } else
        {
            j = g[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L20
    }
}
