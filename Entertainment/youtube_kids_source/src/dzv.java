// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dzv extends eul
{

    public static final dzv a[] = new dzv[0];
    public int b;
    public String c;
    public dsi d;

    public dzv()
    {
        b = 1;
        c = "";
        d = null;
    }

    public final int a()
    {
        int j = 0;
        if (b != 1)
        {
            j = euj.c(1, b) + 0;
        }
        int i = j;
        if (!c.equals(""))
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(3, d);
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
                int j = eui1.d();
                if (j == 1 || j == 2 || j == 3 || j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10 || j == 11 || j == 12 || j == 13 || j == 14 || j == 15 || j == 16 || j == 17 || j == 18 || j == 19)
                {
                    b = j;
                } else
                {
                    b = 1;
                }
                break;

            case 18: // '\022'
                c = eui1.f();
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dsi();
                }
                eui1.a(d);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != 1)
        {
            euj1.a(1, b);
        }
        if (!c.equals(""))
        {
            euj1.a(2, c);
        }
        if (d != null)
        {
            euj1.a(3, d);
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
            if (!(obj instanceof dzv))
            {
                return false;
            }
            obj = (dzv)obj;
            if (b == ((dzv) (obj)).b && (c != null ? c.equals(((dzv) (obj)).c) : ((dzv) (obj)).c == null) && (d != null ? d.equals(((dzv) (obj)).d) : ((dzv) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dzv) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dzv) (obj)).O))
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
        int i1 = b;
        int i;
        int j;
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
        if (O != null)
        {
            k = O.hashCode();
        }
        return (j + (i + ((l + 527) * 31 + i1) * 31) * 31) * 31 + k;
    }

}
