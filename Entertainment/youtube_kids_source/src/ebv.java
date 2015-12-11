// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ebv extends eul
{

    public int a;
    public int b;
    public int c;
    private int d[];
    private int e;

    public ebv()
    {
        d = eup.a;
        a = 0;
        b = 0;
        c = 0;
        e = 0;
    }

    public final int a()
    {
        int j = 0;
        boolean flag = false;
        int i = j;
        if (d != null)
        {
            i = j;
            if (d.length > 0)
            {
                int ai[] = d;
                int k = ai.length;
                j = 0;
                for (i = ((flag) ? 1 : 0); i < k; i++)
                {
                    j += euj.a(ai[i]);
                }

                i = j + 0 + d.length * 1;
            }
        }
        j = i;
        if (a != 0)
        {
            j = i + euj.d(2, a);
        }
        i = j;
        if (b != 0)
        {
            i = j + euj.d(3, b);
        }
        j = i;
        if (c != 0)
        {
            j = i + euj.d(4, c);
        }
        i = j;
        if (e != 0)
        {
            i = j + euj.d(5, e);
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

            case 8: // '\b'
                int k = eup.a(eui1, 8);
                int j = d.length;
                int ai[] = new int[k + j];
                System.arraycopy(d, 0, ai, 0, j);
                for (d = ai; j < d.length - 1; j++)
                {
                    d[j] = eui1.d();
                    eui1.a();
                }

                d[j] = eui1.d();
                break;

            case 16: // '\020'
                a = eui1.h();
                break;

            case 24: // '\030'
                b = eui1.h();
                break;

            case 32: // ' '
                c = eui1.h();
                break;

            case 40: // '('
                e = eui1.h();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (d != null && d.length > 0)
        {
            int ai[] = d;
            int j = ai.length;
            for (int i = 0; i < j; i++)
            {
                euj1.a(1, ai[i]);
            }

        }
        if (a != 0)
        {
            euj1.b(2, a);
        }
        if (b != 0)
        {
            euj1.b(3, b);
        }
        if (c != 0)
        {
            euj1.b(4, c);
        }
        if (e != 0)
        {
            euj1.b(5, e);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof ebv))
        {
            return false;
        }
        obj = (ebv)obj;
        if (!Arrays.equals(d, ((ebv) (obj)).d) || a != ((ebv) (obj)).a || b != ((ebv) (obj)).b || c != ((ebv) (obj)).c || e != ((ebv) (obj)).e)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ebv) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ebv) (obj)).O))
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
        if (d != null) goto _L2; else goto _L1
_L1:
        int j = i * 31;
_L4:
        int k = a;
        int l = b;
        int i1 = c;
        int j1 = e;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return ((((j * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + i;
_L2:
        k = 0;
_L5:
        j = i;
        if (k >= d.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + d[k];
        k++;
          goto _L5
    }
}
