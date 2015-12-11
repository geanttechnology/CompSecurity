// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dtl extends eul
{

    private dkp a;
    private dko b;
    private dgg c[];
    private dug d;

    public dtl()
    {
        a = null;
        b = null;
        c = dgg.a;
        d = null;
    }

    public final int a()
    {
        int k = 0;
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
            dgg adgg[] = c;
            int l = adgg.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dgg dgg1 = adgg[k];
                j = i;
                if (dgg1 != null)
                {
                    j = i + euj.b(3, dgg1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (d != null)
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

            case 10: // '\n'
                if (a == null)
                {
                    a = new dkp();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dko();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                int k = eup.a(eui1, 26);
                dgg adgg[];
                int j;
                if (c == null)
                {
                    j = 0;
                } else
                {
                    j = c.length;
                }
                adgg = new dgg[k + j];
                if (c != null)
                {
                    System.arraycopy(c, 0, adgg, 0, j);
                }
                for (c = adgg; j < c.length - 1; j++)
                {
                    c[j] = new dgg();
                    eui1.a(c[j]);
                    eui1.a();
                }

                c[j] = new dgg();
                eui1.a(c[j]);
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dug();
                }
                eui1.a(d);
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
            dgg adgg[] = c;
            int j = adgg.length;
            for (int i = 0; i < j; i++)
            {
                dgg dgg1 = adgg[i];
                if (dgg1 != null)
                {
                    euj1.a(3, dgg1);
                }
            }

        }
        if (d != null)
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
            if (!(obj instanceof dtl))
            {
                return false;
            }
            obj = (dtl)obj;
            if ((a != null ? a.equals(((dtl) (obj)).a) : ((dtl) (obj)).a == null) && (b != null ? b.equals(((dtl) (obj)).b) : ((dtl) (obj)).b == null) && Arrays.equals(c, ((dtl) (obj)).c) && (d != null ? d.equals(((dtl) (obj)).d) : ((dtl) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dtl) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dtl) (obj)).O))
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
        if (c[l] == null)
        {
            j = 0;
        } else
        {
            j = c[l].hashCode();
        }
        i = j + i * 31;
        l++;
          goto _L5
    }
}
