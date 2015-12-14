// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import amx;
import amy;
import amz;
import ana;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import xn;

public class TProEditRotateBottomBar extends LinearLayout
{

    View bottom_1;
    View bottom_2;
    View bottom_3;
    View bottom_4;
    public xn listener;

    public TProEditRotateBottomBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03011e, this, true);
        bottom_1 = findViewById(0x7f0d0104);
        bottom_2 = findViewById(0x7f0d0291);
        bottom_3 = findViewById(0x7f0d0294);
        bottom_4 = findViewById(0x7f0d0297);
        bottom_1.setOnClickListener(new amx(this));
        bottom_2.setOnClickListener(new amy(this));
        bottom_3.setOnClickListener(new amz(this));
        bottom_4.setOnClickListener(new ana(this));
    }

    public void setListner(xn xn)
    {
        listener = xn;
    }
}
