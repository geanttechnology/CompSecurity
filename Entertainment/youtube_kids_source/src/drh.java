// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class drh extends eul
{

    public boolean a;
    public boolean b;

    public drh()
    {
        a = false;
        b = false;
    }

    public final int a()
    {
        int i = 0;
        if (a)
        {
            boolean flag = a;
            i = euj.b(1) + 1 + 0;
        }
        int j = i;
        if (b)
        {
            boolean flag1 = b;
            j = i + (euj.b(2) + 1);
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
                a = eui1.e();
                break;

            case 16: // '\020'
                b = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a)
        {
            euj1.a(1, a);
        }
        if (b)
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
        if (!(obj instanceof drh))
        {
            return false;
        }
        obj = (drh)obj;
        if (a != ((drh) (obj)).a || b != ((drh) (obj)).b)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((drh) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((drh) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j = 1;
        int l = getClass().getName().hashCode();
        int i;
        int k;
        if (a)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (!b)
        {
            j = 2;
        }
        if (O == null)
        {
            k = 0;
        } else
        {
            k = O.hashCode();
        }
        return k + ((i + (l + 527) * 31) * 31 + j) * 31;
    }
}
