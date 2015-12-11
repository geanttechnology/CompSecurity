// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.mShop.model.auth.User;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.LoginResponse;
import com.amazon.rio.j2me.client.services.mShop.NewAccountRequest;

// Referenced classes of package com.amazon.mShop.control.account:
//            NewAccountController, NewAccountSubscriber

class val.value
    implements Runnable
{

    final NewAccountController this$0;
    final ServiceCall val$sc;
    final LoginResponse val$value;

    public void run()
    {
        if (NewAccountController.access$000(NewAccountController.this, val$sc))
        {
            NewAccountController.access$100(NewAccountController.this);
            com.amazon.rio.j2me.client.services.mShop.LoginData logindata = val$value.getLoginData();
            if (logindata != null)
            {
                User.userSignedIn(NewAccountController.access$200(NewAccountController.this).getEmail(), logindata);
            }
            NewAccountSubscriber newaccountsubscriber = NewAccountController.access$300(NewAccountController.this);
            boolean flag;
            if (logindata != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            newaccountsubscriber.onNewAccountCreation(flag, val$value.getNotification());
        }
    }

    est()
    {
        this$0 = final_newaccountcontroller;
        val$sc = servicecall;
        val$value = LoginResponse.this;
        super();
    }
}
