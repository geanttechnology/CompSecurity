// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dzs extends eul
{

    public static final dzs a[] = new dzs[0];
    private dlb b;
    private boolean c;
    private dre d;

    public dzs()
    {
        b = null;
        c = false;
        d = null;
    }

    public final int a()
    {
        int j = 0;
        if (b != null)
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (c)
        {
            boolean flag = c;
            i = j + (euj.b(2) + 1);
        }
        j = i;
        if (d != null)
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
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 16: // '\020'
                c = eui1.e();
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dre();
                }
                eui1.a(d);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(1, b);
        }
        if (c)
        {
            euj1.a(2, c);
        }
        if (d != null)
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
            if (!(obj instanceof dzs))
            {
                return false;
            }
            obj = (dzs)obj;
            if ((b != null ? b.equals(((dzs) (obj)).b) : ((dzs) (obj)).b == null) && c == ((dzs) (obj)).c && (d != null ? d.equals(((dzs) (obj)).d) : ((dzs) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dzs) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dzs) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l = 0;
        int i1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (c)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + l;
    }

}
