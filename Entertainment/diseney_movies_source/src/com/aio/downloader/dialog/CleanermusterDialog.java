// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class CleanermusterDialog extends Dialog
{
    public static interface OnCustomDialogListener
    {

        public abstract void back(String s);
    }


    private Context ctx;
    private android.view.View.OnClickListener itemsOnClick;

    public CleanermusterDialog(Context context, int i, android.view.View.OnClickListener onclicklistener)
    {
        super(context, i);
        ctx = context;
        itemsOnClick = onclicklistener;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030024);
    }
}
