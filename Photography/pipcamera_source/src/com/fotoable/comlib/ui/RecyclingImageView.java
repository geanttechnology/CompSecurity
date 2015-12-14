// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import fv;
import fw;

public class RecyclingImageView extends ImageView
{

    public RecyclingImageView(Context context)
    {
        super(context);
    }

    public RecyclingImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public RecyclingImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private static void notifyDrawable(Drawable drawable, boolean flag)
    {
        if (!(drawable instanceof fw)) goto _L2; else goto _L1
_L1:
        ((fw)drawable).a(flag);
_L4:
        return;
_L2:
        if (drawable instanceof fv)
        {
            ((fv)drawable).a(flag);
            return;
        }
        if (drawable instanceof LayerDrawable)
        {
            drawable = (LayerDrawable)drawable;
            int i = 0;
            int j = drawable.getNumberOfLayers();
            while (i < j) 
            {
                notifyDrawable(drawable.getDrawable(i), flag);
                i++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onDetachedFromWindow()
    {
        setImageDrawable(null);
        super.onDetachedFromWindow();
    }

    public void setImageDrawable(Drawable drawable)
    {
        Drawable drawable1 = getDrawable();
        super.setImageDrawable(drawable);
        notifyDrawable(drawable, true);
        notifyDrawable(drawable1, false);
    }
}
