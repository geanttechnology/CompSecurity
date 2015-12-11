// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dup extends eul
{

    private dzp a;
    private dlb b;
    private dzp c;
    private dlb d;
    private dlb e;
    private dlb f;
    private dlb g;
    private dre h;
    private dmt i;
    private byte j[];
    private String k[];
    private String l[];

    public dup()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = eup.f;
        k = eup.d;
        l = eup.d;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        if (a != null)
        {
            j1 = euj.b(1, a) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (b != null)
        {
            i1 = j1 + euj.b(2, b);
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1 + euj.b(3, c);
        }
        i1 = j1;
        if (d != null)
        {
            i1 = j1 + euj.b(4, d);
        }
        j1 = i1;
        if (e != null)
        {
            j1 = i1 + euj.b(5, e);
        }
        i1 = j1;
        if (f != null)
        {
            i1 = j1 + euj.b(6, f);
        }
        j1 = i1;
        if (g != null)
        {
            j1 = i1 + euj.b(7, g);
        }
        i1 = j1;
        if (h != null)
        {
            i1 = j1 + euj.b(8, h);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1 + euj.b(9, i);
        }
        i1 = j1;
        if (!Arrays.equals(j, eup.f))
        {
            i1 = j1 + euj.b(11, j);
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1;
            if (k.length > 0)
            {
                String as[] = k;
                int i2 = as.length;
                j1 = 0;
                int k1 = 0;
                for (; j1 < i2; j1++)
                {
                    k1 += euj.a(as[j1]);
                }

                j1 = i1 + k1 + k.length * 1;
            }
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1;
            if (l.length > 0)
            {
                String as1[] = l;
                int j2 = as1.length;
                int l1 = 0;
                for (i1 = ((flag) ? 1 : 0); i1 < j2; i1++)
                {
                    l1 += euj.a(as1[i1]);
                }

                i1 = j1 + l1 + l.length * 1;
            }
        }
        i1 += eup.a(O);
        P = i1;
        return i1;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int i1 = eui1.a();
            switch (i1)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, i1))
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
                    c = new dzp();
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
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new dlb();
                }
                eui1.a(f);
                break;

            case 58: // ':'
                if (g == null)
                {
                    g = new dlb();
                }
                eui1.a(g);
                break;

            case 66: // 'B'
                if (h == null)
                {
                    h = new dre();
                }
                eui1.a(h);
                break;

            case 74: // 'J'
                if (i == null)
                {
                    i = new dmt();
                }
                eui1.a(i);
                break;

            case 90: // 'Z'
                j = eui1.g();
                break;

            case 98: // 'b'
                int l1 = eup.a(eui1, 98);
                int j1 = k.length;
                String as[] = new String[l1 + j1];
                System.arraycopy(k, 0, as, 0, j1);
                for (k = as; j1 < k.length - 1; j1++)
                {
                    k[j1] = eui1.f();
                    eui1.a();
                }

                k[j1] = eui1.f();
                break;

            case 106: // 'j'
                int i2 = eup.a(eui1, 106);
                int k1 = l.length;
                String as1[] = new String[i2 + k1];
                System.arraycopy(l, 0, as1, 0, k1);
                for (l = as1; k1 < l.length - 1; k1++)
                {
                    l[k1] = eui1.f();
                    eui1.a();
                }

                l[k1] = eui1.f();
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
            euj1.a(6, f);
        }
        if (g != null)
        {
            euj1.a(7, g);
        }
        if (h != null)
        {
            euj1.a(8, h);
        }
        if (i != null)
        {
            euj1.a(9, i);
        }
        if (!Arrays.equals(j, eup.f))
        {
            euj1.a(11, j);
        }
        if (k != null)
        {
            String as[] = k;
            int k1 = as.length;
            for (int i1 = 0; i1 < k1; i1++)
            {
                euj1.a(12, as[i1]);
            }

        }
        if (l != null)
        {
            String as1[] = l;
            int l1 = as1.length;
            for (int j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
            {
                euj1.a(13, as1[j1]);
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
            if (!(obj instanceof dup))
            {
                return false;
            }
            obj = (dup)obj;
            if ((a != null ? a.equals(((dup) (obj)).a) : ((dup) (obj)).a == null) && (b != null ? b.equals(((dup) (obj)).b) : ((dup) (obj)).b == null) && (c != null ? c.equals(((dup) (obj)).c) : ((dup) (obj)).c == null) && (d != null ? d.equals(((dup) (obj)).d) : ((dup) (obj)).d == null) && (e != null ? e.equals(((dup) (obj)).e) : ((dup) (obj)).e == null) && (f != null ? f.equals(((dup) (obj)).f) : ((dup) (obj)).f == null) && (g != null ? g.equals(((dup) (obj)).g) : ((dup) (obj)).g == null) && (h != null ? h.equals(((dup) (obj)).h) : ((dup) (obj)).h == null) && (i != null ? i.equals(((dup) (obj)).i) : ((dup) (obj)).i == null) && (Arrays.equals(j, ((dup) (obj)).j) && Arrays.equals(k, ((dup) (obj)).k) && Arrays.equals(l, ((dup) (obj)).l)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dup) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dup) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i1;
        int j1;
        int k1;
        boolean flag = false;
        int j3 = getClass().getName().hashCode();
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        if (a == null)
        {
            i1 = 0;
        } else
        {
            i1 = a.hashCode();
        }
        if (b == null)
        {
            j1 = 0;
        } else
        {
            j1 = b.hashCode();
        }
        if (c == null)
        {
            k1 = 0;
        } else
        {
            k1 = c.hashCode();
        }
        if (d == null)
        {
            l1 = 0;
        } else
        {
            l1 = d.hashCode();
        }
        if (e == null)
        {
            i2 = 0;
        } else
        {
            i2 = e.hashCode();
        }
        if (f == null)
        {
            j2 = 0;
        } else
        {
            j2 = f.hashCode();
        }
        if (g == null)
        {
            k2 = 0;
        } else
        {
            k2 = g.hashCode();
        }
        if (h == null)
        {
            l2 = 0;
        } else
        {
            l2 = h.hashCode();
        }
        if (i == null)
        {
            i3 = 0;
        } else
        {
            i3 = i.hashCode();
        }
        j1 = i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (j3 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31;
        if (j != null) goto _L2; else goto _L1
_L1:
        i1 = j1 * 31;
_L8:
        if (k != null) goto _L4; else goto _L3
_L3:
        j1 = i1 * 31;
_L11:
        if (l != null) goto _L6; else goto _L5
_L5:
        k1 = j1 * 31;
_L14:
        if (O == null)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = O.hashCode();
        }
        return k1 * 31 + i1;
_L2:
        k1 = 0;
_L9:
        i1 = j1;
        if (k1 >= j.length) goto _L8; else goto _L7
_L7:
        j1 = j1 * 31 + j[k1];
        k1++;
          goto _L9
          goto _L8
_L4:
        k1 = 0;
_L12:
        j1 = i1;
        if (k1 >= k.length) goto _L11; else goto _L10
_L10:
        if (k[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = k[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L12
          goto _L11
_L6:
        k1 = 0;
        i1 = j1;
        j1 = k1;
_L15:
        k1 = i1;
        if (j1 >= l.length) goto _L14; else goto _L13
_L13:
        if (l[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = l[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L15
    }
}
