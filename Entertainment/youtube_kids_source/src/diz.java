// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class diz extends eul
{

    private dja a[];
    private dre b;
    private dlb c;

    public diz()
    {
        a = dja.a;
        b = null;
        c = null;
    }

    public final int a()
    {
        int j = 0;
        int i = 0;
        if (a != null)
        {
            dja adja[] = a;
            int l = adja.length;
            int k = 0;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dja dja1 = adja[k];
                j = i;
                if (dja1 != null)
                {
                    j = i + euj.b(1, dja1);
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
                int k = eup.a(eui1, 10);
                dja adja[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adja = new dja[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adja, 0, j);
                }
                for (a = adja; j < a.length - 1; j++)
                {
                    a[j] = new dja();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dja();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dre();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            dja adja[] = a;
            int j = adja.length;
            for (int i = 0; i < j; i++)
            {
                dja dja1 = adja[i];
                if (dja1 != null)
                {
                    euj1.a(1, dja1);
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
            if (!(obj instanceof diz))
            {
                return false;
            }
            obj = (diz)obj;
            if (Arrays.equals(a, ((diz) (obj)).a) && (b != null ? b.equals(((diz) (obj)).b) : ((diz) (obj)).b == null) && (c != null ? c.equals(((diz) (obj)).c) : ((diz) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((diz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((diz) (obj)).O))
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
