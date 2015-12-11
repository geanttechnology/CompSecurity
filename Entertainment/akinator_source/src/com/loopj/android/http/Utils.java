// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


class Utils
{

    private Utils()
    {
    }

    public static void asserts(boolean flag, String s)
    {
        if (!flag)
        {
            throw new AssertionError(s);
        } else
        {
            return;
        }
    }

    public static Object notNull(Object obj, String s)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" should not be null!").toString());
        } else
        {
            return obj;
        }
    }
}
