// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import boe;
import bof;
import bog;

public class BackPathActionBarView extends FrameLayout
{

    public bog backTopLayerListener;
    Button cancel;
    Button layout_pre;
    private Context mContext;
    TextView tx_tip;

    public BackPathActionBarView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = context;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030068, this, true);
        initView();
    }

    public void initView()
    {
        tx_tip = (TextView)findViewById(0x7f0d022e);
        layout_pre = (Button)findViewById(0x7f0d018c);
        cancel = (Button)findViewById(0x7f0d022f);
        layout_pre.setOnClickListener(new boe(this));
        cancel.setOnClickListener(new bof(this));
    }

    public void saveButtomIsShow(boolean flag)
    {
        if (!flag)
        {
            tx_tip.setVisibility(4);
            cancel.setVisibility(4);
            layout_pre.setVisibility(0);
            return;
        } else
        {
            tx_tip.setVisibility(0);
            cancel.setVisibility(0);
            layout_pre.setVisibility(0);
            return;
        }
    }

    public void setBackTopLayerListener(bog bog)
    {
        backTopLayerListener = bog;
    }

    public void setTextViewText(String s)
    {
        tx_tip.setText(s);
    }
}
