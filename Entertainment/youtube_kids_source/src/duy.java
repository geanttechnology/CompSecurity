// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class duy extends eul
{

    public dva a[];
    public String b;
    public boolean c;
    public byte d[];
    private duz e[];
    private boolean f;
    private dmb g;
    private dlb h;

    public duy()
    {
        a = dva.a;
        b = "";
        c = false;
        e = duz.a;
        f = false;
        g = null;
        h = null;
        d = eup.f;
    }

    public final int a()
    {
        boolean flag = false;
        int k;
        if (a != null)
        {
            dva adva[] = a;
            int k1 = adva.length;
            int l = 0;
            int i = 0;
            do
            {
                k = i;
                if (l >= k1)
                {
                    break;
                }
                dva dva1 = adva[l];
                k = i;
                if (dva1 != null)
                {
                    k = i + euj.b(1, dva1);
                }
                l++;
                i = k;
            } while (true);
        } else
        {
            k = 0;
        }
        int i1 = k;
        if (!b.equals(""))
        {
            i1 = k + euj.b(2, b);
        }
        int j = i1;
        if (c)
        {
            boolean flag1 = c;
            j = i1 + (euj.b(3) + 1);
        }
        k = j;
        if (e != null)
        {
            duz aduz[] = e;
            int l1 = aduz.length;
            int j1 = ((flag) ? 1 : 0);
            do
            {
                k = j;
                if (j1 >= l1)
                {
                    break;
                }
                duz duz1 = aduz[j1];
                k = j;
                if (duz1 != null)
                {
                    k = j + euj.b(4, duz1);
                }
                j1++;
                j = k;
            } while (true);
        }
        j = k;
        if (f)
        {
            boolean flag2 = f;
            j = k + (euj.b(5) + 1);
        }
        k = j;
        if (g != null)
        {
            k = j + euj.b(6, g);
        }
        j = k;
        if (h != null)
        {
            j = k + euj.b(7, h);
        }
        k = j;
        if (!Arrays.equals(d, eup.f))
        {
            k = j + euj.b(9, d);
        }
        j = k + eup.a(O);
        P = j;
        return j;
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
                int l = eup.a(eui1, 10);
                dva adva[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adva = new dva[l + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adva, 0, j);
                }
                for (a = adva; j < a.length - 1; j++)
                {
                    a[j] = new dva();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dva();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 24: // '\030'
                c = eui1.e();
                break;

            case 34: // '"'
                int i1 = eup.a(eui1, 34);
                duz aduz[];
                int k;
                if (e == null)
                {
                    k = 0;
                } else
                {
                    k = e.length;
                }
                aduz = new duz[i1 + k];
                if (e != null)
                {
                    System.arraycopy(e, 0, aduz, 0, k);
                }
                for (e = aduz; k < e.length - 1; k++)
                {
                    e[k] = new duz();
                    eui1.a(e[k]);
                    eui1.a();
                }

                e[k] = new duz();
                eui1.a(e[k]);
                break;

            case 40: // '('
                f = eui1.e();
                break;

            case 50: // '2'
                if (g == null)
                {
                    g = new dmb();
                }
                eui1.a(g);
                break;

            case 58: // ':'
                if (h == null)
                {
                    h = new dlb();
                }
                eui1.a(h);
                break;

            case 74: // 'J'
                d = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            dva adva[] = a;
            int k = adva.length;
            for (int i = 0; i < k; i++)
            {
                dva dva1 = adva[i];
                if (dva1 != null)
                {
                    euj1.a(1, dva1);
                }
            }

        }
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (c)
        {
            euj1.a(3, c);
        }
        if (e != null)
        {
            duz aduz[] = e;
            int l = aduz.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                duz duz1 = aduz[j];
                if (duz1 != null)
                {
                    euj1.a(4, duz1);
                }
            }

        }
        if (f)
        {
            euj1.a(5, f);
        }
        if (g != null)
        {
            euj1.a(6, g);
        }
        if (h != null)
        {
            euj1.a(7, h);
        }
        if (!Arrays.equals(d, eup.f))
        {
            euj1.a(9, d);
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
            if (!(obj instanceof duy))
            {
                return false;
            }
            obj = (duy)obj;
            if (Arrays.equals(a, ((duy) (obj)).a) && (b != null ? b.equals(((duy) (obj)).b) : ((duy) (obj)).b == null) && (c == ((duy) (obj)).c && Arrays.equals(e, ((duy) (obj)).e) && f == ((duy) (obj)).f) && (g != null ? g.equals(((duy) (obj)).g) : ((duy) (obj)).g == null) && (h != null ? h.equals(((duy) (obj)).h) : ((duy) (obj)).h == null) && Arrays.equals(d, ((duy) (obj)).d))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((duy) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((duy) (obj)).O))
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
        boolean flag;
        l = 1;
        flag = false;
        i = getClass().getName().hashCode() + 527;
        if (a != null) goto _L2; else goto _L1
_L1:
        int j = i * 31;
_L8:
        int k;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (c)
        {
            k = 1;
        } else
        {
            k = 2;
        }
        i = k + (i + j * 31) * 31;
        if (e != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L11:
        if (f)
        {
            i = l;
        } else
        {
            i = 2;
        }
        if (g == null)
        {
            k = 0;
        } else
        {
            k = g.hashCode();
        }
        if (h == null)
        {
            l = 0;
        } else
        {
            l = h.hashCode();
        }
        i = l + (k + (j * 31 + i) * 31) * 31;
        if (d != null) goto _L6; else goto _L5
_L5:
        j = i * 31;
_L14:
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
_L15:
        j = i;
        if (k >= d.length) goto _L14; else goto _L13
_L13:
        i = i * 31 + d[k];
        k++;
          goto _L15
    }
}
