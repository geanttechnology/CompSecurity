// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dxx extends eul
{

    private int a;
    private int b;
    private String c;
    private String d;
    private String e[];
    private String f[];

    public dxx()
    {
        a = 0;
        b = 0;
        c = "";
        d = "";
        e = eup.d;
        f = eup.d;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        if (a != 0)
        {
            j = euj.c(1, a) + 0;
        } else
        {
            j = 0;
        }
        i = j;
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
        if (!d.equals(""))
        {
            i = j + euj.b(4, d);
        }
        j = i;
        if (e != null)
        {
            j = i;
            if (e.length > 0)
            {
                String as[] = e;
                int i1 = as.length;
                j = 0;
                int k = 0;
                for (; j < i1; j++)
                {
                    k += euj.a(as[j]);
                }

                j = i + k + e.length * 1;
            }
        }
        i = j;
        if (f != null)
        {
            i = j;
            if (f.length > 0)
            {
                String as1[] = f;
                int j1 = as1.length;
                int l = 0;
                for (i = ((flag) ? 1 : 0); i < j1; i++)
                {
                    l += euj.a(as1[i]);
                }

                i = j + l + f.length * 1;
            }
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
                a = eui1.d();
                break;

            case 16: // '\020'
                b = eui1.d();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 34: // '"'
                d = eui1.f();
                break;

            case 42: // '*'
                int l = eup.a(eui1, 42);
                int j = e.length;
                String as[] = new String[l + j];
                System.arraycopy(e, 0, as, 0, j);
                for (e = as; j < e.length - 1; j++)
                {
                    e[j] = eui1.f();
                    eui1.a();
                }

                e[j] = eui1.f();
                break;

            case 50: // '2'
                int i1 = eup.a(eui1, 50);
                int k = f.length;
                String as1[] = new String[i1 + k];
                System.arraycopy(f, 0, as1, 0, k);
                for (f = as1; k < f.length - 1; k++)
                {
                    f[k] = eui1.f();
                    eui1.a();
                }

                f[k] = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != 0)
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
        if (!d.equals(""))
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            String as[] = e;
            int k = as.length;
            for (int i = 0; i < k; i++)
            {
                euj1.a(5, as[i]);
            }

        }
        if (f != null)
        {
            String as1[] = f;
            int l = as1.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                euj1.a(6, as1[j]);
            }

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
            if (!(obj instanceof dxx))
            {
                return false;
            }
            obj = (dxx)obj;
            if (a == ((dxx) (obj)).a && b == ((dxx) (obj)).b && (c != null ? c.equals(((dxx) (obj)).c) : ((dxx) (obj)).c == null) && (d != null ? d.equals(((dxx) (obj)).d) : ((dxx) (obj)).d == null) && (Arrays.equals(e, ((dxx) (obj)).e) && Arrays.equals(f, ((dxx) (obj)).f)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dxx) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dxx) (obj)).O))
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
        int k;
        boolean flag = false;
        k = getClass().getName().hashCode();
        int l = a;
        int i1 = b;
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
        i = j + (i + (((k + 527) * 31 + l) * 31 + i1) * 31) * 31;
        if (e != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L6:
        if (f != null) goto _L4; else goto _L3
_L3:
        k = j * 31;
_L9:
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return k * 31 + i;
_L2:
        k = 0;
_L7:
        j = i;
        if (k >= e.length) goto _L6; else goto _L5
_L5:
        if (e[k] == null)
        {
            j = 0;
        } else
        {
            j = e[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L7
          goto _L6
_L4:
        k = 0;
        i = j;
        j = k;
_L10:
        k = i;
        if (j >= f.length) goto _L9; else goto _L8
_L8:
        if (f[j] == null)
        {
            k = 0;
        } else
        {
            k = f[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L10
    }
}
