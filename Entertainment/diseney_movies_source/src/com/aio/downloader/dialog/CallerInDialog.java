// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

public class CallerInDialog extends Dialog
{

    private Context ctx;
    private Button gallery_cancel;
    private android.view.View.OnClickListener itemsOnClick;
    private RelativeLayout rl_gallery_ok;

    public CallerInDialog(Context context, int i, android.view.View.OnClickListener onclicklistener)
    {
        super(context, i);
        ctx = context;
        itemsOnClick = onclicklistener;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030021);
        gallery_cancel = (Button)findViewById(0x7f070133);
        rl_gallery_ok = (RelativeLayout)findViewById(0x7f070134);
        gallery_cancel.setOnClickListener(itemsOnClick);
        rl_gallery_ok.setOnClickListener(itemsOnClick);
    }
}
