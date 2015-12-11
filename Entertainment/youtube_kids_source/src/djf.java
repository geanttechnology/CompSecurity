// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class djf extends eul
{

    public static final djf a[] = new djf[0];
    private drj b;
    private dzt c;
    private dns d;

    public djf()
    {
        b = null;
        c = null;
        d = null;
    }

    public final int a()
    {
        int j = 0;
        if (b != null)
        {
            j = euj.b(0x31a2ee9, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(0x4314c98, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(0x4a49488, d);
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

            case 562717890: 
                if (c == null)
                {
                    c = new dzt();
                }
                eui1.a(c);
                break;

            case 623158338: 
                if (d == null)
                {
                    d = new dns();
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
            euj1.a(0x31a2ee9, b);
        }
        if (c != null)
        {
            euj1.a(0x4314c98, c);
        }
        if (d != null)
        {
            euj1.a(0x4a49488, d);
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
            if (!(obj instanceof djf))
            {
                return false;
            }
            obj = (djf)obj;
            if ((b != null ? b.equals(((djf) (obj)).b) : ((djf) (obj)).b == null) && (c != null ? c.equals(((djf) (obj)).c) : ((djf) (obj)).c == null) && (d != null ? d.equals(((djf) (obj)).d) : ((djf) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((djf) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((djf) (obj)).O))
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
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + l;
    }

}
