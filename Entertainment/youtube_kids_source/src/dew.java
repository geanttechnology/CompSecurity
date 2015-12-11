// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dew extends eul
{

    public dto a;
    private dtn b;
    private dtm c;

    public dew()
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
            j = euj.b(0x392f096, a) + 0;
        }
        int i = j;
        if (b != null)
        {
            i = j + euj.b(0x3c6724e, b);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(0x44fc6e7, c);
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

            case 479691954: 
                if (a == null)
                {
                    a = new dto();
                }
                eui1.a(a);
                break;

            case 506696306: 
                if (b == null)
                {
                    b = new dtn();
                }
                eui1.a(b);
                break;

            case 578697018: 
                if (c == null)
                {
                    c = new dtm();
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
            euj1.a(0x392f096, a);
        }
        if (b != null)
        {
            euj1.a(0x3c6724e, b);
        }
        if (c != null)
        {
            euj1.a(0x44fc6e7, c);
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
            if (!(obj instanceof dew))
            {
                return false;
            }
            obj = (dew)obj;
            if ((a != null ? a.equals(((dew) (obj)).a) : ((dew) (obj)).a == null) && (b != null ? b.equals(((dew) (obj)).b) : ((dew) (obj)).b == null) && (c != null ? c.equals(((dew) (obj)).c) : ((dew) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dew) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dew) (obj)).O))
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
