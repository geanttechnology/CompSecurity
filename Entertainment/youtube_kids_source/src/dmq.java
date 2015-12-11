// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dmq extends eul
{

    private String a;
    private String b;
    private String c;
    private int d;
    private int e;

    public dmq()
    {
        a = "";
        b = "";
        c = "";
        d = 0;
        e = 0;
    }

    public final int a()
    {
        int j = 0;
        if (!a.equals(""))
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (!b.equals(""))
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (!c.equals(""))
        {
            j = i + euj.b(3, c);
        }
        i = j;
        if (d != 0)
        {
            i = j + euj.c(4, d);
        }
        j = i;
        if (e != 0)
        {
            j = i + euj.c(5, e);
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

            case 10: // '\n'
                a = eui1.f();
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 32: // ' '
                d = eui1.d();
                break;

            case 40: // '('
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2 || j == 3)
                {
                    e = j;
                } else
                {
                    e = 0;
                }
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!a.equals(""))
        {
            euj1.a(1, a);
        }
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (d != 0)
        {
            euj1.a(4, d);
        }
        if (e != 0)
        {
            euj1.a(5, e);
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
            if (!(obj instanceof dmq))
            {
                return false;
            }
            obj = (dmq)obj;
            if ((a != null ? a.equals(((dmq) (obj)).a) : ((dmq) (obj)).a == null) && (b != null ? b.equals(((dmq) (obj)).b) : ((dmq) (obj)).b == null) && (c != null ? c.equals(((dmq) (obj)).c) : ((dmq) (obj)).c == null) && (d == ((dmq) (obj)).d && e == ((dmq) (obj)).e))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmq) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmq) (obj)).O))
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
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        j1 = d;
        k1 = e;
        if (O != null)
        {
            l = O.hashCode();
        }
        return (((k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + j1) * 31 + k1) * 31 + l;
    }
}
