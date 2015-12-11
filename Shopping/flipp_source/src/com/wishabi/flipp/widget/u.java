// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public final class u extends FrameLayout
{

    private final TextView a;
    private final TextView b;

    public u(Context context)
    {
        this(context, (byte)0);
    }

    private u(Context context, byte byte0)
    {
        this(context, '\0');
    }

    private u(Context context, char c)
    {
        super(context, null, 0);
        View.inflate(context, 0x7f030019, this);
        setBackgroundColor(context.getResources().getColor(0x7f090066));
        a = (TextView)findViewById(0x7f0b005c);
        b = (TextView)findViewById(0x7f0b005d);
        b.setSingleLine();
    }

    public final void setCount(int i)
    {
        a.setText(Integer.toString(i));
        TextView textview = b;
        if (i > 1)
        {
            i = 0x7f0e006a;
        } else
        {
            i = 0x7f0e0069;
        }
        textview.setText(i);
    }
}
