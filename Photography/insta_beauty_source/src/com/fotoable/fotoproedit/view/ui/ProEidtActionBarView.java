// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui;

import amm;
import amn;
import amo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ProEidtActionBarView extends FrameLayout
{

    ImageView img_accept;
    public View layout_accept;
    View layout_pre;
    public amo listener;
    TextView tx_tip;

    public ProEidtActionBarView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030116, this, true);
        tx_tip = (TextView)findViewById(0x7f0d022e);
        img_accept = (ImageView)findViewById(0x7f0d03b0);
        layout_accept = findViewById(0x7f0d03af);
        layout_accept.getBackground().setColorFilter(getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.SRC_IN);
        layout_accept.setOnClickListener(new amm(this));
        layout_pre = findViewById(0x7f0d018c);
        layout_pre.getBackground().setColorFilter(getResources().getColor(0x7f0c00a6), android.graphics.PorterDuff.Mode.SRC_IN);
        layout_pre.setOnClickListener(new amn(this));
    }

    public String getActionBarTitle()
    {
        return null;
    }

    public void setActionBarTitle(String s)
    {
        tx_tip.setText(s);
    }

    public void setActionBarTitleTypeface(Typeface typeface)
    {
        tx_tip.setTypeface(typeface);
    }

    public void setBtnCanEnaable(boolean flag)
    {
        layout_accept.setEnabled(flag);
        layout_pre.setEnabled(flag);
    }

    public void setOnAcceptListener(amo amo)
    {
        listener = amo;
    }
}
