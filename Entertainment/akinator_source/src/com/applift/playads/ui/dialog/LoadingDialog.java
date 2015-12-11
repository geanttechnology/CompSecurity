// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applift.playads.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import com.applift.playads.util.Res;

public class LoadingDialog extends Dialog
{

    private static int layoutId;

    public LoadingDialog(Context context, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        int i;
        boolean flag;
        if (oncancellistener != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        super(context, flag, oncancellistener);
        requestWindowFeature(1);
        if (layoutId > 0)
        {
            i = layoutId;
        } else
        {
            i = Res.layoutId(context, "al_dialog_loading");
        }
        setContentView(i);
        setCanceledOnTouchOutside(false);
    }

    public static void setLayoutId(int i)
    {
        layoutId = i;
    }
}
