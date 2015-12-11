// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

// Referenced classes of package com.localytics.android:
//            DatapointHelper, Localytics, ReflectionUtils

public class PushReceiver extends BroadcastReceiver
{

    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY = 5000L;
    private static int numRetries = 0;
    static String retrySenderId = null;

    public PushReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = DatapointHelper.getLocalyticsAppKeyOrNull(context);
        if (!TextUtils.isEmpty(s))
        {
            Localytics.integrate(context.getApplicationContext(), s);
        }
        if (!intent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION")) goto _L2; else goto _L1
_L1:
        Localytics.handleRegistration(intent);
_L4:
        return;
_L2:
        Bundle bundle = intent.getExtras();
        int i;
        try
        {
            context = ((Context) (ReflectionUtils.tryInvokeStatic("com.google.android.gms.gcm.GoogleCloudMessaging", "getInstance", new Class[] {
                android/content/Context
            }, new Object[] {
                context
            })));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Localytics.Log.w("Something went wrong with GCM", context);
            return;
        }
        if (context == null) goto _L4; else goto _L3
_L3:
        context = (String)ReflectionUtils.tryInvokeInstance(context, "getMessageType", new Class[] {
            android/content/Intent
        }, new Object[] {
            intent
        });
        if (bundle.isEmpty()) goto _L4; else goto _L5
_L5:
        if (!ReflectionUtils.tryGetStaticField("com.google.android.gms.gcm.GoogleCloudMessaging", "ERROR_SERVICE_NOT_AVAILABLE").equals(context))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (TextUtils.isEmpty(retrySenderId)) goto _L4; else goto _L6
_L6:
        i = numRetries + 1;
        numRetries = i;
        if (i > 3)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        Localytics.Log.w("GCM registration ERROR_SERVICE_NOT_AVAILABLE. Retrying in 5000 milliseconds.");
        Localytics.registerPush(retrySenderId, 5000L);
_L7:
        retrySenderId = null;
        return;
        numRetries = 0;
          goto _L7
        if (!ReflectionUtils.tryGetStaticField("com.google.android.gms.gcm.GoogleCloudMessaging", "MESSAGE_TYPE_MESSAGE").equals(context)) goto _L4; else goto _L8
_L8:
        Localytics.handleNotificationReceived(intent);
        return;
    }

}
