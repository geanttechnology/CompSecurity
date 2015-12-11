// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.util;

import android.os.Looper;

public class Preconditions
{

    private Preconditions()
    {
        throw new UnsupportedOperationException("do not instantiate");
    }

    public static void checkArgument(boolean flag, Object obj)
        throws IllegalArgumentException
    {
        if (!flag)
        {
            throw new IllegalArgumentException(obj.toString());
        } else
        {
            return;
        }
    }

    public static transient void checkArgument(boolean flag, String s, Object aobj[])
        throws IllegalArgumentException
    {
        if (!flag)
        {
            throw new IllegalArgumentException(String.format(s, aobj));
        } else
        {
            return;
        }
    }

    public static void checkState(boolean flag, Object obj)
        throws IllegalStateException
    {
        if (!flag)
        {
            throw new IllegalStateException(obj.toString());
        } else
        {
            return;
        }
    }

    public static transient void checkState(boolean flag, String s, Object aobj[])
        throws IllegalStateException
    {
        if (!flag)
        {
            throw new IllegalStateException(String.format(s, aobj));
        } else
        {
            return;
        }
    }

    public static void isMainThread()
        throws IllegalStateException
    {
        isMainThread("This operation must be performed on the main thread.");
    }

    public static void isMainThread(Object obj)
        throws IllegalStateException
    {
        isMainThread(obj.toString(), (Object[])null);
    }

    public static transient void isMainThread(String s, Object aobj[])
        throws IllegalStateException
    {
        if (Looper.getMainLooper().getThread() != Thread.currentThread())
        {
            throw new IllegalStateException(String.format(s, aobj));
        } else
        {
            return;
        }
    }
}
