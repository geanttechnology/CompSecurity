// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.b.h;

// Referenced classes of package com.urbanairship:
//            PreferenceDataStore

public class ApplicationMetrics
{

    private static final String LAST_OPEN_KEY = "com.urbanairship.application.metrics.LAST_OPEN";
    private final PreferenceDataStore preferenceDataStore;

    ApplicationMetrics(Context context, PreferenceDataStore preferencedatastore)
    {
        preferenceDataStore = preferencedatastore;
        registerBroadcastReceivers(context);
    }

    private void registerBroadcastReceivers(Context context)
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("com.urbanairship.analytics.APP_FOREGROUND");
        h.a(context).a(new _cls1(), intentfilter);
    }

    public long getLastOpenTimeMillis()
    {
        return preferenceDataStore.getLong("com.urbanairship.application.metrics.LAST_OPEN", -1L);
    }


    private class _cls1 extends BroadcastReceiver
    {

        final ApplicationMetrics this$0;

        public void onReceive(Context context, Intent intent)
        {
            preferenceDataStore.put("com.urbanairship.application.metrics.LAST_OPEN", System.currentTimeMillis());
        }

        _cls1()
        {
            this$0 = ApplicationMetrics.this;
            super();
        }
    }

}
