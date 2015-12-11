// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import android.graphics.Bitmap;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.util.BadgeUtils;

// Referenced classes of package com.amazon.mShop.ui:
//            BadgeView

class this._cls0
    implements com.amazon.mShop.net.Subscriber
{

    final BadgeView this$0;

    public void onHttpRequestFailed(com.amazon.mShop.net.Params params)
    {
    }

    public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net.Params params)
    {
        if (BadgeView.access$000(BadgeView.this) != null && !BadgeView.access$000(BadgeView.this).isCancelled())
        {
            if (bitmap != null)
            {
                BadgeUtils.addBadgeBitampToCache(((com.amazon.mShop.net.r.BitmapFetcherParams)params).getBaseUrl(), bitmap);
                BadgeView.access$200(BadgeView.this, bitmap, BadgeView.access$100(BadgeView.this));
            }
            BadgeView.access$002(BadgeView.this, null);
        }
    }

    public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.Params params)
    {
        onHttpResponseReceived((Bitmap)obj, params);
    }

    .Params()
    {
        this$0 = BadgeView.this;
        super();
    }
}
