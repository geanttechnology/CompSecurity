// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dmd extends eul
{

    public dcm a;
    public String b;
    public String c[];
    public eam d[];
    public dmg e[];
    public dkn f[];
    public dmn g[];
    private String h;
    private String i;
    private dvh j;
    private String k;
    private dnd l[];

    public dmd()
    {
        a = null;
        b = "";
        h = "";
        i = "";
        j = null;
        k = "";
        c = eup.d;
        d = eam.a;
        e = dmg.a;
        f = dkn.a;
        g = dmn.a;
        l = dnd.a;
    }

    public final int a()
    {
        boolean flag = false;
        int i1;
        int j1;
        int l2;
        if (a != null)
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
        if (!h.equals(""))
        {
            j1 = i1 + euj.b(3, h);
        }
        i1 = j1;
        if (!i.equals(""))
        {
            i1 = j1 + euj.b(4, i);
        }
        j1 = i1;
        if (j != null)
        {
            j1 = i1 + euj.b(5, j);
        }
        i1 = j1;
        if (!k.equals(""))
        {
            i1 = j1 + euj.b(6, k);
        }
        j1 = i1;
        if (c != null)
        {
            j1 = i1;
            if (c.length > 0)
            {
                String as[] = c;
                int i3 = as.length;
                j1 = 0;
                int k1 = 0;
                for (; j1 < i3; j1++)
                {
                    k1 += euj.a(as[j1]);
                }

                j1 = i1 + k1 + c.length * 1;
            }
        }
        i1 = j1;
        if (d != null)
        {
            eam aeam[] = d;
            int j3 = aeam.length;
            int l1 = 0;
            do
            {
                i1 = j1;
                if (l1 >= j3)
                {
                    break;
                }
                eam eam1 = aeam[l1];
                i1 = j1;
                if (eam1 != null)
                {
                    i1 = j1 + euj.b(8, eam1);
                }
                l1++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (e != null)
        {
            dmg admg[] = e;
            int k3 = admg.length;
            int i2 = 0;
            do
            {
                j1 = i1;
                if (i2 >= k3)
                {
                    break;
                }
                dmg dmg1 = admg[i2];
                j1 = i1;
                if (dmg1 != null)
                {
                    j1 = i1 + euj.b(9, dmg1);
                }
                i2++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (f != null)
        {
            dkn adkn[] = f;
            int l3 = adkn.length;
            int j2 = 0;
            do
            {
                i1 = j1;
                if (j2 >= l3)
                {
                    break;
                }
                dkn dkn1 = adkn[j2];
                i1 = j1;
                if (dkn1 != null)
                {
                    i1 = j1 + euj.b(10, dkn1);
                }
                j2++;
                j1 = i1;
            } while (true);
        }
        j1 = i1;
        if (g != null)
        {
            dmn admn[] = g;
            int i4 = admn.length;
            int k2 = 0;
            do
            {
                j1 = i1;
                if (k2 >= i4)
                {
                    break;
                }
                dmn dmn1 = admn[k2];
                j1 = i1;
                if (dmn1 != null)
                {
                    j1 = i1 + euj.b(11, dmn1);
                }
                k2++;
                i1 = j1;
            } while (true);
        }
        l2 = j1;
        if (l != null)
        {
            dnd adnd[] = l;
            int j4 = adnd.length;
            i1 = ((flag) ? 1 : 0);
            do
            {
                l2 = j1;
                if (i1 >= j4)
                {
                    break;
                }
                dnd dnd1 = adnd[i1];
                l2 = j1;
                if (dnd1 != null)
                {
                    l2 = j1 + euj.b(12, dnd1);
                }
                i1++;
                j1 = l2;
            } while (true);
        }
        i1 = l2 + eup.a(O);
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
                if (a == null)
                {
                    a = new dcm();
                }
                eui1.a(a);
                break;

            case 18: // '\022'
                b = eui1.f();
                break;

            case 26: // '\032'
                h = eui1.f();
                break;

            case 34: // '"'
                i = eui1.f();
                break;

            case 42: // '*'
                if (j == null)
                {
                    j = new dvh();
                }
                eui1.a(j);
                break;

            case 50: // '2'
                k = eui1.f();
                break;

            case 58: // ':'
                int l2 = eup.a(eui1, 58);
                int j1 = c.length;
                String as[] = new String[l2 + j1];
                System.arraycopy(c, 0, as, 0, j1);
                for (c = as; j1 < c.length - 1; j1++)
                {
                    c[j1] = eui1.f();
                    eui1.a();
                }

                c[j1] = eui1.f();
                break;

            case 66: // 'B'
                int i3 = eup.a(eui1, 66);
                eam aeam[];
                int k1;
                if (d == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = d.length;
                }
                aeam = new eam[i3 + k1];
                if (d != null)
                {
                    System.arraycopy(d, 0, aeam, 0, k1);
                }
                for (d = aeam; k1 < d.length - 1; k1++)
                {
                    d[k1] = new eam();
                    eui1.a(d[k1]);
                    eui1.a();
                }

                d[k1] = new eam();
                eui1.a(d[k1]);
                break;

            case 74: // 'J'
                int j3 = eup.a(eui1, 74);
                dmg admg[];
                int l1;
                if (e == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = e.length;
                }
                admg = new dmg[j3 + l1];
                if (e != null)
                {
                    System.arraycopy(e, 0, admg, 0, l1);
                }
                for (e = admg; l1 < e.length - 1; l1++)
                {
                    e[l1] = new dmg();
                    eui1.a(e[l1]);
                    eui1.a();
                }

                e[l1] = new dmg();
                eui1.a(e[l1]);
                break;

            case 82: // 'R'
                int k3 = eup.a(eui1, 82);
                dkn adkn[];
                int i2;
                if (f == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = f.length;
                }
                adkn = new dkn[k3 + i2];
                if (f != null)
                {
                    System.arraycopy(f, 0, adkn, 0, i2);
                }
                for (f = adkn; i2 < f.length - 1; i2++)
                {
                    f[i2] = new dkn();
                    eui1.a(f[i2]);
                    eui1.a();
                }

                f[i2] = new dkn();
                eui1.a(f[i2]);
                break;

            case 90: // 'Z'
                int l3 = eup.a(eui1, 90);
                dmn admn[];
                int j2;
                if (g == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = g.length;
                }
                admn = new dmn[l3 + j2];
                if (g != null)
                {
                    System.arraycopy(g, 0, admn, 0, j2);
                }
                for (g = admn; j2 < g.length - 1; j2++)
                {
                    g[j2] = new dmn();
                    eui1.a(g[j2]);
                    eui1.a();
                }

                g[j2] = new dmn();
                eui1.a(g[j2]);
                break;

            case 98: // 'b'
                int i4 = eup.a(eui1, 98);
                dnd adnd[];
                int k2;
                if (l == null)
                {
                    k2 = 0;
                } else
                {
                    k2 = l.length;
                }
                adnd = new dnd[i4 + k2];
                if (l != null)
                {
                    System.arraycopy(l, 0, adnd, 0, k2);
                }
                for (l = adnd; k2 < l.length - 1; k2++)
                {
                    l[k2] = new dnd();
                    eui1.a(l[k2]);
                    eui1.a();
                }

                l[k2] = new dnd();
                eui1.a(l[k2]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        boolean flag = false;
        if (a != null)
        {
            euj1.a(1, a);
        }
        if (!b.equals(""))
        {
            euj1.a(2, b);
        }
        if (!h.equals(""))
        {
            euj1.a(3, h);
        }
        if (!i.equals(""))
        {
            euj1.a(4, i);
        }
        if (j != null)
        {
            euj1.a(5, j);
        }
        if (!k.equals(""))
        {
            euj1.a(6, k);
        }
        if (c != null)
        {
            String as[] = c;
            int k2 = as.length;
            for (int i1 = 0; i1 < k2; i1++)
            {
                euj1.a(7, as[i1]);
            }

        }
        if (d != null)
        {
            eam aeam[] = d;
            int l2 = aeam.length;
            for (int j1 = 0; j1 < l2; j1++)
            {
                eam eam1 = aeam[j1];
                if (eam1 != null)
                {
                    euj1.a(8, eam1);
                }
            }

        }
        if (e != null)
        {
            dmg admg[] = e;
            int i3 = admg.length;
            for (int k1 = 0; k1 < i3; k1++)
            {
                dmg dmg1 = admg[k1];
                if (dmg1 != null)
                {
                    euj1.a(9, dmg1);
                }
            }

        }
        if (f != null)
        {
            dkn adkn[] = f;
            int j3 = adkn.length;
            for (int l1 = 0; l1 < j3; l1++)
            {
                dkn dkn1 = adkn[l1];
                if (dkn1 != null)
                {
                    euj1.a(10, dkn1);
                }
            }

        }
        if (g != null)
        {
            dmn admn[] = g;
            int k3 = admn.length;
            for (int i2 = 0; i2 < k3; i2++)
            {
                dmn dmn1 = admn[i2];
                if (dmn1 != null)
                {
                    euj1.a(11, dmn1);
                }
            }

        }
        if (l != null)
        {
            dnd adnd[] = l;
            int l3 = adnd.length;
            for (int j2 = ((flag) ? 1 : 0); j2 < l3; j2++)
            {
                dnd dnd1 = adnd[j2];
                if (dnd1 != null)
                {
                    euj1.a(12, dnd1);
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
            if (!(obj instanceof dmd))
            {
                return false;
            }
            obj = (dmd)obj;
            if ((a != null ? a.equals(((dmd) (obj)).a) : ((dmd) (obj)).a == null) && (b != null ? b.equals(((dmd) (obj)).b) : ((dmd) (obj)).b == null) && (h != null ? h.equals(((dmd) (obj)).h) : ((dmd) (obj)).h == null) && (i != null ? i.equals(((dmd) (obj)).i) : ((dmd) (obj)).i == null) && (j != null ? j.equals(((dmd) (obj)).j) : ((dmd) (obj)).j == null) && (k != null ? k.equals(((dmd) (obj)).k) : ((dmd) (obj)).k == null) && (Arrays.equals(c, ((dmd) (obj)).c) && Arrays.equals(d, ((dmd) (obj)).d) && Arrays.equals(e, ((dmd) (obj)).e) && Arrays.equals(f, ((dmd) (obj)).f) && Arrays.equals(g, ((dmd) (obj)).g) && Arrays.equals(l, ((dmd) (obj)).l)))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dmd) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dmd) (obj)).O))
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
        boolean flag = false;
        int k2 = getClass().getName().hashCode();
        int l1;
        int i2;
        int j2;
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
        if (h == null)
        {
            k1 = 0;
        } else
        {
            k1 = h.hashCode();
        }
        if (i == null)
        {
            l1 = 0;
        } else
        {
            l1 = i.hashCode();
        }
        if (j == null)
        {
            i2 = 0;
        } else
        {
            i2 = j.hashCode();
        }
        if (k == null)
        {
            j2 = 0;
        } else
        {
            j2 = k.hashCode();
        }
        i1 = j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (k2 + 527) * 31) * 31) * 31) * 31) * 31) * 31;
        if (c != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L14:
        if (d != null) goto _L4; else goto _L3
_L3:
        j1 *= 31;
_L17:
        if (e != null) goto _L6; else goto _L5
_L5:
        j1 *= 31;
_L20:
        if (f != null) goto _L8; else goto _L7
_L7:
        j1 *= 31;
_L23:
        if (g != null) goto _L10; else goto _L9
_L9:
        j1 *= 31;
_L26:
        if (l != null) goto _L12; else goto _L11
_L11:
        k1 = j1 * 31;
_L29:
        if (O == null)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = O.hashCode();
        }
        return k1 * 31 + i1;
