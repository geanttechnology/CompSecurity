// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Compose2BottomBarView extends LinearLayout
{

    ImageView im_background;
    ImageView im_link;
    ImageView im_mag;
    ImageView im_share;
    ImageView img_free_selector;
    ImageView img_link_selector;
    ImageView img_mag_selector;
    ImageView img_module_selector;
    TextView tx_bottom_bar_free;
    TextView tx_bottom_bar_link;
    TextView tx_bottom_bar_mag;
    TextView tx_bottom_bar_module;

    public Compose2BottomBarView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300aa, this, true);
        im_background = (ImageView)findViewById(0x7f0c0053);
        tx_bottom_bar_module = (TextView)findViewById(0x7f0c029e);
        im_share = (ImageView)findViewById(0x7f0c02ab);
        int i = getContext().getResources().getColor(0x7f0b0082);
        int j = getContext().getResources().getColor(0x7f0b0083);
        tx_bottom_bar_module.setTextColor(j);
        tx_bottom_bar_free.setTextColor(i);
        tx_bottom_bar_link.setTextColor(i);
        tx_bottom_bar_mag.setTextColor(i);
    }

    public void setModeludeStatus(boolean flag)
    {
        if (flag)
        {
            im_background.setImageResource(0x7f0201bf);
            int i = getContext().getResources().getColor(0x7f0b0083);
            tx_bottom_bar_module.setTextColor(i);
            return;
        } else
        {
            im_background.setImageResource(0x7f0201be);
            int j = getContext().getResources().getColor(0x7f0b0082);
            tx_bottom_bar_module.setTextColor(j);
            return;
        }
    }
}
