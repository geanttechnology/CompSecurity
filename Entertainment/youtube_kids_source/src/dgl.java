// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dgl extends eul
{

    private String a;

    public dgl()
    {
        a = "";
    }

    public final int a()
    {
        int i = 0;
        if (!a.equals(""))
        {
            i = euj.b(1, a) + 0;
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
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!a.equals(""))
        {
            euj1.a(1, a);
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
            if (!(obj instanceof dgl))
            {
                return false;
            }
            obj = (dgl)obj;
            if (a != null ? a.equals(((dgl) (obj)).a) : ((dgl) (obj)).a == null)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dgl) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dgl) (obj)).O))
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
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (O != null)
        {
            j = O.hashCode();
        }
        return (i + (k + 527) * 31) * 31 + j;
    }
}
