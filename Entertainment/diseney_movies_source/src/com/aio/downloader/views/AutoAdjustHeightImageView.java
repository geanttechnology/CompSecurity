// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AutoAdjustHeightImageView extends ImageView
{

    private int imageHeight;
    private int imageWidth;

    public AutoAdjustHeightImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        getImageSize();
    }

    private void getImageSize()
    {
        Object obj = getBackground();
        if (obj == null)
        {
            return;
        } else
        {
            obj = ((BitmapDrawable)obj).getBitmap();
            imageWidth = ((Bitmap) (obj)).getWidth();
            imageHeight = ((Bitmap) (obj)).getHeight();
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        if (imageWidth != 0 && imageHeight != 0)
        {
            i = android.view.View.MeasureSpec.getSize(i);
            setMeasuredDimension(i, (imageHeight * i) / imageWidth);
        }
    }
}
