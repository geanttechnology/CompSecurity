// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            ah, v, av, aa, 
//            az, ay, aw, ac, 
//            ar

public final class af
{
    private static final class a
    {

        public final int a;
        public final int b;

        public final aa a()
        {
            return new aa(a, b);
        }

        private a(int i, int j)
        {
            a = i;
            b = j;
        }

        a(int i, int j, byte byte0)
        {
            this(i, j);
        }
    }


    private final ah a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;

    public af(ah ah1)
    {
        a = ah1;
    }

    private int a(a a1, a a2)
    {
        float f3 = b(a1, a2);
        float f4 = (float)(a2.a - a1.a) / f3;
        float f5 = (float)(a2.b - a1.b) / f3;
        float f1 = a1.a;
        float f2 = a1.b;
        boolean flag = a.a(a1.a, a1.b);
        int j = 0;
        for (int i = 0; (float)i < f3;)
        {
            f1 += f4;
            f2 += f5;
            int k = j;
            if (a.a((int)(0.5F + f1), (int)(0.5F + f2)) != flag)
            {
                k = j + 1;
            }
            i++;
            j = k;
        }

        f1 = (float)j / f3;
        if ((double)f1 > 0.10000000000000001D && (double)f1 < 0.90000000000000002D)
        {
            return 0;
        }
        if ((double)f1 <= 0.10000000000000001D)
        {
            return !flag ? -1 : 1;
        }
        return !flag ? 1 : -1;
    }

    private a a(a a1, boolean flag, int i, int j)
    {
        int l = a1.a + i;
        int k;
        for (k = a1.b + j; a(l, k) && a.a(l, k) == flag; k += j)
        {
            l += i;
        }

        int i1 = l - i;
        l = k - j;
        for (k = i1; a(k, l) && a.a(k, l) == flag; k += i) { }
        k -= i;
        for (i = l; a(k, i) && a.a(k, i) == flag; i += j) { }
        return new a(k, i - j, (byte)0);
    }

    private boolean a(int i, int j)
    {
        return i >= 0 && i < a.a && j > 0 && j < a.b;
    }

    private boolean[] a(a a1, a a2, int i)
    {
        boolean aflag[] = new boolean[i];
        float f1 = b(a1, a2);
        float f2 = f1 / (float)(i - 1);
        float f3 = ((float)(a2.a - a1.a) * f2) / f1;
        float f4 = (f2 * (float)(a2.b - a1.b)) / f1;
        f2 = a1.a;
        f1 = a1.b;
        for (int j = 0; j < i; j++)
        {
            aflag[j] = a.a((int)(f2 + 0.5F), (int)(f1 + 0.5F));
            f2 += f3;
            f1 += f4;
        }

        return aflag;
    }

    private static float b(a a1, a a2)
    {
        return (float)Math.sqrt((a1.a - a2.a) * (a1.a - a2.a) + (a1.b - a2.b) * (a1.b - a2.b));
    }

