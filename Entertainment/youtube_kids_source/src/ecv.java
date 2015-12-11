// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ecv extends eul
{

    public static final ecv a[] = new ecv[0];
    public dre b;
    private dlb c;
    private dzp d;
    private byte e[];

    public ecv()
    {
        c = null;
        d = null;
        b = null;
        e = eup.f;
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
        if (b != null)
        {
            j = i + euj.b(3, b);
        }
        i = j;
        if (!Arrays.equals(e, eup.f))
        {
            i = j + euj.b(5, e);
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
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 18: // '\022'
                if (d == null)
                {
                    d = new dzp();
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

            case 42: // '*'
                e = eui1.g();
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
        if (b != null)
        {
            euj1.a(3, b);
        }
        if (!Arrays.equals(e, eup.f))
        {
            euj1.a(5, e);
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
            if (!(obj instanceof ecv))
            {
                return false;
            }
            obj = (ecv)obj;
            if ((c != null ? c.equals(((ecv) (obj)).c) : ((ecv) (obj)).c == null) && (d != null ? d.equals(((ecv) (obj)).d) : ((ecv) (obj)).d == null) && (b != null ? b.equals(((ecv) (obj)).b) : ((ecv) (obj)).b == null) && Arrays.equals(e, ((ecv) (obj)).e))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ecv) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ecv) (obj)).O))
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
        if (b == null)
        {
            k = 0;
        } else
        {
            k = b.hashCode();
        }
        i = k + (j + (i + (i1 + 527) * 31) * 31) * 31;
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
