// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dns extends eul
{

    private dnt a;
    private int b;
    private String c;
    private byte d[];

    public dns()
    {
        a = null;
        b = 0;
        c = "";
        d = eup.f;
    }

    public final int a()
    {
        int j = 0;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (b != 0)
        {
            i = j + euj.c(2, b);
        }
        j = i;
        if (!c.equals(""))
        {
            j = i + euj.b(3, c);
        }
        i = j;
        if (!Arrays.equals(d, eup.f))
        {
            i = j + euj.b(4, d);
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
                    a = new dnt();
                }
                eui1.a(a);
                break;

            case 16: // '\020'
                b = eui1.d();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 34: // '"'
                d = eui1.g();
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
        if (b != 0)
        {
            euj1.a(2, b);
        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (!Arrays.equals(d, eup.f))
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
            if (!(obj instanceof dns))
            {
                return false;
            }
            obj = (dns)obj;
            if ((a != null ? a.equals(((dns) (obj)).a) : ((dns) (obj)).a == null) && b == ((dns) (obj)).b && (c != null ? c.equals(((dns) (obj)).c) : ((dns) (obj)).c == null) && Arrays.equals(d, ((dns) (obj)).d))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dns) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dns) (obj)).O))
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
        int k = getClass().getName().hashCode();
        int i1;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        i1 = b;
        if (c == null)
        {
            j = 0;
        } else
        {
            j = c.hashCode();
        }
        i = j + ((i + (k + 527) * 31) * 31 + i1) * 31;
        if (d != null) goto _L2; else goto _L1
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
        if (l >= d.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + d[l];
        l++;
          goto _L5
    }
}
