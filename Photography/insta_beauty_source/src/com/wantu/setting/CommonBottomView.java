// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import boh;
import bok;
import java.util.Locale;

public class CommonBottomView extends FrameLayout
{

    public Context mContext;
    FrameLayout new_create_folder;
    TextView new_create_folder_tv;
    public bok onClickNewCreateFolderListener;

    public CommonBottomView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = context;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300a9, this, true);
        initView();
        initFontSize();
    }

    public void initFontSize()
    {
        if (Locale.getDefault().getLanguage().compareTo("zh") != 0)
        {
            new_create_folder_tv.setTextSize(20F);
        }
    }

    public void initView()
    {
        new_create_folder = (FrameLayout)findViewById(0x7f0d02c1);
        new_create_folder_tv = (TextView)findViewById(0x7f0d02c2);
        new_create_folder.setOnClickListener(new boh(this));
    }

    public void setOnClickCreateFolderListener(bok bok)
    {
        onClickNewCreateFolderListener = bok;
    }
}
