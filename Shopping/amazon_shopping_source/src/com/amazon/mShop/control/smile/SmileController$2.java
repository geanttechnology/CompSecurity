// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.smile;

import com.amazon.mShop.model.auth.User;
import com.amazon.rio.j2me.client.services.mShop.SmileInfoResponse;

// Referenced classes of package com.amazon.mShop.control.smile:
//            SmileController

class foResponse
    implements Runnable
{

    final SmileController this$0;
    final SmileInfoResponse val$value;

    public void run()
    {
        SmileController.access$000(SmileController.this);
        User.userUpdated(val$value);
    }

    foResponse()
    {
        this$0 = final_smilecontroller;
        val$value = SmileInfoResponse.this;
        super();
    }
}
