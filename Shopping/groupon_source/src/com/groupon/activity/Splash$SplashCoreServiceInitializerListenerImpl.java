// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Handler;
import com.groupon.manager.ExceptionManager;
import com.groupon.service.core.CollectionsService;
import com.groupon.service.core.CoreService;
import com.groupon.service.core.CoreServiceException;
import com.groupon.service.core.listener.CoreServiceInitializerListener;
import com.groupon.service.startup.StartupDirector;
import com.groupon.util.Function0;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            Splash

private class <init>
    implements CoreServiceInitializerListener
{

    final Splash this$0;

    public void onAllServicesRefreshCompletedSuccessfully()
    {
        Splash.access$2500(Splash.this);
    }

    public void onAllServicesRefreshCompletedWithError(Collection collection)
    {
        Ln.d("onAllServicesRefreshCompletedWithError", new Object[0]);
        CoreServiceException coreserviceexception = (CoreServiceException)collection.iterator().next();
        if (collection.size() == 1 && coreserviceexception.getCoreServiceClass() == com/groupon/service/core/CollectionsService)
        {
            Ln.d("The only core service that failed was the collection service. Passing through as it is optional for app startup.", new Object[0]);
            Splash.access$2500(Splash.this);
            return;
        } else
        {
            ((ExceptionManager)RoboGuice.getInjector(Splash.this).getInstance(com/groupon/manager/ExceptionManager)).handleException(coreserviceexception.getCause(), new Function0() {

                final Splash.SplashCoreServiceInitializerListenerImpl this$1;

                public void execute()
                {
                    Splash.access$1900(this$0).addCoreServicesInitializerListener(Splash.access$2300(this$0));
                    Splash.access$1900(this$0).startupCoreServices();
                }

            
            {
                this$1 = Splash.SplashCoreServiceInitializerListenerImpl.this;
                super();
            }
            }, new Function0() {

                final Splash.SplashCoreServiceInitializerListenerImpl this$1;

                public void execute()
                {
                    finish();
                }

            
            {
                this$1 = Splash.SplashCoreServiceInitializerListenerImpl.this;
                super();
            }
            });
            return;
        }
    }

    public void onServiceRefreshStarted(CoreService coreservice)
    {
        if (!Splash.access$2400(Splash.this).get() && coreservice.isDownloadingDataFromNetwork())
        {
            ((Handler)Splash.access$2100(Splash.this).get()).post(new Runnable() {

                final Splash.SplashCoreServiceInitializerListenerImpl this$1;

                public void run()
                {
                    setupViews();
                }

            
            {
                this$1 = Splash.SplashCoreServiceInitializerListenerImpl.this;
                super();
            }
            });
        }
    }

    private _cls3.this._cls1()
    {
        this$0 = Splash.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
