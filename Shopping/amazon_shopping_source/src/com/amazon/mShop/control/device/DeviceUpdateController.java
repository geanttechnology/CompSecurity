// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.device;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.KiangApplicationState;
import com.amazon.rio.j2me.client.services.mShop.KiangSecurity;
import com.amazon.rio.j2me.client.services.mShop.KiangUpdateRequest;
import com.amazon.rio.j2me.client.services.mShop.KiangUpdateResponse;
import com.amazon.rio.j2me.client.services.mShop.KiangUpdateResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.mShop.control.device:
//            KiangSubscriber

public class DeviceUpdateController extends BaseController
    implements KiangUpdateResponseListener
{

    private static final Object lock = new Object();
    private KiangSubscriber mKiangSubscriber;
    private KiangUpdateRequest mRequest;
    private AtomicInteger mRetryCount;

    public DeviceUpdateController(KiangSecurity kiangsecurity, KiangApplicationState kiangapplicationstate, KiangSubscriber kiangsubscriber)
    {
        mRetryCount = new AtomicInteger(0);
        mRequest = new KiangUpdateRequest();
        mRequest.setSecurity(kiangsecurity);
        mRequest.setApplicationState(kiangapplicationstate);
        mKiangSubscriber = kiangsubscriber;
    }

    public void completed(final KiangUpdateResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final DeviceUpdateController this$0;
            final ServiceCall val$sc;
            final KiangUpdateResponse val$value;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    if (value.getResetRegistration() != null && value.getResetRegistration().booleanValue())
                    {
                        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
                        datastore.remove("applicationInstallId");
                        datastore.remove("applicationSecretKey");
                        datastore.remove("kiangUpdateSequenceNumber");
                        mKiangSubscriber.onResetRegister();
                    }
                }
            }

            
            {
                this$0 = DeviceUpdateController.this;
                sc = servicecall;
                value = kiangupdateresponse;
                super();
            }
        });
    }

    public void error(Exception exception, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final DeviceUpdateController this$0;
            final ServiceCall val$sc;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    kiangUpdate();
                }
            }

            
            {
                this$0 = DeviceUpdateController.this;
                sc = servicecall;
                super();
            }
        }, getDelayTime());
    }

    public int getDelayTime()
    {
        return mRetryCount.get() * 60000;
    }

    protected volatile GenericSubscriber getSubscriber()
    {
        return getSubscriber();
    }

    protected KiangSubscriber getSubscriber()
    {
        return mKiangSubscriber;
    }

    public void kiangUpdate()
    {
        if (mRetryCount.getAndAdd(1) < 3)
        {
            Platform platform = com.amazon.mShop.platform.Platform.Factory.getInstance();
            DataStore datastore = platform.getDataStore();
            synchronized (lock)
            {
                int i = datastore.getInt("kiangUpdateSequenceNumber");
                mRequest.getApplicationState().setSequenceNumber(i + 1);
                datastore.putInt("kiangUpdateSequenceNumber", i + 1);
            }
            serviceCallStarted(platform.getMShopService().kiangUpdate(mRequest, this), null);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }






}
