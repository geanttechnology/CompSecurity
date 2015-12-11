// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dwh extends eul
{

    public int a;
    public byte b[];
    public String c;
    private byte d[][];
    private ece e[];
    private ece f;

    public dwh()
    {
        a = 0;
        d = eup.e;
        e = ece.a;
        b = eup.f;
        c = "";
        f = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        if (a != 0)
        {
            j = euj.c(1, a) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (d != null)
        {
            i = j;
            if (d.length > 0)
            {
                byte abyte0[][] = d;
                int i1 = abyte0.length;
                i = 0;
                int k = 0;
                for (; i < i1; i++)
                {
                    k += euj.a(abyte0[i]);
                }

                i = j + k + d.length * 1;
            }
        }
        j = i;
        if (e != null)
        {
            ece aece[] = e;
            int j1 = aece.length;
            int l = ((flag) ? 1 : 0);
            do
            {
                j = i;
                if (l >= j1)
                {
                    break;
                }
                ece ece1 = aece[l];
                j = i;
                if (ece1 != null)
                {
                    j = i + euj.b(3, ece1);
                }
                l++;
                i = j;
            } while (true);
        }
        i = j;
        if (!Arrays.equals(b, eup.f))
        {
            i = j + euj.b(4, b);
        }
        j = i;
        if (!c.equals(""))
        {
            j = i + euj.b(5, c);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(6, f);
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
                a = eui1.d();
                break;

            case 18: // '\022'
                int l = eup.a(eui1, 18);
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

            case 26: // '\032'
                int i1 = eup.a(eui1, 26);
                ece aece[];
                int k;
                if (e == null)
                {
                    k = 0;
                } else
                {
                    k = e.length;
                }
                aece = new ece[i1 + k];
                if (e != null)
                {
                    System.arraycopy(e, 0, aece, 0, k);
                }
                for (e = aece; k < e.length - 1; k++)
                {
                    e[k] = new ece();
                    eui1.a(e[k]);
                    eui1.a();
                }

                e[k] = new ece();
                eui1.a(e[k]);
                break;

            case 34: // '"'
                b = eui1.g();
                break;

            case 42: // '*'
                c = eui1.f();
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new ece();
                }
                eui1.a(f);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != 0)
        {
            euj1.a(1, a);
        }
        if (d != null)
        {
            byte abyte0[][] = d;
            int k = abyte0.length;
            for (int i = 0; i < k; i++)
            {
                euj1.a(2, abyte0[i]);
            }

        }
        if (e != null)
        {
            ece aece[] = e;
            int l = aece.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                ece ece1 = aece[j];
                if (ece1 != null)
                {
                    euj1.a(3, ece1);
                }
            }

        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(4, b);
        }
        if (!c.equals(""))
        {
            euj1.a(5, c);
        }
        if (f != null)
        {
            euj1.a(6, f);
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
            if (!(obj instanceof dwh))
            {
                return false;
            }
            obj = (dwh)obj;
            if (a == ((dwh) (obj)).a && Arrays.equals(d, ((dwh) (obj)).d) && Arrays.equals(e, ((dwh) (obj)).e) && Arrays.equals(b, ((dwh) (obj)).b) && (c != null ? c.equals(((dwh) (obj)).c) : ((dwh) (obj)).c == null) && (f != null ? f.equals(((dwh) (obj)).f) : ((dwh) (obj)).f == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dwh) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dwh) (obj)).O))
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
        l = 0;
        i = (getClass().getName().hashCode() + 527) * 31 + a;
        if (d != null) goto _L2; else goto _L1
_L1:
        int j = i * 31;
_L8:
        if (e != null) goto _L4; else goto _L3
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
        if (f == null)
        {
            k = 0;
        } else
        {
            k = f.hashCode();
        }
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + (j + i * 31) * 31) * 31 + l;
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
        if (k >= b.length) goto _L14; else goto _L13
_L13:
        j = j * 31 + b[k];
        k++;
          goto _L15
    }
}
