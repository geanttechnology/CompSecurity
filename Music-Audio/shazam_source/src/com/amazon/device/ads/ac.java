// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            co, cn

public class ac
{
    private static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/amazon/device/ads/ac$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("MODAL", 0);
            b = new a("MODELESS", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int i1)
        {
            super(s, i1);
        }
    }

    private static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        private static final b c[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/amazon/device/ads/ac$b, s);
        }

        public static b[] values()
        {
            return (b[])c.clone();
        }

        static 
        {
            a = new b("CAN_UPSCALE", 0);
            b = new b("NO_UPSCALE", 1);
            c = (new b[] {
                a, b
            });
        }

        private b(String s, int i1)
        {
            super(s, i1);
        }
    }

    static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        private static final c d[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/amazon/device/ads/ac$c, s);
        }

        public static c[] values()
        {
            return (c[])d.clone();
        }

        static 
        {
            a = new c("EXPLICIT", 0);
            b = new c("AUTO", 1);
            c = new c("INTERSTITIAL", 2);
            d = (new c[] {
                a, b, c
            });
        }

        private c(String s, int i1)
        {
            super(s, i1);
        }
    }


    public static final ac a = new ac(300, 50);
    public static final ac b = new ac(320, 50);
    public static final ac c = new ac(300, 250);
    public static final ac d = new ac(600, 90);
    public static final ac e = new ac(728, 90);
    public static final ac f = new ac(1024, 50);
    public static final ac g;
    public static final ac h;
    static final ac i;
    static final ac j;
    private static final String n = com/amazon/device/ads/ac.getSimpleName();
    int k;
    c l;
    a m;
    private int o;
    private int p;
    private b q;
    private final cn r;

    public ac(int i1, int j1)
    {
        k = 17;
        l = c.a;
        m = a.b;
        q = b.a;
        new co();
        r = co.a(n);
        if (i1 <= 0 || j1 <= 0)
        {
            r.d("The width and height must be positive integers.", null);
            throw new IllegalArgumentException("The width and height must be positive integers.");
        } else
        {
            o = i1;
            p = j1;
            l = c.a;
            return;
        }
    }

    private ac(c c1)
    {
        k = 17;
        l = c.a;
        m = a.b;
        q = b.a;
        new co();
        r = co.a(n);
        l = c1;
    }

    private ac(c c1, a a1)
    {
        this(c1);
        m = a1;
    }

    private ac(c c1, b b1)
    {
        this(c1);
        q = b1;
    }

    static String a(int i1, int j1)
    {
        return (new StringBuilder()).append(Integer.toString(i1)).append("x").append(Integer.toString(j1)).toString();
    }

    public final boolean a()
    {
        return l == c.b;
    }

    public final boolean b()
    {
        return b.a.equals(q);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ac)
        {
            obj = (ac)obj;
            if (l.equals(((ac) (obj)).l))
            {
                return !l.equals(c.a) || o == ((ac) (obj)).o && p == ((ac) (obj)).p;
            }
        }
        return false;
    }

    public String toString()
    {
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[c.values().length];
                try
                {
                    a[c.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[c.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[c.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[l.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return a(o, p);

        case 2: // '\002'
            return "auto";

        case 3: // '\003'
            return "interstitial";
        }
    }

    static 
    {
        g = new ac(c.b);
        h = new ac(c.b, b.b);
        i = new ac(c.c, a.a);
        j = new ac(c.c);
    }
}
