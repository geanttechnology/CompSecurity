// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class edg extends eul
{

    public String a;
    public int b;
    public String c;
    private String d;

    public edg()
    {
        a = "";
        b = 0;
        d = "";
        c = "";
    }

    public final int a()
    {
        int j = 0;
        if (!a.equals(""))
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (b != 0)
        {
            i = j + euj.d(2, b);
        }
        j = i;
        if (!d.equals(""))
        {
            j = i + euj.b(3, d);
        }
        i = j;
        if (!c.equals(""))
        {
            i = j + euj.b(4, c);
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

            case 16: // '\020'
                b = eui1.h();
                break;

            case 26: // '\032'
                d = eui1.f();
                break;

            case 34: // '"'
                c = eui1.f();
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
        if (b != 0)
        {
            euj1.b(2, b);
        }
        if (!d.equals(""))
        {
            euj1.a(3, d);
        }
        if (!c.equals(""))
        {
            euj1.a(4, c);
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
            if (!(obj instanceof edg))
            {
                return false;
            }
            obj = (edg)obj;
            if ((a != null ? a.equals(((edg) (obj)).a) : ((edg) (obj)).a == null) && b == ((edg) (obj)).b && (d != null ? d.equals(((edg) (obj)).d) : ((edg) (obj)).d == null) && (c != null ? c.equals(((edg) (obj)).c) : ((edg) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((edg) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((edg) (obj)).O))
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
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        j1 = b;
        if (d == null)
        {
            j = 0;
        } else
        {
            j = d.hashCode();
        }
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + (j + ((i + (i1 + 527) * 31) * 31 + j1) * 31) * 31) * 31 + l;
    }
}
