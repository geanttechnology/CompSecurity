// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.b.l;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.urbanairship:
//            Autopilot, UAirship, Logger, PreferenceDataStore

public abstract class BaseIntentService extends IntentService
{

    protected static final long DEFAULT_MAX_BACK_OFF_TIME_MS = 0x4e2000L;
    protected static final long DEFAULT_STARTING_BACK_OFF_TIME_MS = 10000L;
    private static final String EXTRA_BACK_OFF_MS = "com.urbanairship.EXTRA_BACK_OFF_MS";
    private final Map delegateMap = new HashMap();

    public BaseIntentService(String s)
    {
        super(s);
    }

    protected abstract Delegate getServiceDelegate(String s, PreferenceDataStore preferencedatastore);

    public void onCreate()
    {
        super.onCreate();
        Autopilot.automaticTakeOff(getApplicationContext());
    }

    protected void onHandleIntent(Intent intent)
    {
        if (intent == null)
        {
            return;
        }
        String s = intent.getAction();
        if (s == null)
        {
            l.completeWakefulIntent(intent);
            return;
        }
        Delegate delegate2 = (Delegate)delegateMap.get(s);
        Delegate delegate1;
        delegate1 = delegate2;
        if (delegate2 != null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        delegate1 = getServiceDelegate(s, UAirship.shared().preferenceDataStore);
        if (delegate1 != null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        Logger.debug((new StringBuilder("BaseIntentService - No delegate for intent action: ")).append(s).toString());
        l.completeWakefulIntent(intent);
        return;
        delegateMap.put(s, delegate1);
        delegate1.onHandleIntent(intent);
        l.completeWakefulIntent(intent);
        return;
        Exception exception;
        exception;
        l.completeWakefulIntent(intent);
        throw exception;
    }

    private class Delegate
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
            long l1 = ((Intent) (obj)).getLongExtra("com.urbanairship.EXTRA_BACK_OFF_MS", 0L);
            if (l1 <= 0L)
            {
                l1 = getInitialBackoff(((Intent) (obj)));
            } else
            {
                l1 = Math.min(l1 << 1, getMaxBackOff(((Intent) (obj))));
            }
            ((Intent) (obj)).putExtra("com.urbanairship.EXTRA_BACK_OFF_MS", l1);
            Logger.verbose((new StringBuilder("BaseIntentService - Scheduling intent ")).append(((Intent) (obj)).getAction()).append(" in ").append(l1).append(" milliseconds.").toString());
            intent = (AlarmManager)context.getSystemService("alarm");
            obj = PendingIntent.getService(context, 0, ((Intent) (obj)), 0x8000000);
            intent.set(3, l1 + SystemClock.elapsedRealtime(), ((PendingIntent) (obj)));
        }

        public Delegate(Context context1, PreferenceDataStore preferencedatastore)
        {
            context = context1;
            dataStore = preferencedatastore;
        }
    }

}