    private a b()
    {
        aa aaa[] = (new av(a)).a();
        Object obj;
        aa aa1;
        aa aa2;
        aa aa3;
        aa3 = aaa[0];
        aa2 = aaa[1];
        aa1 = aaa[2];
        obj = aaa[3];
_L1:
        int i;
        int j;
        i = (int)((aa3.a() + ((aa) (obj)).a() + aa2.a() + aa1.a()) / 4F + 0.5F);
        float f1 = aa3.b();
        j = (int)((((aa) (obj)).b() + f1 + aa2.b() + aa1.b()) / 4F + 0.5F);
        obj = (new av(a, i, j)).a();
        aa3 = obj[0];
        aa2 = obj[1];
        aa1 = obj[2];
        obj = obj[3];
_L2:
        i = (int)((aa3.a() + ((aa) (obj)).a() + aa2.a() + aa1.a()) / 4F + 0.5F);
        float f2 = aa3.b();
        return new a(i, (int)((((aa) (obj)).b() + f2 + aa2.b() + aa1.b()) / 4F + 0.5F), (byte)0);
        v v1;
        v1;
        i = a.a / 2;
        j = a.b / 2;
        aa3 = a(new a(i + 7, j - 7, (byte)0), false, 1, -1).a();
        aa2 = a(new a(i + 7, j + 7, (byte)0), false, 1, 1).a();
        aa1 = a(new a(i - 7, j + 7, (byte)0), false, -1, 1).a();
        v1 = a(new a(i - 7, j - 7, (byte)0), false, -1, -1).a();
          goto _L1
        v1;
        aa3 = a(new a(i + 7, j - 7, (byte)0), false, 1, -1).a();
        aa2 = a(new a(i + 7, j + 7, (byte)0), false, 1, 1).a();
        aa1 = a(new a(i - 7, j + 7, (byte)0), false, -1, 1).a();
        v1 = a(new a(i - 7, j - 7, (byte)0), false, -1, -1).a();
          goto _L2
    }

