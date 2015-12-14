// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.utils.ResourceManager;

public class SelectCountryTitleView extends RelativeLayout
{

    private TextView mTitleTv;

    public SelectCountryTitleView(Context context)
    {
        super(context);
        initView();
    }

    private void initView()
    {
        setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, ResourceManager.dp2px(getContext(), 24)));
        setBackgroundDrawable(ResourceManager.getDrawable(getContext(), "tableview_sectionheader_background.png"));
        mTitleTv = new TextView(getContext());
        mTitleTv.setTextSize(14F);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(15);
        layoutparams.leftMargin = ResourceManager.dp2px(getContext(), 10);
        mTitleTv.setLayoutParams(layoutparams);
        mTitleTv.setGravity(3);
        mTitleTv.setTextColor(0xff929292);
        mTitleTv.setGravity(16);
        addView(mTitleTv);
    }

    public void setTitle(String s)
    {
        mTitleTv.setText(s);
    }

    public void update(String s)
    {
        setTitle(s);
    }
}
