// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            ah

abstract class df
{
    private static final class a extends df
    {

        final boolean a(int i, int j)
        {
            return (i + j & 1) == 0;
        }

        private a()
        {
            super((byte)0);
        }

        a(byte byte0)
        {
            this();
        }
    }

    private static final class b extends df
    {

        final boolean a(int i, int j)
        {
            return (i & 1) == 0;
        }

        private b()
        {
            super((byte)0);
        }

        b(byte byte0)
        {
            this();
        }
    }

    private static final class c extends df
    {

        final boolean a(int i, int j)
        {
            return j % 3 == 0;
        }

        private c()
        {
            super((byte)0);
        }

        c(byte byte0)
        {
            this();
        }
    }

    private static final class d extends df
    {

        final boolean a(int i, int j)
        {
            return (i + j) % 3 == 0;
        }

        private d()
        {
            super((byte)0);
        }

        d(byte byte0)
        {
            this();
        }
    }

    private static final class e extends df
    {

        final boolean a(int i, int j)
        {
            return ((i >>> 1) + j / 3 & 1) == 0;
        }

        private e()
        {
            super((byte)0);
        }

        e(byte byte0)
        {
            this();
        }
    }

    private static final class f extends df
    {

        final boolean a(int i, int j)
        {
            i *= j;
            return i % 3 + (i & 1) == 0;
        }

        private f()
        {
            super((byte)0);
        }

        f(byte byte0)
        {
            this();
        }
    }

    private static final class g extends df
    {

        final boolean a(int i, int j)
        {
            i *= j;
            return (i % 3 + (i & 1) & 1) == 0;
        }

        private g()
        {
            super((byte)0);
        }

        g(byte byte0)
        {
            this();
        }
    }

    private static final class h extends df
    {

        final boolean a(int i, int j)
        {
            return ((i + j & 1) + (i * j) % 3 & 1) == 0;
        }

        private h()
        {
            super((byte)0);
        }

        h(byte byte0)
        {
            this();
        }
    }


    private static final df a[] = {
        new a((byte)0), new b((byte)0), new c((byte)0), new d((byte)0), new e((byte)0), new f((byte)0), new g((byte)0), new h((byte)0)
    };

    private df()
    {
    }

    df(byte byte0)
    {
        this();
    }

    static df a(int i)
    {
        if (i < 0 || i > 7)
        {
            throw new IllegalArgumentException();
        } else
        {
            return a[i];
        }
    }

    final void a(ah ah1, int i)
    {
        for (int j = 0; j < i; j++)
        {
            for (int k = 0; k < i; k++)
            {
                if (a(j, k))
                {
                    int l = ah1.c * j + (k >> 5);
                    int ai[] = ah1.d;
                    ai[l] = ai[l] ^ 1 << (k & 0x1f);
                }
            }

        }

    }

    abstract boolean a(int i, int j);

}
