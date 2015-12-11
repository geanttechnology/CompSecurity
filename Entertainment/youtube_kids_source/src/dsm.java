// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dsm extends eul
{

    private dsj a[];
    private dlb b;
    private byte c[];

    public dsm()
    {
        a = dsj.a;
        b = null;
        c = eup.f;
    }

    public final int a()
    {
        int j = 0;
        int i = 0;
        if (a != null)
        {
            dsj adsj[] = a;
            int l = adsj.length;
            int k = 0;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dsj dsj1 = adsj[k];
                j = i;
                if (dsj1 != null)
                {
                    j = i + euj.b(1, dsj1);
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
        j = i;
        if (!Arrays.equals(c, eup.f))
        {
            j = i + euj.b(4, c);
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
                dsj adsj[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adsj = new dsj[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adsj, 0, j);
                }
                for (a = adsj; j < a.length - 1; j++)
                {
                    a[j] = new dsj();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dsj();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 34: // '"'
                c = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            dsj adsj[] = a;
            int j = adsj.length;
            for (int i = 0; i < j; i++)
            {
                dsj dsj1 = adsj[i];
                if (dsj1 != null)
                {
                    euj1.a(1, dsj1);
                }
            }

        }
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(4, c);
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
            if (!(obj instanceof dsm))
            {
                return false;
            }
            obj = (dsm)obj;
            if (Arrays.equals(a, ((dsm) (obj)).a) && (b != null ? b.equals(((dsm) (obj)).b) : ((dsm) (obj)).b == null) && Arrays.equals(c, ((dsm) (obj)).c))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dsm) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dsm) (obj)).O))
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
_L6:
        int j;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        i += k * 31;
        if (c != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L9:
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return j * 31 + i;
_L2:
        j = 0;
_L7:
        k = i;
        if (j >= a.length) goto _L6; else goto _L5
_L5:
        if (a[j] == null)
        {
            k = 0;
        } else
        {
            k = a[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L7
          goto _L6
_L4:
        k = 0;
_L10:
        j = i;
        if (k >= c.length) goto _L9; else goto _L8
_L8:
        i = i * 31 + c[k];
        k++;
          goto _L10
    }
}
