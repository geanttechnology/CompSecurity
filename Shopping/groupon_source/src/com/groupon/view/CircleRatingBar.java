// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.ButterKnife;

public class CircleRatingBar extends LinearLayout
{

    ImageView circle_five;
    ImageView circle_four;
    ImageView circle_one;
    ImageView circle_three;
    ImageView circle_two;

    public CircleRatingBar(Context context)
    {
        this(context, null);
    }

    public CircleRatingBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflateView();
        ButterKnife.bind(this);
    }

    protected void inflateView()
    {
        inflate(getContext(), 0x7f030061, this);
    }

    protected void setCircle(ImageView imageview, double d)
    {
        int i;
        if (d >= 1.0D)
        {
            i = 0x7f0202c6;
        } else
        if (d >= 0.5D)
        {
            i = 0x7f0202c4;
        } else
        {
            i = 0x7f0202c5;
        }
        imageview.setImageResource(i);
    }

    public void setRating(double d)
    {
        setCircle(circle_one, d);
        setCircle(circle_two, d - 1.0D);
        setCircle(circle_three, d - 2D);
        setCircle(circle_four, d - 3D);
        setCircle(circle_five, d - 4D);
    }
}
