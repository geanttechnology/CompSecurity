// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.locale;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.LocaleResponse;

// Referenced classes of package com.amazon.mShop.control.locale:
//            LocaleController, LocaleSwitchSubscriber

class ponse
    implements Runnable
{

    final LocaleController this$0;
    final ServiceCall val$sc;
    final LocaleResponse val$value;

    public void run()
    {
        if (LocaleController.access$000(LocaleController.this, val$sc))
        {
            LocaleController.access$100(LocaleController.this).onLocaleSwitchCompleted(val$value.getCurrentCode());
            LocaleController.access$200(LocaleController.this);
        }
    }

    ponse()
    {
        this$0 = final_localecontroller;
        val$sc = servicecall;
        val$value = LocaleResponse.this;
        super();
    }
}
