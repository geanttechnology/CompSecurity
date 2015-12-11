// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ecl extends eul
{

    public static final ecl a[] = new ecl[0];
    public dre b;
    private dzp c;
    private dlb d;
    private dlb e;
    private byte f[];

    public ecl()
    {
        c = null;
        d = null;
        e = null;
        b = null;
        f = eup.f;
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
        if (b != null)
        {
            i = j + euj.b(4, b);
        }
        j = i;
        if (!Arrays.equals(f, eup.f))
        {
            j = i + euj.b(6, f);
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
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 34: // '"'
                if (b == null)
                {
                    b = new dre();
                }
                eui1.a(b);
                break;

            case 50: // '2'
                f = eui1.g();
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
        if (b != null)
        {
            euj1.a(4, b);
        }
        if (!Arrays.equals(f, eup.f))
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
            if (!(obj instanceof ecl))
            {
                return false;
            }
            obj = (ecl)obj;
            if ((c != null ? c.equals(((ecl) (obj)).c) : ((ecl) (obj)).c == null) && (d != null ? d.equals(((ecl) (obj)).d) : ((ecl) (obj)).d == null) && (e != null ? e.equals(((ecl) (obj)).e) : ((ecl) (obj)).e == null) && (b != null ? b.equals(((ecl) (obj)).b) : ((ecl) (obj)).b == null) && Arrays.equals(f, ((ecl) (obj)).f))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ecl) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ecl) (obj)).O))
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
        if (b == null)
        {
            i1 = 0;
        } else
        {
            i1 = b.hashCode();
        }
        i = i1 + (k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31;
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
