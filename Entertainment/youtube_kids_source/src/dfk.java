// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dfk extends eul
{

    private drc a;
    private dkc b;

    public dfk()
    {
        a = null;
        b = null;
    }

    public final int a()
    {
        int i = 0;
        if (a != null)
        {
            i = euj.b(0x31dea0e, a) + 0;
        }
        int j = i;
        if (b != null)
        {
            j = i + euj.b(0x32dfc43, b);
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

            case 418336882: 
                if (a == null)
                {
                    a = new drc();
                }
                eui1.a(a);
                break;

            case 426762778: 
                if (b == null)
                {
                    b = new dkc();
                }
                eui1.a(b);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            euj1.a(0x31dea0e, a);
        }
        if (b != null)
        {
            euj1.a(0x32dfc43, b);
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
            if (!(obj instanceof dfk))
            {
                return false;
            }
            obj = (dfk)obj;
            if ((a != null ? a.equals(((dfk) (obj)).a) : ((dfk) (obj)).a == null) && (b != null ? b.equals(((dfk) (obj)).b) : ((dfk) (obj)).b == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dfk) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dfk) (obj)).O))
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
        if (O != null)
        {
            k = O.hashCode();
        }
        return (j + (i + (l + 527) * 31) * 31) * 31 + k;
    }
}
