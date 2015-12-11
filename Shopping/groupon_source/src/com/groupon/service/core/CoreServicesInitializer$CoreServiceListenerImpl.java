// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import com.groupon.service.core.listener.CoreServiceListener;
import java.util.Set;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service.core:
//            CoreServicesInitializer, CoreServiceException, CoreService

private class <init>
    implements CoreServiceListener
{

    final CoreServicesInitializer this$0;

    public void onRefreshError(CoreService coreservice, Exception exception)
    {
        Ln.d(exception, "StartupService %s refreshed with error", new Object[] {
            coreservice.getClass().getName()
        });
        CoreServicesInitializer.access$500(CoreServicesInitializer.this).add(new CoreServiceException(coreservice, exception));
        CoreServicesInitializer.access$400(CoreServicesInitializer.this);
    }

    public void onRefreshStarted(CoreService coreservice)
    {
        CoreServicesInitializer.access$200(CoreServicesInitializer.this, coreservice);
    }

    public void onRefreshSuccess(CoreService coreservice)
    {
        Ln.d("StartupService %s refreshed successfully", new Object[] {
            coreservice.getClass().getName()
        });
        CoreServicesInitializer.access$300(CoreServicesInitializer.this).add(coreservice);
        CoreServicesInitializer.access$400(CoreServicesInitializer.this);
    }

    private ()
    {
        this$0 = CoreServicesInitializer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
