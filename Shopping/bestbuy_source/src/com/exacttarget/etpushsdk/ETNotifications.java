// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.exacttarget.etpushsdk.util.c;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.m;
import java.lang.reflect.Field;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETException, ETPush, ETLandingPagePresenter, ETNotificationBuilder, 
//            ETNotificationLaunchIntent

public class ETNotifications
{

    private static final String NOTIFICATION_REQUEST_CODE = "et_notification_request_code_key";
    private static final String TAG = "~!ETPushNotifications";
    private static final String _OD = "_od";
    private static ETNotificationBuilder notificationBuilder = null;
    private static ETNotificationLaunchIntent notificationLaunchIntent = null;
    private static final Object notificationSynchronization = new Object();

    public ETNotifications()
    {
    }

    public static PendingIntent createPendingIntentWithOpenAnalytics(Context context, Intent intent, boolean flag)
    {
        Intent intent1 = new Intent((new StringBuilder()).append(context.getApplicationContext().getPackageName()).append(".MESSAGE_OPENED").toString());
        intent1.putExtra("et_push_open_intent", intent);
        return setupLaunchPendingIntent(context, intent1, flag);
    }

    public static ETNotificationBuilder getNotificationBuilder()
    {
        return notificationBuilder;
    }

    public static ETNotificationLaunchIntent getNotificationLaunchIntent()
    {
        return notificationLaunchIntent;
    }

    public static void setNotificationBuilder(ETNotificationBuilder etnotificationbuilder)
    {
        notificationBuilder = etnotificationbuilder;
    }

    public static void setNotificationLaunchIntent(ETNotificationLaunchIntent etnotificationlaunchintent)
    {
        notificationLaunchIntent = etnotificationlaunchintent;
    }

