// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.device.ads:
//            InterstitialAd

class > extends BroadcastReceiver
{

    final InterstitialAd this$0;

    public void onReceive(Context context, Intent intent)
    {
        onBroadcastReceived(intent);
    }

    ()
    {
        this$0 = InterstitialAd.this;
        super();
    }
}
