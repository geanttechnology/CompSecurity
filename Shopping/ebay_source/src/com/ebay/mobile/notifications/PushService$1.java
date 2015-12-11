// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.app.Service;
import com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager;
import com.ebay.nautilus.shell.app.FwContext;

// Referenced classes of package com.ebay.mobile.notifications:
//            PushService

static final class val.userId
    implements Runnable
{

    final Service val$context;
    final String val$userId;

    public void run()
    {
        ((MyEbayBuyingDataManager)MyEbayBuyingDataManager.get(((FwContext)val$context).getEbayContext(), new com.ebay.nautilus.domain.content.dm.taManager.KeyParams(val$userId))).forceReloadWonList();
    }

    yingDataManager(Service service, String s)
    {
        val$context = service;
        val$userId = s;
        super();
    }
}
