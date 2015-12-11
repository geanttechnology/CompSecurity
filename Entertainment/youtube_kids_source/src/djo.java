// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class djo extends eul
{

    private dlb a;
    private dzp b;
    private ebj c;
    private ebl d;
    private ebk e[];
    private dre f;
    private dre g;
    private dre h;
    private dlb i;
    private dlb j;
    private dlb k;

    public djo()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = ebk.a;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
    }

    public final int a()
    {
        int j1 = 0;
        int l;
        int i1;
        if (a != null)
        {
            i1 = euj.b(1, a) + 0;
        } else
        {
            i1 = 0;
        }
        l = i1;
        if (b != null)
        {
            l = i1 + euj.b(2, b);
        }
        i1 = l;
        if (c != null)
        {
            i1 = l + euj.b(3, c);
        }
        l = i1;
        if (d != null)
        {
            l = i1 + euj.b(4, d);
        }
        i1 = l;
        if (e != null)
        {
            ebk aebk[] = e;
            int k1 = aebk.length;
            do
            {
                i1 = l;
                if (j1 >= k1)
                {
                    break;
                }
                ebk ebk1 = aebk[j1];
                i1 = l;
                if (ebk1 != null)
                {
                    i1 = l + euj.b(5, ebk1);
                }
                j1++;
                l = i1;
            } while (true);
        }
        l = i1;
        if (f != null)
        {
            l = i1 + euj.b(6, f);
        }
        i1 = l;
        if (g != null)
        {
            i1 = l + euj.b(7, g);
        }
        l = i1;
        if (h != null)
        {
            l = i1 + euj.b(9, h);
        }
        i1 = l;
        if (i != null)
        {
            i1 = l + euj.b(11, i);
        }
        l = i1;
        if (j != null)
        {
            l = i1 + euj.b(12, j);
        }
        i1 = l;
        if (k != null)
        {
            i1 = l + euj.b(13, k);
        }
        l = i1 + eup.a(O);
        P = l;
        return l;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int l = eui1.a();
            switch (l)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, l))
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
                    b = new dzp();
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
                    d = new ebl();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                int j1 = eup.a(eui1, 42);
                ebk aebk[];
                int i1;
                if (e == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = e.length;
                }
                aebk = new ebk[j1 + i1];
                if (e != null)
                {
                    System.arraycopy(e, 0, aebk, 0, i1);
                }
                for (e = aebk; i1 < e.length - 1; i1++)
                {
                    e[i1] = new ebk();
                    eui1.a(e[i1]);
                    eui1.a();
                }

                e[i1] = new ebk();
                eui1.a(e[i1]);
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new dre();
                }
                eui1.a(f);
                break;

            case 58: // ':'
                if (g == null)
                {
                    g = new dre();
                }
                eui1.a(g);
                break;

            case 74: // 'J'
                if (h == null)
                {
                    h = new dre();
                }
                eui1.a(h);
                break;

            case 90: // 'Z'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 98: // 'b'
                if (j == null)
                {
                    j = new dlb();
                }
                eui1.a(j);
                break;

            case 106: // 'j'
                if (k == null)
                {
                    k = new dlb();
                }
                eui1.a(k);
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
            ebk aebk[] = e;
            int i1 = aebk.length;
            for (int l = 0; l < i1; l++)
            {
                ebk ebk1 = aebk[l];
                if (ebk1 != null)
                {
                    euj1.a(5, ebk1);
                }
            }

        }
        if (f != null)
        {
            euj1.a(6, f);
        }
        if (g != null)
        {
            euj1.a(7, g);
        }
        if (h != null)
        {
            euj1.a(9, h);
        }
        if (i != null)
        {
            euj1.a(11, i);
        }
        if (j != null)
        {
            euj1.a(12, j);
        }
        if (k != null)
        {
            euj1.a(13, k);
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
            if (!(obj instanceof djo))
            {
                return false;
            }
            obj = (djo)obj;
            if ((a != null ? a.equals(((djo) (obj)).a) : ((djo) (obj)).a == null) && (b != null ? b.equals(((djo) (obj)).b) : ((djo) (obj)).b == null) && (c != null ? c.equals(((djo) (obj)).c) : ((djo) (obj)).c == null) && (d != null ? d.equals(((djo) (obj)).d) : ((djo) (obj)).d == null) && Arrays.equals(e, ((djo) (obj)).e) && (f != null ? f.equals(((djo) (obj)).f) : ((djo) (obj)).f == null) && (g != null ? g.equals(((djo) (obj)).g) : ((djo) (obj)).g == null) && (h != null ? h.equals(((djo) (obj)).h) : ((djo) (obj)).h == null) && (i != null ? i.equals(((djo) (obj)).i) : ((djo) (obj)).i == null) && (j != null ? j.equals(((djo) (obj)).j) : ((djo) (obj)).j == null) && (k != null ? k.equals(((djo) (obj)).k) : ((djo) (obj)).k == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((djo) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((djo) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l;
        int i1;
        int j1;
        int k1;
        int l2;
        l2 = 0;
        int l1 = getClass().getName().hashCode();
        if (a == null)
        {
            l = 0;
        } else
        {
            l = a.hashCode();
        }
        if (b == null)
        {
            i1 = 0;
        } else
        {
            i1 = b.hashCode();
        }
        if (c == null)
        {
            j1 = 0;
        } else
        {
            j1 = c.hashCode();
        }
        if (d == null)
        {
            k1 = 0;
        } else
        {
            k1 = d.hashCode();
        }
        l = k1 + (j1 + (i1 + (l + (l1 + 527) * 31) * 31) * 31) * 31;
        if (e != null) goto _L2; else goto _L1
_L1:
        i1 = l * 31;
_L4:
        int i2;
        int j2;
        int k2;
        if (f == null)
        {
            l = 0;
        } else
        {
            l = f.hashCode();
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
            i2 = 0;
        } else
        {
            i2 = i.hashCode();
        }
        if (j == null)
        {
            j2 = 0;
        } else
        {
            j2 = j.hashCode();
        }
        if (k == null)
        {
            k2 = 0;
        } else
        {
            k2 = k.hashCode();
        }
        if (O != null)
        {
            l2 = O.hashCode();
        }
        return (k2 + (j2 + (i2 + (k1 + (j1 + (l + i1 * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l2;
_L2:
        j1 = 0;
_L5:
        i1 = l;
        if (j1 >= e.length) goto _L4; else goto _L3
_L3:
        if (e[j1] == null)
        {
            i1 = 0;
        } else
        {
            i1 = e[j1].hashCode();
        }
        l = i1 + l * 31;
        j1++;
          goto _L5
    }
}