    public final ac a()
        throws v
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        boolean flag;
        obj = b();
        flag = true;
        e = 1;
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
_L12:
        if (e >= 9) goto _L2; else goto _L1
_L1:
        a a1;
        a a2;
        a a3;
        a a4;
        a1 = a(((a) (obj3)), flag, 1, -1);
        a2 = a(((a) (obj2)), flag, 1, 1);
        a3 = a(((a) (obj1)), flag, -1, 1);
        a4 = a(((a) (obj)), flag, -1, -1);
        if (e <= 2) goto _L4; else goto _L3
_L3:
        float f1 = (b(a4, a1) * (float)e) / (b(((a) (obj)), ((a) (obj3))) * (float)(e + 2));
        if ((double)f1 < 0.75D || (double)f1 > 1.25D) goto _L2; else goto _L5
_L5:
        a a5;
        a a6;
        a a7;
        a a8;
        int i;
        a5 = new a(a1.a - 3, a1.b + 3, (byte)0);
        a6 = new a(a2.a - 3, a2.b - 3, (byte)0);
        a7 = new a(a3.a + 3, a3.b - 3, (byte)0);
        a8 = new a(a4.a + 3, a4.b + 3, (byte)0);
        i = a(a8, a5);
        if (i == 0) goto _L7; else goto _L6
_L6:
        int k = a(a5, a6);
        if (k == i && k != 0) goto _L9; else goto _L8
_L8:
        i = 0;
_L10:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        int l;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = e + 1;
        obj = a4;
        obj1 = a3;
        obj2 = a2;
        obj3 = a1;
        continue; /* Loop/switch isn't completed */
_L9:
        l = a(a6, a7);
        if (l != i || l == 0)
        {
            i = 0;
            continue; /* Loop/switch isn't completed */
        }
        l = a(a7, a8);
        if (l == i && l != 0)
        {
            i = 1;
            continue; /* Loop/switch isn't completed */
        }
_L7:
        i = 0;
        if (true) goto _L10; else goto _L2
_L2:
        if (e != 5 && e != 7)
        {
            throw v.a();
        }
        float f2;
        float f3;
        int j;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        boolean flag1;
        if (e == 5)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        b = flag1;
        f2 = 1.5F / (float)(e * 2 - 3);
        j1 = ((a) (obj3)).a - ((a) (obj1)).a;
        k1 = ((a) (obj3)).b - ((a) (obj1)).b;
        j = (int)(((float)((a) (obj1)).a - (float)j1 * f2) + 0.5F);
        i1 = (int)(((float)((a) (obj1)).b - (float)k1 * f2) + 0.5F);
        f3 = ((a) (obj3)).a;
        j1 = (int)((float)j1 * f2 + f3 + 0.5F);
        f3 = ((a) (obj3)).b;
        k1 = (int)((float)k1 * f2 + f3 + 0.5F);
        k2 = ((a) (obj2)).a - ((a) (obj)).a;
        j2 = ((a) (obj2)).b - ((a) (obj)).b;
        l1 = (int)(((float)((a) (obj)).a - (float)k2 * f2) + 0.5F);
        i2 = (int)(((float)((a) (obj)).b - (float)j2 * f2) + 0.5F);
        f3 = ((a) (obj2)).a;
        k2 = (int)((float)k2 * f2 + f3 + 0.5F);
        f3 = ((a) (obj2)).b;
        j2 = (int)(f2 * (float)j2 + f3 + 0.5F);
        if (!a(j1, k1) || !a(k2, j2) || !a(j, i1) || !a(l1, i2))
        {
            throw v.a();
        }
        obj = new a(j1, k1, (byte)0);
        obj1 = new a(k2, j2, (byte)0);
        obj3 = new a(j, i1, (byte)0);
        Object obj4 = new a(l1, i2, (byte)0);
        a aa1[] = new a[4];
        aa1[0] = ((a) (obj));
        aa1[1] = ((a) (obj1));
        aa1[2] = ((a) (obj3));
        aa1[3] = ((a) (obj4));
        obj = a(aa1[0], aa1[1], e * 2 + 1);
        int ai[] = a(aa1[1], aa1[2], e * 2 + 1);
        boolean aflag2[] = a(aa1[2], aa1[3], e * 2 + 1);
        boolean aflag3[] = a(aa1[3], aa1[0], e * 2 + 1);
        if (obj[0] && obj[e * 2])
        {
            f = 0;
        } else
        if (ai[0] && ai[e * 2])
        {
            f = 1;
        } else
        if (aflag2[0] && aflag2[e * 2])
        {
            f = 2;
        } else
        if (aflag3[0] && aflag3[e * 2])
        {
            f = 3;
        } else
        {
            throw v.a();
        }
        if (b)
        {
            boolean aflag[] = new boolean[28];
            for (j = 0; j < 7; j++)
            {
                aflag[j] = obj[j + 2];
                aflag[j + 7] = ai[j + 2];
                aflag[j + 14] = aflag2[j + 2];
                aflag[j + 21] = aflag3[j + 2];
            }

            ai = new boolean[28];
            j = 0;
            do
            {
                obj = ai;
                if (j >= 28)
                {
                    break;
                }
                ai[j] = aflag[(f * 7 + j) % 28];
                j++;
            } while (true);
        } else
        {
            boolean aflag1[] = new boolean[40];
            for (j = 0; j < 11; j++)
            {
                if (j < 5)
                {
                    aflag1[j] = obj[j + 2];
                    aflag1[j + 10] = ai[j + 2];
                    aflag1[j + 20] = aflag2[j + 2];
                    aflag1[j + 30] = aflag3[j + 2];
                }
                if (j > 5)
                {
                    aflag1[j - 1] = obj[j + 2];
                    aflag1[(j + 10) - 1] = ai[j + 2];
                    aflag1[(j + 20) - 1] = aflag2[j + 2];
                    aflag1[(j + 30) - 1] = aflag3[j + 2];
                }
            }

            ai = new boolean[40];
            j = 0;
            do
            {
                obj = ai;
                if (j >= 40)
                {
                    break;
                }
                ai[j] = aflag1[(f * 10 + j) % 40];
                j++;
            } while (true);
        }
        if (b)
        {
            i1 = 7;
            j = 2;
        } else
        {
            i1 = 10;
            j = 4;
        }
        ai = new int[i1];
        for (j1 = 0; j1 < i1; j1++)
        {
            l1 = 1;
            for (k1 = 1; k1 <= 4; k1++)
            {
                if (obj[(j1 * 4 + 4) - k1])
                {
                    ai[j1] = ai[j1] + l1;
                }
                l1 <<= 1;
            }

        }

