// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dvp extends eul
{

    public dvq a[];
    public byte b[];
    private dlb c;

    public dvp()
    {
        c = null;
        a = dvq.a;
        b = eup.f;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (c != null)
        {
            i = euj.b(1, c) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (a != null)
        {
            dvq advq[] = a;
            int l = advq.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dvq dvq1 = advq[k];
                j = i;
                if (dvq1 != null)
                {
                    j = i + euj.b(2, dvq1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (!Arrays.equals(b, eup.f))
        {
            i = j + euj.b(4, b);
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
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                dvq advq[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                advq = new dvq[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, advq, 0, j);
                }
                for (a = advq; j < a.length - 1; j++)
                {
                    a[j] = new dvq();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dvq();
                eui1.a(a[j]);
                break;

            case 34: // '"'
                b = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (c != null)
        {
            euj1.a(1, c);
        }
        if (a != null)
        {
            dvq advq[] = a;
            int j = advq.length;
            for (int i = 0; i < j; i++)
            {
                dvq dvq1 = advq[i];
                if (dvq1 != null)
                {
                    euj1.a(2, dvq1);
                }
            }

        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(4, b);
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
            if (!(obj instanceof dvp))
            {
                return false;
            }
            obj = (dvp)obj;
            if ((c != null ? c.equals(((dvp) (obj)).c) : ((dvp) (obj)).c == null) && (Arrays.equals(a, ((dvp) (obj)).a) && Arrays.equals(b, ((dvp) (obj)).b)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dvp) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dvp) (obj)).O))
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
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        i += (j + 527) * 31;
        if (a != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L6:
        if (b != null) goto _L4; else goto _L3
_L3:
        i = j * 31;
_L9:
        int k;
        if (O == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = O.hashCode();
        }
        return i * 31 + j;
_L2:
        k = 0;
_L7:
        j = i;
        if (k >= a.length) goto _L6; else goto _L5
_L5:
        if (a[k] == null)
        {
            j = 0;
        } else
        {
            j = a[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L7
          goto _L6
_L4:
        k = 0;
_L10:
        i = j;
        if (k >= b.length) goto _L9; else goto _L8
_L8:
        j = j * 31 + b[k];
        k++;
          goto _L10
    }
}
