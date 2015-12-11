// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class drl extends eul
{

    private int a;
    private boolean b;
    private dlb c;
    private dlb d;
    private byte e[];
    private byte f[][];
    private byte g[];

    public drl()
    {
        a = 0;
        b = false;
        c = null;
        d = null;
        e = eup.f;
        f = eup.e;
        g = eup.f;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int k;
        if (a != 0)
        {
            j = euj.d(1, a) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (b)
        {
            boolean flag1 = b;
            i = j + (euj.b(2) + 1);
        }
        j = i;
        if (c != null)
        {
            j = i + euj.b(3, c);
        }
        k = j;
        if (d != null)
        {
            k = j + euj.b(4, d);
        }
        i = k;
        if (!Arrays.equals(e, eup.f))
        {
            i = k + euj.b(5, e);
        }
        j = i;
        if (f != null)
        {
            j = i;
            if (f.length > 0)
            {
                byte abyte0[][] = f;
                int i1 = abyte0.length;
                int l = 0;
                for (j = ((flag) ? 1 : 0); j < i1; j++)
                {
                    l += euj.a(abyte0[j]);
                }

                j = i + l + f.length * 1;
            }
        }
        i = j;
        if (!Arrays.equals(g, eup.f))
        {
            i = j + euj.b(8, g);
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

            case 8: // '\b'
                a = eui1.h();
                break;

            case 16: // '\020'
                b = eui1.e();
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 34: // '"'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                e = eui1.g();
                break;

            case 58: // ':'
                int k = eup.a(eui1, 58);
                int j = f.length;
                byte abyte0[][] = new byte[k + j][];
                System.arraycopy(f, 0, abyte0, 0, j);
                for (f = abyte0; j < f.length - 1; j++)
                {
                    f[j] = eui1.g();
                    eui1.a();
                }

                f[j] = eui1.g();
                break;

            case 66: // 'B'
                g = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != 0)
        {
            euj1.b(1, a);
        }
        if (b)
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            euj1.a(3, c);
        }
        if (d != null)
        {
            euj1.a(4, d);
        }
        if (!Arrays.equals(e, eup.f))
        {
            euj1.a(5, e);
        }
        if (f != null)
        {
            byte abyte0[][] = f;
            int j = abyte0.length;
            for (int i = 0; i < j; i++)
            {
                euj1.a(7, abyte0[i]);
            }

        }
        if (!Arrays.equals(g, eup.f))
        {
            euj1.a(8, g);
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
            if (!(obj instanceof drl))
            {
                return false;
            }
            obj = (drl)obj;
            if (a == ((drl) (obj)).a && b == ((drl) (obj)).b && (c != null ? c.equals(((drl) (obj)).c) : ((drl) (obj)).c == null) && (d != null ? d.equals(((drl) (obj)).d) : ((drl) (obj)).d == null) && (Arrays.equals(e, ((drl) (obj)).e) && Arrays.equals(f, ((drl) (obj)).f) && Arrays.equals(g, ((drl) (obj)).g)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((drl) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((drl) (obj)).O))
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
        int i1 = getClass().getName().hashCode();
        int j1 = a;
        int k;
        if (b)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (c == null)
        {
            j = 0;
        } else
        {
            j = c.hashCode();
        }
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        j = k + (j + (i + ((i1 + 527) * 31 + j1) * 31) * 31) * 31;
        if (e != null) goto _L2; else goto _L1
_L1:
        i = j * 31;
_L8:
        if (f != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L11:
        if (g != null) goto _L6; else goto _L5
_L5:
        i = j * 31;
_L14:
        int l;
        byte byte0;
        if (O == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = O.hashCode();
        }
        return i * 31 + j;
_L2:
        l = 0;
_L9:
        i = j;
        if (l >= e.length) goto _L8; else goto _L7
_L7:
        j = j * 31 + e[l];
        l++;
          goto _L9
          goto _L8
_L4:
        l = 0;
_L12:
        j = i;
        if (l >= f.length) goto _L11; else goto _L10
_L10:
        for (j = 0; j < f[l].length;)
        {
            byte0 = f[l][j];
            j++;
            i = byte0 + i * 31;
        }

        l++;
          goto _L12
          goto _L11
_L6:
        l = 0;
_L15:
        i = j;
        if (l >= g.length) goto _L14; else goto _L13
_L13:
        j = j * 31 + g[l];
        l++;
          goto _L15
    }
}
