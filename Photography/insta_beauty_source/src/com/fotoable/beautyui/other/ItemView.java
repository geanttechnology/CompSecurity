// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.other;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItemView extends LinearLayout
{

    ImageView icon;
    TextView item_text;
    FrameLayout ly_item_view;

    public ItemView(Context context)
    {
        super(context);
    }

    public ItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03011c, this, true);
        icon = (ImageView)findViewById(0x7f0d01cd);
        item_text = (TextView)findViewById(0x7f0d01ce);
        ly_item_view = (FrameLayout)findViewById(0x7f0d01cc);
    }

    public float getItemWidth()
    {
        return (float)ly_item_view.getWidth();
    }

    public void setIconRes(int i)
    {
        icon.setImageResource(i);
    }

    public void setImageFilter(int i)
    {
        icon.setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_IN);
    }

    public void setItemWidth(int i)
    {
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)ly_item_view.getLayoutParams();
        layoutparams.width = i;
        ly_item_view.setLayoutParams(layoutparams);
    }

    public void setText(String s)
    {
        item_text.setText(s);
    }

    public void setTextColor(int i)
    {
        item_text.setTextColor(i);
    }
}
