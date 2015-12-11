// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.util.Log;
import com.amazon.mShop.control.account.OneClickController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CheckLoginRequest;
import com.amazon.rio.j2me.client.services.mShop.CheckLoginResponseListener;
import com.amazon.rio.j2me.client.services.mShop.LoginData;
import com.amazon.rio.j2me.client.services.mShop.LoginResponse;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.NotificationTarget;
import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickStatus;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil, SignedMShopService

public final class MShopCheckLogin
    implements CheckLoginResponseListener
{
    public static interface Subscriber
    {

        public abstract void onCancelled();

        public abstract void onComplete();

        public abstract void onError();
    }


    private static Notification sPendingNotification = null;
    private final String TAG;
    private final Context mApplicationContext;
    private final boolean mAttemptOneClickActivation;
    private final boolean mCallPhoneHomeOnCompleted;
    private final Subscriber mSubscriber;

    public MShopCheckLogin(Context context, boolean flag, Subscriber subscriber)
    {
        this(context, flag, subscriber, true);
    }

    public MShopCheckLogin(Context context, boolean flag, Subscriber subscriber, boolean flag1)
    {
        TAG = com/amazon/mShop/sso/MShopCheckLogin.getSimpleName();
        mAttemptOneClickActivation = flag;
        mApplicationContext = context;
        mSubscriber = subscriber;
        mCallPhoneHomeOnCompleted = flag1;
    }

    private void handleLoginResponse(LoginResponse loginresponse)
    {
        if (loginresponse == null)
        {
            simulateSignIn();
        } else
        {
            updateUserData(loginresponse);
            if (loginresponse.getNotification() != null)
            {
                savePendingNotification(loginresponse.getNotification());
                return;
            }
        }
    }

    public static void savePendingNotification(Notification notification)
    {
        sPendingNotification = notification;
    }

    private void simulateSignIn()
    {
        String s = null;
        boolean flag3 = false;
        String s2 = SSOUtil.peekCustomerAttribute(mApplicationContext, "com.amazon.dcp.sso.property.username");
        User user = User.getUser();
        com.amazon.rio.j2me.client.services.mShop.Date date;
        String s1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (user != null)
        {
            flag = user.isPrime();
        } else
        {
            flag = false;
        }
        if (user != null)
        {
            flag1 = user.isOneClick();
        } else
        {
            flag1 = false;
        }
        if (user != null)
        {
            date = user.getDob();
        } else
        {
            date = null;
        }
        if (user != null)
        {
            flag2 = user.isPrimeEligible();
        } else
        {
            flag2 = false;
        }
        if (user != null)
        {
            s = user.getPrimeFunnelUrl();
        }
        if (user != null)
        {
            s1 = user.getCharity();
        } else
        {
            s1 = "";
        }
        if (user != null)
        {
            flag3 = user.isSmile();
        }
        User.userSignedIn(new User("", s2, flag, flag1, date, Boolean.valueOf(flag2), s, s1, flag3));
    }

    private void updateUserData(LoginResponse loginresponse)
    {
        LoginData logindata = loginresponse.getLoginData();
        if (logindata == null)
        {
            if (SSOUtil.DEBUG)
            {
                Log.v(TAG, "SIGNED OUT: CheckLogin completed successfully with an empty LoginData field");
            }
            User.userSignedOut();
            return;
        }
        loginresponse = loginresponse.getNotification();
        if (loginresponse != null && OneClickController.isOneClickNotification(loginresponse))
        {
            OneClickController.setDidAttemptAutoActivationOnFirstSignIn(true);
        }
        if (SSOUtil.DEBUG)
        {
            loginresponse = logindata.getPrimeOneClickStatus();
            boolean flag1 = false;
            boolean flag = false;
            if (loginresponse != null)
            {
                flag1 = loginresponse.getIsPrime();
                flag = loginresponse.getIsOneClickEnabled();
            }
            Log.v(TAG, (new StringBuilder()).append("LoginResponse ").append(logindata.getFullName()).append(" prime: ").append(flag1).append(" 1-click: ").append(flag).append(" primeEligible:").append(logindata.getIsPrimeFunnelEligible()).toString());
        }
        if (mCallPhoneHomeOnCompleted)
        {
            User.userSignedIn("", logindata);
            return;
        } else
        {
            User.saveUser("", logindata);
            return;
        }
    }

    public void cancelled(ServiceCall servicecall)
    {
        if (SSOUtil.DEBUG)
        {
            Log.w(TAG, (new StringBuilder()).append(servicecall.getMethod()).append(" cancelled").toString());
        }
        AndroidPlatform.getInstance().invokeLater(new Runnable() {

            final MShopCheckLogin this$0;

            public void run()
            {
                handleLoginResponse(null);
                if (mSubscriber != null)
                {
                    mSubscriber.onCancelled();
                }
            }

            
            {
                this$0 = MShopCheckLogin.this;
                super();
            }
        });
    }

    public void checkLogin()
    {
        CheckLoginRequest checkloginrequest = new CheckLoginRequest();
        AndroidPlatform androidplatform = AndroidPlatform.getInstance();
        if (mAttemptOneClickActivation && OneClickController.shouldAttempAutoActivationOnSignIn())
        {
            checkloginrequest.setOneClickDeviceName(androidplatform.getDeviceName());
        } else
        {
            checkloginrequest.setOneClickDeviceName(null);
        }
        if (MShopPushNotificationUtils.isPushNotificationAvailable())
        {
            NotificationTarget notificationtarget = PushNotificationManager.getInstance().getNewNotificationTarget(null);
            if (notificationtarget != null && !Util.isEmpty(notificationtarget.getDestination()))
            {
                checkloginrequest.setNotificationTarget(notificationtarget);
            }
        }
        if (SSOUtil.DEBUG)
        {
            Log.v(TAG, (new StringBuilder()).append("checkLogin OneClickDeviceName: ").append(checkloginrequest.getOneClickDeviceName()).toString());
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
        if (SSOUtil.DEBUG)
        {
            Log.v(TAG, (new StringBuilder()).append(servicecall.getMethod()).append(" completed ").append(loginResponse).toString());
        }
        AndroidPlatform.getInstance().invokeLater(new Runnable() {

            final MShopCheckLogin this$0;
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
                this$0 = MShopCheckLogin.this;
                loginResponse = loginresponse;
                super();
            }
        });
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        if (SSOUtil.DEBUG)
        {
            Log.w(TAG, (new StringBuilder()).append("CheckLogin failed with error: ").append(servicecall.getMethod()).append(" ").append(exception).toString());
        }
        AndroidPlatform.getInstance().invokeLater(new Runnable() {

            final MShopCheckLogin this$0;

            public void run()
            {
                handleLoginResponse(null);
                if (mSubscriber != null)
                {
                    mSubscriber.onError();
                }
            }

            
            {
                this$0 = MShopCheckLogin.this;
                super();
            }
        });
    }



}
