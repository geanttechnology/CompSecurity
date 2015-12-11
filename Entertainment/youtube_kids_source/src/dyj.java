// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dyj extends eul
{

    private dzp a;
    private dlb b;
    private String c[];
    private byte d[];
    private String e[];
    private String f[];

    public dyj()
    {
        a = null;
        b = null;
        c = eup.d;
        d = eup.f;
        e = eup.d;
        f = eup.d;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (b != null)
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (c != null)
        {
            j = i;
            if (c.length > 0)
            {
                String as[] = c;
                int j1 = as.length;
                j = 0;
                int k = 0;
                for (; j < j1; j++)
                {
                    k += euj.a(as[j]);
                }

                j = i + k + c.length * 1;
            }
        }
        i = j;
        if (!Arrays.equals(d, eup.f))
        {
            i = j + euj.b(5, d);
        }
        j = i;
        if (e != null)
        {
            j = i;
            if (e.length > 0)
            {
                String as1[] = e;
                int k1 = as1.length;
                j = 0;
                int l = 0;
                for (; j < k1; j++)
                {
                    l += euj.a(as1[j]);
                }

                j = i + l + e.length * 1;
            }
        }
        i = j;
        if (f != null)
        {
            i = j;
            if (f.length > 0)
            {
                String as2[] = f;
                int l1 = as2.length;
                int i1 = 0;
                for (i = ((flag) ? 1 : 0); i < l1; i++)
                {
                    i1 += euj.a(as2[i]);
                }

                i = j + i1 + f.length * 1;
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

            case 10: // '\n'
                if (a == null)
                {
                    a = new dzp();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                int i1 = eup.a(eui1, 26);
                int j = c.length;
                String as[] = new String[i1 + j];
                System.arraycopy(c, 0, as, 0, j);
                for (c = as; j < c.length - 1; j++)
                {
                    c[j] = eui1.f();
                    eui1.a();
                }

                c[j] = eui1.f();
                break;

            case 42: // '*'
                d = eui1.g();
                break;

            case 50: // '2'
                int j1 = eup.a(eui1, 50);
                int k = e.length;
                String as1[] = new String[j1 + k];
                System.arraycopy(e, 0, as1, 0, k);
                for (e = as1; k < e.length - 1; k++)
                {
                    e[k] = eui1.f();
                    eui1.a();
                }

                e[k] = eui1.f();
                break;

            case 58: // ':'
                int k1 = eup.a(eui1, 58);
                int l = f.length;
                String as2[] = new String[k1 + l];
                System.arraycopy(f, 0, as2, 0, l);
                for (f = as2; l < f.length - 1; l++)
                {
                    f[l] = eui1.f();
                    eui1.a();
                }

                f[l] = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
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
            String as[] = c;
            int l = as.length;
            for (int i = 0; i < l; i++)
            {
                euj1.a(3, as[i]);
            }

        }
        if (!Arrays.equals(d, eup.f))
        {
            euj1.a(5, d);
        }
        if (e != null)
        {
            String as1[] = e;
            int i1 = as1.length;
            for (int j = 0; j < i1; j++)
            {
                euj1.a(6, as1[j]);
            }

        }
        if (f != null)
        {
            String as2[] = f;
            int j1 = as2.length;
            for (int k = ((flag) ? 1 : 0); k < j1; k++)
            {
                euj1.a(7, as2[k]);
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
            if (!(obj instanceof dyj))
            {
                return false;
            }
            obj = (dyj)obj;
            if ((a != null ? a.equals(((dyj) (obj)).a) : ((dyj) (obj)).a == null) && (b != null ? b.equals(((dyj) (obj)).b) : ((dyj) (obj)).b == null) && (Arrays.equals(c, ((dyj) (obj)).c) && Arrays.equals(d, ((dyj) (obj)).d) && Arrays.equals(e, ((dyj) (obj)).e) && Arrays.equals(f, ((dyj) (obj)).f)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dyj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dyj) (obj)).O))
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
        i = j + (i + (k + 527) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L10:
        if (d != null) goto _L4; else goto _L3
_L3:
        i = j * 31;
_L13:
        if (e != null) goto _L6; else goto _L5
_L5:
        j = i * 31;
_L16:
        if (f != null) goto _L8; else goto _L7
_L7:
        k = j * 31;
_L19:
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
_L11:
        j = i;
        if (k >= c.length) goto _L10; else goto _L9
_L9:
        if (c[k] == null)
        {
            j = 0;
        } else
        {
            j = c[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L11
          goto _L10
_L4:
        k = 0;
_L14:
        i = j;
        if (k >= d.length) goto _L13; else goto _L12
_L12:
        j = j * 31 + d[k];
        k++;
          goto _L14
          goto _L13
_L6:
        k = 0;
_L17:
        j = i;
        if (k >= e.length) goto _L16; else goto _L15
_L15:
        if (e[k] == null)
        {
            j = 0;
        } else
        {
            j = e[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L17
          goto _L16
_L8:
        k = 0;
        i = j;
        j = k;
_L20:
        k = i;
        if (j >= f.length) goto _L19; else goto _L18
_L18:
        if (f[j] == null)
        {
            k = 0;
        } else
        {
            k = f[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L20
    }
}
