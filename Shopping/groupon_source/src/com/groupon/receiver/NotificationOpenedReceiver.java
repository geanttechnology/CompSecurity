// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.receiver;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.groupon.activity.Splash;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.models.notification.NotificationMetadata;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GrouponPointsUtil;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class NotificationOpenedReceiver extends WakefulBroadcastReceiver
{

    private static final String PARAM_ATTR_LINK_ID = "grpn_l";
    private static final String UTM_MEDIUM = "utm_medium";
    private DeepLinkUtil deepLinkUtil;
    private GrouponPointsUtil grouponPointsUtil;
    private Logger logger;

    public NotificationOpenedReceiver()
    {
    }

    private Uri appendAttribution(Uri uri, String s, String s1)
    {
        return uri.buildUpon().appendQueryParameter("grpn_l", s).appendQueryParameter("utm_medium", s1).build();
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        RoboGuice.getInjector(context).injectMembers(this);
        Ln.d("GCM_Notification: Received intent: %s", new Object[] {
            intent.toString()
        });
        obj = intent.getAction();
        if (!((String) (obj)).equals("com.groupon.PUSH_NOTIFICATION_OPENED"))
        {
            continue; /* Loop/switch isn't completed */
        }
        Ln.d("GCM_Notification: User clicked notification. Message: %s", new Object[] {
            intent.getStringExtra("alert")
        });
        Bundle bundle1 = intent.getExtras();
        if (bundle1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Uri uri;
        String s1;
        try
        {
            trackNotificationOpened(bundle1);
            NotificationManagerCompat.from(context).cancel(com.groupon.Constants.Notification.DEAL_NOTIFICATION_ID);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Ln.e(((Throwable) (obj)));
        }
        s1 = intent.getStringExtra("not_null_link");
        uri = Uri.parse(s1);
        obj = uri;
        intent = uri;
        if (!Uri.parse(deepLinkUtil.getDeepLink(s1).getParam("url")).getPath().startsWith("/points"))
        {
            break MISSING_BLOCK_LABEL_202;
        }
        intent = uri;
        obj = uri.buildUpon().appendQueryParameter("needsAuth", "true").appendQueryParameter("hide_header", "true").build();
        intent = ((Intent) (obj));
        grouponPointsUtil.logPointsNotificationClink("");
        intent = ((Intent) (obj));
        try
        {
            grouponPointsUtil.logPointsDeepLinking(((Uri) (obj)).toString(), ((Uri) (obj)).getQueryParameter("cid"), bundle1.getString("nid"));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Ln.e(((Throwable) (obj)));
            obj = intent;
        }
        intent = new Intent("android.intent.action.VIEW");
        intent.setData(((Uri) (obj)));
        intent.setFlags(0x10000000);
        intent.setPackage(context.getPackageName());
        Ln.d("GCM_Notification: Launching activity to this link: %s", new Object[] {
            s1
        });
        context.getApplicationContext().startActivity(intent);
        return;
        if (!((String) (obj)).equals("com.groupon.NOTIFICATION_OPENED")) goto _L1; else goto _L3
_L3:
        Ln.d("User clicked notification. Message: %s", new Object[] {
            intent.getStringExtra("alert")
        });
        Bundle bundle = intent.getExtras();
        if (bundle != null)
        {
            String s = intent.getStringExtra("nid");
            try
            {
                trackNotificationOpened(bundle);
                NotificationManagerCompat.from(context).cancel(com.groupon.Constants.Notification.DEAL_NOTIFICATION_ID);
            }
            catch (Exception exception)
            {
                Ln.e(exception);
            }
            intent = intent.getStringExtra("not_null_link");
            if (Strings.isEmpty(intent))
            {
                intent = new Intent(context.getApplicationContext(), com/groupon/activity/Splash);
                intent.setFlags(0x14000000);
                intent.setPackage(context.getPackageName());
                context.getApplicationContext().startActivity(intent);
                return;
            } else
            {
                intent = deepLinkUtil.normalizeUrl(intent, true);
                Intent intent1 = new Intent("android.intent.action.VIEW");
                intent1.setData(appendAttribution(Uri.parse(intent), s, "notification"));
                intent1.setFlags(0x10000000);
                intent1.setPackage(context.getPackageName());
                context.getApplicationContext().startActivity(intent1);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void trackNotificationOpened(Bundle bundle)
    {
        boolean flag = bundle.getBoolean("is_wearable");
        boolean flag1 = bundle.getBoolean("is_wearable_preview_purchase");
        String s = bundle.getString("notificationType");
        if (flag || flag1)
        {
            NotificationMetadata notificationmetadata = new NotificationMetadata();
            notificationmetadata.device = "wear";
            if (flag1)
            {
                bundle = "purchase";
            } else
            {
                bundle = "open";
            }
            notificationmetadata.type = bundle;
            logger.logClick(s, "push_notification_alert", "view", notificationmetadata, null);
            return;
        }
        if (Strings.isEmpty(bundle.getString("nid")))
        {
            bundle = "";
        } else
        {
            bundle = bundle.getString("nid");
        }
        logger.logClick(s, "push_notification_alert", "view", bundle);
    }
}
