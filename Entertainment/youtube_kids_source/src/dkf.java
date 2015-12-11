// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dkf extends eul
{

    private long a;
    private dxx b;

    public dkf()
    {
        a = 0L;
        b = null;
    }

    public final int a()
    {
        int i = 0;
        if (a != 0L)
        {
            i = euj.d(1, a) + 0;
        }
        int j = i;
        if (b != null)
        {
            j = i + euj.b(2, b);
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
                a = eui1.c();
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dxx();
                }
                eui1.a(b);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != 0L)
        {
            euj1.b(1, a);
        }
        if (b != null)
        {
            euj1.a(2, b);
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
            if (!(obj instanceof dkf))
            {
                return false;
            }
            obj = (dkf)obj;
            if (a == ((dkf) (obj)).a && (b != null ? b.equals(((dkf) (obj)).b) : ((dkf) (obj)).b == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dkf) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dkf) (obj)).O))
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
        int l = (int)(a ^ a >>> 32);
        int i;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (O != null)
        {
            j = O.hashCode();
        }
        return (i + ((k + 527) * 31 + l) * 31) * 31 + j;
    }
}
