// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
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
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300ce, this, true);
        icon = (ImageView)findViewById(0x7f0d01cd);
        item_text = (TextView)findViewById(0x7f0d01ce);
    }

    public ItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300ce, this, true);
        icon = (ImageView)findViewById(0x7f0d01cd);
        item_text = (TextView)findViewById(0x7f0d01ce);
    }
}
