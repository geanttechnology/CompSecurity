// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            AmazonOOAdRegistration, Settings

static final class val.context
    implements Runnable
{

    final Context val$context;

    public void run()
    {
        AmazonOOAdRegistration.prepareRegistrationInfo(val$context);
        Settings.getInstance().putLong("lastIdentifyUserWithSisTime", AmazonOOAdRegistration.sLastIdentifyUserWithSisTime);
    }

    (Context context1)
    {
        val$context = context1;
        super();
    }
}
