// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;

// Referenced classes of package android.support.v7:
//            xa

public class xg
    implements g
{
    public static class a
    {

        private final Status a;
        private final a b;
        private final byte c[];
        private final long d;
        private final xa e;
        private final xh.c f;

        public Status a()
        {
            return a;
        }

        public a b()
        {
            return b;
        }

        public byte[] c()
        {
            return c;
        }

        public xa d()
        {
            return e;
        }

        public xh.c e()
        {
            return f;
        }

        public long f()
        {
            return d;
        }

        public a(Status status, xa xa, a a1)
        {
            this(status, xa, null, null, a1, 0L);
        }

        public a(Status status, xa xa, byte abyte0[], xh.c c1, a a1, long l)
        {
            a = status;
            e = xa;
            c = abyte0;
            f = c1;
            b = a1;
            d = l;
        }
    }

    public static final class a.a extends Enum
    {

        public static final a.a a;
        public static final a.a b;
        public static final a.a c;
        private static final a.a d[];

        public static a.a valueOf(String s)
        {
            return (a.a)Enum.valueOf(android/support/v7/xg$a$a, s);
        }

        public static a.a[] values()
        {
            return (a.a[])d.clone();
        }

        static 
        {
            a = new a.a("NETWORK", 0);
            b = new a.a("DISK", 1);
            c = new a.a("DEFAULT", 2);
            d = (new a.a[] {
                a, b, c
            });
        }

        private a.a(String s, int i)
        {
            super(s, i);
        }
    }


    private final a a;

    public xg(a a1)
    {
        a = a1;
    }

    public Status a()
    {
        return a.a();
    }

    public a b()
    {
        return a;
    }
}
