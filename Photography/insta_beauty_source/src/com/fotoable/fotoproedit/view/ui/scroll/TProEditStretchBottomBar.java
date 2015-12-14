// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import anb;
import anc;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import xn;

// Referenced classes of package com.fotoable.fotoproedit.view.ui.scroll:
//            ColorItemView

public class TProEditStretchBottomBar extends LinearLayout
{

    ColorItemView bottom_1;
    ColorItemView bottom_2;
    public ColorItemView curColorItemView;
    public xn listener;

    public TProEditStretchBottomBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030120, this, true);
        bottom_1 = (ColorItemView)findViewById(0x7f0d0104);
        bottom_1.setTextColor(-1);
        bottom_1.setIconRes(0x7f0202f3);
        bottom_1.setText(getContext().getResources().getString(0x7f0602e8));
        bottom_1.setTag("vertical");
        bottom_1.setSelected(true);
        curColorItemView = bottom_1;
        bottom_1.setOnClickListener(new anb(this));
        bottom_2 = (ColorItemView)findViewById(0x7f0d0291);
        bottom_2.setTextColor(-1);
        bottom_2.setIconRes(0x7f0202f2);
        bottom_2.setText(getContext().getResources().getString(0x7f0602e7));
        bottom_2.setTag("horizonal");
        bottom_2.setSelected(false);
        bottom_2.setOnClickListener(new anc(this));
    }

    public void setListner(xn xn)
    {
        listener = xn;
    }
}
