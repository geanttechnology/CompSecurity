// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.text.TextUtils;
import com.exacttarget.etpushsdk.util.m;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETPushService

public final class ETPushReceiver extends WakefulBroadcastReceiver
{

    public static final int ACTIVITY_PAUSED_REQUEST_CODE = 1000;
    protected static final String APP_IN_BACKGROUND = "et_push_app_in_background";
    protected static final String MESSAGE_OPENED = ".MESSAGE_OPENED";
    protected static final String NOTIFICATION_ID = "et_notification_id_key";
    protected static final String OPEN_TYPE_EXTRA = "et_open_type_extra";
    protected static final String PUSH_ACTION = "et_push_action";
    protected static final String PUSH_ACTION_OPEN = "et_push_action_open";
    protected static final String PUSH_ACTION_OPEN_INTENT = "et_push_open_intent";
    protected static final String PUSH_ACTION_SEND = "et_push_action_send";
    protected static final String SEND_TYPE_CLOUDPAGE_REQUEST = "et_send_type_cloudpage";
    public static final String SEND_TYPE_CUSTOM_APP_REQUEST = "et_send_type_custom_app_request";
    protected static final String SEND_TYPE_ET_ANALYTIC_EVENTS = "et_send_type_analytic_events";
    protected static final String SEND_TYPE_EXTRA = "et_send_type_extra";
    protected static final String SEND_TYPE_GEOFENCE_REQUEST = "et_send_type_geofence";
    protected static final String SEND_TYPE_LOCATION = "et_send_type_location";
    protected static final String SEND_TYPE_PI_ANALYTIC_EVENTS = "pi_send_type_analytic_events";
    protected static final String SEND_TYPE_PROXIMITY_REQUEST = "et_send_type_proximity";
    protected static final String SEND_TYPE_REGISTRATION = "et_send_type_registration";
    private static final String TAG = "~!ETPushReceiver";

    public ETPushReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Intent intent1;
        String s;
        m.a("~!ETPushReceiver", String.format("%s.onReceive()", new Object[] {
            getClass().getSimpleName()
        }));
        String s2;
        try
        {
            intent1 = new Intent(context, com/exacttarget/etpushsdk/ETPushService);
            if (intent.getExtras() != null)
            {
                intent1.putExtras(intent.getExtras());
            }
            s = intent.getAction();
            String s1 = intent.getStringExtra("et_send_type_extra");
            s2 = intent.getStringExtra("et_open_type_extra");
            if (!TextUtils.isEmpty(s1))
            {
                intent1.putExtra("et_push_action", "et_push_action_send");
                m.a("~!ETPushReceiver", String.format("Push action: %s", new Object[] {
                    "et_push_action_send"
                }));
                startWakefulService(context, intent1);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            m.c("~!ETPushReceiver", context.getMessage(), context);
            completeWakefulIntent(intent);
            return;
        }
        if (!TextUtils.isEmpty(s2))
        {
            intent1.putExtra("et_push_action", "et_push_action_open");
            m.a("~!ETPushReceiver", String.format("Push action: %s", new Object[] {
                "et_push_action_open"
            }));
            startWakefulService(context, intent1);
            return;
        }
        if (!TextUtils.isEmpty(s))
        {
            intent1.putExtra("et_push_action", s);
            m.a("~!ETPushReceiver", String.format("Push action: %s", new Object[] {
                s
            }));
            startWakefulService(context, intent1);
            return;
        }
        m.d("~!ETPushReceiver", "No action provided.");
        completeWakefulIntent(intent);
        return;
    }
}
