// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.service.countryanddivision.CountryAndDivisionInitializer;
import com.groupon.service.startup.StartupDirector;
import com.groupon.util.AbstractRetryAsyncTask;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.activity:
//            Splash

private class defaultDivisionId extends AbstractRetryAsyncTask
{

    private final String defaultDivisionId;
    final Splash this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        ((CountryAndDivisionInitializer)RoboGuice.getInjector(Splash.this).getInstance(com/groupon/service/countryanddivision/CountryAndDivisionInitializer)).setCurrentDivision(defaultDivisionId);
        return null;
    }

    protected void onException(Exception exception)
    {
        super.onException(exception);
        setupViews();
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((Void)obj);
    }

    protected void onSuccess(Void void1)
        throws Exception
    {
        super.onSuccess(void1);
        onNewIntent(getIntent());
        Splash.access$1900(Splash.this).addCountryAndDivisionInitializerListener(Splash.access$1800(Splash.this));
        Splash.access$1900(Splash.this).addCoreServicesInitializerListener(Splash.access$2300(Splash.this));
        Splash.access$1900(Splash.this).startupCountryAndDivisionInitializer();
    }

    public void onUserCancelRetry()
    {
        finish();
    }

    public nitializer(String s)
    {
        this$0 = Splash.this;
        super(Splash.this);
        defaultDivisionId = s;
    }
}
