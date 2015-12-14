// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import ama;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class BubbleItemView extends LinearLayout
{

    ama font;
    ImageView icon;
    View im_container;
    Boolean selected;

    public BubbleItemView(Context context)
    {
        super(context);
    }

    public BubbleItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030125, this, true);
        icon = (ImageView)findViewById(0x7f0d01cd);
        im_container = findViewById(0x7f0d015c);
        selected = Boolean.valueOf(false);
    }

    public ama getFont()
    {
        return font;
    }

    public void setFont(ama ama)
    {
        font = ama;
    }

    public void setIconRes(int i)
    {
        icon.setBackgroundResource(i);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        selected = Boolean.valueOf(flag);
        if (flag)
        {
            im_container.setBackgroundColor(0xff007aff);
            return;
        } else
        {
            im_container.setBackgroundColor(0xff000000);
            return;
        }
    }
}
