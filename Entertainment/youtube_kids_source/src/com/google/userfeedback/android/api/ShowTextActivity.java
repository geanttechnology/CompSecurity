// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedback, UserFeedbackReport, UserFeedbackCrashData

public class ShowTextActivity extends Activity
{

    private static final String TAG = "ShowTextActivity";

    public ShowTextActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.gf_show_text_activity);
        bundle = getIntent().getStringExtra("feedback.FIELD_NAME");
        UserFeedbackReport userfeedbackreport = UserFeedback.userFeedback().getReport();
        if (userfeedbackreport == null)
        {
            finish();
            return;
        }
        if ("systemLog".equals(bundle))
        {
            setTitle(R.string.gf_error_report_system_log);
            setText(userfeedbackreport.systemLog);
            return;
        }
        if ("serviceDetails".equals(bundle))
        {
            setTitle(R.string.gf_error_report_running_service_details);
            return;
        }
        if ("stackTrace".equals(bundle))
        {
            setTitle(R.string.gf_stack_trace);
            setText(userfeedbackreport.crashData.stackTrace);
            return;
        } else
        {
            throw new IllegalArgumentException("ShowTextActivity unknown EXTRA_FIELD_NAME");
        }
    }

    protected void setText(String s)
    {
        if (s == null)
        {
            findViewById(R.id.gf_text_view).setVisibility(8);
            findViewById(R.id.gf_empty_view).setVisibility(0);
            return;
        } else
        {
            ((TextView)findViewById(R.id.gf_text)).setText(s);
            findViewById(R.id.gf_empty_view).setVisibility(8);
            findViewById(R.id.gf_text_view).setVisibility(0);
            return;
        }
    }
}
