// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dtp extends eul
{

    private long a;
    private long b;
    private dzp c;
    private byte d[];

    public dtp()
    {
        a = 0L;
        b = 0L;
        c = null;
        d = eup.f;
    }

    public final int a()
    {
        int j = 0;
        if (a != 0L)
        {
            j = euj.d(1, a) + 0;
        }
        int i = j;
        if (b != 0L)
        {
            i = j + euj.d(2, b);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(3, c);
        }
        i = j;
        if (!Arrays.equals(d, eup.f))
        {
            i = j + euj.b(5, d);
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
                a = eui1.c();
                break;

            case 16: // '\020'
                b = eui1.c();
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dzp();
                }
                eui1.a(c);
                break;

            case 42: // '*'
                d = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != 0L)
        {
            euj1.b(1, a);
        }
        if (b != 0L)
        {
            euj1.b(2, b);
        }
        if (c != null)
        {
            euj1.a(3, c);
        }
        if (!Arrays.equals(d, eup.f))
        {
            euj1.a(5, d);
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
            if (!(obj instanceof dtp))
            {
                return false;
            }
            obj = (dtp)obj;
            if (a == ((dtp) (obj)).a && b == ((dtp) (obj)).b && (c != null ? c.equals(((dtp) (obj)).c) : ((dtp) (obj)).c == null) && Arrays.equals(d, ((dtp) (obj)).d))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dtp) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dtp) (obj)).O))
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
        int k = (int)(a ^ a >>> 32);
        int i1 = (int)(b ^ b >>> 32);
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        i += (((j + 527) * 31 + k) * 31 + i1) * 31;
        if (d != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        int l;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return j * 31 + i;
_L2:
        l = 0;
_L5:
        j = i;
        if (l >= d.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + d[l];
        l++;
          goto _L5
    }
}
