// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.app.AlertDialog;
import android.view.View;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackActivity

class this._cls0
    implements android.view.UserFeedbackActivity._cls4
{

    final UserFeedbackActivity this$0;

    public void onClick(View view)
    {
        view = (new android.app.it>(UserFeedbackActivity.this)).Title(getString(icy)).Message(getString(t)).ate();
        class _cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final UserFeedbackActivity._cls4 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            _cls1()
            {
                this$1 = UserFeedbackActivity._cls4.this;
                super();
            }
        }

        view.setButton("OK", new _cls1());
        view.show();
    }

    _cls1()
    {
        this$0 = UserFeedbackActivity.this;
        super();
    }
}
