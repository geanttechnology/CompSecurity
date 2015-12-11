// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.digidust.elokence.akinator.activities.SplashscreenActivity;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digidust.elokence.akinator.services:
//            AkGCMBroadcastReceiver

public class GCMIntentService extends IntentService
{

    private static final int NOTIFICATION_OPEN_APP = 0;
    private static final int NOTIFICATION_OPEN_LINK = 1;
    public static final String TAG = "GCM Demo";
    android.support.v4.app.NotificationCompat.Builder builder;
    private NotificationManager mNotificationManager;

    public GCMIntentService()
    {
        super("GcmIntentService");
    }

    protected void onHandleIntent(Intent intent)
    {
        Object obj;
        Object obj1;
        obj = intent.getExtras();
        obj1 = GoogleCloudMessaging.getInstance(this).getMessageType(intent);
        break MISSING_BLOCK_LABEL_14;
_L2:
        Context context;
        String s1;
        int i;
        do
        {
            AkGCMBroadcastReceiver.completeWakefulIntent(intent);
            return;
        } while (((Bundle) (obj)).isEmpty() || "send_error".equals(obj1) || "deleted_messages".equals(obj1) || !"gcm".equals(obj1));
        for (obj = intent.getExtras().keySet().iterator(); ((Iterator) (obj)).hasNext(); Log.d("GCM Demo", (new StringBuilder()).append(((String) (obj1))).append(" : ").append(intent.getStringExtra(((String) (obj1)))).toString()))
        {
            obj1 = (String)((Iterator) (obj)).next();
        }

        obj1 = intent.getStringExtra("message");
        Object obj2 = intent.getStringExtra("title");
        s1 = intent.getStringExtra("link");
        String s = intent.getStringExtra("token_download");
        boolean flag = false;
        android.graphics.Bitmap bitmap;
        long l;
        if (intent.hasExtra("extra"))
        {
            try
            {
                new JSONObject(intent.getStringExtra("extra"));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((JSONException) (obj)).printStackTrace();
            }
        }
        if (obj2 == null || obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        context = AkApplication.getAppContext();
        l = System.currentTimeMillis();
        bitmap = BitmapFactory.decodeResource(context.getResources(), 0x7f020356);
        obj = null;
        i = ((flag) ? 1 : 0);
        if (s1 != null)
        {
            i = ((flag) ? 1 : 0);
            if (s1.length() > 0)
            {
                i = 1;
            }
        }
        if (i != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new Intent(context, com/digidust/elokence/akinator/activities/SplashscreenActivity);
        ((Intent) (obj)).setFlags(0x24000000);
        obj = PendingIntent.getActivity(context, 0, ((Intent) (obj)), 0);
_L4:
        obj2 = (new android.support.v4.app.NotificationCompat.Builder(context)).setSmallIcon(0x7f020252).setLargeIcon(bitmap).setContentTitle(((CharSequence) (obj2))).setContentText(((CharSequence) (obj1))).setTicker(((CharSequence) (obj1))).setWhen(l).setSound(RingtoneManager.getDefaultUri(2)).setContentIntent(((PendingIntent) (obj)));
        if (i == 1)
        {
            obj1 = s;
            if (s == null)
            {
                obj1 = "";
            }
            ((android.support.v4.app.NotificationCompat.Builder) (obj2)).addAction(0x7f02038a, ((CharSequence) (obj1)), ((PendingIntent) (obj)));
        }
        obj = (NotificationManager)context.getSystemService("notification");
        obj1 = ((android.support.v4.app.NotificationCompat.Builder) (obj2)).build();
        obj1.flags = ((Notification) (obj1)).flags | 0x10;
        ((NotificationManager) (obj)).notify(i, ((Notification) (obj1)));
        if (true) goto _L2; else goto _L1
_L1:
        if (i != 1) goto _L4; else goto _L3
_L3:
        obj = PendingIntent.getActivity(context, 0, new Intent("android.intent.action.VIEW", Uri.parse(s1)), 0);
          goto _L4
    }
}
