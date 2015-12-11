// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public class air
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        private static final a f[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(android/support/v7/air$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("IO_ERROR", 0);
            b = new a("DECODING_ERROR", 1);
            c = new a("NETWORK_DENIED", 2);
            d = new a("OUT_OF_MEMORY", 3);
            e = new a("UNKNOWN", 4);
            f = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private final a a;
    private final Throwable b;

    public air(a a1, Throwable throwable)
    {
        a = a1;
        b = throwable;
    }
}
