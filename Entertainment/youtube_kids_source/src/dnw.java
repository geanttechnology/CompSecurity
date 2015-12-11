// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dnw extends eul
{

    private String a;
    private String b[];
    private String c[];

    public dnw()
    {
        a = "";
        b = eup.d;
        c = eup.d;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        if (!a.equals(""))
        {
            i = euj.b(1, a) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (b != null)
        {
            j = i;
            if (b.length > 0)
            {
                String as[] = b;
                int i1 = as.length;
                j = 0;
                int k = 0;
                for (; j < i1; j++)
                {
                    k += euj.a(as[j]);
                }

                j = i + k + b.length * 1;
            }
        }
        i = j;
        if (c != null)
        {
            i = j;
            if (c.length > 0)
            {
                String as1[] = c;
                int j1 = as1.length;
                int l = 0;
                for (i = ((flag) ? 1 : 0); i < j1; i++)
                {
                    l += euj.a(as1[i]);
                }

                i = j + l + c.length * 1;
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
                a = eui1.f();
                break;

            case 18: // '\022'
                int l = eup.a(eui1, 18);
                int j = b.length;
                String as[] = new String[l + j];
                System.arraycopy(b, 0, as, 0, j);
                for (b = as; j < b.length - 1; j++)
                {
                    b[j] = eui1.f();
                    eui1.a();
                }

                b[j] = eui1.f();
                break;

            case 26: // '\032'
                int i1 = eup.a(eui1, 26);
                int k = c.length;
                String as1[] = new String[i1 + k];
                System.arraycopy(c, 0, as1, 0, k);
                for (c = as1; k < c.length - 1; k++)
                {
                    c[k] = eui1.f();
                    eui1.a();
                }

                c[k] = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!a.equals(""))
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            String as[] = b;
            int k = as.length;
            for (int i = 0; i < k; i++)
            {
                euj1.a(2, as[i]);
            }

        }
        if (c != null)
        {
            String as1[] = c;
            int l = as1.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                euj1.a(3, as1[j]);
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
            if (!(obj instanceof dnw))
            {
                return false;
            }
            obj = (dnw)obj;
            if ((a != null ? a.equals(((dnw) (obj)).a) : ((dnw) (obj)).a == null) && (Arrays.equals(b, ((dnw) (obj)).b) && Arrays.equals(c, ((dnw) (obj)).c)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dnw) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dnw) (obj)).O))
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
_L6:
        if (c != null) goto _L4; else goto _L3
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
        if (k >= b.length) goto _L6; else goto _L5
_L5:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
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
        if (j >= c.length) goto _L9; else goto _L8
_L8:
        if (c[j] == null)
        {
            k = 0;
        } else
        {
            k = c[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L10
    }
}
