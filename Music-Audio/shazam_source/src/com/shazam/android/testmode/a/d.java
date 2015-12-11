// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.testmode.a;


// Referenced classes of package com.shazam.android.testmode.a:
//            b, c, a, e

public final class d
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/shazam/android/testmode/a/d$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("APP_NEXUS", 0);
            b = new a("FACEBOOK", 1);
            c = new a("AD_COLONY", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public d()
    {
    }

    public static e a(a a1, String s)
    {
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[a.values().length];
                try
                {
                    a[a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[a.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[a1.ordinal()])
        {
        default:
            throw new RuntimeException((new StringBuilder("Unsupported test id source: ")).append(a1).toString());

        case 1: // '\001'
            return new b(com.shazam.i.b.r.d.a(), s);

        case 2: // '\002'
            return new c();

        case 3: // '\003'
            return new com.shazam.android.testmode.a.a();
        }
    }
}
