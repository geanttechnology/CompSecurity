// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.device.ads:
//            AmazonOOAdRegistration, AmazonOOAdRegistrationExecutor

public class AmazonOOReferrerBroadcastReceiver extends BroadcastReceiver
{

    private static final String REFERRER_ACTION_NAME = "com.android.vending.INSTALL_REFERRER";
    private static final String REFERRER_STRING_EXTRA_LABEL = "referrer";
    private final AmazonOOAdRegistrationExecutor adRegistration;

    public AmazonOOReferrerBroadcastReceiver()
    {
        this(AmazonOOAdRegistration.getAmazonOOAdRegistrationExecutor());
    }

    AmazonOOReferrerBroadcastReceiver(AmazonOOAdRegistrationExecutor amazonooadregistrationexecutor)
    {
        adRegistration = amazonooadregistrationexecutor;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("com.android.vending.INSTALL_REFERRER"))
        {
            intent = intent.getStringExtra("referrer");
            adRegistration.setReferrer(context, intent);
        }
    }
}
