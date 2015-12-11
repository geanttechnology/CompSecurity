// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dfb extends eul
{

    public static final dfb a[] = new dfb[0];
    private dfa b;
    private int c[];
    private int d;
    private int e;
    private int f;

    public dfb()
    {
        b = null;
        c = eup.a;
        d = 0;
        e = 0;
        f = 0;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        if (b != null)
        {
            i = euj.b(1, b) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (c != null)
        {
            j = i;
            if (c.length > 0)
            {
                int ai[] = c;
                int l = ai.length;
                int k = 0;
                for (j = ((flag) ? 1 : 0); j < l; j++)
                {
                    k += euj.a(ai[j]);
                }

                j = i + k + c.length * 1;
            }
        }
        i = j;
        if (d != 0)
        {
            i = j + euj.c(3, d);
        }
        j = i;
        if (e != 0)
        {
            j = i + euj.c(4, e);
        }
        i = j;
        if (f != 0)
        {
            i = j + euj.c(5, f);
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
                if (b == null)
                {
                    b = new dfa();
                }
                eui1.a(b);
                break;

            case 16: // '\020'
                int l = eup.a(eui1, 16);
                int j = c.length;
                int ai[] = new int[l + j];
                System.arraycopy(c, 0, ai, 0, j);
                for (c = ai; j < c.length - 1; j++)
                {
                    c[j] = eui1.d();
                    eui1.a();
                }

                c[j] = eui1.d();
                break;

            case 24: // '\030'
                d = eui1.d();
                break;

            case 32: // ' '
                e = eui1.d();
                break;

            case 40: // '('
                int k = eui1.d();
                if (k == 0 || k == 1 || k == 2 || k == 3)
                {
                    f = k;
                } else
                {
                    f = 0;
                }
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(1, b);
        }
        if (c != null)
        {
            int ai[] = c;
            int j = ai.length;
            for (int i = 0; i < j; i++)
            {
                euj1.a(2, ai[i]);
            }

        }
        if (d != 0)
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
            if (!(obj instanceof dfb))
            {
                return false;
            }
            obj = (dfb)obj;
            if ((b != null ? b.equals(((dfb) (obj)).b) : ((dfb) (obj)).b == null) && (Arrays.equals(c, ((dfb) (obj)).c) && d == ((dfb) (obj)).d && e == ((dfb) (obj)).e && f == ((dfb) (obj)).f))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dfb) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dfb) (obj)).O))
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
        boolean flag = false;
        j = getClass().getName().hashCode();
        int k;
        int i1;
        int j1;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        i += (j + 527) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        k = d;
        i1 = e;
        j1 = f;
        int l;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return (((j * 31 + k) * 31 + i1) * 31 + j1) * 31 + i;
_L2:
        l = 0;
_L5:
        j = i;
        if (l >= c.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + c[l];
        l++;
          goto _L5
    }

}
