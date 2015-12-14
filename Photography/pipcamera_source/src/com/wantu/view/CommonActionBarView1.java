// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import yp;

public class CommonActionBarView1 extends FrameLayout
{

    ImageView img_accept;
    View layout_accept;
    View layout_pre;
    yp listener;
    TextView nextText;
    View next_btn;
    TextView tx_tip;
    TextView txtSave;

    public CommonActionBarView1(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300a3, this, true);
        tx_tip = (TextView)findViewById(0x7f0c0284);
        txtSave = (TextView)findViewById(0x7f0c013f);
        layout_accept = findViewById(0x7f0c0285);
        layout_accept.setOnClickListener(new android.view.View.OnClickListener() {

            final CommonActionBarView1 a;

            public void onClick(View view)
            {
                a.layout_accept.setEnabled(false);
                if (a.listener != null)
                {
                    a.listener.b();
                }
                a.layout_accept.setEnabled(true);
            }

            
            {
                a = CommonActionBarView1.this;
                super();
            }
        });
        layout_pre = findViewById(0x7f0c004a);
        layout_pre.setOnClickListener(new android.view.View.OnClickListener() {

            final CommonActionBarView1 a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.listener.c();
                }
            }

            
            {
                a = CommonActionBarView1.this;
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
        nextText.setText(s);
    }

    public void setOnAcceptListener(yp yp)
    {
        listener = yp;
    }

    public void setSaveTitle(String s)
    {
        txtSave.setText(s);
    }

    private class ENextBottonMode extends Enum
    {

        private static final ENextBottonMode $VALUES[];
        public static final ENextBottonMode BUTTON;
        public static final ENextBottonMode ICON;

        public static ENextBottonMode valueOf(String s)
        {
            return (ENextBottonMode)Enum.valueOf(com/wantu/view/CommonActionBarView1$ENextBottonMode, s);
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