    public static Intent setupLaunchIntent(Context context, Bundle bundle)
    {
        Object obj;
        if (ETPush.getInstance().getNotificationAction() == null || ETPush.getInstance().getNotificationActionUri() == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        m.a("~!ETPushNotifications", (new StringBuilder()).append("Launch Intent set to NotificationUri: ").append(ETPush.getInstance().getNotificationActionUri()).toString());
        obj = new Intent(ETPush.getInstance().getNotificationAction(), ETPush.getInstance().getNotificationActionUri());
        context = ((Context) (obj));
        ((Intent) (obj)).putExtras(bundle);
        return ((Intent) (obj));
        if (ETPush.getInstance().getCloudPageRecipient() == null || bundle.getString("_x") == null) goto _L2; else goto _L1
_L1:
        m.a("~!ETPushNotifications", (new StringBuilder()).append("Launch Intent set to Cloud Page: ").append(ETPush.getInstance().getCloudPageRecipient()).toString());
        obj = new Intent(context, ETPush.getInstance().getCloudPageRecipient());
        context = ((Context) (obj));
        ((Intent) (obj)).putExtra("loadURL", bundle.getString("_x"));
        context = ((Context) (obj));
        ((Intent) (obj)).putExtras(bundle);
        return ((Intent) (obj));
        bundle;
_L4:
        m.c("~!ETPushNotifications", bundle.getMessage(), bundle);
        return context;
_L2:
        if (ETPush.getInstance().getCloudPageRecipient() != null || bundle.getString("_x") == null)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        obj = bundle.getString("_x");
        if (!URLUtil.isValidUrl(((String) (obj))) || !URLUtil.isHttpUrl(((String) (obj))) && !URLUtil.isHttpsUrl(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_272;
        }
        m.a("~!ETPushNotifications", (new StringBuilder()).append("Launch Intent set to Cloud Page: ").append(((String) (obj))).toString());
        obj = new Intent(context, com/exacttarget/etpushsdk/ETLandingPagePresenter);
        context = ((Context) (obj));
        ((Intent) (obj)).putExtras(bundle);
        return ((Intent) (obj));
        m.a("~!ETPushNotifications", "Launch Intent set to Launch Package");
        obj = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        context = ((Context) (obj));
        ((Intent) (obj)).putExtras(bundle);
        return ((Intent) (obj));
        if (ETPush.getInstance().getOpenDirectRecipient() == null || bundle.getString("_od") == null)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        m.a("~!ETPushNotifications", (new StringBuilder()).append("Launch Intent set to Open Direct: ").append(ETPush.getInstance().getOpenDirectRecipient()).toString());
        obj = new Intent(context, ETPush.getInstance().getOpenDirectRecipient());
        context = ((Context) (obj));
        ((Intent) (obj)).putExtra("open_direct_payload", bundle.getString("_od"));
        context = ((Context) (obj));
        ((Intent) (obj)).putExtras(bundle);
        return ((Intent) (obj));
        if (ETPush.getInstance().getOpenDirectRecipient() != null || bundle.getString("_od") == null)
        {
            break MISSING_BLOCK_LABEL_512;
        }
        obj = bundle.getString("_od");
        if (!URLUtil.isValidUrl(((String) (obj))) || !URLUtil.isHttpUrl(((String) (obj))) && !URLUtil.isHttpsUrl(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_482;
        }
        m.a("~!ETPushNotifications", (new StringBuilder()).append("Launch Intent set to Open Direct: ").append(((String) (obj))).toString());
        obj = new Intent(context, com/exacttarget/etpushsdk/ETLandingPagePresenter);
        context = ((Context) (obj));
        ((Intent) (obj)).putExtras(bundle);
        return ((Intent) (obj));
        m.a("~!ETPushNotifications", "Launch Intent set to Launch Package");
        obj = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        context = ((Context) (obj));
        ((Intent) (obj)).putExtras(bundle);
        return ((Intent) (obj));
        ETPush.getInstance();
        if (ETPush.getNotificationRecipientClass() == null)
        {
            break MISSING_BLOCK_LABEL_581;
        }
        obj = (new StringBuilder()).append("Launch Intent set to Notification Recipient: ");
        ETPush.getInstance();
        m.a("~!ETPushNotifications", ((StringBuilder) (obj)).append(ETPush.getNotificationRecipientClass()).toString());
        ETPush.getInstance();
        obj = new Intent(context, ETPush.getNotificationRecipientClass());
        context = ((Context) (obj));
        ((Intent) (obj)).putExtras(bundle);
        return ((Intent) (obj));
        m.a("~!ETPushNotifications", "Launch Intent set to Launch Package");
        obj = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        context = ((Context) (obj));
        ((Intent) (obj)).putExtras(bundle);
        return ((Intent) (obj));
        bundle;
        context = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected static PendingIntent setupLaunchPendingIntent(Context context, Intent intent, boolean flag)
    {
        Object obj = notificationSynchronization;
        obj;
        JVM INSTR monitorenter ;
        int i;
        i = ((Integer)d.a(context, "et_notification_request_code_key", Integer.valueOf(0), new Object[] {
            PreferenceManager.getDefaultSharedPreferences(context)
        })).intValue();
        intent.putExtra("et_auto_cancel", flag);
        m.a("~!ETPushNotifications", (new StringBuilder()).append("AUTOCANCEL: ").append(flag).toString());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        intent.putExtra("et_notification_id_key", i);
        m.a("~!ETPushNotifications", (new StringBuilder()).append("NOTIFICATION_ID: ").append(i).toString());
        intent = PendingIntent.getBroadcast(context, i, intent, 0x10000000);
        d.a(context, "et_notification_request_code_key", Integer.valueOf(i + 1));
        obj;
        JVM INSTR monitorexit ;
        return intent;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static android.support.v4.app.NotificationCompat.Builder setupNotificationBuilder(Context context, Bundle bundle)
    {
        android.support.v4.app.NotificationCompat.Builder builder;
        int j;
        builder = new android.support.v4.app.NotificationCompat.Builder(context);
        j = context.getApplicationInfo().icon;
        ETPush.getInstance();
        if (ETPush.getNotificationResourceId() == null) goto _L2; else goto _L1
_L1:
        int i;
        ETPush.getInstance();
        i = ETPush.getNotificationResourceId().intValue();
_L7:
        builder.setSmallIcon(i);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), j));
        builder.setAutoCancel(true);
        Object obj = context.getString(context.getApplicationInfo().labelRes);
        builder.setContentTitle(((CharSequence) (obj)));
        String s = bundle.getString("alert");
        if (s != null)
        {
            builder.setTicker(s);
            builder.setContentText(s);
            String s1 = bundle.getString("et_big_pic");
            if (!TextUtils.isEmpty(s1))
            {
                builder.setStyle((new android.support.v4.app.NotificationCompat.BigPictureStyle()).bigPicture(c.a(s1)).setSummaryText(s));
            } else
            {
                builder.setStyle((new android.support.v4.app.NotificationCompat.BigTextStyle()).bigText(s).setBigContentTitle(((CharSequence) (obj))));
            }
        }
        if (bundle.getString("sound") == null) goto _L4; else goto _L3
_L3:
        if (!bundle.getString("sound").equals("custom.caf")) goto _L6; else goto _L5
_L5:
        bundle = Class.forName((new StringBuilder()).append(context.getPackageName()).append(".R$raw").toString()).getDeclaredField("custom");
        builder.setSound(Uri.parse((new StringBuilder()).append("android.resource://").append(context.getPackageName()).append("/").append(bundle.getInt(null)).toString()));
_L4:
        return builder;
        obj;
        m.c("~!ETPushNotifications", (new StringBuilder()).append("Error getting notification icon: ").append(((Exception) (obj)).getMessage()).toString(), ((Throwable) (obj)));
_L2:
        i = j;
          goto _L7
        context;
_L9:
        m.b("~!ETPushNotifications", "R.raw.custom sound requested but not defined, reverting to default notification sound.", context);
        builder.setSound(android.provider.Settings.System.DEFAULT_NOTIFICATION_URI);
        return builder;
_L6:
        builder.setSound(android.provider.Settings.System.DEFAULT_NOTIFICATION_URI);
        return builder;
        context;
        continue; /* Loop/switch isn't completed */
        context;
        continue; /* Loop/switch isn't completed */
        context;
        if (true) goto _L9; else goto _L8
_L8:
    }

}
