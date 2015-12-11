// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class duz extends eul
{

    public static final duz a[] = new duz[0];
    private drj b;
    private dvg c;

    public duz()
    {
        b = null;
        c = null;
    }

    public final int a()
    {
        int i = 0;
        if (b != null)
        {
            i = euj.b(0x31a2ee9, b) + 0;
        }
        int j = i;
        if (c != null)
        {
            j = i + euj.b(0x31a2eed, c);
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

            case 416380778: 
                if (c == null)
                {
                    c = new dvg();
                }
                eui1.a(c);
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
            euj1.a(0x31a2eed, c);
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
            if (!(obj instanceof duz))
            {
                return false;
            }
            obj = (duz)obj;
            if ((b != null ? b.equals(((duz) (obj)).b) : ((duz) (obj)).b == null) && (c != null ? c.equals(((duz) (obj)).c) : ((duz) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((duz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((duz) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k = 0;
        int l = getClass().getName().hashCode();
        int i;
        int j;
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
        if (O != null)
        {
            k = O.hashCode();
        }
        return (j + (i + (l + 527) * 31) * 31) * 31 + k;
    }

}
