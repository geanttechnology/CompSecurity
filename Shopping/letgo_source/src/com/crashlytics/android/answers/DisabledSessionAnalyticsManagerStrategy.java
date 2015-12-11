// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.support.v7.anu;
import android.support.v7.aov;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionAnalyticsManagerStrategy

class DisabledSessionAnalyticsManagerStrategy extends anu
    implements SessionAnalyticsManagerStrategy
{

    DisabledSessionAnalyticsManagerStrategy()
    {
    }

    public void processEvent(SessionEvent.Builder builder)
    {
    }

    public void setAnalyticsSettingsData(aov aov, String s)
    {
    }
}
