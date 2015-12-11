// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ch;
import com.urbanairship.actions.ActionService;
import com.urbanairship.actions.Situation;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.analytics.InteractiveNotificationEvent;
import com.urbanairship.push.PushMessage;
import com.urbanairship.push.iam.InAppMessage;
import com.urbanairship.push.iam.InAppMessageManager;
import com.urbanairship.push.iam.ResolutionEvent;
import com.urbanairship.util.UAStringUtil;

// Referenced classes of package com.urbanairship:
//            UAirship, Logger, AirshipConfigOptions, Autopilot

public class CoreReceiver extends BroadcastReceiver
{

    public CoreReceiver()
    {
    }

    private static void clearInAppMessage(String s)
    {
        if (!UAStringUtil.isEmpty(s))
        {
            InAppMessageManager inappmessagemanager = UAirship.shared().getInAppMessageManager();
            InAppMessage inappmessage = inappmessagemanager.getPendingMessage();
            InAppMessage inappmessage1 = inappmessagemanager.getCurrentMessage();
            if (inappmessage != null && s.equals(inappmessage.getId()) && !inappmessage.equals(inappmessage1))
            {
                Logger.info("Clearing pending in-app message due to directly interacting with the message's push notification.");
                inappmessagemanager.setPendingMessage(null);
                s = ResolutionEvent.createDirectOpenResolutionEvent(inappmessage);
                UAirship.shared().getAnalytics().addEvent(s);
                return;
            }
        }
    }

    static void handleChannelCapture(Context context, Intent intent)
    {
        if (intent.hasExtra("com.urbanairship.EXTRA_NOTIFICATION_ID"))
        {
            int i = intent.getIntExtra("com.urbanairship.EXTRA_NOTIFICATION_ID", -1);
            ch.a(context).a(i);
        }
        intent = intent.getStringExtra("com.urbanairship.EXTRA_ACTIONS");
        if (!UAStringUtil.isEmpty(intent))
        {
            Logger.debug((new StringBuilder("Running actions for notification action: ")).append(intent).toString());
            ActionService.runActions(context, intent, Situation.MANUAL_INVOCATION, null);
        }
    }

    static void handleNotificationButtonOpenedProxy(Context context, Intent intent)
    {
        Object obj = (PushMessage)intent.getParcelableExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE");
        if (obj == null)
        {
            Logger.error((new StringBuilder("CoreReceiver - Intent is missing push message for: ")).append(intent.getAction()).toString());
            return;
        }
        String s = intent.getStringExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ID");
        if (s == null)
        {
            Logger.error((new StringBuilder("CoreReceiver - Intent is missing notification button ID: ")).append(intent.getAction()).toString());
            return;
        }
        int i = intent.getIntExtra("com.urbanairship.push.NOTIFICATION_ID", -1);
        boolean flag = intent.getBooleanExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_FOREGROUND", true);
        String s1 = intent.getStringExtra("com.urbanairship.push.EXTRA_NOTIFICATION_ACTION_BUTTON_DESCRIPTION");
        Logger.info((new StringBuilder("Notification opened ID: ")).append(i).append(" action button Id: ").append(s).toString());
        if (flag)
        {
            UAirship.shared().getAnalytics().setConversionSendId(((PushMessage) (obj)).getSendId());
        }
        clearInAppMessage(((PushMessage) (obj)).getSendId());
        ch.a(context).a(i);
        obj = new InteractiveNotificationEvent(((PushMessage) (obj)), s, s1, flag);
        UAirship.shared().getAnalytics().addEvent(((com.urbanairship.analytics.Event) (obj)));
        context.sendOrderedBroadcast((new Intent("com.urbanairship.push.OPENED")).putExtras(intent.getExtras()).setPackage(UAirship.getPackageName()).addCategory(UAirship.getPackageName()), UAirship.getUrbanAirshipPermission());
    }

