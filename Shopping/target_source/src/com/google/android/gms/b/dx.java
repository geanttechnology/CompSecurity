// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;


public final class dx
    implements com.google.android.gms.common.api.b.a.d
{
    public static final class a
    {

        private boolean a;
        private boolean b;
        private String c;
        private com.google.android.gms.common.api.d.e d;

        public dx a()
        {
            return new dx(a, b, c, d);
        }

        public a()
        {
        }
    }


    public static final dx a = (new a()).a();
    private final boolean b;
    private final boolean c;
    private final String d;
    private final com.google.android.gms.common.api.d.e e;

    private dx(boolean flag, boolean flag1, String s, com.google.android.gms.common.api.d.e e1)
    {
        b = flag;
        c = flag1;
        d = s;
        e = e1;
    }


    public boolean a()
    {
        return b;
    }

    public boolean b()
    {
        return c;
    }

    public String c()
    {
        return d;
    }

    public com.google.android.gms.common.api.d.e d()
    {
        return e;
    }

}
