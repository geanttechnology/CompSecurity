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
import android.widget.EditText;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.EnvConfig;

public class PMSetIPDialog extends DialogFragment
    implements TraceFieldInterface
{

    View dialoglayout;

    public PMSetIPDialog()
    {
    }

    public void onCancel(DialogInterface dialoginterface)
    {
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new android.app.AlertDialog.Builder(getActivity());
        dialoglayout = getActivity().getLayoutInflater().inflate(0x7f0300b2, null);
        bundle.setView(dialoglayout);
        bundle = bundle.create();
        Button button = (Button)dialoglayout.findViewById(0x7f0c02a4);
        if (button != null)
        {
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final PMSetIPDialog this$0;

                public void onClick(View view)
                {
                    Object obj = (EditText)dialoglayout.findViewById(0x7f0c02a0);
                    Object obj2 = (EditText)dialoglayout.findViewById(0x7f0c02a1);
                    Object obj1 = (EditText)dialoglayout.findViewById(0x7f0c02a2);
                    view = (EditText)dialoglayout.findViewById(0x7f0c02a3);
                    obj = ((EditText) (obj)).getText().toString();
                    obj2 = ((EditText) (obj2)).getText().toString();
                    obj1 = ((EditText) (obj1)).getText().toString();
                    view = view.getText().toString();
                    if (obj != null && obj2 != null && obj1 != null)
                    {
                        view = (new StringBuilder()).append("http://").append(((String) (obj))).append(".").append(((String) (obj2))).append(".").append(((String) (obj1))).append(".").append(view).append(":9292").toString();
                        EnvConfig.setupDevIP(view);
                        PMApplicationSession.GetPMSession().setDevIP(view);
                        dismiss();
                    }
                }

            
            {
                this$0 = PMSetIPDialog.this;
                super();
            }
            });
        }
        return bundle;
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
