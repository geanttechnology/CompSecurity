// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.LoginResponse;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.NewAccountRequest;
import com.amazon.rio.j2me.client.services.mShop.NewAccountResponseListener;

// Referenced classes of package com.amazon.mShop.control.account:
//            NewAccountSubscriber

public class NewAccountController extends BaseController
    implements NewAccountResponseListener
{

    private NewAccountRequest newAccountrequest;
    private final NewAccountSubscriber subscriber;

    public NewAccountController(NewAccountSubscriber newaccountsubscriber)
    {
        subscriber = newaccountsubscriber;
        newAccountrequest = new NewAccountRequest();
    }

    public void completed(final LoginResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final NewAccountController this$0;
            final ServiceCall val$sc;
            final LoginResponse val$value;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    com.amazon.rio.j2me.client.services.mShop.LoginData logindata = value.getLoginData();
                    if (logindata != null)
                    {
                        User.userSignedIn(newAccountrequest.getEmail(), logindata);
                    }
                    NewAccountSubscriber newaccountsubscriber = subscriber;
                    boolean flag;
                    if (logindata != null)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    newaccountsubscriber.onNewAccountCreation(flag, value.getNotification());
                }
            }

            
            {
                this$0 = NewAccountController.this;
                sc = servicecall;
                value = loginresponse;
                super();
            }
        });
    }

    public void createNewAccount(String s, String s1, String s2, String s3, boolean flag, TaskCallback taskcallback)
    {
        newAccountrequest.setFullName(s);
        newAccountrequest.setPronunciation(s1);
        newAccountrequest.setEmail(s2);
        newAccountrequest.setPassword(s3);
        newAccountrequest.setForceMase(Boolean.valueOf(flag));
        serviceCallStarted(com.amazon.mShop.platform.Platform.Factory.getInstance().getMShopService().newAccount(newAccountrequest, this), taskcallback);
    }

    protected GenericSubscriber getSubscriber()
    {
        return subscriber;
    }

    public boolean isValidEmail(String s)
    {
        s = s.split("@");
        if (s.length == 2 && s[0].length() >= 1 && s[1].length() >= 1) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ((s = s[1].split("\\.")).length >= 2)
        {
            int i = 0;
            int j = s.length;
label0:
            do
            {
label1:
                {
                    if (i >= j)
                    {
                        break label1;
                    }
                    if (s[i].length() < 1)
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }




}
