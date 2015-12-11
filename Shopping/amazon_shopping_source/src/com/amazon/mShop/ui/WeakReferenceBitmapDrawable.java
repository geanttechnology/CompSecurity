// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.net.LRUCache;
import java.lang.ref.WeakReference;

public class WeakReferenceBitmapDrawable extends Drawable
    implements com.amazon.mShop.net.HttpFetcher.Subscriber
{
    public static class WeakReferenceBitmapState extends android.graphics.drawable.Drawable.ConstantState
    {

        public int mChangingConfigurations;
        private WeakReference mDefaultImage;
        private Paint mPaint;
        private com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams mParams;
        private Resources mResource;
        public int mTargetDensity;

        public int getChangingConfigurations()
        {
            return mChangingConfigurations;
        }

        public Drawable newDrawable()
        {
            Bitmap bitmap = null;
            if (mParams != null)
            {
                bitmap = (Bitmap)LRUCache.getValue(mParams.getUrl(), android/graphics/Bitmap);
            }
            Bitmap bitmap1 = bitmap;
            if (bitmap == null)
            {
                bitmap1 = (Bitmap)mDefaultImage.get();
            }
            return new WeakReferenceBitmapDrawable(mResource, bitmap1, (Bitmap)mDefaultImage.get(), mParams);
        }



        public WeakReferenceBitmapState(WeakReferenceBitmapDrawable weakreferencebitmapdrawable, Bitmap bitmap, Bitmap bitmap1, Resources resources, com.amazon.mShop.net.HttpFetcher.Params params)
        {
            mPaint = new Paint();
            mDefaultImage = new WeakReference(bitmap1);
            mResource = resources;
            if (params == null)
            {
                mParams = null;
            } else
            if (params instanceof com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams)
            {
                bitmap = (com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams)params;
                if (bitmap.getBaseUrl() != null)
                {
                    mParams = new com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams(bitmap.getBaseUrl(), weakreferencebitmapdrawable, bitmap.getMaxDimension(), null, bitmap.useDiskCache(), bitmap.getResidencePriority());
                    return;
                }
                if (bitmap.getUrl() != null)
                {
                    mParams = new com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams(bitmap.getUrl(), weakreferencebitmapdrawable);
                    return;
                }
            }
        }
    }


    private BitmapFetcher mBitmapFetcher;
    private int mBitmapHeight;
    private WeakReferenceBitmapState mBitmapState;
    private int mBitmapWidth;
    private Bitmap mDefaultImage;
    private int mTargetDensity;

    public WeakReferenceBitmapDrawable(Resources resources, Bitmap bitmap, Bitmap bitmap1, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        mDefaultImage = bitmap1;
        mBitmapState = new WeakReferenceBitmapState(this, bitmap, bitmap1, resources, params);
        bitmap1 = mBitmapState;
        int i = resources.getDisplayMetrics().densityDpi;
        mTargetDensity = i;
        bitmap1.mTargetDensity = i;
        computeBitmapSize(bitmap);
    }

    private void computeBitmapSize(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            mBitmapWidth = bitmap.getScaledWidth(mTargetDensity);
            mBitmapHeight = bitmap.getScaledHeight(mTargetDensity);
            return;
        } else
        {
            mBitmapWidth = -1;
            mBitmapHeight = -1;
            return;
        }
    }

    public void draw(Canvas canvas)
    {
        Bitmap bitmap = getBitmap();
        if (bitmap != null)
        {
            canvas.drawBitmap(bitmap, null, new Rect(getBounds().centerX() - bitmap.getWidth() / 2, getBounds().centerY() - bitmap.getHeight() / 2, mBitmapWidth, mBitmapHeight), mBitmapState.mPaint);
        }
    }

    public Bitmap getBitmap()
    {
        Bitmap bitmap1 = null;
        Bitmap bitmap = bitmap1;
        if (mBitmapState != null)
        {
            bitmap = bitmap1;
            if (mBitmapState.mParams != null)
            {
                bitmap1 = (Bitmap)LRUCache.getValue(mBitmapState.mParams.getUrl(), android/graphics/Bitmap);
                bitmap = bitmap1;
                if (bitmap1 == null)
                {
                    bitmap = bitmap1;
                    if (mBitmapFetcher == null)
                    {
                        mBitmapFetcher = new BitmapFetcher(mBitmapState.mParams);
                        mBitmapFetcher.fetch();
                        bitmap = bitmap1;
                    }
                }
            }
        }
        bitmap1 = bitmap;
        if (bitmap == null)
        {
            bitmap1 = mDefaultImage;
        }
        return bitmap1;
    }

    public final android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        mBitmapState.mChangingConfigurations = getChangingConfigurations();
        return mBitmapState;
    }

    public int getIntrinsicHeight()
    {
        return mBitmapHeight;
    }

    public int getIntrinsicWidth()
    {
        return mBitmapWidth;
    }

    public int getOpacity()
    {
        Bitmap bitmap = getBitmap();
        return bitmap != null && !bitmap.hasAlpha() ? -1 : -3;
    }

    public void onHttpRequestFailed(com.amazon.mShop.net.HttpFetcher.Params params)
    {
        mBitmapFetcher = null;
    }

    public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        if (mBitmapFetcher != null && !mBitmapFetcher.isCancelled())
        {
            mBitmapFetcher = null;
            computeBitmapSize(bitmap);
            invalidateSelf();
        }
    }

    public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        onHttpResponseReceived((Bitmap)obj, params);
    }

    public void setAlpha(int i)
    {
        if (i != mBitmapState.mPaint.getAlpha())
        {
            mBitmapState.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mBitmapState.mPaint.setColorFilter(colorfilter);
        invalidateSelf();
    }

    public void setDither(boolean flag)
    {
        mBitmapState.mPaint.setDither(flag);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean flag)
    {
        mBitmapState.mPaint.setFilterBitmap(flag);
        invalidateSelf();
    }
}
