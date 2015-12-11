// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.o;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{

    public static final int a;
    private static final ExecutorService b = Executors.newFixedThreadPool(5, com.shazam.i.q.a.a("module layers rendering-%d"));
    private static final ExecutorService c = Executors.newSingleThreadExecutor(com.shazam.i.q.a.a("daemon thread-%d"));
    private static final ExecutorService d = Executors.newSingleThreadExecutor(com.shazam.i.q.a.a("comscore thread-%d"));
    private static final ExecutorService e = Executors.newSingleThreadExecutor(com.shazam.i.q.a.b("HockeyAppLogger-%d").b());
    private static final ExecutorService f;

    public static ExecutorService a()
    {
        return c;
    }

    public static ExecutorService a(int i)
    {
        return Executors.newFixedThreadPool(i, com.shazam.i.q.a.b("AudioReader-%d").b());
    }

    public static ExecutorService b()
    {
        return d;
    }

    public static ExecutorService c()
    {
        return b;
    }

    public static ExecutorService d()
    {
        return e;
    }

    public static ExecutorService e()
    {
        return f;
    }

    public static ExecutorService f()
    {
        return Executors.newFixedThreadPool(1, com.shazam.i.q.a.b("RecordingBridge-%d").b());
    }

    static 
    {
        int i = Runtime.getRuntime().availableProcessors();
        a = i;
        f = Executors.newFixedThreadPool(i, com.shazam.i.q.a.a("BlurExecutor-%d"));
    }
}
