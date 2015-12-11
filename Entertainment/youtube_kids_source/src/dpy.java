// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dpy extends eul
{

    private String a;
    private boolean b;
    private int c;
    private dlb d;

    public dpy()
    {
        a = "";
        b = false;
        c = 0;
        d = null;
    }

    public final int a()
    {
        int j = 0;
        if (!a.equals(""))
        {
            j = euj.b(2, a) + 0;
        }
        int i = j;
        if (b)
        {
            boolean flag = b;
            i = j + (euj.b(3) + 1);
        }
        j = i;
        if (c != 0)
        {
            j = i + euj.c(4, c);
        }
        i = j;
        if (d != null)
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

            case 18: // '\022'
                a = eui1.f();
                break;

            case 24: // '\030'
                b = eui1.e();
                break;

            case 32: // ' '
                c = eui1.d();
                break;

            case 42: // '*'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!a.equals(""))
        {
            euj1.a(2, a);
        }
        if (b)
        {
            euj1.a(3, b);
        }
        if (c != 0)
        {
            euj1.a(4, c);
        }
        if (d != null)
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
            if (!(obj instanceof dpy))
            {
                return false;
            }
            obj = (dpy)obj;
            if ((a != null ? a.equals(((dpy) (obj)).a) : ((dpy) (obj)).a == null) && (b == ((dpy) (obj)).b && c == ((dpy) (obj)).c) && (d != null ? d.equals(((dpy) (obj)).d) : ((dpy) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dpy) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dpy) (obj)).O))
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
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        if (b)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        j1 = c;
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
        return (k + ((j + (i + (i1 + 527) * 31) * 31) * 31 + j1) * 31) * 31 + l;
    }
}
