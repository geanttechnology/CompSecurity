// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dqc extends eul
{

    public static final dqc a[] = new dqc[0];
    private dre b;
    private String c;
    private dzp d;
    private boolean e;
    private dqc f[];

    public dqc()
    {
        b = null;
        c = "";
        d = null;
        e = false;
        f = a;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int k;
        if (b != null)
        {
            j = euj.b(1, b) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (!c.equals(""))
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(3, d);
        }
        i = j;
        if (e)
        {
            boolean flag1 = e;
            i = j + (euj.b(4) + 1);
        }
        k = i;
        if (f != null)
        {
            dqc adqc[] = f;
            int l = adqc.length;
            j = ((flag) ? 1 : 0);
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                dqc dqc1 = adqc[j];
                k = i;
                if (dqc1 != null)
                {
                    k = i + euj.b(5, dqc1);
                }
                j++;
                i = k;
            } while (true);
        }
        i = k + eup.a(O);
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
                    b = new dre();
                }
                eui1.a(b);
                break;

            case 18: // '\022'
                c = eui1.f();
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dzp();
                }
                eui1.a(d);
                break;

            case 32: // ' '
                e = eui1.e();
                break;

            case 42: // '*'
                int k = eup.a(eui1, 42);
                dqc adqc[];
                int j;
                if (f == null)
                {
                    j = 0;
                } else
                {
                    j = f.length;
                }
                adqc = new dqc[k + j];
                if (f != null)
                {
                    System.arraycopy(f, 0, adqc, 0, j);
                }
                for (f = adqc; j < f.length - 1; j++)
                {
                    f[j] = new dqc();
                    eui1.a(f[j]);
                    eui1.a();
                }

                f[j] = new dqc();
                eui1.a(f[j]);
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
        if (!c.equals(""))
        {
            euj1.a(2, c);
        }
        if (d != null)
        {
            euj1.a(3, d);
        }
        if (e)
        {
            euj1.a(4, e);
        }
        if (f != null)
        {
            dqc adqc[] = f;
            int j = adqc.length;
            for (int i = 0; i < j; i++)
            {
                dqc dqc1 = adqc[i];
                if (dqc1 != null)
                {
                    euj1.a(5, dqc1);
                }
            }

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
            if (!(obj instanceof dqc))
            {
                return false;
            }
            obj = (dqc)obj;
            if ((b != null ? b.equals(((dqc) (obj)).b) : ((dqc) (obj)).b == null) && (c != null ? c.equals(((dqc) (obj)).c) : ((dqc) (obj)).c == null) && (d != null ? d.equals(((dqc) (obj)).d) : ((dqc) (obj)).d == null) && (e == ((dqc) (obj)).e && Arrays.equals(f, ((dqc) (obj)).f)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dqc) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dqc) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        int l;
        boolean flag = false;
        int j1 = getClass().getName().hashCode();
        int j;
        int i1;
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
        if (d == null)
        {
            l = 0;
        } else
        {
            l = d.hashCode();
        }
        if (e)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        i = i1 + (l + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31;
        if (f != null) goto _L2; else goto _L1
_L1:
        l = i * 31;
_L4:
        int k;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return l * 31 + i;
_L2:
        k = 0;
_L5:
        l = i;
        if (k >= f.length) goto _L4; else goto _L3
_L3:
        if (f[k] == null)
        {
            l = 0;
        } else
        {
            l = f[k].hashCode();
        }
        i = l + i * 31;
        k++;
          goto _L5
    }

}
