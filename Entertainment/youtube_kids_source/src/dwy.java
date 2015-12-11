// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dwy extends eul
{

    private dcd a[];
    private byte b[];
    private dre c;

    public dwy()
    {
        a = dcd.a;
        b = eup.f;
        c = null;
    }

    public final int a()
    {
        int j = 0;
        int i = 0;
        if (a != null)
        {
            dcd adcd[] = a;
            int l = adcd.length;
            int k = 0;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dcd dcd1 = adcd[k];
                j = i;
                if (dcd1 != null)
                {
                    j = i + euj.b(1, dcd1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (!Arrays.equals(b, eup.f))
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
                dcd adcd[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adcd = new dcd[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adcd, 0, j);
                }
                for (a = adcd; j < a.length - 1; j++)
                {
                    a[j] = new dcd();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dcd();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                b = eui1.g();
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dre();
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
            dcd adcd[] = a;
            int j = adcd.length;
            for (int i = 0; i < j; i++)
            {
                dcd dcd1 = adcd[i];
                if (dcd1 != null)
                {
                    euj1.a(1, dcd1);
                }
            }

        }
        if (!Arrays.equals(b, eup.f))
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
            if (!(obj instanceof dwy))
            {
                return false;
            }
            obj = (dwy)obj;
            if (Arrays.equals(a, ((dwy) (obj)).a) && Arrays.equals(b, ((dwy) (obj)).b) && (c != null ? c.equals(((dwy) (obj)).c) : ((dwy) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dwy) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dwy) (obj)).O))
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
        i = j * 31;
_L9:
        int k;
        if (c == null)
        {
            j = 0;
        } else
        {
            j = c.hashCode();
        }
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return (j + i * 31) * 31 + k;
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
