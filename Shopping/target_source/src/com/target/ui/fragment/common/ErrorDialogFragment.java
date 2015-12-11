// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.target.mothership.util.o;
import com.target.ui.util.al;

public class ErrorDialogFragment extends DialogFragment
    implements android.view.View.OnClickListener, TraceFieldInterface
{

    private static final String KEY_ERROR_MSG = "keyErrorMessage";
    private static final String KEY_ERROR_TITLE = "keyErrorTitle";
    public static final String TAG = com/target/ui/fragment/common/ErrorDialogFragment.getSimpleName();

    public ErrorDialogFragment()
    {
    }

    public static ErrorDialogFragment a(String s)
    {
        return a(null, s);
    }

    public static ErrorDialogFragment a(String s, String s1)
    {
        ErrorDialogFragment errordialogfragment = new ErrorDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("keyErrorTitle", s);
        bundle.putString("keyErrorMessage", s1);
        errordialogfragment.setArguments(bundle);
        return errordialogfragment;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755390: 
            dismiss();
            break;
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = getActivity();
        View view = getActivity().getLayoutInflater().inflate(0x7f03005c, null);
        String s = getArguments().getString("keyErrorTitle");
        TextView textview = (TextView)view.findViewById(0x7f10017c);
        if (o.g(s))
        {
            al.a(textview, s);
        } else
        {
            al.c(textview);
        }
        s = getArguments().getString("keyErrorMessage");
        ((TextView)view.findViewById(0x7f10017d)).setText(s);
        view.findViewById(0x7f10017e).setOnClickListener(this);
        return (new android.app.AlertDialog.Builder(bundle)).setView(view).create();
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
