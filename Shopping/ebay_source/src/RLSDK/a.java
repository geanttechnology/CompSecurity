// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


public final class RLSDK.a
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
            return (a)Enum.valueOf(RLSDK/a$a, s);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("PUBLIC_SDK_MODE", 0);
            b = new a("LICENSED_SDK_MODE", 1);
            c = new a("DISABLED_SDK_MODE", 2);
            d = new a("UNINITIALIZED_SDK_MODE", 3);
            e = new a("ERROR", 4);
            f = (new a[] {
                a, b, c, d, e
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public static void a()
    {
        RLSDK/a;
        JVM INSTR monitorenter ;
    }
}
