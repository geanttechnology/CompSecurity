// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.crop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import ms;

public class TProEditRotateBottomBar extends LinearLayout
{

    View bottom_1;
    View bottom_2;
    View bottom_3;
    View bottom_4;
    ms listener;

    public TProEditRotateBottomBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300cd, this, true);
        bottom_1 = findViewById(0x7f0c0165);
        bottom_2 = findViewById(0x7f0c0168);
        bottom_3 = findViewById(0x7f0c016b);
        bottom_4 = findViewById(0x7f0c016e);
        bottom_1.setOnClickListener(new android.view.View.OnClickListener() {

            final TProEditRotateBottomBar a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.listener.a("left", view);
                }
            }

            
            {
                a = TProEditRotateBottomBar.this;
                super();
            }
        });
        bottom_2.setOnClickListener(new android.view.View.OnClickListener() {

            final TProEditRotateBottomBar a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.listener.a("right", view);
                }
            }

            
            {
                a = TProEditRotateBottomBar.this;
                super();
            }
        });
        bottom_3.setOnClickListener(new android.view.View.OnClickListener() {

            final TProEditRotateBottomBar a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.listener.a("flip-h", view);
                }
            }

            
            {
                a = TProEditRotateBottomBar.this;
                super();
            }
        });
        bottom_4.setOnClickListener(new android.view.View.OnClickListener() {

            final TProEditRotateBottomBar a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.listener.a("flip-v", view);
                }
            }

            
            {
                a = TProEditRotateBottomBar.this;
                super();
            }
        });
    }

    public void setListner(ms ms)
    {
        listener = ms;
    }
}
