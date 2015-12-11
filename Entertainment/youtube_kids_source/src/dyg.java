// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dyg extends eul
{

    private dlb a;
    private dre b;
    private String c[];
    private byte d[];

    public dyg()
    {
        a = null;
        b = null;
        c = eup.d;
        d = eup.f;
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
                int l = as.length;
                int k = 0;
                for (j = ((flag) ? 1 : 0); j < l; j++)
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
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dre();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                int k = eup.a(eui1, 26);
                int j = c.length;
                String as[] = new String[k + j];
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
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
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
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                euj1.a(3, as[i]);
            }

        }
        if (!Arrays.equals(d, eup.f))
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
            if (!(obj instanceof dyg))
            {
                return false;
            }
            obj = (dyg)obj;
            if ((a != null ? a.equals(((dyg) (obj)).a) : ((dyg) (obj)).a == null) && (b != null ? b.equals(((dyg) (obj)).b) : ((dyg) (obj)).b == null) && (Arrays.equals(c, ((dyg) (obj)).c) && Arrays.equals(d, ((dyg) (obj)).d)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dyg) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dyg) (obj)).O))
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
_L6:
        if (d != null) goto _L4; else goto _L3
_L3:
        i = j * 31;
_L9:
        int l;
        if (O == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = O.hashCode();
        }
        return i * 31 + j;
_L2:
        l = 0;
_L7:
        j = i;
        if (l >= c.length) goto _L6; else goto _L5
_L5:
        if (c[l] == null)
        {
            j = 0;
        } else
        {
            j = c[l].hashCode();
        }
        i = j + i * 31;
        l++;
          goto _L7
          goto _L6
_L4:
        l = 0;
_L10:
        i = j;
        if (l >= d.length) goto _L9; else goto _L8
_L8:
        j = j * 31 + d[l];
        l++;
          goto _L10
    }
}
