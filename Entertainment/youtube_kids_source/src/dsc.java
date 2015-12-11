// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dsc extends eul
{

    public int a;
    private String b;
    private int c;
    private int d;
    private String e;
    private drz f;

    public dsc()
    {
        b = "";
        c = 0;
        d = 0;
        a = 0;
        e = "";
        f = null;
    }

    public final int a()
    {
        int j = 0;
        if (!b.equals(""))
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (c != 0)
        {
            i = j + euj.d(2, c);
        }
        j = i;
        if (d != 0)
        {
            j = i + euj.d(3, d);
        }
        i = j;
        if (a != 0)
        {
            i = j + euj.c(5, a);
        }
        j = i;
        if (!e.equals(""))
        {
            j = i + euj.b(6, e);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(7, f);
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
                b = eui1.f();
                break;

            case 16: // '\020'
                c = eui1.h();
                break;

            case 24: // '\030'
                d = eui1.h();
                break;

            case 40: // '('
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2 || j == 3 || j == 4 || j == 5 || j == 6)
                {
                    a = j;
                } else
                {
                    a = 0;
                }
                break;

            case 50: // '2'
                e = eui1.f();
                break;

            case 58: // ':'
                if (f == null)
                {
                    f = new drz();
                }
                eui1.a(f);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!b.equals(""))
        {
            euj1.a(1, b);
        }
        if (c != 0)
        {
            euj1.b(2, c);
        }
        if (d != 0)
        {
            euj1.b(3, d);
        }
        if (a != 0)
        {
            euj1.a(5, a);
        }
        if (!e.equals(""))
        {
            euj1.a(6, e);
        }
        if (f != null)
        {
            euj1.a(7, f);
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
            if (!(obj instanceof dsc))
            {
                return false;
            }
            obj = (dsc)obj;
            if ((b != null ? b.equals(((dsc) (obj)).b) : ((dsc) (obj)).b == null) && (c == ((dsc) (obj)).c && d == ((dsc) (obj)).d && a == ((dsc) (obj)).a) && (e != null ? e.equals(((dsc) (obj)).e) : ((dsc) (obj)).e == null) && (f != null ? f.equals(((dsc) (obj)).f) : ((dsc) (obj)).f == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dsc) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dsc) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l = 0;
        int i1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int j1;
        int k1;
        int l1;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        j1 = c;
        k1 = d;
        l1 = a;
        if (e == null)
        {
            j = 0;
        } else
        {
            j = e.hashCode();
        }
        if (f == null)
        {
            k = 0;
        } else
        {
            k = f.hashCode();
        }
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + (j + ((((i + (i1 + 527) * 31) * 31 + j1) * 31 + k1) * 31 + l1) * 31) * 31) * 31 + l;
    }
}
