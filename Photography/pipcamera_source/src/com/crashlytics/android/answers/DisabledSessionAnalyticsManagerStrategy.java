// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import ace;
import adi;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionAnalyticsManagerStrategy

class DisabledSessionAnalyticsManagerStrategy extends ace
    implements SessionAnalyticsManagerStrategy
{

    DisabledSessionAnalyticsManagerStrategy()
    {
    }

    public void processEvent(SessionEvent.Builder builder)
    {
    }

    public void setAnalyticsSettingsData(adi adi, String s)
    {
    }
}
