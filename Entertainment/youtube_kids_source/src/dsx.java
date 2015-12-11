// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dsx extends eul
{

    public int a;
    public boolean b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private int j;

    public dsx()
    {
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        a = 0;
        b = false;
        i = false;
        j = 0;
    }

    public final int a()
    {
        int l = 0;
        if (c != 0)
        {
            l = euj.c(1, c) + 0;
        }
        int k = l;
        if (d != 0)
        {
            k = l + euj.c(2, d);
        }
        l = k;
        if (e != 0)
        {
            l = k + euj.c(3, e);
        }
        k = l;
        if (f != 0)
        {
            k = l + euj.c(4, f);
        }
        l = k;
        if (g != 0)
        {
            l = k + euj.c(5, g);
        }
        k = l;
        if (h != 0)
        {
            k = l + euj.c(6, h);
        }
        l = k;
        if (a != 0)
        {
            l = k + euj.c(7, a);
        }
        k = l;
        if (b)
        {
            boolean flag = b;
            k = l + (euj.b(8) + 1);
        }
        l = k;
        if (i)
        {
            boolean flag1 = i;
            l = k + (euj.b(9) + 1);
        }
        k = l;
        if (j != 0)
        {
            k = l + euj.c(10, j);
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

            case 8: // '\b'
                c = eui1.d();
                break;

            case 16: // '\020'
                d = eui1.d();
                break;

            case 24: // '\030'
                e = eui1.d();
                break;

            case 32: // ' '
                f = eui1.d();
                break;

            case 40: // '('
                g = eui1.d();
                break;

            case 48: // '0'
                h = eui1.d();
                break;

            case 56: // '8'
                a = eui1.d();
                break;

            case 64: // '@'
                b = eui1.e();
                break;

            case 72: // 'H'
                i = eui1.e();
                break;

            case 80: // 'P'
                j = eui1.d();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (c != 0)
        {
            euj1.a(1, c);
        }
        if (d != 0)
        {
            euj1.a(2, d);
        }
        if (e != 0)
        {
            euj1.a(3, e);
        }
        if (f != 0)
        {
            euj1.a(4, f);
        }
        if (g != 0)
        {
            euj1.a(5, g);
        }
        if (h != 0)
        {
            euj1.a(6, h);
        }
        if (a != 0)
        {
            euj1.a(7, a);
        }
        if (b)
        {
            euj1.a(8, b);
        }
        if (i)
        {
            euj1.a(9, i);
        }
        if (j != 0)
        {
            euj1.a(10, j);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dsx))
        {
            return false;
        }
        obj = (dsx)obj;
        if (c != ((dsx) (obj)).c || d != ((dsx) (obj)).d || e != ((dsx) (obj)).e || f != ((dsx) (obj)).f || g != ((dsx) (obj)).g || h != ((dsx) (obj)).h || a != ((dsx) (obj)).a || b != ((dsx) (obj)).b || i != ((dsx) (obj)).i || j != ((dsx) (obj)).j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dsx) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dsx) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l = 1;
        int j1 = getClass().getName().hashCode();
        int k1 = c;
        int l1 = d;
        int i2 = e;
        int j2 = f;
        int k2 = g;
        int l2 = h;
        int i3 = a;
        int k;
        int i1;
        int j3;
        if (b)
        {
            k = 1;
        } else
        {
            k = 2;
        }
        if (!i)
        {
            l = 2;
        }
        j3 = j;
        if (O == null)
        {
            i1 = 0;
        } else
        {
            i1 = O.hashCode();
        }
        return i1 + (((k + ((((((((j1 + 527) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + i3) * 31) * 31 + l) * 31 + j3) * 31;
    }
}
