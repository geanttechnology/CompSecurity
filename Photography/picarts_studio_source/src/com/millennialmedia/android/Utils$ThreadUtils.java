// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class 
{

    private static final ExecutorService a = Executors.newCachedThreadPool();

    static void a(Runnable runnable)
    {
        a.execute(runnable);
    }


    ()
    {
    }
}
