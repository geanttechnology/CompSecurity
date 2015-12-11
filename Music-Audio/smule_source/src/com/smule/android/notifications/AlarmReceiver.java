// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.android.notifications:
//            a

public class AlarmReceiver extends BroadcastReceiver
{

    private static final String a = com/smule/android/notifications/AlarmReceiver.getName();

    public AlarmReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Object obj = intent.getExtras();
        aa.a(a, (new StringBuilder()).append("Received ").append(intent).append(" extra ").append(obj).toString());
        if (obj != null)
        {
            intent = (String)((Bundle) (obj)).get("DESTINATION_URI");
            String s = (String)((Bundle) (obj)).get("MESSAGE");
            String s1 = (String)((Bundle) (obj)).get("HEADER");
            obj = (String)((Bundle) (obj)).get("PARAMS");
            com.smule.android.notifications.a.a().a(context, intent, s, s1, s, ((String) (obj)));
        }
    }

}
