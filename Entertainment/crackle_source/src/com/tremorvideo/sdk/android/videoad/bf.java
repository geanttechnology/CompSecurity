// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;


// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            n

public abstract class bf
{
    public static interface a
    {

        public abstract void a(bf bf1);
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        private static final b g[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/videoad/bf$b, s);
        }

        public static b[] values()
        {
            return (b[])g.clone();
        }

        static 
        {
            a = new b("Invalid", 0);
            b = new b("Complete", 1);
            c = new b("Error", 2);
            d = new b("FatalError", 3);
            e = new b("Cancelled", 4);
            f = new b("Timeout", 5);
            g = (new b[] {
                a, b, c, d, e, f
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        private static final c d[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/tremorvideo/sdk/android/videoad/bf$c, s);
        }

        public static c[] values()
        {
            return (c[])d.clone();
        }

        static 
        {
            a = new c("Initialized", 0);
            b = new c("Stopped", 1);
            c = new c("Running", 2);
            d = (new c[] {
                a, b, c
            });
        }

        private c(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class d extends Enum
    {

        public static final d a;
        public static final d b;
        public static final d c;
        public static final d d;
        public static final d e;
        public static final d f;
        public static final d g;
        public static final d h;
        public static final d i;
        private static final d j[];

        public static d valueOf(String s)
        {
            return (d)Enum.valueOf(com/tremorvideo/sdk/android/videoad/bf$d, s);
        }

        public static d[] values()
        {
            return (d[])j.clone();
        }

        static 
        {
            a = new d("Asset", 0);
            b = new d("Video", 1);
            c = new d("Survey", 2);
            d = new d("HTML5", 3);
            e = new d("VAST", 4);
            f = new d("ProcessBIN", 5);
            g = new d("ProcessEmbedPlayer", 6);
            h = new d("ProcessMovieBoard", 7);
            i = new d("Invalid", 8);
            j = (new d[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private d(String s, int k)
        {
            super(s, k);
        }
    }


    private c a;
    private b b;
    private a c;

    public bf(a a1)
    {
        c = a1;
        b = b.a;
        a = c.a;
    }

    public b a()
    {
        return b;
    }

    protected void a(b b1)
    {
        a = c.b;
        b = b1;
        c.a(this);
    }

    public void a(String s, n n)
        throws Exception
    {
    }

    public void b()
    {
        if (a == c.a)
        {
            a = c.c;
            b = b.a;
            e();
        }
    }

    public void c()
    {
        if (a == c.c)
        {
            f();
        }
    }

    public void d()
    {
        if (a == c.b)
        {
            a = c.c;
            g();
        }
    }

    protected abstract void e();

    protected abstract void f();

    protected abstract void g();
}
