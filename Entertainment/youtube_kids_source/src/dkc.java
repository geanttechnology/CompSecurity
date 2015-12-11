// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dkc extends eul
{

    private String a;
    private byte b[];
    private String c;
    private dmb d;

    public dkc()
    {
        a = "";
        b = eup.f;
        c = "";
        d = null;
    }

    public final int a()
    {
        int j = 0;
        if (!a.equals(""))
        {
            j = euj.b(1, a) + 0;
        }
        int i = j;
        if (!Arrays.equals(b, eup.f))
        {
            i = j + euj.b(3, b);
        }
        j = i;
        if (!c.equals(""))
        {
            j = i + euj.b(4, c);
        }
        i = j;
        if (d != null)
        {
            i = j + euj.b(5, d);
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
                a = eui1.f();
                break;

            case 26: // '\032'
                b = eui1.g();
                break;

            case 34: // '"'
                c = eui1.f();
                break;

            case 42: // '*'
                if (d == null)
                {
                    d = new dmb();
                }
                eui1.a(d);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!a.equals(""))
        {
            euj1.a(1, a);
        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(3, b);
        }
        if (!c.equals(""))
        {
            euj1.a(4, c);
        }
        if (d != null)
        {
            euj1.a(5, d);
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
            if (!(obj instanceof dkc))
            {
                return false;
            }
            obj = (dkc)obj;
            if ((a != null ? a.equals(((dkc) (obj)).a) : ((dkc) (obj)).a == null) && Arrays.equals(b, ((dkc) (obj)).b) && (c != null ? c.equals(((dkc) (obj)).c) : ((dkc) (obj)).c == null) && (d != null ? d.equals(((dkc) (obj)).d) : ((dkc) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dkc) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dkc) (obj)).O))
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
        int l;
        l = 0;
        j = getClass().getName().hashCode();
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        i += (j + 527) * 31;
        if (b != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
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
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + (i + j * 31) * 31) * 31 + l;
_L2:
        k = 0;
_L5:
        j = i;
        if (k >= b.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + b[k];
        k++;
          goto _L5
    }
}
