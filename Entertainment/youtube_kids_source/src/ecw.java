// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ecw extends eul
{

    public ecu a;
    public ecr b;
    public byte c[];
    private dlb d;
    private dre e;
    private dlb f[];
    private ecn g;
    private boolean h;
    private dlb i;
    private dqi j;

    public ecw()
    {
        d = null;
        e = null;
        f = dlb.a;
        g = null;
        a = null;
        b = null;
        h = false;
        i = null;
        c = eup.f;
        j = null;
    }

    public final int a()
    {
        int i1 = 0;
        int k;
        int l;
        if (d != null)
        {
            l = euj.b(1, d) + 0;
        } else
        {
            l = 0;
        }
        k = l;
        if (e != null)
        {
            k = l + euj.b(2, e);
        }
        l = k;
        if (f != null)
        {
            dlb adlb[] = f;
            int j1 = adlb.length;
            do
            {
                l = k;
                if (i1 >= j1)
                {
                    break;
                }
                dlb dlb1 = adlb[i1];
                l = k;
                if (dlb1 != null)
                {
                    l = k + euj.b(3, dlb1);
                }
                i1++;
                k = l;
            } while (true);
        }
        k = l;
        if (g != null)
        {
            k = l + euj.b(4, g);
        }
        l = k;
        if (a != null)
        {
            l = k + euj.b(5, a);
        }
        k = l;
        if (b != null)
        {
            k = l + euj.b(6, b);
        }
        l = k;
        if (h)
        {
            boolean flag = h;
            l = k + (euj.b(7) + 1);
        }
        k = l;
        if (i != null)
        {
            k = l + euj.b(8, i);
        }
        l = k;
        if (!Arrays.equals(c, eup.f))
        {
            l = k + euj.b(10, c);
        }
        k = l;
        if (j != null)
        {
            k = l + euj.b(11, j);
        }
        k += eup.a(O);
        P = k;
        return k;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int k = eui1.a();
            switch (k)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, k))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                if (d == null)
                {
                    d = new dlb();
                }
                eui1.a(d);
                break;

            case 18: // '\022'
                if (e == null)
                {
                    e = new dre();
                }
                eui1.a(e);
                break;

            case 26: // '\032'
                int i1 = eup.a(eui1, 26);
                dlb adlb[];
                int l;
                if (f == null)
                {
                    l = 0;
                } else
                {
                    l = f.length;
                }
                adlb = new dlb[i1 + l];
                if (f != null)
                {
                    System.arraycopy(f, 0, adlb, 0, l);
                }
                for (f = adlb; l < f.length - 1; l++)
                {
                    f[l] = new dlb();
                    eui1.a(f[l]);
                    eui1.a();
                }

                f[l] = new dlb();
                eui1.a(f[l]);
                break;

            case 34: // '"'
                if (g == null)
                {
                    g = new ecn();
                }
                eui1.a(g);
                break;

            case 42: // '*'
                if (a == null)
                {
                    a = new ecu();
                }
                eui1.a(a);
                break;

            case 50: // '2'
                if (b == null)
                {
                    b = new ecr();
                }
                eui1.a(b);
                break;

            case 56: // '8'
                h = eui1.e();
                break;

            case 66: // 'B'
                if (i == null)
                {
                    i = new dlb();
                }
                eui1.a(i);
                break;

            case 82: // 'R'
                c = eui1.g();
                break;

            case 90: // 'Z'
                if (j == null)
                {
                    j = new dqi();
                }
                eui1.a(j);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (d != null)
        {
            euj1.a(1, d);
        }
        if (e != null)
        {
            euj1.a(2, e);
        }
        if (f != null)
        {
            dlb adlb[] = f;
            int l = adlb.length;
            for (int k = 0; k < l; k++)
            {
                dlb dlb1 = adlb[k];
                if (dlb1 != null)
                {
                    euj1.a(3, dlb1);
                }
            }

        }
        if (g != null)
        {
            euj1.a(4, g);
        }
        if (a != null)
        {
            euj1.a(5, a);
        }
        if (b != null)
        {
            euj1.a(6, b);
        }
        if (h)
        {
            euj1.a(7, h);
        }
        if (i != null)
        {
            euj1.a(8, i);
        }
        if (!Arrays.equals(c, eup.f))
        {
            euj1.a(10, c);
        }
        if (j != null)
        {
            euj1.a(11, j);
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
            if (!(obj instanceof ecw))
            {
                return false;
            }
            obj = (ecw)obj;
            if ((d != null ? d.equals(((ecw) (obj)).d) : ((ecw) (obj)).d == null) && (e != null ? e.equals(((ecw) (obj)).e) : ((ecw) (obj)).e == null) && Arrays.equals(f, ((ecw) (obj)).f) && (g != null ? g.equals(((ecw) (obj)).g) : ((ecw) (obj)).g == null) && (a != null ? a.equals(((ecw) (obj)).a) : ((ecw) (obj)).a == null) && (b != null ? b.equals(((ecw) (obj)).b) : ((ecw) (obj)).b == null) && h == ((ecw) (obj)).h && (i != null ? i.equals(((ecw) (obj)).i) : ((ecw) (obj)).i == null) && Arrays.equals(c, ((ecw) (obj)).c) && (j != null ? j.equals(((ecw) (obj)).j) : ((ecw) (obj)).j == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((ecw) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((ecw) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int k;
        int l;
        int i1;
        boolean flag = false;
        i1 = getClass().getName().hashCode();
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        if (e == null)
        {
            l = 0;
        } else
        {
            l = e.hashCode();
        }
        k = l + (k + (i1 + 527) * 31) * 31;
        if (f != null) goto _L2; else goto _L1
_L1:
        l = k * 31;
_L6:
        int j1;
        int k1;
        int l1;
        if (g == null)
        {
            k = 0;
        } else
        {
            k = g.hashCode();
        }
        if (a == null)
        {
            i1 = 0;
        } else
        {
            i1 = a.hashCode();
        }
        if (b == null)
        {
            j1 = 0;
        } else
        {
            j1 = b.hashCode();
        }
        if (h)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (i == null)
        {
            l1 = 0;
        } else
        {
            l1 = i.hashCode();
        }
        k = l1 + (k1 + (j1 + (i1 + (k + l * 31) * 31) * 31) * 31) * 31;
        if (c != null) goto _L4; else goto _L3
_L3:
        l = k * 31;
_L9:
        if (j == null)
        {
            k = 0;
        } else
        {
            k = j.hashCode();
        }
        if (O == null)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = O.hashCode();
        }
        return (k + l * 31) * 31 + i1;
_L2:
        i1 = 0;
_L7:
        l = k;
        if (i1 >= f.length) goto _L6; else goto _L5
_L5:
        if (f[i1] == null)
        {
            l = 0;
        } else
        {
            l = f[i1].hashCode();
        }
        k = l + k * 31;
        i1++;
          goto _L7
          goto _L6
_L4:
        i1 = 0;
_L10:
        l = k;
        if (i1 >= c.length) goto _L9; else goto _L8
_L8:
        k = k * 31 + c[i1];
        i1++;
          goto _L10
    }
}
