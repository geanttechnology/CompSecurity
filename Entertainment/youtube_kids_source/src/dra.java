// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dra extends eul
{

    public byte a[];
    private dzp b;
    private dlb c;
    private dlb d;

    public dra()
    {
        b = null;
        c = null;
        d = null;
        a = eup.f;
    }

    public final int a()
    {
        int j = 0;
        if (b != null)
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(3, d);
        }
        i = j;
        if (!Arrays.equals(a, eup.f))
        {
            i = j + euj.b(5, a);
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
                    b = new dzp();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                a = eui1.g();
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
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (d != null)
        {
            euj1.a(3, d);
        }
        if (!Arrays.equals(a, eup.f))
        {
            euj1.a(5, a);
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
            if (!(obj instanceof dra))
            {
                return false;
            }
            obj = (dra)obj;
            if ((b != null ? b.equals(((dra) (obj)).b) : ((dra) (obj)).b == null) && (c != null ? c.equals(((dra) (obj)).c) : ((dra) (obj)).c == null) && (d != null ? d.equals(((dra) (obj)).d) : ((dra) (obj)).d == null) && Arrays.equals(a, ((dra) (obj)).a))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dra) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dra) (obj)).O))
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
        boolean flag = false;
        int i1 = getClass().getName().hashCode();
        int k;
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
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        i = k + (j + (i + (i1 + 527) * 31) * 31) * 31;
        if (a != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        int l;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return j * 31 + i;
_L2:
        l = 0;
_L5:
        j = i;
        if (l >= a.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + a[l];
        l++;
          goto _L5
    }
}
