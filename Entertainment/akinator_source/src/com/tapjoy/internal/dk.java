// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            dj

public interface dk
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        private static final a g[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/tapjoy/internal/dk$a, s);
        }

        public static a[] values()
        {
            return (a[])g.clone();
        }

        static 
        {
            a = new a("NEW", 0);
            b = new a("STARTING", 1);
            c = new a("RUNNING", 2);
            d = new a("STOPPING", 3);
            e = new a("TERMINATED", 4);
            f = new a("FAILED", 5);
            g = (new a[] {
                a, b, c, d, e, f
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract dj f();

    public abstract a g();
}
