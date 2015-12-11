// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class dlx extends eul
{

    private boolean a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private String g;
    private float h;
    private int i;

    public dlx()
    {
        a = false;
        b = false;
        c = 0;
        d = 0;
        e = 0;
        f = false;
        g = "";
        h = 0.0F;
        i = 0;
    }

    public final int a()
    {
        int k = 0;
        if (a)
        {
            boolean flag = a;
            k = euj.b(1) + 1 + 0;
        }
        int j = k;
        if (b)
        {
            boolean flag1 = b;
            j = k + (euj.b(4) + 1);
        }
        k = j;
        if (c != 0)
        {
            k = j + euj.c(5, c);
        }
        j = k;
        if (d != 0)
        {
            j = k + euj.c(6, d);
        }
        k = j;
        if (e != 0)
        {
            k = j + euj.c(7, e);
        }
        j = k;
        if (f)
        {
            boolean flag2 = f;
            j = k + (euj.b(8) + 1);
        }
        k = j;
        if (!g.equals(""))
        {
            k = j + euj.b(9, g);
        }
        j = k;
        if (h != 0.0F)
        {
            float f1 = h;
            j = k + (euj.b(10) + 4);
        }
        k = j;
        if (i != 0)
        {
            k = j + euj.c(11, i);
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

            case 8: // '\b'
                a = eui1.e();
                break;

            case 32: // ' '
                b = eui1.e();
                break;

            case 40: // '('
                int k = eui1.d();
                if (k == 0 || k == 1 || k == 2 || k == 3)
                {
                    c = k;
                } else
                {
                    c = 0;
                }
                break;

            case 48: // '0'
                d = eui1.d();
                break;

            case 56: // '8'
                e = eui1.d();
                break;

            case 64: // '@'
                f = eui1.e();
                break;

            case 74: // 'J'
                g = eui1.f();
                break;

            case 85: // 'U'
                h = Float.intBitsToFloat(eui1.i());
                break;

            case 88: // 'X'
                i = eui1.d();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a)
        {
            euj1.a(1, a);
        }
        if (b)
        {
            euj1.a(4, b);
        }
        if (c != 0)
        {
            euj1.a(5, c);
        }
        if (d != 0)
        {
            euj1.a(6, d);
        }
        if (e != 0)
        {
            euj1.a(7, e);
        }
        if (f)
        {
            euj1.a(8, f);
        }
        if (!g.equals(""))
        {
            euj1.a(9, g);
        }
        if (h != 0.0F)
        {
            euj1.a(10, h);
        }
        if (i != 0)
        {
            euj1.a(11, i);
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
            if (!(obj instanceof dlx))
            {
                return false;
            }
            obj = (dlx)obj;
            if (a == ((dlx) (obj)).a && b == ((dlx) (obj)).b && c == ((dlx) (obj)).c && d == ((dlx) (obj)).d && e == ((dlx) (obj)).e && f == ((dlx) (obj)).f && (g != null ? g.equals(((dlx) (obj)).g) : ((dlx) (obj)).g == null) && (h == ((dlx) (obj)).h && i == ((dlx) (obj)).i))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dlx) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dlx) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int j1 = 0;
        int l = 1;
        int k1 = getClass().getName().hashCode();
        int j;
        int k;
        int i1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        if (a)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        if (b)
        {
            k = 1;
        } else
        {
            k = 2;
        }
        l1 = c;
        i2 = d;
        j2 = e;
        if (!f)
        {
            l = 2;
        }
        if (g == null)
        {
            i1 = 0;
        } else
        {
            i1 = g.hashCode();
        }
        k2 = Float.floatToIntBits(h);
        l2 = i;
        if (O != null)
        {
            j1 = O.hashCode();
        }
        return (((i1 + (((((k + (j + (k1 + 527) * 31) * 31) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + l) * 31) * 31 + k2) * 31 + l2) * 31 + j1;
    }
}
