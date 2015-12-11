// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dwz extends eul
{

    private String a[];
    private String b;
    private String c;

    public dwz()
    {
        a = eup.d;
        b = "";
        c = "";
    }

    public final int a()
    {
        int j = 0;
        boolean flag = false;
        int i = j;
        if (a != null)
        {
            i = j;
            if (a.length > 0)
            {
                String as[] = a;
                int k = as.length;
                j = 0;
                for (i = ((flag) ? 1 : 0); i < k; i++)
                {
                    j += euj.a(as[i]);
                }

                i = j + 0 + a.length * 1;
            }
        }
        j = i;
        if (!b.equals(""))
        {
            j = i + euj.b(2, b);
        }
        i = j;
        if (!c.equals(""))
        {
            i = j + euj.b(3, c);
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
                int k = eup.a(eui1, 10);
                int j = a.length;
                String as[] = new String[k + j];
                System.arraycopy(a, 0, as, 0, j);
                for (a = as; j < a.length - 1; j++)
                {
                    a[j] = eui1.f();
                    eui1.a();
                }

                a[j] = eui1.f();
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            String as[] = a;
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                euj1.a(1, as[i]);
            }

        }
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
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
            if (!(obj instanceof dwz))
            {
                return false;
            }
            obj = (dwz)obj;
            if (Arrays.equals(a, ((dwz) (obj)).a) && (b != null ? b.equals(((dwz) (obj)).b) : ((dwz) (obj)).b == null) && (c != null ? c.equals(((dwz) (obj)).c) : ((dwz) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dwz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dwz) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        int l;
        l = 0;
        i = getClass().getName().hashCode() + 527;
        if (a != null) goto _L2; else goto _L1
_L1:
        int j = i * 31;
_L4:
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
            k = 0;
        } else
        {
            k = c.hashCode();
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
        if (k >= a.length) goto _L4; else goto _L3
_L3:
        if (a[k] == null)
        {
            j = 0;
        } else
        {
            j = a[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L5
    }
}
