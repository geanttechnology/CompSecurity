// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CallerOutDialog extends Dialog
{

    private Context ctx;
    private ImageView gallery_cancel;
    private android.view.View.OnClickListener itemsOnClick;
    private String number;
    private Button rl_gallery_ok;
    private TextView tv_number_caller;

    public CallerOutDialog(Context context, int i, android.view.View.OnClickListener onclicklistener, String s)
    {
        super(context, i);
        ctx = context;
        itemsOnClick = onclicklistener;
        number = s;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03009d);
        gallery_cancel = (ImageView)findViewById(0x7f070368);
        rl_gallery_ok = (Button)findViewById(0x7f07036b);
        tv_number_caller = (TextView)findViewById(0x7f07036a);
        tv_number_caller.setText(number);
        gallery_cancel.setOnClickListener(itemsOnClick);
        rl_gallery_ok.setOnClickListener(itemsOnClick);
    }
}
