// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.platform;


// Referenced classes of package com.amazon.now.platform:
//            AndroidPlatform

public static class 
{

    private static AndroidPlatform instance;

    public static AndroidPlatform getInstance()
    {
        com/amazon/now/platform/AndroidPlatform$Factory;
        JVM INSTR monitorenter ;
        AndroidPlatform androidplatform = instance;
        com/amazon/now/platform/AndroidPlatform$Factory;
        JVM INSTR monitorexit ;
        return androidplatform;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setInstance(AndroidPlatform androidplatform)
    {
        com/amazon/now/platform/AndroidPlatform$Factory;
        JVM INSTR monitorenter ;
        instance = androidplatform;
        com/amazon/now/platform/AndroidPlatform$Factory;
        JVM INSTR monitorexit ;
        return;
        androidplatform;
        throw androidplatform;
    }

    public ()
    {
    }
}
