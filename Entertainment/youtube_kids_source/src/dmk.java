// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dmk extends eul
{

    private eam a;
    private eam b[];
    private eam c[];

    public dmk()
    {
        a = null;
        b = eam.a;
        c = eam.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int l;
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
            eam aeam[] = b;
            int i1 = aeam.length;
            int k = 0;
            do
            {
                i = j;
                if (k >= i1)
                {
                    break;
                }
                eam eam1 = aeam[k];
                i = j;
                if (eam1 != null)
                {
                    i = j + euj.b(2, eam1);
                }
                k++;
                j = i;
            } while (true);
        }
        l = i;
        if (c != null)
        {
            eam aeam1[] = c;
            int j1 = aeam1.length;
            j = ((flag) ? 1 : 0);
            do
            {
                l = i;
                if (j >= j1)
                {
                    break;
                }
                eam eam2 = aeam1[j];
                l = i;
                if (eam2 != null)
                {
                    l = i + euj.b(3, eam2);
                }
                j++;
                i = l;
            } while (true);
        }
        i = l + eup.a(O);
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
                    a = new eam();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                int l = eup.a(eui1, 18);
                eam aeam[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                aeam = new eam[l + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, aeam, 0, j);
                }
                for (b = aeam; j < b.length - 1; j++)
                {
                    b[j] = new eam();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new eam();
                eui1.a(b[j]);
                break;

            case 26: // '\032'
                int i1 = eup.a(eui1, 26);
                eam aeam1[];
                int k;
                if (c == null)
                {
                    k = 0;
                } else
                {
                    k = c.length;
                }
                aeam1 = new eam[i1 + k];
                if (c != null)
                {
                    System.arraycopy(c, 0, aeam1, 0, k);
                }
                for (c = aeam1; k < c.length - 1; k++)
                {
                    c[k] = new eam();
                    eui1.a(c[k]);
                    eui1.a();
                }

                c[k] = new eam();
                eui1.a(c[k]);
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
            eam aeam[] = b;
            int k = aeam.length;
            for (int i = 0; i < k; i++)
            {
                eam eam1 = aeam[i];
                if (eam1 != null)
                {
                    euj1.a(2, eam1);
                }
            }

        }
        if (c != null)
        {
            eam aeam1[] = c;
            int l = aeam1.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                eam eam2 = aeam1[j];
                if (eam2 != null)
                {
                    euj1.a(3, eam2);
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
            if (!(obj instanceof dmk))
            {
                return false;
            }
            obj = (dmk)obj;
            if ((a != null ? a.equals(((dmk) (obj)).a) : ((dmk) (obj)).a == null) && (Arrays.equals(b, ((dmk) (obj)).b) && Arrays.equals(c, ((dmk) (obj)).c)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmk) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmk) (obj)).O))
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
