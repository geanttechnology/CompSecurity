// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ddi extends eul
{

    private dlb a;
    private ddj b[];
    private dre c;
    private dlb d;

    public ddi()
    {
        a = null;
        b = ddj.a;
        c = null;
        d = null;
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
            ddj addj[] = b;
            int l = addj.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                ddj ddj1 = addj[k];
                j = i;
                if (ddj1 != null)
                {
                    j = i + euj.b(2, ddj1);
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
        if (d != null)
        {
            j = i + euj.b(4, d);
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
                if (a == null)
                {
                    a = new dlb();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                ddj addj[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                addj = new ddj[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, addj, 0, j);
                }
                for (b = addj; j < b.length - 1; j++)
                {
                    b[j] = new ddj();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new ddj();
                eui1.a(b[j]);
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dre();
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
            ddj addj[] = b;
            int j = addj.length;
            for (int i = 0; i < j; i++)
            {
                ddj ddj1 = addj[i];
                if (ddj1 != null)
                {
                    euj1.a(2, ddj1);
                }
            }

        }
        if (c != null)
        {
            euj1.a(3, c);
        }
        if (d != null)
        {
            euj1.a(4, d);
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
            if (!(obj instanceof ddi))
            {
                return false;
            }
            obj = (ddi)obj;
            if ((a != null ? a.equals(((ddi) (obj)).a) : ((ddi) (obj)).a == null) && Arrays.equals(b, ((ddi) (obj)).b) && (c != null ? c.equals(((ddi) (obj)).c) : ((ddi) (obj)).c == null) && (d != null ? d.equals(((ddi) (obj)).d) : ((ddi) (obj)).d == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ddi) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ddi) (obj)).O))
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
        int l;
        l = 0;
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
        j = i * 31;
_L4:
        int k;
        if (c == null)
        {
            i = 0;
        } else
        {
            i = c.hashCode();
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
        return (k + (i + j * 31) * 31) * 31 + l;
_L2:
        k = 0;
_L5:
        j = i;
        if (k >= b.length) goto _L4; else goto _L3
_L3:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L5
    }
}
