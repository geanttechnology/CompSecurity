// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui;

import amf;
import amg;
import amh;
import ami;
import amj;
import amk;
import aml;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fotoable.fotoproedit.view.ui.scroll.StyleItemView;

public class ProEditTextFontStyleView extends FrameLayout
{

    int bold;
    public StyleItemView bottom_1;
    public StyleItemView bottom_2;
    public StyleItemView bottom_3;
    public StyleItemView bottom_4;
    public StyleItemView bottom_5;
    public StyleItemView bottom_6;
    View frame_1;
    View frame_2;
    View frame_3;
    View frame_4;
    View frame_5;
    View frame_6;
    ImageView im_1;
    ImageView im_2;
    int italic;
    public aml listener;

    public ProEditTextFontStyleView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03012b, this, true);
        bold = 0;
        italic = 0;
        bottom_1 = (StyleItemView)findViewById(0x7f0d0453);
        bottom_1.setIconResouce(0x7f020308);
        bottom_1.setSelected(false);
        bottom_2 = (StyleItemView)findViewById(0x7f0d0454);
        bottom_2.setIconResouce(0x7f020311);
        bottom_2.setSelected(false);
        bottom_3 = (StyleItemView)findViewById(0x7f0d0455);
        bottom_3.setIconResouce(0x7f020317);
        bottom_3.setSelected(false);
        bottom_4 = (StyleItemView)findViewById(0x7f0d0456);
        bottom_4.setIconResouce(0x7f020314);
        bottom_4.setSelected(false);
        bottom_5 = (StyleItemView)findViewById(0x7f0d001a);
        bottom_5.setIconResouce(0x7f020315);
        bottom_5.setSelected(true);
        bottom_6 = (StyleItemView)findViewById(0x7f0d0457);
        bottom_6.setIconResouce(0x7f020316);
        bottom_6.setSelected(false);
        bottom_1.setOnClickListener(new amf(this));
        bottom_2.setOnClickListener(new amg(this));
        bottom_3.setOnClickListener(new amh(this));
        bottom_4.setOnClickListener(new ami(this));
        bottom_5.setOnClickListener(new amj(this));
        bottom_6.setOnClickListener(new amk(this));
    }

    public void setBoldAndItalic(boolean flag, boolean flag1)
    {
        bottom_1.setEnabled(flag);
        if (flag)
        {
            bottom_1.setIconResouce(0x7f020308);
        } else
        {
            bottom_1.setIconResouce(0x7f020309);
        }
        bottom_2.setEnabled(flag1);
        if (flag)
        {
            bottom_2.setIconResouce(0x7f020311);
            return;
        } else
        {
            bottom_2.setIconResouce(0x7f020312);
            return;
        }
    }

    public void setListner(aml aml)
    {
        listener = aml;
    }
}
