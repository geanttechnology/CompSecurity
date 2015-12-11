// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dks extends eul
{

    private dlb a;
    private dqc b[];
    private dqc c[];
    private dxa d[];

    public dks()
    {
        a = null;
        b = dqc.a;
        c = dqc.a;
        d = dxa.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int i1;
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
            dqc adqc[] = b;
            int j1 = adqc.length;
            int k = 0;
            do
            {
                i = j;
                if (k >= j1)
                {
                    break;
                }
                dqc dqc1 = adqc[k];
                i = j;
                if (dqc1 != null)
                {
                    i = j + euj.b(2, dqc1);
                }
                k++;
                j = i;
            } while (true);
        }
        j = i;
        if (c != null)
        {
            dqc adqc1[] = c;
            int k1 = adqc1.length;
            int l = 0;
            do
            {
                j = i;
                if (l >= k1)
                {
                    break;
                }
                dqc dqc2 = adqc1[l];
                j = i;
                if (dqc2 != null)
                {
                    j = i + euj.b(3, dqc2);
                }
                l++;
                i = j;
            } while (true);
        }
        i1 = j;
        if (d != null)
        {
            dxa adxa[] = d;
            int l1 = adxa.length;
            i = ((flag) ? 1 : 0);
            do
            {
                i1 = j;
                if (i >= l1)
                {
                    break;
                }
                dxa dxa1 = adxa[i];
                i1 = j;
                if (dxa1 != null)
                {
                    i1 = j + euj.b(4, dxa1);
                }
                i++;
                j = i1;
            } while (true);
        }
        i = i1 + eup.a(O);
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
                int i1 = eup.a(eui1, 18);
                dqc adqc[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adqc = new dqc[i1 + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adqc, 0, j);
                }
                for (b = adqc; j < b.length - 1; j++)
                {
                    b[j] = new dqc();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dqc();
                eui1.a(b[j]);
                break;

            case 26: // '\032'
                int j1 = eup.a(eui1, 26);
                dqc adqc1[];
                int k;
                if (c == null)
                {
                    k = 0;
                } else
                {
                    k = c.length;
                }
                adqc1 = new dqc[j1 + k];
                if (c != null)
                {
                    System.arraycopy(c, 0, adqc1, 0, k);
                }
                for (c = adqc1; k < c.length - 1; k++)
                {
                    c[k] = new dqc();
                    eui1.a(c[k]);
                    eui1.a();
                }

                c[k] = new dqc();
                eui1.a(c[k]);
                break;

            case 34: // '"'
                int k1 = eup.a(eui1, 34);
                dxa adxa[];
                int l;
                if (d == null)
                {
                    l = 0;
                } else
                {
                    l = d.length;
                }
                adxa = new dxa[k1 + l];
                if (d != null)
                {
                    System.arraycopy(d, 0, adxa, 0, l);
                }
                for (d = adxa; l < d.length - 1; l++)
                {
                    d[l] = new dxa();
                    eui1.a(d[l]);
                    eui1.a();
                }

                d[l] = new dxa();
                eui1.a(d[l]);
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
            dqc adqc[] = b;
            int l = adqc.length;
            for (int i = 0; i < l; i++)
            {
                dqc dqc1 = adqc[i];
                if (dqc1 != null)
                {
                    euj1.a(2, dqc1);
                }
            }

        }
        if (c != null)
        {
            dqc adqc1[] = c;
            int i1 = adqc1.length;
            for (int j = 0; j < i1; j++)
            {
                dqc dqc2 = adqc1[j];
                if (dqc2 != null)
                {
                    euj1.a(3, dqc2);
                }
            }

        }
        if (d != null)
        {
            dxa adxa[] = d;
            int j1 = adxa.length;
            for (int k = ((flag) ? 1 : 0); k < j1; k++)
            {
                dxa dxa1 = adxa[k];
                if (dxa1 != null)
                {
                    euj1.a(4, dxa1);
                }
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
            if (!(obj instanceof dks))
            {
                return false;
            }
            obj = (dks)obj;
            if ((a != null ? a.equals(((dks) (obj)).a) : ((dks) (obj)).a == null) && (Arrays.equals(b, ((dks) (obj)).b) && Arrays.equals(c, ((dks) (obj)).c) && Arrays.equals(d, ((dks) (obj)).d)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dks) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dks) (obj)).O))
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
_L8:
        if (c != null) goto _L4; else goto _L3
_L3:
        j *= 31;
_L11:
        if (d != null) goto _L6; else goto _L5
_L5:
        k = j * 31;
_L14:
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
_L9:
        j = i;
        if (k >= b.length) goto _L8; else goto _L7
_L7:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L9
          goto _L8
_L4:
        k = 0;
        i = j;
_L12:
        j = i;
        if (k >= c.length) goto _L11; else goto _L10
_L10:
        if (c[k] == null)
        {
            j = 0;
        } else
        {
            j = c[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L12
          goto _L11
_L6:
        k = 0;
        i = j;
        j = k;
_L15:
        k = i;
        if (j >= d.length) goto _L14; else goto _L13
_L13:
        if (d[j] == null)
        {
            k = 0;
        } else
        {
            k = d[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L15
    }
}
