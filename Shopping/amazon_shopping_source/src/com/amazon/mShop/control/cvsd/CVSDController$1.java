// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.cvsd;

import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.cvsd:
//            CVSDController, CVSDSubscriber, CVSDReceivedResult

class 
    implements Runnable
{

    final CVSDController this$0;
    final ServiceCall val$sc;

    public void run()
    {
        if (!CVSDController.access$000(CVSDController.this, val$sc)) goto _L2; else goto _L1
_L1:
        CVSDController.access$100(CVSDController.this);
        if (CVSDController.access$200(CVSDController.this) != 0) goto _L4; else goto _L3
_L3:
        if (CVSDController.access$300(CVSDController.this).size() != 0 || Util.isEmpty(CVSDController.access$400(CVSDController.this))) goto _L6; else goto _L5
_L5:
        if (CVSDController.access$500(CVSDController.this) != null)
        {
            CVSDController.access$500(CVSDController.this).onOnlyMessageReceived(CVSDController.access$400(CVSDController.this));
        }
_L2:
        return;
_L6:
        if (CVSDController.access$500(CVSDController.this) != null)
        {
            CVSDController.access$500(CVSDController.this).onDeliveryLocationsReceived(CVSDController.access$300(CVSDController.this));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (CVSDController.access$200(CVSDController.this) == 1)
        {
            CVSDReceivedResult.reset();
            CVSDReceivedResult.receivedType = 1;
            CVSDReceivedResult.message = CVSDController.access$400(CVSDController.this);
            CVSDReceivedResult.receivedAddresss = CVSDController.access$300(CVSDController.this);
            if (CVSDController.access$500(CVSDController.this) != null)
            {
                CVSDController.access$500(CVSDController.this).onRefinementsReceived();
                return;
            }
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    ()
    {
        this$0 = final_cvsdcontroller;
        val$sc = ServiceCall.this;
        super();
    }
}
