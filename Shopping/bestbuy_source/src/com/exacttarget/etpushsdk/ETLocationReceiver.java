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
//            ETLocationService

public final class ETLocationReceiver extends WakefulBroadcastReceiver
{

    public static final String LOCATION_15MINUTE_UPDATE = "et_location_action_15minute_update";
    public static final int LOCATION_15MINUTE_UPDATE_REQUEST_CODE = 1001;
    public static final String LOCATION_GEOFENCE_CROSS = "et_location_action_geofence_cross";
    public static final int LOCATION_GEOFENCE_CROSS_REQUEST_CODE = 1002;
    public static final String LOCATION_PASSIVE_LOCATION_CHANGE = "et_location_action_passive_location_change";
    public static final int LOCATION_PASSIVE_LOCATION_CHANGE_REQUEST_CODE = 1003;
    public static final String LOCATION_TIMEOUT = "et_location_action_timeout";
    public static final int LOCATION_TIMEOUT_REQUEST_CODE = 1000;
    private static final String TAG = "~!ETLocationReceiver";

    public ETLocationReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        m.a("~!ETLocationReceiver", String.format("%s.onReceive()", new Object[] {
            getClass().getSimpleName()
        }));
        Intent intent1 = new Intent(context, com/exacttarget/etpushsdk/ETLocationService);
        String s = intent.getAction();
        if (!TextUtils.isEmpty(s))
        {
            m.a("~!ETLocationReceiver", String.format("Location action: %s", new Object[] {
                s
            }));
            intent1.setAction(s);
            if (intent.getExtras() != null)
            {
                intent1.putExtras(intent.getExtras());
            }
            startWakefulService(context, intent1);
            return;
        }
        try
        {
            m.d("~!ETLocationReceiver", "No action provided.");
            completeWakefulIntent(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            m.c("~!ETLocationReceiver", context.getMessage(), context);
        }
        completeWakefulIntent(intent);
        return;
    }
}
