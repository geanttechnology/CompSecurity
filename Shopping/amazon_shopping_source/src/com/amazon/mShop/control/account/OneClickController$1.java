// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.OneClickConfigResponse;

// Referenced classes of package com.amazon.mShop.control.account:
//            OneClickController

class igResponse
    implements Runnable
{

    final OneClickController this$0;
    final ServiceCall val$sc;
    final OneClickConfigResponse val$value;

    public void run()
    {
label0:
        {
            if (OneClickController.access$000(OneClickController.this, val$sc))
            {
                OneClickController.access$100(OneClickController.this);
                OneClickController.access$200(OneClickController.this, val$value);
                if (!"set_one_click_config_v21".equals(val$sc.getMethod()))
                {
                    break label0;
                }
                OneClickController.access$300(OneClickController.this).onSaveOneClickStatus(val$value.getOneClickStatus());
            }
            return;
        }
        OneClickController.access$300(OneClickController.this).onReceiveOneClickConfig(val$value);
    }

    igResponse()
    {
        this$0 = final_oneclickcontroller;
        val$sc = servicecall;
        val$value = OneClickConfigResponse.this;
        super();
    }
}
