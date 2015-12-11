// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dcq extends eul
{

    private boolean a;
    private String b;
    private byte c[];
    private String d;

    public dcq()
    {
        a = false;
        b = "";
        c = eup.f;
        d = "";
    }

    public final int a()
    {
        int j = 0;
        if (a)
        {
            boolean flag = a;
            j = euj.b(1) + 1 + 0;
        }
        int i = j;
        if (!b.equals(""))
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (!Arrays.equals(c, eup.f))
        {
            j = i + euj.b(3, c);
        }
        i = j;
        if (!d.equals(""))
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

            case 8: // '\b'
                a = eui1.e();
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 26: // '\032'
                c = eui1.g();
                break;

            case 34: // '"'
                d = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a)
        {
            euj1.a(1, a);
        }
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(3, c);
        }
        if (!d.equals(""))
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
            if (!(obj instanceof dcq))
            {
                return false;
            }
            obj = (dcq)obj;
            if (a == ((dcq) (obj)).a && (b != null ? b.equals(((dcq) (obj)).b) : ((dcq) (obj)).b == null) && Arrays.equals(c, ((dcq) (obj)).c) && (d != null ? d.equals(((dcq) (obj)).d) : ((dcq) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dcq) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dcq) (obj)).O))
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
        if (a)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        i = j + (i + (k + 527) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        int l;
        if (d == null)
        {
            i = 0;
        } else
        {
            i = d.hashCode();
        }
        if (O == null)
        {
            l = ((flag) ? 1 : 0);
        } else
        {
            l = O.hashCode();
        }
        return (i + j * 31) * 31 + l;
_L2:
        l = 0;
_L5:
        j = i;
        if (l >= c.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + c[l];
        l++;
          goto _L5
    }
}
