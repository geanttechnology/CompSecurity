// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dhz extends eul
{

    public dre a;
    private dmb b;
    private dzp c;
    private dlb d;
    private byte e[];

    public dhz()
    {
        b = null;
        c = null;
        d = null;
        a = null;
        e = eup.f;
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
        if (a != null)
        {
            i = j + euj.b(4, a);
        }
        j = i;
        if (!Arrays.equals(e, eup.f))
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
                if (b == null)
                {
                    b = new dmb();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dzp();
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

            case 34: // '"'
                if (a == null)
                {
                    a = new dre();
                }
                eui1.a(a);
                break;

            case 50: // '2'
                e = eui1.g();
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
        if (a != null)
        {
            euj1.a(4, a);
        }
        if (!Arrays.equals(e, eup.f))
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
            if (!(obj instanceof dhz))
            {
                return false;
            }
            obj = (dhz)obj;
            if ((b != null ? b.equals(((dhz) (obj)).b) : ((dhz) (obj)).b == null) && (c != null ? c.equals(((dhz) (obj)).c) : ((dhz) (obj)).c == null) && (d != null ? d.equals(((dhz) (obj)).d) : ((dhz) (obj)).d == null) && (a != null ? a.equals(((dhz) (obj)).a) : ((dhz) (obj)).a == null) && Arrays.equals(e, ((dhz) (obj)).e))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dhz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dhz) (obj)).O))
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
        int j1 = getClass().getName().hashCode();
        int k;
        int i1;
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
        if (a == null)
        {
            i1 = 0;
        } else
        {
            i1 = a.hashCode();
        }
        i = i1 + (k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31;
        if (e != null) goto _L2; else goto _L1
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
        if (l >= e.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + e[l];
        l++;
          goto _L5
    }
}
