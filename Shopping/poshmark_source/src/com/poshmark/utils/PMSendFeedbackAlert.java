// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.poshmark.analytics.Analytics;

public class PMSendFeedbackAlert extends DialogFragment
    implements TraceFieldInterface
{

    public PMSendFeedbackAlert()
    {
    }

    public void onCancel(DialogInterface dialoginterface)
    {
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        Object obj = new android.app.AlertDialog.Builder(getActivity());
        bundle = getActivity().getLayoutInflater().inflate(0x7f0300b1, null);
        ((android.app.AlertDialog.Builder) (obj)).setView(bundle);
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        Button button = (Button)bundle.findViewById(0x7f0c029e);
        bundle = (Button)bundle.findViewById(0x7f0c029f);
        if (button != null)
        {
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final PMSendFeedbackAlert this$0;

                public void onClick(View view)
                {
                    dismiss();
                    Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_rating_send_feedback_dismissed", null);
                }

            
            {
                this$0 = PMSendFeedbackAlert.this;
                super();
            }
            });
        }
        if (bundle != null)
        {
            bundle.setOnClickListener(new android.view.View.OnClickListener() {

                final PMSendFeedbackAlert this$0;

                public void onClick(View view)
                {
                    dismiss();
                    view = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "support@poshmark.com", null));
                    startActivity(view);
                    Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_rating_send_feedback", null);
                }

            
            {
                this$0 = PMSendFeedbackAlert.this;
                super();
            }
            });
        }
        return ((Dialog) (obj));
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
