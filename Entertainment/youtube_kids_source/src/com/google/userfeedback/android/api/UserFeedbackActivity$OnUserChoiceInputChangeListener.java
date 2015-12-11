// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.widget.CompoundButton;
import android.widget.EditText;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackActivity

class <init>
    implements android.widget.eInputChangeListener
{

    final UserFeedbackActivity this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        UserFeedbackActivity.access$300(UserFeedbackActivity.this, UserFeedbackActivity.access$000(UserFeedbackActivity.this), UserFeedbackActivity.access$100(UserFeedbackActivity.this), UserFeedbackActivity.access$200(UserFeedbackActivity.this).getText().toString());
    }

    private ()
    {
        this$0 = UserFeedbackActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
