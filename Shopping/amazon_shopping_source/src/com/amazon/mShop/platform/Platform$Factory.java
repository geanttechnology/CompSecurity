// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.platform;


// Referenced classes of package com.amazon.mShop.platform:
//            Platform

public static class 
{

    private static Platform instance;

    public static Platform getInstance()
    {
        com/amazon/mShop/platform/Platform$Factory;
        JVM INSTR monitorenter ;
        Platform platform = instance;
        com/amazon/mShop/platform/Platform$Factory;
        JVM INSTR monitorexit ;
        return platform;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setInstance(Platform platform)
    {
        com/amazon/mShop/platform/Platform$Factory;
        JVM INSTR monitorenter ;
        instance = platform;
        com/amazon/mShop/platform/Platform$Factory;
        JVM INSTR monitorexit ;
        return;
        platform;
        throw platform;
    }

    public ()
    {
    }
}
