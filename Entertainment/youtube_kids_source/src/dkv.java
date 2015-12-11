// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dkv extends eul
{

    private int a;
    private int b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private String j[];
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;

    public dkv()
    {
        a = 0;
        b = 0;
        c = 0;
        d = false;
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        j = eup.d;
        k = 1;
        l = false;
        m = false;
        n = false;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int k1;
        if (a != 0)
        {
            j1 = euj.c(1, a) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (b != 0)
        {
            i1 = j1 + euj.c(2, b);
        }
        j1 = i1;
        if (c != 0)
        {
            j1 = i1 + euj.c(3, c);
        }
        i1 = j1;
        if (d)
        {
            boolean flag1 = d;
            i1 = j1 + (euj.b(4) + 1);
        }
        j1 = i1;
        if (e)
        {
            boolean flag2 = e;
            j1 = i1 + (euj.b(5) + 1);
        }
        i1 = j1;
        if (f)
        {
            boolean flag3 = f;
            i1 = j1 + (euj.b(6) + 1);
        }
        j1 = i1;
        if (g)
        {
            boolean flag4 = g;
            j1 = i1 + (euj.b(7) + 1);
        }
        k1 = j1;
        if (h)
        {
            boolean flag5 = h;
            k1 = j1 + (euj.b(8) + 1);
        }
        i1 = k1;
        if (i)
        {
            boolean flag6 = i;
            i1 = k1 + (euj.b(9) + 1);
        }
        j1 = i1;
        if (j != null)
        {
            j1 = i1;
            if (j.length > 0)
            {
                String as[] = j;
                int i2 = as.length;
                int l1 = 0;
                for (j1 = ((flag) ? 1 : 0); j1 < i2; j1++)
                {
                    l1 += euj.a(as[j1]);
                }

                j1 = i1 + l1 + j.length * 1;
            }
        }
        i1 = j1;
        if (k != 1)
        {
            i1 = j1 + euj.c(11, k);
        }
        j1 = i1;
        if (l)
        {
            boolean flag7 = l;
            j1 = i1 + (euj.b(12) + 1);
        }
        i1 = j1;
        if (m)
        {
            boolean flag8 = m;
            i1 = j1 + (euj.b(13) + 1);
        }
        j1 = i1;
        if (n)
        {
            boolean flag9 = n;
            j1 = i1 + (euj.b(14) + 1);
        }
        i1 = j1 + eup.a(O);
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

            case 8: // '\b'
                int j1 = eui1.d();
                if (j1 == 0 || j1 == 1 || j1 == 2 || j1 == 3 || j1 == 4 || j1 == 5)
                {
                    a = j1;
                } else
                {
                    a = 0;
                }
                break;

            case 16: // '\020'
                int k1 = eui1.d();
                if (k1 == 0 || k1 == 1 || k1 == 2 || k1 == 3 || k1 == 4 || k1 == 5 || k1 == 6)
                {
                    b = k1;
                } else
                {
                    b = 0;
                }
                break;

            case 24: // '\030'
                int l1 = eui1.d();
                if (l1 == 0 || l1 == 1 || l1 == 2 || l1 == 3)
                {
                    c = l1;
                } else
                {
                    c = 0;
                }
                break;

            case 32: // ' '
                d = eui1.e();
                break;

            case 40: // '('
                e = eui1.e();
                break;

            case 48: // '0'
                f = eui1.e();
                break;

            case 56: // '8'
                g = eui1.e();
                break;

            case 64: // '@'
                h = eui1.e();
                break;

            case 72: // 'H'
                i = eui1.e();
                break;

            case 82: // 'R'
                int k2 = eup.a(eui1, 82);
                int i2 = j.length;
                String as[] = new String[k2 + i2];
                System.arraycopy(j, 0, as, 0, i2);
                for (j = as; i2 < j.length - 1; i2++)
                {
                    j[i2] = eui1.f();
                    eui1.a();
                }

                j[i2] = eui1.f();
                break;

            case 88: // 'X'
                int j2 = eui1.d();
                if (j2 == 1 || j2 == 2 || j2 == 3)
                {
                    k = j2;
                } else
                {
                    k = 1;
                }
                break;

            case 96: // '`'
                l = eui1.e();
                break;

            case 104: // 'h'
                m = eui1.e();
                break;

            case 112: // 'p'
                n = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != 0)
        {
            euj1.a(1, a);
        }
        if (b != 0)
        {
            euj1.a(2, b);
        }
        if (c != 0)
        {
            euj1.a(3, c);
        }
        if (d)
        {
            euj1.a(4, d);
        }
        if (e)
        {
            euj1.a(5, e);
        }
        if (f)
        {
            euj1.a(6, f);
        }
        if (g)
        {
            euj1.a(7, g);
        }
        if (h)
        {
            euj1.a(8, h);
        }
        if (i)
        {
            euj1.a(9, i);
        }
        if (j != null)
        {
            String as[] = j;
            int j1 = as.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                euj1.a(10, as[i1]);
            }

        }
        if (k != 1)
        {
            euj1.a(11, k);
        }
        if (l)
        {
            euj1.a(12, l);
        }
        if (m)
        {
            euj1.a(13, m);
        }
        if (n)
        {
            euj1.a(14, n);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dkv))
        {
            return false;
        }
        obj = (dkv)obj;
        if (a != ((dkv) (obj)).a || b != ((dkv) (obj)).b || c != ((dkv) (obj)).c || d != ((dkv) (obj)).d || e != ((dkv) (obj)).e || f != ((dkv) (obj)).f || g != ((dkv) (obj)).g || h != ((dkv) (obj)).h || i != ((dkv) (obj)).i || !Arrays.equals(j, ((dkv) (obj)).j) || k != ((dkv) (obj)).k || l != ((dkv) (obj)).l || m != ((dkv) (obj)).m || n != ((dkv) (obj)).n)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dkv) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dkv) (obj)).O))
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
        int l1;
        int i2;
        boolean flag = false;
        boolean flag1 = true;
        int k2 = getClass().getName().hashCode();
        int l2 = a;
        int i3 = b;
        int j3 = c;
        int j2;
        if (d)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        if (e)
        {
            j1 = 1;
        } else
        {
            j1 = 2;
        }
        if (f)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (g)
        {
            l1 = 1;
        } else
        {
            l1 = 2;
        }
        if (h)
        {
            i2 = 1;
        } else
        {
            i2 = 2;
        }
        if (i)
        {
            j2 = 1;
        } else
        {
            j2 = 2;
        }
        i1 = j2 + (i2 + (l1 + (k1 + (j1 + (i1 + ((((k2 + 527) * 31 + l2) * 31 + i3) * 31 + j3) * 31) * 31) * 31) * 31) * 31) * 31;
        if (j != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L4:
        j2 = k;
        if (l)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        if (m)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (n)
        {
            l1 = ((flag1) ? 1 : 0);
        } else
        {
            l1 = 2;
        }
        if (O == null)
        {
            i2 = ((flag) ? 1 : 0);
        } else
        {
            i2 = O.hashCode();
        }
        return ((k1 + (i1 + (j1 * 31 + j2) * 31) * 31) * 31 + l1) * 31 + i2;
_L2:
        k1 = 0;
_L5:
        j1 = i1;
        if (k1 >= j.length) goto _L4; else goto _L3
_L3:
        if (j[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = j[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L5
    }
}
