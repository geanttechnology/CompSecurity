// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.internal.er;

public class b extends DialogFragment
{

    private Dialog mDialog;
    private android.content.DialogInterface.OnCancelListener yK;

    public b()
    {
        mDialog = null;
        yK = null;
    }

    public static b a(Dialog dialog, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        b b1 = new b();
        dialog = (Dialog)er.b(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        b1.mDialog = dialog;
        if (oncancellistener != null)
        {
            b1.yK = oncancellistener;
        }
        return b1;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        if (yK != null)
        {
            yK.onCancel(dialoginterface);
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
