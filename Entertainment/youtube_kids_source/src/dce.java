// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dce extends eul
{

    public static final dce a[] = new dce[0];
    public int b;
    public dmd c;
    public String d;
    private edh e;
    private int f;

    public dce()
    {
        b = 0;
        c = null;
        e = null;
        d = "";
        f = 0;
    }

    public final int a()
    {
        int j = 0;
        if (b != 0)
        {
            j = euj.c(1, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(3, e);
        }
        i = j;
        if (!d.equals(""))
        {
            i = j + euj.b(4, d);
        }
        j = i;
        if (f != 0)
        {
            j = i + euj.c(5, f);
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
                if (j == 0 || j == 1 || j == 2)
                {
                    b = j;
                } else
                {
                    b = 0;
                }
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dmd();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (e == null)
                {
                    e = new edh();
                }
                eui1.a(e);
                break;

            case 34: // '"'
                d = eui1.f();
                break;

            case 40: // '('
                f = eui1.d();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != 0)
        {
            euj1.a(1, b);
        }
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (e != null)
        {
            euj1.a(3, e);
        }
        if (!d.equals(""))
        {
            euj1.a(4, d);
        }
        if (f != 0)
        {
            euj1.a(5, f);
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
            if (!(obj instanceof dce))
            {
                return false;
            }
            obj = (dce)obj;
            if (b == ((dce) (obj)).b && (c != null ? c.equals(((dce) (obj)).c) : ((dce) (obj)).c == null) && (e != null ? e.equals(((dce) (obj)).e) : ((dce) (obj)).e == null) && (d != null ? d.equals(((dce) (obj)).d) : ((dce) (obj)).d == null) && f == ((dce) (obj)).f)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dce) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dce) (obj)).O))
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
        int j1 = b;
        int i;
        int j;
        int k;
        int k1;
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        if (e == null)
        {
            j = 0;
        } else
        {
            j = e.hashCode();
        }
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        k1 = f;
        if (O != null)
        {
            l = O.hashCode();
        }
        return ((k + (j + (i + ((i1 + 527) * 31 + j1) * 31) * 31) * 31) * 31 + k1) * 31 + l;
    }

}
