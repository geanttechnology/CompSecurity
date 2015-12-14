// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component.view;

import android.app.Dialog;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sina.weibo.sdk.utils.ResourceManager;

public class AppProgressDialog extends Dialog
{

    private TextView info;
    private ProgressBar myBar;

    public AppProgressDialog(Context context)
    {
        super(context);
        setCanceledOnTouchOutside(false);
        LinearLayout linearlayout = new LinearLayout(context);
        linearlayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(ResourceManager.dp2px(context, 100), ResourceManager.dp2px(context, 100)));
        linearlayout.setOrientation(0);
        linearlayout.setGravity(17);
        linearlayout.setBackgroundColor(-1);
        myBar = new ProgressBar(context);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        int i = ResourceManager.dp2px(context, 20);
        layoutparams.bottomMargin = i;
        layoutparams.topMargin = i;
        layoutparams.leftMargin = i;
        myBar.setLayoutParams(layoutparams);
        linearlayout.addView(myBar);
        info = new TextView(context);
        setTitle("\u63D0\u793A");
        info.setTextSize(2, 17F);
        info.setText("\u6B63\u5728\u5904\u7406...");
        info.setTextColor(0xff525252);
        info.setGravity(16);
        layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams.leftMargin = ResourceManager.dp2px(context, 20);
        layoutparams.rightMargin = ResourceManager.dp2px(context, 20);
        info.setLayoutParams(layoutparams);
        linearlayout.addView(info);
        setContentView(linearlayout);
    }

    public void setMessage(String s)
    {
        info.setText(s);
    }
}
