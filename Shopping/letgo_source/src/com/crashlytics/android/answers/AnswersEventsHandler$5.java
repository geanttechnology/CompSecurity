// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.support.v7.alt;
import android.support.v7.amc;

// Referenced classes of package com.crashlytics.android.answers:
//            AnswersEventsHandler, SessionAnalyticsManagerStrategy

class val.flush
    implements Runnable
{

    final AnswersEventsHandler this$0;
    final Strategy.rollFileOver val$eventBuilder;
    final boolean val$flush;

    public void run()
    {
        try
        {
            strategy.processEvent(val$eventBuilder);
            if (val$flush)
            {
                strategy.rollFileOver();
            }
            return;
        }
        catch (Exception exception)
        {
            alt.h().e("Answers", "Failed to process event", exception);
        }
    }

    Strategy()
    {
        this$0 = final_answerseventshandler;
        val$eventBuilder = strategy;
        val$flush = Z.this;
        super();
    }
}
