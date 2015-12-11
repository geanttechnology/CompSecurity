// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dwj extends eul
{

    public boolean a;
    public dre b;
    public dwk c;
    public byte d[];
    private dlb e;
    private dzp f[];

    public dwj()
    {
        e = null;
        f = dzp.a;
        a = false;
        b = null;
        c = null;
        d = eup.f;
    }

    public final int a()
    {
        int k = 0;
        int i;
        int j;
        if (e != null)
        {
            i = euj.b(1, e) + 0;
        } else
        {
            i = 0;
        }
        j = i;
        if (f != null)
        {
            dzp adzp[] = f;
            int l = adzp.length;
            do
            {
                j = i;
                if (k >= l)
                {
                    break;
                }
                dzp dzp1 = adzp[k];
                j = i;
                if (dzp1 != null)
                {
                    j = i + euj.b(2, dzp1);
                }
                k++;
                i = j;
            } while (true);
        }
        i = j;
        if (a)
        {
            boolean flag = a;
            i = j + (euj.b(3) + 1);
        }
        j = i;
        if (b != null)
        {
            j = i + euj.b(4, b);
        }
        i = j;
        if (c != null)
        {
            i = j + euj.b(5, c);
        }
        j = i;
        if (!Arrays.equals(d, eup.f))
        {
            j = i + euj.b(7, d);
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
                if (e == null)
                {
                    e = new dlb();
                }
                eui1.a(e);
                break;

            case 18: // '\022'
                int k = eup.a(eui1, 18);
                dzp adzp[];
                int j;
                if (f == null)
                {
                    j = 0;
                } else
                {
                    j = f.length;
                }
                adzp = new dzp[k + j];
                if (f != null)
                {
                    System.arraycopy(f, 0, adzp, 0, j);
                }
                for (f = adzp; j < f.length - 1; j++)
                {
                    f[j] = new dzp();
                    eui1.a(f[j]);
                    eui1.a();
                }

                f[j] = new dzp();
                eui1.a(f[j]);
                break;

            case 24: // '\030'
                a = eui1.e();
                break;

            case 34: // '"'
                if (b == null)
                {
                    b = new dre();
                }
                eui1.a(b);
                break;

            case 42: // '*'
                if (c == null)
                {
                    c = new dwk();
                }
                eui1.a(c);
                break;

            case 58: // ':'
                d = eui1.g();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (e != null)
        {
            euj1.a(1, e);
        }
        if (f != null)
        {
            dzp adzp[] = f;
            int j = adzp.length;
            for (int i = 0; i < j; i++)
            {
                dzp dzp1 = adzp[i];
                if (dzp1 != null)
                {
                    euj1.a(2, dzp1);
                }
            }

        }
        if (a)
        {
            euj1.a(3, a);
        }
        if (b != null)
        {
            euj1.a(4, b);
        }
        if (c != null)
        {
            euj1.a(5, c);
        }
        if (!Arrays.equals(d, eup.f))
        {
            euj1.a(7, d);
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
            if (!(obj instanceof dwj))
            {
                return false;
            }
            obj = (dwj)obj;
            if ((e != null ? e.equals(((dwj) (obj)).e) : ((dwj) (obj)).e == null) && (Arrays.equals(f, ((dwj) (obj)).f) && a == ((dwj) (obj)).a) && (b != null ? b.equals(((dwj) (obj)).b) : ((dwj) (obj)).b == null) && (c != null ? c.equals(((dwj) (obj)).c) : ((dwj) (obj)).c == null) && Arrays.equals(d, ((dwj) (obj)).d))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dwj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dwj) (obj)).O))
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
        j = getClass().getName().hashCode();
        if (e == null)
        {
            i = 0;
        } else
        {
            i = e.hashCode();
        }
        i += (j + 527) * 31;
        if (f != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L6:
        int k;
        int i1;
        if (a)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (b == null)
        {
            k = 0;
        } else
        {
            k = b.hashCode();
        }
        if (c == null)
        {
            i1 = 0;
        } else
        {
            i1 = c.hashCode();
        }
        i = i1 + (k + (i + j * 31) * 31) * 31;
        if (d != null) goto _L4; else goto _L3
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
        if (k >= f.length) goto _L6; else goto _L5
_L5:
        if (f[k] == null)
        {
            j = 0;
        } else
        {
            j = f[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L7
          goto _L6
_L4:
        l = 0;
_L10:
        j = i;
        if (l >= d.length) goto _L9; else goto _L8
_L8:
        i = i * 31 + d[l];
        l++;
          goto _L10
    }
}
