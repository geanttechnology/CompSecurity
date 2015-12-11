// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dzo extends eul
{

    public static final dzo a[] = new dzo[0];
    public dqw b;

    public dzo()
    {
        b = null;
    }

    public final int a()
    {
        int i = 0;
        if (b != null)
        {
            i = euj.b(0x396214a, b) + 0;
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

            case 481364562: 
                if (b == null)
                {
                    b = new dqw();
                }
                eui1.a(b);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(0x396214a, b);
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
            if (!(obj instanceof dzo))
            {
                return false;
            }
            obj = (dzo)obj;
            if (b != null ? b.equals(((dzo) (obj)).b) : ((dzo) (obj)).b == null)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dzo) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dzo) (obj)).O))
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
        return (i + (k + 527) * 31) * 31 + j;
    }

}
