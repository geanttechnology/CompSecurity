// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.PostEventsResponse;
import com.amazon.rio.j2me.client.services.mShop.PostEventsResponseListener;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupSequenceMediator

class this._cls0
    implements PostEventsResponseListener
{

    final StartupSequenceMediator this$0;

    public void cancelled(ServiceCall servicecall)
    {
    }

    public void completed(PostEventsResponse posteventsresponse, ServiceCall servicecall)
    {
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
    }

    Response()
    {
        this$0 = StartupSequenceMediator.this;
        super();
    }
}
