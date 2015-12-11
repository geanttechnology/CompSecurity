// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.PartyFragment;

public class PartyAlert
{

    public PartyAlert()
    {
    }

    private static void showAlert(PMActivity pmactivity, Bundle bundle, String s)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(pmactivity);
        builder.setTitle("Party is ON!");
        builder.setMessage((new StringBuilder()).append(s).append(" is happening now!").toString()).setCancelable(false).setPositiveButton("Join?", new android.content.DialogInterface.OnClickListener(pmactivity, bundle) {

            final Bundle val$bundle;
            final PMActivity val$topActivity;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Analytics.getInstance().trackEvent(null, "party", "join_party_notification_clicked", null);
                topActivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/PartyFragment, null);
            }

            
            {
                topActivity = pmactivity;
                bundle = bundle1;
                super();
            }
        }).setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

        });
        builder.create().show();
    }

    public static void showPartyAlert(Bundle bundle)
    {
        String s = bundle.getString("PARTY_TITLE");
        PMActivity pmactivity = PMApplication.getApplicationObject().getTopActivity();
        if (pmactivity != null && pmactivity.isActivityInForeground())
        {
            showAlert(pmactivity, bundle, s);
        }
    }
}
