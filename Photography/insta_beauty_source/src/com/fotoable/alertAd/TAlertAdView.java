// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.alertAd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import axw;
import com.fotoable.onLineImage.ImageViewOnline;
import hk;
import hl;
import hm;
import hn;
import java.io.PrintStream;

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
    public hn onClickEvent;
    TextView tx_desc;
    TextView tx_title;

    public TAlertAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300e9, this, true);
        setBackgroundColor(0x106000d);
        layout_container = (RelativeLayout)findViewById(0x7f0d0378);
        img_desc = (ImageViewOnline)findViewById(0x7f0d0379);
        int i = axw.a(getContext());
        axw.b(getContext());
        ((android.widget.RelativeLayout.LayoutParams)layout_container.getLayoutParams()).height = axw.a(getContext(), i / 2);
        tx_title = (TextView)findViewById(0x7f0d037e);
        tx_desc = (TextView)findViewById(0x7f0d0380);
        layout_top_left = (RelativeLayout)findViewById(0x7f0d037a);
        img_icon = (ImageViewOnline)findViewById(0x7f0d037b);
        layout_top = (RelativeLayout)findViewById(0x7f0d00ee);
        layout_ad = (RelativeLayout)findViewById(0x7f0d0375);
        bt_ok = (Button)findViewById(0x7f0d0377);
        bt_cancel = (TextView)findViewById(0x7f0d0376);
        if (!axw.a())
        {
            bt_ok.setText("Free Download");
            bt_cancel.setText("Give up");
        }
        requestLayout();
    }

    public void initWithTAdItem(hk hk1)
    {
        if (hk1.j() == null)
        {
            ((android.widget.RelativeLayout.LayoutParams)layout_top_left.getLayoutParams()).width = 0;
            layout_top_left.setVisibility(4);
            img_icon.setVisibility(4);
        } else
        {
            img_icon.setImageBitmapFromUrl(hk1.j());
        }
        if (hk1.k() == null)
        {
            ((android.widget.RelativeLayout.LayoutParams)layout_container.getLayoutParams()).height = 0;
            layout_container.setVisibility(4);
            img_desc.setVisibility(4);
        } else
        {
            img_desc.setImageBitmapFromUrl(hk1.k());
        }
        if (hk1.f() != null)
        {
            tx_title.setText(hk1.f());
        }
        if (hk1.g() != null)
        {
            tx_desc.setText(hk1.g());
        }
        if (hk1.h() != null)
        {
            bt_ok.setText(hk1.h());
        }
        if (hk1.i() != null)
        {
            bt_cancel.setText(hk1.i());
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        i = layout_container.getHeight();
        j = layout_top.getHeight();
        i = axw.d(getContext(), i) + 60 + axw.d(getContext(), j) + 25;
        ((android.widget.RelativeLayout.LayoutParams)layout_ad.getLayoutParams()).height = axw.a(getContext(), i);
        System.out.println(i);
    }

    public void setOnClickListener(hn hn)
    {
        onClickEvent = hn;
        bt_cancel.setOnClickListener(new hl(this));
        bt_ok.setOnClickListener(new hm(this));
    }
}
