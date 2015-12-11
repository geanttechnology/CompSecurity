// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.GetPointsSummaryResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.Null;
import com.amazon.rio.j2me.client.services.mShop.PointsSummaryResponse;

// Referenced classes of package com.amazon.mShop.control.account:
//            AmazonPointsSummarySubscriber

public class AmazonPointsSummaryController extends BaseController
    implements GetPointsSummaryResponseListener
{

    private AmazonPointsSummarySubscriber subscriber;

    public AmazonPointsSummaryController(AmazonPointsSummarySubscriber amazonpointssummarysubscriber)
    {
        subscriber = amazonpointssummarysubscriber;
    }

    public void completed(final PointsSummaryResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final AmazonPointsSummaryController this$0;
            final ServiceCall val$sc;
            final PointsSummaryResponse val$value;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    if (value != null)
                    {
                        subscriber.onReceiveAmazonPointsSummary(value.getSummaryRows());
                    }
                }
            }

            
            {
                this$0 = AmazonPointsSummaryController.this;
                sc = servicecall;
                value = pointssummaryresponse;
                super();
            }
        });
    }

    public void doGetPointsSummary(TaskCallback taskcallback)
    {
        this;
        JVM INSTR monitorenter ;
        serviceCallStarted(ServiceController.getMShopService().getPointsSummary(new Null(), this), taskcallback);
        this;
        JVM INSTR monitorexit ;
        return;
        taskcallback;
        throw taskcallback;
    }

    protected GenericSubscriber getSubscriber()
    {
        return subscriber;
    }



}
