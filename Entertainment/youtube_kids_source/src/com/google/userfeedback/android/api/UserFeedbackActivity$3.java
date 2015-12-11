// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackActivity, UserFeedback, UserFeedbackReport

class val.cx
    implements android.widget.tedListener
{

    final UserFeedbackActivity this$0;
    final Context val$cx;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (String)UserFeedbackActivity.access$600(UserFeedbackActivity.this).getSelectedItem();
        if (!adapterview.equals(val$cx.getString(val.cx)))
        {
            UserFeedbackActivity.access$400(UserFeedbackActivity.this).getReport().chosenAccount = adapterview;
            return;
        } else
        {
            UserFeedbackActivity.access$400(UserFeedbackActivity.this).getReport().chosenAccount = "";
            return;
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        UserFeedbackActivity.access$400(UserFeedbackActivity.this).getReport().chosenAccount = "";
    }

    ()
    {
        this$0 = final_userfeedbackactivity;
        val$cx = Context.this;
        super();
    }
}
