// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dee extends eul
{

    public static final dee a[] = new dee[0];
    private int b;
    private String c;

    public dee()
    {
        b = 0;
        c = "";
    }

    public final int a()
    {
        int i = 0;
        if (b != 0)
        {
            i = euj.c(1, b) + 0;
        }
        int j = i;
        if (!c.equals(""))
        {
            j = i + euj.b(2, c);
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
                b = eui1.d();
                break;

            case 18: // '\022'
                c = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != 0)
        {
            euj1.a(1, b);
        }
        if (!c.equals(""))
        {
            euj1.a(2, c);
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
            if (!(obj instanceof dee))
            {
                return false;
            }
            obj = (dee)obj;
            if (b == ((dee) (obj)).b && (c != null ? c.equals(((dee) (obj)).c) : ((dee) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dee) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dee) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j = 0;
        int k = getClass().getName().hashCode();
        int l = b;
        int i;
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        if (O != null)
        {
            j = O.hashCode();
        }
        return (i + ((k + 527) * 31 + l) * 31) * 31 + j;
    }

}
