// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            v, ah, aa

public final class av
{

    private final ah a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public av(ah ah1)
        throws v
    {
        a = ah1;
        b = ah1.b;
        c = ah1.a;
        d = c - 30 >> 1;
        e = c + 30 >> 1;
        g = b - 30 >> 1;
        f = b + 30 >> 1;
        if (g < 0 || d < 0 || f >= b || e >= c)
        {
            throw v.a();
        } else
        {
            return;
        }
    }

    public av(ah ah1, int i, int j)
        throws v
    {
        a = ah1;
        b = ah1.b;
        c = ah1.a;
        d = i - 7;
        e = i + 7;
        g = j - 7;
        f = j + 7;
        if (g < 0 || d < 0 || f >= b || e >= c)
        {
            throw v.a();
        } else
        {
            return;
        }
    }

    private aa a(float f1, float f2, float f3, float f4)
    {
        float f5 = f1 - f3;
        float f6 = f2 - f4;
        int j = (int)((float)Math.sqrt(f5 * f5 + f6 * f6) + 0.5F);
        f3 = (f3 - f1) / (float)j;
        f4 = (f4 - f2) / (float)j;
        for (int i = 0; i < j; i++)
        {
            int k = (int)((float)i * f3 + f1 + 0.5F);
            int l = (int)((float)i * f4 + f2 + 0.5F);
            if (a.a(k, l))
            {
                return new aa(k, l);
            }
        }

        return null;
    }

    private boolean a(int i, int j, int k, boolean flag)
    {
        int l = i;
        if (!flag) goto _L2; else goto _L1
_L1:
        for (; i <= j; i++)
        {
            if (a.a(i, k))
            {
                return true;
            }
        }

          goto _L3
_L4:
        l++;
_L2:
        if (l > j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a.a(k, l))
        {
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        return false;
    }

    public final aa[] a()
        throws v
    {
        int i;
        int k;
        int i1;
        int i2;
        boolean flag1;
        int k2;
        boolean flag2;
        k = d;
        i2 = e;
        i = g;
        i1 = f;
        flag2 = false;
        k2 = 1;
        flag1 = false;
_L1:
        aa aa3;
        int j;
        int l;
        int j1;
        int l1;
        int j2;
        if (k2 == 0)
        {
            break MISSING_BLOCK_LABEL_943;
        }
        l = 0;
        boolean flag3 = true;
        j = i2;
        do
        {
            if (!flag3 || j >= c)
            {
                break;
            }
            boolean flag7 = a(i, i1, j, false);
            flag3 = flag7;
            if (flag7)
            {
                j++;
                l = 1;
                flag3 = flag7;
            }
        } while (true);
        aa aa1;
        if (j >= c)
        {
            boolean flag = true;
            l = j;
            j = i1;
            i1 = ((flag) ? 1 : 0);
        } else
        {
            boolean flag4 = true;
            j1 = l;
            l = i1;
            do
            {
                if (!flag4 || l >= b)
                {
                    break;
                }
                boolean flag8 = a(k, j, l, true);
                flag4 = flag8;
                if (flag8)
                {
                    l++;
                    j1 = 1;
                    flag4 = flag8;
                }
            } while (true);
            if (l >= b)
            {
                i1 = 1;
                j1 = j;
                j = l;
                l = j1;
            } else
            {
                boolean flag5 = true;
                j2 = j1;
                j1 = k;
                do
                {
                    if (!flag5 || j1 < 0)
                    {
                        break;
                    }
                    boolean flag9 = a(i, l, j1, false);
                    flag5 = flag9;
                    if (flag9)
                    {
                        j1--;
                        j2 = 1;
                        flag5 = flag9;
                    }
                } while (true);
                if (j1 < 0)
                {
                    i1 = 1;
                    int k1 = j;
                    k = j1;
                    j = l;
                    l = k1;
                } else
                {
label0:
                    {
                        boolean flag6 = true;
                        l1 = i;
                        do
                        {
                            if (!flag6 || l1 < 0)
                            {
                                break;
                            }
                            boolean flag10 = a(j1, j, l1, true);
                            flag6 = flag10;
                            if (flag10)
                            {
                                l1--;
                                j2 = 1;
                                flag6 = flag10;
                            }
                        } while (true);
                        if (l1 >= 0)
                        {
                            break label0;
                        }
                        i1 = 1;
                        i2 = j;
                        k = j1;
                        j = l;
                        i = l1;
                        l = i2;
                    }
                }
            }
        }
_L2:
        if (i1 != 0 || !flag1)
        {
            break MISSING_BLOCK_LABEL_939;
        }
        j1 = l - k;
        aa1 = null;
        i1 = 1;
        do
        {
            aa3 = aa1;
            if (i1 >= j1)
            {
                break;
            }
            aa1 = a(k, j - i1, k + i1, j);
            aa3 = aa1;
            if (aa1 != null)
            {
                break;
            }
            i1++;
        } while (true);
        break MISSING_BLOCK_LABEL_513;
        i1 = l;
        i = l1;
        i2 = j;
        k = j1;
        k2 = j2;
        if (j2 != 0)
        {
            flag1 = true;
            i1 = l;
            i = l1;
            i2 = j;
            k = j1;
            k2 = j2;
        }
          goto _L1
        if (aa3 == null)
        {
            throw v.a();
        }
        aa aa2 = null;
        i1 = 1;
        aa aa4;
        do
        {
            aa4 = aa2;
            if (i1 >= j1)
            {
                break;
            }
            aa2 = a(k, i + i1, k + i1, i);
            aa4 = aa2;
            if (aa2 != null)
            {
                break;
            }
            i1++;
        } while (true);
        if (aa4 == null)
        {
            throw v.a();
        }
        aa2 = null;
        k = 1;
        aa aa5;
        do
        {
            aa5 = aa2;
            if (k >= j1)
            {
                break;
            }
            aa2 = a(l, i + k, l - k, i);
            aa5 = aa2;
            if (aa2 != null)
            {
                break;
            }
            k++;
        } while (true);
        if (aa5 == null)
        {
            throw v.a();
        }
        aa2 = null;
        i = 1;
        aa aa6;
        do
        {
            aa6 = aa2;
            if (i >= j1)
            {
                break;
            }
            aa2 = a(l, j - i, l - i, j);
            aa6 = aa2;
            if (aa2 != null)
            {
                break;
            }
            i++;
        } while (true);
        if (aa6 == null)
        {
            throw v.a();
        }
        float f1 = aa6.a();
        float f2 = aa6.b();
        float f3 = aa3.a();
        float f4 = aa3.b();
        float f5 = aa5.a();
        float f6 = aa5.b();
        float f7 = aa4.a();
        float f8 = aa4.b();
        if (f1 < (float)(c / 2))
        {
            return (new aa[] {
                new aa(f7 - 1.0F, f8 + 1.0F), new aa(f3 + 1.0F, f4 + 1.0F), new aa(f5 - 1.0F, f6 - 1.0F), new aa(f1 + 1.0F, f2 - 1.0F)
            });
        } else
        {
            return (new aa[] {
                new aa(f7 + 1.0F, f8 + 1.0F), new aa(f3 + 1.0F, f4 - 1.0F), new aa(f5 - 1.0F, f6 + 1.0F), new aa(f1 - 1.0F, f2 - 1.0F)
            });
        }
        throw v.a();
        l = i2;
        j = i1;
        i1 = ((flag2) ? 1 : 0);
          goto _L2
    }
}
