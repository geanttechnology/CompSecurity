// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dwg extends eul
{

    private byte a[][];
    private String b;

    public dwg()
    {
        a = eup.e;
        b = "";
    }

    public final int a()
    {
        int j = 0;
        boolean flag = false;
        int i = j;
        if (a != null)
        {
            i = j;
            if (a.length > 0)
            {
                byte abyte0[][] = a;
                int k = abyte0.length;
                j = 0;
                for (i = ((flag) ? 1 : 0); i < k; i++)
                {
                    j += euj.a(abyte0[i]);
                }

                i = j + 0 + a.length * 1;
            }
        }
        j = i;
        if (!b.equals(""))
        {
            j = i + euj.b(2, b);
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
                int k = eup.a(eui1, 10);
                int j = a.length;
                byte abyte0[][] = new byte[k + j][];
                System.arraycopy(a, 0, abyte0, 0, j);
                for (a = abyte0; j < a.length - 1; j++)
                {
                    a[j] = eui1.g();
                    eui1.a();
                }

                a[j] = eui1.g();
                break;

            case 18: // '\022'
                b = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            byte abyte0[][] = a;
            int j = abyte0.length;
            for (int i = 0; i < j; i++)
            {
                euj1.a(1, abyte0[i]);
            }

        }
        if (!b.equals(""))
        {
            euj1.a(2, b);
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
            if (!(obj instanceof dwg))
            {
                return false;
            }
            obj = (dwg)obj;
            if (Arrays.equals(a, ((dwg) (obj)).a) && (b != null ? b.equals(((dwg) (obj)).b) : ((dwg) (obj)).b == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dwg) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dwg) (obj)).O))
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
        int k = i * 31;
_L4:
        int j;
        byte byte0;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (O == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = O.hashCode();
        }
        return (i + k * 31) * 31 + j;
_L2:
        j = 0;
_L5:
        k = i;
        if (j >= a.length) goto _L4; else goto _L3
_L3:
        for (k = 0; k < a[j].length;)
        {
            byte0 = a[j][k];
            k++;
            i = byte0 + i * 31;
        }

        j++;
          goto _L5
    }
}
