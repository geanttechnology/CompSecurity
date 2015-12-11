// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import com.groupon.models.order.OrderContainer;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service.core:
//            UserManager

class val.successCallback
    implements Function1
{

    final UserManager this$0;
    final Function1 val$successCallback;

    public void execute(OrderContainer ordercontainer)
        throws RuntimeException
    {
        if (val$successCallback != null)
        {
            val$successCallback.execute(ordercontainer.order);
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((OrderContainer)obj);
    }

    ()
    {
        this$0 = final_usermanager;
        val$successCallback = Function1.this;
        super();
    }
}
