// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import android.support.v7.apy;

public final class Header
{

    public static final apy RESPONSE_STATUS = apy.a(":status");
    public static final apy TARGET_AUTHORITY = apy.a(":authority");
    public static final apy TARGET_HOST = apy.a(":host");
    public static final apy TARGET_METHOD = apy.a(":method");
    public static final apy TARGET_PATH = apy.a(":path");
    public static final apy TARGET_SCHEME = apy.a(":scheme");
    public static final apy VERSION = apy.a(":version");
    final int hpackSize;
    public final apy name;
    public final apy value;

    public Header(apy apy1, apy apy2)
    {
        name = apy1;
        value = apy2;
        hpackSize = apy1.f() + 32 + apy2.f();
    }

    public Header(apy apy1, String s)
    {
        this(apy1, apy.a(s));
    }

    public Header(String s, String s1)
    {
        this(apy.a(s), apy.a(s1));
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Header)
        {
            obj = (Header)obj;
            flag = flag1;
            if (name.equals(((Header) (obj)).name))
            {
                flag = flag1;
                if (value.equals(((Header) (obj)).value))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return (name.hashCode() + 527) * 31 + value.hashCode();
    }

    public String toString()
    {
        return String.format("%s: %s", new Object[] {
            name.a(), value.a()
        });
    }

}
