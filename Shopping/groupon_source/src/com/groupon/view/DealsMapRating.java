// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DealsMapRating extends LinearLayout
{

    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;

    public DealsMapRating(Context context)
    {
        this(context, null);
    }

    public DealsMapRating(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(getContext(), 0x7f03017f, this);
        star1 = (ImageView)findViewById(0x7f10025e);
        star2 = (ImageView)findViewById(0x7f10025f);
        star3 = (ImageView)findViewById(0x7f100260);
        star4 = (ImageView)findViewById(0x7f100261);
        star5 = (ImageView)findViewById(0x7f100262);
    }

    public void setRating(double d)
    {
        setStar(star1, d);
        setStar(star2, d - 1.0D);
        setStar(star3, d - 2D);
        setStar(star4, d - 3D);
        setStar(star5, d - 4D);
    }

    protected void setStar(ImageView imageview, double d)
    {
        int i;
        if (d >= 1.0D)
        {
            i = 0x7f020205;
        } else
        if (d >= 0.5D)
        {
            i = 0x7f020203;
        } else
        {
            i = 0x7f020204;
        }
        imageview.setImageResource(i);
    }
}
