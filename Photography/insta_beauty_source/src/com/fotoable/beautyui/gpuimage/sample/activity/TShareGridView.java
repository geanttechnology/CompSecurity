// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.GridView;
import bqx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import qy;

public class TShareGridView extends GridView
{

    private static String mItemImg = "itemImage";
    private static String mItemTag = "itemTag";
    private static String mItemTxt = "itemTxt";
    private qy mAdapter;
    private bqx mCallback;
    private Context mContext;
    private ArrayList shareItemInfo;

    public TShareGridView(Context context)
    {
        super(context);
        mContext = context;
        setNumColumns(4);
        setVerticalSpacing(0);
        setHorizontalSpacing(0);
        shareItemInfo = new ArrayList();
        init();
        mAdapter = new qy(this, shareItemInfo);
        setAdapter(mAdapter);
    }

    public TShareGridView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = context;
        setNumColumns(4);
        setVerticalSpacing(0);
        setHorizontalSpacing(0);
        shareItemInfo = new ArrayList();
        init();
        mAdapter = new qy(this, shareItemInfo);
        setAdapter(mAdapter);
    }

    private void addItemInfo(String s, String s1, int i)
    {
        HashMap hashmap = new HashMap();
        String s2;
        if (i == 0)
        {
            s2 = "";
        } else
        {
            s2 = getContext().getResources().getString(i);
        }
        hashmap.put(mItemImg, s);
        hashmap.put(mItemTag, s1);
        hashmap.put(mItemTxt, s2);
        shareItemInfo.add(hashmap);
    }

    private void init()
    {
        if (Locale.getDefault().getLanguage().compareTo("zh") == 0)
        {
            addItemInfo(String.valueOf(0x1080052), "sync_more", 0x7f060245);
            addItemInfo(String.valueOf(0x7f02042c), "sync_wechat", 0x7f060253);
            addItemInfo(String.valueOf(0x7f020413), "sync_moment", 0x7f060244);
            addItemInfo(String.valueOf(0x7f020424), "sync_sina", 0x7f060249);
            addItemInfo(String.valueOf(0x7f02041c), "sync_qq", 0x7f060246);
            addItemInfo(String.valueOf(0x7f020420), "sync_qqzone", 0x7f060248);
            addItemInfo(String.valueOf(0x7f02041e), "sync_qqweibo", 0x7f060247);
            addItemInfo(String.valueOf(0x7f02040f), "sync_instagram", 0x7f060243);
            addItemInfo(String.valueOf(0x7f02040d), "sync_facebook", 0x7f060241);
            addItemInfo(String.valueOf(0x7f02042a), "sync_twitter", 0x7f060252);
            addItemInfo(String.valueOf(0x7f020428), "sync_tumblr", 0x7f060251);
            addItemInfo("0", "", 0);
        } else
        if (Locale.getDefault().getLanguage().compareTo("en") == 0)
        {
            addItemInfo(String.valueOf(0x1080052), "sync_more", 0x7f060245);
            addItemInfo(String.valueOf(0x7f02040f), "sync_instagram", 0x7f060243);
            addItemInfo(String.valueOf(0x7f02040d), "sync_facebook", 0x7f060241);
            addItemInfo(String.valueOf(0x7f02042a), "sync_twitter", 0x7f060252);
            addItemInfo(String.valueOf(0x7f020428), "sync_tumblr", 0x7f060251);
            addItemInfo(String.valueOf(0x7f02042c), "sync_wechat", 0x7f060253);
            addItemInfo(String.valueOf(0x7f020413), "sync_moment", 0x7f060244);
            addItemInfo(String.valueOf(0x7f020424), "sync_sina", 0x7f060249);
            addItemInfo(String.valueOf(0x7f02041c), "sync_qq", 0x7f060246);
            addItemInfo(String.valueOf(0x7f020420), "sync_qqzone", 0x7f060248);
            addItemInfo(String.valueOf(0x7f02041e), "sync_qqweibo", 0x7f060247);
            addItemInfo("0", "", 0);
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(0x1fffffff, 0x80000000));
    }

    public void setCallback(bqx bqx)
    {
        mCallback = bqx;
    }






}
