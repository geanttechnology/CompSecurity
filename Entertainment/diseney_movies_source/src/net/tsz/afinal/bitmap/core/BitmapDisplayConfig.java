// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.core;

import android.graphics.Bitmap;
import android.view.animation.Animation;

public class BitmapDisplayConfig
{
    public class AnimationType
    {

        public static final int fadeIn = 1;
        public static final int userDefined = 0;
        final BitmapDisplayConfig this$0;

        public AnimationType()
        {
            this$0 = BitmapDisplayConfig.this;
            super();
        }
    }


    private Animation animation;
    private int animationType;
    private int bitmapHeight;
    private int bitmapWidth;
    private Bitmap loadfailBitmap;
    private Bitmap loadingBitmap;

    public BitmapDisplayConfig()
    {
    }

    public Animation getAnimation()
    {
        return animation;
    }

    public int getAnimationType()
    {
        return animationType;
    }

    public int getBitmapHeight()
    {
        return bitmapHeight;
    }

    public int getBitmapWidth()
    {
        return bitmapWidth;
    }

    public Bitmap getLoadfailBitmap()
    {
        return loadfailBitmap;
    }

    public Bitmap getLoadingBitmap()
    {
        return loadingBitmap;
    }

    public void setAnimation(Animation animation1)
    {
        animation = animation1;
    }

    public void setAnimationType(int i)
    {
        animationType = i;
    }

    public void setBitmapHeight(int i)
    {
        bitmapHeight = i;
    }

    public void setBitmapWidth(int i)
    {
        bitmapWidth = i;
    }

    public void setLoadfailBitmap(Bitmap bitmap)
    {
        loadfailBitmap = bitmap;
    }

    public void setLoadingBitmap(Bitmap bitmap)
    {
        loadingBitmap = bitmap;
    }
}
