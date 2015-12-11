// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class drk extends eul
{

    public static final drk a[] = new drk[0];
    public drd b;
    public String c;
    private dex d[];
    private drk e[];

    public drk()
    {
        b = null;
        d = dex.a;
        c = "";
        e = a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int i1;
        if (b != null)
        {
            i = euj.b(1, b) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (d != null)
        {
            dex adex[] = d;
            int j1 = adex.length;
            int l = 0;
            do
            {
                j = i;
                if (l >= j1)
                {
                    break;
                }
                dex dex1 = adex[l];
                j = i;
                if (dex1 != null)
                {
                    j = i + euj.b(2, dex1);
                }
                l++;
                i = j;
            } while (true);
        }
        i = j;
        if (!c.equals(""))
        {
            i = j + euj.b(3, c);
        }
        i1 = i;
        if (e != null)
        {
            drk adrk[] = e;
            int k1 = adrk.length;
            int k = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (k >= k1)
                {
                    break;
                }
                drk drk1 = adrk[k];
                i1 = i;
                if (drk1 != null)
                {
                    i1 = i + euj.b(4, drk1);
                }
                k++;
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
                if (b == null)
                {
                    b = new drd();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                int l = eup.a(eui1, 18);
                dex adex[];
                int j;
                if (d == null)
                {
                    j = 0;
                } else
                {
                    j = d.length;
                }
                adex = new dex[l + j];
                if (d != null)
                {
                    System.arraycopy(d, 0, adex, 0, j);
                }
                for (d = adex; j < d.length - 1; j++)
                {
                    d[j] = new dex();
                    eui1.a(d[j]);
                    eui1.a();
                }

                d[j] = new dex();
                eui1.a(d[j]);
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 34: // '"'
                int i1 = eup.a(eui1, 34);
                drk adrk[];
                int k;
                if (e == null)
                {
                    k = 0;
                } else
                {
                    k = e.length;
                }
                adrk = new drk[i1 + k];
                if (e != null)
                {
                    System.arraycopy(e, 0, adrk, 0, k);
                }
                for (e = adrk; k < e.length - 1; k++)
                {
                    e[k] = new drk();
                    eui1.a(e[k]);
                    eui1.a();
                }

                e[k] = new drk();
                eui1.a(e[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (b != null)
        {
            euj1.a(1, b);
        }
        if (d != null)
        {
            dex adex[] = d;
            int k = adex.length;
            for (int i = 0; i < k; i++)
            {
                dex dex1 = adex[i];
                if (dex1 != null)
                {
                    euj1.a(2, dex1);
                }
            }

        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (e != null)
        {
            drk adrk[] = e;
            int l = adrk.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                drk drk1 = adrk[j];
                if (drk1 != null)
                {
                    euj1.a(4, drk1);
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
            if (!(obj instanceof drk))
            {
                return false;
            }
            obj = (drk)obj;
            if ((b != null ? b.equals(((drk) (obj)).b) : ((drk) (obj)).b == null) && Arrays.equals(d, ((drk) (obj)).d) && (c != null ? c.equals(((drk) (obj)).c) : ((drk) (obj)).c == null) && Arrays.equals(e, ((drk) (obj)).e))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((drk) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((drk) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        int i1;
        boolean flag = false;
        int j = getClass().getName().hashCode();
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        i += (j + 527) * 31;
        if (d != null) goto _L2; else goto _L1
_L1:
        i1 = i * 31;
_L6:
        int k;
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        i += i1 * 31;
        if (e != null) goto _L4; else goto _L3
_L3:
        i1 = i * 31;
_L9:
        int l;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return i1 * 31 + i;
_L2:
        k = 0;
_L7:
        i1 = i;
        if (k >= d.length) goto _L6; else goto _L5
_L5:
        if (d[k] == null)
        {
            i1 = 0;
        } else
        {
            i1 = d[k].hashCode();
        }
        i = i1 + i * 31;
        k++;
          goto _L7
          goto _L6
_L4:
        l = 0;
_L10:
        i1 = i;
        if (l >= e.length) goto _L9; else goto _L8
_L8:
        if (e[l] == null)
        {
            i1 = 0;
        } else
        {
            i1 = e[l].hashCode();
        }
        i = i1 + i * 31;
        l++;
          goto _L10
    }

}
