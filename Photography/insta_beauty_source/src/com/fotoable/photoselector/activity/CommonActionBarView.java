// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.activity;

import aeh;
import aei;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import arp;
import arq;
import arr;
import ars;

public class CommonActionBarView extends FrameLayout
{

    ImageView img_accept;
    public View layout_accept;
    FrameLayout layout_pre;
    public ars listener;
    public View next_btn;
    TextView textNext;
    TextView tx_tip;

    public CommonActionBarView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(aei.view_common_action_bar, this, true);
        tx_tip = (TextView)findViewById(aeh.tx_tip);
        img_accept = (ImageView)findViewById(aeh.img_accept);
        layout_accept = findViewById(aeh.layout_accept);
        layout_accept.setOnClickListener(new arp(this));
        layout_pre = (FrameLayout)findViewById(aeh.layout_pre);
        layout_pre.setOnClickListener(new arq(this));
        textNext = (TextView)findViewById(aeh.next_text);
        next_btn = findViewById(aeh.next_btn);
        next_btn.setOnClickListener(new arr(this));
    }

    public String getActionBarTitle()
    {
        return null;
    }

    public void setAcceptBarResId(int i)
    {
        img_accept.setImageResource(i);
    }

    public void setActionBarTitle(String s)
    {
        tx_tip.setText(s);
    }

    public void setIsNextButtonShow(boolean flag)
    {
        if (!flag)
        {
            layout_accept.setVisibility(4);
            next_btn.setVisibility(4);
            return;
        } else
        {
            layout_accept.setVisibility(0);
            next_btn.setVisibility(0);
            return;
        }
    }

    public void setNextButtonBackgroundResId(int i)
    {
        next_btn.setBackgroundResource(i);
    }

    public void setNextButtonMode(ENextBottonMode enextbottonmode)
    {
        if (enextbottonmode == ENextBottonMode.ICON)
        {
            layout_accept.setVisibility(0);
            next_btn.setVisibility(4);
        } else
        if (enextbottonmode == ENextBottonMode.BUTTON)
        {
            layout_accept.setVisibility(4);
            next_btn.setVisibility(0);
            return;
        }
    }

    public void setNextButtonText(String s)
    {
        textNext.setText(s);
    }

    public void setOnAcceptListener(ars ars)
    {
        listener = ars;
    }

    private class ENextBottonMode extends Enum
    {

        private static final ENextBottonMode $VALUES[];
        public static final ENextBottonMode BUTTON;
        public static final ENextBottonMode ICON;

        public static ENextBottonMode valueOf(String s)
        {
            return (ENextBottonMode)Enum.valueOf(com/fotoable/photoselector/activity/CommonActionBarView$ENextBottonMode, s);
        }

        public static ENextBottonMode[] values()
        {
            return (ENextBottonMode[])$VALUES.clone();
        }

        static 
        {
            ICON = new ENextBottonMode("ICON", 0);
            BUTTON = new ENextBottonMode("BUTTON", 1);
            $VALUES = (new ENextBottonMode[] {
                ICON, BUTTON
            });
        }

        private ENextBottonMode(String s, int i)
        {
            super(s, i);
        }
    }

}
