// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dga extends eul
{

    public dgb a[];
    public byte b[];
    public dwk c;
    private dlb d;

    public dga()
    {
        d = null;
        a = dgb.a;
        b = eup.f;
        c = null;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (d != null)
        {
            i = euj.b(1, d) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (a != null)
        {
            dgb adgb[] = a;
            int l = adgb.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dgb dgb1 = adgb[k];
                j = i;
                if (dgb1 != null)
                {
                    j = i + euj.b(2, dgb1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (!Arrays.equals(b, eup.f))
        {
            i = j + euj.b(4, b);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(5, c);
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
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                dgb adgb[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adgb = new dgb[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adgb, 0, j);
                }
                for (a = adgb; j < a.length - 1; j++)
                {
                    a[j] = new dgb();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dgb();
                eui1.a(a[j]);
                break;

            case 34: // '"'
                b = eui1.g();
                break;

            case 42: // '*'
                if (c == null)
                {
                    c = new dwk();
                }
                eui1.a(c);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (d != null)
        {
            euj1.a(1, d);
        }
        if (a != null)
        {
            dgb adgb[] = a;
            int j = adgb.length;
            for (int i = 0; i < j; i++)
            {
                dgb dgb1 = adgb[i];
                if (dgb1 != null)
                {
                    euj1.a(2, dgb1);
                }
            }

        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(4, b);
        }
        if (c != null)
        {
            euj1.a(5, c);
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
            if (!(obj instanceof dga))
            {
                return false;
            }
            obj = (dga)obj;
            if ((d != null ? d.equals(((dga) (obj)).d) : ((dga) (obj)).d == null) && (Arrays.equals(a, ((dga) (obj)).a) && Arrays.equals(b, ((dga) (obj)).b)) && (c != null ? c.equals(((dga) (obj)).c) : ((dga) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dga) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dga) (obj)).O))
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
        if (d == null)
        {
            i = 0;
        } else
        {
            i = d.hashCode();
        }
        i += (j + 527) * 31;
        if (a != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
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
