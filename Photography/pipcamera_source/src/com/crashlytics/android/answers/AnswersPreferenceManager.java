// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import adf;
import android.content.SharedPreferences;

class AnswersPreferenceManager
{

    static final String PREFKEY_ANALYTICS_LAUNCHED = "analytics_launched";
    private final adf prefStore;

    public AnswersPreferenceManager(adf adf1)
    {
        prefStore = adf1;
    }

    public boolean hasAnalyticsLaunched()
    {
        return prefStore.a().getBoolean("analytics_launched", false);
    }

    public void setAnalyticsLaunched()
    {
        prefStore.a(prefStore.b().putBoolean("analytics_launched", true));
    }
}
