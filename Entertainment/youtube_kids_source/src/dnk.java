// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dnk extends eul
{

    public static final dnk a[] = new dnk[0];
    private int b;
    private int c[];
    private int d[];
    private int e[];
    private int f[];

    public dnk()
    {
        b = 0;
        c = eup.a;
        d = eup.a;
        e = eup.a;
        f = eup.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        if (b != 0)
        {
            j = euj.d(1, b) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (c != null)
        {
            i = j;
            if (c.length > 0)
            {
                int ai[] = c;
                int k1 = ai.length;
                i = 0;
                int k = 0;
                for (; i < k1; i++)
                {
                    k += euj.c(ai[i]);
                }

                i = j + k + c.length * 1;
            }
        }
        j = i;
        if (d != null)
        {
            j = i;
            if (d.length > 0)
            {
                int ai1[] = d;
                int l1 = ai1.length;
                j = 0;
                int l = 0;
                for (; j < l1; j++)
                {
                    l += euj.c(ai1[j]);
                }

                j = i + l + d.length * 1;
            }
        }
        i = j;
        if (e != null)
        {
            i = j;
            if (e.length > 0)
            {
                int ai2[] = e;
                int i2 = ai2.length;
                i = 0;
                int i1 = 0;
                for (; i < i2; i++)
                {
                    i1 += euj.c(ai2[i]);
                }

                i = j + i1 + e.length * 1;
            }
        }
        j = i;
        if (f != null)
        {
            j = i;
            if (f.length > 0)
            {
                int ai3[] = f;
                int j2 = ai3.length;
                int j1 = 0;
                for (j = ((flag) ? 1 : 0); j < j2; j++)
                {
                    j1 += euj.c(ai3[j]);
                }

                j = i + j1 + f.length * 1;
            }
        }
        i = j + eup.a(O);
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

            case 8: // '\b'
                b = eui1.h();
                break;

            case 16: // '\020'
                int j1 = eup.a(eui1, 16);
                int j = c.length;
                int ai[] = new int[j1 + j];
                System.arraycopy(c, 0, ai, 0, j);
                for (c = ai; j < c.length - 1; j++)
                {
                    c[j] = eui1.h();
                    eui1.a();
                }

                c[j] = eui1.h();
                break;

            case 24: // '\030'
                int k1 = eup.a(eui1, 24);
                int k = d.length;
                int ai1[] = new int[k1 + k];
                System.arraycopy(d, 0, ai1, 0, k);
                for (d = ai1; k < d.length - 1; k++)
                {
                    d[k] = eui1.h();
                    eui1.a();
                }

                d[k] = eui1.h();
                break;

            case 32: // ' '
                int l1 = eup.a(eui1, 32);
                int l = e.length;
                int ai2[] = new int[l1 + l];
                System.arraycopy(e, 0, ai2, 0, l);
                for (e = ai2; l < e.length - 1; l++)
                {
                    e[l] = eui1.h();
                    eui1.a();
                }

                e[l] = eui1.h();
                break;

            case 40: // '('
                int i2 = eup.a(eui1, 40);
                int i1 = f.length;
                int ai3[] = new int[i2 + i1];
                System.arraycopy(f, 0, ai3, 0, i1);
                for (f = ai3; i1 < f.length - 1; i1++)
                {
                    f[i1] = eui1.h();
                    eui1.a();
                }

                f[i1] = eui1.h();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (b != 0)
        {
            euj1.b(1, b);
        }
        if (c != null)
        {
            int ai[] = c;
            int i1 = ai.length;
            for (int i = 0; i < i1; i++)
            {
                euj1.b(2, ai[i]);
            }

        }
        if (d != null)
        {
            int ai1[] = d;
            int j1 = ai1.length;
            for (int j = 0; j < j1; j++)
            {
                euj1.b(3, ai1[j]);
            }

        }
        if (e != null)
        {
            int ai2[] = e;
            int k1 = ai2.length;
            for (int k = 0; k < k1; k++)
            {
                euj1.b(4, ai2[k]);
            }

        }
        if (f != null)
        {
            int ai3[] = f;
            int l1 = ai3.length;
            for (int l = ((flag) ? 1 : 0); l < l1; l++)
            {
                euj1.b(5, ai3[l]);
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
        if (!(obj instanceof dnk))
        {
            return false;
        }
        obj = (dnk)obj;
        if (b != ((dnk) (obj)).b || !Arrays.equals(c, ((dnk) (obj)).c) || !Arrays.equals(d, ((dnk) (obj)).d) || !Arrays.equals(e, ((dnk) (obj)).e) || !Arrays.equals(f, ((dnk) (obj)).f))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dnk) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dnk) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j;
        boolean flag;
        flag = false;
        j = (getClass().getName().hashCode() + 527) * 31 + b;
        if (c != null) goto _L2; else goto _L1
_L1:
        int i = j * 31;
_L10:
        if (d != null) goto _L4; else goto _L3
_L3:
        i *= 31;
_L13:
        if (e != null) goto _L6; else goto _L5
_L5:
        i *= 31;
_L16:
        if (f != null) goto _L8; else goto _L7
_L7:
        j = i * 31;
_L19:
        int k;
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
_L11:
        i = j;
        if (k >= c.length) goto _L10; else goto _L9
_L9:
        j = j * 31 + c[k];
        k++;
          goto _L11
          goto _L10
_L4:
        k = 0;
        j = i;
_L14:
        i = j;
        if (k >= d.length) goto _L13; else goto _L12
_L12:
        j = j * 31 + d[k];
        k++;
          goto _L14
          goto _L13
_L6:
        k = 0;
        j = i;
_L17:
        i = j;
        if (k >= e.length) goto _L16; else goto _L15
_L15:
        j = j * 31 + e[k];
        k++;
          goto _L17
          goto _L16
_L8:
        k = 0;
_L20:
        j = i;
        if (k >= f.length) goto _L19; else goto _L18
_L18:
        i = i * 31 + f[k];
        k++;
          goto _L20
    }

}
