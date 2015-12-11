// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

public final class avx extends i
{

    private Dialog W;
    private android.content.DialogInterface.OnCancelListener X;

    public avx()
    {
        W = null;
        X = null;
    }

    public static avx a(Dialog dialog, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        avx avx1 = new avx();
        dialog = (Dialog)a.f(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        avx1.W = dialog;
        if (oncancellistener != null)
        {
            avx1.X = oncancellistener;
        }
        return avx1;
    }

    public final void a(r r, String s)
    {
        super.a(r, s);
    }

    public final Dialog c(Bundle bundle)
    {
        if (W == null)
        {
            super.a = false;
        }
        return W;
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        if (X != null)
        {
            X.onCancel(dialoginterface);
        }
    }
}
