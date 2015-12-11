// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dmx extends eul
{

    public static final dmx a[] = new dmx[0];
    public String b;
    public String c;
    private int d;
    private int e;

    public dmx()
    {
        b = "";
        c = "";
        d = 0;
        e = 0;
    }

    public final int a()
    {
        int j = 0;
        if (!b.equals(""))
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (!c.equals(""))
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (d != 0)
        {
            j = i + euj.c(3, d);
        }
        i = j;
        if (e != 0)
        {
            i = j + euj.c(4, e);
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

            case 10: // '\n'
                b = eui1.f();
                break;

            case 18: // '\022'
                c = eui1.f();
                break;

            case 24: // '\030'
                d = eui1.d();
                break;

            case 32: // ' '
                e = eui1.d();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!b.equals(""))
        {
            euj1.a(1, b);
        }
        if (!c.equals(""))
        {
            euj1.a(2, c);
        }
        if (d != 0)
        {
            euj1.a(3, d);
        }
        if (e != 0)
        {
            euj1.a(4, e);
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
            if (!(obj instanceof dmx))
            {
                return false;
            }
            obj = (dmx)obj;
            if ((b != null ? b.equals(((dmx) (obj)).b) : ((dmx) (obj)).b == null) && (c != null ? c.equals(((dmx) (obj)).c) : ((dmx) (obj)).c == null) && (d == ((dmx) (obj)).d && e == ((dmx) (obj)).e))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmx) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmx) (obj)).O))
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
        int i1;
        int j1;
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
        i1 = d;
        j1 = e;
        if (O != null)
        {
            k = O.hashCode();
        }
        return (((j + (i + (l + 527) * 31) * 31) * 31 + i1) * 31 + j1) * 31 + k;
    }

}
