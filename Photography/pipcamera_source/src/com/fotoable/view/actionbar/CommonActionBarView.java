// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.view.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ph;

public class CommonActionBarView extends FrameLayout
{

    ImageView img_accept;
    View layout_accept;
    View layout_pre;
    ph listener;
    TextView nextText;
    View next_btn;
    TextView tx_tip;
    TextView txtSave;

    public CommonActionBarView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300a2, this, true);
        tx_tip = (TextView)findViewById(0x7f0c0284);
        txtSave = (TextView)findViewById(0x7f0c013f);
        layout_accept = findViewById(0x7f0c0285);
        layout_accept.setOnClickListener(new android.view.View.OnClickListener() {

            final CommonActionBarView a;

            public void onClick(View view)
            {
                a.layout_accept.setEnabled(false);
                if (a.listener != null)
                {
                    a.listener.f();
                }
                a.layout_accept.setEnabled(true);
            }

            
            {
                a = CommonActionBarView.this;
                super();
            }
        });
        layout_pre = findViewById(0x7f0c004a);
        layout_pre.setOnClickListener(new android.view.View.OnClickListener() {

            final CommonActionBarView a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.listener.g();
                }
            }

            
            {
                a = CommonActionBarView.this;
                super();
            }
        });
        nextText = (TextView)findViewById(0x7f0c0286);
        next_btn = findViewById(0x7f0c0080);
        next_btn.setOnClickListener(new android.view.View.OnClickListener() {

            final CommonActionBarView a;

            public void onClick(View view)
            {
                a.next_btn.setEnabled(false);
                if (a.listener != null)
                {
                    a.listener.f();
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

    public void setOnAcceptListener(ph ph)
    {
        listener = ph;
    }

    public void setSaveButtomShow(boolean flag)
    {
        if (flag)
        {
            layout_accept.setVisibility(0);
            next_btn.setVisibility(4);
            txtSave.setVisibility(0);
            return;
        } else
        {
            layout_accept.setVisibility(4);
            next_btn.setVisibility(4);
            txtSave.setVisibility(4);
            return;
        }
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
