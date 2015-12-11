// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.mShop.model.auth.User;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.LogoutResponse;

// Referenced classes of package com.amazon.mShop.control.account:
//            SignOutController, SignOutSubscriber

class nse
    implements Runnable
{

    final SignOutController this$0;
    final ServiceCall val$sc;
    final LogoutResponse val$value;

    public void run()
    {
        if (SignOutController.access$000(SignOutController.this, val$sc))
        {
            SignOutController.access$100(SignOutController.this);
            if (val$value.getFailureMessage() == null)
            {
                User.userSignedOut();
            }
            SignOutController.access$200(SignOutController.this).onSignOutComplete(val$value.getFailureMessage());
        }
    }

    nse()
    {
        this$0 = final_signoutcontroller;
        val$sc = servicecall;
        val$value = LogoutResponse.this;
        super();
    }
}
