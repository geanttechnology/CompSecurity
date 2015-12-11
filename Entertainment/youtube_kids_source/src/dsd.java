// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dsd extends eul
{

    public String a;
    public String b;
    public int c;
    public String d;

    public dsd()
    {
        a = "";
        b = "";
        c = 0;
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
        if (c != 0)
        {
            j = i + euj.d(3, c);
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

            case 10: // '\n'
                a = eui1.f();
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 24: // '\030'
                c = eui1.h();
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
            euj1.a(1, a);
        }
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (c != 0)
        {
            euj1.b(3, c);
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
            if (!(obj instanceof dsd))
            {
                return false;
            }
            obj = (dsd)obj;
            if ((a != null ? a.equals(((dsd) (obj)).a) : ((dsd) (obj)).a == null) && (b != null ? b.equals(((dsd) (obj)).b) : ((dsd) (obj)).b == null) && c == ((dsd) (obj)).c && (d != null ? d.equals(((dsd) (obj)).d) : ((dsd) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dsd) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dsd) (obj)).O))
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
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        j1 = c;
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + ((j + (i + (i1 + 527) * 31) * 31) * 31 + j1) * 31) * 31 + l;
    }
}
