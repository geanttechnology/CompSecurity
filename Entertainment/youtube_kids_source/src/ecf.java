// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ecf extends eul
{

    public String a;
    private byte b[];
    private boolean c;
    private boolean d;
    private dpd e;

    public ecf()
    {
        a = "";
        b = eup.f;
        c = false;
        d = false;
        e = null;
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
        if (c)
        {
            boolean flag = c;
            j = i + (euj.b(4) + 1);
        }
        i = j;
        if (d)
        {
            boolean flag1 = d;
            i = j + (euj.b(5) + 1);
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
                a = eui1.f();
                break;

            case 26: // '\032'
                b = eui1.g();
                break;

            case 32: // ' '
                c = eui1.e();
                break;

            case 40: // '('
                d = eui1.e();
                break;

            case 50: // '2'
                if (e == null)
                {
                    e = new dpd();
                }
                eui1.a(e);
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
        if (c)
        {
            euj1.a(4, c);
        }
        if (d)
        {
            euj1.a(5, d);
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
            if (!(obj instanceof ecf))
            {
                return false;
            }
            obj = (ecf)obj;
            if ((a != null ? a.equals(((ecf) (obj)).a) : ((ecf) (obj)).a == null) && (Arrays.equals(b, ((ecf) (obj)).b) && c == ((ecf) (obj)).c && d == ((ecf) (obj)).d) && (e != null ? e.equals(((ecf) (obj)).e) : ((ecf) (obj)).e == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ecf) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ecf) (obj)).O))
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
        int i1;
        boolean flag = true;
        i1 = 0;
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
        int l;
        if (c)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (d)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = 2;
        }
        if (e == null)
        {
            l = 0;
        } else
        {
            l = e.hashCode();
        }
        if (O != null)
        {
            i1 = O.hashCode();
        }
        return (l + ((i + j * 31) * 31 + k) * 31) * 31 + i1;
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
