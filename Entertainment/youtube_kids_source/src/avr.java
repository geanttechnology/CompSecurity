// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

public final class avr extends DialogFragment
{

    private Dialog a;
    private android.content.DialogInterface.OnCancelListener b;

    public avr()
    {
        a = null;
        b = null;
    }

    public static avr a(Dialog dialog, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        avr avr1 = new avr();
        dialog = (Dialog)a.f(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        avr1.a = dialog;
        if (oncancellistener != null)
        {
            avr1.b = oncancellistener;
        }
        return avr1;
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        if (b != null)
        {
            b.onCancel(dialoginterface);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        if (a == null)
        {
            setShowsDialog(false);
        }
        return a;
    }

    public final void show(FragmentManager fragmentmanager, String s)
    {
        super.show(fragmentmanager, s);
    }
}
