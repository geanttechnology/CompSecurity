// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class ebl extends eul
{

    private long a;
    private long b;
    private long c;
    private long d;
    private dlb e;

    public ebl()
    {
        a = 0L;
        b = 0L;
        c = 0L;
        d = 0L;
        e = null;
    }

    public final int a()
    {
        int j = 0;
        if (a != 0L)
        {
            j = euj.c(1, a) + 0;
        }
        int i = j;
        if (b != 0L)
        {
            i = j + euj.c(2, b);
        }
        j = i;
        if (c != 0L)
        {
            j = i + euj.c(3, c);
        }
        i = j;
        if (d != 0L)
        {
            i = j + euj.c(4, d);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(5, e);
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

            case 8: // '\b'
                a = eui1.b();
                break;

            case 16: // '\020'
                b = eui1.b();
                break;

            case 24: // '\030'
                c = eui1.b();
                break;

            case 32: // ' '
                d = eui1.b();
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != 0L)
        {
            euj1.a(1, a);
        }
        if (b != 0L)
        {
            euj1.a(2, b);
        }
        if (c != 0L)
        {
            euj1.a(3, c);
        }
        if (d != 0L)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
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
            if (!(obj instanceof ebl))
            {
                return false;
            }
            obj = (ebl)obj;
            if (a == ((ebl) (obj)).a && b == ((ebl) (obj)).b && c == ((ebl) (obj)).c && d == ((ebl) (obj)).d && (e != null ? e.equals(((ebl) (obj)).e) : ((ebl) (obj)).e == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ebl) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ebl) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j = 0;
        int k = getClass().getName().hashCode();
        int l = (int)(a ^ a >>> 32);
        int i1 = (int)(b ^ b >>> 32);
        int j1 = (int)(c ^ c >>> 32);
        int k1 = (int)(d ^ d >>> 32);
        int i;
        if (e == null)
        {
            i = 0;
        } else
        {
            i = e.hashCode();
        }
        if (O != null)
        {
            j = O.hashCode();
        }
        return (i + (((((k + 527) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31) * 31 + j;
    }
}
