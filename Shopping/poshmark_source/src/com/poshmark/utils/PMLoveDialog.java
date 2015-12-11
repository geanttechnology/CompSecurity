// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.poshmark.analytics.Analytics;
import com.poshmark.triggers.PMTrigger;

// Referenced classes of package com.poshmark.utils:
//            PMSendFeedbackAlert, PMAppRateDialog

public class PMLoveDialog extends DialogFragment
    implements TraceFieldInterface
{

    PMTrigger trigger;

    public PMLoveDialog(PMTrigger pmtrigger)
    {
        trigger = pmtrigger;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        trigger.setNewState(com.poshmark.triggers.PMTrigger.TriggerState.IGNORED);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        Object obj = new android.app.AlertDialog.Builder(getActivity());
        bundle = getActivity().getLayoutInflater().inflate(0x7f0300a3, null);
        ((android.app.AlertDialog.Builder) (obj)).setView(bundle);
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        Button button = (Button)bundle.findViewById(0x7f0c0268);
        bundle = (Button)bundle.findViewById(0x7f0c026a);
        if (button != null)
        {
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final PMLoveDialog this$0;

                public void onClick(View view)
                {
                    trigger.setNewState(com.poshmark.triggers.PMTrigger.TriggerState.DISMISSED);
                    dismiss();
                    (new PMSendFeedbackAlert()).show(getFragmentManager(), "feedbackAlert");
                    Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_love_alert_no_button_tapped", null);
                    Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_rating_send_feedback_alert_displayed", null);
                }

            
            {
                this$0 = PMLoveDialog.this;
                super();
            }
            });
        }
        if (bundle != null)
        {
            bundle.setOnClickListener(new android.view.View.OnClickListener() {

                final PMLoveDialog this$0;

                public void onClick(View view)
                {
                    (new PMAppRateDialog(trigger)).show(getFragmentManager(), "appRateDlg");
                    dismiss();
                    Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_love_alert_yes_button_tapped", null);
                }

            
            {
                this$0 = PMLoveDialog.this;
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
