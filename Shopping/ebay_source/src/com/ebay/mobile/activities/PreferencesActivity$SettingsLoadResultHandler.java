// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.activities:
//            PreferencesActivity

static class startTime extends Handler
{

    private final WeakReference activityReference;
    public long startTime;

    public void handleMessage(Message message)
    {
label0:
        {
            message = (PreferencesActivity)activityReference.get();
            if (message != null)
            {
                if (!message.isNotificationsSettled())
                {
                    break label0;
                }
                message.removeDialog(0x7f0707c6);
                message.startNotificationPreferences();
            }
            return;
        }
        if (System.currentTimeMillis() - startTime > 30000L)
        {
            Log.d("PreferencesActivity", "SettingsLoadResultHandler: operation takes long time, aborted");
            message.removeDialog(0x7f0707c6);
            message.showDialog(0x7f07014c);
            return;
        } else
        {
            sleep(1000L);
            return;
        }
    }

    public void sleep(long l)
    {
        removeMessages(0);
        sendMessageDelayed(obtainMessage(0), l);
    }

    public (PreferencesActivity preferencesactivity, long l)
    {
        activityReference = new WeakReference(preferencesactivity);
        startTime = l;
    }
}
