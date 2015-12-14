// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;

import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.model.GetSplashRequest;
import com.amazon.clouddrive.extended.model.GetSplashResponse;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest.account:
//            SubscriptionInfoCache

private static class request extends Thread
{

    private final CloudDriveServiceClientManager cloudDriveServiceClientManager;
    private final CountDownLatch latch;
    private final GetSplashRequest request;
    private GetSplashResponse response;

    public GetSplashResponse getResponse()
    {
        return response;
    }

    public void run()
    {
        response = cloudDriveServiceClientManager.getForegroundCdsClient().getSplash(request);
        latch.countDown();
        return;
        Object obj;
        obj;
_L2:
        GLogger.i(SubscriptionInfoCache.access$000(), "problem fetching splash URL: %s", new Object[] {
            obj
        });
        latch.countDown();
        return;
        obj;
        latch.countDown();
        throw obj;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public (CloudDriveServiceClientManager clouddriveserviceclientmanager, CountDownLatch countdownlatch, GetSplashRequest getsplashrequest)
    {
        cloudDriveServiceClientManager = clouddriveserviceclientmanager;
        latch = countdownlatch;
        request = getsplashrequest;
    }
}
