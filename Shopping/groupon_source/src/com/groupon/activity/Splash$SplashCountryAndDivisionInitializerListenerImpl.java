// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.manager.ExceptionManager;
import com.groupon.service.countryanddivision.listener.CountryAndDivisionInitializerListener;
import com.groupon.service.startup.StartupDirector;
import com.groupon.util.Function0;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            Splash, IntentFactory

private class <init>
    implements CountryAndDivisionInitializerListener
{

    final Splash this$0;

    public void onCountryAndDivisionSet()
    {
        Ln.d("onCountryAndDivisionSet", new Object[0]);
    }

    public void onException(Exception exception)
    {
        ((ExceptionManager)RoboGuice.getInjector(Splash.this).getInstance(com/groupon/manager/ExceptionManager)).handleException(exception, new Function0() {

            final Splash.SplashCountryAndDivisionInitializerListenerImpl this$1;

            public void execute()
                throws RuntimeException
            {
                Splash.access$1900(this$0).addCountryAndDivisionInitializerListener(Splash.access$1800(this$0));
                Splash.access$1900(this$0).addCoreServicesInitializerListener(Splash.access$2300(this$0));
                Splash.access$1900(this$0).startupCountryAndDivisionInitializer();
            }

            
            {
                this$1 = Splash.SplashCountryAndDivisionInitializerListenerImpl.this;
                super();
            }
        }, new Function0() {

            final Splash.SplashCountryAndDivisionInitializerListenerImpl this$1;

            public void execute()
            {
                finish();
            }

            
            {
                this$1 = Splash.SplashCountryAndDivisionInitializerListenerImpl.this;
                super();
            }
        });
    }

    public void onManualCountrySelectionNeeded()
    {
        Ln.d("onManualCountrySelectionNeeded", new Object[0]);
        ((Handler)Splash.access$2100(Splash.this).get()).post(new Runnable() {

            final Splash.SplashCountryAndDivisionInitializerListenerImpl this$1;

            public void run()
            {
                setupViews();
                if (getIntent().getData() != null && Splash.access$1200(this$0).isDeepLink(getIntent().getData().toString()))
                {
                    Splash.access$1700(this$0);
                    return;
                } else
                {
                    Splash.access$1900(this$0).addCountryAndDivisionInitializerListener(Splash.access$1800(this$0));
                    Splash.access$2000(this$0);
                    return;
                }
            }

            
            {
                this$1 = Splash.SplashCountryAndDivisionInitializerListenerImpl.this;
                super();
            }
        });
    }

    public void onManualDivisionSelectionNeeded()
    {
        Ln.d("onManualDivisionSelectionNeeded", new Object[0]);
        ((Handler)Splash.access$2100(Splash.this).get()).post(new Runnable() {

            final Splash.SplashCountryAndDivisionInitializerListenerImpl this$1;

            public void run()
            {
                setupViews();
                if (getIntent().getData() != null && Splash.access$1200(this$0).isDeepLink(getIntent().getData().toString()))
                {
                    Splash.access$1700(this$0);
                    return;
                }
                Splash.access$1900(this$0).addCountryAndDivisionInitializerListener(Splash.access$1800(this$0));
                if (Splash.access$2200(this$0))
                {
                    Splash.access$2202(this$0, false);
                    startActivity(Splash.access$400(this$0).newCountryOrDivisionSelector());
                    return;
                } else
                {
                    Splash.access$2000(this$0);
                    return;
                }
            }

            
            {
                this$1 = Splash.SplashCountryAndDivisionInitializerListenerImpl.this;
                super();
            }
        });
    }

    private _cls4.this._cls1()
    {
        this$0 = Splash.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
