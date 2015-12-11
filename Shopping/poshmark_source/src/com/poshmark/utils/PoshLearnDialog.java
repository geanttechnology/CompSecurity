// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.poshmark.controllers.GlobalPartiesController;

// Referenced classes of package com.poshmark.utils:
//            ViewUtils

public class PoshLearnDialog extends DialogFragment
    implements TraceFieldInterface
{

    public PoshLearnDialog()
    {
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        GlobalPartiesController.getGlobalPartiesController().enablePartyAlerts();
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new android.app.AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(0x7f0300a4, null);
        ((Button)view.findViewById(0x7f0c026e)).setOnClickListener(new android.view.View.OnClickListener() {

            final PoshLearnDialog this$0;

            public void onClick(View view1)
            {
                GlobalPartiesController.getGlobalPartiesController().enablePartyAlerts();
                dismiss();
            }

            
            {
                this$0 = PoshLearnDialog.this;
                super();
            }
        });
        bundle.setView(view);
        return bundle.create();
    }

    public void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        if (getDialog() == null)
        {
            return;
        } else
        {
            Display display = ((WindowManager)getActivity().getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int i = point.x;
            int j = (int)ViewUtils.dipToPixels(getActivity(), 15F);
            int k = point.y;
            int l = (int)ViewUtils.dipToPixels(getActivity(), 120F);
            getDialog().getWindow().setLayout(i - j, k - l);
            return;
        }
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
