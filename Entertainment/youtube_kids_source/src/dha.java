// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dha extends eul
{

    private dhe a[];
    private dhd b;
    private dhb c;
    private dhc d;

    public dha()
    {
        a = dhe.a;
        b = null;
        c = null;
        d = null;
    }

    public final int a()
    {
        int j = 0;
        int i = 0;
        if (a != null)
        {
            dhe adhe[] = a;
            int l = adhe.length;
            int k = 0;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dhe dhe1 = adhe[k];
                j = i;
                if (dhe1 != null)
                {
                    j = i + euj.b(1, dhe1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (b != null)
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(3, c);
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
                int k = eup.a(eui1, 10);
                dhe adhe[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adhe = new dhe[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adhe, 0, j);
                }
                for (a = adhe; j < a.length - 1; j++)
                {
                    a[j] = new dhe();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dhe();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dhd();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dhb();
                }
                eui1.a(c);
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dhc();
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
            dhe adhe[] = a;
            int j = adhe.length;
            for (int i = 0; i < j; i++)
            {
                dhe dhe1 = adhe[i];
                if (dhe1 != null)
                {
                    euj1.a(1, dhe1);
                }
            }

        }
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            euj1.a(3, c);
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
            if (!(obj instanceof dha))
            {
                return false;
            }
            obj = (dha)obj;
            if (Arrays.equals(a, ((dha) (obj)).a) && (b != null ? b.equals(((dha) (obj)).b) : ((dha) (obj)).b == null) && (c != null ? c.equals(((dha) (obj)).c) : ((dha) (obj)).c == null) && (d != null ? d.equals(((dha) (obj)).d) : ((dha) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dha) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dha) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        int i1;
        i1 = 0;
        i = getClass().getName().hashCode() + 527;
        if (a != null) goto _L2; else goto _L1
_L1:
        int j = i * 31;
_L4:
        int k;
        int l;
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
        if (d == null)
        {
            l = 0;
        } else
        {
            l = d.hashCode();
        }
        if (O != null)
        {
            i1 = O.hashCode();
        }
        return (l + (k + (i + j * 31) * 31) * 31) * 31 + i1;
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
