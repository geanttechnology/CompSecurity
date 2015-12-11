// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class diw extends eul
{

    private dii a;
    private dfj b;
    private eci c;
    private dnj d;

    public diw()
    {
        a = null;
        b = null;
        c = null;
        d = null;
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
            j = i + euj.b(0x4913a5c, c);
        }
        i = j;
        if (d != null)
        {
            i = j + euj.b(0x4faac81, d);
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

            case 613012194: 
                if (c == null)
                {
                    c = new eci();
                }
                eui1.a(c);
                break;

            case 668296202: 
                if (d == null)
                {
                    d = new dnj();
                }
                eui1.a(d);
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
            euj1.a(0x4913a5c, c);
        }
        if (d != null)
        {
            euj1.a(0x4faac81, d);
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
            if (!(obj instanceof diw))
            {
                return false;
            }
            obj = (diw)obj;
            if ((a != null ? a.equals(((diw) (obj)).a) : ((diw) (obj)).a == null) && (b != null ? b.equals(((diw) (obj)).b) : ((diw) (obj)).b == null) && (c != null ? c.equals(((diw) (obj)).c) : ((diw) (obj)).c == null) && (d != null ? d.equals(((diw) (obj)).d) : ((diw) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((diw) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((diw) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i1 = 0;
        int j1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
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
        if (d == null)
        {
            l = 0;
        } else
        {
            l = d.hashCode();
        }
        if (O != null)
        {
            i1 = O.hashCode();
        }
        return (l + (k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31) * 31 + i1;
    }
}
