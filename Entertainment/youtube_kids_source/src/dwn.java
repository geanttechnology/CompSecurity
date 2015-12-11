// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dwn extends eul
{

    public dwo a;
    public dir b;
    public byte c[];
    private dwa d;
    private long e;
    private String f;
    private String g;

    public dwn()
    {
        d = null;
        e = 0L;
        f = "";
        a = null;
        g = "";
        b = null;
        c = eup.f;
    }

    public final int a()
    {
        int j = 0;
        if (d != null)
        {
            j = euj.b(1, d) + 0;
        }
        int i = j;
        if (e != 0L)
        {
            i = j + euj.d(2, e);
        }
        j = i;
        if (!f.equals(""))
        {
            j = i + euj.b(3, f);
        }
        i = j;
        if (a != null)
        {
            i = j + euj.b(4, a);
        }
        j = i;
        if (!g.equals(""))
        {
            j = i + euj.b(5, g);
        }
        i = j;
        if (b != null)
        {
            i = j + euj.b(7, b);
        }
        j = i;
        if (!Arrays.equals(c, eup.f))
        {
            j = i + euj.b(9, c);
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
                if (d == null)
                {
                    d = new dwa();
                }
                eui1.a(d);
                break;

            case 16: // '\020'
                e = eui1.c();
                break;

            case 26: // '\032'
                f = eui1.f();
                break;

            case 34: // '"'
                if (a == null)
                {
                    a = new dwo();
                }
                eui1.a(a);
                break;

            case 42: // '*'
                g = eui1.f();
                break;

            case 58: // ':'
                if (b == null)
                {
                    b = new dir();
                }
                eui1.a(b);
                break;

            case 74: // 'J'
                c = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (d != null)
        {
            euj1.a(1, d);
        }
        if (e != 0L)
        {
            euj1.b(2, e);
        }
        if (!f.equals(""))
        {
            euj1.a(3, f);
        }
        if (a != null)
        {
            euj1.a(4, a);
        }
        if (!g.equals(""))
        {
            euj1.a(5, g);
        }
        if (b != null)
        {
            euj1.a(7, b);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(9, c);
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
            if (!(obj instanceof dwn))
            {
                return false;
            }
            obj = (dwn)obj;
            if ((d != null ? d.equals(((dwn) (obj)).d) : ((dwn) (obj)).d == null) && e == ((dwn) (obj)).e && (f != null ? f.equals(((dwn) (obj)).f) : ((dwn) (obj)).f == null) && (a != null ? a.equals(((dwn) (obj)).a) : ((dwn) (obj)).a == null) && (g != null ? g.equals(((dwn) (obj)).g) : ((dwn) (obj)).g == null) && (b != null ? b.equals(((dwn) (obj)).b) : ((dwn) (obj)).b == null) && Arrays.equals(c, ((dwn) (obj)).c))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dwn) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dwn) (obj)).O))
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
        int k1 = getClass().getName().hashCode();
        int k;
        int i1;
        int j1;
        int l1;
        if (d == null)
        {
            i = 0;
        } else
        {
            i = d.hashCode();
        }
        l1 = (int)(e ^ e >>> 32);
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
        if (g == null)
        {
            i1 = 0;
        } else
        {
            i1 = g.hashCode();
        }
        if (b == null)
        {
            j1 = 0;
        } else
        {
            j1 = b.hashCode();
        }
        i = j1 + (i1 + (k + (j + ((i + (k1 + 527) * 31) * 31 + l1) * 31) * 31) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
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
        if (l >= c.length) goto _L4; else goto _L3
_L3:
        i = i * 31 + c[l];
        l++;
          goto _L5
    }
}
