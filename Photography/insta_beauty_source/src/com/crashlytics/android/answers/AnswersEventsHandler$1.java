// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import bso;
import btb;
import bwv;

// Referenced classes of package com.crashlytics.android.answers:
//            AnswersEventsHandler, SessionAnalyticsManagerStrategy

class val.protocolAndHostOverride
    implements Runnable
{

    final AnswersEventsHandler this$0;
    final bwv val$analyticsSettingsData;
    final String val$protocolAndHostOverride;

    public void run()
    {
        try
        {
            strategy.setAnalyticsSettingsData(val$analyticsSettingsData, val$protocolAndHostOverride);
            return;
        }
        catch (Exception exception)
        {
            bso.h().e("Answers", "Failed to set analytics settings data", exception);
        }
    }

    Strategy()
    {
        this$0 = final_answerseventshandler;
        val$analyticsSettingsData = bwv;
        val$protocolAndHostOverride = String.this;
        super();
    }
}
