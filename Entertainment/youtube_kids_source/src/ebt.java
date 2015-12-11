// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ebt extends eul
{

    public ebv a;
    public dre b;
    public byte c[];
    private dlb d;
    private ebr e;

    public ebt()
    {
        a = null;
        d = null;
        b = null;
        c = eup.f;
        e = null;
    }

    public final int a()
    {
        int j = 0;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (d != null)
        {
            i = j + euj.b(2, d);
        }
        j = i;
        if (b != null)
        {
            j = i + euj.b(3, b);
        }
        i = j;
        if (!Arrays.equals(c, eup.f))
        {
            i = j + euj.b(4, c);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(6, e);
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
                if (a == null)
                {
                    a = new ebv();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 26: // '\032'
                if (b == null)
                {
                    b = new dre();
                }
                eui1.a(b);
                break;

            case 34: // '"'
                c = eui1.g();
                break;

            case 50: // '2'
                if (e == null)
                {
                    e = new ebr();
                }
                eui1.a(e);
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
        if (d != null)
        {
            euj1.a(2, d);
        }
        if (b != null)
        {
            euj1.a(3, b);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(4, c);
        }
        if (e != null)
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
            if (!(obj instanceof ebt))
            {
                return false;
            }
            obj = (ebt)obj;
            if ((a != null ? a.equals(((ebt) (obj)).a) : ((ebt) (obj)).a == null) && (d != null ? d.equals(((ebt) (obj)).d) : ((ebt) (obj)).d == null) && (b != null ? b.equals(((ebt) (obj)).b) : ((ebt) (obj)).b == null) && Arrays.equals(c, ((ebt) (obj)).c) && (e != null ? e.equals(((ebt) (obj)).e) : ((ebt) (obj)).e == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ebt) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ebt) (obj)).O))
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
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (d == null)
        {
            j = 0;
        } else
        {
            j = d.hashCode();
        }
        if (b == null)
        {
            k = 0;
        } else
        {
            k = b.hashCode();
        }
        i = k + (j + (i + (l + 527) * 31) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        if (e == null)
        {
            i = 0;
        } else
        {
            i = e.hashCode();
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
        if (k >= c.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + c[k];
        k++;
          goto _L5
    }
}
