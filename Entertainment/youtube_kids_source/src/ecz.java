// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ecz extends eul
{

    public dlb a;
    public ecy b[];
    private dre c;
    private byte d[];
    private dlb e;

    public ecz()
    {
        a = null;
        b = ecy.a;
        c = null;
        d = eup.f;
        e = null;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (a != null)
        {
            i = euj.b(1, a) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (b != null)
        {
            ecy aecy[] = b;
            int l = aecy.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                ecy ecy1 = aecy[k];
                j = i;
                if (ecy1 != null)
                {
                    j = i + euj.b(2, ecy1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (c != null)
        {
            i = j + euj.b(3, c);
        }
        j = i;
        if (!Arrays.equals(d, eup.f))
        {
            j = i + euj.b(5, d);
        }
        i = j;
        if (e != null)
        {
            i = j + euj.b(6, e);
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
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                ecy aecy[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                aecy = new ecy[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, aecy, 0, j);
                }
                for (b = aecy; j < b.length - 1; j++)
                {
                    b[j] = new ecy();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new ecy();
                eui1.a(b[j]);
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dre();
                }
                eui1.a(c);
                break;

            case 42: // '*'
                d = eui1.g();
                break;

            case 50: // '2'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            ecy aecy[] = b;
            int j = aecy.length;
            for (int i = 0; i < j; i++)
            {
                ecy ecy1 = aecy[i];
                if (ecy1 != null)
                {
                    euj1.a(2, ecy1);
                }
            }

        }
        if (c != null)
        {
            euj1.a(3, c);
        }
        if (!Arrays.equals(d, eup.f))
        {
            euj1.a(5, d);
        }
        if (e != null)
        {
            euj1.a(6, e);
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
            if (!(obj instanceof ecz))
            {
                return false;
            }
            obj = (ecz)obj;
            if ((a != null ? a.equals(((ecz) (obj)).a) : ((ecz) (obj)).a == null) && Arrays.equals(b, ((ecz) (obj)).b) && (c != null ? c.equals(((ecz) (obj)).c) : ((ecz) (obj)).c == null) && Arrays.equals(d, ((ecz) (obj)).d) && (e != null ? e.equals(((ecz) (obj)).e) : ((ecz) (obj)).e == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ecz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ecz) (obj)).O))
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
        j = getClass().getName().hashCode();
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        i += (j + 527) * 31;
        if (b != null) goto _L2; else goto _L1
_L1:
        k = i * 31;
_L6:
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
        }
        i += k * 31;
        if (d != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L9:
        if (e == null)
        {
            i = 0;
        } else
        {
            i = e.hashCode();
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
        j = 0;
_L7:
        k = i;
        if (j >= b.length) goto _L6; else goto _L5
_L5:
        if (b[j] == null)
        {
            k = 0;
        } else
        {
            k = b[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L7
          goto _L6
_L4:
        k = 0;
_L10:
        j = i;
        if (k >= d.length) goto _L9; else goto _L8
_L8:
        i = i * 31 + d[k];
        k++;
          goto _L10
    }
}
