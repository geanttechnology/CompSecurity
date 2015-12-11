// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedback

class val.activity
    implements android.content..OnClickListener
{

    final UserFeedback this$0;
    final Activity val$activity;
    final String val$feedbackText;
    final boolean val$includeScreenshot;
    final boolean val$includeSystemLogs;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        submitFeedback(val$includeScreenshot, val$includeSystemLogs, val$feedbackText, false);
        val$activity.setResult(-1);
        val$activity.finish();
    }

    ()
    {
        this$0 = final_userfeedback;
        val$includeScreenshot = flag;
        val$includeSystemLogs = flag1;
        val$feedbackText = s;
        val$activity = Activity.this;
        super();
    }
}
