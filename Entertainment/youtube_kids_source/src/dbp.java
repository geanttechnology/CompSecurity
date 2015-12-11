// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dbp extends eul
{

    private dbr a[];
    private dlb b;
    private dlb c;
    private byte d[];
    private dbo e;
    private dbq f[];

    public dbp()
    {
        a = dbr.a;
        b = null;
        c = null;
        d = eup.f;
        e = null;
        f = dbq.a;
    }

    public final int a()
    {
        boolean flag = false;
        int k;
        if (a != null)
        {
            dbr adbr[] = a;
            int k1 = adbr.length;
            int i1 = 0;
            int i = 0;
            do
            {
                k = i;
                if (i1 >= k1)
                {
                    break;
                }
                dbr dbr1 = adbr[i1];
                k = i;
                if (dbr1 != null)
                {
                    k = i + euj.b(1, dbr1);
                }
                i1++;
                i = k;
            } while (true);
        } else
        {
            k = 0;
        }
        int j = k;
        if (b != null)
        {
            j = k + euj.b(2, b);
        }
        k = j;
        if (c != null)
        {
            k = j + euj.b(5, c);
        }
        int j1 = k;
        if (!Arrays.equals(d, eup.f))
        {
            j1 = k + euj.b(6, d);
        }
        j = j1;
        if (e != null)
        {
            j = j1 + euj.b(7, e);
        }
        j1 = j;
        if (f != null)
        {
            dbq adbq[] = f;
            int l1 = adbq.length;
            int l = ((flag) ? 1 : 0);
            do
            {
                j1 = j;
                if (l >= l1)
                {
                    break;
                }
                dbq dbq1 = adbq[l];
                j1 = j;
                if (dbq1 != null)
                {
                    j1 = j + euj.b(8, dbq1);
                }
                l++;
                j = j1;
            } while (true);
        }
        j = j1 + eup.a(O);
        P = j;
        return j;
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
                int l = eup.a(eui1, 10);
                dbr adbr[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                adbr = new dbr[l + j];
                if (a != null)
                {
                    System.arraycopy(a, 0, adbr, 0, j);
                }
                for (a = adbr; j < a.length - 1; j++)
                {
                    a[j] = new dbr();
                    eui1.a(a[j]);
                    eui1.a();
                }

                a[j] = new dbr();
                eui1.a(a[j]);
                break;

            case 18: // '\022'
                if (b == null)
                {
                    b = new dlb();
                }
                eui1.a(b);
                break;

            case 42: // '*'
                if (c == null)
                {
                    c = new dlb();
                }
                eui1.a(c);
                break;

            case 50: // '2'
                d = eui1.g();
                break;

            case 58: // ':'
                if (e == null)
                {
                    e = new dbo();
                }
                eui1.a(e);
                break;

            case 66: // 'B'
                int i1 = eup.a(eui1, 66);
                dbq adbq[];
                int k;
                if (f == null)
                {
                    k = 0;
                } else
                {
                    k = f.length;
                }
                adbq = new dbq[i1 + k];
                if (f != null)
                {
                    System.arraycopy(f, 0, adbq, 0, k);
                }
                for (f = adbq; k < f.length - 1; k++)
                {
                    f[k] = new dbq();
                    eui1.a(f[k]);
                    eui1.a();
                }

                f[k] = new dbq();
                eui1.a(f[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            dbr adbr[] = a;
            int k = adbr.length;
            for (int i = 0; i < k; i++)
            {
                dbr dbr1 = adbr[i];
                if (dbr1 != null)
                {
                    euj1.a(1, dbr1);
                }
            }

        }
        if (b != null)
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            euj1.a(5, c);
        }
        if (!Arrays.equals(d, eup.f))
        {
            euj1.a(6, d);
        }
        if (e != null)
        {
            euj1.a(7, e);
        }
        if (f != null)
        {
            dbq adbq[] = f;
            int l = adbq.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                dbq dbq1 = adbq[j];
                if (dbq1 != null)
                {
                    euj1.a(8, dbq1);
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
            if (!(obj instanceof dbp))
            {
                return false;
            }
            obj = (dbp)obj;
            if (Arrays.equals(a, ((dbp) (obj)).a) && (b != null ? b.equals(((dbp) (obj)).b) : ((dbp) (obj)).b == null) && (c != null ? c.equals(((dbp) (obj)).c) : ((dbp) (obj)).c == null) && Arrays.equals(d, ((dbp) (obj)).d) && (e != null ? e.equals(((dbp) (obj)).e) : ((dbp) (obj)).e == null) && Arrays.equals(f, ((dbp) (obj)).f))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dbp) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dbp) (obj)).O))
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
_L8:
        int k;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (c == null)
        {
            k = 0;
        } else
        {
            k = c.hashCode();
        }
        i = k + (i + j * 31) * 31;
        if (d != null) goto _L4; else goto _L3
_L3:
        j = i * 31;
_L11:
        if (e == null)
        {
            i = 0;
        } else
        {
            i = e.hashCode();
        }
        i += j * 31;
        if (f != null) goto _L6; else goto _L5
_L5:
        k = i * 31;
_L14:
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return k * 31 + i;
_L2:
        k = 0;
_L9:
        j = i;
        if (k >= a.length) goto _L8; else goto _L7
_L7:
        if (a[k] == null)
        {
            j = 0;
        } else
        {
            j = a[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L9
          goto _L8
_L4:
        k = 0;
_L12:
        j = i;
        if (k >= d.length) goto _L11; else goto _L10
_L10:
        i = i * 31 + d[k];
        k++;
          goto _L12
          goto _L11
_L6:
        j = 0;
_L15:
        k = i;
        if (j >= f.length) goto _L14; else goto _L13
_L13:
        if (f[j] == null)
        {
            k = 0;
        } else
        {
            k = f[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L15
    }
}
