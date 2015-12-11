// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dcd extends eul
{

    public static final dcd a[] = new dcd[0];
    private dru b;
    private dsn c;
    private ddp d;

    public dcd()
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
            j = euj.b(0x499eec5, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(0x499ef11, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(0x49a1b8e, d);
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

            case 617575978: 
                if (b == null)
                {
                    b = new dru();
                }
                eui1.a(b);
                break;

            case 617576586: 
                if (c == null)
                {
                    c = new dsn();
                }
                eui1.a(c);
                break;

            case 617667698: 
                if (d == null)
                {
                    d = new ddp();
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
            euj1.a(0x499eec5, b);
        }
        if (c != null)
        {
            euj1.a(0x499ef11, c);
        }
        if (d != null)
        {
            euj1.a(0x49a1b8e, d);
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
            if (!(obj instanceof dcd))
            {
                return false;
            }
            obj = (dcd)obj;
            if ((b != null ? b.equals(((dcd) (obj)).b) : ((dcd) (obj)).b == null) && (c != null ? c.equals(((dcd) (obj)).c) : ((dcd) (obj)).c == null) && (d != null ? d.equals(((dcd) (obj)).d) : ((dcd) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dcd) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dcd) (obj)).O))
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
