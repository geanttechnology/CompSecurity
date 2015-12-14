// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.libraryview;

import android.content.Context;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b extends ThreadPoolExecutor
{

    private static final int a;
    private static final int b;
    private static final int c;
    private static final BlockingQueue d = new LinkedBlockingQueue();

    public b(Context context)
    {
        super(b, c, 30L, TimeUnit.SECONDS, d);
    }

    static 
    {
        a = Runtime.getRuntime().availableProcessors();
        b = Math.max(a - 1, 1);
        c = b;
    }
}
