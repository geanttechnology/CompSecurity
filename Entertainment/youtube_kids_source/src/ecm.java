// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ecm extends eul
{

    public dlb a;
    public ecl b[];
    private byte c[];
    private dre d;
    private dlb e;

    public ecm()
    {
        a = null;
        b = ecl.a;
        c = eup.f;
        d = null;
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
            ecl aecl[] = b;
            int l = aecl.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                ecl ecl1 = aecl[k];
                j = i;
                if (ecl1 != null)
                {
                    j = i + euj.b(2, ecl1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (!Arrays.equals(c, eup.f))
        {
            i = j + euj.b(4, c);
        }
        j = i;
        if (d != null)
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
                ecl aecl[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                aecl = new ecl[k + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, aecl, 0, j);
                }
                for (b = aecl; j < b.length - 1; j++)
                {
                    b[j] = new ecl();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new ecl();
                eui1.a(b[j]);
                break;

            case 34: // '"'
                c = eui1.g();
                break;

            case 42: // '*'
                if (d == null)
                {
                    d = new dre();
                }
                eui1.a(d);
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
            ecl aecl[] = b;
            int j = aecl.length;
            for (int i = 0; i < j; i++)
            {
                ecl ecl1 = aecl[i];
                if (ecl1 != null)
                {
                    euj1.a(2, ecl1);
                }
            }

        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(4, c);
        }
        if (d != null)
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
            if (!(obj instanceof ecm))
            {
                return false;
            }
            obj = (ecm)obj;
            if ((a != null ? a.equals(((ecm) (obj)).a) : ((ecm) (obj)).a == null) && (Arrays.equals(b, ((ecm) (obj)).b) && Arrays.equals(c, ((ecm) (obj)).c)) && (d != null ? d.equals(((ecm) (obj)).d) : ((ecm) (obj)).d == null) && (e != null ? e.equals(((ecm) (obj)).e) : ((ecm) (obj)).e == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ecm) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ecm) (obj)).O))
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
_L6:
        if (c != null) goto _L4; else goto _L3
_L3:
        i = j * 31;
_L9:
        int k;
        if (d == null)
        {
            j = 0;
        } else
        {
            j = d.hashCode();
        }
        if (e == null)
        {
            k = 0;
        } else
        {
            k = e.hashCode();
        }
        if (O != null)
        {
            l = O.hashCode();
        }
        return (k + (j + i * 31) * 31) * 31 + l;
_L2:
        k = 0;
_L7:
        j = i;
        if (k >= b.length) goto _L6; else goto _L5
_L5:
        if (b[k] == null)
        {
            j = 0;
        } else
        {
            j = b[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L7
          goto _L6
_L4:
        k = 0;
_L10:
        i = j;
        if (k >= c.length) goto _L9; else goto _L8
_L8:
        j = j * 31 + c[k];
        k++;
          goto _L10
    }
}
