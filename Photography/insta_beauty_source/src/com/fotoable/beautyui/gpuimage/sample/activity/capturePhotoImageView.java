// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import rh;

public class capturePhotoImageView extends ImageView
{

    private rh onMeasureListener;

    public capturePhotoImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public capturePhotoImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (onMeasureListener != null)
        {
            onMeasureListener.a(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setOnMeasureListener(rh rh1)
    {
        onMeasureListener = rh1;
    }
}
