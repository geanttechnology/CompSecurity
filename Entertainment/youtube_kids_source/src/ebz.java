// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ebz extends eul
{

    public ece a[];
    public byte b[];
    public String c;
    private byte d[][];

    public ebz()
    {
        d = eup.e;
        a = ece.a;
        b = eup.f;
        c = "";
    }

    public final int a()
    {
        int l = 0;
        int i;
        int k;
        if (d != null && d.length > 0)
        {
            byte abyte0[][] = d;
            int i1 = abyte0.length;
            i = 0;
            int j = 0;
            for (; i < i1; i++)
            {
                j += euj.a(abyte0[i]);
            }

            i = j + 0 + d.length * 1;
        } else
        {
            i = 0;
        }
        k = i;
        if (a != null)
        {
            ece aece[] = a;
            int j1 = aece.length;
            do
            {
                k = i;
                if (l >= j1)
                {
                    break;
                }
                ece ece1 = aece[l];
                k = i;
                if (ece1 != null)
                {
                    k = i + euj.b(2, ece1);
                }
                l++;
                i = k;
            } while (true);
        }
        i = k;
        if (!Arrays.equals(b, eup.f))
        {
            i = k + euj.b(3, b);
        }
        k = i;
        if (!c.equals(""))
        {
            k = i + euj.b(4, c);
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
                int l = eup.a(eui1, 10);
                int j = d.length;
                byte abyte0[][] = new byte[l + j][];
                System.arraycopy(d, 0, abyte0, 0, j);
                for (d = abyte0; j < d.length - 1; j++)
                {
                    d[j] = eui1.g();
                    eui1.a();
                }

                d[j] = eui1.g();
                break;

            case 18: // '\022'
                int i1 = eup.a(eui1, 18);
                ece aece[];
                int k;
                if (a == null)
                {
                    k = 0;
                } else
                {
                    k = a.length;
                }
                aece = new ece[i1 + k];
                if (a != null)
                {
                    System.arraycopy(a, 0, aece, 0, k);
                }
                for (a = aece; k < a.length - 1; k++)
                {
                    a[k] = new ece();
                    eui1.a(a[k]);
                    eui1.a();
                }

                a[k] = new ece();
                eui1.a(a[k]);
                break;

            case 26: // '\032'
                b = eui1.g();
                break;

            case 34: // '"'
                c = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (d != null)
        {
            byte abyte0[][] = d;
            int k = abyte0.length;
            for (int i = 0; i < k; i++)
            {
                euj1.a(1, abyte0[i]);
            }

        }
        if (a != null)
        {
            ece aece[] = a;
            int l = aece.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                ece ece1 = aece[j];
                if (ece1 != null)
                {
                    euj1.a(2, ece1);
                }
            }

        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(3, b);
        }
        if (!c.equals(""))
        {
            euj1.a(4, c);
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
            if (!(obj instanceof ebz))
            {
                return false;
            }
            obj = (ebz)obj;
            if (Arrays.equals(d, ((ebz) (obj)).d) && Arrays.equals(a, ((ebz) (obj)).a) && Arrays.equals(b, ((ebz) (obj)).b) && (c != null ? c.equals(((ebz) (obj)).c) : ((ebz) (obj)).c == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ebz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ebz) (obj)).O))
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
_L8:
        if (a != null) goto _L4; else goto _L3
_L3:
        j *= 31;
_L11:
        if (b != null) goto _L6; else goto _L5
_L5:
        i = j * 31;
_L14:
        int k;
        byte byte0;
        if (c == null)
        {
            j = 0;
        } else
        {
            j = c.hashCode();
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
        if (k >= d.length) goto _L8; else goto _L7
_L7:
        for (j = 0; j < d[k].length;)
        {
            byte0 = d[k][j];
            j++;
            i = byte0 + i * 31;
        }

        k++;
          goto _L9
          goto _L8
_L4:
        k = 0;
        i = j;
_L12:
        j = i;
        if (k >= a.length) goto _L11; else goto _L10
_L10:
        if (a[k] == null)
        {
            j = 0;
        } else
        {
            j = a[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L12
          goto _L11
_L6:
        k = 0;
_L15:
        i = j;
        if (k >= b.length) goto _L14; else goto _L13
_L13:
        j = j * 31 + b[k];
        k++;
          goto _L15
    }
}
