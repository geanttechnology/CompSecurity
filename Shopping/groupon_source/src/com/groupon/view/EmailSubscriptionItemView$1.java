// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import com.groupon.models.emailsubscription.EmailSubscription;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.view:
//            EmailSubscriptionItemView

class val.internalCallback
    implements Function1
{

    final EmailSubscriptionItemView this$0;
    final Function1 val$internalCallback;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Void)obj);
    }

    public void execute(Void void1)
    {
        EmailSubscriptionItemView.access$000(EmailSubscriptionItemView.this).id = null;
        val$internalCallback.execute(null);
    }

    scription()
    {
        this$0 = final_emailsubscriptionitemview;
        val$internalCallback = Function1.this;
        super();
    }
}
