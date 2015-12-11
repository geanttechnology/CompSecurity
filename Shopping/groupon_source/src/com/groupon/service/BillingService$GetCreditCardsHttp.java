// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.http.Http;
import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.util.CheckedFunction1;
import com.groupon.util.Function0;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            BillingService, LoginService

protected class finallyListener extends Http
{

    protected final Function1 exceptionListener;
    protected final Function0 finallyListener;
    private Function0 onUserCancelRetry;
    protected final CheckedFunction1 successListener;
    final BillingService this$0;

    protected void onException(Exception exception)
    {
        if (exceptionListener != null)
        {
            exceptionListener.execute(exception);
            return;
        } else
        {
            super.onException(exception);
            return;
        }
    }

    protected void onFinally()
    {
        if (finallyListener != null)
        {
            finallyListener.execute();
            return;
        } else
        {
            super.onFinally();
            return;
        }
    }

    protected void onSuccess(UserContainer usercontainer)
        throws Exception
    {
        successListener.execute(usercontainer.user.billingRecords);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((UserContainer)obj);
    }

    public void onUserCancelRetry()
    {
        if (onUserCancelRetry != null)
        {
            onUserCancelRetry.execute();
        }
        super.onUserCancelRetry();
    }

    public (CheckedFunction1 checkedfunction1, Function1 function1, Function0 function0, Function0 function0_1)
    {
        this$0 = BillingService.this;
        super(BillingService.access$000(BillingService.this), com/groupon/models/user/UserContainer, String.format("https:/users/%s", new Object[] {
            BillingService.access$100(BillingService.this).getUserId()
        }));
        successListener = checkedfunction1;
        exceptionListener = function1;
        onUserCancelRetry = function0;
        finallyListener = function0_1;
    }
}
