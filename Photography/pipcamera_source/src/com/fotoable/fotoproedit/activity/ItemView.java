// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
    }

    public ItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300cc, this, true);
        icon = (ImageView)findViewById(0x7f0c010f);
        item_text = (TextView)findViewById(0x7f0c0110);
    }

    public void setIconColor(int i)
    {
        try
        {
            icon.getBackground().mutate().setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_IN);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void setIconRes(int i)
    {
        icon.setBackgroundResource(i);
    }

    public void setText(int i)
    {
        item_text.setText(i);
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
