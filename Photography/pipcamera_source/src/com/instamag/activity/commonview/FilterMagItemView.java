// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FilterMagItemView extends LinearLayout
{

    ImageView icon;
    private int imgResId;
    private int imgSelectedResId;

    public FilterMagItemView(Context context)
    {
        super(context);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03003e, this, true);
        icon = (ImageView)findViewById(0x7f0c010f);
    }

    public FilterMagItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03003e, this, true);
        icon = (ImageView)findViewById(0x7f0c010f);
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
            return;
        } else
        {
            icon.setBackgroundResource(imgResId);
            return;
        }
    }

    public void setSelectedResId(int i)
    {
        imgSelectedResId = i;
    }
}
