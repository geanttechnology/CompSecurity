// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event.util;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;

// Referenced classes of package de.greenrobot.event.util:
//            ErrorDialogFragments

public static class Monitor extends DialogFragment
    implements android.content.er, TraceFieldInterface
{

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ErrorDialogFragments.handleOnClick(dialoginterface, i, getActivity(), getArguments());
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
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

    public Monitor()
    {
    }
}