_L2:
        k1 = 0;
_L15:
        j1 = i1;
        if (k1 >= c.length) goto _L14; else goto _L13
_L13:
        if (c[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = c[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L15
          goto _L14
_L4:
        k1 = 0;
        i1 = j1;
_L18:
        j1 = i1;
        if (k1 >= d.length) goto _L17; else goto _L16
_L16:
        if (d[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = d[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L18
          goto _L17
_L6:
        k1 = 0;
        i1 = j1;
_L21:
        j1 = i1;
        if (k1 >= e.length) goto _L20; else goto _L19
_L19:
        if (e[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = e[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L21
          goto _L20
_L8:
        k1 = 0;
        i1 = j1;
_L24:
        j1 = i1;
        if (k1 >= f.length) goto _L23; else goto _L22
_L22:
        if (f[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = f[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L24
          goto _L23
_L10:
        k1 = 0;
        i1 = j1;
_L27:
        j1 = i1;
        if (k1 >= g.length) goto _L26; else goto _L25
_L25:
        if (g[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = g[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L27
          goto _L26
_L12:
        k1 = 0;
        i1 = j1;
        j1 = k1;
_L30:
        k1 = i1;
        if (j1 >= l.length) goto _L29; else goto _L28
_L28:
        if (l[j1] == null)
        {
            k1 = 0;
        } else
        {
            k1 = l[j1].hashCode();
        }
        i1 = k1 + i1 * 31;
        j1++;
          goto _L30
    }
}
