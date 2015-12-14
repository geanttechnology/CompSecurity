// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui;

import amp;
import amq;
import amr;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ProEidtMainActionBarView extends FrameLayout
{

    ImageView img_share;
    View layout_pre;
    View layout_share;
    public amr listener;

    public ProEidtMainActionBarView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03011b, this, true);
        img_share = (ImageView)findViewById(0x7f0d03b0);
        layout_share = findViewById(0x7f0d041a);
        layout_share.setOnClickListener(new amp(this));
        layout_pre = findViewById(0x7f0d018c);
        layout_pre.setOnClickListener(new amq(this));
    }

    public String getActionBarTitle()
    {
        return null;
    }

    public void hideShareButton()
    {
        layout_share.setVisibility(4);
    }

    public void isSharButtonEnable(boolean flag)
    {
        img_share.setEnabled(flag);
        layout_share.setEnabled(flag);
    }

    public void setOnActionBarItemListener(amr amr)
    {
        listener = amr;
    }
}
