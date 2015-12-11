// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.mixerbox.mixerbox3b.services:
//            LocalNotificationService

public class LocalNotificationReceiver extends BroadcastReceiver
{

    public LocalNotificationReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Intent intent1 = new Intent(context, com/mixerbox/mixerbox3b/services/LocalNotificationService);
        intent1.putExtras(intent);
        context.startService(intent1);
    }
}
