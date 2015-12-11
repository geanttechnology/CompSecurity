// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;

public class InstallfirstDialog extends Dialog
{
    public static interface OnCustomDialogListener
    {

        public abstract void back(String s);
    }


    private Button bt_firstcleaner_cancel;
    private Button bt_firstcleaner_ok;
    private Context ctx;
    private TextView descriptiontv;
    private TextView installf_tv;
    private android.view.View.OnClickListener itemsOnClick;

    public InstallfirstDialog(Context context, int i, android.view.View.OnClickListener onclicklistener)
    {
        super(context, i);
        ctx = context;
        itemsOnClick = onclicklistener;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030028);
        descriptiontv = (TextView)findViewById(0x7f07014b);
        bt_firstcleaner_cancel = (Button)findViewById(0x7f07014c);
        bt_firstcleaner_ok = (Button)findViewById(0x7f07014d);
        descriptiontv.setText(Html.fromHtml("<font color='#3C55C3'>All-In-One Downloader</font> installed, you can delete its unneeded apk file to save<font color='#3C55C3'> 6.6MB</font>."));
        bt_firstcleaner_cancel.setOnClickListener(itemsOnClick);
        bt_firstcleaner_ok.setOnClickListener(itemsOnClick);
    }
}
