// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.ebay.mobile.service:
//            GoogleNowAuthenticationService

public class LocaleChangedReceiver extends BroadcastReceiver
{

    public LocaleChangedReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        GoogleNowAuthenticationService.stop(context, null);
        GoogleNowAuthenticationService.start(context);
    }
}
