// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class eax extends eul
{

    public eaz a[];
    private int b;
    private dlb c;
    private dlb d;
    private eay e[];
    private byte f[];
    private dre g;

    public eax()
    {
        a = eaz.a;
        b = 0;
        c = null;
        d = null;
        e = eay.a;
        f = eup.f;
        g = null;
    }

    public final int a()
    {
        boolean flag = false;
        int k;
        if (a != null)
        {
            eaz aeaz[] = a;
            int j1 = aeaz.length;
            int l = 0;
            int i = 0;
            do
            {
                k = i;
                if (l >= j1)
                {
                    break;
                }
                eaz eaz1 = aeaz[l];
                k = i;
                if (eaz1 != null)
                {
                    k = i + euj.b(1, eaz1);
                }
                l++;
                i = k;
            } while (true);
        } else
        {
            k = 0;
        }
        int j = k;
        if (b != 0)
        {
            j = k + euj.c(2, b);
        }
        k = j;
        if (c != null)
        {
            k = j + euj.b(3, c);
        }
        j = k;
        if (d != null)
        {
            j = k + euj.b(4, d);
        }
        k = j;
        if (e != null)
        {
            eay aeay[] = e;
            int k1 = aeay.length;
            int i1 = ((flag) ? 1 : 0);
            do
            {
                k = j;
                if (i1 >= k1)
                {
                    break;
                }
                eay eay1 = aeay[i1];
                k = j;
                if (eay1 != null)
                {
                    k = j + euj.b(5, eay1);
                }
                i1++;
                j = k;
            } while (true);
        }
        j = k;
        if (!Arrays.equals(f, eup.f))
        {
            j = k + euj.b(7, f);
        }
        k = j;
        if (g != null)
        {
            k = j + euj.b(8, g);
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
                eaz aeaz[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                aeaz = new eaz[l + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, aeaz, 0, j);
                }
                for (a = aeaz; j < a.length - 1; j++)
                {
                    a[j] = new eaz();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new eaz();
                eui1.a(a[j]);
                break;

            case 16: // '\020'
                b = eui1.d();
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                int i1 = eup.a(eui1, 42);
                eay aeay[];
                int k;
                if (e == null)
                {
                    k = 0;
                } else
                {
                    k = e.length;
                }
                aeay = new eay[i1 + k];
                if (e != null)
                {
                    System.arraycopy(e, 0, aeay, 0, k);
                }
                for (e = aeay; k < e.length - 1; k++)
                {
                    e[k] = new eay();
                    eui1.a(e[k]);
                    eui1.a();
                }

                e[k] = new eay();
                eui1.a(e[k]);
                break;

            case 58: // ':'
                f = eui1.g();
                break;

            case 66: // 'B'
                if (g == null)
                {
                    g = new dre();
                }
                eui1.a(g);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            eaz aeaz[] = a;
            int k = aeaz.length;
            for (int i = 0; i < k; i++)
            {
                eaz eaz1 = aeaz[i];
                if (eaz1 != null)
                {
                    euj1.a(1, eaz1);
                }
            }

        }
        if (b != 0)
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            euj1.a(3, c);
        }
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            eay aeay[] = e;
            int l = aeay.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                eay eay1 = aeay[j];
                if (eay1 != null)
                {
                    euj1.a(5, eay1);
                }
            }

        }
        if (!Arrays.equals(f, eup.f))
        {
            euj1.a(7, f);
        }
        if (g != null)
        {
            euj1.a(8, g);
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
            if (!(obj instanceof eax))
            {
                return false;
            }
            obj = (eax)obj;
            if (Arrays.equals(a, ((eax) (obj)).a) && b == ((eax) (obj)).b && (c != null ? c.equals(((eax) (obj)).c) : ((eax) (obj)).c == null) && (d != null ? d.equals(((eax) (obj)).d) : ((eax) (obj)).d == null) && (Arrays.equals(e, ((eax) (obj)).e) && Arrays.equals(f, ((eax) (obj)).f)) && (g != null ? g.equals(((eax) (obj)).g) : ((eax) (obj)).g == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((eax) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((eax) (obj)).O))
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
        int k;
        int l = b;
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
        i = k + (i + (j * 31 + l) * 31) * 31;
        if (e != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L11:
        if (f != null) goto _L6; else goto _L5
_L5:
        i = j * 31;
_L14:
        if (g == null)
        {
            j = 0;
        } else
        {
            j = g.hashCode();
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
        i = j;
        if (k >= f.length) goto _L14; else goto _L13
_L13:
        j = j * 31 + f[k];
        k++;
          goto _L15
    }
}
