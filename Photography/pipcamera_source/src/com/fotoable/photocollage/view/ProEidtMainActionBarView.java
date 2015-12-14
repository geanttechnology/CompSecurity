// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import mb;

public class ProEidtMainActionBarView extends FrameLayout
{

    ImageView img_share;
    View layout_pre;
    View layout_share;
    mb listener;
    TextView tx_tip;

    public ProEidtMainActionBarView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300cb, this, true);
        tx_tip = (TextView)findViewById(0x7f0c0273);
        img_share = (ImageView)findViewById(0x7f0c0314);
        layout_share = findViewById(0x7f0c0315);
        layout_share.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEidtMainActionBarView a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.listener.a();
                }
            }

            
            {
                a = ProEidtMainActionBarView.this;
                super();
            }
        });
        layout_pre = findViewById(0x7f0c004a);
        layout_pre.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEidtMainActionBarView a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.listener.b();
                }
            }

            
            {
                a = ProEidtMainActionBarView.this;
                super();
            }
        });
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

    public void setActionBarTitle(String s)
    {
        tx_tip.setText(s);
    }

    public void setOnActionBarItemListener(mb mb)
    {
        listener = mb;
    }
}
