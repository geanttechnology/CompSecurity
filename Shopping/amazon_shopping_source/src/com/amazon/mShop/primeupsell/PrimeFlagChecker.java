// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.primeupsell;

import com.amazon.mShop.control.account.OneClickController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.sso.SignedMShopService;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CheckLoginRequest;
import com.amazon.rio.j2me.client.services.mShop.CheckLoginResponseListener;
import com.amazon.rio.j2me.client.services.mShop.LoginResponse;
import com.amazon.rio.j2me.client.services.mShop.MShopService;

public class PrimeFlagChecker
    implements CheckLoginResponseListener
{
    public static interface Subscriber
    {

        public abstract void onCancelled();

        public abstract void onComplete();

        public abstract void onError();
    }


    private Subscriber mSubscriber;

    public PrimeFlagChecker(Subscriber subscriber)
    {
        mSubscriber = subscriber;
    }

    private void handleLoginResponse(LoginResponse loginresponse)
    {
        if (loginresponse != null)
        {
            loginresponse = loginresponse.getLoginData();
            if (loginresponse != null)
            {
                User.userUpdated(loginresponse);
            }
        }
    }

    public void cancelled(ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().runOnUiThread(new Runnable() {

            final PrimeFlagChecker this$0;

            public void run()
            {
                if (mSubscriber != null)
                {
                    mSubscriber.onCancelled();
                }
            }

            
            {
                this$0 = PrimeFlagChecker.this;
                super();
            }
        });
    }

    public void checkFlag()
    {
        CheckLoginRequest checkloginrequest = new CheckLoginRequest();
        if (OneClickController.shouldAttempAutoActivationOnSignIn())
        {
            checkloginrequest.setOneClickDeviceName(AndroidPlatform.getInstance().getDeviceName());
        } else
        {
            checkloginrequest.setOneClickDeviceName(null);
        }
        if (SSOUtil.hasAmazonAccount())
        {
            (new SignedMShopService()).checkLogin(checkloginrequest, this);
            return;
        } else
        {
            AndroidPlatform.getInstance().getMShopService().checkLogin(checkloginrequest, this);
            return;
        }
    }

    public void completed(final LoginResponse loginResponse, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().runOnUiThread(new Runnable() {

            final PrimeFlagChecker this$0;
            final LoginResponse val$loginResponse;

            public void run()
            {
label0:
                {
                    handleLoginResponse(loginResponse);
                    if (mSubscriber != null)
                    {
                        if (loginResponse == null)
                        {
                            break label0;
                        }
                        mSubscriber.onComplete();
                    }
                    return;
                }
                mSubscriber.onError();
            }

            
            {
                this$0 = PrimeFlagChecker.this;
                loginResponse = loginresponse;
                super();
            }
        });
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().runOnUiThread(new Runnable() {

            final PrimeFlagChecker this$0;

            public void run()
            {
                if (mSubscriber != null)
                {
                    mSubscriber.onError();
                }
            }

            
            {
                this$0 = PrimeFlagChecker.this;
                super();
            }
        });
    }

    public void setSubscriber(Subscriber subscriber)
    {
        mSubscriber = subscriber;
    }


}
