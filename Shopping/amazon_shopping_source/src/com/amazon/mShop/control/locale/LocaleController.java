// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.locale;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.LocaleRequest;
import com.amazon.rio.j2me.client.services.mShop.LocaleResponse;
import com.amazon.rio.j2me.client.services.mShop.LocaleResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;

// Referenced classes of package com.amazon.mShop.control.locale:
//            LocaleSwitchSubscriber

public class LocaleController extends BaseController
    implements LocaleResponseListener
{

    private final LocaleSwitchSubscriber mSubscriber;
    private TaskCallback mTaskCallback;

    public LocaleController(LocaleSwitchSubscriber localeswitchsubscriber)
    {
        mSubscriber = localeswitchsubscriber;
    }

    public void completed(final LocaleResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final LocaleController this$0;
            final ServiceCall val$sc;
            final LocaleResponse val$value;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    mSubscriber.onLocaleSwitchCompleted(value.getCurrentCode());
                    serviceCallCompleted();
                }
            }

            
            {
                this$0 = LocaleController.this;
                sc = servicecall;
                value = localeresponse;
                super();
            }
        });
    }

    protected volatile GenericSubscriber getSubscriber()
    {
        return getSubscriber();
    }

    protected LocaleSwitchSubscriber getSubscriber()
    {
        return mSubscriber;
    }

    public void switchLanguage(String s, TaskCallback taskcallback)
    {
        mTaskCallback = taskcallback;
        taskcallback = new LocaleRequest();
        taskcallback.setCode(s);
        serviceCallStarted(ServiceController.getMShopService().locale(taskcallback, this), mTaskCallback);
    }



}
