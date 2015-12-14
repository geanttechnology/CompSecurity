// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ImageDetailView extends FrameLayout
{

    int bmpH;
    int bmpW;
    FrameLayout detailContainer;
    ImageView detailImageView;
    ImageView mTargetarea;

    public ImageDetailView(Context context)
    {
        super(context);
        init();
    }

    public ImageDetailView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03010e, this, true);
        detailContainer = (FrameLayout)findViewById(0x7f0d03e6);
        detailImageView = (ImageView)findViewById(0x7f0d03e7);
        mTargetarea = (ImageView)findViewById(0x7f0d020f);
    }

    public void setImage(Bitmap bitmap)
    {
        detailImageView.setImageBitmap(bitmap);
        bmpW = bitmap.getWidth();
        bmpH = bitmap.getHeight();
    }

    public void setTragetArea(int i)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)mTargetarea.getLayoutParams();
        layoutparams.width = i;
        layoutparams.height = i;
        mTargetarea.setLayoutParams(layoutparams);
    }

    public void updateDetailViewPos(float f, int i, int j)
    {
        i = (int)((float)(i * 2) * f);
        j = (int)((float)(j * 2) * f);
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)detailImageView.getLayoutParams();
        layoutparams.leftMargin = -(i - detailContainer.getWidth() / 2);
        layoutparams.topMargin = -(j - detailContainer.getHeight() / 2);
        layoutparams.width = (int)((float)bmpW * f * 2.0F);
        layoutparams.height = (int)((float)bmpH * f * 2.0F);
        detailImageView.setLayoutParams(layoutparams);
    }
}
