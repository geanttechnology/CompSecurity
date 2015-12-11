// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;

public final class agp extends agu
{

    public byte a[];
    public String b;
    public double c;
    public float d;
    public long e;
    public int f;
    public int g;
    public boolean h;
    public agn i[];
    public ago j[];
    public String k[];
    public long l[];
    public float m[];
    public long n;

    public agp()
    {
        a();
    }

    public agp a()
    {
        a = ahd.h;
        b = "";
        c = 0.0D;
        d = 0.0F;
        e = 0L;
        f = 0;
        g = 0;
        h = false;
        i = agn.a();
        j = ago.a();
        k = ahd.f;
        l = ahd.b;
        m = ahd.c;
        n = 0L;
        o = null;
        p = -1;
        return this;
    }

    public agp a(agr agr1)
    {
        do
        {
            int i1 = agr1.a();
            switch (i1)
            {
            default:
                if (a(agr1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                a = agr1.i();
                break;

            case 18: // '\022'
                b = agr1.h();
                break;

            case 25: // '\031'
                c = agr1.c();
                break;

            case 37: // '%'
                d = agr1.d();
                break;

            case 40: // '('
                e = agr1.e();
                break;

            case 48: // '0'
                f = agr1.f();
                break;

            case 56: // '8'
                g = agr1.j();
                break;

            case 64: // '@'
                h = agr1.g();
                break;

            case 74: // 'J'
                int i3 = ahd.a(agr1, 74);
                agn aagn[];
                int j1;
                if (i == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = i.length;
                }
                aagn = new agn[i3 + j1];
                i3 = j1;
                if (j1 != 0)
                {
                    System.arraycopy(i, 0, aagn, 0, j1);
                    i3 = j1;
                }
                for (; i3 < aagn.length - 1; i3++)
                {
                    aagn[i3] = new agn();
                    agr1.a(aagn[i3]);
                    agr1.a();
                }

                aagn[i3] = new agn();
                agr1.a(aagn[i3]);
                i = aagn;
                break;

            case 82: // 'R'
                int j3 = ahd.a(agr1, 82);
                ago aago[];
                int k1;
                if (j == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = j.length;
                }
                aago = new ago[j3 + k1];
                j3 = k1;
                if (k1 != 0)
                {
                    System.arraycopy(j, 0, aago, 0, k1);
                    j3 = k1;
                }
                for (; j3 < aago.length - 1; j3++)
                {
                    aago[j3] = new ago();
                    agr1.a(aago[j3]);
                    agr1.a();
                }

                aago[j3] = new ago();
                agr1.a(aago[j3]);
                j = aago;
                break;

            case 90: // 'Z'
                int k3 = ahd.a(agr1, 90);
                String as[];
                int l1;
                if (k == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = k.length;
                }
                as = new String[k3 + l1];
                k3 = l1;
                if (l1 != 0)
                {
                    System.arraycopy(k, 0, as, 0, l1);
                    k3 = l1;
                }
                for (; k3 < as.length - 1; k3++)
                {
                    as[k3] = agr1.h();
                    agr1.a();
                }

                as[k3] = agr1.h();
                k = as;
                break;

            case 96: // '`'
                int l3 = ahd.a(agr1, 96);
                long al[];
                int i2;
                if (l == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = l.length;
                }
                al = new long[l3 + i2];
                l3 = i2;
                if (i2 != 0)
                {
                    System.arraycopy(l, 0, al, 0, i2);
                    l3 = i2;
                }
                for (; l3 < al.length - 1; l3++)
                {
                    al[l3] = agr1.e();
                    agr1.a();
                }

                al[l3] = agr1.e();
                l = al;
                break;

            case 98: // 'b'
                int l4 = agr1.d(agr1.k());
                int j2 = agr1.q();
                int i4;
                for (i4 = 0; agr1.o() > 0; i4++)
                {
                    agr1.e();
                }

                agr1.f(j2);
                long al1[];
                if (l == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = l.length;
                }
                al1 = new long[i4 + j2];
                i4 = j2;
                if (j2 != 0)
                {
                    System.arraycopy(l, 0, al1, 0, j2);
                    i4 = j2;
                }
                for (; i4 < al1.length; i4++)
                {
                    al1[i4] = agr1.e();
                }

                l = al1;
                agr1.e(l4);
                break;

            case 104: // 'h'
                n = agr1.e();
                break;

            case 117: // 'u'
                int j4 = ahd.a(agr1, 117);
                float af[];
                int k2;
                if (m == null)
                {
                    k2 = 0;
                } else
                {
                    k2 = m.length;
                }
                af = new float[j4 + k2];
                j4 = k2;
                if (k2 != 0)
                {
                    System.arraycopy(m, 0, af, 0, k2);
                    j4 = k2;
                }
                for (; j4 < af.length - 1; j4++)
                {
                    af[j4] = agr1.d();
                    agr1.a();
                }

                af[j4] = agr1.d();
                m = af;
                break;

            case 114: // 'r'
                int l2 = agr1.k();
                int i5 = agr1.d(l2);
                int k4 = l2 / 4;
                float af1[];
                if (m == null)
                {
                    l2 = 0;
                } else
                {
                    l2 = m.length;
                }
                af1 = new float[k4 + l2];
                k4 = l2;
                if (l2 != 0)
                {
                    System.arraycopy(m, 0, af1, 0, l2);
                    k4 = l2;
                }
                for (; k4 < af1.length; k4++)
                {
                    af1[k4] = agr1.d();
                }

                m = af1;
                agr1.e(i5);
                break;
            }
        } while (true);
    }

    public void a(ags ags1)
    {
        boolean flag = false;
        if (!Arrays.equals(a, ahd.h))
        {
            ags1.a(1, a);
        }
        if (!b.equals(""))
        {
            ags1.a(2, b);
        }
        if (Double.doubleToLongBits(c) != Double.doubleToLongBits(0.0D))
        {
            ags1.a(3, c);
        }
        if (Float.floatToIntBits(d) != Float.floatToIntBits(0.0F))
        {
            ags1.a(4, d);
        }
        if (e != 0L)
        {
            ags1.a(5, e);
        }
        if (f != 0)
        {
            ags1.a(6, f);
        }
        if (g != 0)
        {
            ags1.b(7, g);
        }
        if (h)
        {
            ags1.a(8, h);
        }
        if (i != null && i.length > 0)
        {
            for (int i1 = 0; i1 < i.length; i1++)
            {
                agn agn1 = i[i1];
                if (agn1 != null)
                {
                    ags1.a(9, agn1);
                }
            }

        }
        if (j != null && j.length > 0)
        {
            for (int j1 = 0; j1 < j.length; j1++)
            {
                ago ago1 = j[j1];
                if (ago1 != null)
                {
                    ags1.a(10, ago1);
                }
            }

        }
        if (k != null && k.length > 0)
        {
            for (int k1 = 0; k1 < k.length; k1++)
            {
                String s = k[k1];
                if (s != null)
                {
                    ags1.a(11, s);
                }
            }

        }
        if (l != null && l.length > 0)
        {
            for (int l1 = 0; l1 < l.length; l1++)
            {
                ags1.a(12, l[l1]);
            }

        }
        if (n != 0L)
        {
            ags1.a(13, n);
        }
        if (m != null && m.length > 0)
        {
            for (int i2 = ((flag) ? 1 : 0); i2 < m.length; i2++)
            {
                ags1.a(14, m[i2]);
            }

        }
        super.a(ags1);
    }

    public aha b(agr agr1)
    {
        return a(agr1);
    }

    protected int c()
    {
        boolean flag = false;
        int j1 = super.c();
        int i1 = j1;
        if (!Arrays.equals(a, ahd.h))
        {
            i1 = j1 + ags.b(1, a);
        }
        j1 = i1;
        if (!b.equals(""))
        {
            j1 = i1 + ags.b(2, b);
        }
        i1 = j1;
        if (Double.doubleToLongBits(c) != Double.doubleToLongBits(0.0D))
        {
            i1 = j1 + ags.b(3, c);
        }
        j1 = i1;
        if (Float.floatToIntBits(d) != Float.floatToIntBits(0.0F))
        {
            j1 = i1 + ags.b(4, d);
        }
        i1 = j1;
        if (e != 0L)
        {
            i1 = j1 + ags.b(5, e);
        }
        j1 = i1;
        if (f != 0)
        {
            j1 = i1 + ags.c(6, f);
        }
        int k1 = j1;
        if (g != 0)
        {
            k1 = j1 + ags.d(7, g);
        }
        i1 = k1;
        if (h)
        {
            i1 = k1 + ags.b(8, h);
        }
        j1 = i1;
        if (i != null)
        {
            j1 = i1;
            if (i.length > 0)
            {
                for (j1 = 0; j1 < i.length;)
                {
                    agn agn1 = i[j1];
                    int l1 = i1;
                    if (agn1 != null)
                    {
                        l1 = i1 + ags.c(9, agn1);
                    }
                    j1++;
                    i1 = l1;
                }

                j1 = i1;
            }
        }
        i1 = j1;
        if (j != null)
        {
            i1 = j1;
            if (j.length > 0)
            {
                i1 = j1;
                for (j1 = 0; j1 < j.length;)
                {
                    ago ago1 = j[j1];
                    int i2 = i1;
                    if (ago1 != null)
                    {
                        i2 = i1 + ags.c(10, ago1);
                    }
                    j1++;
                    i1 = i2;
                }

            }
        }
        j1 = i1;
        if (k != null)
        {
            j1 = i1;
            if (k.length > 0)
            {
                j1 = 0;
                int j2 = 0;
                int l2;
                int i3;
                for (l2 = 0; j1 < k.length; l2 = i3)
                {
                    String s = k[j1];
                    int j3 = j2;
                    i3 = l2;
                    if (s != null)
                    {
                        i3 = l2 + 1;
                        j3 = j2 + ags.b(s);
                    }
                    j1++;
                    j2 = j3;
                }

                j1 = i1 + j2 + l2 * 1;
            }
        }
        i1 = j1;
        if (l != null)
        {
            i1 = j1;
            if (l.length > 0)
            {
                int k2 = 0;
                for (i1 = ((flag) ? 1 : 0); i1 < l.length; i1++)
                {
                    k2 += ags.b(l[i1]);
                }

                i1 = j1 + k2 + l.length * 1;
            }
        }
        j1 = i1;
        if (n != 0L)
        {
            j1 = i1 + ags.b(13, n);
        }
        i1 = j1;
        if (m != null)
        {
            i1 = j1;
            if (m.length > 0)
            {
                i1 = j1 + m.length * 4 + m.length * 1;
            }
        }
        return i1;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof agp))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (agp)obj;
        flag = flag1;
        if (!Arrays.equals(a, ((agp) (obj)).a))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (b != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((agp) (obj)).b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        flag = flag1;
        if (Double.doubleToLongBits(c) == Double.doubleToLongBits(((agp) (obj)).c))
        {
            flag = flag1;
            if (Float.floatToIntBits(d) == Float.floatToIntBits(((agp) (obj)).d))
            {
                flag = flag1;
                if (e == ((agp) (obj)).e)
                {
                    flag = flag1;
                    if (f == ((agp) (obj)).f)
                    {
                        flag = flag1;
                        if (g == ((agp) (obj)).g)
                        {
                            flag = flag1;
                            if (h == ((agp) (obj)).h)
                            {
                                flag = flag1;
                                if (agy.a(i, ((agp) (obj)).i))
                                {
                                    flag = flag1;
                                    if (agy.a(j, ((agp) (obj)).j))
                                    {
                                        flag = flag1;
                                        if (agy.a(k, ((agp) (obj)).k))
                                        {
                                            flag = flag1;
                                            if (agy.a(l, ((agp) (obj)).l))
                                            {
                                                flag = flag1;
                                                if (agy.a(m, ((agp) (obj)).m))
                                                {
                                                    flag = flag1;
                                                    if (n == ((agp) (obj)).n)
                                                    {
                                                        return a(((agu) (obj)));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!b.equals(((agp) (obj)).b))
        {
            return false;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public int hashCode()
    {
        int j1 = Arrays.hashCode(a);
        int i1;
        char c1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        long l2;
        if (b == null)
        {
            i1 = 0;
        } else
        {
            i1 = b.hashCode();
        }
        l2 = Double.doubleToLongBits(c);
        k1 = (int)(l2 ^ l2 >>> 32);
        l1 = Float.floatToIntBits(d);
        i2 = (int)(e ^ e >>> 32);
        j2 = f;
        k2 = g;
        if (h)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        return (((((((c1 + ((((((i1 + (j1 + 527) * 31) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31) * 31 + agy.a(i)) * 31 + agy.a(j)) * 31 + agy.a(k)) * 31 + agy.a(l)) * 31 + agy.a(m)) * 31 + (int)(n ^ n >>> 32)) * 31 + d();
    }
}
