// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class edo extends eul
{

    private eam a[];
    private eam b[];

    public edo()
    {
        a = eam.a;
        b = eam.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        if (a != null)
        {
            eam aeam[] = a;
            int j1 = aeam.length;
            int l = 0;
            int j = 0;
            do
            {
                i = j;
                if (l >= j1)
                {
                    break;
                }
                eam eam1 = aeam[l];
                i = j;
                if (eam1 != null)
                {
                    i = j + euj.b(1, eam1);
                }
                l++;
                j = i;
            } while (true);
        } else
        {
            i = 0;
        }
        int i1 = i;
        if (b != null)
        {
            eam aeam1[] = b;
            int k1 = aeam1.length;
            int k = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (k >= k1)
                {
                    break;
                }
                eam eam2 = aeam1[k];
                i1 = i;
                if (eam2 != null)
                {
                    i1 = i + euj.b(2, eam2);
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

            case 10: // '\n'
                int l = eup.a(eui1, 10);
                eam aeam[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                aeam = new eam[l + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, aeam, 0, j);
                }
                for (a = aeam; j < a.length - 1; j++)
                {
                    a[j] = new eam();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new eam();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                int i1 = eup.a(eui1, 18);
                eam aeam1[];
                int k;
                if (b == null)
                {
                    k = 0;
                } else
                {
                    k = b.length;
                }
                aeam1 = new eam[i1 + k];
                if (b != null)
                {
                    System.arraycopy(b, 0, aeam1, 0, k);
                }
                for (b = aeam1; k < b.length - 1; k++)
                {
                    b[k] = new eam();
                    eui1.a(b[k]);
                    eui1.a();
                }

                b[k] = new eam();
                eui1.a(b[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            eam aeam[] = a;
            int k = aeam.length;
            for (int i = 0; i < k; i++)
            {
                eam eam1 = aeam[i];
                if (eam1 != null)
                {
                    euj1.a(1, eam1);
                }
            }

        }
        if (b != null)
        {
            eam aeam1[] = b;
            int l = aeam1.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                eam eam2 = aeam1[j];
                if (eam2 != null)
                {
                    euj1.a(2, eam2);
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
        if (!(obj instanceof edo))
        {
            return false;
        }
        obj = (edo)obj;
        if (!Arrays.equals(a, ((edo) (obj)).a) || !Arrays.equals(b, ((edo) (obj)).b))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((edo) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((edo) (obj)).O))
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
        int j = i * 31;
_L6:
        if (b != null) goto _L4; else goto _L3
_L3:
        int k = j * 31;
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
        i = j;
        j = k;
_L10:
        k = i;
        if (j >= b.length) goto _L9; else goto _L8
_L8:
        if (b[j] == null)
        {
            k = 0;
        } else
        {
            k = b[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L10
    }
}
