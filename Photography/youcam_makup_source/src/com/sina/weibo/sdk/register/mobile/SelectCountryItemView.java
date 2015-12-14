// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.utils.ResourceManager;

public class SelectCountryItemView extends RelativeLayout
{

    private TextView mCountryCode;
    private TextView mCountryName;

    public SelectCountryItemView(Context context, String s, String s1)
    {
        super(context);
        initView(s, s1);
    }

    private void initView(String s, String s1)
    {
        setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, ResourceManager.dp2px(getContext(), 40)));
        mCountryName = new TextView(getContext());
        mCountryName.setTextSize(16F);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.leftMargin = ResourceManager.dp2px(getContext(), 15);
        layoutparams.addRule(9);
        layoutparams.addRule(15);
        mCountryName.setGravity(16);
        mCountryName.setLayoutParams(layoutparams);
        mCountryName.setText(s);
        mCountryName.setTextColor(0xff333333);
        addView(mCountryName);
        mCountryCode = new TextView(getContext());
        mCountryCode.setTextSize(16F);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(15);
        layoutparams.addRule(11);
        layoutparams.rightMargin = ResourceManager.dp2px(getContext(), 40);
        mCountryCode.setLayoutParams(layoutparams);
        mCountryCode.setText(s1);
        mCountryCode.setTextColor(0xff507daf);
        mCountryCode.setGravity(16);
        addView(mCountryCode);
        setContent(s, s1);
    }

    private void setContent(String s, String s1)
    {
        mCountryName.setText(s);
        mCountryCode.setText(s1);
    }

    public void updateContent(String s, String s1)
    {
        setContent(s, s1);
    }
}
