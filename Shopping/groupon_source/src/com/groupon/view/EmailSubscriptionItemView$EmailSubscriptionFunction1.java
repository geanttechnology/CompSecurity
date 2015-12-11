// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import com.groupon.models.emailsubscription.EmailSubscription;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.view:
//            EmailSubscriptionItemView

private class callback
    implements Function1
{

    private final Function1 callback;
    final EmailSubscriptionItemView this$0;

    public void execute(EmailSubscription emailsubscription)
    {
        setInProgress(false);
        if (callback != null)
        {
            callback.execute(emailsubscription);
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((EmailSubscription)obj);
    }

    public (Function1 function1)
    {
        this$0 = EmailSubscriptionItemView.this;
        super();
        callback = function1;
    }
}
