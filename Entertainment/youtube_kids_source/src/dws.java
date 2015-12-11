// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dws extends eul
{

    public static final dws a[] = new dws[0];
    public drj b;
    public dvu c;
    private dvg d;

    public dws()
    {
        b = null;
        d = null;
        c = null;
    }

    public final int a()
    {
        int j = 0;
        if (b != null)
        {
            j = euj.b(0x31a2ee9, b) + 0;
        }
        int i = j;
        if (d != null)
        {
            i = j + euj.b(0x31a2eed, d);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(0x39af697, c);
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

            case 416380746: 
                if (b == null)
                {
                    b = new drj();
                }
                eui1.a(b);
                break;

            case 416380778: 
                if (d == null)
                {
                    d = new dvg();
                }
                eui1.a(d);
                break;

            case 483898554: 
                if (c == null)
                {
                    c = new dvu();
                }
                eui1.a(c);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(0x31a2ee9, b);
        }
        if (d != null)
        {
            euj1.a(0x31a2eed, d);
        }
        if (c != null)
        {
            euj1.a(0x39af697, c);
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
            if (!(obj instanceof dws))
            {
                return false;
            }
            obj = (dws)obj;
            if ((b != null ? b.equals(((dws) (obj)).b) : ((dws) (obj)).b == null) && (d != null ? d.equals(((dws) (obj)).d) : ((dws) (obj)).d == null) && (c != null ? c.equals(((dws) (obj)).c) : ((dws) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dws) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dws) (obj)).O))
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
        if (d == null)
        {
            j = 0;
        } else
        {
            j = d.hashCode();
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
