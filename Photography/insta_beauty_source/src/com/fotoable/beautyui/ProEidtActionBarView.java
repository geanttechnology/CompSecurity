// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fotoable.beautyui.newui.MNewCanSelButton;
import kd;
import ke;
import kf;
import kg;
import kh;

public class ProEidtActionBarView extends FrameLayout
{

    TextView label_title;
    Button layout_accept;
    ImageView layout_pre;
    public kh listener;
    MNewCanSelButton mBtnRedo;
    MNewCanSelButton mBtnUndo;

    public ProEidtActionBarView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300ea, this, true);
        layout_accept = (Button)findViewById(0x7f0d0384);
        layout_accept.setOnClickListener(new kd(this));
        layout_pre = (ImageView)findViewById(0x7f0d018c);
        layout_pre.setOnClickListener(new ke(this));
        mBtnRedo = (MNewCanSelButton)findViewById(0x7f0d0382);
        mBtnRedo.setOnClickListener(new kf(this));
        mBtnUndo = (MNewCanSelButton)findViewById(0x7f0d0381);
        mBtnUndo.setOnClickListener(new kg(this));
        mBtnUndo.setSelectedColor(getResources().getColor(0x7f0c002b), getResources().getColor(0x7f0c002d));
        mBtnRedo.setSelectedColor(getResources().getColor(0x7f0c002b), getResources().getColor(0x7f0c002d));
        mBtnUndo.setEnabled(false);
        mBtnRedo.setEnabled(false);
        label_title = (TextView)findViewById(0x7f0d0383);
        label_title.setVisibility(0);
    }

    public String getActionBarTitle()
    {
        return null;
    }

    public void setOnAcceptListener(kh kh)
    {
        listener = kh;
    }

    public void setTitle(String s)
    {
        label_title.setVisibility(0);
        label_title.setText(s);
    }

    public void updateBackState(boolean flag, boolean flag1)
    {
        mBtnRedo.setEnabled(flag);
        mBtnUndo.setEnabled(flag1);
    }
}
