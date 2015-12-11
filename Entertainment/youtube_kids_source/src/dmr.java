// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dmr extends eul
{

    public String a;
    public String b;
    public dmx c;
    public String d;
    public String e;
    public int f;
    public float g;
    private dmx h;
    private String i;
    private dmx j[];
    private String k;
    private String l;

    public dmr()
    {
        a = "";
        b = "";
        c = null;
        d = "";
        e = "";
        f = 0;
        h = null;
        i = "";
        j = dmx.a;
        g = 0.0F;
        k = "";
        l = "";
    }

    public final int a()
    {
        int k1 = 0;
        int i1;
        int j1;
        if (!a.equals(""))
        {
            j1 = euj.b(1, a) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (!b.equals(""))
        {
            i1 = j1 + euj.b(2, b);
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1 + euj.b(3, c);
        }
        i1 = j1;
        if (!d.equals(""))
        {
            i1 = j1 + euj.b(4, d);
        }
        j1 = i1;
        if (!e.equals(""))
        {
            j1 = i1 + euj.b(5, e);
        }
        i1 = j1;
        if (f != 0)
        {
            i1 = j1 + euj.c(6, f);
        }
        j1 = i1;
        if (h != null)
        {
            j1 = i1 + euj.b(7, h);
        }
        i1 = j1;
        if (!i.equals(""))
        {
            i1 = j1 + euj.b(8, i);
        }
        j1 = i1;
        if (j != null)
        {
            dmx admx[] = j;
            int l1 = admx.length;
            do
            {
                j1 = i1;
                if (k1 >= l1)
                {
                    break;
                }
                dmx dmx1 = admx[k1];
                j1 = i1;
                if (dmx1 != null)
                {
                    j1 = i1 + euj.b(9, dmx1);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (g != 0.0F)
        {
            float f1 = g;
            i1 = j1 + (euj.b(10) + 4);
        }
        j1 = i1;
        if (!k.equals(""))
        {
            j1 = i1 + euj.b(11, k);
        }
        i1 = j1;
        if (!l.equals(""))
        {
            i1 = j1 + euj.b(12, l);
        }
        i1 += eup.a(O);
        P = i1;
        return i1;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int i1 = eui1.a();
            switch (i1)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, i1))
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
                b = eui1.f();
                break;

            case 26: // '\032'
                if (c == null)
                {
                    c = new dmx();
                }
                eui1.a(c);
                break;

            case 34: // '"'
                d = eui1.f();
                break;

            case 42: // '*'
                e = eui1.f();
                break;

            case 48: // '0'
                f = eui1.d();
                break;

            case 58: // ':'
                if (h == null)
                {
                    h = new dmx();
                }
                eui1.a(h);
                break;

            case 66: // 'B'
                i = eui1.f();
                break;

            case 74: // 'J'
                int k1 = eup.a(eui1, 74);
                dmx admx[];
                int j1;
                if (j == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = j.length;
                }
                admx = new dmx[k1 + j1];
                if (j != null)
                {
                    System.arraycopy(j, 0, admx, 0, j1);
                }
                for (j = admx; j1 < j.length - 1; j1++)
                {
                    j[j1] = new dmx();
                    eui1.a(j[j1]);
                    eui1.a();
                }

                j[j1] = new dmx();
                eui1.a(j[j1]);
                break;

            case 85: // 'U'
                g = Float.intBitsToFloat(eui1.i());
                break;

            case 90: // 'Z'
                k = eui1.f();
                break;

            case 98: // 'b'
                l = eui1.f();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (!a.equals(""))
        {
            euj1.a(1, a);
        }
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (c != null)
        {
            euj1.a(3, c);
        }
        if (!d.equals(""))
        {
            euj1.a(4, d);
        }
        if (!e.equals(""))
        {
            euj1.a(5, e);
        }
        if (f != 0)
        {
            euj1.a(6, f);
        }
        if (h != null)
        {
            euj1.a(7, h);
        }
        if (!i.equals(""))
        {
            euj1.a(8, i);
        }
        if (j != null)
        {
            dmx admx[] = j;
            int j1 = admx.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                dmx dmx1 = admx[i1];
                if (dmx1 != null)
                {
                    euj1.a(9, dmx1);
                }
            }

        }
        if (g != 0.0F)
        {
            euj1.a(10, g);
        }
        if (!k.equals(""))
        {
            euj1.a(11, k);
        }
        if (!l.equals(""))
        {
            euj1.a(12, l);
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
            if (!(obj instanceof dmr))
            {
                return false;
            }
            obj = (dmr)obj;
            if ((a != null ? a.equals(((dmr) (obj)).a) : ((dmr) (obj)).a == null) && (b != null ? b.equals(((dmr) (obj)).b) : ((dmr) (obj)).b == null) && (c != null ? c.equals(((dmr) (obj)).c) : ((dmr) (obj)).c == null) && (d != null ? d.equals(((dmr) (obj)).d) : ((dmr) (obj)).d == null) && (e != null ? e.equals(((dmr) (obj)).e) : ((dmr) (obj)).e == null) && f == ((dmr) (obj)).f && (h != null ? h.equals(((dmr) (obj)).h) : ((dmr) (obj)).h == null) && (i != null ? i.equals(((dmr) (obj)).i) : ((dmr) (obj)).i == null) && (Arrays.equals(j, ((dmr) (obj)).j) && g == ((dmr) (obj)).g) && (k != null ? k.equals(((dmr) (obj)).k) : ((dmr) (obj)).k == null) && (l != null ? l.equals(((dmr) (obj)).l) : ((dmr) (obj)).l == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmr) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmr) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i1;
        int j1;
        int k1;
        int l1;
        boolean flag = false;
        int l2 = getClass().getName().hashCode();
        int i2;
        int j2;
        int k2;
        int i3;
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
        if (c == null)
        {
            k1 = 0;
        } else
        {
            k1 = c.hashCode();
        }
        if (d == null)
        {
            l1 = 0;
        } else
        {
            l1 = d.hashCode();
        }
        if (e == null)
        {
            i2 = 0;
        } else
        {
            i2 = e.hashCode();
        }
        i3 = f;
        if (h == null)
        {
            j2 = 0;
        } else
        {
            j2 = h.hashCode();
        }
        if (i == null)
        {
            k2 = 0;
        } else
        {
            k2 = i.hashCode();
        }
        i1 = k2 + (j2 + ((i2 + (l1 + (k1 + (j1 + (i1 + (l2 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i3) * 31) * 31;
        if (j != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L4:
        i2 = Float.floatToIntBits(g);
        if (k == null)
        {
            i1 = 0;
        } else
        {
            i1 = k.hashCode();
        }
        if (l == null)
        {
            k1 = 0;
        } else
        {
            k1 = l.hashCode();
        }
        if (O == null)
        {
            l1 = ((flag) ? 1 : 0);
        } else
        {
            l1 = O.hashCode();
        }
        return (k1 + (i1 + (j1 * 31 + i2) * 31) * 31) * 31 + l1;
_L2:
        k1 = 0;
_L5:
        j1 = i1;
        if (k1 >= j.length) goto _L4; else goto _L3
_L3:
        if (j[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = j[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L5
    }
}
