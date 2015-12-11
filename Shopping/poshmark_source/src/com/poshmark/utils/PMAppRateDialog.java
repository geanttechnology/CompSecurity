// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.poshmark.analytics.Analytics;
import com.poshmark.triggers.PMTrigger;
import com.poshmark.ui.customviews.PMButton;

public class PMAppRateDialog extends DialogFragment
    implements TraceFieldInterface
{

    PMTrigger trigger;

    public PMAppRateDialog(PMTrigger pmtrigger)
    {
        trigger = pmtrigger;
    }

    private void launchPlayStore()
    {
        String s = getActivity().getPackageName();
        try
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(s).toString())));
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(s).toString())));
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        trigger.setNewState(com.poshmark.triggers.PMTrigger.TriggerState.IGNORED);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        Object obj = new android.app.AlertDialog.Builder(getActivity());
        bundle = getActivity().getLayoutInflater().inflate(0x7f03000f, null);
        ((android.app.AlertDialog.Builder) (obj)).setView(bundle);
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        PMButton pmbutton = (PMButton)bundle.findViewById(0x7f0c005d);
        PMButton pmbutton1 = (PMButton)bundle.findViewById(0x7f0c005e);
        bundle = (PMButton)bundle.findViewById(0x7f0c005f);
        if (pmbutton != null)
        {
            pmbutton.setOnClickListener(new android.view.View.OnClickListener() {

                final PMAppRateDialog this$0;

                public void onClick(View view)
                {
                    trigger.setNewState(com.poshmark.triggers.PMTrigger.TriggerState.INTERACTED);
                    launchPlayStore();
                    dismiss();
                    Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_rating_alert_rate_button_tapped", null);
                }

            
            {
                this$0 = PMAppRateDialog.this;
                super();
            }
            });
        }
        if (pmbutton1 != null)
        {
            pmbutton1.setOnClickListener(new android.view.View.OnClickListener() {

                final PMAppRateDialog this$0;

                public void onClick(View view)
                {
                    trigger.setNewState(com.poshmark.triggers.PMTrigger.TriggerState.IGNORED);
                    dismiss();
                    Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_rating_alert_remind_later_button_tapped", null);
                }

            
            {
                this$0 = PMAppRateDialog.this;
                super();
            }
            });
        }
        if (bundle != null)
        {
            bundle.setOnClickListener(new android.view.View.OnClickListener() {

                final PMAppRateDialog this$0;

                public void onClick(View view)
                {
                    trigger.setNewState(com.poshmark.triggers.PMTrigger.TriggerState.DISMISSED);
                    dismiss();
                    Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_rating_alert_dismiss_button_tapped", null);
                }

            
            {
                this$0 = PMAppRateDialog.this;
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
