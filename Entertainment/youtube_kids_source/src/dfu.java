// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dfu extends eul
{

    public String a;
    private String b;
    private String c;
    private String d;

    public dfu()
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
            j = euj.b(2, a) + 0;
        }
        int i = j;
        if (!b.equals(""))
        {
            i = j + euj.b(3, b);
        }
        j = i;
        if (!c.equals(""))
        {
            j = i + euj.b(4, c);
        }
        i = j;
        if (!d.equals(""))
        {
            i = j + euj.b(5, d);
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

            case 18: // '\022'
                a = eui1.f();
                break;

            case 26: // '\032'
                b = eui1.f();
                break;

            case 34: // '"'
                c = eui1.f();
                break;

            case 42: // '*'
                d = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!a.equals(""))
        {
            euj1.a(2, a);
        }
        if (!b.equals(""))
        {
            euj1.a(3, b);
        }
        if (!c.equals(""))
        {
            euj1.a(4, c);
        }
        if (!d.equals(""))
        {
            euj1.a(5, d);
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
            if (!(obj instanceof dfu))
            {
                return false;
            }
            obj = (dfu)obj;
            if ((a != null ? a.equals(((dfu) (obj)).a) : ((dfu) (obj)).a == null) && (b != null ? b.equals(((dfu) (obj)).b) : ((dfu) (obj)).b == null) && (c != null ? c.equals(((dfu) (obj)).c) : ((dfu) (obj)).c == null) && (d != null ? d.equals(((dfu) (obj)).d) : ((dfu) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dfu) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dfu) (obj)).O))
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
