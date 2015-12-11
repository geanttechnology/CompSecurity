// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class eaj extends eul
{

    public static final eaj a[] = new eaj[0];
    private dvi b;
    private eal c;
    private dzr d;
    private ebd e;
    private ead f;

    public eaj()
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
            j = euj.b(0x3d3b5e2, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(0x3e5ba2f, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(0x47a5862, d);
        }
        i = j;
        if (e != null)
        {
            i = j + euj.b(0x4b1afe0, e);
        }
        j = i;
        if (f != null)
        {
            j = i + euj.b(0x50eedc2, f);
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

            case 513650450: 
                if (b == null)
                {
                    b = new dvi();
                }
                eui1.a(b);
                break;

            case 523096442: 
                if (c == null)
                {
                    c = new eal();
                }
                eui1.a(c);
                break;

            case 601015058: 
                if (d == null)
                {
                    d = new dzr();
                }
                eui1.a(d);
                break;

            case 630030082: 
                if (e == null)
                {
                    e = new ebd();
                }
                eui1.a(e);
                break;

            case 678915602: 
                if (f == null)
                {
                    f = new ead();
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
            euj1.a(0x3d3b5e2, b);
        }
        if (c != null)
        {
            euj1.a(0x3e5ba2f, c);
        }
        if (d != null)
        {
            euj1.a(0x47a5862, d);
        }
        if (e != null)
        {
            euj1.a(0x4b1afe0, e);
        }
        if (f != null)
        {
            euj1.a(0x50eedc2, f);
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
            if (!(obj instanceof eaj))
            {
                return false;
            }
            obj = (eaj)obj;
            if ((b != null ? b.equals(((eaj) (obj)).b) : ((eaj) (obj)).b == null) && (c != null ? c.equals(((eaj) (obj)).c) : ((eaj) (obj)).c == null) && (d != null ? d.equals(((eaj) (obj)).d) : ((eaj) (obj)).d == null) && (e != null ? e.equals(((eaj) (obj)).e) : ((eaj) (obj)).e == null) && (f != null ? f.equals(((eaj) (obj)).f) : ((eaj) (obj)).f == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((eaj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((eaj) (obj)).O))
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
