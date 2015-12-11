// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class eap extends eul
{

    public String a;
    private int b;
    private boolean c;
    private String d;

    public eap()
    {
        a = "";
        b = 0;
        c = false;
        d = "";
    }

    public final int a()
    {
        int j = 0;
        if (!a.equals(""))
        {
            j = euj.b(3, a) + 0;
        }
        int i = j;
        if (b != 0)
        {
            i = j + euj.c(5, b);
        }
        j = i;
        if (c)
        {
            boolean flag = c;
            j = i + (euj.b(7) + 1);
        }
        i = j;
        if (!d.equals(""))
        {
            i = j + euj.b(10, d);
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

            case 26: // '\032'
                a = eui1.f();
                break;

            case 40: // '('
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2)
                {
                    b = j;
                } else
                {
                    b = 0;
                }
                break;

            case 56: // '8'
                c = eui1.e();
                break;

            case 82: // 'R'
                d = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!a.equals(""))
        {
            euj1.a(3, a);
        }
        if (b != 0)
        {
            euj1.a(5, b);
        }
        if (c)
        {
            euj1.a(7, c);
        }
        if (!d.equals(""))
        {
            euj1.a(10, d);
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
            if (!(obj instanceof eap))
            {
                return false;
            }
            obj = (eap)obj;
            if ((a != null ? a.equals(((eap) (obj)).a) : ((eap) (obj)).a == null) && (b == ((eap) (obj)).b && c == ((eap) (obj)).c) && (d != null ? d.equals(((eap) (obj)).d) : ((eap) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((eap) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((eap) (obj)).O))
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
        j1 = b;
        if (c)
        {
            j = 1;
        } else
        {
            j = 2;
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
        return (k + (j + ((i + (i1 + 527) * 31) * 31 + j1) * 31) * 31) * 31 + l;
    }
}
