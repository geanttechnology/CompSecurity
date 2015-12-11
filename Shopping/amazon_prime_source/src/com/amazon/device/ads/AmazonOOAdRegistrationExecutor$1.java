// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            AmazonOOAdRegistrationExecutor, SystemTime, Settings

class val.context
    implements Runnable
{

    final AmazonOOAdRegistrationExecutor this$0;
    final Context val$context;

    public void run()
    {
        prepareRegistrationInfo(val$context);
        getSettings().putLong("amzn-ad-iu-last-checkin", AmazonOOAdRegistrationExecutor.access$000(AmazonOOAdRegistrationExecutor.this).currentTimeMillis());
    }

    ()
    {
        this$0 = final_amazonooadregistrationexecutor;
        val$context = Context.this;
        super();
    }
}
