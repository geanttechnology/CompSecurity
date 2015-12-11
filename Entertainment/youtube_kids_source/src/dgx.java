// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dgx extends eul
{

    private byte a[];
    private ece b[];
    private String c;
    private ece d;

    public dgx()
    {
        a = eup.f;
        b = ece.a;
        c = "";
        d = null;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (!Arrays.equals(a, eup.f))
        {
            i = euj.b(1, a) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (b != null)
        {
            ece aece[] = b;
            int l = aece.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                ece ece1 = aece[k];
                j = i;
                if (ece1 != null)
                {
                    j = i + euj.b(2, ece1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (!c.equals(""))
        {
            i = j + euj.b(3, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(4, d);
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
                a = eui1.g();
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                ece aece[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                aece = new ece[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, aece, 0, j);
                }
                for (b = aece; j < b.length - 1; j++)
                {
                    b[j] = new ece();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new ece();
                eui1.a(b[j]);
                break;

            case 26: // '\032'
                c = eui1.f();
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new ece();
                }
                eui1.a(d);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!Arrays.equals(a, eup.f))
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            ece aece[] = b;
            int j = aece.length;
            for (int i = 0; i < j; i++)
            {
                ece ece1 = aece[i];
                if (ece1 != null)
                {
                    euj1.a(2, ece1);
                }
            }

        }
        if (!c.equals(""))
        {
            euj1.a(3, c);
        }
        if (d != null)
        {
            euj1.a(4, d);
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
            if (!(obj instanceof dgx))
            {
                return false;
            }
            obj = (dgx)obj;
            if (Arrays.equals(a, ((dgx) (obj)).a) && Arrays.equals(b, ((dgx) (obj)).b) && (c != null ? c.equals(((dgx) (obj)).c) : ((dgx) (obj)).c == null) && (d != null ? d.equals(((dgx) (obj)).d) : ((dgx) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dgx) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dgx) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j;
        int l;
        l = 0;
        j = getClass().getName().hashCode() + 527;
        if (a != null) goto _L2; else goto _L1
_L1:
        int i = j * 31;
_L6:
        if (b != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L9:
        int k;
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
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + (i + j * 31) * 31) * 31 + l;
_L2:
        k = 0;
_L7:
        i = j;
        if (k >= a.length) goto _L6; else goto _L5
_L5:
        j = j * 31 + a[k];
        k++;
          goto _L7
          goto _L6
_L4:
        k = 0;
_L10:
        j = i;
        if (k >= b.length) goto _L9; else goto _L8
_L8:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L10
    }
}
