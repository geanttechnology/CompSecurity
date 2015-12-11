// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class edm extends eul
{

    public static final edm a[] = new edm[0];
    private dkn b[];
    private String c[];
    private String d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private String k;
    private String l;

    public edm()
    {
        b = dkn.a;
        c = eup.d;
        d = "";
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = false;
        j = false;
        k = "";
        l = "";
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        if (b != null)
        {
            dkn adkn[] = b;
            int j2 = adkn.length;
            int l1 = 0;
            int j1 = 0;
            do
            {
                i1 = j1;
                if (l1 >= j2)
                {
                    break;
                }
                dkn dkn1 = adkn[l1];
                i1 = j1;
                if (dkn1 != null)
                {
                    i1 = j1 + euj.b(1, dkn1);
                }
                l1++;
                j1 = i1;
            } while (true);
        } else
        {
            i1 = 0;
        }
        int k1 = i1;
        if (c != null)
        {
            k1 = i1;
            if (c.length > 0)
            {
                String as[] = c;
                int k2 = as.length;
                int i2 = 0;
                for (k1 = ((flag) ? 1 : 0); k1 < k2; k1++)
                {
                    i2 += euj.a(as[k1]);
                }

                k1 = i1 + i2 + c.length * 1;
            }
        }
        i1 = k1;
        if (!d.equals(""))
        {
            i1 = k1 + euj.b(3, d);
        }
        k1 = i1;
        if (e != 0)
        {
            k1 = i1 + euj.c(4, e);
        }
        i1 = k1;
        if (f != 0)
        {
            i1 = k1 + euj.c(5, f);
        }
        k1 = i1;
        if (g != 0)
        {
            k1 = i1 + euj.c(6, g);
        }
        i1 = k1;
        if (h != 0)
        {
            i1 = k1 + euj.c(7, h);
        }
        k1 = i1;
        if (i)
        {
            boolean flag1 = i;
            k1 = i1 + (euj.b(8) + 1);
        }
        i1 = k1;
        if (j)
        {
            boolean flag2 = j;
            i1 = k1 + (euj.b(9) + 1);
        }
        k1 = i1;
        if (!k.equals(""))
        {
            k1 = i1 + euj.b(10, k);
        }
        i1 = k1;
        if (!l.equals(""))
        {
            i1 = k1 + euj.b(11, l);
        }
        i1 += eup.a(O);
        P = i1;
        return i1;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int i1 = eui1.a();
            switch (i1)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                int l1 = eup.a(eui1, 10);
                dkn adkn[];
                int j1;
                if (b == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = b.length;
                }
                adkn = new dkn[l1 + j1];
                if (b != null)
                {
                    System.arraycopy(b, 0, adkn, 0, j1);
                }
                for (b = adkn; j1 < b.length - 1; j1++)
                {
                    b[j1] = new dkn();
                    eui1.a(b[j1]);
                    eui1.a();
                }

                b[j1] = new dkn();
                eui1.a(b[j1]);
                break;

            case 18: // '\022'
                int i2 = eup.a(eui1, 18);
                int k1 = c.length;
                String as[] = new String[i2 + k1];
                System.arraycopy(c, 0, as, 0, k1);
                for (c = as; k1 < c.length - 1; k1++)
                {
                    c[k1] = eui1.f();
                    eui1.a();
                }

                c[k1] = eui1.f();
                break;

            case 26: // '\032'
                d = eui1.f();
                break;

            case 32: // ' '
                e = eui1.d();
                break;

            case 40: // '('
                f = eui1.d();
                break;

            case 48: // '0'
                g = eui1.d();
                break;

            case 56: // '8'
                h = eui1.d();
                break;

            case 64: // '@'
                i = eui1.e();
                break;

            case 72: // 'H'
                j = eui1.e();
                break;

            case 82: // 'R'
                k = eui1.f();
                break;

            case 90: // 'Z'
                l = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (b != null)
        {
            dkn adkn[] = b;
            int k1 = adkn.length;
            for (int i1 = 0; i1 < k1; i1++)
            {
                dkn dkn1 = adkn[i1];
                if (dkn1 != null)
                {
                    euj1.a(1, dkn1);
                }
            }

        }
        if (c != null)
        {
            String as[] = c;
            int l1 = as.length;
            for (int j1 = ((flag) ? 1 : 0); j1 < l1; j1++)
            {
                euj1.a(2, as[j1]);
            }

        }
        if (!d.equals(""))
        {
            euj1.a(3, d);
        }
        if (e != 0)
        {
            euj1.a(4, e);
        }
        if (f != 0)
        {
            euj1.a(5, f);
        }
        if (g != 0)
        {
            euj1.a(6, g);
        }
        if (h != 0)
        {
            euj1.a(7, h);
        }
        if (i)
        {
            euj1.a(8, i);
        }
        if (j)
        {
            euj1.a(9, j);
        }
        if (!k.equals(""))
        {
            euj1.a(10, k);
        }
        if (!l.equals(""))
        {
            euj1.a(11, l);
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
            if (!(obj instanceof edm))
            {
                return false;
            }
            obj = (edm)obj;
            if (Arrays.equals(b, ((edm) (obj)).b) && Arrays.equals(c, ((edm) (obj)).c) && (d != null ? d.equals(((edm) (obj)).d) : ((edm) (obj)).d == null) && (e == ((edm) (obj)).e && f == ((edm) (obj)).f && g == ((edm) (obj)).g && h == ((edm) (obj)).h && i == ((edm) (obj)).i && j == ((edm) (obj)).j) && (k != null ? k.equals(((edm) (obj)).k) : ((edm) (obj)).k == null) && (l != null ? l.equals(((edm) (obj)).l) : ((edm) (obj)).l == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((edm) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((edm) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i1;
        int l1;
        int k2;
        l1 = 1;
        k2 = 0;
        i1 = getClass().getName().hashCode() + 527;
        if (b != null) goto _L2; else goto _L1
_L1:
        int j1 = i1 * 31;
_L6:
        if (c != null) goto _L4; else goto _L3
_L3:
        j1 *= 31;
_L9:
        int k1;
        int i2;
        int j2;
        int l2;
        int i3;
        int j3;
        int k3;
        if (d == null)
        {
            i1 = 0;
        } else
        {
            i1 = d.hashCode();
        }
        l2 = e;
        i3 = f;
        j3 = g;
        k3 = h;
        if (i)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (!j)
        {
            l1 = 2;
        }
        if (k == null)
        {
            i2 = 0;
        } else
        {
            i2 = k.hashCode();
        }
        if (l == null)
        {
            j2 = 0;
        } else
        {
            j2 = l.hashCode();
        }
        if (O != null)
        {
            k2 = O.hashCode();
        }
        return (j2 + (i2 + ((k1 + (((((i1 + j1 * 31) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31) * 31 + l1) * 31) * 31) * 31 + k2;
_L2:
        k1 = 0;
_L7:
        j1 = i1;
        if (k1 >= b.length) goto _L6; else goto _L5
_L5:
        if (b[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = b[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L7
          goto _L6
_L4:
        k1 = 0;
        i1 = j1;
_L10:
        j1 = i1;
        if (k1 >= c.length) goto _L9; else goto _L8
_L8:
        if (c[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = c[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L10
    }

}
