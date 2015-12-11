// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            s, ah, dj, dl, 
//            df

final class dd
{

    private final ah a;
    private dl b;
    private dj c;

    dd(ah ah1)
        throws s
    {
        int i = ah1.b;
        if (i < 21 || (i & 3) != 1)
        {
            throw s.a();
        } else
        {
            a = ah1;
            return;
        }
    }

    private int a(int i, int j, int k)
    {
        if (a.a(i, j))
        {
            return k << 1 | 1;
        } else
        {
            return k << 1;
        }
    }

    final dj a()
        throws s
    {
        int l = 0;
        if (c != null)
        {
            return c;
        }
        int i = 0;
        int k = 0;
        for (; i < 6; i++)
        {
            k = a(i, 8, k);
        }

        k = a(8, 7, a(8, 8, a(7, 8, k)));
        for (i = 5; i >= 0; i--)
        {
            k = a(8, i, k);
        }

        int j1 = a.b;
        int i1 = j1 - 1;
        i = l;
        for (l = i1; l >= j1 - 7; l--)
        {
            i = a(8, l, i);
        }

        i1 = j1 - 8;
        l = i;
        for (int j = i1; j < j1; j++)
        {
            l = a(j, 8, l);
        }

        c = dj.b(k, l);
        if (c != null)
        {
            return c;
        } else
        {
            throw s.a();
        }
    }

    final dl b()
        throws s
    {
        boolean flag = false;
        if (b != null)
        {
            return b;
        }
        int i1 = a.b;
        int i = i1 - 17 >> 2;
        if (i <= 6)
        {
            return dl.b(i);
        }
        int j1 = i1 - 11;
        i = 5;
        int j = 0;
        for (; i >= 0; i--)
        {
            for (int k = i1 - 9; k >= j1; k--)
            {
                j = a(k, i, j);
            }

        }

        b = dl.c(j);
        if (b != null && b.d() == i1)
        {
            return b;
        }
        i = 5;
        j = ((flag) ? 1 : 0);
        for (; i >= 0; i--)
        {
            for (int l = i1 - 9; l >= j1; l--)
            {
                j = a(i, l, j);
            }

        }

        b = dl.c(j);
        if (b != null && b.d() == i1)
        {
            return b;
        } else
        {
            throw s.a();
        }
    }

    final byte[] c()
        throws s
    {
        Object obj = a();
        dl dl1 = b();
        obj = df.a(((dj) (obj)).b());
        int k2 = a.b;
        ((df) (obj)).a(a, k2);
        obj = dl1.e();
        byte abyte0[] = new byte[dl1.c()];
        int i = k2 - 1;
        int j = 0;
        int k = 0;
        int l1 = 0;
        for (boolean flag = true; i > 0; flag ^= true)
        {
            int i1 = i;
            if (i == 6)
            {
                i1 = i - 1;
            }
            for (i = 0; i < k2;)
            {
                int l;
                int j1;
                int k1;
                int j2;
                if (flag)
                {
                    j1 = k2 - 1 - i;
                } else
                {
                    j1 = i;
                }
                k1 = 0;
                l = k;
                j2 = j;
                while (k1 < 2) 
                {
                    k = j2;
                    j = l;
                    int i2 = l1;
                    if (!((ah) (obj)).a(i1 - k1, j1))
                    {
                        j2++;
                        j = l << 1;
                        l = j;
                        if (a.a(i1 - k1, j1))
                        {
                            l = j | 1;
                        }
                        k = j2;
                        j = l;
                        i2 = l1;
                        if (j2 == 8)
                        {
                            abyte0[l1] = (byte)l;
                            j = 0;
                            i2 = l1 + 1;
                            k = 0;
                        }
                    }
                    k1++;
                    j2 = k;
                    l = j;
                    l1 = i2;
                }
                i++;
                j = j2;
                k = l;
            }

            i = i1 - 2;
        }

        if (l1 != dl1.c())
        {
            throw s.a();
        } else
        {
            return abyte0;
        }
    }
}
