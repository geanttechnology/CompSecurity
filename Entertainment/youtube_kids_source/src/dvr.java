// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dvr extends eul
{

    public long a;
    public long b;
    private int c;
    private int d;

    public dvr()
    {
        c = 0;
        d = 0;
        a = 0L;
        b = 0L;
    }

    public final int a()
    {
        int j = 0;
        if (c != 0)
        {
            j = euj.c(1, c) + 0;
        }
        int i = j;
        if (d != 0)
        {
            i = j + euj.c(2, d);
        }
        j = i;
        if (a != 0L)
        {
            j = i + euj.d(3, a);
        }
        i = j;
        if (b != 0L)
        {
            i = j + euj.d(4, b);
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
                c = eui1.d();
                break;

            case 16: // '\020'
                d = eui1.d();
                break;

            case 24: // '\030'
                a = eui1.c();
                break;

            case 32: // ' '
                b = eui1.c();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (c != 0)
        {
            euj1.a(1, c);
        }
        if (d != 0)
        {
            euj1.a(2, d);
        }
        if (a != 0L)
        {
            euj1.b(3, a);
        }
        if (b != 0L)
        {
            euj1.b(4, b);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dvr))
        {
            return false;
        }
        obj = (dvr)obj;
        if (c != ((dvr) (obj)).c || d != ((dvr) (obj)).d || a != ((dvr) (obj)).a || b != ((dvr) (obj)).b)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dvr) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dvr) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j = getClass().getName().hashCode();
        int k = c;
        int l = d;
        int i1 = (int)(a ^ a >>> 32);
        int j1 = (int)(b ^ b >>> 32);
        int i;
        if (O == null)
        {
            i = 0;
        } else
        {
            i = O.hashCode();
        }
        return i + (((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31;
    }
}
