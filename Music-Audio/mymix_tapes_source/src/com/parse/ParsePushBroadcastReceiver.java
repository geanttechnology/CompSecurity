// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            Parse, ManifestInfo, ParseAnalytics, TaskStackBuilderHelper, 
//            ParseNotificationManager

public class ParsePushBroadcastReceiver extends BroadcastReceiver
{

    public static final String ACTION_PUSH_DELETE = "com.parse.push.intent.DELETE";
    public static final String ACTION_PUSH_OPEN = "com.parse.push.intent.OPEN";
    public static final String ACTION_PUSH_RECEIVE = "com.parse.push.intent.RECEIVE";
    public static final String KEY_PUSH_CHANNEL = "com.parse.Channel";
    public static final String KEY_PUSH_DATA = "com.parse.Data";
    public static final String PROPERTY_PUSH_ICON = "com.parse.push.notification_icon";
    protected static final int SMALL_NOTIFICATION_MAX_CHARACTER_LIMIT = 38;
    private static final String TAG = "com.parse.ParsePushReceiver";

    public ParsePushBroadcastReceiver()
    {
    }

    private JSONObject getPushData(Intent intent)
    {
        try
        {
            intent = new JSONObject(intent.getStringExtra("com.parse.Data"));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Parse.logE("com.parse.ParsePushReceiver", "Unexpected JSONException when receiving push data: ", intent);
            return null;
        }
        return intent;
    }

    protected Class getActivity(Context context, Intent intent)
    {
        context = Parse.applicationContext.getPackageName();
        context = Parse.applicationContext.getPackageManager().getLaunchIntentForPackage(context);
        if (context == null)
        {
            return null;
        }
        context = context.getComponent().getClassName();
        try
        {
            context = Class.forName(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    protected Bitmap getLargeIcon(Context context, Intent intent)
    {
        return null;
    }

    protected Notification getNotification(Context context, Intent intent)
    {
        Object obj = getPushData(intent);
        if (obj == null || !((JSONObject) (obj)).has("alert") && !((JSONObject) (obj)).has("title"))
        {
            return null;
        }
        String s = ((JSONObject) (obj)).optString("alert", "Notification received.");
        obj = ((JSONObject) (obj)).optString("title", ManifestInfo.getDisplayName());
        Object obj1 = intent.getExtras();
        Object obj2 = new Random();
        int i = ((Random) (obj2)).nextInt();
        int j = ((Random) (obj2)).nextInt();
        Object obj3 = context.getPackageName();
        Intent intent1 = new Intent("com.parse.push.intent.OPEN");
        intent1.putExtras(((Bundle) (obj1)));
        intent1.setPackage(((String) (obj3)));
        obj2 = new Intent("com.parse.push.intent.DELETE");
        ((Intent) (obj2)).putExtras(((Bundle) (obj1)));
        ((Intent) (obj2)).setPackage(((String) (obj3)));
        obj1 = PendingIntent.getBroadcast(context, i, intent1, 0x8000000);
        obj2 = PendingIntent.getBroadcast(context, j, ((Intent) (obj2)), 0x8000000);
        obj3 = new NotificationCompat.Builder(context);
        ((NotificationCompat.Builder) (obj3)).setContentTitle(((CharSequence) (obj))).setContentText(s).setSmallIcon(getSmallIconId(context, intent)).setLargeIcon(getLargeIcon(context, intent)).setContentIntent(((PendingIntent) (obj1))).setDeleteIntent(((PendingIntent) (obj2))).setAutoCancel(true).setDefaults(-1);
        if (s != null && s.length() > 38)
        {
            ((NotificationCompat.Builder) (obj3)).setStyle((new NotificationCompat.Builder.BigTextStyle()).bigText(s));
        }
        return ((NotificationCompat.Builder) (obj3)).build();
    }

    protected int getSmallIconId(Context context, Intent intent)
    {
        context = ManifestInfo.getApplicationMetadata();
        int i = 0;
        if (context != null)
        {
            i = context.getInt("com.parse.push.notification_icon");
        }
        if (i != 0)
        {
            return i;
        } else
        {
            return ManifestInfo.getIconId();
        }
    }

    protected void onPushDismiss(Context context, Intent intent)
    {
    }

    protected void onPushOpen(Context context, Intent intent)
    {
        Object obj;
        ParseAnalytics.trackAppOpened(intent);
        obj = null;
        String s = (new JSONObject(intent.getStringExtra("com.parse.Data"))).optString("uri");
        obj = s;
_L1:
        Object obj1 = getActivity(context, intent);
        if (obj != null)
        {
            obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
        } else
        {
            obj = new Intent(context, ((Class) (obj1)));
        }
        ((Intent) (obj)).putExtras(intent.getExtras());
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            TaskStackBuilderHelper.startActivities(context, ((Class) (obj1)), ((Intent) (obj)));
            return;
        } else
        {
            ((Intent) (obj)).addFlags(0x10000000);
            ((Intent) (obj)).addFlags(0x4000000);
            context.startActivity(((Intent) (obj)));
            return;
        }
        obj1;
        Parse.logE("com.parse.ParsePushReceiver", "Unexpected JSONException when receiving push data: ", ((Throwable) (obj1)));
          goto _L1
    }

    protected void onPushReceive(Context context, Intent intent)
    {
        JSONObject jsonobject1 = null;
        JSONObject jsonobject = new JSONObject(intent.getStringExtra("com.parse.Data"));
        jsonobject1 = jsonobject;
_L2:
        String s = null;
        if (jsonobject1 != null)
        {
            s = jsonobject1.optString("action", null);
        }
        if (s != null)
        {
            Bundle bundle = intent.getExtras();
            Intent intent1 = new Intent();
            intent1.putExtras(bundle);
            intent1.setAction(s);
            intent1.setPackage(context.getPackageName());
            context.sendBroadcast(intent1);
        }
        intent = getNotification(context, intent);
        if (intent != null)
        {
            ParseNotificationManager.getInstance().showNotification(context, intent);
        }
        return;
        JSONException jsonexception;
        jsonexception;
        Parse.logE("com.parse.ParsePushReceiver", "Unexpected JSONException when receiving push data: ", jsonexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getAction();
        if ("com.parse.push.intent.RECEIVE".equals(s))
        {
            onPushReceive(context, intent);
        } else
        {
            if ("com.parse.push.intent.DELETE".equals(s))
            {
                onPushDismiss(context, intent);
                return;
            }
            if ("com.parse.push.intent.OPEN".equals(s))
            {
                onPushOpen(context, intent);
                return;
            }
        }
    }
}
