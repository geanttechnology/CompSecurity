// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dnp extends eul
{

    public static final dnp a[] = new dnp[0];
    public ebz b;
    public dwh c;
    public long d;
    public dwf e;
    public dha f;
    private dgx g;
    private int h;

    public dnp()
    {
        b = null;
        c = null;
        g = null;
        d = 0L;
        e = null;
        f = null;
        h = 0;
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
        if (g != null)
        {
            j = i + euj.b(3, g);
        }
        i = j;
        if (d != 0L)
        {
            i = j + euj.c(4, d);
        }
        j = i;
        if (e != null)
        {
            j = i + euj.b(5, e);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(6, f);
        }
        j = i;
        if (h != 0)
        {
            j = i + euj.d(7, h);
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
                if (b == null)
                {
                    b = new ebz();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dwh();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (g == null)
                {
                    g = new dgx();
                }
                eui1.a(g);
                break;

            case 32: // ' '
                d = eui1.b();
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dwf();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                if (f == null)
                {
                    f = new dha();
                }
                eui1.a(f);
                break;

            case 56: // '8'
                h = eui1.h();
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
        if (g != null)
        {
            euj1.a(3, g);
        }
        if (d != 0L)
        {
            euj1.a(4, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (f != null)
        {
            euj1.a(6, f);
        }
        if (h != 0)
        {
            euj1.b(7, h);
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
            if (!(obj instanceof dnp))
            {
                return false;
            }
            obj = (dnp)obj;
            if ((b != null ? b.equals(((dnp) (obj)).b) : ((dnp) (obj)).b == null) && (c != null ? c.equals(((dnp) (obj)).c) : ((dnp) (obj)).c == null) && (g != null ? g.equals(((dnp) (obj)).g) : ((dnp) (obj)).g == null) && d == ((dnp) (obj)).d && (e != null ? e.equals(((dnp) (obj)).e) : ((dnp) (obj)).e == null) && (f != null ? f.equals(((dnp) (obj)).f) : ((dnp) (obj)).f == null) && h == ((dnp) (obj)).h)
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dnp) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dnp) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j1 = 0;
        int k1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
        int i1;
        int l1;
        int i2;
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
        if (g == null)
        {
            k = 0;
        } else
        {
            k = g.hashCode();
        }
        l1 = (int)(d ^ d >>> 32);
        if (e == null)
        {
            l = 0;
        } else
        {
            l = e.hashCode();
        }
        if (f == null)
        {
            i1 = 0;
        } else
        {
            i1 = f.hashCode();
        }
        i2 = h;
        if (O != null)
        {
            j1 = O.hashCode();
        }
        return ((i1 + (l + ((k + (j + (i + (k1 + 527) * 31) * 31) * 31) * 31 + l1) * 31) * 31) * 31 + i2) * 31 + j1;
    }

}
