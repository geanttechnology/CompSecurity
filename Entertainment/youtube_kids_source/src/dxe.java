// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dxe extends eul
{

    private dwa a;
    private String b;
    private String c;
    private dcb d[];

    public dxe()
    {
        a = null;
        b = "";
        c = "";
        d = dcb.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int l;
        if (a != null)
        {
            i = euj.b(1, a) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (!b.equals(""))
        {
            j = i + euj.b(2, b);
        }
        i = j;
        if (!c.equals(""))
        {
            i = j + euj.b(7, c);
        }
        l = i;
        if (d != null)
        {
            dcb adcb[] = d;
            int i1 = adcb.length;
            int k = ((flag) ? 1 : 0);
            do
            {
                l = i;
                if (k >= i1)
                {
                    break;
                }
                dcb dcb1 = adcb[k];
                l = i;
                if (dcb1 != null)
                {
                    l = i + euj.b(8, dcb1);
                }
                k++;
                i = l;
            } while (true);
        }
        i = l + eup.a(O);
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
                    a = new dwa();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 58: // ':'
                c = eui1.f();
                break;

            case 66: // 'B'
                int k = eup.a(eui1, 66);
                dcb adcb[];
                int j;
                if (d == null)
                {
                    j = 0;
                } else
                {
                    j = d.length;
                }
                adcb = new dcb[k + j];
                if (d != null)
                {
                    System.arraycopy(d, 0, adcb, 0, j);
                }
                for (d = adcb; j < d.length - 1; j++)
                {
                    d[j] = new dcb();
                    eui1.a(d[j]);
                    eui1.a();
                }

                d[j] = new dcb();
                eui1.a(d[j]);
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
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (!c.equals(""))
        {
            euj1.a(7, c);
        }
        if (d != null)
        {
            dcb adcb[] = d;
            int j = adcb.length;
            for (int i = 0; i < j; i++)
            {
                dcb dcb1 = adcb[i];
                if (dcb1 != null)
                {
                    euj1.a(8, dcb1);
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
            if (!(obj instanceof dxe))
            {
                return false;
            }
            obj = (dxe)obj;
            if ((a != null ? a.equals(((dxe) (obj)).a) : ((dxe) (obj)).a == null) && (b != null ? b.equals(((dxe) (obj)).b) : ((dxe) (obj)).b == null) && (c != null ? c.equals(((dxe) (obj)).c) : ((dxe) (obj)).c == null) && Arrays.equals(d, ((dxe) (obj)).d))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dxe) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dxe) (obj)).O))
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
        int i1 = getClass().getName().hashCode();
        int j;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b == null)
        {
            j = 0;
        } else
        {
            j = b.hashCode();
        }
        if (c == null)
        {
            l = 0;
        } else
        {
            l = c.hashCode();
        }
        i = l + (j + (i + (i1 + 527) * 31) * 31) * 31;
        if (d != null) goto _L2; else goto _L1
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
        if (k >= d.length) goto _L4; else goto _L3
_L3:
        if (d[k] == null)
        {
            l = 0;
        } else
        {
            l = d[k].hashCode();
        }
        i = l + i * 31;
        k++;
          goto _L5
    }
}
