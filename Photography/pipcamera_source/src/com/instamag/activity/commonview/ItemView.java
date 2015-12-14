// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItemView extends LinearLayout
{

    ImageView icon;
    TextView item_text;

    public ItemView(Context context)
    {
        super(context);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03008f, this, true);
        icon = (ImageView)findViewById(0x7f0c010f);
        item_text = (TextView)findViewById(0x7f0c0110);
    }

    public ItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03008f, this, true);
        icon = (ImageView)findViewById(0x7f0c010f);
        item_text = (TextView)findViewById(0x7f0c0110);
    }

    public void setData(String s, int i)
    {
        item_text.setText(s);
        icon.setImageResource(i);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            item_text.setTextColor(getResources().getColor(0x7f0b0020));
            icon.setColorFilter(getResources().getColor(0x7f0b0020), android.graphics.PorterDuff.Mode.MULTIPLY);
            return;
        } else
        {
            icon.clearColorFilter();
            item_text.setTextColor(-1);
            return;
        }
    }

    public void setTextColor(int i)
    {
        item_text.setTextColor(i);
    }
}
