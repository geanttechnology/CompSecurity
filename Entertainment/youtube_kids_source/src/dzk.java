// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dzk extends eul
{

    public dre a;
    public dzi b;
    private String c;
    private boolean d;
    private dmb e;
    private dzj f;

    public dzk()
    {
        a = null;
        c = "";
        d = false;
        b = null;
        e = null;
        f = null;
    }

    public final int a()
    {
        int j = 0;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (!c.equals(""))
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (d)
        {
            boolean flag = d;
            j = i + (euj.b(3) + 1);
        }
        i = j;
        if (b != null)
        {
            i = j + euj.b(4, b);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(6, e);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(7, f);
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
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                c = eui1.f();
                break;

            case 24: // '\030'
                d = eui1.e();
                break;

            case 34: // '"'
                if (b == null)
                {
                    b = new dzi();
                }
                eui1.a(b);
                break;

            case 50: // '2'
                if (e == null)
                {
                    e = new dmb();
                }
                eui1.a(e);
                break;

            case 58: // ':'
                if (f == null)
                {
                    f = new dzj();
                }
                eui1.a(f);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            euj1.a(1, a);
        }
        if (!c.equals(""))
        {
            euj1.a(2, c);
        }
        if (d)
        {
            euj1.a(3, d);
        }
        if (b != null)
        {
            euj1.a(4, b);
        }
        if (e != null)
        {
            euj1.a(6, e);
        }
        if (f != null)
        {
            euj1.a(7, f);
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
            if (!(obj instanceof dzk))
            {
                return false;
            }
            obj = (dzk)obj;
            if ((a != null ? a.equals(((dzk) (obj)).a) : ((dzk) (obj)).a == null) && (c != null ? c.equals(((dzk) (obj)).c) : ((dzk) (obj)).c == null) && d == ((dzk) (obj)).d && (b != null ? b.equals(((dzk) (obj)).b) : ((dzk) (obj)).b == null) && (e != null ? e.equals(((dzk) (obj)).e) : ((dzk) (obj)).e == null) && (f != null ? f.equals(((dzk) (obj)).f) : ((dzk) (obj)).f == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dzk) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dzk) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k1 = 0;
        int l1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (c == null)
        {
            j = 0;
        } else
        {
            j = c.hashCode();
        }
        if (d)
        {
            k = 1;
        } else
        {
            k = 2;
        }
        if (b == null)
        {
            l = 0;
        } else
        {
            l = b.hashCode();
        }
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        if (f == null)
        {
            j1 = 0;
        } else
        {
            j1 = f.hashCode();
        }
        if (O != null)
        {
            k1 = O.hashCode();
        }
        return (j1 + (i1 + (l + (k + (j + (i + (l1 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k1;
    }
}
