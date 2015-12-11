// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dvz extends eul
{

    public boolean a;
    private boolean b;
    private boolean c;
    private String d;
    private boolean e;
    private dor f[];
    private boolean g;

    public dvz()
    {
        b = false;
        c = false;
        d = "";
        e = false;
        a = false;
        f = dor.a;
        g = false;
    }

    public final int a()
    {
        boolean flag = false;
        int i;
        int j;
        int k;
        if (b)
        {
            boolean flag1 = b;
            j = euj.b(7) + 1 + 0;
        } else
        {
            j = 0;
        }
        i = j;
        if (c)
        {
            boolean flag2 = c;
            i = j + (euj.b(9) + 1);
        }
        j = i;
        if (!d.equals(""))
        {
            j = i + euj.b(12, d);
        }
        k = j;
        if (e)
        {
            boolean flag3 = e;
            k = j + (euj.b(13) + 1);
        }
        i = k;
        if (a)
        {
            boolean flag4 = a;
            i = k + (euj.b(14) + 1);
        }
        j = i;
        if (f != null)
        {
            dor ador[] = f;
            int i1 = ador.length;
            int l = ((flag) ? 1 : 0);
            do
            {
                j = i;
                if (l >= i1)
                {
                    break;
                }
                dor dor1 = ador[l];
                j = i;
                if (dor1 != null)
                {
                    j = i + euj.b(15, dor1);
                }
                l++;
                i = j;
            } while (true);
        }
        i = j;
        if (g)
        {
            boolean flag5 = g;
            i = j + (euj.b(16) + 1);
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

            case 56: // '8'
                b = eui1.e();
                break;

            case 72: // 'H'
                c = eui1.e();
                break;

            case 98: // 'b'
                d = eui1.f();
                break;

            case 104: // 'h'
                e = eui1.e();
                break;

            case 112: // 'p'
                a = eui1.e();
                break;

            case 122: // 'z'
                int k = eup.a(eui1, 122);
                dor ador[];
                int j;
                if (f == null)
                {
                    j = 0;
                } else
                {
                    j = f.length;
                }
                ador = new dor[k + j];
                if (f != null)
                {
                    System.arraycopy(f, 0, ador, 0, j);
                }
                for (f = ador; j < f.length - 1; j++)
                {
                    f[j] = new dor();
                    eui1.a(f[j]);
                    eui1.a();
                }

                f[j] = new dor();
                eui1.a(f[j]);
                break;

            case 128: 
                g = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b)
        {
            euj1.a(7, b);
        }
        if (c)
        {
            euj1.a(9, c);
        }
        if (!d.equals(""))
        {
            euj1.a(12, d);
        }
        if (e)
        {
            euj1.a(13, e);
        }
        if (a)
        {
            euj1.a(14, a);
        }
        if (f != null)
        {
            dor ador[] = f;
            int j = ador.length;
            for (int i = 0; i < j; i++)
            {
                dor dor1 = ador[i];
                if (dor1 != null)
                {
                    euj1.a(15, dor1);
                }
            }

        }
        if (g)
        {
            euj1.a(16, g);
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
            if (!(obj instanceof dvz))
            {
                return false;
            }
            obj = (dvz)obj;
            if (b == ((dvz) (obj)).b && c == ((dvz) (obj)).c && (d != null ? d.equals(((dvz) (obj)).d) : ((dvz) (obj)).d == null) && (e == ((dvz) (obj)).e && a == ((dvz) (obj)).a && Arrays.equals(f, ((dvz) (obj)).f) && g == ((dvz) (obj)).g))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dvz) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dvz) (obj)).O))
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
        boolean flag1 = true;
        int j1 = getClass().getName().hashCode();
        int l;
        int i1;
        if (b)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        if (c)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        if (d == null)
        {
            k = 0;
        } else
        {
            k = d.hashCode();
        }
        if (e)
        {
            l = 1;
        } else
        {
            l = 2;
        }
        if (a)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        i = i1 + (l + (k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31) * 31;
        if (f != null) goto _L2; else goto _L1
_L1:
        j = i * 31;
_L4:
        if (g)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 2;
        }
        if (O == null)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = O.hashCode();
        }
        return (j * 31 + i) * 31 + k;
_L2:
        k = 0;
_L5:
        j = i;
        if (k >= f.length) goto _L4; else goto _L3
_L3:
        if (f[k] == null)
        {
            j = 0;
        } else
        {
            j = f[k].hashCode();
        }
        i = j + i * 31;
        k++;
          goto _L5
    }
}
