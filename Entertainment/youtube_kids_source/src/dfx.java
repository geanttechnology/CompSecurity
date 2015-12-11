// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dfx extends eul
{

    public dfy a;
    public dir b;
    public dfv c;
    public byte d[];
    private dwa e;
    private String f;
    private boolean g;

    public dfx()
    {
        e = null;
        f = "";
        a = null;
        b = null;
        c = null;
        d = eup.f;
        g = false;
    }

    public final int a()
    {
        int j = 0;
        if (e != null)
        {
            j = euj.b(1, e) + 0;
        }
        int i = j;
        if (!f.equals(""))
        {
            i = j + euj.b(5, f);
        }
        j = i;
        if (a != null)
        {
            j = i + euj.b(9, a);
        }
        i = j;
        if (b != null)
        {
            i = j + euj.b(10, b);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(13, c);
        }
        i = j;
        if (!Arrays.equals(d, eup.f))
        {
            i = j + euj.b(16, d);
        }
        j = i;
        if (g)
        {
            boolean flag = g;
            j = i + (euj.b(19) + 1);
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
                if (e == null)
                {
                    e = new dwa();
                }
                eui1.a(e);
                break;

            case 42: // '*'
                f = eui1.f();
                break;

            case 74: // 'J'
                if (a == null)
                {
                    a = new dfy();
                }
                eui1.a(a);
                break;

            case 82: // 'R'
                if (b == null)
                {
                    b = new dir();
                }
                eui1.a(b);
                break;

            case 106: // 'j'
                if (c == null)
                {
                    c = new dfv();
                }
                eui1.a(c);
                break;

            case 130: 
                d = eui1.g();
                break;

            case 152: 
                g = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (e != null)
        {
            euj1.a(1, e);
        }
        if (!f.equals(""))
        {
            euj1.a(5, f);
        }
        if (a != null)
        {
            euj1.a(9, a);
        }
        if (b != null)
        {
            euj1.a(10, b);
        }
        if (c != null)
        {
            euj1.a(13, c);
        }
        if (!Arrays.equals(d, eup.f))
        {
            euj1.a(16, d);
        }
        if (g)
        {
            euj1.a(19, g);
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
            if (!(obj instanceof dfx))
            {
                return false;
            }
            obj = (dfx)obj;
            if ((e != null ? e.equals(((dfx) (obj)).e) : ((dfx) (obj)).e == null) && (f != null ? f.equals(((dfx) (obj)).f) : ((dfx) (obj)).f == null) && (a != null ? a.equals(((dfx) (obj)).a) : ((dfx) (obj)).a == null) && (b != null ? b.equals(((dfx) (obj)).b) : ((dfx) (obj)).b == null) && (c != null ? c.equals(((dfx) (obj)).c) : ((dfx) (obj)).c == null) && (Arrays.equals(d, ((dfx) (obj)).d) && g == ((dfx) (obj)).g))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dfx) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dfx) (obj)).O))
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
        int k;
        boolean flag = false;
        int j1 = getClass().getName().hashCode();
        int l;
        int i1;
        if (e == null)
        {
            i = 0;
        } else
        {
            i = e.hashCode();
        }
        if (f == null)
        {
            j = 0;
        } else
        {
            j = f.hashCode();
        }
        if (a == null)
        {
            k = 0;
        } else
        {
            k = a.hashCode();
        }
        if (b == null)
        {
            l = 0;
        } else
        {
            l = b.hashCode();
        }
        if (c == null)
        {
            i1 = 0;
        } else
        {
            i1 = c.hashCode();
        }
        i = i1 + (l + (k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31) * 31;
        if (d != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        if (g)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return (i + j * 31) * 31 + k;
_L2:
        k = 0;
_L5:
        j = i;
        if (k >= d.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + d[k];
        k++;
          goto _L5
    }
}
