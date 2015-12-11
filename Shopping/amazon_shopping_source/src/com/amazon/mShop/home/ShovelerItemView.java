// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.mShop.ui.WeakReferenceBitmapDrawable;
import com.amazon.mShop.util.ImageUtil;
import com.amazon.mShop.util.Util;
import java.io.ByteArrayOutputStream;

public class ShovelerItemView extends LinearLayout
    implements com.amazon.mShop.net.HttpFetcher.Subscriber
{

    private BitmapFetcher mBitmapFetcher;
    private Drawable mDrawable;
    private String mImageUrl;
    private ImageView mThumbnail;

    public ShovelerItemView(Context context, AttributeSet attributeset)
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
            mBitmapFetcher = new BitmapFetcher(s, Integer.valueOf(getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.home_view_shoveler_view_thumbnail_max_dimension)), this);
            mBitmapFetcher.fetch();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public byte[] getEncodedImage()
    {
        if (mDrawable != null)
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            Bitmap bitmap = ((WeakReferenceBitmapDrawable)mDrawable).getBitmap();
            if (bitmap != null && bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream))
            {
                return bytearrayoutputstream.toByteArray();
            }
        }
        return null;
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mBitmapFetcher != null && !mBitmapFetcher.isCancelled())
        {
            cancelImageFetcher();
        }
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mThumbnail = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.home_shoveler_item_thumbnail);
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
                mThumbnail.setImageDrawable(mDrawable);
            }
            mBitmapFetcher = null;
        }
    }

    public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        onHttpResponseReceived((Bitmap)obj, params);
    }

    public void update(String s)
    {
label0:
        {
            mImageUrl = s;
            if (!Util.isEmpty(mImageUrl))
            {
                int i = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.home_view_shoveler_view_thumbnail_max_dimension);
                String s1 = ImageUtil.getImageUrl(mImageUrl, i);
                Bitmap bitmap = (Bitmap)LRUCache.getValue(s1, android/graphics/Bitmap);
                if (bitmap == null)
                {
                    break label0;
                }
                s = new com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams(s1, null);
                mDrawable = DrawableFactory.getInstance().createDrawable(getResources(), bitmap, s);
                mThumbnail.setImageDrawable(mDrawable);
            }
            return;
        }
        mThumbnail.setImageDrawable(DrawableFactory.getInstance().getDefaultDrawable(getResources()));
        setImageUrl(s);
    }
}
