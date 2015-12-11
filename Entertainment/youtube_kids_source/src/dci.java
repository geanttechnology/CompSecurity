// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dci extends eul
{

    public int a;
    public int b;
    public int c;
    public String d;
    private boolean e;

    public dci()
    {
        a = 0;
        b = 0;
        c = 0;
        d = "";
        e = false;
    }

    public final int a()
    {
        int j = 0;
        if (a != 0)
        {
            j = euj.c(1, a) + 0;
        }
        int i = j;
        if (b != 0)
        {
            i = j + euj.c(2, b);
        }
        j = i;
        if (c != 0)
        {
            j = i + euj.c(3, c);
        }
        i = j;
        if (!d.equals(""))
        {
            i = j + euj.b(5, d);
        }
        j = i;
        if (e)
        {
            boolean flag = e;
            j = i + (euj.b(6) + 1);
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
                if (j == 0 || j == 1 || j == 2 || j == 3 || j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10 || j == 11 || j == 12 || j == 13 || j == 14)
                {
                    a = j;
                } else
                {
                    a = 0;
                }
                break;

            case 16: // '\020'
                int k = eui1.d();
                if (k == 0 || k == 1 || k == 2 || k == 3 || k == 4 || k == 5 || k == 6 || k == 7 || k == 8 || k == 9 || k == 10 || k == 11 || k == 12 || k == 13 || k == 14)
                {
                    b = k;
                } else
                {
                    b = 0;
                }
                break;

            case 24: // '\030'
                int l = eui1.d();
                if (l == 0 || l == 1 || l == 2 || l == 3 || l == 4)
                {
                    c = l;
                } else
                {
                    c = 0;
                }
                break;

            case 42: // '*'
                d = eui1.f();
                break;

            case 48: // '0'
                e = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != 0)
        {
            euj1.a(1, a);
        }
        if (b != 0)
        {
            euj1.a(2, b);
        }
        if (c != 0)
        {
            euj1.a(3, c);
        }
        if (!d.equals(""))
        {
            euj1.a(5, d);
        }
        if (e)
        {
            euj1.a(6, e);
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
            if (!(obj instanceof dci))
            {
                return false;
            }
            obj = (dci)obj;
            if (a == ((dci) (obj)).a && b == ((dci) (obj)).b && c == ((dci) (obj)).c && (d != null ? d.equals(((dci) (obj)).d) : ((dci) (obj)).d == null) && e == ((dci) (obj)).e)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dci) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dci) (obj)).O))
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
        int i1 = a;
        int j1 = b;
        int k1 = c;
        int i;
        int j;
        if (d == null)
        {
            i = 0;
        } else
        {
            i = d.hashCode();
        }
        if (e)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        if (O != null)
        {
            k = O.hashCode();
        }
        return (j + (i + ((((l + 527) * 31 + i1) * 31 + j1) * 31 + k1) * 31) * 31) * 31 + k;
    }
}
