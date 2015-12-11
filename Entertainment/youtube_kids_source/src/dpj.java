// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dpj extends eul
{

    private int a;
    private dpr b[];
    private boolean c;
    private dpk d[];

    public dpj()
    {
        a = 0;
        b = dpr.a;
        c = false;
        d = dpk.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int i1;
        if (a != 0)
        {
            i = euj.c(1, a) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (b != null)
        {
            dpr adpr[] = b;
            int j1 = adpr.length;
            int l = 0;
            do
            {
                j = i;
                if (l >= j1)
                {
                    break;
                }
                dpr dpr1 = adpr[l];
                j = i;
                if (dpr1 != null)
                {
                    j = i + euj.b(2, dpr1);
                }
                l++;
                i = j;
            } while (true);
        }
        i = j;
        if (c)
        {
            boolean flag1 = c;
            i = j + (euj.b(3) + 1);
        }
        i1 = i;
        if (d != null)
        {
            dpk adpk[] = d;
            int k1 = adpk.length;
            int k = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (k >= k1)
                {
                    break;
                }
                dpk dpk1 = adpk[k];
                i1 = i;
                if (dpk1 != null)
                {
                    i1 = i + euj.b(4, dpk1);
                }
                k++;
                i = i1;
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

            case 8: // '\b'
                a = eui1.d();
                break;

            case 18: // '\022'
                int l = eup.a(eui1, 18);
                dpr adpr[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adpr = new dpr[l + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adpr, 0, j);
                }
                for (b = adpr; j < b.length - 1; j++)
                {
                    b[j] = new dpr();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dpr();
                eui1.a(b[j]);
                break;

            case 24: // '\030'
                c = eui1.e();
                break;

            case 34: // '"'
                int i1 = eup.a(eui1, 34);
                dpk adpk[];
                int k;
                if (d == null)
                {
                    k = 0;
                } else
                {
                    k = d.length;
                }
                adpk = new dpk[i1 + k];
                if (d != null)
                {
                    System.arraycopy(d, 0, adpk, 0, k);
                }
                for (d = adpk; k < d.length - 1; k++)
                {
                    d[k] = new dpk();
                    eui1.a(d[k]);
                    eui1.a();
                }

                d[k] = new dpk();
                eui1.a(d[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != 0)
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            dpr adpr[] = b;
            int k = adpr.length;
            for (int i = 0; i < k; i++)
            {
                dpr dpr1 = adpr[i];
                if (dpr1 != null)
                {
                    euj1.a(2, dpr1);
                }
            }

        }
        if (c)
        {
            euj1.a(3, c);
        }
        if (d != null)
        {
            dpk adpk[] = d;
            int l = adpk.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                dpk dpk1 = adpk[j];
                if (dpk1 != null)
                {
                    euj1.a(4, dpk1);
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
        if (!(obj instanceof dpj))
        {
            return false;
        }
        obj = (dpj)obj;
        if (a != ((dpj) (obj)).a || !Arrays.equals(b, ((dpj) (obj)).b) || c != ((dpj) (obj)).c || !Arrays.equals(d, ((dpj) (obj)).d))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dpj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dpj) (obj)).O))
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
        i = (getClass().getName().hashCode() + 527) * 31 + a;
        if (b != null) goto _L2; else goto _L1
_L1:
        int l = i * 31;
_L6:
        int j;
        if (c)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        i += l * 31;
        if (d != null) goto _L4; else goto _L3
_L3:
        l = i * 31;
_L9:
        int k;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return l * 31 + i;
_L2:
        j = 0;
_L7:
        l = i;
        if (j >= b.length) goto _L6; else goto _L5
_L5:
        if (b[j] == null)
        {
            l = 0;
        } else
        {
            l = b[j].hashCode();
        }
        i = l + i * 31;
        j++;
          goto _L7
          goto _L6
_L4:
        k = 0;
_L10:
        l = i;
        if (k >= d.length) goto _L9; else goto _L8
_L8:
        if (d[k] == null)
        {
            l = 0;
        } else
        {
            l = d[k].hashCode();
        }
        i = l + i * 31;
        k++;
          goto _L10
    }
}
