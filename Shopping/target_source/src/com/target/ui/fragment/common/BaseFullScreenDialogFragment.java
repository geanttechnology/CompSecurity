// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Window;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;

public class BaseFullScreenDialogFragment extends DialogFragment
    implements TraceFieldInterface
{

    public BaseFullScreenDialogFragment()
    {
    }

    protected boolean d()
    {
        return false;
    }

    protected boolean e()
    {
        return true;
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        int i;
        if (e())
        {
            i = 0x7f0c0090;
        } else
        {
            i = 0x7f0c0091;
        }
        bundle = new Dialog(getActivity(), i);
        bundle.requestWindowFeature(1);
        bundle.getWindow().getAttributes().horizontalMargin = 0.0F;
        bundle.getWindow().getAttributes().verticalMargin = 0.0F;
        bundle.getWindow().setGravity(119);
        return bundle;
    }

    public void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        if (!d())
        {
            return;
        } else
        {
            getDialog().getWindow().setLayout(-1, -1);
            return;
        }
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
