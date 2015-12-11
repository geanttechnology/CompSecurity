// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;

public class dk
{

    private static boolean mb = false;
    private String mTag;
    private boolean mc;
    private boolean md;

    public dk(String s)
    {
        this(s, bc());
    }

    public dk(String s, boolean flag)
    {
        mTag = s;
        mc = flag;
    }

    public static boolean bc()
    {
        return mb;
    }

    public transient void a(String s, Object aobj[])
    {
        if (md)
        {
            Log.v(mTag, String.format(s, aobj));
        }
    }

    public transient void b(String s, Object aobj[])
    {
        if (mc || mb)
        {
            Log.d(mTag, String.format(s, aobj));
        }
    }

    public transient void c(String s, Object aobj[])
    {
        Log.i(mTag, String.format(s, aobj));
    }

    public transient void d(String s, Object aobj[])
    {
        Log.w(mTag, String.format(s, aobj));
    }

}
