// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.d:
//            ke, jy

public static final class d
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/google/android/gms/d/ke$a$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("NETWORK", 0);
            b = new a("DISK", 1);
            c = new a("DEFAULT", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public final Status a;
    final a b;
    final byte c[];
    public final long d;
    final jy e;
    public final a f;

    public a(Status status, jy jy, a a1)
    {
        this(status, jy, null, null, a1, 0L);
    }

    public a(Status status, jy jy, byte abyte0[], api.Status status1, a a1, long l)
    {
        a = status;
        e = jy;
        c = abyte0;
        f = status1;
        b = a1;
        d = l;
    }
}
