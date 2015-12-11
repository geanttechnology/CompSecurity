// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ch;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.CoreReceiver;
import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionService;
import com.urbanairship.actions.Situation;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.analytics.PushArrivedEvent;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.iam.InAppMessageManager;
import com.urbanairship.push.notifications.NotificationFactory;
import com.urbanairship.richpush.RichPushManager;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.urbanairship.push:
//            PushManager, PushMessage

class IncomingPushServiceDelegate extends com.urbanairship.BaseIntentService.Delegate
{

    private static final String LAST_CANONICAL_IDS_KEY = "com.urbanairship.push.LAST_CANONICAL_IDS";
    private static final int MAX_CANONICAL_IDS = 10;
    private static final int RICH_PUSH_REFRESH_WAIT_TIME_MS = 60000;
    private final UAirship airship;
    private final ch notificationManager;
    private final PushManager pushManager;

    public IncomingPushServiceDelegate(Context context, PreferenceDataStore preferencedatastore)
    {
        this(context, preferencedatastore, UAirship.shared(), ch.a(context));
    }

    public IncomingPushServiceDelegate(Context context, PreferenceDataStore preferencedatastore, UAirship uairship, ch ch1)
    {
        super(context, preferencedatastore);
        airship = uairship;
        pushManager = uairship.getPushManager();
        notificationManager = ch1;
    }

    private void createPushArrivedEvent(String s)
    {
        String s1 = s;
        if (UAStringUtil.isEmpty(s))
        {
            s1 = UUID.randomUUID().toString();
        }
        airship.getAnalytics().addEvent(new PushArrivedEvent(s1));
    }

    private boolean isUniqueCanonicalId(String s)
    {
        if (UAStringUtil.isEmpty(s))
        {
            return true;
        }
        Object obj;
        try
        {
            obj = JsonValue.parseString(getDataStore().getString("com.urbanairship.push.LAST_CANONICAL_IDS", null)).getList();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.debug("IncomingPushServiceDelegate - Unable to parse canonical Ids.", ((Throwable) (obj)));
            obj = null;
        }
        if (obj == null)
        {
            obj = new ArrayList();
        } else
        {
            obj = ((JsonList) (obj)).getList();
        }
        s = JsonValue.wrap(s);
        if (((List) (obj)).contains(s))
        {
            return false;
        }
        ((List) (obj)).add(s);
        s = ((String) (obj));
        if (((List) (obj)).size() > 10)
        {
            s = ((List) (obj)).subList(((List) (obj)).size() - 10, ((List) (obj)).size());
        }
        getDataStore().put("com.urbanairship.push.LAST_CANONICAL_IDS", JsonValue.wrap(s, null).toString());
        return true;
    }

    private void onAdmMessageReceived(Intent intent)
    {
        if (airship.getPlatformType() != 1)
        {
            Logger.error("Received intent from invalid transport acting as ADM.");
            return;
        }
        if (!airship.getPushManager().isPushAvailable())
        {
            Logger.error("IncomingPushServiceDelegate - Received intent from ADM without registering.");
            return;
        }
        intent = (Intent)intent.getParcelableExtra("com.urbanairship.push.EXTRA_INTENT");
        if (intent == null)
        {
            Logger.error("IncomingPushServiceDelegate - Received ADM message missing original intent.");
            return;
        } else
        {
            processMessage(new PushMessage(intent.getExtras()));
            return;
        }
    }

    private void onGcmMessageReceived(Intent intent)
    {
        if (airship.getPlatformType() != 2)
        {
            Logger.error("Received intent from invalid transport acting as GCM.");
            return;
        }
        if (!airship.getPushManager().isPushAvailable())
        {
            Logger.error("IncomingPushServiceDelegate - Received intent from GCM without registering.");
            return;
        }
        intent = (Intent)intent.getParcelableExtra("com.urbanairship.push.EXTRA_INTENT");
        if (intent == null)
        {
            Logger.error("IncomingPushServiceDelegate - Received GCM message missing original intent.");
            return;
        }
        String s = intent.getStringExtra("from");
        if (s != null && !s.equals(airship.getAirshipConfigOptions().gcmSender))
        {
            Logger.info((new StringBuilder("Ignoring GCM message from sender: ")).append(s).toString());
            return;
        }
        if ("deleted_messages".equals(intent.getStringExtra("message_type")))
        {
            Logger.info((new StringBuilder("GCM deleted ")).append(intent.getStringExtra("total_deleted")).append(" pending messages.").toString());
            return;
        } else
        {
            processMessage(new PushMessage(intent.getExtras()));
            return;
        }
    }

    private void processMessage(PushMessage pushmessage)
    {
        if (!pushManager.isPushEnabled())
        {
            Logger.info("Received a push when push is disabled! Ignoring.");
            return;
        }
        if (!isUniqueCanonicalId(pushmessage.getCanonicalPushId()))
        {
            Logger.info((new StringBuilder("Received a duplicate push with canonical ID: ")).append(pushmessage.getCanonicalPushId()).toString());
            return;
        }
        pushManager.setLastReceivedSendId(pushmessage.getSendId());
        createPushArrivedEvent(pushmessage.getSendId());
        if (pushmessage.isExpired())
        {
            Logger.debug("Received expired push message, ignoring.");
            return;
        }
        if (pushmessage.isPing())
        {
            Logger.verbose("IncomingPushServiceDelegate - Received UA Ping");
            return;
        }
        Object obj = new Bundle();
        ((Bundle) (obj)).putParcelable("com.urbanairship.PUSH_MESSAGE", pushmessage);
        ActionService.runActions(UAirship.getApplicationContext(), pushmessage.getActions(), Situation.PUSH_RECEIVED, ((Bundle) (obj)));
        obj = pushmessage.getInAppMessage();
        if (obj != null)
        {
            Logger.debug("IncomingPushServiceDelegate - Received a Push with an in-app message.");
            airship.getInAppMessageManager().setPendingMessage(((com.urbanairship.push.iam.InAppMessage) (obj)));
        }
        if (!UAStringUtil.isEmpty(pushmessage.getRichPushMessageId()))
        {
            Logger.debug("IncomingPushServiceDelegate - Received a Rich Push.");
            refreshRichPushMessages();
        }
        obj = null;
        if (!pushManager.getUserNotificationsEnabled())
        {
            Logger.info((new StringBuilder("User notifications disabled. Unable to display notification for message: ")).append(pushmessage).toString());
        } else
        {
            obj = showNotification(pushmessage, pushManager.getNotificationFactory());
        }
        sendPushReceivedBroadcast(pushmessage, ((Integer) (obj)));
    }

