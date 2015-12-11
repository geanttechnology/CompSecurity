// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class x extends Enum
{

    public static final x a;
    private static final x c[];
    private final ExecutorService b = Executors.newCachedThreadPool();

    private x(String s)
    {
        super(s, 0);
    }

    public static x valueOf(String s)
    {
        return (x)Enum.valueOf(com/rhythmnewmedia/sdk/x, s);
    }

    public static x[] values()
    {
        return (x[])c.clone();
    }

    public final Future a(Runnable runnable)
    {
        return b.submit(runnable);
    }

    static 
    {
        a = new x("instance");
        c = (new x[] {
            a
        });
    }
}
