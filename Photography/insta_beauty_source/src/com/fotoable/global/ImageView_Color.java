// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.global;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ImageView_Color extends ImageView
{

    int mNormalColor;
    int mSelectedColor;

    public ImageView_Color(Context context)
    {
        super(context);
        mSelectedColor = 0xff007aff;
        mNormalColor = -1;
    }

    public ImageView_Color(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSelectedColor = 0xff007aff;
        mNormalColor = -1;
    }

    public ImageView_Color(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mSelectedColor = 0xff007aff;
        mNormalColor = -1;
    }

    public void setImageColor(int i, int j)
    {
        mNormalColor = i;
        mSelectedColor = j;
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            try
            {
                getBackground().mutate().setColorFilter(mSelectedColor, android.graphics.PorterDuff.Mode.SRC_IN);
                return;
            }
            catch (Exception exception)
            {
                return;
            }
        }
        getBackground().mutate().setColorFilter(mNormalColor, android.graphics.PorterDuff.Mode.SRC_IN);
        return;
    }
}
