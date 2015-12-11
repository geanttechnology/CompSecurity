// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedback, PreviewActivity

class val.thisActivity
    implements android.view.er
{

    final PreviewActivity this$0;
    final Activity val$thisActivity;

    public void onClick(View view)
    {
        view = UserFeedback.userFeedback();
        Dialog dialog = view.createDialog(val$thisActivity, view.shouldIncludeScreenshot(), view.shouldIncludeSystemLogs(), view.getFeedbackText());
        if (dialog == null)
        {
            view.submitFeedback(view.shouldIncludeScreenshot(), view.shouldIncludeSystemLogs(), view.getFeedbackText(), false);
            view = new Intent();
            setResult(-1, view);
            finish();
            return;
        } else
        {
            dialog.show();
            return;
        }
    }

    ()
    {
        this$0 = final_previewactivity;
        val$thisActivity = Activity.this;
        super();
    }
}
