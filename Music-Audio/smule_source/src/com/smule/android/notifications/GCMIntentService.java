// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.notifications;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.smule.android.c;
import com.smule.android.network.core.b;

// Referenced classes of package com.smule.android.notifications:
//            a, GCMReceiver

public class GCMIntentService extends IntentService
{

    public static final String a = com/smule/android/notifications/GCMIntentService.getSimpleName();

    public GCMIntentService()
    {
        super("GCMIntentService");
    }

    public static String a()
    {
        String s = b.d().a(c.b);
        if (s == null)
        {
            throw new RuntimeException("getSenderId - unable to find valid GCM_SENDER ID");
        } else
        {
            return s;
        }
    }

    private void a(Bundle bundle)
    {
        if (bundle != null)
        {
            String s = (String)bundle.get("DESTINATION_URI");
            String s1 = (String)bundle.get("MESSAGE");
            String s2 = (String)bundle.get("HEADER");
            bundle = (String)bundle.get("PARAMS");
            com.smule.android.notifications.a.a().a(this, s, s1, s2, s1, bundle);
        }
    }

    protected void onHandleIntent(Intent intent)
    {
        Bundle bundle;
        String s;
        bundle = intent.getExtras();
        s = GoogleCloudMessaging.getInstance(this).getMessageType(intent);
        break MISSING_BLOCK_LABEL_14;
        if (!bundle.isEmpty() && !"send_error".equals(s) && !"deleted_messages".equals(s) && "gcm".equals(s))
        {
            a(bundle);
            Log.i(a, (new StringBuilder()).append("Received: ").append(bundle.toString()).toString());
        }
        GCMReceiver.completeWakefulIntent(intent);
        return;
    }

}
