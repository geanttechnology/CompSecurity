// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dpz extends eul
{

    public String a[];
    public dqa b;
    private int c;
    private String d;
    private boolean e;

    public dpz()
    {
        c = 0;
        d = "";
        e = false;
        a = eup.d;
        b = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        if (c != 0)
        {
            i = euj.d(1, c) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (!d.equals(""))
        {
            j = i + euj.b(2, d);
        }
        i = j;
        if (e)
        {
            boolean flag1 = e;
            i = j + (euj.b(3) + 1);
        }
        j = i;
        if (a != null)
        {
            j = i;
            if (a.length > 0)
            {
                String as[] = a;
                int l = as.length;
                int k = 0;
                for (j = ((flag) ? 1 : 0); j < l; j++)
                {
                    k += euj.a(as[j]);
                }

                j = i + k + a.length * 1;
            }
        }
        i = j;
        if (b != null)
        {
            i = j + euj.b(6, b);
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
                c = eui1.h();
                break;

            case 18: // '\022'
                d = eui1.f();
                break;

            case 24: // '\030'
                e = eui1.e();
                break;

            case 42: // '*'
                int k = eup.a(eui1, 42);
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

            case 50: // '2'
                if (b == null)
                {
                    b = new dqa();
                }
                eui1.a(b);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (c != 0)
        {
            euj1.b(1, c);
        }
        if (!d.equals(""))
        {
            euj1.a(2, d);
        }
        if (e)
        {
            euj1.a(3, e);
        }
        if (a != null)
        {
            String as[] = a;
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                euj1.a(5, as[i]);
            }

        }
        if (b != null)
        {
            euj1.a(6, b);
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
            if (!(obj instanceof dpz))
            {
                return false;
            }
            obj = (dpz)obj;
            if (c == ((dpz) (obj)).c && (d != null ? d.equals(((dpz) (obj)).d) : ((dpz) (obj)).d == null) && (e == ((dpz) (obj)).e && Arrays.equals(a, ((dpz) (obj)).a)) && (b != null ? b.equals(((dpz) (obj)).b) : ((dpz) (obj)).b == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dpz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dpz) (obj)).O))
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
        int i1 = c;
        if (d == null)
        {
            i = 0;
        } else
        {
            i = d.hashCode();
        }
        if (e)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        i = j + (i + ((k + 527) * 31 + i1) * 31) * 31;
        if (a != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        int l;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
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
        if (l >= a.length) goto _L4; else goto _L3
_L3:
        if (a[l] == null)
        {
            j = 0;
        } else
        {
            j = a[l].hashCode();
        }
        i = j + i * 31;
        l++;
          goto _L5
    }
}
