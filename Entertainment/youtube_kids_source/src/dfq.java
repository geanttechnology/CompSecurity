// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dfq extends eul
{

    public static final dfq a[] = new dfq[0];
    public dqw b;
    private edz c;
    private dpc d;
    private dzl e;

    public dfq()
    {
        c = null;
        d = null;
        e = null;
        b = null;
    }

    public final int a()
    {
        int j = 0;
        if (c != null)
        {
            j = euj.b(0x3084dbb, c) + 0;
        }
        int i = j;
        if (d != null)
        {
            i = j + euj.b(0x308ffc6, d);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(0x30905d8, e);
        }
        i = j;
        if (b != null)
        {
            i = j + euj.b(0x396214a, b);
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

            case 407006682: 
                if (c == null)
                {
                    c = new edz();
                }
                eui1.a(c);
                break;

            case 407371314: 
                if (d == null)
                {
                    d = new dpc();
                }
                eui1.a(d);
                break;

            case 407383746: 
                if (e == null)
                {
                    e = new dzl();
                }
                eui1.a(e);
                break;

            case 481364562: 
                if (b == null)
                {
                    b = new dqw();
                }
                eui1.a(b);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (c != null)
        {
            euj1.a(0x3084dbb, c);
        }
        if (d != null)
        {
            euj1.a(0x308ffc6, d);
        }
        if (e != null)
        {
            euj1.a(0x30905d8, e);
        }
        if (b != null)
        {
            euj1.a(0x396214a, b);
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
            if (!(obj instanceof dfq))
            {
                return false;
            }
            obj = (dfq)obj;
            if ((c != null ? c.equals(((dfq) (obj)).c) : ((dfq) (obj)).c == null) && (d != null ? d.equals(((dfq) (obj)).d) : ((dfq) (obj)).d == null) && (e != null ? e.equals(((dfq) (obj)).e) : ((dfq) (obj)).e == null) && (b != null ? b.equals(((dfq) (obj)).b) : ((dfq) (obj)).b == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dfq) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dfq) (obj)).O))
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
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        if (d == null)
        {
            j = 0;
        } else
        {
            j = d.hashCode();
        }
        if (e == null)
        {
            k = 0;
        } else
        {
            k = e.hashCode();
        }
        if (b == null)
        {
            l = 0;
        } else
        {
            l = b.hashCode();
        }
        if (O != null)
        {
            i1 = O.hashCode();
        }
        return (l + (k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31) * 31 + i1;
    }

}
