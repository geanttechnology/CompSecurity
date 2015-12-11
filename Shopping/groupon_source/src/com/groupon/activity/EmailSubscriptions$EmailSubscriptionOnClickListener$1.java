// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.emailsubscription.EmailSubscription;
import com.groupon.util.Function1;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            EmailSubscriptions

class val.position
    implements Function1
{

    final execute this$1;
    final int val$position;

    public void execute(EmailSubscription emailsubscription)
    {
        if (emailsubscription != null)
        {
            EmailSubscriptions.access$100(_fld0).set(val$position, emailsubscription);
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((EmailSubscription)obj);
    }

    ()
    {
        this$1 = final_;
        val$position = I.this;
        super();
    }
}
