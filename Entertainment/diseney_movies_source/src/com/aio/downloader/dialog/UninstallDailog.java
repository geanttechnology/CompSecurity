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

public class UninstallDailog extends Dialog
{
    public static interface OnCustomDialogListener
    {

        public abstract void back(String s);
    }


    private String appname;
    private String appsize;
    private Button cleanercancel;
    private Button cleanerupdate;
    private Context ctx;
    private TextView descriptiontv;
    private android.view.View.OnClickListener itemsOnClick;

    public UninstallDailog(Context context, int i, android.view.View.OnClickListener onclicklistener, String s, String s1)
    {
        super(context, i);
        ctx = context;
        itemsOnClick = onclicklistener;
        appname = s;
        appsize = s1;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300b5);
        descriptiontv = (TextView)findViewById(0x7f070093);
        cleanercancel = (Button)findViewById(0x7f070090);
        cleanerupdate = (Button)findViewById(0x7f070092);
        cleanercancel.setOnClickListener(itemsOnClick);
        cleanerupdate.setOnClickListener(itemsOnClick);
        descriptiontv.setText(Html.fromHtml((new StringBuilder("<font color='#3261b4'> <b>")).append(appname).append("</b></font>  left <font color='#3261b4'><b>").append(appsize).append(" </b></font> residual files. \n Use ").append("<font color='#3261b4'> <b>AIO Cleaner").append("</b></font> to get rid of them!").toString()));
    }
}
