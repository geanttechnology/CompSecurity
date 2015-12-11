// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.categoryBrowse;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.mShop.ui.WeakReferenceBitmapDrawable;
import com.amazon.mShop.util.Util;
import java.io.ByteArrayOutputStream;

public class CategoryBrowseTopProductItemView extends ImageView
    implements com.amazon.mShop.net.HttpFetcher.Subscriber
{

    private BitmapFetcher mBitmapFetcher;
    private Drawable mDrawable;
    private byte mEncodedImage[];
    private String mImageUrl;

    public CategoryBrowseTopProductItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private void cancelImageFetcher()
    {
        if (mBitmapFetcher != null)
        {
            mBitmapFetcher.cancel();
            mBitmapFetcher = null;
        }
    }

    private void setImageUrl(String s)
    {
        if (mBitmapFetcher == null || mBitmapFetcher.isCancelled()) goto _L2; else goto _L1
_L1:
        if (!mBitmapFetcher.getParams().getBaseUrl().equals(s)) goto _L4; else goto _L3
_L3:
        return;
_L4:
        cancelImageFetcher();
_L2:
        if (s != null)
        {
            mBitmapFetcher = new BitmapFetcher(s, Integer.valueOf(getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.category_browse_top_product_max_image_dimension)), this);
            mBitmapFetcher.fetch();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public byte[] getEncodedImage()
    {
        if (mDrawable != null && Util.isEmpty(mEncodedImage))
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            Bitmap bitmap = ((WeakReferenceBitmapDrawable)mDrawable).getBitmap();
            if (bitmap != null && bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream))
            {
                mEncodedImage = bytearrayoutputstream.toByteArray();
            }
        }
        return mEncodedImage;
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mBitmapFetcher != null && !mBitmapFetcher.isCancelled())
        {
            cancelImageFetcher();
        }
    }

    public void onHttpRequestFailed(com.amazon.mShop.net.HttpFetcher.Params params)
    {
        mBitmapFetcher = null;
    }

    public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        if (mBitmapFetcher != null && !mBitmapFetcher.isCancelled())
        {
            if (((com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams)params).getBaseUrl().equals(mImageUrl))
            {
                mDrawable = DrawableFactory.getInstance().createDrawable(getResources(), bitmap, params);
                setImageDrawable(mDrawable);
            }
            mBitmapFetcher = null;
        }
    }

    public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        onHttpResponseReceived((Bitmap)obj, params);
    }
}
