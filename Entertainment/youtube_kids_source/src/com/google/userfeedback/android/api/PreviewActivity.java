// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedback, UserFeedbackSpec, UiConfigurationOptions, UserFeedbackReportAdapter

public class PreviewActivity extends ListActivity
{

    private UserFeedbackReportAdapter mAdapter;
    private Button mGoBack;
    private Button mSubmitFeedback;

    public PreviewActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.gf_preview_activity);
        bundle = UserFeedback.userFeedback().getSpec().getUiConfigurationOptions();
        if (bundle != null && bundle.getBackgroundColor() != 0)
        {
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(bundle.getBackgroundColor()));
        }
        mSubmitFeedback = (Button)findViewById(R.id.gf_send_from_preview);
        mSubmitFeedback.setOnClickListener(new _cls1());
        mGoBack = (Button)findViewById(R.id.gf_back);
        mGoBack.setOnClickListener(new _cls2());
        bundle = UserFeedback.userFeedback();
        if (bundle == null)
        {
            finish();
            return;
        }
        bundle = bundle.getReport();
        if (bundle == null)
        {
            finish();
            return;
        }
        try
        {
            mAdapter = new UserFeedbackReportAdapter(this, bundle);
            setListAdapter(mAdapter);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return;
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        UserFeedback.flushBitmapsOnDestroy(this);
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        super.onListItemClick(listview, view, i, l);
        mAdapter.onListItemClick(i);
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final PreviewActivity this$0;
        final Activity val$thisActivity;

        public void onClick(View view)
        {
            view = UserFeedback.userFeedback();
            Dialog dialog = view.createDialog(thisActivity, view.shouldIncludeScreenshot(), view.shouldIncludeSystemLogs(), view.getFeedbackText());
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

        _cls1()
        {
            this$0 = PreviewActivity.this;
            thisActivity = activity;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final PreviewActivity this$0;

        public void onClick(View view)
        {
            setResult(0);
            finish();
        }

        _cls2()
        {
            this$0 = PreviewActivity.this;
            super();
        }
    }

}
