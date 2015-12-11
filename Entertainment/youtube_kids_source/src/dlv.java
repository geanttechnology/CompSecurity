// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dlv extends eul
{

    public dsz a;
    private dwa b;
    private String c;
    private boolean d;

    public dlv()
    {
        b = null;
        a = null;
        c = "";
        d = false;
    }

    public final int a()
    {
        int j = 0;
        if (b != null)
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (a != null)
        {
            i = j + euj.b(2, a);
        }
        j = i;
        if (!c.equals(""))
        {
            j = i + euj.b(3, c);
        }
        i = j;
        if (d)
        {
            boolean flag = d;
            i = j + (euj.b(4) + 1);
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
                if (b == null)
                {
                    b = new dwa();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                if (a == null)
                {
                    a = new dsz();
                }
                eui1.a(a);
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 32: // ' '
                d = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(1, b);
        }
        if (a != null)
        {
            euj1.a(2, a);
        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (d)
        {
            euj1.a(4, d);
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
            if (!(obj instanceof dlv))
            {
                return false;
            }
            obj = (dlv)obj;
            if ((b != null ? b.equals(((dlv) (obj)).b) : ((dlv) (obj)).b == null) && (a != null ? a.equals(((dlv) (obj)).a) : ((dlv) (obj)).a == null) && (c != null ? c.equals(((dlv) (obj)).c) : ((dlv) (obj)).c == null) && d == ((dlv) (obj)).d)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dlv) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dlv) (obj)).O))
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
        if (a == null)
        {
            j = 0;
        } else
        {
            j = a.hashCode();
        }
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        if (d)
        {
            l = 1;
        } else
        {
            l = 2;
        }
        if (O != null)
        {
            i1 = O.hashCode();
        }
        return (l + (k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31) * 31 + i1;
    }
}
