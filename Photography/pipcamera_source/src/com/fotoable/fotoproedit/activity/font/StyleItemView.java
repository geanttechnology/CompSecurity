// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class StyleItemView extends LinearLayout
{

    View container;
    ImageView icon;
    View mask;

    public StyleItemView(Context context)
    {
        super(context);
    }

    public StyleItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300d4, this, true);
        icon = (ImageView)findViewById(0x7f0c0316);
        container = findViewById(0x7f0c0331);
        mask = findViewById(0x7f0c033f);
        mask.setVisibility(4);
    }

    public void setIconResouce(int i)
    {
        icon.setImageResource(i);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            container.setBackgroundColor(0xff007aff);
            return;
        } else
        {
            container.setBackgroundColor(0x106000e);
            return;
        }
    }
}
