// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class djt extends eul
{

    public static final djt a[] = new djt[0];
    private dqj b;
    private dhv c;
    private ebg d;
    private dcy e;

    public djt()
    {
        b = null;
        c = null;
        d = null;
        e = null;
    }

    public final int a()
    {
        int j = 0;
        if (b != null)
        {
            j = euj.b(0x37cc592, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(0x3b66809, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(0x3d6367c, d);
        }
        i = j;
        if (e != null)
        {
            i = j + euj.b(0x485029a, e);
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

            case 468069522: 
                if (b == null)
                {
                    b = new dqj();
                }
                eui1.a(b);
                break;

            case 498286666: 
                if (c == null)
                {
                    c = new dhv();
                }
                eui1.a(c);
                break;

            case 514962402: 
                if (d == null)
                {
                    d = new ebg();
                }
                eui1.a(d);
                break;

            case 606606546: 
                if (e == null)
                {
                    e = new dcy();
                }
                eui1.a(e);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(0x37cc592, b);
        }
        if (c != null)
        {
            euj1.a(0x3b66809, c);
        }
        if (d != null)
        {
            euj1.a(0x3d6367c, d);
        }
        if (e != null)
        {
            euj1.a(0x485029a, e);
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
            if (!(obj instanceof djt))
            {
                return false;
            }
            obj = (djt)obj;
            if ((b != null ? b.equals(((djt) (obj)).b) : ((djt) (obj)).b == null) && (c != null ? c.equals(((djt) (obj)).c) : ((djt) (obj)).c == null) && (d != null ? d.equals(((djt) (obj)).d) : ((djt) (obj)).d == null) && (e != null ? e.equals(((djt) (obj)).e) : ((djt) (obj)).e == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((djt) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((djt) (obj)).O))
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
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (c == null)
        {
            j = 0;
        } else
        {
            j = c.hashCode();
        }
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        if (e == null)
        {
            l = 0;
        } else
        {
            l = e.hashCode();
        }
        if (O != null)
        {
            i1 = O.hashCode();
        }
        return (l + (k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31) * 31 + i1;
    }

}
