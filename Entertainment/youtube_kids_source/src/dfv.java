// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dfv extends eul
{

    public dge a;
    public dks b;
    public dun c;
    private djo d;
    private dwp e;

    public dfv()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
    }

    public final int a()
    {
        int j = 0;
        if (a != null)
        {
            j = euj.b(0x2c42002, a) + 0;
        }
        int i = j;
        if (b != null)
        {
            i = j + euj.b(0x2fe8b38, b);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(0x32ce059, c);
        }
        i = j;
        if (d != null)
        {
            i = j + euj.b(0x4dc13cf, d);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(0x50b7449, e);
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

            case 371261458: 
                if (a == null)
                {
                    a = new dge();
                }
                eui1.a(a);
                break;

            case 401889730: 
                if (b == null)
                {
                    b = new dks();
                }
                eui1.a(b);
                break;

            case 426181322: 
                if (c == null)
                {
                    c = new dun();
                }
                eui1.a(c);
                break;

            case 652254842: 
                if (d == null)
                {
                    d = new djo();
                }
                eui1.a(d);
                break;

            case 677093962: 
                if (e == null)
                {
                    e = new dwp();
                }
                eui1.a(e);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            euj1.a(0x2c42002, a);
        }
        if (b != null)
        {
            euj1.a(0x2fe8b38, b);
        }
        if (c != null)
        {
            euj1.a(0x32ce059, c);
        }
        if (d != null)
        {
            euj1.a(0x4dc13cf, d);
        }
        if (e != null)
        {
            euj1.a(0x50b7449, e);
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
            if (!(obj instanceof dfv))
            {
                return false;
            }
            obj = (dfv)obj;
            if ((a != null ? a.equals(((dfv) (obj)).a) : ((dfv) (obj)).a == null) && (b != null ? b.equals(((dfv) (obj)).b) : ((dfv) (obj)).b == null) && (c != null ? c.equals(((dfv) (obj)).c) : ((dfv) (obj)).c == null) && (d != null ? d.equals(((dfv) (obj)).d) : ((dfv) (obj)).d == null) && (e != null ? e.equals(((dfv) (obj)).e) : ((dfv) (obj)).e == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dfv) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dfv) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j1 = 0;
        int k1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
        int i1;
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
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        if (O != null)
        {
            j1 = O.hashCode();
        }
        return (i1 + (l + (k + (j + (i + (k1 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + j1;
    }
}
