// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.startup;

import com.groupon.service.core.CoreService;
import com.groupon.service.core.CoreServicesInitializer;
import com.groupon.service.core.listener.CoreServiceInitializerListener;
import java.util.Collection;

// Referenced classes of package com.groupon.service.startup:
//            StartupDirector, CoreServicesInitializerEventSource

private class <init>
    implements CoreServiceInitializerListener
{

    final StartupDirector this$0;

    public void onAllServicesRefreshCompletedSuccessfully()
    {
        StartupDirector.access$1100(StartupDirector.this);
    }

    public void onAllServicesRefreshCompletedWithError(Collection collection)
    {
        StartupDirector.access$1202(StartupDirector.this, false);
        StartupDirector.access$1400(StartupDirector.this).removeListener(StartupDirector.access$1300(StartupDirector.this));
        StartupDirector.access$1000(StartupDirector.this).fireOnCoreServicesRefreshWithError(collection);
    }

    public void onServiceRefreshStarted(CoreService coreservice)
    {
        StartupDirector.access$1000(StartupDirector.this).fireOnCoreServicesRefreshStarted(coreservice);
    }

    private ()
    {
        this$0 = StartupDirector.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
