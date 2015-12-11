// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class edb extends eul
{

    public dtb a;
    private dtd b;

    public edb()
    {
        b = null;
        a = null;
    }

    public final int a()
    {
        int i = 0;
        if (b != null)
        {
            i = euj.b(0x4c0fbdf, b) + 0;
        }
        int j = i;
        if (a != null)
        {
            j = i + euj.b(0x4c28627, a);
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

            case 638050042: 
                if (b == null)
                {
                    b = new dtd();
                }
                eui1.a(b);
                break;

            case 638857530: 
                if (a == null)
                {
                    a = new dtb();
                }
                eui1.a(a);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(0x4c0fbdf, b);
        }
        if (a != null)
        {
            euj1.a(0x4c28627, a);
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
            if (!(obj instanceof edb))
            {
                return false;
            }
            obj = (edb)obj;
            if ((b != null ? b.equals(((edb) (obj)).b) : ((edb) (obj)).b == null) && (a != null ? a.equals(((edb) (obj)).a) : ((edb) (obj)).a == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((edb) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((edb) (obj)).O))
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
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (a == null)
        {
            j = 0;
        } else
        {
            j = a.hashCode();
        }
        if (O != null)
        {
            k = O.hashCode();
        }
        return (j + (i + (l + 527) * 31) * 31) * 31 + k;
    }
}
