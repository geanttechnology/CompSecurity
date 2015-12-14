// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ma;

public class ProEidtActionBarView extends FrameLayout
{

    ImageView img_accept;
    View layout_accept;
    View layout_pre;
    ma listener;
    TextView tx_tip;

    public ProEidtActionBarView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300c9, this, true);
        tx_tip = (TextView)findViewById(0x7f0c0284);
        img_accept = (ImageView)findViewById(0x7f0c0314);
        layout_accept = findViewById(0x7f0c0285);
        layout_accept.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEidtActionBarView a;

            public void onClick(View view)
            {
                a.layout_accept.setEnabled(false);
                if (a.listener != null)
                {
                    a.listener.d();
                }
                a.layout_accept.setEnabled(true);
            }

            
            {
                a = ProEidtActionBarView.this;
                super();
            }
        });
        layout_pre = findViewById(0x7f0c004a);
        layout_pre.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEidtActionBarView a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.listener.e();
                }
            }

            
            {
                a = ProEidtActionBarView.this;
                super();
            }
        });
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

    public void setOnAcceptListener(ma ma)
    {
        listener = ma;
    }
}
