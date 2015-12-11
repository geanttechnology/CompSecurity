// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dsj extends eul
{

    public static final dsj a[] = new dsj[0];
    private dsl b;
    private dsk c;
    private dsm d;

    public dsj()
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
            j = euj.b(0x4a05067, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(0x4a18621, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(0x4a44aae, d);
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

            case 620921658: 
                if (b == null)
                {
                    b = new dsl();
                }
                eui1.a(b);
                break;

            case 621555978: 
                if (c == null)
                {
                    c = new dsk();
                }
                eui1.a(c);
                break;

            case 623007090: 
                if (d == null)
                {
                    d = new dsm();
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
            euj1.a(0x4a05067, b);
        }
        if (c != null)
        {
            euj1.a(0x4a18621, c);
        }
        if (d != null)
        {
            euj1.a(0x4a44aae, d);
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
            if (!(obj instanceof dsj))
            {
                return false;
            }
            obj = (dsj)obj;
            if ((b != null ? b.equals(((dsj) (obj)).b) : ((dsj) (obj)).b == null) && (c != null ? c.equals(((dsj) (obj)).c) : ((dsj) (obj)).c == null) && (d != null ? d.equals(((dsj) (obj)).d) : ((dsj) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dsj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dsj) (obj)).O))
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
