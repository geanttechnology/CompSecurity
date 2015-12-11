// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dly extends eul
{

    public dlz a[];
    private dlb b;
    private byte c[];
    private int d;
    private int e;
    private dre f;

    public dly()
    {
        a = dlz.a;
        b = null;
        c = eup.f;
        d = 0;
        e = 0;
        f = null;
    }

    public final int a()
    {
        int j = 0;
        int i = 0;
        if (a != null)
        {
            dlz adlz[] = a;
            int l = adlz.length;
            int k = 0;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dlz dlz1 = adlz[k];
                j = i;
                if (dlz1 != null)
                {
                    j = i + euj.b(1, dlz1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (b != null)
        {
            i = j + euj.b(3, b);
        }
        j = i;
        if (!Arrays.equals(c, eup.f))
        {
            j = i + euj.b(4, c);
        }
        i = j;
        if (d != 0)
        {
            i = j + euj.c(6, d);
        }
        j = i;
        if (e != 0)
        {
            j = i + euj.c(7, e);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(8, f);
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
                dlz adlz[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adlz = new dlz[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adlz, 0, j);
                }
                for (a = adlz; j < a.length - 1; j++)
                {
                    a[j] = new dlz();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dlz();
                eui1.a(a[j]);
                break;

            case 26: // '\032'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 34: // '"'
                c = eui1.g();
                break;

            case 48: // '0'
                d = eui1.d();
                break;

            case 56: // '8'
                e = eui1.d();
                break;

            case 66: // 'B'
                if (f == null)
                {
                    f = new dre();
                }
                eui1.a(f);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            dlz adlz[] = a;
            int j = adlz.length;
            for (int i = 0; i < j; i++)
            {
                dlz dlz1 = adlz[i];
                if (dlz1 != null)
                {
                    euj1.a(1, dlz1);
                }
            }

        }
        if (b != null)
        {
            euj1.a(3, b);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(4, c);
        }
        if (d != 0)
        {
            euj1.a(6, d);
        }
        if (e != 0)
        {
            euj1.a(7, e);
        }
        if (f != null)
        {
            euj1.a(8, f);
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
            if (!(obj instanceof dly))
            {
                return false;
            }
            obj = (dly)obj;
            if (Arrays.equals(a, ((dly) (obj)).a) && (b != null ? b.equals(((dly) (obj)).b) : ((dly) (obj)).b == null) && (Arrays.equals(c, ((dly) (obj)).c) && d == ((dly) (obj)).d && e == ((dly) (obj)).e) && (f != null ? f.equals(((dly) (obj)).f) : ((dly) (obj)).f == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dly) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dly) (obj)).O))
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
        int l;
        int i1;
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
        l = d;
        i1 = e;
        if (f == null)
        {
            i = 0;
        } else
        {
            i = f.hashCode();
        }
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return (i + ((j * 31 + l) * 31 + i1) * 31) * 31 + k;
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
