// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import c.a.a.a.e;
import c.a.a.a.q;

// Referenced classes of package com.crashlytics.android.answers:
//            AnswersEventsHandler, DisabledSessionAnalyticsManagerStrategy, SessionAnalyticsManagerStrategy

class this._cls0
    implements Runnable
{

    final AnswersEventsHandler this$0;

    public void run()
    {
        try
        {
            SessionAnalyticsManagerStrategy sessionanalyticsmanagerstrategy = strategy;
            strategy = new DisabledSessionAnalyticsManagerStrategy();
            sessionanalyticsmanagerstrategy.deleteAllEvents();
            return;
        }
        catch (Exception exception)
        {
            e.d().c("Answers", "Failed to disable events", exception);
        }
    }

    Strategy()
    {
        this$0 = AnswersEventsHandler.this;
        super();
    }
}
