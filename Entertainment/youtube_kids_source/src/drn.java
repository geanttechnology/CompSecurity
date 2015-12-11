// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class drn extends eul
{

    private drp a[];
    private dro b;

    public drn()
    {
        a = drp.a;
        b = null;
    }

    public final int a()
    {
        int j = 0;
        int i = 0;
        if (a != null)
        {
            drp adrp[] = a;
            int l = adrp.length;
            int k = 0;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                drp drp1 = adrp[k];
                j = i;
                if (drp1 != null)
                {
                    j = i + euj.b(1, drp1);
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
                int k = eup.a(eui1, 10);
                drp adrp[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adrp = new drp[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adrp, 0, j);
                }
                for (a = adrp; j < a.length - 1; j++)
                {
                    a[j] = new drp();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new drp();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dro();
                }
                eui1.a(b);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            drp adrp[] = a;
            int j = adrp.length;
            for (int i = 0; i < j; i++)
            {
                drp drp1 = adrp[i];
                if (drp1 != null)
                {
                    euj1.a(1, drp1);
                }
            }

        }
        if (b != null)
        {
            euj1.a(2, b);
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
            if (!(obj instanceof drn))
            {
                return false;
            }
            obj = (drn)obj;
            if (Arrays.equals(a, ((drn) (obj)).a) && (b != null ? b.equals(((drn) (obj)).b) : ((drn) (obj)).b == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((drn) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((drn) (obj)).O))
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
_L4:
        int k;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return (i + j * 31) * 31 + k;
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
