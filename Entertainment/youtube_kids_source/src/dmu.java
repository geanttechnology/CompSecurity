// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dmu extends eul
{

    public dnb a[];
    private String b[];
    private String c[];
    private String d[];
    private String e[];
    private String f[];

    public dmu()
    {
        a = dnb.a;
        b = eup.d;
        c = eup.d;
        d = eup.d;
        e = eup.d;
        f = eup.d;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        if (a != null)
        {
            dnb adnb[] = a;
            int j2 = adnb.length;
            int l = 0;
            int j = 0;
            do
            {
                i = j;
                if (l >= j2)
                {
                    break;
                }
                dnb dnb1 = adnb[l];
                i = j;
                if (dnb1 != null)
                {
                    i = j + euj.b(1, dnb1);
                }
                l++;
                j = i;
            } while (true);
        } else
        {
            i = 0;
        }
        int k = i;
        if (b != null)
        {
            k = i;
            if (b.length > 0)
            {
                String as[] = b;
                int k2 = as.length;
                k = 0;
                int i1 = 0;
                for (; k < k2; k++)
                {
                    i1 += euj.a(as[k]);
                }

                k = i + i1 + b.length * 1;
            }
        }
        i = k;
        if (c != null)
        {
            i = k;
            if (c.length > 0)
            {
                String as1[] = c;
                int l2 = as1.length;
                i = 0;
                int j1 = 0;
                for (; i < l2; i++)
                {
                    j1 += euj.a(as1[i]);
                }

                i = k + j1 + c.length * 1;
            }
        }
        k = i;
        if (d != null)
        {
            k = i;
            if (d.length > 0)
            {
                String as2[] = d;
                int i3 = as2.length;
                k = 0;
                int k1 = 0;
                for (; k < i3; k++)
                {
                    k1 += euj.a(as2[k]);
                }

                k = i + k1 + d.length * 1;
            }
        }
        i = k;
        if (e != null)
        {
            i = k;
            if (e.length > 0)
            {
                String as3[] = e;
                int j3 = as3.length;
                i = 0;
                int l1 = 0;
                for (; i < j3; i++)
                {
                    l1 += euj.a(as3[i]);
                }

                i = k + l1 + e.length * 1;
            }
        }
        k = i;
        if (f != null)
        {
            k = i;
            if (f.length > 0)
            {
                String as4[] = f;
                int k3 = as4.length;
                int i2 = 0;
                for (k = ((flag) ? 1 : 0); k < k3; k++)
                {
                    i2 += euj.a(as4[k]);
                }

                k = i + i2 + f.length * 1;
            }
        }
        i = k + eup.a(O);
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
                int l1 = eup.a(eui1, 10);
                dnb adnb[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adnb = new dnb[l1 + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adnb, 0, j);
                }
                for (a = adnb; j < a.length - 1; j++)
                {
                    a[j] = new dnb();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dnb();
                eui1.a(a[j]);
                break;

            case 26: // '\032'
                int i2 = eup.a(eui1, 26);
                int k = b.length;
                String as[] = new String[i2 + k];
                System.arraycopy(b, 0, as, 0, k);
                for (b = as; k < b.length - 1; k++)
                {
                    b[k] = eui1.f();
                    eui1.a();
                }

                b[k] = eui1.f();
                break;

            case 34: // '"'
                int j2 = eup.a(eui1, 34);
                int l = c.length;
                String as1[] = new String[j2 + l];
                System.arraycopy(c, 0, as1, 0, l);
                for (c = as1; l < c.length - 1; l++)
                {
                    c[l] = eui1.f();
                    eui1.a();
                }

                c[l] = eui1.f();
                break;

            case 42: // '*'
                int k2 = eup.a(eui1, 42);
                int i1 = d.length;
                String as2[] = new String[k2 + i1];
                System.arraycopy(d, 0, as2, 0, i1);
                for (d = as2; i1 < d.length - 1; i1++)
                {
                    d[i1] = eui1.f();
                    eui1.a();
                }

                d[i1] = eui1.f();
                break;

            case 50: // '2'
                int l2 = eup.a(eui1, 50);
                int j1 = e.length;
                String as3[] = new String[l2 + j1];
                System.arraycopy(e, 0, as3, 0, j1);
                for (e = as3; j1 < e.length - 1; j1++)
                {
                    e[j1] = eui1.f();
                    eui1.a();
                }

                e[j1] = eui1.f();
                break;

            case 58: // ':'
                int i3 = eup.a(eui1, 58);
                int k1 = f.length;
                String as4[] = new String[i3 + k1];
                System.arraycopy(f, 0, as4, 0, k1);
                for (f = as4; k1 < f.length - 1; k1++)
                {
                    f[k1] = eui1.f();
                    eui1.a();
                }

                f[k1] = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            dnb adnb[] = a;
            int k1 = adnb.length;
            for (int i = 0; i < k1; i++)
            {
                dnb dnb1 = adnb[i];
                if (dnb1 != null)
                {
                    euj1.a(1, dnb1);
                }
            }

        }
        if (b != null)
        {
            String as[] = b;
            int l1 = as.length;
            for (int j = 0; j < l1; j++)
            {
                euj1.a(3, as[j]);
            }

        }
        if (c != null)
        {
            String as1[] = c;
            int i2 = as1.length;
            for (int k = 0; k < i2; k++)
            {
                euj1.a(4, as1[k]);
            }

        }
        if (d != null)
        {
            String as2[] = d;
            int j2 = as2.length;
            for (int l = 0; l < j2; l++)
            {
                euj1.a(5, as2[l]);
            }

        }
        if (e != null)
        {
            String as3[] = e;
            int k2 = as3.length;
            for (int i1 = 0; i1 < k2; i1++)
            {
                euj1.a(6, as3[i1]);
            }

        }
        if (f != null)
        {
            String as4[] = f;
            int l2 = as4.length;
            for (int j1 = ((flag) ? 1 : 0); j1 < l2; j1++)
            {
                euj1.a(7, as4[j1]);
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
        if (!(obj instanceof dmu))
        {
            return false;
        }
        obj = (dmu)obj;
        if (!Arrays.equals(a, ((dmu) (obj)).a) || !Arrays.equals(b, ((dmu) (obj)).b) || !Arrays.equals(c, ((dmu) (obj)).c) || !Arrays.equals(d, ((dmu) (obj)).d) || !Arrays.equals(e, ((dmu) (obj)).e) || !Arrays.equals(f, ((dmu) (obj)).f))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmu) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmu) (obj)).O))
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
_L14:
        if (b != null) goto _L4; else goto _L3
