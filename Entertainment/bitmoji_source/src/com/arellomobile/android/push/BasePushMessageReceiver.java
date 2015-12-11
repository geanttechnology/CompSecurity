// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.arellomobile.android.push.utils.PreferenceUtils;

// Referenced classes of package com.arellomobile.android.push:
//            PushManager

public abstract class BasePushMessageReceiver extends BroadcastReceiver
{

    public static final String JSON_DATA_KEY = "pw_data_json_string";

    public BasePushMessageReceiver()
    {
    }

    protected abstract void onMessageReceive(Intent intent);

    public void onReceive(Context context, Intent intent)
    {
        ((NotificationManager)context.getSystemService("notification")).cancel(PreferenceUtils.getMessageId(context));
        PushManager.getInstance(context);
        PushManager.sendPushStat(context, intent.getExtras().getString("p"));
        onMessageReceive(intent);
    }
}
