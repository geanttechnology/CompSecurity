// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

// Referenced classes of package com.urbanairship:
//            Logger, PreferenceDataStore

public abstract class dataStore
{

    private final Context context;
    private final PreferenceDataStore dataStore;

    protected Context getContext()
    {
        return context;
    }

    protected PreferenceDataStore getDataStore()
    {
        return dataStore;
    }

    protected long getInitialBackoff(Intent intent)
    {
        return 10000L;
    }

    protected long getMaxBackOff(Intent intent)
    {
        return 0x4e2000L;
    }

    protected abstract void onHandleIntent(Intent intent);

    public void retryIntent(Intent intent)
    {
        Object obj = new Intent(intent);
        ((Intent) (obj)).removeExtra("android.support.content.wakelockid");
        long l = ((Intent) (obj)).getLongExtra("com.urbanairship.EXTRA_BACK_OFF_MS", 0L);
        if (l <= 0L)
        {
            l = getInitialBackoff(((Intent) (obj)));
        } else
        {
            l = Math.min(l << 1, getMaxBackOff(((Intent) (obj))));
        }
        ((Intent) (obj)).putExtra("com.urbanairship.EXTRA_BACK_OFF_MS", l);
        Logger.verbose((new StringBuilder("BaseIntentService - Scheduling intent ")).append(((Intent) (obj)).getAction()).append(" in ").append(l).append(" milliseconds.").toString());
        intent = (AlarmManager)context.getSystemService("alarm");
        obj = PendingIntent.getService(context, 0, ((Intent) (obj)), 0x8000000);
        intent.set(3, l + SystemClock.elapsedRealtime(), ((PendingIntent) (obj)));
    }

    public (Context context1, PreferenceDataStore preferencedatastore)
    {
        context = context1;
        dataStore = preferencedatastore;
    }
}
