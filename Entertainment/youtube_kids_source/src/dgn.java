// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dgn extends eul
{

    private dlb a;
    private dgp b;
    private dgp c;
    private dlb d;
    private dgo e;
    private byte f[];

    public dgn()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = eup.f;
    }

    public final int a()
    {
        int j = 0;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (b != null)
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(3, c);
        }
        i = j;
        if (d != null)
        {
            i = j + euj.b(4, d);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(5, e);
        }
        i = j;
        if (!Arrays.equals(f, eup.f))
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
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dgp();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dgp();
                }
                eui1.a(c);
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dgo();
                }
                eui1.a(e);
                break;

            case 58: // ':'
                f = eui1.g();
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
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            euj1.a(3, c);
        }
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (!Arrays.equals(f, eup.f))
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
            if (!(obj instanceof dgn))
            {
                return false;
            }
            obj = (dgn)obj;
            if ((a != null ? a.equals(((dgn) (obj)).a) : ((dgn) (obj)).a == null) && (b != null ? b.equals(((dgn) (obj)).b) : ((dgn) (obj)).b == null) && (c != null ? c.equals(((dgn) (obj)).c) : ((dgn) (obj)).c == null) && (d != null ? d.equals(((dgn) (obj)).d) : ((dgn) (obj)).d == null) && (e != null ? e.equals(((dgn) (obj)).e) : ((dgn) (obj)).e == null) && Arrays.equals(f, ((dgn) (obj)).f))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dgn) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dgn) (obj)).O))
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
        int k1 = getClass().getName().hashCode();
        int k;
        int i1;
        int j1;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
        }
        if (e == null)
        {
            j1 = 0;
        } else
        {
            j1 = e.hashCode();
        }
        i = j1 + (i1 + (k + (j + (i + (k1 + 527) * 31) * 31) * 31) * 31) * 31;
        if (f != null) goto _L2; else goto _L1
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
        if (l >= f.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + f[l];
        l++;
          goto _L5
    }
}
