// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.mShop.util.BitmapUtil;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;

public class AmazonImageView extends ImageView
    implements com.amazon.mShop.net.HttpFetcher.Subscriber
{

    private BitmapFetcher mBitmapFetcher;
    private int mImageDimen;
    private String mImageUrl;
    private String mUrl;

    public AmazonImageView(Context context)
    {
        super(context);
    }

    public AmazonImageView(Context context, AttributeSet attributeset)
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

    public void fetchImage(String s, int i)
    {
        fetchImage(s, i, true);
    }

    public void fetchImage(String s, int i, boolean flag)
    {
        mImageUrl = s;
        mImageDimen = i;
        if (flag)
        {
            BitmapUtil.setImageResource(this, com.amazon.mShop.android.lib.R.drawable.noimage);
        }
        if (mBitmapFetcher == null || mBitmapFetcher.isCancelled()) goto _L2; else goto _L1
_L1:
        if (!mBitmapFetcher.getParams().getBaseUrl().equals(s)) goto _L4; else goto _L3
_L3:
        return;
_L4:
        cancelImageFetcher();
_L2:
        if (!Util.isEmpty(s))
        {
            mBitmapFetcher = new BitmapFetcher(s, Integer.valueOf(mImageDimen), this);
            mBitmapFetcher.fetch();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public byte[] getImageByteArray()
    {
        Object obj = null;
        byte abyte0[] = obj;
        if (mUrl != null)
        {
            Bitmap bitmap = (Bitmap)LRUCache.getValue(mUrl, android/graphics/Bitmap);
            abyte0 = obj;
            if (bitmap != null)
            {
                abyte0 = UIUtils.convertBitmapToByteArray(bitmap);
            }
        }
        return abyte0;
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
            String s = ((com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams)params).getBaseUrl();
            mUrl = params.getUrl();
            if (s.equals(mImageUrl))
            {
                setImageDrawable(DrawableFactory.getInstance().createDrawable(getResources(), bitmap, params));
                setVisibility(0);
            }
            mBitmapFetcher = null;
        }
    }

    public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        onHttpResponseReceived((Bitmap)obj, params);
    }
}
