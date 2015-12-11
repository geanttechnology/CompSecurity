// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class don extends eul
{

    public static final don a[] = new don[0];
    public drj b;
    public dvu c;
    private dvg d;
    private dzt e;

    public don()
    {
        b = null;
        d = null;
        c = null;
        e = null;
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
        i = j;
        if (e != null)
        {
            i = j + euj.b(0x4314c98, e);
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

            case 562717890: 
                if (e == null)
                {
                    e = new dzt();
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
        if (e != null)
        {
            euj1.a(0x4314c98, e);
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
            if (!(obj instanceof don))
            {
                return false;
            }
            obj = (don)obj;
            if ((b != null ? b.equals(((don) (obj)).b) : ((don) (obj)).b == null) && (d != null ? d.equals(((don) (obj)).d) : ((don) (obj)).d == null) && (c != null ? c.equals(((don) (obj)).c) : ((don) (obj)).c == null) && (e != null ? e.equals(((don) (obj)).e) : ((don) (obj)).e == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((don) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((don) (obj)).O))
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
