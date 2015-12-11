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
import com.amazon.rio.j2me.client.services.mShop.LoginRequest;
import com.amazon.rio.j2me.client.services.mShop.LoginResponse;
import com.amazon.rio.j2me.client.services.mShop.LoginResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.NotificationTarget;

// Referenced classes of package com.amazon.mShop.control.account:
//            OneClickController, SignInSubscriber

public class SignInController extends BaseController
    implements LoginResponseListener
{

    private final LoginRequest loginRequest = new LoginRequest();
    private final boolean mNeedCallUserSignedIn;
    private final SignInSubscriber subscriber;

    public SignInController(SignInSubscriber signinsubscriber, boolean flag)
    {
        subscriber = signinsubscriber;
        mNeedCallUserSignedIn = flag;
    }

    public void completed(final LoginResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final SignInController this$0;
            final ServiceCall val$sc;
            final LoginResponse val$value;

            public void run()
            {
                boolean flag = true;
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    com.amazon.rio.j2me.client.services.mShop.Notification notification = value.getNotification();
                    com.amazon.rio.j2me.client.services.mShop.LoginData logindata = value.getLoginData();
                    if (logindata != null)
                    {
                        SignInSubscriber signinsubscriber;
                        if (notification != null && OneClickController.isOneClickNotification(notification))
                        {
                            OneClickController.setDidAttemptAutoActivationOnFirstSignIn(true);
                        } else
                        if (loginRequest.getOneClickDeviceName() != null)
                        {
                            OneClickController.setDidAttemptAutoActivationOnFirstSignIn(false);
                        }
                        if (mNeedCallUserSignedIn)
                        {
                            User.userSignedIn(loginRequest.getEmail(), logindata);
                        } else
                        {
                            User.saveUser(loginRequest.getEmail(), logindata);
                        }
                    }
                    signinsubscriber = subscriber;
                    if (logindata == null)
                    {
                        flag = false;
                    }
                    signinsubscriber.onSignInCompleted(flag, notification);
                }
            }

            
            {
                this$0 = SignInController.this;
                sc = servicecall;
                value = loginresponse;
                super();
            }
        });
    }

    protected GenericSubscriber getSubscriber()
    {
        return subscriber;
    }

    public void signIn(String s, String s1, NotificationTarget notificationtarget, boolean flag, TaskCallback taskcallback)
    {
        loginRequest.setEmail(s);
        loginRequest.setPassword(s1);
        if (notificationtarget != null && !Util.isEmpty(notificationtarget.getDestination()))
        {
            loginRequest.setNotificationTarget(notificationtarget);
        }
        s = com.amazon.mShop.platform.Platform.Factory.getInstance();
        if (flag && OneClickController.shouldAttempAutoActivationOnSignIn())
        {
            loginRequest.setOneClickDeviceName(s.getDeviceName());
        } else
        {
            loginRequest.setOneClickDeviceName(null);
        }
        serviceCallStarted(s.getMShopService().login(loginRequest, this), taskcallback);
    }





}
