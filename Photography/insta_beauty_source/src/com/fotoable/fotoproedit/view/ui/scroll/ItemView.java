// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

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
    FrameLayout itemicon;

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
        itemicon = (FrameLayout)findViewById(0x7f0d01cc);
    }

    public void setIconRes(int i)
    {
        icon.setBackgroundResource(i);
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
