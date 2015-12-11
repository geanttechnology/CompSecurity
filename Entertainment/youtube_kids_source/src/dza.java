// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dza extends eul
{

    public static final dza a[] = new dza[0];
    public String b;
    public boolean c;
    public boolean d;
    public dre e;
    public boolean f;
    private boolean g;

    public dza()
    {
        b = "";
        c = false;
        d = false;
        g = false;
        e = null;
        f = false;
    }

    public final int a()
    {
        int j = 0;
        if (!b.equals(""))
        {
            j = euj.b(1, b) + 0;
        }
        int i = j;
        if (c)
        {
            boolean flag = c;
            i = j + (euj.b(2) + 1);
        }
        j = i;
        if (d)
        {
            boolean flag1 = d;
            j = i + (euj.b(3) + 1);
        }
        i = j;
        if (g)
        {
            boolean flag2 = g;
            i = j + (euj.b(4) + 1);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(5, e);
        }
        i = j;
        if (f)
        {
            boolean flag3 = f;
            i = j + (euj.b(6) + 1);
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
                b = eui1.f();
                break;

            case 16: // '\020'
                c = eui1.e();
                break;

            case 24: // '\030'
                d = eui1.e();
                break;

            case 32: // ' '
                g = eui1.e();
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dre();
                }
                eui1.a(e);
                break;

            case 48: // '0'
                f = eui1.e();
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
        if (c)
        {
            euj1.a(2, c);
        }
        if (d)
        {
            euj1.a(3, d);
        }
        if (g)
        {
            euj1.a(4, g);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f)
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
            if (!(obj instanceof dza))
            {
                return false;
            }
            obj = (dza)obj;
            if ((b != null ? b.equals(((dza) (obj)).b) : ((dza) (obj)).b == null) && (c == ((dza) (obj)).c && d == ((dza) (obj)).d && g == ((dza) (obj)).g) && (e != null ? e.equals(((dza) (obj)).e) : ((dza) (obj)).e == null) && f == ((dza) (obj)).f)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dza) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dza) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k1 = 0;
        int j1 = 1;
        int l1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
        int i1;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (c)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        if (d)
        {
            k = 1;
        } else
        {
            k = 2;
        }
        if (g)
        {
            l = 1;
        } else
        {
            l = 2;
        }
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        if (!f)
        {
            j1 = 2;
        }
        if (O != null)
        {
            k1 = O.hashCode();
        }
        return ((i1 + (l + (k + (j + (i + (l1 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + j1) * 31 + k1;
    }

}
