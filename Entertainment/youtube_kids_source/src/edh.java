// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class edh extends eul
{

    private dcm a;
    private String b;
    private String c;
    private eam d[];
    private dkn e[];
    private edk f[];

    public edh()
    {
        a = null;
        b = "";
        c = "";
        d = eam.a;
        e = dkn.a;
        f = edk.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int i1;
        if (a != null)
        {
            j = euj.b(1, a) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (!b.equals(""))
        {
            i = j + euj.b(2, b);
        }
        j = i;
        if (!c.equals(""))
        {
            j = i + euj.b(3, c);
        }
        i = j;
        if (d != null)
        {
            eam aeam[] = d;
            int j1 = aeam.length;
            int k = 0;
            do
            {
                i = j;
                if (k >= j1)
                {
                    break;
                }
                eam eam1 = aeam[k];
                i = j;
                if (eam1 != null)
                {
                    i = j + euj.b(4, eam1);
                }
                k++;
                j = i;
            } while (true);
        }
        j = i;
        if (e != null)
        {
            dkn adkn[] = e;
            int k1 = adkn.length;
            int l = 0;
            do
            {
                j = i;
                if (l >= k1)
                {
                    break;
                }
                dkn dkn1 = adkn[l];
                j = i;
                if (dkn1 != null)
                {
                    j = i + euj.b(5, dkn1);
                }
                l++;
                i = j;
            } while (true);
        }
        i1 = j;
        if (f != null)
        {
            edk aedk[] = f;
            int l1 = aedk.length;
            i = ((flag) ? 1 : 0);
            do
            {
                i1 = j;
                if (i >= l1)
                {
                    break;
                }
                edk edk1 = aedk[i];
                i1 = j;
                if (edk1 != null)
                {
                    i1 = j + euj.b(6, edk1);
                }
                i++;
                j = i1;
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
                if (a == null)
                {
                    a = new dcm();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 34: // '"'
                int i1 = eup.a(eui1, 34);
                eam aeam[];
                int j;
                if (d == null)
                {
                    j = 0;
                } else
                {
                    j = d.length;
                }
                aeam = new eam[i1 + j];
                if (d != null)
                {
                    System.arraycopy(d, 0, aeam, 0, j);
                }
                for (d = aeam; j < d.length - 1; j++)
                {
                    d[j] = new eam();
                    eui1.a(d[j]);
                    eui1.a();
                }

                d[j] = new eam();
                eui1.a(d[j]);
                break;

            case 42: // '*'
                int j1 = eup.a(eui1, 42);
                dkn adkn[];
                int k;
                if (e == null)
                {
                    k = 0;
                } else
                {
                    k = e.length;
                }
                adkn = new dkn[j1 + k];
                if (e != null)
                {
                    System.arraycopy(e, 0, adkn, 0, k);
                }
                for (e = adkn; k < e.length - 1; k++)
                {
                    e[k] = new dkn();
                    eui1.a(e[k]);
                    eui1.a();
                }

                e[k] = new dkn();
                eui1.a(e[k]);
                break;

            case 50: // '2'
                int k1 = eup.a(eui1, 50);
                edk aedk[];
                int l;
                if (f == null)
                {
                    l = 0;
                } else
                {
                    l = f.length;
                }
                aedk = new edk[k1 + l];
                if (f != null)
                {
                    System.arraycopy(f, 0, aedk, 0, l);
                }
                for (f = aedk; l < f.length - 1; l++)
                {
                    f[l] = new edk();
                    eui1.a(f[l]);
                    eui1.a();
                }

                f[l] = new edk();
                eui1.a(f[l]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
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
            euj1.a(3, c);
        }
        if (d != null)
        {
            eam aeam[] = d;
            int l = aeam.length;
            for (int i = 0; i < l; i++)
            {
                eam eam1 = aeam[i];
                if (eam1 != null)
                {
                    euj1.a(4, eam1);
                }
            }

        }
        if (e != null)
        {
            dkn adkn[] = e;
            int i1 = adkn.length;
            for (int j = 0; j < i1; j++)
            {
                dkn dkn1 = adkn[j];
                if (dkn1 != null)
                {
                    euj1.a(5, dkn1);
                }
            }

        }
        if (f != null)
        {
            edk aedk[] = f;
            int j1 = aedk.length;
            for (int k = ((flag) ? 1 : 0); k < j1; k++)
            {
                edk edk1 = aedk[k];
                if (edk1 != null)
                {
                    euj1.a(6, edk1);
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
            if (!(obj instanceof edh))
            {
                return false;
            }
            obj = (edh)obj;
            if ((a != null ? a.equals(((edh) (obj)).a) : ((edh) (obj)).a == null) && (b != null ? b.equals(((edh) (obj)).b) : ((edh) (obj)).b == null) && (c != null ? c.equals(((edh) (obj)).c) : ((edh) (obj)).c == null) && (Arrays.equals(d, ((edh) (obj)).d) && Arrays.equals(e, ((edh) (obj)).e) && Arrays.equals(f, ((edh) (obj)).f)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((edh) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((edh) (obj)).O))
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
        int l = getClass().getName().hashCode();
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
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        i = k + (j + (i + (l + 527) * 31) * 31) * 31;
        if (d != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L8:
        if (e != null) goto _L4; else goto _L3
_L3:
        j *= 31;
_L11:
        if (f != null) goto _L6; else goto _L5
_L5:
        k = j * 31;
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
        if (k >= d.length) goto _L8; else goto _L7
_L7:
        if (d[k] == null)
        {
            j = 0;
        } else
        {
            j = d[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L9
          goto _L8
_L4:
        k = 0;
        i = j;
_L12:
        j = i;
        if (k >= e.length) goto _L11; else goto _L10
_L10:
        if (e[k] == null)
        {
            j = 0;
        } else
        {
            j = e[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L12
          goto _L11
_L6:
        k = 0;
        i = j;
        j = k;
_L15:
        k = i;
        if (j >= f.length) goto _L14; else goto _L13
_L13:
        if (f[j] == null)
        {
            k = 0;
        } else
        {
            k = f[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L15
    }
}
