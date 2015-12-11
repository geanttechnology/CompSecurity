// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.mShop.model.auth.User;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.LoginRequest;
import com.amazon.rio.j2me.client.services.mShop.LoginResponse;

// Referenced classes of package com.amazon.mShop.control.account:
//            SignInController, OneClickController, SignInSubscriber

class nse
    implements Runnable
{

    final SignInController this$0;
    final ServiceCall val$sc;
    final LoginResponse val$value;

    public void run()
    {
        boolean flag = true;
        if (SignInController.access$000(SignInController.this, val$sc))
        {
            SignInController.access$100(SignInController.this);
            com.amazon.rio.j2me.client.services.mShop.Notification notification = val$value.getNotification();
            com.amazon.rio.j2me.client.services.mShop.LoginData logindata = val$value.getLoginData();
            if (logindata != null)
            {
                SignInSubscriber signinsubscriber;
                if (notification != null && OneClickController.isOneClickNotification(notification))
                {
                    OneClickController.setDidAttemptAutoActivationOnFirstSignIn(true);
                } else
                if (SignInController.access$200(SignInController.this).getOneClickDeviceName() != null)
                {
                    OneClickController.setDidAttemptAutoActivationOnFirstSignIn(false);
                }
                if (SignInController.access$300(SignInController.this))
                {
                    User.userSignedIn(SignInController.access$200(SignInController.this).getEmail(), logindata);
                } else
                {
                    User.saveUser(SignInController.access$200(SignInController.this).getEmail(), logindata);
                }
            }
            signinsubscriber = SignInController.access$400(SignInController.this);
            if (logindata == null)
            {
                flag = false;
            }
            signinsubscriber.onSignInCompleted(flag, notification);
        }
    }

    nse()
    {
        this$0 = final_signincontroller;
        val$sc = servicecall;
        val$value = LoginResponse.this;
        super();
    }
}
