// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.device.ads:
//            AdLayout, IAdController

class  extends BroadcastReceiver
{

    final AdLayout this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF") && AdLayout.access$000(AdLayout.this))
        {
            AdLayout.access$100(AdLayout.this).sendCommand("close", null);
        }
    }

    er()
    {
        this$0 = AdLayout.this;
        super();
    }
}
