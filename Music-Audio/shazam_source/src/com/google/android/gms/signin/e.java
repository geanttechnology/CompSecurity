// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin;


public final class e
{
    public static final class a
    {

        private boolean a;
        private boolean b;
        private String c;
        private com.google.android.gms.common.api.c.d d;

        public final e a()
        {
            return new e(a, b, c, d, (byte)0);
        }

        public a()
        {
        }
    }


    public static final e a = (new a()).a();
    public final boolean b;
    public final boolean c;
    public final String d;
    public final com.google.android.gms.common.api.c.d e;

    private e(boolean flag, boolean flag1, String s, com.google.android.gms.common.api.c.d d1)
    {
        b = flag;
        c = flag1;
        d = s;
        e = d1;
    }

    e(boolean flag, boolean flag1, String s, com.google.android.gms.common.api.c.d d1, byte byte0)
    {
        this(flag, flag1, s, d1);
    }

}
