// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dpv extends eul
{

    public static final dpv a[] = new dpv[0];
    private dlb b;
    private dlb c;
    private int d;
    private boolean e;

    public dpv()
    {
        b = null;
        c = null;
        d = 0;
        e = false;
    }

    public final int a()
    {
        int j = 0;
        if (b != null)
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (c != null)
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (d != 0)
        {
            j = i + euj.c(3, d);
        }
        i = j;
        if (e)
        {
            boolean flag = e;
            i = j + (euj.b(4) + 1);
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

            case 10: // '\n'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 24: // '\030'
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2)
                {
                    d = j;
                } else
                {
                    d = 0;
                }
                break;

            case 32: // ' '
                e = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != null)
        {
            euj1.a(1, b);
        }
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (d != 0)
        {
            euj1.a(3, d);
        }
        if (e)
        {
            euj1.a(4, e);
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
            if (!(obj instanceof dpv))
            {
                return false;
            }
            obj = (dpv)obj;
            if ((b != null ? b.equals(((dpv) (obj)).b) : ((dpv) (obj)).b == null) && (c != null ? c.equals(((dpv) (obj)).c) : ((dpv) (obj)).c == null) && (d == ((dpv) (obj)).d && e == ((dpv) (obj)).e))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dpv) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dpv) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int l = 0;
        int i1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int j1;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (c == null)
        {
            j = 0;
        } else
        {
            j = c.hashCode();
        }
        j1 = d;
        if (e)
        {
            k = 1;
        } else
        {
            k = 2;
        }
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + ((j + (i + (i1 + 527) * 31) * 31) * 31 + j1) * 31) * 31 + l;
    }

}
