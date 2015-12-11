// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.LogoutRequest;
import com.amazon.rio.j2me.client.services.mShop.LogoutResponse;
import com.amazon.rio.j2me.client.services.mShop.LogoutResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.NotificationTarget;

// Referenced classes of package com.amazon.mShop.control.account:
//            SignOutSubscriber

public class SignOutController extends BaseController
    implements LogoutResponseListener
{

    private final SignOutSubscriber subscriber;

    public SignOutController(SignOutSubscriber signoutsubscriber)
    {
        subscriber = signoutsubscriber;
    }

    public void completed(final LogoutResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final SignOutController this$0;
            final ServiceCall val$sc;
            final LogoutResponse val$value;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    if (value.getFailureMessage() == null)
                    {
                        User.userSignedOut();
                    }
                    subscriber.onSignOutComplete(value.getFailureMessage());
                }
            }

            
            {
                this$0 = SignOutController.this;
                sc = servicecall;
                value = logoutresponse;
                super();
            }
        });
    }

    protected GenericSubscriber getSubscriber()
    {
        return subscriber;
    }

    public void signOut(TaskCallback taskcallback, NotificationTarget notificationtarget)
    {
        LogoutRequest logoutrequest = new LogoutRequest();
        if (notificationtarget != null && !Util.isEmpty(notificationtarget.getDestination()))
        {
            logoutrequest.setNotificationTarget(notificationtarget);
        }
        serviceCallStarted(com.amazon.mShop.platform.Platform.Factory.getInstance().getMShopService().logout(logoutrequest, this), taskcallback);
    }



}
