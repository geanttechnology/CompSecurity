// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service.core:
//            UserManager

class val.onSuccess
    implements Function1
{

    final UserManager this$0;
    final Function1 val$onSuccess;

    public void execute(UserContainer usercontainer)
        throws RuntimeException
    {
        if (usercontainer != null)
        {
            usercontainer = usercontainer.user.billingRecords;
            val$onSuccess.execute(getDefaultBillingRecord(usercontainer));
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((UserContainer)obj);
    }

    ()
    {
        this$0 = final_usermanager;
        val$onSuccess = Function1.this;
        super();
    }
}
