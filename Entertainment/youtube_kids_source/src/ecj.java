// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class ecj extends eul
{

    private dii a;
    private dfj b;
    private dnj c;

    public ecj()
    {
        a = null;
        b = null;
        c = null;
    }

    public final int a()
    {
        int j = 0;
        if (a != null)
        {
            j = euj.b(0x3049143, a) + 0;
        }
        int i = j;
        if (b != null)
        {
            i = j + euj.b(0x3e1ae1d, b);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(0x4faac81, c);
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

            case 405047834: 
                if (a == null)
                {
                    a = new dii();
                }
                eui1.a(a);
                break;

            case 520974570: 
                if (b == null)
                {
                    b = new dfj();
                }
                eui1.a(b);
                break;

            case 668296202: 
                if (c == null)
                {
                    c = new dnj();
                }
                eui1.a(c);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            euj1.a(0x3049143, a);
        }
        if (b != null)
        {
            euj1.a(0x3e1ae1d, b);
        }
        if (c != null)
        {
            euj1.a(0x4faac81, c);
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
            if (!(obj instanceof ecj))
            {
                return false;
            }
            obj = (ecj)obj;
            if ((a != null ? a.equals(((ecj) (obj)).a) : ((ecj) (obj)).a == null) && (b != null ? b.equals(((ecj) (obj)).b) : ((ecj) (obj)).b == null) && (c != null ? c.equals(((ecj) (obj)).c) : ((ecj) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ecj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ecj) (obj)).O))
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
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + l;
    }
}
