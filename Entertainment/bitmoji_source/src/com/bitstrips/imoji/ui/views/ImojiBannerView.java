// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImojiBannerView extends LinearLayout
{

    public ImojiBannerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03003c, this, true);
        context = context.obtainStyledAttributes(attributeset, com.bitstrips.imoji.R.styleable.imoji_banner, 0, 0);
        attributeset = context.getString(0);
        context.recycle();
        ((TextView)findViewById(0x7f0b00c8)).setText(attributeset);
    }

    public void setSpeechBubbleText(String s)
    {
        ((TextView)findViewById(0x7f0b00c8)).setText(s);
    }
}
