// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dol extends eul
{

    public static final dol a[] = new dol[0];
    public dii b;
    public dic c;
    public dhy d;
    public dig e;
    public die f;

    public dol()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
    }

    public final int a()
    {
        int j = 0;
        if (b != null)
        {
            j = euj.b(0x3049143, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(0x3064567, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(0x3070f41, d);
        }
        i = j;
        if (e != null)
        {
            i = j + euj.b(0x32b52b9, e);
        }
        j = i;
        if (f != null)
        {
            j = i + euj.b(0x467ef78, f);
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
                if (b == null)
                {
                    b = new dii();
                }
                eui1.a(b);
                break;

            case 405941050: 
                if (c == null)
                {
                    c = new dic();
                }
                eui1.a(c);
                break;

            case 406354442: 
                if (d == null)
                {
                    d = new dhy();
                }
                eui1.a(d);
                break;

            case 425366986: 
                if (e == null)
                {
                    e = new dig();
                }
                eui1.a(e);
                break;

            case 591363010: 
                if (f == null)
                {
                    f = new die();
                }
                eui1.a(f);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(0x3049143, b);
        }
        if (c != null)
        {
            euj1.a(0x3064567, c);
        }
        if (d != null)
        {
            euj1.a(0x3070f41, d);
        }
        if (e != null)
        {
            euj1.a(0x32b52b9, e);
        }
        if (f != null)
        {
            euj1.a(0x467ef78, f);
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
            if (!(obj instanceof dol))
            {
                return false;
            }
            obj = (dol)obj;
            if ((b != null ? b.equals(((dol) (obj)).b) : ((dol) (obj)).b == null) && (c != null ? c.equals(((dol) (obj)).c) : ((dol) (obj)).c == null) && (d != null ? d.equals(((dol) (obj)).d) : ((dol) (obj)).d == null) && (e != null ? e.equals(((dol) (obj)).e) : ((dol) (obj)).e == null) && (f != null ? f.equals(((dol) (obj)).f) : ((dol) (obj)).f == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dol) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dol) (obj)).O))
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
        if (f == null)
        {
            i1 = 0;
        } else
        {
            i1 = f.hashCode();
        }
        if (O != null)
        {
            j1 = O.hashCode();
        }
        return (i1 + (l + (k + (j + (i + (k1 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + j1;
    }

}
