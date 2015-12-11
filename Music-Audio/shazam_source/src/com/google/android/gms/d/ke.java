// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;

// Referenced classes of package com.google.android.gms.d:
//            jy

public final class ke
    implements g
{
    public static final class a
    {

        public final Status a;
        final a b;
        final byte c[];
        public final long d;
        final jy e;
        public final kf.c f;

        public a(Status status, jy jy, a a1)
        {
            this(status, jy, null, null, a1, 0L);
        }

        public a(Status status, jy jy, byte abyte0[], kf.c c1, a a1, long l)
        {
            a = status;
            e = jy;
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
            return (a.a)Enum.valueOf(com/google/android/gms/d/ke$a$a, s);
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


    public final a a;

    public ke(a a1)
    {
        a = a1;
    }

    public final Status a()
    {
        return a.a;
    }
}
