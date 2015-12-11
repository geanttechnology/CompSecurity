// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ConfirmationDialogFragment extends DialogFragment
    implements android.content.DialogInterface.OnClickListener
{
    public static interface ConfirmationDialogFragmentListener
    {

        public abstract void onNegativeClick();

        public abstract void onPositiveClick();
    }


    private static final String MESSAGE = "message";
    private static final String TITLE = "title";
    ConfirmationDialogFragmentListener mListener;

    public ConfirmationDialogFragment()
    {
    }

    public static ConfirmationDialogFragment newInstance(int i, int j)
    {
        ConfirmationDialogFragment confirmationdialogfragment = new ConfirmationDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("title", i);
        bundle.putInt("message", j);
        confirmationdialogfragment.setArguments(bundle);
        return confirmationdialogfragment;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        switch (i)
        {
        default:
            mListener.onNegativeClick();
            return;

        case -1: 
            mListener.onPositiveClick();
            break;
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        int i = getArguments().getInt("title");
        int j = getArguments().getInt("message");
        return (new android.app.AlertDialog.Builder(getActivity())).setTitle(i).setMessage(j).setPositiveButton(getResources().getString(0x7f0b00ce), this).setNegativeButton(getResources().getString(0x7f0b0100), this).create();
    }

    public void setOnConfirmationDialogClickListener(ConfirmationDialogFragmentListener confirmationdialogfragmentlistener)
    {
        mListener = confirmationdialogfragmentlistener;
    }
}
