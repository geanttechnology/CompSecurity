// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash;

import com.amazon.mobile.mash.interception.MASHUrlIntercepter;
import com.amazon.mobile.mash.interception.UrlIntercepterConfigManager;
import com.amazon.mobile.mash.util.MASHDebug;

// Referenced classes of package com.amazon.mobile.mash:
//            MASHApplication

public final class MASHApplicationFactory
{

    private static MASHApplication sMASHApplication;

    private MASHApplicationFactory()
    {
    }

    public static MASHApplication getInstance()
    {
        com/amazon/mobile/mash/MASHApplicationFactory;
        JVM INSTR monitorenter ;
        MASHApplication mashapplication = sMASHApplication;
        com/amazon/mobile/mash/MASHApplicationFactory;
        JVM INSTR monitorexit ;
        return mashapplication;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setInstance(MASHApplication mashapplication)
    {
        com/amazon/mobile/mash/MASHApplicationFactory;
        JVM INSTR monitorenter ;
        sMASHApplication = mashapplication;
        MASHDebug.setEnabled(mashapplication.isDebugEnabled());
        if (mashapplication.shouldInterceptUrls())
        {
            MASHUrlIntercepter.setShouldInterceptUrl(true);
            UrlIntercepterConfigManager.init();
        }
        com/amazon/mobile/mash/MASHApplicationFactory;
        JVM INSTR monitorexit ;
        return;
        mashapplication;
        throw mashapplication;
    }
}
