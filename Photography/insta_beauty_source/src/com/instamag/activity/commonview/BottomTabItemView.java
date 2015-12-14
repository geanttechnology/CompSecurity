// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Locale;

public class BottomTabItemView extends LinearLayout
{

    ImageView icon;
    private int imgResId;
    private int imgSelectedResId;
    TextView item_text;
    private int textColor;
    private int textSelectedColor;

    public BottomTabItemView(Context context)
    {
        super(context);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03004c, this, true);
        icon = (ImageView)findViewById(0x7f0d01cd);
        item_text = (TextView)findViewById(0x7f0d01ce);
        if (!getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
        {
            item_text.setTextSize(10F);
        }
    }

    public BottomTabItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03004c, this, true);
        icon = (ImageView)findViewById(0x7f0d01cd);
        item_text = (TextView)findViewById(0x7f0d01ce);
        if (!getResources().getConfiguration().locale.getLanguage().endsWith("zh"))
        {
            item_text.setTextSize(10F);
        }
    }

    public void setResId(int i)
    {
        imgResId = i;
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            icon.setBackgroundResource(imgSelectedResId);
            item_text.setTextColor(textSelectedColor);
            return;
        } else
        {
            icon.setBackgroundResource(imgResId);
            item_text.setTextColor(textColor);
            return;
        }
    }

    public void setSelectedResId(int i)
    {
        imgSelectedResId = i;
    }

    public void setText(String s)
    {
        item_text.setText(s);
    }

    public void setTextColor(int i)
    {
        textColor = i;
    }

    public void setTextSelectedColor(int i)
    {
        textSelectedColor = i;
    }
}
