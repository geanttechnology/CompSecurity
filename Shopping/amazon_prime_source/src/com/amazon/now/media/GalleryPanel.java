// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

// Referenced classes of package com.amazon.now.media:
//            Gallery

public class GalleryPanel extends LinearLayout
{

    private Context mContext;
    private int mHighlighted;
    private ImageView mImageIcons[];
    private int mThumbnailMargin;
    private int mThumbnailScroll;
    private int mThumbnailWidth;

    public GalleryPanel(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = context;
        mThumbnailMargin = getResources().getDimensionPixelSize(0x7f0b00fb);
        mThumbnailWidth = getResources().getDimensionPixelSize(0x7f0b00fc);
        mThumbnailScroll = mThumbnailWidth + mThumbnailMargin * 2;
    }

    public void attachTo(Gallery gallery)
    {
        gallery.setPanel(this);
    }

    public void populateDots(int i, android.view.View.OnClickListener onclicklistener)
    {
        removeAllViews();
        mImageIcons = new ImageView[i];
        for (int j = 0; j < i; j++)
        {
            mImageIcons[j] = new ImageView(mContext);
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(0, 0);
            layoutparams.width = mThumbnailWidth;
            layoutparams.height = -1;
            layoutparams.leftMargin = mThumbnailMargin;
            layoutparams.rightMargin = mThumbnailMargin;
            layoutparams.topMargin = mThumbnailMargin;
            layoutparams.bottomMargin = mThumbnailMargin;
            layoutparams.gravity = 17;
            mImageIcons[j].setLayoutParams(layoutparams);
            mImageIcons[j].setScaleType(android.widget.ImageView.ScaleType.CENTER);
            mImageIcons[j].setImageResource(0x7f020032);
            if (j != 0)
            {
                mImageIcons[j].setAlpha(0.5F);
            }
            mImageIcons[j].setClickable(true);
            mImageIcons[j].setTag(Integer.valueOf(j));
            mImageIcons[j].setOnClickListener(onclicklistener);
            addView(mImageIcons[j]);
        }

        mHighlighted = 0;
    }

    public void recycleBitmaps()
    {
        ImageView aimageview[] = mImageIcons;
        int j = aimageview.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = aimageview[i];
            if (obj == null)
            {
                continue;
            }
            obj = ((ImageView) (obj)).getDrawable();
            if (obj == null || !(obj instanceof BitmapDrawable))
            {
                continue;
            }
            obj = ((BitmapDrawable)obj).getBitmap();
            if (obj != null)
            {
                ((Bitmap) (obj)).recycle();
            }
        }

    }

    public void selectDot(int i, boolean flag)
    {
        if (i >= 0 && i != mHighlighted)
        {
            if (flag)
            {
                ((HorizontalScrollView)getParent()).smoothScrollTo(mThumbnailScroll * i, 0);
            }
            mImageIcons[i].setAlpha(1.0F);
            mImageIcons[mHighlighted].setAlpha(0.5F);
            mHighlighted = i;
        }
    }

    public void setThumbnail(Bitmap bitmap, int i)
    {
        mImageIcons[i].setImageBitmap(bitmap);
        mImageIcons[i].setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
    }
}
