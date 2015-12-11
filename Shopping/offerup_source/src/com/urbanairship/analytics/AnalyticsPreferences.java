// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import com.urbanairship.PreferenceDataStore;

class AnalyticsPreferences
{

    private static final String ANALYTICS_ENABLED_KEY = "com.urbanairship.analytics.ANALYTICS_ENABLED";
    private static final String KEY_PREFIX = "com.urbanairship.analytics";
    private static final String LAST_SEND_KEY = "com.urbanairship.analytics.LAST_SEND";
    static final int MAX_BATCH_INTERVAL_MS = 0x240c8400;
    static final int MAX_BATCH_SIZE_BYTES = 0x7d000;
    private static final String MAX_BATCH_SIZE_KEY = "com.urbanairship.analytics.MAX_BATCH_SIZE";
    static final int MAX_TOTAL_DB_SIZE_BYTES = 0x500000;
    private static final String MAX_TOTAL_DB_SIZE_KEY = "com.urbanairship.analytics.MAX_TOTAL_DB_SIZE";
    private static final String MAX_WAIT_KEY = "com.urbanairship.analytics.MAX_WAIT";
    static final int MAX_WAIT_MS = 0x48190800;
    private static final String MIN_BATCH_INTERVAL_KEY = "com.urbanairship.analytics.MIN_BATCH_INTERVAL";
    static final int MIN_BATCH_INTERVAL_MS = 60000;
    static final int MIN_BATCH_SIZE_BYTES = 1024;
    static final int MIN_TOTAL_DB_SIZE_BYTES = 10240;
    static final int MIN_WAIT_MS = 0x240c8400;
    private static final String SCHEDULED_SEND_TIME = "com.urbanairship.analytics.SCHEDULED_SEND_TIME";
    private final PreferenceDataStore preferenceDataStore;

    AnalyticsPreferences(PreferenceDataStore preferencedatastore)
    {
        preferenceDataStore = preferencedatastore;
    }

    long getLastSendTime()
    {
        return preferenceDataStore.getLong("com.urbanairship.analytics.LAST_SEND", 0L);
    }

    int getMaxBatchSize()
    {
        return preferenceDataStore.getInt("com.urbanairship.analytics.MAX_BATCH_SIZE", 0x7d000);
    }

    int getMaxTotalDbSize()
    {
        return preferenceDataStore.getInt("com.urbanairship.analytics.MAX_TOTAL_DB_SIZE", 0x500000);
    }

    int getMaxWait()
    {
        return preferenceDataStore.getInt("com.urbanairship.analytics.MAX_WAIT", 0x48190800);
    }

    int getMinBatchInterval()
    {
        return preferenceDataStore.getInt("com.urbanairship.analytics.MIN_BATCH_INTERVAL", 60000);
    }

    long getScheduledSendTime()
    {
        return preferenceDataStore.getLong("com.urbanairship.analytics.SCHEDULED_SEND_TIME", 0L);
    }

    boolean isAnalyticsEnabled()
    {
        return preferenceDataStore.getBoolean("com.urbanairship.analytics.ANALYTICS_ENABLED", true);
    }

    void setAnalyticsEnabled(boolean flag)
    {
        preferenceDataStore.put("com.urbanairship.analytics.ANALYTICS_ENABLED", flag);
    }

    void setLastSendTime(long l)
    {
        preferenceDataStore.put("com.urbanairship.analytics.LAST_SEND", l);
    }

    void setMaxBatchSize(int i)
    {
        preferenceDataStore.put("com.urbanairship.analytics.MAX_BATCH_SIZE", i);
    }

    void setMaxTotalDbSize(int i)
    {
        preferenceDataStore.put("com.urbanairship.analytics.MAX_TOTAL_DB_SIZE", i);
    }

    void setMaxWait(int i)
    {
        preferenceDataStore.put("com.urbanairship.analytics.MAX_WAIT", i);
    }

    void setMinBatchInterval(int i)
    {
        preferenceDataStore.put("com.urbanairship.analytics.MIN_BATCH_INTERVAL", i);
    }

    void setScheduledSendTime(long l)
    {
        preferenceDataStore.put("com.urbanairship.analytics.SCHEDULED_SEND_TIME", l);
    }
}
