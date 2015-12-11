// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dhe extends eul
{

    public static final dhe a[] = new dhe[0];
    private String b;
    private long c;
    private String d;

    public dhe()
    {
        b = "";
        c = 0L;
        d = "";
    }

    public final int a()
    {
        int j = 0;
        if (!b.equals(""))
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (c != 0L)
        {
            i = j + euj.c(2, c);
        }
        j = i;
        if (!d.equals(""))
        {
            j = i + euj.b(3, d);
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
                b = eui1.f();
                break;

            case 16: // '\020'
                c = eui1.b();
                break;

            case 26: // '\032'
                d = eui1.f();
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
        if (c != 0L)
        {
            euj1.a(2, c);
        }
        if (!d.equals(""))
        {
            euj1.a(3, d);
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
            if (!(obj instanceof dhe))
            {
                return false;
            }
            obj = (dhe)obj;
            if ((b != null ? b.equals(((dhe) (obj)).b) : ((dhe) (obj)).b == null) && c == ((dhe) (obj)).c && (d != null ? d.equals(((dhe) (obj)).d) : ((dhe) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dhe) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dhe) (obj)).O))
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
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        i1 = (int)(c ^ c >>> 32);
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
        return (j + ((i + (l + 527) * 31) * 31 + i1) * 31) * 31 + k;
    }

}
