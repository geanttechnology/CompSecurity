// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dmb extends eul
{

    public int a;

    public dmb()
    {
        a = 0;
    }

    public final int a()
    {
        int i = 0;
        if (a != 0)
        {
            i = euj.c(1, a) + 0;
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
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2 || j == 3 || j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10 || j == 11 || j == 12 || j == 13 || j == 14 || j == 15 || j == 16 || j == 17 || j == 18 || j == 19 || j == 20 || j == 21 || j == 22 || j == 23 || j == 24 || j == 25 || j == 26 || j == 27 || j == 28 || j == 29 || j == 30 || j == 31 || j == 32 || j == 33 || j == 34 || j == 35 || j == 36 || j == 37 || j == 38 || j == 39 || j == 40 || j == 41 || j == 42 || j == 43 || j == 44 || j == 45 || j == 46 || j == 47 || j == 48 || j == 49 || j == 50 || j == 51 || j == 52 || j == 53 || j == 54 || j == 55 || j == 56 || j == 57 || j == 58 || j == 59 || j == 60 || j == 61 || j == 62 || j == 63 || j == 64 || j == 65 || j == 66 || j == 67 || j == 68 || j == 69 || j == 70 || j == 71 || j == 72 || j == 73 || j == 74 || j == 75 || j == 76 || j == 77 || j == 78 || j == 79 || j == 80 || j == 81 || j == 82 || j == 83 || j == 84 || j == 85 || j == 86 || j == 87 || j == 88)
                {
                    a = j;
                } else
                {
                    a = 0;
                }
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != 0)
        {
            euj1.a(1, a);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dmb))
        {
            return false;
        }
        obj = (dmb)obj;
        if (a != ((dmb) (obj)).a)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmb) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmb) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j = getClass().getName().hashCode();
        int k = a;
        int i;
        if (O == null)
        {
            i = 0;
        } else
        {
            i = O.hashCode();
        }
        return i + ((j + 527) * 31 + k) * 31;
    }
}
