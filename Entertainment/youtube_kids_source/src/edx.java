// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class edx extends eul
{

    private dlb a;
    private edy b;
    private dlb c[];
    private dlb d[];
    private dre e;
    private dlb f;
    private edw g;
    private byte h[];
    private dlb i[];
    private dlb j[];

    public edx()
    {
        a = null;
        b = null;
        c = dlb.a;
        d = dlb.a;
        e = null;
        f = null;
        g = null;
        h = eup.f;
        i = dlb.a;
        j = dlb.a;
    }

    public final int a()
    {
        boolean flag = false;
        int k;
        int l;
        int i2;
        if (a != null)
        {
            k = euj.b(1, a) + 0;
        } else
        {
            k = 0;
        }
        l = k;
        if (b != null)
        {
            l = k + euj.b(2, b);
        }
        k = l;
        if (c != null)
        {
            dlb adlb[] = c;
            int j2 = adlb.length;
            int j1 = 0;
            do
            {
                k = l;
                if (j1 >= j2)
                {
                    break;
                }
                dlb dlb1 = adlb[j1];
                k = l;
                if (dlb1 != null)
                {
                    k = l + euj.b(4, dlb1);
                }
                j1++;
                l = k;
            } while (true);
        }
        l = k;
        if (d != null)
        {
            dlb adlb1[] = d;
            int k2 = adlb1.length;
            int k1 = 0;
            do
            {
                l = k;
                if (k1 >= k2)
                {
                    break;
                }
                dlb dlb2 = adlb1[k1];
                l = k;
                if (dlb2 != null)
                {
                    l = k + euj.b(5, dlb2);
                }
                k1++;
                k = l;
            } while (true);
        }
        k = l;
        if (e != null)
        {
            k = l + euj.b(6, e);
        }
        l = k;
        if (f != null)
        {
            l = k + euj.b(7, f);
        }
        k = l;
        if (g != null)
        {
            k = l + euj.b(8, g);
        }
        l = k;
        if (!Arrays.equals(h, eup.f))
        {
            l = k + euj.b(10, h);
        }
        k = l;
        if (i != null)
        {
            dlb adlb2[] = i;
            int l2 = adlb2.length;
            int l1 = 0;
            do
            {
                k = l;
                if (l1 >= l2)
                {
                    break;
                }
                dlb dlb3 = adlb2[l1];
                k = l;
                if (dlb3 != null)
                {
                    k = l + euj.b(11, dlb3);
                }
                l1++;
                l = k;
            } while (true);
        }
        i2 = k;
        if (j != null)
        {
            dlb adlb3[] = j;
            int i3 = adlb3.length;
            int i1 = ((flag) ? 1 : 0);
            do
            {
                i2 = k;
                if (i1 >= i3)
                {
                    break;
                }
                dlb dlb4 = adlb3[i1];
                i2 = k;
                if (dlb4 != null)
                {
                    i2 = k + euj.b(12, dlb4);
                }
                i1++;
                k = i2;
            } while (true);
        }
        k = i2 + eup.a(O);
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
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new edy();
                }
                eui1.a(b);
                break;

            case 34: // '"'
                int l1 = eup.a(eui1, 34);
                dlb adlb[];
                int l;
                if (c == null)
                {
                    l = 0;
                } else
                {
                    l = c.length;
                }
                adlb = new dlb[l1 + l];
                if (c != null)
                {
                    System.arraycopy(c, 0, adlb, 0, l);
                }
                for (c = adlb; l < c.length - 1; l++)
                {
                    c[l] = new dlb();
                    eui1.a(c[l]);
                    eui1.a();
                }

                c[l] = new dlb();
                eui1.a(c[l]);
                break;

            case 42: // '*'
                int i2 = eup.a(eui1, 42);
                dlb adlb1[];
                int i1;
                if (d == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = d.length;
                }
                adlb1 = new dlb[i2 + i1];
                if (d != null)
                {
                    System.arraycopy(d, 0, adlb1, 0, i1);
                }
                for (d = adlb1; i1 < d.length - 1; i1++)
                {
                    d[i1] = new dlb();
                    eui1.a(d[i1]);
                    eui1.a();
                }

                d[i1] = new dlb();
                eui1.a(d[i1]);
                break;

            case 50: // '2'
                if (e == null)
                {
                    e = new dre();
                }
                eui1.a(e);
                break;

            case 58: // ':'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 66: // 'B'
                if (g == null)
                {
                    g = new edw();
                }
                eui1.a(g);
                break;

            case 82: // 'R'
                h = eui1.g();
                break;

            case 90: // 'Z'
                int j2 = eup.a(eui1, 90);
                dlb adlb2[];
                int j1;
                if (i == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = i.length;
                }
                adlb2 = new dlb[j2 + j1];
                if (i != null)
                {
                    System.arraycopy(i, 0, adlb2, 0, j1);
                }
                for (i = adlb2; j1 < i.length - 1; j1++)
                {
                    i[j1] = new dlb();
                    eui1.a(i[j1]);
                    eui1.a();
                }

                i[j1] = new dlb();
                eui1.a(i[j1]);
                break;

            case 98: // 'b'
                int k2 = eup.a(eui1, 98);
                dlb adlb3[];
                int k1;
                if (j == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = j.length;
                }
                adlb3 = new dlb[k2 + k1];
                if (j != null)
                {
                    System.arraycopy(j, 0, adlb3, 0, k1);
                }
                for (j = adlb3; k1 < j.length - 1; k1++)
                {
                    j[k1] = new dlb();
                    eui1.a(j[k1]);
                    eui1.a();
                }

                j[k1] = new dlb();
                eui1.a(j[k1]);
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
            dlb adlb[] = c;
            int k1 = adlb.length;
            for (int k = 0; k < k1; k++)
            {
                dlb dlb1 = adlb[k];
                if (dlb1 != null)
                {
                    euj1.a(4, dlb1);
                }
            }

        }
        if (d != null)
        {
            dlb adlb1[] = d;
            int l1 = adlb1.length;
            for (int l = 0; l < l1; l++)
            {
                dlb dlb2 = adlb1[l];
                if (dlb2 != null)
                {
                    euj1.a(5, dlb2);
                }
            }

        }
        if (e != null)
        {
            euj1.a(6, e);
        }
        if (f != null)
        {
            euj1.a(7, f);
        }
        if (g != null)
        {
            euj1.a(8, g);
        }
        if (!Arrays.equals(h, eup.f))
        {
            euj1.a(10, h);
        }
        if (i != null)
        {
            dlb adlb2[] = i;
            int i2 = adlb2.length;
            for (int i1 = 0; i1 < i2; i1++)
            {
                dlb dlb3 = adlb2[i1];
                if (dlb3 != null)
                {
                    euj1.a(11, dlb3);
                }
            }

        }
        if (j != null)
        {
            dlb adlb3[] = j;
            int j2 = adlb3.length;
            for (int j1 = ((flag) ? 1 : 0); j1 < j2; j1++)
            {
                dlb dlb4 = adlb3[j1];
                if (dlb4 != null)
                {
                    euj1.a(12, dlb4);
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
            if (!(obj instanceof edx))
            {
                return false;
            }
            obj = (edx)obj;
            if ((a != null ? a.equals(((edx) (obj)).a) : ((edx) (obj)).a == null) && (b != null ? b.equals(((edx) (obj)).b) : ((edx) (obj)).b == null) && (Arrays.equals(c, ((edx) (obj)).c) && Arrays.equals(d, ((edx) (obj)).d)) && (e != null ? e.equals(((edx) (obj)).e) : ((edx) (obj)).e == null) && (f != null ? f.equals(((edx) (obj)).f) : ((edx) (obj)).f == null) && (g != null ? g.equals(((edx) (obj)).g) : ((edx) (obj)).g == null) && (Arrays.equals(h, ((edx) (obj)).h) && Arrays.equals(i, ((edx) (obj)).i) && Arrays.equals(j, ((edx) (obj)).j)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((edx) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((edx) (obj)).O))
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
        k = l + (k + (i1 + 527) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        l = k * 31;
_L12:
        if (d != null) goto _L4; else goto _L3
_L3:
        l *= 31;
_L15:
        int j1;
        if (e == null)
        {
            k = 0;
        } else
        {
            k = e.hashCode();
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
        l = j1 + (i1 + (k + l * 31) * 31) * 31;
        if (h != null) goto _L6; else goto _L5
_L5:
        k = l * 31;
_L18:
        if (i != null) goto _L8; else goto _L7
_L7:
        l = k * 31;
_L21:
        if (j != null) goto _L10; else goto _L9
_L9:
        i1 = l * 31;
_L24:
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
_L13:
        l = k;
        if (i1 >= c.length) goto _L12; else goto _L11
_L11:
        if (c[i1] == null)
        {
            l = 0;
        } else
        {
            l = c[i1].hashCode();
        }
        k = l + k * 31;
        i1++;
          goto _L13
          goto _L12
_L4:
        i1 = 0;
        k = l;
_L16:
        l = k;
        if (i1 >= d.length) goto _L15; else goto _L14
_L14:
        if (d[i1] == null)
        {
            l = 0;
        } else
        {
            l = d[i1].hashCode();
        }
        k = l + k * 31;
        i1++;
          goto _L16
          goto _L15
_L6:
        i1 = 0;
_L19:
        k = l;
        if (i1 >= h.length) goto _L18; else goto _L17
_L17:
        l = l * 31 + h[i1];
        i1++;
          goto _L19
          goto _L18
_L8:
        i1 = 0;
_L22:
        l = k;
        if (i1 >= i.length) goto _L21; else goto _L20
_L20:
        if (i[i1] == null)
        {
            l = 0;
        } else
        {
            l = i[i1].hashCode();
        }
        k = l + k * 31;
        i1++;
          goto _L22
          goto _L21
_L10:
        i1 = 0;
        k = l;
        l = i1;
_L25:
        i1 = k;
        if (l >= j.length) goto _L24; else goto _L23
_L23:
        if (j[l] == null)
        {
            i1 = 0;
        } else
        {
            i1 = j[l].hashCode();
        }
        k = i1 + k * 31;
        l++;
          goto _L25
    }
}
