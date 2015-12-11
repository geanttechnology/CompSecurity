// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class ddu extends eul
{

    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    private boolean g;

    public ddu()
    {
        a = false;
        b = false;
        c = false;
        d = false;
        e = false;
        f = false;
        g = false;
    }

    public final int a()
    {
        int j = 0;
        if (a)
        {
            boolean flag = a;
            j = euj.b(1) + 1 + 0;
        }
        int i = j;
        if (b)
        {
            boolean flag1 = b;
            i = j + (euj.b(2) + 1);
        }
        j = i;
        if (c)
        {
            boolean flag2 = c;
            j = i + (euj.b(3) + 1);
        }
        i = j;
        if (d)
        {
            boolean flag3 = d;
            i = j + (euj.b(4) + 1);
        }
        j = i;
        if (e)
        {
            boolean flag4 = e;
            j = i + (euj.b(5) + 1);
        }
        i = j;
        if (f)
        {
            boolean flag5 = f;
            i = j + (euj.b(6) + 1);
        }
        j = i;
        if (g)
        {
            boolean flag6 = g;
            j = i + (euj.b(7) + 1);
        }
        i = j + eup.a(O);
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
                a = eui1.e();
                break;

            case 16: // '\020'
                b = eui1.e();
                break;

            case 24: // '\030'
                c = eui1.e();
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
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a)
        {
            euj1.a(1, a);
        }
        if (b)
        {
            euj1.a(2, b);
        }
        if (c)
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
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof ddu))
        {
            return false;
        }
        obj = (ddu)obj;
        if (a != ((ddu) (obj)).a || b != ((ddu) (obj)).b || c != ((ddu) (obj)).c || d != ((ddu) (obj)).d || e != ((ddu) (obj)).e || f != ((ddu) (obj)).f || g != ((ddu) (obj)).g)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ddu) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ddu) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k1 = 1;
        int i2 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int l1;
        if (a)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (b)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        if (c)
        {
            k = 1;
        } else
        {
            k = 2;
        }
        if (d)
        {
            l = 1;
        } else
        {
            l = 2;
        }
        if (e)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        if (f)
        {
            j1 = 1;
        } else
        {
            j1 = 2;
        }
        if (!g)
        {
            k1 = 2;
        }
        if (O == null)
        {
            l1 = 0;
        } else
        {
            l1 = O.hashCode();
        }
        return l1 + ((j1 + (i1 + (l + (k + (j + (i + (i2 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k1) * 31;
    }
}
