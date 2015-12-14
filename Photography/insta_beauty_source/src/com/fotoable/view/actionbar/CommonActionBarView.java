// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.view.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ayf;
import ayg;
import ayh;
import ayi;

public class CommonActionBarView extends FrameLayout
{

    ImageView img_accept;
    public View layout_accept;
    View layout_pre;
    public ayi listener;
    public Button next_btn;
    TextView tx_tip;

    public CommonActionBarView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300f9, this, true);
        tx_tip = (TextView)findViewById(0x7f0d022e);
        img_accept = (ImageView)findViewById(0x7f0d03b0);
        layout_accept = findViewById(0x7f0d03af);
        layout_accept.setOnClickListener(new ayf(this));
        layout_pre = findViewById(0x7f0d018c);
        layout_pre.setOnClickListener(new ayg(this));
        next_btn = (Button)findViewById(0x7f0d010b);
        next_btn.setOnClickListener(new ayh(this));
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
        next_btn.setText(s);
    }

    public void setOnAcceptListener(ayi ayi)
    {
        listener = ayi;
    }

    private class ENextBottonMode extends Enum
    {

        private static final ENextBottonMode $VALUES[];
        public static final ENextBottonMode BUTTON;
        public static final ENextBottonMode ICON;

        public static ENextBottonMode valueOf(String s)
        {
            return (ENextBottonMode)Enum.valueOf(com/fotoable/view/actionbar/CommonActionBarView$ENextBottonMode, s);
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
