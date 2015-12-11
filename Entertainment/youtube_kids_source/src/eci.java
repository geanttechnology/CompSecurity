// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class eci extends eul
{

    private ecj a;
    private ecg b[];

    public eci()
    {
        a = null;
        b = ecg.a;
    }

    public final int a()
    {
        int j = 0;
        int i;
        int k;
        if (a != null)
        {
            i = euj.b(1, a) + 0;
        } else
        {
            i = 0;
        }
        k = i;
        if (b != null)
        {
            ecg aecg[] = b;
            int l = aecg.length;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                ecg ecg1 = aecg[j];
                k = i;
                if (ecg1 != null)
                {
                    k = i + euj.b(2, ecg1);
                }
                j++;
                i = k;
            } while (true);
        }
        i = k + eup.a(O);
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
                    a = new ecj();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                ecg aecg[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                aecg = new ecg[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, aecg, 0, j);
                }
                for (b = aecg; j < b.length - 1; j++)
                {
                    b[j] = new ecg();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new ecg();
                eui1.a(b[j]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            ecg aecg[] = b;
            int j = aecg.length;
            for (int i = 0; i < j; i++)
            {
                ecg ecg1 = aecg[i];
                if (ecg1 != null)
                {
                    euj1.a(2, ecg1);
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
            if (!(obj instanceof eci))
            {
                return false;
            }
            obj = (eci)obj;
            if ((a != null ? a.equals(((eci) (obj)).a) : ((eci) (obj)).a == null) && Arrays.equals(b, ((eci) (obj)).b))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((eci) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((eci) (obj)).O))
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
        boolean flag = false;
        int j = getClass().getName().hashCode();
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
        l = i * 31;
_L4:
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
        k = 0;
_L5:
        l = i;
        if (k >= b.length) goto _L4; else goto _L3
_L3:
        if (b[k] == null)
        {
            l = 0;
        } else
        {
            l = b[k].hashCode();
        }
        i = l + i * 31;
        k++;
          goto _L5
    }
}
