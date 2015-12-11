// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.view.ViewGroup;
import com.ebay.mobile.ads.GoogleTextAdLoader;
import com.google.android.gms.ads.AdListener;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewActivity

class  extends AdListener
{

    final ItemViewActivity this$0;
    final ViewGroup val$textAdContainer;
    final GoogleTextAdLoader val$textAdLoader;

    public void onAdFailedToLoad(int i)
    {
        super.onAdFailedToLoad(i);
        ItemViewActivity.access$800(ItemViewActivity.this, false);
    }

    public void onAdLoaded()
    {
        super.onAdLoaded();
        if (ItemViewActivity.access$900(ItemViewActivity.this) != null)
        {
            val$textAdContainer.removeView(ItemViewActivity.access$900(ItemViewActivity.this));
            ItemViewActivity.access$902(ItemViewActivity.this, null);
        }
        ItemViewActivity.access$902(ItemViewActivity.this, val$textAdLoader.textAdView);
        if (ItemViewActivity.access$900(ItemViewActivity.this) != null)
        {
            val$textAdContainer.addView(ItemViewActivity.access$900(ItemViewActivity.this));
            ItemViewActivity.access$800(ItemViewActivity.this, true);
        }
    }

    ()
    {
        this$0 = final_itemviewactivity;
        val$textAdContainer = viewgroup;
        val$textAdLoader = GoogleTextAdLoader.this;
        super();
    }
}
