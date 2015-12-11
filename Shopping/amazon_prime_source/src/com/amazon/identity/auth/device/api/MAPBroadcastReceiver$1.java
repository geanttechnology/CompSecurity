// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPBroadcastReceiver

class val.intent
    implements Runnable
{

    final MAPBroadcastReceiver this$0;
    final Context val$context;
    final Intent val$intent;

    public void run()
    {
        Intent intent1 = MAPBroadcastReceiver.constructBackwardsCompatibleIntent(val$context, val$intent);
        if (intent1 == null)
        {
            MAPBroadcastReceiver.access$000();
            val$intent.getAction();
            return;
        } else
        {
            backwardsCompatibleOnReceive(val$context, intent1);
            return;
        }
    }

    ()
    {
        this$0 = final_mapbroadcastreceiver;
        val$context = context1;
        val$intent = Intent.this;
        super();
    }
}
