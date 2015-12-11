// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.smile;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.SmileInfoRequest;
import com.amazon.rio.j2me.client.services.mShop.SmileInfoResponse;
import com.amazon.rio.j2me.client.services.mShop.SmileInfoResponseListener;

public class SmileController extends BaseController
    implements SmileInfoResponseListener
{

    private static SmileController sInstance = new SmileController();
    private SmileInfoRequest mSmileRequest;
    private GenericSubscriber mSubscribe;

    private SmileController()
    {
        mSubscribe = new GenericSubscriber() {

            final SmileController this$0;

            public void onError(Exception exception, ServiceCall servicecall)
            {
            }

            
            {
                this$0 = SmileController.this;
                super();
            }
        };
        mSmileRequest = new SmileInfoRequest();
    }

    public static SmileController getInstance()
    {
        return sInstance;
    }

    public void completed(final SmileInfoResponse value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final SmileController this$0;
            final SmileInfoResponse val$value;

            public void run()
            {
                serviceCallCompleted();
                User.userUpdated(value);
            }

            
            {
                this$0 = SmileController.this;
                value = smileinforesponse;
                super();
            }
        });
    }

    protected GenericSubscriber getSubscriber()
    {
        return mSubscribe;
    }

    public void syncSmileInfo()
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().getMShopService().smileInfo(mSmileRequest, this);
    }


}
