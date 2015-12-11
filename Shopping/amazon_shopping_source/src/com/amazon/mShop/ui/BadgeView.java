// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.util.BadgeUtils;
import com.amazon.mShop.util.ImageUtil;
import com.amazon.mShop.util.UIUtils;
import com.amazon.rio.j2me.client.services.mShop.Badge;
import com.amazon.rio.j2me.client.services.mShop.RichMessage;
import com.amazon.rio.j2me.client.services.mShop.UniversalLink;
import java.util.ArrayList;
import java.util.List;

public class BadgeView extends TextView
{

    private AmazonActivity mActivity;
    private BitmapFetcher mBadgeFetcher;
    private com.amazon.mShop.net.HttpFetcher.Subscriber mBadgeSubscriber;

    public BadgeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mBadgeSubscriber = new com.amazon.mShop.net.HttpFetcher.Subscriber() {

            final BadgeView this$0;

            public void onHttpRequestFailed(com.amazon.mShop.net.HttpFetcher.Params params)
            {
            }

            public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net.HttpFetcher.Params params)
            {
                if (mBadgeFetcher != null && !mBadgeFetcher.isCancelled())
                {
                    if (bitmap != null)
                    {
                        BadgeUtils.addBadgeBitampToCache(((com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams)params).getBaseUrl(), bitmap);
                        updateBadgeItem(bitmap, mActivity);
                    }
                    mBadgeFetcher = null;
                }
            }

            public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.HttpFetcher.Params params)
            {
                onHttpResponseReceived((Bitmap)obj, params);
            }

            
            {
                this$0 = BadgeView.this;
                super();
            }
        };
        mActivity = (AmazonActivity)context;
    }

    private void cancelBadgeFetcher()
    {
        if (mBadgeFetcher != null)
        {
            mBadgeFetcher.cancel();
            mBadgeFetcher = null;
        }
    }

    private void getBadgeFromBackground(String s)
    {
        if (mBadgeFetcher == null || mBadgeFetcher.isCancelled()) goto _L2; else goto _L1
_L1:
        if (!mBadgeFetcher.getParams().getBaseUrl().equals(s)) goto _L4; else goto _L3
_L3:
        return;
_L4:
        cancelBadgeFetcher();
_L2:
        if (s != null)
        {
            int i = UIUtils.convertDipToPixel(2);
            mBadgeFetcher = new BitmapFetcher(ImageUtil.getImageUrlWithMaxHeight(s, (int)getTextSize() + i), s, mBadgeSubscriber);
            mBadgeFetcher.fetch();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private void updateBadgeItem(Bitmap bitmap, AmazonActivity amazonactivity)
    {
        if (bitmap != null)
        {
            setVisibility(0);
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            UIUtils.setImageSpan(amazonactivity, bitmap, spannablestringbuilder, 0);
            setText(spannablestringbuilder);
        }
    }

    private void updateBadgeItem(RichMessage richmessage, AmazonActivity amazonactivity)
    {
        setVisibility(0);
        ArrayList arraylist = new ArrayList();
        Integer integer = richmessage.getBackgroundColor();
        if (integer != null)
        {
            arraylist.add(integer);
        }
        UIUtils.setHyperTexts(this, amazonactivity, richmessage.getMessages(), arraylist);
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        cancelBadgeFetcher();
    }

    public void update(Badge badge)
    {
        if (!BadgeUtils.hasBadgeUrl(badge)) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = BadgeUtils.getCachedBadge(badge.getMeta().getImageLink().getUrl());
        if (bitmap == null) goto _L4; else goto _L3
_L3:
        updateBadgeItem(bitmap, mActivity);
_L6:
        return;
_L4:
        if (BadgeUtils.hasBadgeDefaultHyperText(badge))
        {
            updateBadgeItem(badge.getMeta(), mActivity);
        }
        getBadgeFromBackground(BadgeUtils.getBadgeImageUrl(badge));
        return;
_L2:
        if (BadgeUtils.hasBadgeDefaultHyperText(badge))
        {
            updateBadgeItem(badge.getMeta(), mActivity);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }



/*
    static BitmapFetcher access$002(BadgeView badgeview, BitmapFetcher bitmapfetcher)
    {
        badgeview.mBadgeFetcher = bitmapfetcher;
        return bitmapfetcher;
    }

*/


}
