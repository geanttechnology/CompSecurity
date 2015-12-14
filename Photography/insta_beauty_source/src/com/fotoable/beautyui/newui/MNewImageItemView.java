// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MNewImageItemView extends FrameLayout
{

    int iconId;
    ImageView imgview;
    int selectedColor;
    int unselectedColor;

    public MNewImageItemView(Context context)
    {
        super(context);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03010a, this, true);
        imgview = (ImageView)findViewById(0x7f0d01cd);
    }

    public MNewImageItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03010a, this, true);
        imgview = (ImageView)findViewById(0x7f0d01cd);
    }

    public void setResourceID(int i, int j, int k)
    {
        unselectedColor = k;
        selectedColor = j;
        imgview.setImageResource(i);
        setSelected(false);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            if (imgview != null && imgview.getDrawable() != null)
            {
                imgview.setColorFilter(selectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
            }
        } else
        if (imgview != null && imgview.getDrawable() != null)
        {
            imgview.setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
            imgview.getDrawable().setColorFilter(unselectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
            return;
        }
    }
}
