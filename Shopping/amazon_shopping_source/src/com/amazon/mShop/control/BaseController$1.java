// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control;

import com.amazon.mShop.model.auth.UserSubscriber;
import com.amazon.rio.j2me.client.services.ApplicationException;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control:
//            BaseController, GenericSubscriber

class val.e
    implements Runnable
{

    final BaseController this$0;
    final Exception val$e;
    final ServiceCall val$sc;

    public void run()
    {
        GenericSubscriber genericsubscriber;
label0:
        {
            if (isRunningServiceCall(val$sc))
            {
                genericsubscriber = getSubscriber();
                if (!(val$e instanceof ApplicationException) || !ApplicationException.USER_NOT_AUTHENTICATED.equals(((ApplicationException)val$e).getErrorCode()) || !(genericsubscriber instanceof UserSubscriber))
                {
                    break label0;
                }
                ((UserSubscriber)genericsubscriber).onRequiresUserLogin(BaseController.this);
            }
            return;
        }
        handleServiceCallError();
        genericsubscriber.onError(val$e, val$sc);
    }

    eCall()
    {
        this$0 = final_basecontroller;
        val$sc = servicecall;
        val$e = Exception.this;
        super();
    }
}
