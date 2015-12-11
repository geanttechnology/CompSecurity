// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ecu extends eul
{

    public ecv a[];
    private dlb b;
    private byte c[];

    public ecu()
    {
        b = null;
        a = ecv.a;
        c = eup.f;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (b != null)
        {
            i = euj.b(1, b) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (a != null)
        {
            ecv aecv[] = a;
            int l = aecv.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                ecv ecv1 = aecv[k];
                j = i;
                if (ecv1 != null)
                {
                    j = i + euj.b(2, ecv1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (!Arrays.equals(c, eup.f))
        {
            i = j + euj.b(4, c);
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
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                ecv aecv[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                aecv = new ecv[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, aecv, 0, j);
                }
                for (a = aecv; j < a.length - 1; j++)
                {
                    a[j] = new ecv();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new ecv();
                eui1.a(a[j]);
                break;

            case 34: // '"'
                c = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(1, b);
        }
        if (a != null)
        {
            ecv aecv[] = a;
            int j = aecv.length;
            for (int i = 0; i < j; i++)
            {
                ecv ecv1 = aecv[i];
                if (ecv1 != null)
                {
                    euj1.a(2, ecv1);
                }
            }

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
            if (!(obj instanceof ecu))
            {
                return false;
            }
            obj = (ecu)obj;
            if ((b != null ? b.equals(((ecu) (obj)).b) : ((ecu) (obj)).b == null) && (Arrays.equals(a, ((ecu) (obj)).a) && Arrays.equals(c, ((ecu) (obj)).c)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ecu) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ecu) (obj)).O))
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
        if (a != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L6:
        if (c != null) goto _L4; else goto _L3
_L3:
        i = j * 31;
_L9:
        int k;
        if (O == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = O.hashCode();
        }
        return i * 31 + j;
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
        if (k >= c.length) goto _L9; else goto _L8
_L8:
        j = j * 31 + c[k];
        k++;
          goto _L10
    }
}
