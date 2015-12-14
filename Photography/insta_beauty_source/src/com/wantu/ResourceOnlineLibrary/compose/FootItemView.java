// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import bha;
import bhb;

public class FootItemView extends LinearLayout
{

    private static final String TAG = "FootItemView";
    private Button btnMore;
    private Context mContext;
    private bhb mLisener;

    public FootItemView(Context context)
    {
        super(context);
        mContext = context;
        btnMore = (Button)((ViewGroup)View.inflate(getContext(), 0x7f030058, this)).findViewById(0x7f0d01f1);
        btnMore.setOnClickListener(new bha(this));
    }

    public void setFootViewItemLisener(bhb bhb)
    {
        mLisener = bhb;
    }

}
