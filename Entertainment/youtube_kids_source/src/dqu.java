// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dqu extends eul
{

    public dre a;
    public byte b[];
    private dlb c;

    public dqu()
    {
        c = null;
        a = null;
        b = eup.f;
    }

    public final int a()
    {
        int j = 0;
        if (c != null)
        {
            j = euj.b(1, c) + 0;
        }
        int i = j;
        if (a != null)
        {
            i = j + euj.b(2, a);
        }
        j = i;
        if (!Arrays.equals(b, eup.f))
        {
            j = i + euj.b(4, b);
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
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 18: // '\022'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 34: // '"'
                b = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (c != null)
        {
            euj1.a(1, c);
        }
        if (a != null)
        {
            euj1.a(2, a);
        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(4, b);
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
            if (!(obj instanceof dqu))
            {
                return false;
            }
            obj = (dqu)obj;
            if ((c != null ? c.equals(((dqu) (obj)).c) : ((dqu) (obj)).c == null) && (a != null ? a.equals(((dqu) (obj)).a) : ((dqu) (obj)).a == null) && Arrays.equals(b, ((dqu) (obj)).b))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dqu) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dqu) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        int j;
        boolean flag = false;
        int k = getClass().getName().hashCode();
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        if (a == null)
        {
            j = 0;
        } else
        {
            j = a.hashCode();
        }
        i = j + (i + (k + 527) * 31) * 31;
        if (b != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        int l;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return j * 31 + i;
_L2:
        l = 0;
_L5:
        j = i;
        if (l >= b.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + b[l];
        l++;
          goto _L5
    }
}