    private void refreshRichPushMessages()
    {
        final Semaphore semaphore = new Semaphore(0);
        airship.getRichPushManager().refreshMessages(new _cls1());
        try
        {
            semaphore.tryAcquire(60000L, TimeUnit.MILLISECONDS);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Logger.warn("Interrupted while waiting for rich push messages to refresh");
        }
    }

    private void sendPushReceivedBroadcast(PushMessage pushmessage, Integer integer)
    {
        pushmessage = (new Intent("com.urbanairship.push.RECEIVED")).putExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE", pushmessage).addCategory(UAirship.getPackageName()).setPackage(UAirship.getPackageName());
        if (integer != null)
        {
            pushmessage.putExtra("com.urbanairship.push.NOTIFICATION_ID", integer.intValue());
        }
        getContext().sendBroadcast(pushmessage, UAirship.getUrbanAirshipPermission());
    }

    private Integer showNotification(PushMessage pushmessage, NotificationFactory notificationfactory)
    {
        if (notificationfactory == null)
        {
            Logger.info((new StringBuilder("NotificationFactory is null. Unable to display notification for message: ")).append(pushmessage).toString());
            return null;
        }
        Integer integer;
        try
        {
            integer = Integer.valueOf(notificationfactory.getNextId(pushmessage));
            notificationfactory = notificationfactory.createNotification(pushmessage, integer.intValue());
        }
        // Misplaced declaration of an exception variable
        catch (PushMessage pushmessage)
        {
            Logger.error("Unable to create and display notification.", pushmessage);
            return null;
        }
        if (notificationfactory != null)
        {
            if (!pushManager.isVibrateEnabled() || pushManager.isInQuietTime())
            {
                notificationfactory.vibrate = null;
                notificationfactory.defaults = ((Notification) (notificationfactory)).defaults & -3;
            }
            if (!pushManager.isSoundEnabled() || pushManager.isInQuietTime())
            {
                notificationfactory.sound = null;
                notificationfactory.defaults = ((Notification) (notificationfactory)).defaults & -2;
            }
            Intent intent = (new Intent(getContext(), com/urbanairship/CoreReceiver)).setAction("com.urbanairship.ACTION_NOTIFICATION_OPENED_PROXY").addCategory(UUID.randomUUID().toString()).putExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE", pushmessage).putExtra("com.urbanairship.push.NOTIFICATION_ID", integer);
            if (((Notification) (notificationfactory)).contentIntent != null)
            {
                intent.putExtra("com.urbanairship.push.EXTRA_NOTIFICATION_CONTENT_INTENT", ((Notification) (notificationfactory)).contentIntent);
            }
            pushmessage = (new Intent(getContext(), com/urbanairship/CoreReceiver)).setAction("com.urbanairship.ACTION_NOTIFICATION_DISMISSED_PROXY").addCategory(UUID.randomUUID().toString()).putExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE", pushmessage).putExtra("com.urbanairship.push.NOTIFICATION_ID", integer);
            if (((Notification) (notificationfactory)).deleteIntent != null)
            {
                pushmessage.putExtra("com.urbanairship.push.EXTRA_NOTIFICATION_DELETE_INTENT", ((Notification) (notificationfactory)).deleteIntent);
            }
            notificationfactory.contentIntent = PendingIntent.getBroadcast(getContext(), 0, intent, 0);
            notificationfactory.deleteIntent = PendingIntent.getBroadcast(getContext(), 0, pushmessage, 0);
            Logger.info((new StringBuilder("Posting notification ")).append(notificationfactory).append(" with ID ").append(integer).toString());
            notificationManager.a(integer.intValue(), notificationfactory);
        }
        return integer;
    }

    protected void onHandleIntent(Intent intent)
    {
        String s;
        byte byte0;
        s = intent.getAction();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 36
    //                   -1138418629: 76
    //                   856841428: 61;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_76;
_L4:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            onAdmMessageReceived(intent);
            return;

        case 1: // '\001'
            onGcmMessageReceived(intent);
            break;
        }
        break MISSING_BLOCK_LABEL_102;
_L3:
        if (s.equals("com.urbanairship.push.ACTION_RECEIVE_ADM_MESSAGE"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s.equals("com.urbanairship.push.ACTION_RECEIVE_GCM_MESSAGE"))
        {
            byte0 = 1;
        }
          goto _L4
    }

    private class _cls1
        implements com.urbanairship.richpush.RichPushManager.RefreshMessagesCallback
    {

        final IncomingPushServiceDelegate this$0;
        final Semaphore val$semaphore;

        public void onRefreshMessages(boolean flag)
        {
            semaphore.release();
        }

        _cls1()
        {
            this$0 = IncomingPushServiceDelegate.this;
            semaphore = semaphore1;
            super();
        }
    }

}
