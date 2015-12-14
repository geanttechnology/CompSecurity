// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import tr;

public class MNewCanSelButton extends ImageView
{

    private int selectedColor;
    private int unselectedColor;

    public MNewCanSelButton(Context context)
    {
        super(context);
        selectedColor = -1;
        unselectedColor = -1;
        init();
    }

    public MNewCanSelButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        selectedColor = -1;
        unselectedColor = -1;
        init();
    }

    public MNewCanSelButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        selectedColor = -1;
        unselectedColor = -1;
        init();
    }

    private void init()
    {
        setSelected(false);
        setOnTouchListener(new tr(this));
    }

    public void setBitmapRes(int i, int j, int k)
    {
        selectedColor = j;
        unselectedColor = k;
        setBackgroundResource(i);
        setSelected(false);
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        if (!flag)
        {
            getBackground().setColorFilter(selectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
            return;
        } else
        {
            getBackground().setColorFilter(unselectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
            return;
        }
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            getBackground().setColorFilter(selectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
            return;
        } else
        {
            getBackground().setColorFilter(unselectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
            return;
        }
    }

    public void setSelectedColor(int i, int j)
    {
        selectedColor = i;
        unselectedColor = j;
        setSelected(false);
    }


}
