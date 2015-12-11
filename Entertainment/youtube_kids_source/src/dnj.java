// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dnj extends eul
{

    public byte a[];
    public dre b;
    private dzp c;
    private dlb d;
    private dni e;

    public dnj()
    {
        c = null;
        d = null;
        e = null;
        a = eup.f;
        b = null;
    }

    public final int a()
    {
        int j = 0;
        if (c != null)
        {
            j = euj.b(1, c) + 0;
        }
        int i = j;
        if (d != null)
        {
            i = j + euj.b(2, d);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(3, e);
        }
        i = j;
        if (!Arrays.equals(a, eup.f))
        {
            i = j + euj.b(5, a);
        }
        j = i;
        if (b != null)
        {
            j = i + euj.b(6, b);
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

            case 10: // '\n'
                if (c == null)
                {
                    c = new dzp();
                }
                eui1.a(c);
                break;

            case 18: // '\022'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 26: // '\032'
                if (e == null)
                {
                    e = new dni();
                }
                eui1.a(e);
                break;

            case 42: // '*'
                a = eui1.g();
                break;

            case 50: // '2'
                if (b == null)
                {
                    b = new dre();
                }
                eui1.a(b);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (c != null)
        {
            euj1.a(1, c);
        }
        if (d != null)
        {
            euj1.a(2, d);
        }
        if (e != null)
        {
            euj1.a(3, e);
        }
        if (!Arrays.equals(a, eup.f))
        {
            euj1.a(5, a);
        }
        if (b != null)
        {
            euj1.a(6, b);
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
            if (!(obj instanceof dnj))
            {
                return false;
            }
            obj = (dnj)obj;
            if ((c != null ? c.equals(((dnj) (obj)).c) : ((dnj) (obj)).c == null) && (d != null ? d.equals(((dnj) (obj)).d) : ((dnj) (obj)).d == null) && (e != null ? e.equals(((dnj) (obj)).e) : ((dnj) (obj)).e == null) && Arrays.equals(a, ((dnj) (obj)).a) && (b != null ? b.equals(((dnj) (obj)).b) : ((dnj) (obj)).b == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dnj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dnj) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        int j;
        int k;
        boolean flag = false;
        int l = getClass().getName().hashCode();
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
        if (e == null)
        {
            k = 0;
        } else
        {
            k = e.hashCode();
        }
        i = k + (j + (i + (l + 527) * 31) * 31) * 31;
        if (a != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return (i + j * 31) * 31 + k;
_L2:
        k = 0;
_L5:
        j = i;
        if (k >= a.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + a[k];
        k++;
          goto _L5
    }
}
