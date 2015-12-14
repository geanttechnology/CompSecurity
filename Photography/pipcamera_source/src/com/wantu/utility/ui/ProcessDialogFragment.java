// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.utility.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class ProcessDialogFragment extends DialogFragment
{

    public ProcessDialogFragment()
    {
    }

    public static ProcessDialogFragment a(String s)
    {
        ProcessDialogFragment processdialogfragment = new ProcessDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", s);
        processdialogfragment.setArguments(bundle);
        return processdialogfragment;
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = getArguments().getString("text");
        ProgressDialog progressdialog = new ProgressDialog(getActivity());
        progressdialog.setMessage(bundle);
        return progressdialog;
    }

    public int show(FragmentTransaction fragmenttransaction, String s)
    {
        return super.show(fragmenttransaction, s);
    }

    public void show(FragmentManager fragmentmanager, String s)
    {
        super.show(fragmentmanager, s);
    }
}
