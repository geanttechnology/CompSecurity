// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import java.util.concurrent.ThreadFactory;

public class BackgroundThreadFactory
    implements ThreadFactory
{

    public BackgroundThreadFactory()
    {
    }

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable);
        runnable.setPriority(4);
        return runnable;
    }
}
