// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ebg extends eul
{

    private String a;
    private ebm b;
    private ebj c;
    private dlb d;
    private dzp e;
    private ebl f;
    private ebi g[];
    private boolean h;
    private ebk i[];
    private dre j;

    public ebg()
    {
        a = "";
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = ebi.a;
        h = false;
        i = ebk.a;
        j = null;
    }

    public final int a()
    {
        boolean flag = false;
        int k;
        int l;
        if (!a.equals(""))
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
        k = l;
        if (d != null)
        {
            k = l + euj.b(4, d);
        }
        l = k;
        if (e != null)
        {
            l = k + euj.b(5, e);
        }
        k = l;
        if (f != null)
        {
            k = l + euj.b(6, f);
        }
        l = k;
        if (g != null)
        {
            ebi aebi[] = g;
            int k1 = aebi.length;
            int i1 = 0;
            do
            {
                l = k;
                if (i1 >= k1)
                {
                    break;
                }
                ebi ebi1 = aebi[i1];
                l = k;
                if (ebi1 != null)
                {
                    l = k + euj.b(7, ebi1);
                }
                i1++;
                k = l;
            } while (true);
        }
        k = l;
        if (h)
        {
            boolean flag1 = h;
            k = l + (euj.b(8) + 1);
        }
        l = k;
        if (i != null)
        {
            ebk aebk[] = i;
            int l1 = aebk.length;
            int j1 = ((flag) ? 1 : 0);
            do
            {
                l = k;
                if (j1 >= l1)
                {
                    break;
                }
                ebk ebk1 = aebk[j1];
                l = k;
                if (ebk1 != null)
                {
                    l = k + euj.b(9, ebk1);
                }
                j1++;
                k = l;
            } while (true);
        }
        k = l;
        if (j != null)
        {
            k = l + euj.b(11, j);
        }
        k += eup.a(O);
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
                a = eui1.f();
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new ebm();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new ebj();
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
                    e = new dzp();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new ebl();
                }
                eui1.a(f);
                break;

            case 58: // ':'
                int j1 = eup.a(eui1, 58);
                ebi aebi[];
                int l;
                if (g == null)
                {
                    l = 0;
                } else
                {
                    l = g.length;
                }
                aebi = new ebi[j1 + l];
                if (g != null)
                {
                    System.arraycopy(g, 0, aebi, 0, l);
                }
                for (g = aebi; l < g.length - 1; l++)
                {
                    g[l] = new ebi();
                    eui1.a(g[l]);
                    eui1.a();
                }

                g[l] = new ebi();
                eui1.a(g[l]);
                break;

            case 64: // '@'
                h = eui1.e();
                break;

            case 74: // 'J'
                int k1 = eup.a(eui1, 74);
                ebk aebk[];
                int i1;
                if (i == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = i.length;
                }
                aebk = new ebk[k1 + i1];
                if (i != null)
                {
                    System.arraycopy(i, 0, aebk, 0, i1);
                }
                for (i = aebk; i1 < i.length - 1; i1++)
                {
                    i[i1] = new ebk();
                    eui1.a(i[i1]);
                    eui1.a();
                }

                i[i1] = new ebk();
                eui1.a(i[i1]);
                break;

            case 90: // 'Z'
                if (j == null)
                {
                    j = new dre();
                }
                eui1.a(j);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!a.equals(""))
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
            ebi aebi[] = g;
            int i1 = aebi.length;
            for (int k = 0; k < i1; k++)
            {
                ebi ebi1 = aebi[k];
                if (ebi1 != null)
                {
                    euj1.a(7, ebi1);
                }
            }

        }
        if (h)
        {
            euj1.a(8, h);
        }
        if (i != null)
        {
            ebk aebk[] = i;
            int j1 = aebk.length;
            for (int l = ((flag) ? 1 : 0); l < j1; l++)
            {
                ebk ebk1 = aebk[l];
                if (ebk1 != null)
                {
                    euj1.a(9, ebk1);
                }
            }

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
            if (!(obj instanceof ebg))
            {
                return false;
            }
            obj = (ebg)obj;
            if ((a != null ? a.equals(((ebg) (obj)).a) : ((ebg) (obj)).a == null) && (b != null ? b.equals(((ebg) (obj)).b) : ((ebg) (obj)).b == null) && (c != null ? c.equals(((ebg) (obj)).c) : ((ebg) (obj)).c == null) && (d != null ? d.equals(((ebg) (obj)).d) : ((ebg) (obj)).d == null) && (e != null ? e.equals(((ebg) (obj)).e) : ((ebg) (obj)).e == null) && (f != null ? f.equals(((ebg) (obj)).f) : ((ebg) (obj)).f == null) && (Arrays.equals(g, ((ebg) (obj)).g) && h == ((ebg) (obj)).h && Arrays.equals(i, ((ebg) (obj)).i)) && (j != null ? j.equals(((ebg) (obj)).j) : ((ebg) (obj)).j == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ebg) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ebg) (obj)).O))
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
        int i2 = getClass().getName().hashCode();
        int j1;
        int k1;
        int l1;
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
        if (f == null)
        {
            l1 = 0;
        } else
        {
            l1 = f.hashCode();
        }
        k = l1 + (k1 + (j1 + (i1 + (l + (k + (i2 + 527) * 31) * 31) * 31) * 31) * 31) * 31;
        if (g != null) goto _L2; else goto _L1
_L1:
        i1 = k * 31;
_L6:
        if (h)
        {
            k = 1;
        } else
        {
            k = 2;
        }
        k += i1 * 31;
        if (i != null) goto _L4; else goto _L3
_L3:
        l = k * 31;
_L9:
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
        l = 0;
_L7:
        i1 = k;
        if (l >= g.length) goto _L6; else goto _L5
_L5:
        if (g[l] == null)
        {
            i1 = 0;
        } else
        {
            i1 = g[l].hashCode();
        }
        k = i1 + k * 31;
        l++;
          goto _L7
          goto _L6
_L4:
        i1 = 0;
_L10:
        l = k;
        if (i1 >= i.length) goto _L9; else goto _L8
_L8:
        if (i[i1] == null)
        {
            l = 0;
        } else
        {
            l = i[i1].hashCode();
        }
        k = l + k * 31;
        i1++;
          goto _L10
    }
}
