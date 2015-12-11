// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dno extends eul
{

    public dnl a;
    public dnp b[];
    public long c;

    public dno()
    {
        a = null;
        b = dnp.a;
        c = 0L;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (a != null)
        {
            i = euj.b(1, a) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (b != null)
        {
            dnp adnp[] = b;
            int l = adnp.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dnp dnp1 = adnp[k];
                j = i;
                if (dnp1 != null)
                {
                    j = i + euj.b(2, dnp1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (c != 0L)
        {
            i = j + euj.c(3, c);
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
                if (a == null)
                {
                    a = new dnl();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                dnp adnp[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adnp = new dnp[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adnp, 0, j);
                }
                for (b = adnp; j < b.length - 1; j++)
                {
                    b[j] = new dnp();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dnp();
                eui1.a(b[j]);
                break;

            case 24: // '\030'
                c = eui1.b();
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
            dnp adnp[] = b;
            int j = adnp.length;
            for (int i = 0; i < j; i++)
            {
                dnp dnp1 = adnp[i];
                if (dnp1 != null)
                {
                    euj1.a(2, dnp1);
                }
            }

        }
        if (c != 0L)
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
            if (!(obj instanceof dno))
            {
                return false;
            }
            obj = (dno)obj;
            if ((a != null ? a.equals(((dno) (obj)).a) : ((dno) (obj)).a == null) && (Arrays.equals(b, ((dno) (obj)).b) && c == ((dno) (obj)).c))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dno) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dno) (obj)).O))
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
        j = (int)(c ^ c >>> 32);
        int k;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return (l * 31 + j) * 31 + i;
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
