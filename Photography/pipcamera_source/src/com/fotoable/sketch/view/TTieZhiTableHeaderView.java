// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TTieZhiTableHeaderView extends LinearLayout
{

    ImageView img_section;
    TextView txt_title;

    public TTieZhiTableHeaderView(Context context)
    {
        super(context);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030095, this, true);
        txt_title = (TextView)findViewById(0x7f0c015b);
        img_section = (ImageView)findViewById(0x7f0c015a);
    }

    public void handleDataWithState(boolean flag)
    {
        if (flag)
        {
            img_section.setBackgroundResource(0x7f020192);
            return;
        } else
        {
            img_section.setBackgroundResource(0x7f020193);
            return;
        }
    }

    public void handleTitle(String s)
    {
        txt_title.setText(s);
    }
}
