// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ede extends eul
{

    public edf a;
    public dir b;
    public dre c;
    public byte d[];
    public dtv e;
    public eby f;
    private dwa g;
    private String h;
    private dil i;

    public ede()
    {
        g = null;
        h = "";
        a = null;
        b = null;
        c = null;
        d = eup.f;
        e = null;
        i = null;
        f = null;
    }

    public final int a()
    {
        int k = 0;
        if (g != null)
        {
            k = euj.b(1, g) + 0;
        }
        int j = k;
        if (!h.equals(""))
        {
            j = k + euj.b(6, h);
        }
        k = j;
        if (a != null)
        {
            k = j + euj.b(7, a);
        }
        j = k;
        if (b != null)
        {
            j = k + euj.b(8, b);
        }
        k = j;
        if (c != null)
        {
            k = j + euj.b(9, c);
        }
        j = k;
        if (!Arrays.equals(d, eup.f))
        {
            j = k + euj.b(13, d);
        }
        k = j;
        if (e != null)
        {
            k = j + euj.b(14, e);
        }
        j = k;
        if (i != null)
        {
            j = k + euj.b(15, i);
        }
        k = j;
        if (f != null)
        {
            k = j + euj.b(16, f);
        }
        j = k + eup.a(O);
        P = j;
        return j;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int j = eui1.a();
            switch (j)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, j))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                if (g == null)
                {
                    g = new dwa();
                }
                eui1.a(g);
                break;

            case 50: // '2'
                h = eui1.f();
                break;

            case 58: // ':'
                if (a == null)
                {
                    a = new edf();
                }
                eui1.a(a);
                break;

            case 66: // 'B'
                if (b == null)
                {
                    b = new dir();
                }
                eui1.a(b);
                break;

            case 74: // 'J'
                if (c == null)
                {
                    c = new dre();
                }
                eui1.a(c);
                break;

            case 106: // 'j'
                d = eui1.g();
                break;

            case 114: // 'r'
                if (e == null)
                {
                    e = new dtv();
                }
                eui1.a(e);
                break;

            case 122: // 'z'
                if (i == null)
                {
                    i = new dil();
                }
                eui1.a(i);
                break;

            case 130: 
                if (f == null)
                {
                    f = new eby();
                }
                eui1.a(f);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (g != null)
        {
            euj1.a(1, g);
        }
        if (!h.equals(""))
        {
            euj1.a(6, h);
        }
        if (a != null)
        {
            euj1.a(7, a);
        }
        if (b != null)
        {
            euj1.a(8, b);
        }
        if (c != null)
        {
            euj1.a(9, c);
        }
        if (!Arrays.equals(d, eup.f))
        {
            euj1.a(13, d);
        }
        if (e != null)
        {
            euj1.a(14, e);
        }
        if (i != null)
        {
            euj1.a(15, i);
        }
        if (f != null)
        {
            euj1.a(16, f);
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
            if (!(obj instanceof ede))
            {
                return false;
            }
            obj = (ede)obj;
            if ((g != null ? g.equals(((ede) (obj)).g) : ((ede) (obj)).g == null) && (h != null ? h.equals(((ede) (obj)).h) : ((ede) (obj)).h == null) && (a != null ? a.equals(((ede) (obj)).a) : ((ede) (obj)).a == null) && (b != null ? b.equals(((ede) (obj)).b) : ((ede) (obj)).b == null) && (c != null ? c.equals(((ede) (obj)).c) : ((ede) (obj)).c == null) && Arrays.equals(d, ((ede) (obj)).d) && (e != null ? e.equals(((ede) (obj)).e) : ((ede) (obj)).e == null) && (i != null ? i.equals(((ede) (obj)).i) : ((ede) (obj)).i == null) && (f != null ? f.equals(((ede) (obj)).f) : ((ede) (obj)).f == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ede) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ede) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j;
        int k;
        int l;
        int i1;
        int j1;
        boolean flag = false;
        int k1 = getClass().getName().hashCode();
        if (g == null)
        {
            j = 0;
        } else
        {
            j = g.hashCode();
        }
        if (h == null)
        {
            k = 0;
        } else
        {
            k = h.hashCode();
        }
        if (a == null)
        {
            l = 0;
        } else
        {
            l = a.hashCode();
        }
        if (b == null)
        {
            i1 = 0;
        } else
        {
            i1 = b.hashCode();
        }
        if (c == null)
        {
            j1 = 0;
        } else
        {
            j1 = c.hashCode();
        }
        j = j1 + (i1 + (l + (k + (j + (k1 + 527) * 31) * 31) * 31) * 31) * 31;
        if (d != null) goto _L2; else goto _L1
_L1:
        k = j * 31;
_L4:
        if (e == null)
        {
            j = 0;
        } else
        {
            j = e.hashCode();
        }
        if (i == null)
        {
            l = 0;
        } else
        {
            l = i.hashCode();
        }
        if (f == null)
        {
            i1 = 0;
        } else
        {
            i1 = f.hashCode();
        }
        if (O == null)
        {
            j1 = ((flag) ? 1 : 0);
        } else
        {
            j1 = O.hashCode();
        }
        return (i1 + (l + (j + k * 31) * 31) * 31) * 31 + j1;
_L2:
        l = 0;
_L5:
        k = j;
        if (l >= d.length) goto _L4; else goto _L3
_L3:
        j = j * 31 + d[l];
        l++;
          goto _L5
    }
}
