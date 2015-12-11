// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.views.RoundImageView;

public class AnzhuangDialog extends Dialog
{
    public static interface OnCustomDialogListener
    {

        public abstract void back(String s);
    }


    private String appid;
    private String appname;
    private String appsize;
    private Button cleanercancel;
    private RelativeLayout cleanerupdate;
    private Context ctx;
    private TextView descriptiontv;
    private android.view.View.OnClickListener itemsOnClick;
    private RoundImageView iv_icon_ins;
    PackageInfo pI;
    private TextView tv_install_appname;

    public AnzhuangDialog(Context context, int i, android.view.View.OnClickListener onclicklistener, String s, String s1, String s2)
    {
        super(context, i);
        pI = null;
        ctx = context;
        itemsOnClick = onclicklistener;
        appname = s;
        appid = s1;
        appsize = s2;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030010);
        iv_icon_ins = (RoundImageView)findViewById(0x7f070095);
        pI = ctx.getPackageManager().getPackageInfo(appid, 0);
_L1:
        bundle = pI.applicationInfo.loadIcon(ctx.getPackageManager());
        iv_icon_ins.setBackgroundDrawable(bundle);
_L2:
        descriptiontv = (TextView)findViewById(0x7f070093);
        tv_install_appname = (TextView)findViewById(0x7f070094);
        tv_install_appname.setText(Html.fromHtml((new StringBuilder("<font color='#3463B4'>")).append(appname).append("</font> just installed!").toString()));
        descriptiontv.setText(Html.fromHtml((new StringBuilder("You can delete its unneeded apk file to save <font color='#3261b4'><b>")).append(appsize).append(".</b></font>").toString()));
        cleanercancel = (Button)findViewById(0x7f070090);
        cleanerupdate = (RelativeLayout)findViewById(0x7f070096);
        cleanercancel.setOnClickListener(itemsOnClick);
        cleanerupdate.setOnClickListener(itemsOnClick);
        return;
        bundle;
        bundle.printStackTrace();
          goto _L1
        bundle;
          goto _L2
    }
}
