// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dnz extends eul
{

    private boolean a;
    private String b;
    private int c;
    private String d;
    private boolean e;
    private drw f;

    public dnz()
    {
        a = false;
        b = "";
        c = 0;
        d = "";
        e = false;
        f = null;
    }

    public final int a()
    {
        int j = 0;
        if (a)
        {
            boolean flag = a;
            j = euj.b(1) + 1 + 0;
        }
        int i = j;
        if (!b.equals(""))
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (c != 0)
        {
            j = i + euj.d(3, c);
        }
        i = j;
        if (!d.equals(""))
        {
            i = j + euj.b(4, d);
        }
        j = i;
        if (e)
        {
            boolean flag1 = e;
            j = i + (euj.b(5) + 1);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(6, f);
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

            case 8: // '\b'
                a = eui1.e();
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 24: // '\030'
                c = eui1.h();
                break;

            case 34: // '"'
                d = eui1.f();
                break;

            case 40: // '('
                e = eui1.e();
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new drw();
                }
                eui1.a(f);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a)
        {
            euj1.a(1, a);
        }
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (c != 0)
        {
            euj1.b(3, c);
        }
        if (!d.equals(""))
        {
            euj1.a(4, d);
        }
        if (e)
        {
            euj1.a(5, e);
        }
        if (f != null)
        {
            euj1.a(6, f);
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
            if (!(obj instanceof dnz))
            {
                return false;
            }
            obj = (dnz)obj;
            if (a == ((dnz) (obj)).a && (b != null ? b.equals(((dnz) (obj)).b) : ((dnz) (obj)).b == null) && c == ((dnz) (obj)).c && (d != null ? d.equals(((dnz) (obj)).d) : ((dnz) (obj)).d == null) && e == ((dnz) (obj)).e && (f != null ? f.equals(((dnz) (obj)).f) : ((dnz) (obj)).f == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dnz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dnz) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l = 1;
        int j1 = 0;
        int k1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int i1;
        int l1;
        if (a)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        l1 = c;
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        if (!e)
        {
            l = 2;
        }
        if (f == null)
        {
            i1 = 0;
        } else
        {
            i1 = f.hashCode();
        }
        if (O != null)
        {
            j1 = O.hashCode();
        }
        return (i1 + ((k + ((j + (i + (k1 + 527) * 31) * 31) * 31 + l1) * 31) * 31 + l) * 31) * 31 + j1;
    }
}
