// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackActivity, UserFeedback

class val.thisActivity
    implements android.view.UserFeedbackActivity._cls2
{

    final UserFeedbackActivity this$0;
    final Activity val$thisActivity;

    public void onClick(View view)
    {
        view = UserFeedbackActivity.access$400(UserFeedbackActivity.this).createDialog(val$thisActivity, UserFeedbackActivity.access$000(UserFeedbackActivity.this), UserFeedbackActivity.access$100(UserFeedbackActivity.this), UserFeedbackActivity.access$200(UserFeedbackActivity.this).getText().toString());
        if (view == null)
        {
            UserFeedbackActivity.access$400(UserFeedbackActivity.this).submitFeedback(UserFeedbackActivity.access$000(UserFeedbackActivity.this), UserFeedbackActivity.access$100(UserFeedbackActivity.this), UserFeedbackActivity.access$200(UserFeedbackActivity.this).getText().toString(), false);
            setResult(-1);
            finish();
            return;
        } else
        {
            view.show();
            return;
        }
    }

    ()
    {
        this$0 = final_userfeedbackactivity;
        val$thisActivity = Activity.this;
        super();
    }
}
