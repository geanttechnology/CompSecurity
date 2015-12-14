// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ToggleButton;

public class Compose2TipView extends FrameLayout
{

    View img_close;
    View layout_compose_module_cornor;
    View layout_mask;
    View module_cornor_bg;
    ToggleButton tgShade;

    public Compose2TipView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300b1, this, true);
        initView();
    }

    private void initView()
    {
        layout_mask = findViewById(0x7f0c02c1);
        layout_mask.setOnClickListener(new android.view.View.OnClickListener() {

            final Compose2TipView a;

            public void onClick(View view)
            {
                a.setVisibility(4);
            }

            
            {
                a = Compose2TipView.this;
                super();
            }
        });
        layout_compose_module_cornor = findViewById(0x7f0c02b3);
        layout_compose_module_cornor.setOnClickListener(new android.view.View.OnClickListener() {

            final Compose2TipView a;

            public void onClick(View view)
            {
                a.setVisibility(4);
            }

            
            {
                a = Compose2TipView.this;
                super();
            }
        });
        img_close = findViewById(0x7f0c02c3);
        img_close.setOnClickListener(new android.view.View.OnClickListener() {

            final Compose2TipView a;

            public void onClick(View view)
            {
                a.setVisibility(4);
            }

            
            {
                a = Compose2TipView.this;
                super();
            }
        });
        module_cornor_bg = findViewById(0x7f0c02c2);
        module_cornor_bg.setOnClickListener(new android.view.View.OnClickListener() {

            final Compose2TipView a;

            public void onClick(View view)
            {
            }

            
            {
                a = Compose2TipView.this;
                super();
            }
        });
    }
}
