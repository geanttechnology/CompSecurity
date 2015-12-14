// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import nd;

public class CommonActionBarView extends FrameLayout
{

    ImageView img_accept;
    View layout_accept;
    FrameLayout layout_pre;
    nd listener;
    View next_btn;
    TextView textNext;
    TextView tx_tip;

    public CommonActionBarView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(com.fotoable.fotophotoselector.R.layout.view_common_action_bar, this, true);
        tx_tip = (TextView)findViewById(com.fotoable.fotophotoselector.R.id.tx_tip);
        img_accept = (ImageView)findViewById(com.fotoable.fotophotoselector.R.id.img_accept);
        layout_accept = findViewById(com.fotoable.fotophotoselector.R.id.layout_accept);
        layout_accept.setOnClickListener(new android.view.View.OnClickListener() {

            final CommonActionBarView a;

            public void onClick(View view)
            {
                a.layout_accept.setEnabled(false);
                if (a.listener != null)
                {
                    a.listener.a();
                }
                a.layout_accept.setEnabled(true);
            }

            
            {
                a = CommonActionBarView.this;
                super();
            }
        });
        layout_pre = (FrameLayout)findViewById(com.fotoable.fotophotoselector.R.id.layout_pre);
        layout_pre.setOnClickListener(new android.view.View.OnClickListener() {

            final CommonActionBarView a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.listener.b();
                }
            }

            
            {
                a = CommonActionBarView.this;
                super();
            }
        });
        textNext = (TextView)findViewById(com.fotoable.fotophotoselector.R.id.next_text);
        next_btn = findViewById(com.fotoable.fotophotoselector.R.id.next_btn);
        next_btn.setOnClickListener(new android.view.View.OnClickListener() {

            final CommonActionBarView a;

            public void onClick(View view)
            {
                a.next_btn.setEnabled(false);
                if (a.listener != null)
                {
                    a.listener.a();
                }
                a.next_btn.setEnabled(true);
            }

            
            {
                a = CommonActionBarView.this;
                super();
            }
        });
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

    public void setOnAcceptListener(nd nd)
    {
        listener = nd;
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
