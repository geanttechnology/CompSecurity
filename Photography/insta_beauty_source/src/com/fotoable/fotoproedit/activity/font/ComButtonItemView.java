// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ComButtonItemView extends FrameLayout
{

    private ImageView icon;

    public ComButtonItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300fe, this, true);
        icon = (ImageView)findViewById(0x7f0d01cd);
    }

    public void setImage(int i)
    {
        icon.setImageResource(i);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            icon.setColorFilter(getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.MULTIPLY);
            return;
        } else
        {
            icon.clearColorFilter();
            return;
        }
    }
}
