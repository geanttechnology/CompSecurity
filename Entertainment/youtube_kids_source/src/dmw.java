// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dmw extends eul
{

    public static final dmw a[] = new dmw[0];
    private long b;
    private long c;
    private long d;

    public dmw()
    {
        b = 0L;
        c = 0L;
        d = 0L;
    }

    public final int a()
    {
        int j = 0;
        if (b != 0L)
        {
            j = euj.c(1, b) + 0;
        }
        int i = j;
        if (c != 0L)
        {
            i = j + euj.c(2, c);
        }
        j = i;
        if (d != 0L)
        {
            j = i + euj.c(3, d);
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
                b = eui1.b();
                break;

            case 16: // '\020'
                c = eui1.b();
                break;

            case 24: // '\030'
                d = eui1.b();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != 0L)
        {
            euj1.a(1, b);
        }
        if (c != 0L)
        {
            euj1.a(2, c);
        }
        if (d != 0L)
        {
            euj1.a(3, d);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dmw))
        {
            return false;
        }
        obj = (dmw)obj;
        if (b != ((dmw) (obj)).b || c != ((dmw) (obj)).c || d != ((dmw) (obj)).d)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmw) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmw) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j = getClass().getName().hashCode();
        int k = (int)(b ^ b >>> 32);
        int l = (int)(c ^ c >>> 32);
        int i1 = (int)(d ^ d >>> 32);
        int i;
        if (O == null)
        {
            i = 0;
        } else
        {
            i = O.hashCode();
        }
        return i + ((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31;
    }

}
