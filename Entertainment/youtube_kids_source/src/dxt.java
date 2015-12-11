// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dxt extends eul
{

    private String a[];
    private String b[];
    private String c;
    private String d;
    private ecg e[];
    private div f;

    public dxt()
    {
        a = eup.d;
        b = eup.d;
        c = "";
        d = "";
        e = ecg.a;
        f = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int k;
        int j1;
        if (a != null && a.length > 0)
        {
            String as[] = a;
            int l = as.length;
            i = 0;
            int j = 0;
            for (; i < l; i++)
            {
                j += euj.a(as[i]);
            }

            i = j + 0 + a.length * 1;
        } else
        {
            i = 0;
        }
        k = i;
        if (b != null)
        {
            k = i;
            if (b.length > 0)
            {
                String as1[] = b;
                int l1 = as1.length;
                k = 0;
                int i1 = 0;
                for (; k < l1; k++)
                {
                    i1 += euj.a(as1[k]);
                }

                k = i + i1 + b.length * 1;
            }
        }
        j1 = k;
        if (!c.equals(""))
        {
            j1 = k + euj.b(3, c);
        }
        i = j1;
        if (!d.equals(""))
        {
            i = j1 + euj.b(4, d);
        }
        k = i;
        if (e != null)
        {
            ecg aecg[] = e;
            int i2 = aecg.length;
            int k1 = ((flag) ? 1 : 0);
            do
            {
                k = i;
                if (k1 >= i2)
                {
                    break;
                }
                ecg ecg1 = aecg[k1];
                k = i;
                if (ecg1 != null)
                {
                    k = i + euj.b(5, ecg1);
                }
                k1++;
                i = k;
            } while (true);
        }
        i = k;
        if (f != null)
        {
            i = k + euj.b(6, f);
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
                int i1 = eup.a(eui1, 10);
                int j = a.length;
                String as[] = new String[i1 + j];
                System.arraycopy(a, 0, as, 0, j);
                for (a = as; j < a.length - 1; j++)
                {
                    a[j] = eui1.f();
                    eui1.a();
                }

                a[j] = eui1.f();
                break;

            case 18: // '\022'
                int j1 = eup.a(eui1, 18);
                int k = b.length;
                String as1[] = new String[j1 + k];
                System.arraycopy(b, 0, as1, 0, k);
                for (b = as1; k < b.length - 1; k++)
                {
                    b[k] = eui1.f();
                    eui1.a();
                }

                b[k] = eui1.f();
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 34: // '"'
                d = eui1.f();
                break;

            case 42: // '*'
                int k1 = eup.a(eui1, 42);
                ecg aecg[];
                int l;
                if (e == null)
                {
                    l = 0;
                } else
                {
                    l = e.length;
                }
                aecg = new ecg[k1 + l];
                if (e != null)
                {
                    System.arraycopy(e, 0, aecg, 0, l);
                }
                for (e = aecg; l < e.length - 1; l++)
                {
                    e[l] = new ecg();
                    eui1.a(e[l]);
                    eui1.a();
                }

                e[l] = new ecg();
                eui1.a(e[l]);
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new div();
                }
                eui1.a(f);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            String as[] = a;
            int l = as.length;
            for (int i = 0; i < l; i++)
            {
                euj1.a(1, as[i]);
            }

        }
        if (b != null)
        {
            String as1[] = b;
            int i1 = as1.length;
            for (int j = 0; j < i1; j++)
            {
                euj1.a(2, as1[j]);
            }

        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (!d.equals(""))
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            ecg aecg[] = e;
            int j1 = aecg.length;
            for (int k = ((flag) ? 1 : 0); k < j1; k++)
            {
                ecg ecg1 = aecg[k];
                if (ecg1 != null)
                {
                    euj1.a(5, ecg1);
                }
            }

        }
        if (f != null)
        {
            euj1.a(6, f);
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
            if (!(obj instanceof dxt))
            {
                return false;
            }
            obj = (dxt)obj;
            if (Arrays.equals(a, ((dxt) (obj)).a) && Arrays.equals(b, ((dxt) (obj)).b) && (c != null ? c.equals(((dxt) (obj)).c) : ((dxt) (obj)).c == null) && (d != null ? d.equals(((dxt) (obj)).d) : ((dxt) (obj)).d == null) && Arrays.equals(e, ((dxt) (obj)).e) && (f != null ? f.equals(((dxt) (obj)).f) : ((dxt) (obj)).f == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dxt) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dxt) (obj)).O))
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
        int j = i * 31;
_L8:
        if (b != null) goto _L4; else goto _L3
_L3:
        j *= 31;
_L11:
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
        if (e != null) goto _L6; else goto _L5
_L5:
        j = i * 31;
_L14:
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
        return (i + j * 31) * 31 + k;
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
_L12:
        j = i;
        if (k >= b.length) goto _L11; else goto _L10
_L10:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L12
          goto _L11
_L6:
        k = 0;
_L15:
        j = i;
        if (k >= e.length) goto _L14; else goto _L13
_L13:
        if (e[k] == null)
        {
            j = 0;
        } else
        {
            j = e[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L15
    }
}
