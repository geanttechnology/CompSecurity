// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import com.inc247.bridge.ChatSDKNativeToJSBridge;

// Referenced classes of package com.inc247:
//            ChatSDKUtil

public class NotificationToUser
{

    static String body = "Your Chat is In Background";
    static String subject = "Chat Notification";
    static String title = "Current Chat Status";

    public NotificationToUser()
    {
    }

    public static void ShowNotificationToUser(Context context)
    {
        NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
        Notification notification = new Notification(R.drawable.icon, title, System.currentTimeMillis());
        PendingIntent pendingintent = PendingIntent.getActivity(context, 0, new Intent(), 0);
        notification.setLatestEventInfo(context, subject, body, pendingintent);
        try
        {
            RingtoneManager.getRingtone(context, RingtoneManager.getDefaultUri(2)).play();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(context).append("'}").toString()));
        }
        notificationmanager.notify(0, notification);
    }

}
