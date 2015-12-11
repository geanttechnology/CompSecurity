// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class doj extends eul
{

    public dol a[];
    public byte b[];
    private dlb c;
    private dok d;
    private dlb e;

    public doj()
    {
        a = dol.a;
        c = null;
        d = null;
        e = null;
        b = eup.f;
    }

    public final int a()
    {
        int j = 0;
        int i = 0;
        if (a != null)
        {
            dol adol[] = a;
            int l = adol.length;
            int k = 0;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dol dol1 = adol[k];
                j = i;
                if (dol1 != null)
                {
                    j = i + euj.b(1, dol1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (c != null)
        {
            i = j + euj.b(2, c);
        }
        j = i;
        if (d != null)
        {
            j = i + euj.b(3, d);
        }
        i = j;
        if (e != null)
        {
            i = j + euj.b(5, e);
        }
        j = i;
        if (!Arrays.equals(b, eup.f))
        {
            j = i + euj.b(6, b);
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
                int k = eup.a(eui1, 10);
                dol adol[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adol = new dol[k + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adol, 0, j);
                }
                for (a = adol; j < a.length - 1; j++)
                {
                    a[j] = new dol();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dol();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 26: // '\032'
                if (d == null)
                {
                    d = new dok();
                }
                eui1.a(d);
                break;

            case 42: // '*'
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 50: // '2'
                b = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a != null)
        {
            dol adol[] = a;
            int j = adol.length;
            for (int i = 0; i < j; i++)
            {
                dol dol1 = adol[i];
                if (dol1 != null)
                {
                    euj1.a(1, dol1);
                }
            }

        }
        if (c != null)
        {
            euj1.a(2, c);
        }
        if (d != null)
        {
            euj1.a(3, d);
        }
        if (e != null)
        {
            euj1.a(5, e);
        }
        if (!Arrays.equals(b, eup.f))
        {
            euj1.a(6, b);
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
            if (!(obj instanceof doj))
            {
                return false;
            }
            obj = (doj)obj;
            if (Arrays.equals(a, ((doj) (obj)).a) && (c != null ? c.equals(((doj) (obj)).c) : ((doj) (obj)).c == null) && (d != null ? d.equals(((doj) (obj)).d) : ((doj) (obj)).d == null) && (e != null ? e.equals(((doj) (obj)).e) : ((doj) (obj)).e == null) && Arrays.equals(b, ((doj) (obj)).b))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((doj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((doj) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        boolean flag;
        flag = false;
        i = getClass().getName().hashCode() + 527;
        if (a != null) goto _L2; else goto _L1
_L1:
        int j = i * 31;
_L6:
        int k;
        int i1;
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
        if (e == null)
        {
            i1 = 0;
        } else
        {
            i1 = e.hashCode();
        }
        i = i1 + (k + (i + j * 31) * 31) * 31;
        if (b != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L9:
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
        k = 0;
_L7:
        j = i;
        if (k >= a.length) goto _L6; else goto _L5
_L5:
        if (a[k] == null)
        {
            j = 0;
        } else
        {
            j = a[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L7
          goto _L6
_L4:
        l = 0;
_L10:
        j = i;
        if (l >= b.length) goto _L9; else goto _L8
_L8:
        i = i * 31 + b[l];
        l++;
          goto _L10
    }
}