    private void handleNotificationDismissedProxy(Context context, Intent intent)
    {
        if ((PushMessage)intent.getParcelableExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE") == null)
        {
            Logger.error((new StringBuilder("CoreReceiver - Intent is missing push message for: ")).append(intent.getAction()).toString());
            return;
        }
        int i = intent.getIntExtra("com.urbanairship.push.NOTIFICATION_ID", -1);
        Logger.info((new StringBuilder("Notification dismissed ID: ")).append(i).toString());
        PendingIntent pendingintent = (PendingIntent)intent.getExtras().get("com.urbanairship.push.EXTRA_NOTIFICATION_DELETE_INTENT");
        if (pendingintent != null)
        {
            try
            {
                pendingintent.send();
            }
            catch (android.app.PendingIntent.CanceledException canceledexception)
            {
                Logger.debug("Failed to send notification's deleteIntent, already canceled.");
            }
        }
        context.sendOrderedBroadcast((new Intent("com.urbanairship.push.DISMISSED")).putExtras(intent.getExtras()).setPackage(UAirship.getPackageName()).addCategory(UAirship.getPackageName()), UAirship.getUrbanAirshipPermission());
    }

    private void handleNotificationOpened(Context context, Intent intent)
    {
        PushMessage pushmessage;
        Object obj;
        obj = UAirship.shared().getAirshipConfigOptions();
        pushmessage = (PushMessage)intent.getParcelableExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE");
        if (pushmessage != null) goto _L2; else goto _L1
_L1:
        Logger.error((new StringBuilder("CoreReceiver - Intent is missing push message for: ")).append(intent.getAction()).toString());
_L4:
        return;
_L2:
        if (!intent.hasExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ID"))
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag = intent.getBooleanExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_FOREGROUND", false);
        String s = intent.getStringExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ACTIONS_PAYLOAD");
        if (flag && getResultCode() != 1 && ((AirshipConfigOptions) (obj)).autoLaunchApplication && launchApplication(context) && isOrderedBroadcast())
        {
            setResultCode(1);
        }
        if (!UAStringUtil.isEmpty(s))
        {
            Logger.debug((new StringBuilder("Running actions for notification action: ")).append(s).toString());
            if (flag)
            {
                intent = Situation.FOREGROUND_NOTIFICATION_ACTION_BUTTON;
            } else
            {
                intent = Situation.BACKGROUND_NOTIFICATION_ACTION_BUTTON;
            }
            obj = new Bundle();
            ((Bundle) (obj)).putParcelable("com.urbanairship.PUSH_MESSAGE", pushmessage);
            ActionService.runActions(context, s, intent, ((Bundle) (obj)));
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (getResultCode() == 1) goto _L6; else goto _L5
_L5:
        intent = (PendingIntent)intent.getExtras().get("com.urbanairship.push.EXTRA_NOTIFICATION_CONTENT_INTENT");
        if (intent == null) goto _L8; else goto _L7
_L7:
        try
        {
            intent.send();
            if (isOrderedBroadcast())
            {
                setResultCode(1);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Logger.debug("Failed to send notification's contentIntent, already canceled.");
        }
_L6:
        intent = new Bundle();
        intent.putParcelable("com.urbanairship.PUSH_MESSAGE", pushmessage);
        ActionService.runActions(context, pushmessage.getActions(), Situation.PUSH_OPENED, intent);
        return;
_L8:
        if (((AirshipConfigOptions) (obj)).autoLaunchApplication && launchApplication(context) && isOrderedBroadcast())
        {
            setResultCode(1);
        }
        if (true) goto _L6; else goto _L9
_L9:
    }

    static void handleNotificationOpenedProxy(Context context, Intent intent)
    {
        PushMessage pushmessage = (PushMessage)intent.getParcelableExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE");
        if (pushmessage == null)
        {
            Logger.error((new StringBuilder("CoreReceiver - Intent is missing push message for: ")).append(intent.getAction()).toString());
            return;
        } else
        {
            int i = intent.getIntExtra("com.urbanairship.push.NOTIFICATION_ID", -1);
            Logger.info((new StringBuilder("Notification opened ID: ")).append(i).toString());
            UAirship.shared().getAnalytics().setConversionSendId(pushmessage.getSendId());
            clearInAppMessage(pushmessage.getSendId());
            context.sendOrderedBroadcast((new Intent("com.urbanairship.push.OPENED")).putExtras(intent.getExtras()).setPackage(UAirship.getPackageName()).addCategory(UAirship.getPackageName()), UAirship.getUrbanAirshipPermission());
            return;
        }
    }

    private boolean launchApplication(Context context)
    {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(UAirship.getPackageName());
        if (intent != null)
        {
            intent.setFlags(0x30000000);
            Logger.info("Starting application's launch intent.");
            context.startActivity(intent);
            return true;
        } else
        {
            Logger.info("Unable to launch application. Launch intent is unavailable.");
            return false;
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        String s;
        byte byte0;
        Autopilot.automaticTakeOff(context);
        if (intent == null || intent.getAction() == null)
        {
            return;
        }
        Logger.verbose((new StringBuilder("CoreReceiver - Received intent: ")).append(intent.getAction()).toString());
        s = intent.getAction();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 100
    //                   -1604106496: 175
    //                   -618294128: 191
    //                   -94640370: 206
    //                   168853520: 143
    //                   1702142669: 159;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_206;
_L7:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            handleNotificationOpenedProxy(context, intent);
            return;

        case 1: // '\001'
            handleNotificationButtonOpenedProxy(context, intent);
            return;

        case 2: // '\002'
            handleNotificationDismissedProxy(context, intent);
            return;

        case 3: // '\003'
            handleNotificationOpened(context, intent);
            return;

        case 4: // '\004'
            handleChannelCapture(context, intent);
            break;
        }
        break MISSING_BLOCK_LABEL_247;
_L5:
        if (s.equals("com.urbanairship.ACTION_NOTIFICATION_OPENED_PROXY"))
        {
            byte0 = 0;
        }
          goto _L7
_L6:
        if (s.equals("com.urbanairship.ACTION_NOTIFICATION_BUTTON_OPENED_PROXY"))
        {
            byte0 = 1;
        }
          goto _L7
_L2:
        if (s.equals("com.urbanairship.ACTION_NOTIFICATION_DISMISSED_PROXY"))
        {
            byte0 = 2;
        }
          goto _L7
_L3:
        if (s.equals("com.urbanairship.push.OPENED"))
        {
            byte0 = 3;
        }
          goto _L7
        if (s.equals("com.urbanairship.ACTION_CHANNEL_CAPTURE"))
        {
            byte0 = 4;
        }
          goto _L7
    }
}
