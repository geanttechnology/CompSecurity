// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dlg extends eul
{

    public dxi a[];
    public dsb b[];
    private dwa c;
    private String d;
    private dcb e[];

    public dlg()
    {
        c = null;
        a = dxi.a;
        b = dsb.a;
        d = "";
        e = dcb.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int i1;
        if (c != null)
        {
            j = euj.b(1, c) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (a != null)
        {
            dxi adxi[] = a;
            int j1 = adxi.length;
            int k = 0;
            do
            {
                i = j;
                if (k >= j1)
                {
                    break;
                }
                dxi dxi1 = adxi[k];
                i = j;
                if (dxi1 != null)
                {
                    i = j + euj.b(3, dxi1);
                }
                k++;
                j = i;
            } while (true);
        }
        j = i;
        if (b != null)
        {
            dsb adsb[] = b;
            int k1 = adsb.length;
            int l = 0;
            do
            {
                j = i;
                if (l >= k1)
                {
                    break;
                }
                dsb dsb1 = adsb[l];
                j = i;
                if (dsb1 != null)
                {
                    j = i + euj.b(4, dsb1);
                }
                l++;
                i = j;
            } while (true);
        }
        i = j;
        if (!d.equals(""))
        {
            i = j + euj.b(5, d);
        }
        i1 = i;
        if (e != null)
        {
            dcb adcb[] = e;
            int l1 = adcb.length;
            j = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (j >= l1)
                {
                    break;
                }
                dcb dcb1 = adcb[j];
                i1 = i;
                if (dcb1 != null)
                {
                    i1 = i + euj.b(6, dcb1);
                }
                j++;
                i = i1;
            } while (true);
        }
        i = i1 + eup.a(O);
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
                if (c == null)
                {
                    c = new dwa();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                int i1 = eup.a(eui1, 26);
                dxi adxi[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adxi = new dxi[i1 + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adxi, 0, j);
                }
                for (a = adxi; j < a.length - 1; j++)
                {
                    a[j] = new dxi();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dxi();
                eui1.a(a[j]);
                break;

            case 34: // '"'
                int j1 = eup.a(eui1, 34);
                dsb adsb[];
                int k;
                if (b == null)
                {
                    k = 0;
                } else
                {
                    k = b.length;
                }
                adsb = new dsb[j1 + k];
                if (b != null)
                {
                    System.arraycopy(b, 0, adsb, 0, k);
                }
                for (b = adsb; k < b.length - 1; k++)
                {
                    b[k] = new dsb();
                    eui1.a(b[k]);
                    eui1.a();
                }

                b[k] = new dsb();
                eui1.a(b[k]);
                break;

            case 42: // '*'
                d = eui1.f();
                break;

            case 50: // '2'
                int k1 = eup.a(eui1, 50);
                dcb adcb[];
                int l;
                if (e == null)
                {
                    l = 0;
                } else
                {
                    l = e.length;
                }
                adcb = new dcb[k1 + l];
                if (e != null)
                {
                    System.arraycopy(e, 0, adcb, 0, l);
                }
                for (e = adcb; l < e.length - 1; l++)
                {
                    e[l] = new dcb();
                    eui1.a(e[l]);
                    eui1.a();
                }

                e[l] = new dcb();
                eui1.a(e[l]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (c != null)
        {
            euj1.a(1, c);
        }
        if (a != null)
        {
            dxi adxi[] = a;
            int l = adxi.length;
            for (int i = 0; i < l; i++)
            {
                dxi dxi1 = adxi[i];
                if (dxi1 != null)
                {
                    euj1.a(3, dxi1);
                }
            }

        }
        if (b != null)
        {
            dsb adsb[] = b;
            int i1 = adsb.length;
            for (int j = 0; j < i1; j++)
            {
                dsb dsb1 = adsb[j];
                if (dsb1 != null)
                {
                    euj1.a(4, dsb1);
                }
            }

        }
        if (!d.equals(""))
        {
            euj1.a(5, d);
        }
        if (e != null)
        {
            dcb adcb[] = e;
            int j1 = adcb.length;
            for (int k = ((flag) ? 1 : 0); k < j1; k++)
            {
                dcb dcb1 = adcb[k];
                if (dcb1 != null)
                {
                    euj1.a(6, dcb1);
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
            if (!(obj instanceof dlg))
            {
                return false;
            }
            obj = (dlg)obj;
            if ((c != null ? c.equals(((dlg) (obj)).c) : ((dlg) (obj)).c == null) && (Arrays.equals(a, ((dlg) (obj)).a) && Arrays.equals(b, ((dlg) (obj)).b)) && (d != null ? d.equals(((dlg) (obj)).d) : ((dlg) (obj)).d == null) && Arrays.equals(e, ((dlg) (obj)).e))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dlg) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dlg) (obj)).O))
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
        int k;
        boolean flag = false;
        j = getClass().getName().hashCode();
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        i += (j + 527) * 31;
        if (a != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L8:
        if (b != null) goto _L4; else goto _L3
_L3:
        k = j * 31;
_L11:
        if (d == null)
        {
            i = 0;
        } else
        {
            i = d.hashCode();
        }
        i += k * 31;
        if (e != null) goto _L6; else goto _L5
_L5:
        k = i * 31;
_L14:
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return k * 31 + i;
_L2:
        k = 0;
_L9:
        j = i;
        if (k >= a.length) goto _L8; else goto _L7
_L7:
        if (a[k] == null)
        {
            j = 0;
        } else
        {
            j = a[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L9
          goto _L8
_L4:
        k = 0;
        i = j;
        j = k;
_L12:
        k = i;
        if (j >= b.length) goto _L11; else goto _L10
_L10:
        if (b[j] == null)
        {
            k = 0;
        } else
        {
            k = b[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L12
          goto _L11
_L6:
        j = 0;
_L15:
        k = i;
        if (j >= e.length) goto _L14; else goto _L13
_L13:
        if (e[j] == null)
        {
            k = 0;
        } else
        {
            k = e[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L15
    }
}
