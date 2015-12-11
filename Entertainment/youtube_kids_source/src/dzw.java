// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dzw extends eul
{

    public static final dzw a[] = new dzw[0];
    public String b;
    public int c;

    public dzw()
    {
        b = "";
        c = 0;
    }

    public final int a()
    {
        int i = 0;
        if (!b.equals(""))
        {
            i = euj.b(1, b) + 0;
        }
        int j = i;
        if (c != 0)
        {
            j = i + euj.c(2, c);
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
                b = eui1.f();
                break;

            case 16: // '\020'
                c = eui1.d();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!b.equals(""))
        {
            euj1.a(1, b);
        }
        if (c != 0)
        {
            euj1.a(2, c);
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
            if (!(obj instanceof dzw))
            {
                return false;
            }
            obj = (dzw)obj;
            if ((b != null ? b.equals(((dzw) (obj)).b) : ((dzw) (obj)).b == null) && c == ((dzw) (obj)).c)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dzw) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dzw) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j = 0;
        int k = getClass().getName().hashCode();
        int i;
        int l;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        l = c;
        if (O != null)
        {
            j = O.hashCode();
        }
        return ((i + (k + 527) * 31) * 31 + l) * 31 + j;
    }

}