        try
        {
            (new ay(aw.d)).a(ai, i1 - j);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw v.a();
        }
        for (i1 = 0; i1 < j; i1++)
        {
            k1 = 1;
            j1 = 1;
            while (j1 <= 4) 
            {
                boolean flag2;
                if ((ai[i1] & k1) == k1)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                obj[(i1 * 4 + 4) - j1] = flag2;
                k1 <<= 1;
                j1++;
            }
        }

        if (b)
        {
            j = 2;
            i1 = 6;
        } else
        {
            j = 5;
            i1 = 11;
        }
        for (j1 = 0; j1 < j; j1++)
        {
            c = c << 1;
            if (obj[j1])
            {
                c = c + 1;
            }
        }

        for (j1 = j; j1 < j + i1; j1++)
        {
            d = d << 1;
            if (obj[j1])
            {
                d = d + 1;
            }
        }

        c = c + 1;
        d = d + 1;
        i1 = c;
        if (c > 4)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        f2 = (float)(j + i1 * 2 + (c - 4) / 8) / (2.0F * (float)e);
        i1 = aa1[0].a - aa1[2].a;
        if (i1 > 0)
        {
            j = 1;
        } else
        {
            j = -1;
        }
        k1 = i1 + j;
        i1 = aa1[0].b - aa1[2].b;
        if (i1 > 0)
        {
            j = 1;
        } else
        {
            j = -1;
        }
        j += i1;
        i1 = (int)(((float)aa1[2].a - (float)k1 * f2) + 0.5F);
        j1 = (int)(((float)aa1[2].b - (float)j * f2) + 0.5F);
        f3 = aa1[0].a;
        k1 = (int)((float)k1 * f2 + f3 + 0.5F);
        f3 = aa1[0].b;
        l1 = (int)((float)j * f2 + f3 + 0.5F);
        i2 = aa1[1].a - aa1[3].a;
        if (i2 > 0)
        {
            j = 1;
        } else
        {
            j = -1;
        }
        i2 += j;
        j2 = aa1[1].b - aa1[3].b;
        if (j2 > 0)
        {
            j = 1;
        } else
        {
            j = -1;
        }
        k2 = j + j2;
        j = (int)(((float)aa1[3].a - (float)i2 * f2) + 0.5F);
        j2 = (int)(((float)aa1[3].b - (float)k2 * f2) + 0.5F);
        f3 = aa1[1].a;
        i2 = (int)((float)i2 * f2 + f3 + 0.5F);
        f3 = aa1[1].b;
        k2 = (int)((float)k2 * f2 + f3 + 0.5F);
        if (!a(k1, l1) || !a(i2, k2) || !a(i1, j1) || !a(j, j2))
        {
            throw v.a();
        }
        aa aaa[] = new aa[4];
        aaa[0] = new aa(k1, l1);
        aaa[1] = new aa(i2, k2);
        aaa[2] = new aa(i1, j1);
        aaa[3] = new aa(j, j2);
        ai = a;
        aa1 = aaa[f % 4];
        aflag1 = aaa[(f + 3) % 4];
        aflag2 = aaa[(f + 2) % 4];
        aa aa2 = aaa[(f + 1) % 4];
        if (b)
        {
            j = c * 4 + 11;
        } else
        if (c <= 4)
        {
            j = c * 4 + 15;
        } else
        {
            j = c * 4 + ((c - 4) / 8 + 1) * 2 + 15;
        }
        return new ac(ar.a().a(ai, j, j, 0.5F, 0.5F, (float)j - 0.5F, 0.5F, (float)j - 0.5F, (float)j - 0.5F, 0.5F, (float)j - 0.5F, aa1.a(), aa1.b(), aa2.a(), aa2.b(), aflag2.a(), aflag2.b(), aflag1.a(), aflag1.b()), aaa, b, d, c);
        if (true) goto _L12; else goto _L11
_L11:
    }
}
