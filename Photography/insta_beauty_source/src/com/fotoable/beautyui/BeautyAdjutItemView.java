// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ii;

public class BeautyAdjutItemView extends LinearLayout
{

    FrameLayout bgView;
    public ImageView imgview;
    LinearLayout itemContainer;
    public int selectedColor;
    public TextView tx_tip;
    public int unselectedColor;

    public BeautyAdjutItemView(Context context)
    {
        super(context);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300ee, this, true);
        tx_tip = (TextView)findViewById(0x7f0d01ce);
        imgview = (ImageView)findViewById(0x7f0d01cd);
        bgView = (FrameLayout)findViewById(0x7f0d0396);
        itemContainer = (LinearLayout)findViewById(0x7f0d0395);
        setOnTouchListener(new ii(this));
    }

    public BeautyAdjutItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300ee, this, true);
        tx_tip = (TextView)findViewById(0x7f0d01ce);
        imgview = (ImageView)findViewById(0x7f0d01cd);
        bgView = (FrameLayout)findViewById(0x7f0d0396);
        itemContainer = (LinearLayout)findViewById(0x7f0d0395);
    }

    public int getItemWidth()
    {
        return bgView.getWidth();
    }

    public void setResourceID(int i, int j, int k, int l)
    {
        unselectedColor = l;
        imgview.setImageResource(j);
        selectedColor = k;
        tx_tip.setText(i);
        setSelected(false);
    }

    public void setResourceID(String s, int i, int j, int k)
    {
        unselectedColor = k;
        imgview.setImageResource(i);
        selectedColor = j;
        tx_tip.setText(s);
        setSelected(false);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            imgview.getDrawable().setColorFilter(selectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
            tx_tip.setTextColor(selectedColor);
            return;
        } else
        {
            imgview.getDrawable().setColorFilter(unselectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
            tx_tip.setTextColor(unselectedColor);
            return;
        }
    }

    public void setTxtSize(int i)
    {
        tx_tip.setTextSize(i);
    }
}
