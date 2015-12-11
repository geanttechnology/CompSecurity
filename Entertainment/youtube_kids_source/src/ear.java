// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ear extends eul
{

    public String a;
    public dce b[];
    private String c;

    public ear()
    {
        a = "";
        b = dce.a;
        c = "";
    }

    public final int a()
    {
        int k = 0;
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
            dce adce[] = b;
            int l = adce.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dce dce1 = adce[k];
                j = i;
                if (dce1 != null)
                {
                    j = i + euj.b(2, dce1);
                }
                k++;
                i = j;
            } while (true);
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
                a = eui1.f();
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                dce adce[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adce = new dce[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adce, 0, j);
                }
                for (b = adce; j < b.length - 1; j++)
                {
                    b[j] = new dce();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dce();
                eui1.a(b[j]);
                break;

            case 26: // '\032'
                c = eui1.f();
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
        if (b != null)
        {
            dce adce[] = b;
            int j = adce.length;
            for (int i = 0; i < j; i++)
            {
                dce dce1 = adce[i];
                if (dce1 != null)
                {
                    euj1.a(2, dce1);
                }
            }

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
            if (!(obj instanceof ear))
            {
                return false;
            }
            obj = (ear)obj;
            if ((a != null ? a.equals(((ear) (obj)).a) : ((ear) (obj)).a == null) && Arrays.equals(b, ((ear) (obj)).b) && (c != null ? c.equals(((ear) (obj)).c) : ((ear) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ear) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ear) (obj)).O))
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
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return (i + j * 31) * 31 + k;
_L2:
        k = 0;
_L5:
        j = i;
        if (k >= b.length) goto _L4; else goto _L3
_L3:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L5
    }
}
