// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MNewTextItemView extends FrameLayout
{

    int selectedColor;
    String text;
    TextView tx_tip;
    int unselectedColor;

    public MNewTextItemView(Context context)
    {
        super(context);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03010c, this, true);
        tx_tip = (TextView)findViewById(0x7f0d01ce);
    }

    public MNewTextItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03010c, this, true);
        tx_tip = (TextView)findViewById(0x7f0d01ce);
    }

    public void setResourceID(int i, int j, int k)
    {
        unselectedColor = k;
        selectedColor = j;
        tx_tip.setText(i);
        tx_tip.setTextColor(k);
        setSelected(false);
    }

    public void setResourceID(String s, int i, int j)
    {
        unselectedColor = j;
        selectedColor = i;
        tx_tip.setText(s);
        tx_tip.setTextColor(j);
        setSelected(false);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            tx_tip.setTextColor(selectedColor);
            return;
        } else
        {
            tx_tip.setTextColor(unselectedColor);
            return;
        }
    }
}
