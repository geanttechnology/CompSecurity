// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.f;
import android.support.v4.app.i;
import com.google.android.gms.common.internal.x;

public class e extends f
{

    private Dialog aj;
    private android.content.DialogInterface.OnCancelListener ak;

    public e()
    {
        aj = null;
        ak = null;
    }

    public static e a(Dialog dialog, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        e e1 = new e();
        dialog = (Dialog)x.a(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        e1.aj = dialog;
        if (oncancellistener != null)
        {
            e1.ak = oncancellistener;
        }
        return e1;
    }

    public void a(i i, String s)
    {
        super.a(i, s);
    }

    public Dialog c(Bundle bundle)
    {
        if (aj == null)
        {
            b(false);
        }
        return aj;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        if (ak != null)
        {
            ak.onCancel(dialoginterface);
        }
    }
}
