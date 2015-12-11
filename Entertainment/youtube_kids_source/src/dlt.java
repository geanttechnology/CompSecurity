// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dlt extends eul
{

    public String a;
    public long b;
    public long c;
    private String d;

    public dlt()
    {
        a = "";
        b = 0L;
        c = 0L;
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
        if (b != 0L)
        {
            i = j + euj.d(2, b);
        }
        j = i;
        if (c != 0L)
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

            case 16: // '\020'
                b = eui1.c();
                break;

            case 24: // '\030'
                c = eui1.c();
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
        if (b != 0L)
        {
            euj1.b(2, b);
        }
        if (c != 0L)
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
            if (!(obj instanceof dlt))
            {
                return false;
            }
            obj = (dlt)obj;
            if ((a != null ? a.equals(((dlt) (obj)).a) : ((dlt) (obj)).a == null) && (b == ((dlt) (obj)).b && c == ((dlt) (obj)).c) && (d != null ? d.equals(((dlt) (obj)).d) : ((dlt) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dlt) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dlt) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k = 0;
        int l = getClass().getName().hashCode();
        int i;
        int j;
        int i1;
        int j1;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        i1 = (int)(b ^ b >>> 32);
        j1 = (int)(c ^ c >>> 32);
        if (d == null)
        {
            j = 0;
        } else
        {
            j = d.hashCode();
        }
        if (O != null)
        {
            k = O.hashCode();
        }
        return (j + (((i + (l + 527) * 31) * 31 + i1) * 31 + j1) * 31) * 31 + k;
    }
}
