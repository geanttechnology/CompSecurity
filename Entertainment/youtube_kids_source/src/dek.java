// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dek extends eul
{

    public static final dek a[] = new dek[0];
    private deh b;
    private dej c;
    private dei d;
    private def e;

    public dek()
    {
        b = null;
        c = null;
        d = null;
        e = null;
    }

    public final int a()
    {
        int j = 0;
        if (b != null)
        {
            j = euj.b(0x49de31d, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(0x4a1f695, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(0x4b1b53d, d);
        }
        i = j;
        if (e != null)
        {
            i = j + euj.b(0x4ddb5ee, e);
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

            case 619649258: 
                if (b == null)
                {
                    b = new deh();
                }
                eui1.a(b);
                break;

            case 621786282: 
                if (c == null)
                {
                    c = new dej();
                }
                eui1.a(c);
                break;

            case 630041066: 
                if (d == null)
                {
                    d = new dei();
                }
                eui1.a(d);
                break;

            case 653111154: 
                if (e == null)
                {
                    e = new def();
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
            euj1.a(0x49de31d, b);
        }
        if (c != null)
        {
            euj1.a(0x4a1f695, c);
        }
        if (d != null)
        {
            euj1.a(0x4b1b53d, d);
        }
        if (e != null)
        {
            euj1.a(0x4ddb5ee, e);
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
            if (!(obj instanceof dek))
            {
                return false;
            }
            obj = (dek)obj;
            if ((b != null ? b.equals(((dek) (obj)).b) : ((dek) (obj)).b == null) && (c != null ? c.equals(((dek) (obj)).c) : ((dek) (obj)).c == null) && (d != null ? d.equals(((dek) (obj)).d) : ((dek) (obj)).d == null) && (e != null ? e.equals(((dek) (obj)).e) : ((dek) (obj)).e == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dek) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dek) (obj)).O))
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
        if (O != null)
        {
            i1 = O.hashCode();
        }
        return (l + (k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31) * 31 + i1;
    }

}
