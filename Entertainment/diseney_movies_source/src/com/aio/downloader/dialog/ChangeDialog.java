// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ChangeDialog extends Dialog
{
    public static interface OnCustomDialogListener
    {

        public abstract void back(String s);
    }


    private Button changecancel;
    private Context ctx;
    private TextView descriptiontv_change;
    private String fenzhong;
    private android.view.View.OnClickListener itemsOnClick;
    private int level;
    private RelativeLayout rl_change_ok;
    private TextView tv_change_appname;
    private String xiaoshi;

    public ChangeDialog(Context context, int i, android.view.View.OnClickListener onclicklistener, String s, String s1, int j)
    {
        super(context, i);
        ctx = context;
        itemsOnClick = onclicklistener;
        xiaoshi = s;
        fenzhong = s1;
        level = j;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030023);
        changecancel = (Button)findViewById(0x7f070138);
        rl_change_ok = (RelativeLayout)findViewById(0x7f070139);
        tv_change_appname = (TextView)findViewById(0x7f070136);
        descriptiontv_change = (TextView)findViewById(0x7f070137);
        descriptiontv_change.setText(Html.fromHtml("Extend your battery life up to <font color='#3463B4'><b>50%</b></font> using Battery Saver!"));
        if (level == 100)
        {
            tv_change_appname.setText("Full Charge");
        } else
        {
            tv_change_appname.setText(Html.fromHtml((new StringBuilder("Full Charge Left <font color='#3463B4'><b>")).append(xiaoshi).append("</b></font> H <font color='#3463B4'><b>").append(fenzhong).append("</b></font> Min").toString()));
        }
        changecancel.setOnClickListener(itemsOnClick);
        rl_change_ok.setOnClickListener(itemsOnClick);
    }
}
