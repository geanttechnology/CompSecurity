// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dyt extends eul
{

    private dlb a;
    private dlb b[];
    private String c;
    private drs d;
    private byte e[];

    public dyt()
    {
        a = null;
        b = dlb.a;
        c = "";
        d = null;
        e = eup.f;
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
            dlb adlb[] = b;
            int l = adlb.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dlb dlb1 = adlb[k];
                j = i;
                if (dlb1 != null)
                {
                    j = i + euj.b(2, dlb1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (!c.equals(""))
        {
            i = j + euj.b(3, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(4, d);
        }
        i = j;
        if (!Arrays.equals(e, eup.f))
        {
            i = j + euj.b(6, e);
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
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                dlb adlb[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adlb = new dlb[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adlb, 0, j);
                }
                for (b = adlb; j < b.length - 1; j++)
                {
                    b[j] = new dlb();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dlb();
                eui1.a(b[j]);
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new drs();
                }
                eui1.a(d);
                break;

            case 50: // '2'
                e = eui1.g();
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
            dlb adlb[] = b;
            int j = adlb.length;
            for (int i = 0; i < j; i++)
            {
                dlb dlb1 = adlb[i];
                if (dlb1 != null)
                {
                    euj1.a(2, dlb1);
                }
            }

        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (!Arrays.equals(e, eup.f))
        {
            euj1.a(6, e);
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
            if (!(obj instanceof dyt))
            {
                return false;
            }
            obj = (dyt)obj;
            if ((a != null ? a.equals(((dyt) (obj)).a) : ((dyt) (obj)).a == null) && Arrays.equals(b, ((dyt) (obj)).b) && (c != null ? c.equals(((dyt) (obj)).c) : ((dyt) (obj)).c == null) && (d != null ? d.equals(((dyt) (obj)).d) : ((dyt) (obj)).d == null) && Arrays.equals(e, ((dyt) (obj)).e))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dyt) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dyt) (obj)).O))
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
        j = i * 31;
_L6:
        int k;
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        i = k + (i + j * 31) * 31;
        if (e != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L9:
        int l;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return j * 31 + i;
_L2:
        k = 0;
_L7:
        j = i;
        if (k >= b.length) goto _L6; else goto _L5
_L5:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L7
          goto _L6
_L4:
        l = 0;
_L10:
        j = i;
        if (l >= e.length) goto _L9; else goto _L8
_L8:
        i = i * 31 + e[l];
        l++;
          goto _L10
    }
}
