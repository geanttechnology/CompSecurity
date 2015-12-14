// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotobeauty;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import com.fotoable.ad.StaticFlurryEvent;
import com.google.android.gms.gcm.GcmListenerService;
import com.instabeauty.application.InstaBeautyApplication;

// Referenced classes of package com.fotoable.fotobeauty:
//            WantuActivity

public class FotoGcmListenerService extends GcmListenerService
{

    public FotoGcmListenerService()
    {
    }

    protected static Notification a(Context context, PendingIntent pendingintent, String s, String s1, int i, Bitmap bitmap)
    {
        return (new android.app.Notification.Builder(context)).setContentTitle(s).setContentText(s1).setContentIntent(pendingintent).setSmallIcon(i).setLargeIcon(bitmap).build();
    }

    private static void a(Context context, String s)
    {
        NotificationManager notificationmanager;
        Object obj;
        String s1;
        long l;
        Bitmap bitmap = ((BitmapDrawable)context.getResources().getDrawable(0x7f02034c)).getBitmap();
        l = System.currentTimeMillis();
        notificationmanager = (NotificationManager)context.getSystemService("notification");
        obj = new Intent(context, com/fotoable/fotobeauty/WantuActivity);
        ((Intent) (obj)).putExtra("onlineGCM", true);
        ((Intent) (obj)).setFlags(0x24000000);
        obj = PendingIntent.getActivity(context, 0, ((Intent) (obj)), 0);
        s1 = context.getString(0x7f060077);
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        context = a(context, ((PendingIntent) (obj)), s1, s, 0x7f02034c, bitmap);
_L1:
        context.flags = ((Notification) (context)).flags | 0x10;
        context.defaults = ((Notification) (context)).defaults | 1;
        notificationmanager.notify(0, context);
        return;
        Notification notification;
        try
        {
            notification = new Notification(0x7f02034c, s, l);
            notification.setLatestEventInfo(context, s1, s, ((PendingIntent) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        context = notification;
          goto _L1
    }

    public void onMessageReceived(String s, Bundle bundle)
    {
        super.onMessageReceived(s, bundle);
        bundle = bundle.getString("message");
        StaticFlurryEvent.logGCMEventWithKV("pushkey", "push_message_received");
        StaticFlurryEvent.logGCMEventUnique(InstaBeautyApplication.a, "pushkey_Unique", "push_message_received_Unique");
        Log.d("GCMListenerService", (new StringBuilder()).append("From: ").append(s).toString());
        Log.d("GCMListenerService", (new StringBuilder()).append("Message: ").append(bundle).toString());
        if (!s.startsWith("/topics/"));
        a(InstaBeautyApplication.a, bundle);
    }
}
