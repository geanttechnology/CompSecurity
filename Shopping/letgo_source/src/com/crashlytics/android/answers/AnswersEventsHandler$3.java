// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.support.v7.alt;
import android.support.v7.amc;

// Referenced classes of package com.crashlytics.android.answers:
//            AnswersEventsHandler, SessionAnalyticsManagerStrategy

class this._cls0
    implements Runnable
{

    final AnswersEventsHandler this$0;

    public void run()
    {
        try
        {
            strategy.sendEvents();
            return;
        }
        catch (Exception exception)
        {
            alt.h().e("Answers", "Failed to send events files", exception);
        }
    }

    Strategy()
    {
        this$0 = AnswersEventsHandler.this;
        super();
    }
}
