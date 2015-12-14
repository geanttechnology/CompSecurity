// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MNewItemView extends FrameLayout
{

    int iconId;
    ImageView imgview;
    int selectedColor;
    String text;
    TextView tx_tip;
    int unselectedColor;

    public MNewItemView(Context context)
    {
        super(context);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03010b, this, true);
        tx_tip = (TextView)findViewById(0x7f0d01ce);
        imgview = (ImageView)findViewById(0x7f0d01cd);
    }

    public MNewItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03010b, this, true);
        tx_tip = (TextView)findViewById(0x7f0d01ce);
        imgview = (ImageView)findViewById(0x7f0d01cd);
    }

    public void setResourceID(int i, int j, int k, int l)
    {
        unselectedColor = l;
        selectedColor = k;
        tx_tip.setText(i);
        imgview.setImageResource(j);
        tx_tip.setTextColor(l);
        setSelected(false);
    }

    public void setResourceID(String s, int i, int j, int k)
    {
        unselectedColor = k;
        selectedColor = j;
        tx_tip.setText(s);
        imgview.setImageResource(i);
        tx_tip.setTextColor(k);
        setSelected(false);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            if (imgview != null && imgview.getDrawable() != null)
            {
                imgview.setColorFilter(selectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
            }
            tx_tip.setTextColor(selectedColor);
            return;
        }
        if (imgview != null && imgview.getDrawable() != null)
        {
            imgview.setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
            imgview.getDrawable().setColorFilter(unselectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        tx_tip.setTextColor(unselectedColor);
    }
}