_L3:
        j *= 31;
_L17:
        if (c != null) goto _L6; else goto _L5
_L5:
        j *= 31;
_L20:
        if (d != null) goto _L8; else goto _L7
_L7:
        j *= 31;
_L23:
        if (e != null) goto _L10; else goto _L9
_L9:
        j *= 31;
_L26:
        if (f != null) goto _L12; else goto _L11
_L11:
        int k = j * 31;
_L29:
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
_L15:
        j = i;
        if (k >= a.length) goto _L14; else goto _L13
_L13:
        if (a[k] == null)
        {
            j = 0;
        } else
        {
            j = a[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L15
          goto _L14
_L4:
        k = 0;
        i = j;
_L18:
        j = i;
        if (k >= b.length) goto _L17; else goto _L16
_L16:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L18
          goto _L17
_L6:
        k = 0;
        i = j;
_L21:
        j = i;
        if (k >= c.length) goto _L20; else goto _L19
_L19:
        if (c[k] == null)
        {
            j = 0;
        } else
        {
            j = c[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L21
          goto _L20
_L8:
        k = 0;
        i = j;
_L24:
        j = i;
        if (k >= d.length) goto _L23; else goto _L22
_L22:
        if (d[k] == null)
        {
            j = 0;
        } else
        {
            j = d[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L24
          goto _L23
_L10:
        k = 0;
        i = j;
_L27:
        j = i;
        if (k >= e.length) goto _L26; else goto _L25
_L25:
        if (e[k] == null)
        {
            j = 0;
        } else
        {
            j = e[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L27
          goto _L26
_L12:
        k = 0;
        i = j;
        j = k;
_L30:
        k = i;
        if (j >= f.length) goto _L29; else goto _L28
_L28:
        if (f[j] == null)
        {
            k = 0;
        } else
        {
            k = f[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L30
    }
}
