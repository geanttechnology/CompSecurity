// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

public class ErrorDialogFragment extends DialogFragment
{

    private android.content.DialogInterface.OnCancelListener mCancelListener;
    private Dialog mDialog;

    public ErrorDialogFragment()
    {
    }

    public static ErrorDialogFragment newInstance(Dialog dialog)
    {
        return newInstance(dialog, null);
    }

    public static ErrorDialogFragment newInstance(Dialog dialog, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        ErrorDialogFragment errordialogfragment = new ErrorDialogFragment();
        errordialogfragment.mDialog = dialog;
        errordialogfragment.mCancelListener = oncancellistener;
        errordialogfragment.setRetainInstance(true);
        return errordialogfragment;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        if (mCancelListener != null)
        {
            mCancelListener.onCancel(dialoginterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        return mDialog;
    }

    public void show(FragmentManager fragmentmanager, String s)
    {
        super.show(fragmentmanager, s);
    }
}
