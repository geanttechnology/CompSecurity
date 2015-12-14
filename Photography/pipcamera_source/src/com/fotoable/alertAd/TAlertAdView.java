// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.alertAd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fotoable.onLineImage.ImageViewOnline;
import eh;
import ei;
import java.io.PrintStream;
import pb;

public class TAlertAdView extends FrameLayout
{

    TextView bt_cancel;
    Button bt_ok;
    ImageViewOnline img_desc;
    ImageViewOnline img_icon;
    RelativeLayout layout_ad;
    RelativeLayout layout_container;
    RelativeLayout layout_top;
    RelativeLayout layout_top_left;
    ei onClickEvent;
    TextView tx_desc;
    TextView tx_title;

    public TAlertAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03009d, this, true);
        setBackgroundColor(0x106000d);
        layout_container = (RelativeLayout)findViewById(0x7f0c0056);
        img_desc = (ImageViewOnline)findViewById(0x7f0c026e);
        int i = pb.a(getContext());
        pb.b(getContext());
        ((android.widget.RelativeLayout.LayoutParams)layout_container.getLayoutParams()).height = pb.a(getContext(), i / 2);
        tx_title = (TextView)findViewById(0x7f0c0273);
        tx_desc = (TextView)findViewById(0x7f0c0275);
        layout_top_left = (RelativeLayout)findViewById(0x7f0c026f);
        img_icon = (ImageViewOnline)findViewById(0x7f0c0270);
        layout_top = (RelativeLayout)findViewById(0x7f0c0047);
        layout_ad = (RelativeLayout)findViewById(0x7f0c026b);
        bt_ok = (Button)findViewById(0x7f0c026d);
        bt_cancel = (TextView)findViewById(0x7f0c026c);
        if (!pb.a())
        {
            bt_ok.setText("Free Download");
            bt_cancel.setText("Give up");
        }
        requestLayout();
    }

    public void initWithTAdItem(eh eh1)
    {
        if (eh1.j() == null)
        {
            ((android.widget.RelativeLayout.LayoutParams)layout_top_left.getLayoutParams()).width = 0;
            layout_top_left.setVisibility(4);
            img_icon.setVisibility(4);
        } else
        {
            img_icon.setImageBitmapFromUrl(eh1.j());
        }
        if (eh1.k() == null)
        {
            ((android.widget.RelativeLayout.LayoutParams)layout_container.getLayoutParams()).height = 0;
            layout_container.setVisibility(4);
            img_desc.setVisibility(4);
        } else
        {
            img_desc.setImageBitmapFromUrl(eh1.k());
        }
        if (eh1.f() != null)
        {
            tx_title.setText(eh1.f());
        }
        if (eh1.g() != null)
        {
            tx_desc.setText(eh1.g());
        }
        if (eh1.h() != null)
        {
            bt_ok.setText(eh1.h());
        }
        if (eh1.i() != null)
        {
            bt_cancel.setText(eh1.i());
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        i = layout_container.getHeight();
        j = layout_top.getHeight();
        i = pb.d(getContext(), i) + 60 + pb.d(getContext(), j) + 25;
        ((android.widget.RelativeLayout.LayoutParams)layout_ad.getLayoutParams()).height = pb.a(getContext(), i);
        System.out.println(i);
    }

    public void setOnClickListener(ei ei)
    {
        onClickEvent = ei;
        bt_cancel.setOnClickListener(new android.view.View.OnClickListener() {

            final TAlertAdView a;

            public void onClick(View view)
            {
                a.onClickEvent.b();
            }

            
            {
                a = TAlertAdView.this;
                super();
            }
        });
        bt_ok.setOnClickListener(new android.view.View.OnClickListener() {

            final TAlertAdView a;

            public void onClick(View view)
            {
                a.onClickEvent.a();
            }

            
            {
                a = TAlertAdView.this;
                super();
            }
        });
    }
}
