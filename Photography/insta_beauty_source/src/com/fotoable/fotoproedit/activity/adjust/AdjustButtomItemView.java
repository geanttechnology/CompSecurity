// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.adjust;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class AdjustButtomItemView extends FrameLayout
{

    private ImageView imageview;
    private TextView textview;

    public AdjustButtomItemView(Context context)
    {
        super(context);
        init();
    }

    public AdjustButtomItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300e8, this, true);
        imageview = (ImageView)findViewById(0x7f0d020e);
        textview = (TextView)findViewById(0x7f0d0213);
    }

    public void setData(int i, int j)
    {
        imageview.setImageResource(i);
        textview.setText(j);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            imageview.setColorFilter(getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.MULTIPLY);
            textview.setTextColor(getResources().getColor(0x7f0c009d));
            return;
        } else
        {
            imageview.clearColorFilter();
            textview.setTextColor(-1);
            return;
        }
    }
}
