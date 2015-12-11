// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dfg extends eul
{

    public dfh a[];
    public dfh b[];
    private dlb c;
    private int d;
    private dfh e[];

    public dfg()
    {
        a = dfh.a;
        c = null;
        d = 0;
        b = dfh.a;
        e = dfh.a;
    }

    public final int a()
    {
        boolean flag = false;
        int k;
        if (a != null)
        {
            dfh adfh[] = a;
            int l1 = adfh.length;
            int i1 = 0;
            int i = 0;
            do
            {
                k = i;
                if (i1 >= l1)
                {
                    break;
                }
                dfh dfh1 = adfh[i1];
                k = i;
                if (dfh1 != null)
                {
                    k = i + euj.b(1, dfh1);
                }
                i1++;
                i = k;
            } while (true);
        } else
        {
            k = 0;
        }
        int j = k;
        if (c != null)
        {
            j = k + euj.b(2, c);
        }
        k = j;
        if (d != 0)
        {
            k = j + euj.c(3, d);
        }
        j = k;
        if (b != null)
        {
            dfh adfh1[] = b;
            int i2 = adfh1.length;
            int j1 = 0;
            do
            {
                j = k;
                if (j1 >= i2)
                {
                    break;
                }
                dfh dfh2 = adfh1[j1];
                j = k;
                if (dfh2 != null)
                {
                    j = k + euj.b(4, dfh2);
                }
                j1++;
                k = j;
            } while (true);
        }
        int k1 = j;
        if (e != null)
        {
            dfh adfh2[] = e;
            int j2 = adfh2.length;
            int l = ((flag) ? 1 : 0);
            do
            {
                k1 = j;
                if (l >= j2)
                {
                    break;
                }
                dfh dfh3 = adfh2[l];
                k1 = j;
                if (dfh3 != null)
                {
                    k1 = j + euj.b(6, dfh3);
                }
                l++;
                j = k1;
            } while (true);
        }
        j = k1 + eup.a(O);
        P = j;
        return j;
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
                int i1 = eup.a(eui1, 10);
                dfh adfh[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adfh = new dfh[i1 + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adfh, 0, j);
                }
                for (a = adfh; j < a.length - 1; j++)
                {
                    a[j] = new dfh();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dfh();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 24: // '\030'
                d = eui1.d();
                break;

            case 34: // '"'
                int j1 = eup.a(eui1, 34);
                dfh adfh1[];
                int k;
                if (b == null)
                {
                    k = 0;
                } else
                {
                    k = b.length;
                }
                adfh1 = new dfh[j1 + k];
                if (b != null)
                {
                    System.arraycopy(b, 0, adfh1, 0, k);
                }
                for (b = adfh1; k < b.length - 1; k++)
                {
                    b[k] = new dfh();
                    eui1.a(b[k]);
                    eui1.a();
                }

                b[k] = new dfh();
                eui1.a(b[k]);
                break;

            case 50: // '2'
                int k1 = eup.a(eui1, 50);
                dfh adfh2[];
                int l;
                if (e == null)
                {
                    l = 0;
                } else
                {
                    l = e.length;
                }
                adfh2 = new dfh[k1 + l];
                if (e != null)
                {
                    System.arraycopy(e, 0, adfh2, 0, l);
                }
                for (e = adfh2; l < e.length - 1; l++)
                {
                    e[l] = new dfh();
                    eui1.a(e[l]);
                    eui1.a();
                }

                e[l] = new dfh();
                eui1.a(e[l]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            dfh adfh[] = a;
            int l = adfh.length;
            for (int i = 0; i < l; i++)
            {
                dfh dfh1 = adfh[i];
                if (dfh1 != null)
                {
                    euj1.a(1, dfh1);
                }
            }

        }
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (d != 0)
        {
            euj1.a(3, d);
        }
        if (b != null)
        {
            dfh adfh1[] = b;
            int i1 = adfh1.length;
            for (int j = 0; j < i1; j++)
            {
                dfh dfh2 = adfh1[j];
                if (dfh2 != null)
                {
                    euj1.a(4, dfh2);
                }
            }

        }
        if (e != null)
        {
            dfh adfh2[] = e;
            int j1 = adfh2.length;
            for (int k = ((flag) ? 1 : 0); k < j1; k++)
            {
                dfh dfh3 = adfh2[k];
                if (dfh3 != null)
                {
                    euj1.a(6, dfh3);
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
            if (!(obj instanceof dfg))
            {
                return false;
            }
            obj = (dfg)obj;
            if (Arrays.equals(a, ((dfg) (obj)).a) && (c != null ? c.equals(((dfg) (obj)).c) : ((dfg) (obj)).c == null) && (d == ((dfg) (obj)).d && Arrays.equals(b, ((dfg) (obj)).b) && Arrays.equals(e, ((dfg) (obj)).e)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dfg) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dfg) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        boolean flag;
        flag = false;
        i = getClass().getName().hashCode() + 527;
        if (a != null) goto _L2; else goto _L1
_L1:
        int k = i * 31;
_L8:
        int j;
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        i = (i + k * 31) * 31 + d;
        if (b != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L11:
        if (e != null) goto _L6; else goto _L5
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
        j = 0;
_L9:
        k = i;
        if (j >= a.length) goto _L8; else goto _L7
_L7:
        if (a[j] == null)
        {
            k = 0;
        } else
        {
            k = a[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L9
          goto _L8
_L4:
        k = 0;
_L12:
        j = i;
        if (k >= b.length) goto _L11; else goto _L10
_L10:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
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
        if (j >= e.length) goto _L14; else goto _L13
_L13:
        if (e[j] == null)
        {
            k = 0;
        } else
        {
            k = e[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L15
    }
}
