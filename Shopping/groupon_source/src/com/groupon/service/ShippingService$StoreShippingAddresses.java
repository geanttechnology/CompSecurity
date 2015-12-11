// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.util.Function1;
import java.util.List;

// Referenced classes of package com.groupon.service:
//            ShippingService

protected class this._cls0
    implements Function1
{

    final ShippingService this$0;

    public void execute(UserContainer usercontainer)
    {
        usercontainer = usercontainer.user.shippingAddresses;
        boolean flag;
        if (usercontainer != null && usercontainer.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && !isStored())
        {
            storeMultipleShipping((DealBreakdownAddress)usercontainer.get(0));
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((UserContainer)obj);
    }

    protected ()
    {
        this$0 = ShippingService.this;
        super();
    }
}
