// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            ax

public final class aw
{

    public static final aw a = new aw(4201, 4096);
    public static final aw b = new aw(1033, 1024);
    public static final aw c = new aw(67, 64);
    public static final aw d = new aw(19, 16);
    public static final aw e = new aw(285, 256);
    public static final aw f;
    public static final aw g;
    private int h[];
    private int i[];
    private ax j;
    private ax k;
    private final int l;
    private final int m;
    private boolean n;

    private aw(int i1, int j1)
    {
        n = false;
        m = i1;
        l = j1;
        if (j1 <= 0)
        {
            d();
        }
    }

    static int b(int i1, int j1)
    {
        return i1 ^ j1;
    }

    private void d()
    {
        h = new int[l];
        i = new int[l];
        int k1 = 0;
        int i1 = 1;
        for (; k1 < l; k1++)
        {
            h[k1] = i1;
            int l1 = i1 << 1;
            i1 = l1;
            if (l1 >= l)
            {
                i1 = (l1 ^ m) & l - 1;
            }
        }

        for (int j1 = 0; j1 < l - 1; j1++)
        {
            i[h[j1]] = j1;
        }

        j = new ax(this, new int[] {
            0
        });
        k = new ax(this, new int[] {
            1
        });
        n = true;
    }

    private void e()
    {
        if (!n)
        {
            d();
        }
    }

    final int a(int i1)
    {
        e();
        return h[i1];
    }

    final ax a()
    {
        e();
        return j;
    }

    final ax a(int i1, int j1)
    {
        e();
        if (i1 < 0)
        {
            throw new IllegalArgumentException();
        }
        if (j1 == 0)
        {
            return j;
        } else
        {
            int ai[] = new int[i1 + 1];
            ai[0] = j1;
            return new ax(this, ai);
        }
    }

    final int b(int i1)
    {
        e();
        if (i1 == 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            return i[i1];
        }
    }

    final ax b()
    {
        e();
        return k;
    }

    public final int c()
    {
        return l;
    }

    final int c(int i1)
    {
        e();
        if (i1 == 0)
        {
            throw new ArithmeticException();
        } else
        {
            return h[l - i[i1] - 1];
        }
    }

    final int c(int i1, int j1)
    {
        int k1;
label0:
        {
            e();
            if (i1 == 0 || j1 == 0)
            {
                return 0;
            }
            if (i1 >= 0 && j1 >= 0 && i1 < l)
            {
                k1 = i1;
                if (j1 < l)
                {
                    break label0;
                }
            }
            k1 = i1 + 1;
        }
        i1 = i[k1] + i[j1];
        int ai[] = h;
        j1 = l;
        return ai[i1 / l + i1 % j1];
    }

    static 
    {
        aw aw1 = new aw(301, 256);
        f = aw1;
        g = aw1;
    }
}
