// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.device;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.KiangApplicationInformation;
import com.amazon.rio.j2me.client.services.mShop.KiangApplicationInstanceInformation;
import com.amazon.rio.j2me.client.services.mShop.KiangPushInformation;
import com.amazon.rio.j2me.client.services.mShop.KiangRegisterRequest;
import com.amazon.rio.j2me.client.services.mShop.KiangRegisterResponse;
import com.amazon.rio.j2me.client.services.mShop.KiangRegisterResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.mShop.control.device:
//            KiangSubscriber

public class DeviceRegisterController extends BaseController
    implements KiangRegisterResponseListener
{

    private KiangSubscriber mKiangSubscriber;
    private KiangRegisterRequest mRequest;
    private AtomicInteger mRetryCount;

    public DeviceRegisterController(KiangApplicationInformation kiangapplicationinformation, KiangApplicationInstanceInformation kiangapplicationinstanceinformation, KiangPushInformation kiangpushinformation, KiangSubscriber kiangsubscriber)
    {
        mRetryCount = new AtomicInteger(0);
        mRequest = new KiangRegisterRequest();
        mRequest.setApplicationInformation(kiangapplicationinformation);
        mRequest.setApplicationInstanceInformation(kiangapplicationinstanceinformation);
        mRequest.setPushInformation(kiangpushinformation);
        mKiangSubscriber = kiangsubscriber;
    }

    public void completed(final KiangRegisterResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final DeviceRegisterController this$0;
            final ServiceCall val$sc;
            final KiangRegisterResponse val$value;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    String s = value.getApplicationInstallId();
                    String s1 = value.getSecret();
                    if (Util.isEmpty(s))
                    {
                        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                            final _cls1 this$1;

                            public void run()
                            {
                                kiangRegister();
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        }, getDelayTime());
                        return;
                    } else
                    {
                        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
                        datastore.putString("applicationInstallId", s);
                        datastore.putString("applicationSecretKey", s1);
                        mKiangSubscriber.onRegisterCompleted();
                        return;
                    }
                } else
                {
                    mKiangSubscriber.onRegisterError();
                    return;
                }
            }

            
            {
                this$0 = DeviceRegisterController.this;
                sc = servicecall;
                value = kiangregisterresponse;
                super();
            }
        });
    }

    public void error(Exception exception, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final DeviceRegisterController this$0;
            final ServiceCall val$sc;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    kiangRegister();
                    return;
                } else
                {
                    mKiangSubscriber.onRegisterError();
                    return;
                }
            }

            
            {
                this$0 = DeviceRegisterController.this;
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

    public void kiangRegister()
    {
        if (mRetryCount.getAndAdd(1) < 3)
        {
            serviceCallStarted(com.amazon.mShop.platform.Platform.Factory.getInstance().getMShopService().kiangRegister(mRequest, this), null);
            return;
        } else
        {
            mKiangSubscriber.onRegisterError();
            return;
        }
    }





}
