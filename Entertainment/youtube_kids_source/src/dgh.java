// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dgh extends eul
{

    private String a;
    private dnk b[];
    private dnk c[];
    private String d;
    private String e;
    private diq f;
    private dio g;

    public dgh()
    {
        a = "";
        b = dnk.a;
        c = dnk.a;
        d = "";
        e = "";
        f = null;
        g = null;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        if (!a.equals(""))
        {
            j = euj.b(1, a) + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (b != null)
        {
            dnk adnk[] = b;
            int i1 = adnk.length;
            int k = 0;
            do
            {
                i = j;
                if (k >= i1)
                {
                    break;
                }
                dnk dnk1 = adnk[k];
                i = j;
                if (dnk1 != null)
                {
                    i = j + euj.b(2, dnk1);
                }
                k++;
                j = i;
            } while (true);
        }
        j = i;
        if (c != null)
        {
            dnk adnk1[] = c;
            int j1 = adnk1.length;
            int l = ((flag) ? 1 : 0);
            do
            {
                j = i;
                if (l >= j1)
                {
                    break;
                }
                dnk dnk2 = adnk1[l];
                j = i;
                if (dnk2 != null)
                {
                    j = i + euj.b(3, dnk2);
                }
                l++;
                i = j;
            } while (true);
        }
        i = j;
        if (!d.equals(""))
        {
            i = j + euj.b(4, d);
        }
        j = i;
        if (!e.equals(""))
        {
            j = i + euj.b(5, e);
        }
        i = j;
        if (f != null)
        {
            i = j + euj.b(0x31ac7c8, f);
        }
        j = i;
        if (g != null)
        {
            j = i + euj.b(0x32de345, g);
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
                a = eui1.f();
                break;

            case 18: // '\022'
                int l = eup.a(eui1, 18);
                dnk adnk[];
                int j;
                if (b == null)
                {
                    j = 0;
                } else
                {
                    j = b.length;
                }
                adnk = new dnk[l + j];
                if (b != null)
                {
                    System.arraycopy(b, 0, adnk, 0, j);
                }
                for (b = adnk; j < b.length - 1; j++)
                {
                    b[j] = new dnk();
                    eui1.a(b[j]);
                    eui1.a();
                }

                b[j] = new dnk();
                eui1.a(b[j]);
                break;

            case 26: // '\032'
                int i1 = eup.a(eui1, 26);
                dnk adnk1[];
                int k;
                if (c == null)
                {
                    k = 0;
                } else
                {
                    k = c.length;
                }
                adnk1 = new dnk[i1 + k];
                if (c != null)
                {
                    System.arraycopy(c, 0, adnk1, 0, k);
                }
                for (c = adnk1; k < c.length - 1; k++)
                {
                    c[k] = new dnk();
                    eui1.a(c[k]);
                    eui1.a();
                }

                c[k] = new dnk();
                eui1.a(c[k]);
                break;

            case 34: // '"'
                d = eui1.f();
                break;

            case 42: // '*'
                e = eui1.f();
                break;

            case 416693826: 
                if (f == null)
                {
                    f = new diq();
                }
                eui1.a(f);
                break;

            case 426711594: 
                if (g == null)
                {
                    g = new dio();
                }
                eui1.a(g);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (!a.equals(""))
        {
            euj1.a(1, a);
        }
        if (b != null)
        {
            dnk adnk[] = b;
            int k = adnk.length;
            for (int i = 0; i < k; i++)
            {
                dnk dnk1 = adnk[i];
                if (dnk1 != null)
                {
                    euj1.a(2, dnk1);
                }
            }

        }
        if (c != null)
        {
            dnk adnk1[] = c;
            int l = adnk1.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                dnk dnk2 = adnk1[j];
                if (dnk2 != null)
                {
                    euj1.a(3, dnk2);
                }
            }

        }
        if (!d.equals(""))
        {
            euj1.a(4, d);
        }
        if (!e.equals(""))
        {
            euj1.a(5, e);
        }
        if (f != null)
        {
            euj1.a(0x31ac7c8, f);
        }
        if (g != null)
        {
            euj1.a(0x32de345, g);
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
            if (!(obj instanceof dgh))
            {
                return false;
            }
            obj = (dgh)obj;
            if ((a != null ? a.equals(((dgh) (obj)).a) : ((dgh) (obj)).a == null) && (Arrays.equals(b, ((dgh) (obj)).b) && Arrays.equals(c, ((dgh) (obj)).c)) && (d != null ? d.equals(((dgh) (obj)).d) : ((dgh) (obj)).d == null) && (e != null ? e.equals(((dgh) (obj)).e) : ((dgh) (obj)).e == null) && (f != null ? f.equals(((dgh) (obj)).f) : ((dgh) (obj)).f == null) && (g != null ? g.equals(((dgh) (obj)).g) : ((dgh) (obj)).g == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dgh) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dgh) (obj)).O))
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
        int j1;
        j1 = 0;
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
        j *= 31;
_L9:
        int k;
        int l;
        int i1;
        if (d == null)
        {
            i = 0;
        } else
        {
            i = d.hashCode();
        }
        if (e == null)
        {
            k = 0;
        } else
        {
            k = e.hashCode();
        }
        if (f == null)
        {
            l = 0;
        } else
        {
            l = f.hashCode();
        }
        if (g == null)
        {
            i1 = 0;
        } else
        {
            i1 = g.hashCode();
        }
        if (O != null)
        {
            j1 = O.hashCode();
        }
        return (i1 + (l + (k + (i + j * 31) * 31) * 31) * 31) * 31 + j1;
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
        i = j;
_L10:
        j = i;
        if (k >= c.length) goto _L9; else goto _L8
_L8:
        if (c[k] == null)
        {
            j = 0;
        } else
        {
            j = c[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L10
    }
}
