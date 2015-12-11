// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dne extends eul
{

    private String a;
    private String b;
    private String c;
    private String d;

    public dne()
    {
        a = "";
        b = "";
        c = "";
        d = "";
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
        if (!d.equals(""))
        {
            i = j + euj.b(4, d);
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
                a = eui1.f();
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 34: // '"'
                d = eui1.f();
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
        if (!d.equals(""))
        {
            euj1.a(4, d);
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
            if (!(obj instanceof dne))
            {
                return false;
            }
            obj = (dne)obj;
            if ((a != null ? a.equals(((dne) (obj)).a) : ((dne) (obj)).a == null) && (b != null ? b.equals(((dne) (obj)).b) : ((dne) (obj)).b == null) && (c != null ? c.equals(((dne) (obj)).c) : ((dne) (obj)).c == null) && (d != null ? d.equals(((dne) (obj)).d) : ((dne) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dne) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dne) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i1 = 0;
        int j1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
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
        if (d == null)
        {
            l = 0;
        } else
        {
            l = d.hashCode();
        }
        if (O != null)
        {
            i1 = O.hashCode();
        }
        return (l + (k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31) * 31 + i1;
    }
}
