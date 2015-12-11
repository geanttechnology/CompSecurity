// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dpd extends eul
{

    public static final dpd a[] = new dpd[0];
    public String b;
    private dls c[];
    private dpe d[];

    public dpd()
    {
        b = "";
        c = dls.a;
        d = dpe.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int l;
        if (!b.equals(""))
        {
            j = euj.b(1, b) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (c != null)
        {
            dls adls[] = c;
            int i1 = adls.length;
            int k = 0;
            do
            {
                i = j;
                if (k >= i1)
                {
                    break;
                }
                dls dls1 = adls[k];
                i = j;
                if (dls1 != null)
                {
                    i = j + euj.b(2, dls1);
                }
                k++;
                j = i;
            } while (true);
        }
        l = i;
        if (d != null)
        {
            dpe adpe[] = d;
            int j1 = adpe.length;
            j = ((flag) ? 1 : 0);
            do
            {
                l = i;
                if (j >= j1)
                {
                    break;
                }
                dpe dpe1 = adpe[j];
                l = i;
                if (dpe1 != null)
                {
                    l = i + euj.b(3, dpe1);
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
                b = eui1.f();
                break;

            case 18: // '\022'
                int l = eup.a(eui1, 18);
                dls adls[];
                int j;
                if (c == null)
                {
                    j = 0;
                } else
                {
                    j = c.length;
                }
                adls = new dls[l + j];
                if (c != null)
                {
                    System.arraycopy(c, 0, adls, 0, j);
                }
                for (c = adls; j < c.length - 1; j++)
                {
                    c[j] = new dls();
                    eui1.a(c[j]);
                    eui1.a();
                }

                c[j] = new dls();
                eui1.a(c[j]);
                break;

            case 26: // '\032'
                int i1 = eup.a(eui1, 26);
                dpe adpe[];
                int k;
                if (d == null)
                {
                    k = 0;
                } else
                {
                    k = d.length;
                }
                adpe = new dpe[i1 + k];
                if (d != null)
                {
                    System.arraycopy(d, 0, adpe, 0, k);
                }
                for (d = adpe; k < d.length - 1; k++)
                {
                    d[k] = new dpe();
                    eui1.a(d[k]);
                    eui1.a();
                }

                d[k] = new dpe();
                eui1.a(d[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!b.equals(""))
        {
            euj1.a(1, b);
        }
        if (c != null)
        {
            dls adls[] = c;
            int k = adls.length;
            for (int i = 0; i < k; i++)
            {
                dls dls1 = adls[i];
                if (dls1 != null)
                {
                    euj1.a(2, dls1);
                }
            }

        }
        if (d != null)
        {
            dpe adpe[] = d;
            int l = adpe.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                dpe dpe1 = adpe[j];
                if (dpe1 != null)
                {
                    euj1.a(3, dpe1);
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
            if (!(obj instanceof dpd))
            {
                return false;
            }
            obj = (dpd)obj;
            if ((b != null ? b.equals(((dpd) (obj)).b) : ((dpd) (obj)).b == null) && (Arrays.equals(c, ((dpd) (obj)).c) && Arrays.equals(d, ((dpd) (obj)).d)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dpd) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dpd) (obj)).O))
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
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        i += (j + 527) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L6:
        if (d != null) goto _L4; else goto _L3
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
        if (k >= c.length) goto _L6; else goto _L5
_L5:
        if (c[k] == null)
        {
            j = 0;
        } else
        {
            j = c[k].hashCode();
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
        if (j >= d.length) goto _L9; else goto _L8
_L8:
        if (d[j] == null)
        {
            k = 0;
        } else
        {
            k = d[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L10
    }

}
