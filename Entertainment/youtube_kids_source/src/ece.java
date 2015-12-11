// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ece extends eul
{

    public static final ece a[] = new ece[0];
    public byte b[];
    private int c;
    private int d;
    private int e[];

    public ece()
    {
        b = eup.f;
        c = 0;
        d = 0;
        e = eup.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        if (!Arrays.equals(b, eup.f))
        {
            i = euj.b(1, b) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (c != 0)
        {
            j = i + euj.c(2, c);
        }
        i = j;
        if (d != 0)
        {
            i = j + euj.c(3, d);
        }
        j = i;
        if (e != null)
        {
            j = i;
            if (e.length > 0)
            {
                int ai[] = e;
                int l = ai.length;
                int k = 0;
                for (j = ((flag) ? 1 : 0); j < l; j++)
                {
                    k += euj.a(ai[j]);
                }

                j = i + k + e.length * 1;
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

            case 10: // '\n'
                b = eui1.g();
                break;

            case 16: // '\020'
                c = eui1.d();
                break;

            case 24: // '\030'
                d = eui1.d();
                break;

            case 32: // ' '
                int k = eup.a(eui1, 32);
                int j = e.length;
                int ai[] = new int[k + j];
                System.arraycopy(e, 0, ai, 0, j);
                for (e = ai; j < e.length - 1; j++)
                {
                    e[j] = eui1.d();
                    eui1.a();
                }

                e[j] = eui1.d();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(1, b);
        }
        if (c != 0)
        {
            euj1.a(2, c);
        }
        if (d != 0)
        {
            euj1.a(3, d);
        }
        if (e != null)
        {
            int ai[] = e;
            int j = ai.length;
            for (int i = 0; i < j; i++)
            {
                euj1.a(4, ai[i]);
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
        if (!(obj instanceof ece))
        {
            return false;
        }
        obj = (ece)obj;
        if (!Arrays.equals(b, ((ece) (obj)).b) || c != ((ece) (obj)).c || d != ((ece) (obj)).d || !Arrays.equals(e, ((ece) (obj)).e))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ece) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ece) (obj)).O))
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
        if (b != null) goto _L2; else goto _L1
_L1:
        int k = i * 31;
_L6:
        i = (k * 31 + c) * 31 + d;
        if (e != null) goto _L4; else goto _L3
_L3:
        int j = i * 31;
_L9:
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return j * 31 + i;
_L2:
        j = 0;
_L7:
        k = i;
        if (j >= b.length) goto _L6; else goto _L5
_L5:
        i = i * 31 + b[j];
        j++;
          goto _L7
          goto _L6
_L4:
        k = 0;
_L10:
        j = i;
        if (k >= e.length) goto _L9; else goto _L8
_L8:
        i = i * 31 + e[k];
        k++;
          goto _L10
    }

}
