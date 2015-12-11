// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.os.AsyncTask;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackReportBuilder, UserFeedbackReport

class val.listener extends AsyncTask
{

    final UserFeedbackReportBuilder this$0;
    final omplete val$listener;
    final UserFeedbackReport val$report;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        UserFeedbackReportBuilder.access$000(UserFeedbackReportBuilder.this, val$report);
        if (val$listener != null)
        {
            val$listener.omplete();
        }
        return null;
    }

    ()
    {
        this$0 = final_userfeedbackreportbuilder;
        val$report = userfeedbackreport;
        val$listener = val.listener.this;
        super();
    }
}
