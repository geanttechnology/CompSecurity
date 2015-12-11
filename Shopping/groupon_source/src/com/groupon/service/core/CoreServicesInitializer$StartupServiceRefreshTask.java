// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import android.app.Application;
import android.os.SystemClock;
import com.groupon.service.core.listener.CoreServiceListener;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.concurrent.Callable;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service.core:
//            CoreServicesInitializer, CoreService

private static class <init>
    implements Callable
{

    private Application application;
    private CoreServiceListener coreServiceListener;
    private Logger logger;
    private boolean shouldLogStartupTime;
    private Class startupServiceClass;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        Ln.d("Starting %s", new Object[] {
            startupServiceClass.getName()
        });
        long l = SystemClock.currentThreadTimeMillis();
        Ln.d("Starting Startup Service %s", new Object[] {
            startupServiceClass.getName()
        });
        CoreService coreservice = (CoreService)RoboGuice.getInjector(application).getInstance(startupServiceClass);
        long l1 = SystemClock.currentThreadTimeMillis();
        Ln.d("Startup Service %s created in %d", new Object[] {
            startupServiceClass.getName(), Integer.valueOf((int)(l1 - l))
        });
        coreservice.addListener(coreServiceListener);
        coreservice.doRefresh();
        coreservice.removeListener(coreServiceListener);
        l1 = SystemClock.currentThreadTimeMillis();
        if (shouldLogStartupTime)
        {
            logger.logGeneralEvent("startup", "splash", (new StringBuilder()).append("startupServices:").append(startupServiceClass.getSimpleName()).toString(), (int)(l1 - l), Logger.NULL_NST_FIELD);
        }
        Ln.d("Startup Service %s started in %d", new Object[] {
            startupServiceClass.getName(), Integer.valueOf((int)(l1 - l))
        });
        return null;
    }

    private (Application application1, CoreServiceListener coreservicelistener, Class class1, boolean flag, Logger logger1)
    {
        application = application1;
        coreServiceListener = coreservicelistener;
        startupServiceClass = class1;
        shouldLogStartupTime = flag;
        logger = logger1;
    }

    logger(Application application1, CoreServiceListener coreservicelistener, Class class1, boolean flag, Logger logger1, logger logger2)
    {
        this(application1, coreservicelistener, class1, flag, logger1);
    }
}
