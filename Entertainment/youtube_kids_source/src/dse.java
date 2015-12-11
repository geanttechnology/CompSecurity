// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dse extends eul
{

    private boolean a;
    private dsg b;
    private dsf c[];
    private byte d[];

    public dse()
    {
        a = false;
        b = null;
        c = dsf.a;
        d = eup.f;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (a)
        {
            boolean flag = a;
            j = euj.b(1) + 1 + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (b != null)
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (c != null)
        {
            dsf adsf[] = c;
            int l = adsf.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dsf dsf1 = adsf[k];
                j = i;
                if (dsf1 != null)
                {
                    j = i + euj.b(3, dsf1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (!Arrays.equals(d, eup.f))
        {
            i = j + euj.b(4, d);
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

            case 8: // '\b'
                a = eui1.e();
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dsg();
                }
                eui1.a(b);
                break;

            case 26: // '\032'
                int k = eup.a(eui1, 26);
                dsf adsf[];
                int j;
                if (c == null)
                {
                    j = 0;
                } else
                {
                    j = c.length;
                }
                adsf = new dsf[k + j];
                if (c != null)
                {
                    System.arraycopy(c, 0, adsf, 0, j);
                }
                for (c = adsf; j < c.length - 1; j++)
                {
                    c[j] = new dsf();
                    eui1.a(c[j]);
                    eui1.a();
                }

                c[j] = new dsf();
                eui1.a(c[j]);
                break;

            case 34: // '"'
                d = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a)
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            dsf adsf[] = c;
            int j = adsf.length;
            for (int i = 0; i < j; i++)
            {
                dsf dsf1 = adsf[i];
                if (dsf1 != null)
                {
                    euj1.a(3, dsf1);
                }
            }

        }
        if (!Arrays.equals(d, eup.f))
        {
            euj1.a(4, d);
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
            if (!(obj instanceof dse))
            {
                return false;
            }
            obj = (dse)obj;
            if (a == ((dse) (obj)).a && (b != null ? b.equals(((dse) (obj)).b) : ((dse) (obj)).b == null) && (Arrays.equals(c, ((dse) (obj)).c) && Arrays.equals(d, ((dse) (obj)).d)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dse) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dse) (obj)).O))
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
        int k = getClass().getName().hashCode();
        if (a)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        i = j + (i + (k + 527) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L6:
        if (d != null) goto _L4; else goto _L3
_L3:
        i = j * 31;
_L9:
        int l;
        if (O == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = O.hashCode();
        }
        return i * 31 + j;
_L2:
        l = 0;
_L7:
        j = i;
        if (l >= c.length) goto _L6; else goto _L5
_L5:
        if (c[l] == null)
        {
            j = 0;
        } else
        {
            j = c[l].hashCode();
        }
        i = j + i * 31;
        l++;
          goto _L7
          goto _L6
_L4:
        l = 0;
_L10:
        i = j;
        if (l >= d.length) goto _L9; else goto _L8
_L8:
        j = j * 31 + d[l];
        l++;
          goto _L10
    }
}
