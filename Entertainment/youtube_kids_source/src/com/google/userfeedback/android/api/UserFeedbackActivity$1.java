// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackActivity, PreviewActivity

class this._cls0
    implements android.view.UserFeedbackActivity._cls1
{

    final UserFeedbackActivity this$0;

    public void onClick(View view)
    {
        UserFeedbackActivity.access$300(UserFeedbackActivity.this, UserFeedbackActivity.access$000(UserFeedbackActivity.this), UserFeedbackActivity.access$100(UserFeedbackActivity.this), UserFeedbackActivity.access$200(UserFeedbackActivity.this).getText().toString());
        view = new Intent(getApplicationContext(), com/google/userfeedback/android/api/PreviewActivity);
        startActivityForResult(view, 0);
    }

    ()
    {
        this$0 = UserFeedbackActivity.this;
        super();
    }
}
